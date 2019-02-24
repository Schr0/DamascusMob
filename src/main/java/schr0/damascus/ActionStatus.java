package schr0.damascus;

public enum ActionStatus
{

	IDLE(0),
	SWIM(1),
	ROAR(2),
	ATTACK(3),
	SLEEP(4),
	EAT(5),
	WONDER(6),
	WATCH_CLOSEST(7);

	private static final ActionStatus[] NUMBER_LOOKUP = new ActionStatus[values().length];
	private final int number;

	static
	{
		for (ActionStatus attacktype : values())
		{
			NUMBER_LOOKUP[attacktype.getNumber()] = attacktype;
		}
	}

	private ActionStatus(int number)
	{
		this.number = number;
	}

	public int getNumber()
	{
		return this.number;
	}

	public static ActionStatus byNumber(int number)
	{
		if ((number < 0) || NUMBER_LOOKUP.length <= number)
		{
			number = 0;
		}

		return NUMBER_LOOKUP[number];
	}

}
