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

import android.database.AbstractCursor;

public class ExpansionCursor extends AbstractCursor {
	
	private ArrayList<Expansion> expansions;
	
	public ExpansionCursor(ArrayList<Expansion> exps)
	{
		expansions = exps;
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "_ID", "Name", "Checked" };
	}

	@Override
	public int getCount() {
		return expansions.size();
	}

	@Override
	public double getDouble(int arg0) {
		if(arg0 == 0)
			return mPos;
		return 0;
	}

	@Override
	public float getFloat(int arg0) {
		if(arg0 == 0)
			return mPos;
		return 0;
	}

	@Override
	public int getInt(int arg0) {
		if(arg0 == 0)
		{
			return mPos;
		}
		else if(arg0 == 2)
		{
			if(expansions.get(mPos).getApplied())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		return 0;
	}

	@Override
	public long getLong(int arg0) {
		if(arg0 == 0)
			return mPos;
		return 0;
	}

	@Override
	public short getShort(int arg0) {
		if(arg0 == 0)
			return (short)mPos;
		return 0;
	}
	
	public Expansion getExpansion()
	{
		return expansions.get(mPos);
	}

	@Override
	public String getString(int arg0) {
		if( arg0 == 1)
		{
			
			return expansions.get(mPos).toString();
		}
		else
		{
			return String.valueOf(mPos);
		}
		
	}

	@Override
	public boolean isNull(int arg0) {
		
		return expansions.get(arg0) == null;
	}

}
