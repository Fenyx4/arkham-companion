package ah.drawer;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AHFlyweightFactory {
	
	public final static AHFlyweightFactory INSTANCE = new AHFlyweightFactory();
	private HashMap<Long,Expansion> expansionMap;
	
	//Gamestate
	private HashMap<Long,Long> currentExpansions;
	
	private AHFlyweightFactory() 
	{
		currentExpansions = new HashMap<Long,Long>();
	}
	
	public ArrayList<Expansion> getExpansions(Context context)
	{
		if(expansionMap == null)
		{
			expansionMap = new HashMap<Long,Expansion>();
			DatabaseHelper dh = DatabaseHelper.getInstance(context);
			SQLiteDatabase db = dh.getReadableDatabase();
			
			String[] columns = new String[]{DatabaseHelper.expID,DatabaseHelper.expName};
			Cursor c = db.query(DatabaseHelper.expTable, columns, null, null, null, null, null);
			
			c.moveToFirst();
			long ID;
			while(!c.isAfterLast())
			{
				ID = c.getInt(0);
				expansionMap.put(ID, new Expansion(ID, c.getString(1)));
				
				c.moveToNext();
			}
			
			c.close();
			db.close();
		}
		
		return new ArrayList<Expansion>(expansionMap.values());
	}
	
	public void applyExpansion(long expID, boolean isChecked) 
	{
		if(expansionMap.containsKey(expID))
		{
			if(!currentExpansions.containsKey(expID) && isChecked)
			{
				currentExpansions.put(expID,expID);
			}
			else if (currentExpansions.containsKey(expID) && !isChecked)
			{
				currentExpansions.remove(expID);
			}
		}
	}
	
	public HashMap<Long,Long> getAppliedExpansions()
	{
		return currentExpansions;
	}
	
	public ArrayList<Location> getCurrentLocations()
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.locID,DatabaseHelper.locName};
		String select = DatabaseHelper.locNeiID+" in (SELECT " + DatabaseHelper.neiID + " FROM " + DatabaseHelper.neighborhoodTable + " WHERE " + DatabaseHelper.neiExpID + " in (?))";
		String expIDs = currentExpansions.keySet().toString();
		expIDs = expIDs.substring(1,expIDs.length()-1);
		Cursor c = db.query(DatabaseHelper.locTable, columns, select, new String[]{expIDs}, null, null, null);
		
		Log.i("List",expIDs);
		c.moveToFirst();
		long ID;
		while(!c.isAfterLast())
		{
			ID = c.getInt(0);
			locations.add(new Location(ID,c.getString(1)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return locations;
	
	}
	
	public ArrayList<Location> getCurrentLocations(long neiID)
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.locID,DatabaseHelper.locName};
		String select = DatabaseHelper.locNeiID+"=?";
		Cursor c = db.query(DatabaseHelper.locTable, columns, select, new String[]{Long.toString(neiID)}, null, null, null);
		
		c.moveToFirst();
		long ID;
		while(!c.isAfterLast())
		{
			ID = c.getInt(0);
			locations.add(new Location(ID,c.getString(1)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return locations;
	
	}

	public ArrayList<Encounter> getEncounters(long locID) 
	{

		ArrayList<Encounter> encounters = new ArrayList<Encounter>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.encID,DatabaseHelper.encLocID};
		String select = DatabaseHelper.encLocID+"=?";

		Cursor c = db.query(DatabaseHelper.encounterTable, columns, select, new String[]{Long.toString(locID)}, null, null, null);
		
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			encounters.add(new Encounter(c.getLong(0),c.getLong(1)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return encounters;
	}

	public String getEncounterText(long encID) {
		String encounterText = null;
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.encText};
		String select = DatabaseHelper.encID+"=?";

		Cursor c = db.query(DatabaseHelper.encounterTable, columns, select, new String[]{Long.toString(encID)}, null, null, null);
		
		c.moveToFirst();
		if(!c.isAfterLast())
		{
			encounterText = c.getString(0);
		}
		
		c.close();
		db.close();
		
		return encounterText;
	}

	/*
	public ArrayList<Location> getLocations(long neiID) 
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.locID,DatabaseHelper.locName};
		String select = DatabaseHelper.locNeiID+"=?";

		Cursor c = db.query(DatabaseHelper.locTable, columns, select, new String[]{Long.toString(neiID)}, null, null, null);
		
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			locations.add(new Location(c.getLong(0),c.getString(1)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return locations;
	}
	*/

	public ArrayList<Neighborhood> getCurrentNeighborhoods() {
		ArrayList<Neighborhood> neighborhoods = new ArrayList<Neighborhood>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.neiID,DatabaseHelper.neiName};
		String select = DatabaseHelper.neiExpID + " in (?)";
		String expIDs = currentExpansions.keySet().toString();
		expIDs = expIDs.substring(1,expIDs.length()-1);
		Cursor c = db.query(DatabaseHelper.neighborhoodTable, columns, select, new String[]{expIDs}, null, null, null);
		
		Log.i("List",expIDs);
		c.moveToFirst();
		long ID;
		while(!c.isAfterLast())
		{
			ID = c.getInt(0);
			neighborhoods.add(new Neighborhood(ID,c.getString(1)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return neighborhoods;
	}
	   
}
