package ah.drawer;

public class Encounter
{
	private long ID;
	private long locID;
	public Encounter(long encID, long locID) 
	{
		ID = encID;
		this.locID = locID;
	}

	public String getEncounterText() {
		return AHFlyweightFactory.INSTANCE.getEncounterText(ID);
	}

	public long getID() {
		return ID;
	}
	
	public long getLocID() {
		return locID;
	}

}
