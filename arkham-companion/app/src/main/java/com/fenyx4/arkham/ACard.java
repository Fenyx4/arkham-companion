/*
 * This file is part of Arkham Companion.
 *
 *  Arkham Companion is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Arkham Companion is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Arkham Companion.  If not, see <http://www.gnu.org/licenses/>.
 */
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
