package com.fenyx4.arkham;

import java.util.ArrayList;

import android.database.AbstractCursor;

public class LocationCursor extends AbstractCursor {
	
	private ArrayList<Location> blah;
	
	public LocationCursor(ArrayList<Location> locs)
	{
		blah = locs;
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "_ID", "Left", "Right" };
	}

	@Override
	public int getCount() {
		return (blah.size()+1)/2;
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
	
	public Location getLocation(int columnIdx)
	{
		Location ret;
		if(columnIdx == 1)
		{
			ret = blah.get(mPos*2);
		}
		else
		{
			if(mPos*2+1 < blah.size())
			{
				ret = blah.get(mPos*2+1);
			}
			else
			{
				ret = null;
			}
		}
		return ret;
	}

	@Override
	public String getString(int arg0) {
		if( arg0 == 1)
		{
			
			return blah.get(mPos*2).toString();
		}
		else if(arg0 == 2)
		{
			if(mPos*2+1 < blah.size())
			{
				return blah.get(mPos*2+1).toString();
			}
			else
			{
				return "";
			}
		}
		else
		{
			return String.valueOf(mPos);
		}
		
	}

	@Override
	public boolean isNull(int arg0) {
		
		return blah.get(arg0) == null;
	}

}
