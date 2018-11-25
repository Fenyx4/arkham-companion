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

public class Neighborhood {

    private long ID;
    private String neighborhoodName = "";
    private String cardPath = "";
    private String neighborhoodButtonPath = "";

    public Neighborhood(long ID, String neiName, String cardPath, String neighborhoodButtonPath) {
        this.ID = ID;
        neighborhoodName = neiName;
        this.cardPath = cardPath;
        this.neighborhoodButtonPath = neighborhoodButtonPath;
    }

    public long getID() {
        return ID;
    }

    /*
    public ArrayList<Location> getLocations() {
        return AHFlyweightFactory.INSTANCE.getLocations(ID);
    }
    */
    @Override public String toString()
    {
        return getNeighborhoodName();
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public String getCardPath() {
        return cardPath;
    }

    public String getNeighborhoodButtonPath() {
        return neighborhoodButtonPath;
    }

}

