package com.fenyx4.arkham;

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
	
	@Override 
	public boolean equals(Object aThat) {
	    //check for self-comparison
	    if ( this == aThat ) return true;

	    // instanceof checks for null already
	    if ( !(aThat instanceof ICard) ) return false;

	    ICard that = (ICard)aThat;

	   
	    return ID == that.getID();
	  }
	
	@Override public int hashCode() {
		int result = 17;
		result = 31 * result + (int) (ID ^ (ID >>> 32));
		
		return result;
	  }

}
