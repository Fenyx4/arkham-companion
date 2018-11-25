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

public class NeighborhoodCard extends ACard {

    private long neiID;

    public NeighborhoodCard(long ID, long neiID) {
        super(ID);
        this.neiID = neiID;
    }

    @Override public String toString()
    {
        return "CardID: " + getID() + " NeiID: " + neiID;
    }

    public Neighborhood getNeighborhood() {
        return AHFlyweightFactory.INSTANCE.getNeighborhood(neiID);

    }

    public String getCardPath()
    {
        return getNeighborhood().getCardPath();
    }
}

