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

public class OtherWorldCard extends ACard {

	private ArrayList<OtherWorldColor> colors;
	
	public OtherWorldCard(long ID) {
		super(ID);
	}
	
    @Override public String toString()
    {
    	return "CardID: " + getID();
    }

	public ArrayList<OtherWorldColor> getOtherWorldColors() {
		if(colors == null)
		{
			colors = AHFlyweightFactory.INSTANCE.getOtherWorldColorsForCard(getID());	
		}
		return colors;
	}
	
	public String getCardPath()
	{
		return AHFlyweightFactory.INSTANCE.getOtherWorldCardPathForColoredCard(getID());
	}

}
