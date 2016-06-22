package com.fenyx4.arkham;

public class OtherWorldColor {

	private long colorID;
	private String colorName;
	private String buttonPath;
	private long expID;
	
	//DatabaseHelper.colorID,DatabaseHelper.colorName, DatabaseHelper.colorCardPath, DatabaseHelper.colorExpID};
	public OtherWorldColor(long colorID, String colorName, String buttonPath, long expID) {
		this.colorID = colorID;
		this.colorName = colorName;
		this.expID = expID;
		this.buttonPath = buttonPath;
	}

	public long getID() {
		return colorID;
	}

	public String getName() {
		return colorName;
	}

	public long getExpID() {
		return expID;
	}

	public String getButtonPath() {
		return buttonPath;
	}
	
    @Override public String toString()
    {
    	return getName();
    }

	@Override 
	public boolean equals(Object aThat) {
	    //check for self-comparison
	    if ( this == aThat ) return true;

	    // instanceof checks for null already
	    if ( !(aThat instanceof OtherWorldColor) ) return false;

	    OtherWorldColor that = (OtherWorldColor)aThat;

	   
	    return colorID == that.getID();
	  }
	
	@Override public int hashCode() {
		int result = 17;
		result = 31 * result + (int) (colorID ^ (colorID >>> 32));
		
		return result;
	  }
}
