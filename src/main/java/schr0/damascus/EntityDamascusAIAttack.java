package schr0.damascus;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;

public class EntityDamascusAIAttack extends EntityDamascusAI
{

	private static final int ATTACK_COOLDOWN = (3 * 20);
	private static final float RANGED_ATTACK_DISTANCE = (16.0F * 16.0F);
	private static final float MELEE_ATTACK_DISTANCE = (7.0F * 7.0F);
	private static final float CHANGE_ATTACK_DISTANCE = (8.0F * 8.0F);

	private EntityLivingBase attackTarget;
	private int attackTime;
	private int strafingTime;
	private boolean strafingClockwise;
	private boolean strafingBackwards;
	private float attackDistance;

	public EntityDamascusAIAttack(EntityDamascus entityDamascus)
	{
		super(entityDamascus);
	}

	@Override
	public boolean shouldExecute()
	{
		this.attackTarget = this.getAttackableTarget();

		if (this.attackTarget != null)
		{
			this.attackTime = this.ATTACK_COOLDOWN;
			this.strafingTime = -1;
			this.strafingClockwise = false;
			this.strafingBackwards = false;

			if (this.getTargetDistance(this.attackTarget) < (double) CHANGE_ATTACK_DISTANCE)
			{
				this.getAIOwner().setAttackType(AttackType.MELEE);

				this.attackDistance = MELEE_ATTACK_DISTANCE;
			}
			else
			{
				this.getAIOwner().setAttackType(AttackType.RANGED);

				this.attackDistance = RANGED_ATTACK_DISTANCE;
			}

			return true;
		}

		return false;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (this.isAttackableTarget(this.attackTarget))
		{
			return true;
		}

		return false;
	}

	@Override
	public void updateTask()
	{
		if (!this.isAttackableTarget(this.attackTarget))
		{
			return;
		}

		this.getAIOwner().setActionStatus(ActionStatus.ATTACK);

		this.getAIOwner().faceEntity(this.attackTarget, 30.0F, 30.0F);

		boolean canSeeTarget = this.getAIOwner().getEntitySenses().canSee(this.attackTarget);
		double distance = this.getTargetDistance(this.attackTarget);

		if (canSeeTarget && (distance < (double) this.attackDistance))
		{
			this.getAIOwner().getNavigator().clearPath();

			++this.strafingTime;
		}
		else
		{
			this.getAIOwner().getNavigator().tryMoveToEntityLiving(this.attackTarget, this.getMoveSpeed());

			this.strafingTime = -1;
		}

		if (20 < this.strafingTime)
		{
			if ((double) this.getRandom().nextFloat() < 0.3D)
			{
				this.strafingClockwise = !this.strafingClockwise;
			}

			if ((double) this.getRandom().nextFloat() < 0.3D)
			{
				this.strafingBackwards = !this.strafingBackwards;
			}

			this.strafingTime = 0;
		}

		if (-1 < this.strafingTime)
		{
			if ((double) (this.attackDistance * 0.75F) <= distance)
			{
				this.strafingBackwards = false;
			}
			else
			{
				if (distance < (double) (this.attackDistance * 0.25F))
				{
					this.strafingBackwards = true;
				}
			}

			this.getAIOwner().getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
		}

		if (canSeeTarget)
		{
			if (this.attackTime < 0)
			{
				if (this.getAIOwner().getAttackType() == AttackType.RANGED)
				{
					((IRangedAttackMob) this.getAIOwner()).attackEntityWithRangedAttack(this.attackTarget, 0);

					if (!this.getAIOwner().isFlying())
					{
						this.getAIOwner().jumpBackwardTargetEntity(this.attackTarget);
					}
				}
				else
				{
					if (distance < (double) this.attackDistance)
					{
						this.getAIOwner().setPositionAndUpdate(this.attackTarget.posX, this.attackTarget.posY, this.attackTarget.posZ);

						List<EntityLivingBase> list = this.getWorld().<EntityLivingBase> getEntitiesWithinAABB(EntityLivingBase.class, this.getAIOwner().getEntityBoundingBox().grow(0.5D));

						for (EntityLivingBase aroundEntityLivingBase : list)
						{
							if (canSeeTarget && !aroundEntityLivingBase.isEntityEqual(this.getAIOwner()))
							{
								this.getAIOwner().attackEntityAsMob(aroundEntityLivingBase);
							}
						}
					}
				}

				this.shouldExecute();

				return;
			}
			else
			{
				--this.attackTime;
			}
		}

		if (this.getAIOwner().getAttackType() == AttackType.RANGED)
		{
			DamascusMobParticles.spawnParticleRangedAttacking(this.getAIOwner());
		}
	}

	// TODO /* ======================================== MOD START =====================================*/

	private boolean isAttackableTarget(EntityLivingBase attackTarget)
	{
		if ((attackTarget != null) && attackTarget.isEntityAlive())
		{
			return true;
		}

		return false;
	}

	@Nullable
	private EntityLivingBase getAttackableTarget()
	{
		EntityLivingBase attackTarget = this.getAIOwner().getAttackTarget();

		if (this.isAttackableTarget(attackTarget))
		{
			return attackTarget;
		}

		return (EntityLivingBase) null;
	}

	private double getTargetDistance(EntityLivingBase target)
	{
		return this.getAIOwner().getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);
	}

}
