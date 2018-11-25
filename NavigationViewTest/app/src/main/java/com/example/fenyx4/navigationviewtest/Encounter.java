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

public class Encounter
{
    private long ID;
    private long locID;
    private ICard card;

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

    public ICard getCard() {
        if(card == null)
        {
            card = AHFlyweightFactory.INSTANCE.getCardByEncID(ID);
        }
        return card;
    }


}
