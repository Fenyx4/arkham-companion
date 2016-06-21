package ah.drawer;

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
		return new String[] { "_ID", "Name" };
	}

	@Override
	public int getCount() {
		return blah.size();
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
	
	public Location getLocation()
	{
		return blah.get(mPos);
	}

	@Override
	public String getString(int arg0) {
		if( arg0 == 1)
		{
			
			return blah.get(mPos).toString();
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
