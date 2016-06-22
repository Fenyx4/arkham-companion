package com.fenyx4.arkham;

public class EncounterHx extends Encounter {

	private long hxID;
	
	public EncounterHx(long encID, long locID, long encHxID) {
		super(encID, locID);
		hxID = encHxID;
	}

	public long getHxID() {
		return hxID;
	}
}
