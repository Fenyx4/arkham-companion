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
	
	private Context context;
	
	private AHFlyweightFactory() 
	{
	}
	
	public ArrayList<Expansion> getExpansions()
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
	
	public ArrayList<Location> getCurrentLocations()
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.locID,DatabaseHelper.locName};
		String select = DatabaseHelper.locNeiID+" in (SELECT " + DatabaseHelper.neiID + " FROM " + DatabaseHelper.neighborhoodTable + " WHERE " + DatabaseHelper.neiExpID + " in (?))";
		String orderby = DatabaseHelper.locSort+" ASC, "+DatabaseHelper.locName+" ASC";
		String expIDs = GameState.INSTANCE.getAppliedExpansions().toString();
		expIDs = expIDs.substring(1,expIDs.length()-1);
		Cursor c = db.query(DatabaseHelper.locTable, columns, select, new String[]{expIDs}, null, null, orderby);
		
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
		String orderby = DatabaseHelper.locSort+" ASC, "+DatabaseHelper.locName+" ASC";
		Cursor c = db.query(DatabaseHelper.locTable, columns, select, new String[]{Long.toString(neiID)}, null, null, orderby);
		
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

	public ArrayList<Card> getCurrentCards(long neiID)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.cardID,DatabaseHelper.cardNeiID};
		//String select = DatabaseHelper.cardNeiID+" in (SELECT " + DatabaseHelper.neiID + " FROM " + DatabaseHelper.neighborhoodTable + " WHERE " + DatabaseHelper.neiExpID + " in (?))";
		
		String expIDs = GameState.INSTANCE.getAppliedExpansions().toString();
		expIDs = expIDs.substring(1,expIDs.length()-1);
		//SELECT DISTINCT cardID, NeiID
		//FROM cardTable
		//WHERE neiID= neiID
		//      AND cardID IN (SELECT cardID FROM cardToExpTable
		//                 WHERE expID IN (expIDs)
		//                 AND cardID NOT IN (SELECT cardID from cardToExpTable
		//                                    WHERE expID NOT IN (expIDs)))
		String select = DatabaseHelper.cardNeiID+"=? "+
		"AND "+DatabaseHelper.cardID+" in (SELECT "+DatabaseHelper.cardToExpCardID+" FROM "+DatabaseHelper.cardToExpTable+
		" WHERE "+DatabaseHelper.cardToExpExpID+ " in ("+expIDs+") "+
		"AND "+DatabaseHelper.cardToExpCardID+" NOT IN (SELECT "+DatabaseHelper.cardToExpCardID+" FROM "+DatabaseHelper.cardToExpTable+
		" WHERE "+DatabaseHelper.cardToExpExpID+ " NOT IN ("+expIDs+"))) ";
		//String select = DatabaseHelper.cardNeiID+"=? AND "+DatabaseHelper.cardExpID+" in ("+expIDs+")";

		Cursor c = db.query(DatabaseHelper.cardTable, columns, select, new String[]{Long.toString(neiID)}, null, null, null);
		
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			cards.add(new Card(c.getLong(0),c.getLong(1)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return cards;
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
		
		String[] columns = new String[]{DatabaseHelper.neiID,DatabaseHelper.neiName, DatabaseHelper.neiCardPath, DatabaseHelper.neiButtonPath};

		String expIDs = GameState.INSTANCE.getAppliedExpansions().toString();
		expIDs = expIDs.substring(1,expIDs.length()-1);
		
		//Always gonna have the base neighborhoods
		String select = DatabaseHelper.neiExpID + " in ("+expIDs+") OR "+DatabaseHelper.neiExpID +"=1";
		Cursor c = db.query(DatabaseHelper.neighborhoodTable, columns, select, null, null, null, null);
		
		Log.i("List",expIDs);
		c.moveToFirst();
		long ID;
		while(!c.isAfterLast())
		{
			ID = c.getInt(0);
			neighborhoods.add(new Neighborhood(ID,c.getString(1), c.getString(2), c.getString(3)));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return neighborhoods;
	}

	public Location getLocation(long locID) 
	{
		Location loc = null;
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.locID,DatabaseHelper.locName};
		String select = DatabaseHelper.locID+"=?";
		String orderby = DatabaseHelper.locSort+" ASC, "+DatabaseHelper.locName+" ASC";

		Cursor c = db.query(DatabaseHelper.locTable, columns, select, new String[]{Long.toString(locID)}, null, null, orderby);
		
		c.moveToFirst();
		if(!c.isAfterLast())
		{
			loc = new Location(c.getLong(0), c.getString(1));
		}
		
		c.close();
		db.close();
		
		return loc;
	}

	public ArrayList<Encounter> getEncountersForCard(long cardID) 
	{
		ArrayList<Encounter> encounters = new ArrayList<Encounter>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		//Need to order it by location
		String table = DatabaseHelper.encounterTable+" LEFT JOIN "+DatabaseHelper.locTable+
		" ON "+DatabaseHelper.encounterTable+"."+DatabaseHelper.encLocID+"="+DatabaseHelper.locTable+"."+DatabaseHelper.locID;
		String[] columns = new String[]{DatabaseHelper.encounterTable+"."+DatabaseHelper.encID,DatabaseHelper.encounterTable+"."+DatabaseHelper.encLocID};
		String select = DatabaseHelper.encounterTable+"."+DatabaseHelper.encID+" in (SELECT "+DatabaseHelper.cardToEncEncID+" FROM "+DatabaseHelper.cardToEncTable+ " WHERE "+DatabaseHelper.cardToEncCardID+"=?)";
		String orderby = DatabaseHelper.locTable+"."+DatabaseHelper.locSort+" ASC, "+DatabaseHelper.locTable+"."+DatabaseHelper.locName+" ASC";
		Cursor c = db.query(table, columns, select, new String[]{Long.toString(cardID)}, null, null, orderby);
		
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
	
	public ArrayList<Long> getExpansionsForCard(long cardID) 
	{
		ArrayList<Long> expIDs = new ArrayList<Long>();
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.cardToExpExpID};
		String select = DatabaseHelper.cardToExpCardID+"=?";

		Cursor c = db.query(DatabaseHelper.cardToExpTable, columns, select, new String[]{Long.toString(cardID)}, null, null, null);
		
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			expIDs.add(c.getLong(0));
			
			c.moveToNext();
		}
		
		c.close();
		db.close();
		
		return expIDs;
	}

	public Neighborhood getNeighborhood(long neiID) 
	{
		Neighborhood nei = null;
		
		DatabaseHelper dh = DatabaseHelper.instance;
		SQLiteDatabase db = dh.getReadableDatabase();
		
		String[] columns = new String[]{DatabaseHelper.neiID,DatabaseHelper.neiName, DatabaseHelper.neiCardPath, DatabaseHelper.neiButtonPath};
		String select = DatabaseHelper.neiID+"=?";

		Cursor c = db.query(DatabaseHelper.neighborhoodTable, columns, select, new String[]{Long.toString(neiID)}, null, null, null);
		
		c.moveToFirst();
		if(!c.isAfterLast())
		{
			nei = new Neighborhood(c.getLong(0), c.getString(1), c.getString(2), c.getString(3) );
		}
		
		c.close();
		db.close();
		
		return nei;
	}

	public void Init(Context applicationContext) {
		context = applicationContext;
		
		if(DatabaseHelper.instance == null)
		{
			DatabaseHelper.getInstance(applicationContext);
		}
	}
	   
}
