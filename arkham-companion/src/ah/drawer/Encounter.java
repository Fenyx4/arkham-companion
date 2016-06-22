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
	
	public Location getLocation()
	{
		return AHFlyweightFactory.INSTANCE.getLocation(locID);
	}
	
	@Override 
	public boolean equals(Object aThat) {
	    //check for self-comparison
	    if ( this == aThat ) return true;

	    // instanceof checks for null already
	    if ( !(aThat instanceof Encounter) ) return false;

	    Encounter that = (Encounter)aThat;

	   
	    return ID == that.getID();
	  }
	
	@Override public int hashCode() {
		int result = 17;
		result = 31 * result + (int) (ID ^ (ID >>> 32));
		
		return result;
	  }
	

}
