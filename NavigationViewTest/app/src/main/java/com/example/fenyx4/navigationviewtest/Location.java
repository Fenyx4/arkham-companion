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
package com.example.fenyx4.navigationviewtest;

import java.util.ArrayList;

public class Location {

    private long ID;
    private String locationName = "";
    private ArrayList<OtherWorldColor> otherWorldColors;

    public Location(long ID, String locName) {
        this.ID = ID;
        locationName = locName;
        otherWorldColors = null;//new ArrayList<OtherWorldColor>();
    }

    public long getID() {
        return ID;
    }

    public ArrayList<Encounter> getEncounters() {
        return AHFlyweightFactory.INSTANCE.getEncounters(ID);
    }

    @Override public String toString()
    {
        return getLocationName();
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationButtonPath() {
        // TODO Auto-generated method stub
        return "";
    }

    public ArrayList<OtherWorldColor> getOtherWorldColors() {
        if(otherWorldColors == null)
        {
            otherWorldColors = AHFlyweightFactory.INSTANCE.getOtherWorldColors(ID);
        }
        return otherWorldColors;
    }

    public void setOtherWorldColors(ArrayList<OtherWorldColor> otherWorldColors) {
        this.otherWorldColors = otherWorldColors;
    }

    @Override
    public boolean equals(Object aThat) {
        //check for self-comparison
        if ( this == aThat ) return true;

        // instanceof checks for null already
        if ( !(aThat instanceof Location) ) return false;

        Location that = (Location)aThat;


        return ID == that.getID();
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + (int) (ID ^ (ID >>> 32));

        return result;
    }
}
