package ah.drawer;

import java.util.ArrayList;

public abstract class ACard implements ICard {
	
	private long ID;
	public ACard(long ID)
	{
		this.ID = ID;
	}
	
	public long getID()
	{
		return ID;
	}
	
	public ArrayList<Encounter> getEncounters() {
		return AHFlyweightFactory.INSTANCE.getEncountersForCard(ID);
	}
	
	@Override public String toString()
    {
    	return "CardID: " + ID; // + " NeiID: " + neiID;
    }
	
	ArrayList<Long> expIDs = null;
	public ArrayList<Long> getExpIDs() {
		if(expIDs == null)
		{
			expIDs = AHFlyweightFactory.INSTANCE.getExpansionsForCard(ID);
		}
		
		return expIDs;
	}

}
