package ah.drawer;

public class Expansion {

	private long ID;
	private String name;

	public Expansion(long ID, String name)
	{
		this.ID = ID;
		this.name = name;
	}

	public long getID() {
		return ID;
	}

	public String getName() {
		return name;
	}
	
    @Override public String toString()
    {
    	return getName();
    }

	public boolean getApplied() {
		
		return AHFlyweightFactory.INSTANCE.getAppliedExpansions().containsKey(ID);
	}
}
