package schr0.damascus;

public enum AttackType
{

	RANGED(0),
	MELEE(1);

	private static final AttackType[] NUMBER_LOOKUP = new AttackType[values().length];
	private final int number;

	static
	{
		for (AttackType attacktype : values())
		{
			NUMBER_LOOKUP[attacktype.getNumber()] = attacktype;
		}
	}

	private AttackType(int number)
	{
		this.number = number;
	}

	public int getNumber()
	{
		return this.number;
	}

	public static AttackType byNumber(int number)
	{
		if ((number < 0) || NUMBER_LOOKUP.length <= number)
		{
			number = 0;
		}

		return NUMBER_LOOKUP[number];
	}

}
