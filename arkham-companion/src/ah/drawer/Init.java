package ah.drawer;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Init {

	public ArrayList<Location> locations;
	
	public Init()
    {
		locations = InitLocations();
    }
	
	/*
	private ArrayList<Encounter> InitEncounter(Location loc)
	{
		ArrayList<Encounter> enc = new ArrayList<Encounter>();
		
		if(loc.getLocationName() == "Cold Spring Glen")
		{
			enc.add(new Encounter("After a brisk swim in the murky river, you emerge to find yourself covered in brown, bloated leeches. Shuddering in the cold morning air, you begin the laborious task of pulling the squirming, glistening parasites loose one at a time. Lose 3 points, divided between Sanity and Stamina however you like."));
			enc.add(new Encounter("As the sun sets beneath the horizon, hundreds of whippoorwills begin to sing in a wild, frenzied chorus that tears at your mind. Lose 1 Sanity."));
			enc.add(new Encounter("As you push through some hanging moss, dozens of black and red spiders fall on your head and neck. Make a Will (-2) check. If you fail, you are bitten several times, reducing you to 0 Stamina. If you pass, you remain perfectly still until they crawl off, then you find an odd item beneath the moss. Draw 1 Unique Item."));
			enc.add(new Encounter("Make a Luck (-2) check. If you pass, you discover a strange stone statue deep within the glen. Its hands are outstretched, waiting for you to place something in them. If you discard a Unique Item worth at least $5, then skip the Mythos Phase this turn. If you fail the check, then nothing happens."));
			enc.add(new Encounter("Make a Luck (-2) check. If you pass, you discover a strange stone statue deep within the glen. Its hands are outstretched, waiting for you to place something in them. If you discard a Unique Item worth at least $5, then skip the Mythos Phase this turn. If you fail the Luck check, then nothing happens."));
			enc.add(new Encounter("Moving quietly through the underbrush, you overhear a young woman talking to herself. She is fretting about some money her uncle owes to a rather unsavory character. If you wish, you may give her $5 to pay the debt. If you do, she introduces herself as Corinna Jones and asks if she can help you in any way. Take her Ally card if it's available. If it is not, gain 1 Skill as she teaches you something useful in exchange for your help."));
			enc.add(new Encounter("Moving quietly through the underbrush, you overhear a young woman talking to herself. She is fretting about some money her uncle owes to a rather unsavory character. If you wish, you may give her $5 to pay the debt. If you do, she introduces herself as Corinna Jones and asks if she can help you in any way. Take her Ally card if it's available. If it is not, gain 1 Skill as she teaches you something useful in exchange for your help."));
			enc.add(new Encounter("The pool is extremely cold, but clean and pure, allowing you to scrub away some of the grime from your adventures. Gain 1 Sanity and 1 Stamina."));
			enc.add(new Encounter("The water splashes upwards as a monster appears."));
			enc.add(new Encounter("Tripping as you climb down a steep incline, you roll a bit and smack up against an ancient stone statue. Gain 1 Spell, but lose 2 Stamina."));
			enc.add(new Encounter("Walking along a narrow path through the woods, you duck to avoid some low-hanging foliage. The leaves brush the back of your neck. Pass a Luck (-1) check or something warm and moist slides down the back of your shirt. Lose 2 Sanity."));
			enc.add(new Encounter("You come across a human skull with a star-shaped hole in it. Oddly, it seems to have been ruptured from the inside. Shivering, you replace the skull where you found it. Lose 1 Sanity."));
			enc.add(new Encounter("You stumble across an ancient stone table. It has several deep groves carved into its surface and stained dark brown. If you spend 1 monster trophy with a moon dimensional symbol, the ancient beings here are pleased. Any one investigator you choose (even yourself) is Blessed."));
			enc.add(new Encounter("You wander for several hours, then emerge in a clearing some time after dark. Looking up at the vast, starry sky, you are struck by just how insignificant mankind is within this cold, uncaring universe. Lose 1 Sanity."));
		}
		
		return enc;
	}
	*/

	private ArrayList<Location> InitLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		
		/*
		//Dunwich Horror
		//enc.add(new Encounter("Backwoods Country"));
		locs.add(new Location("Cold Spring Glen")); 
		locs.get(locs.size()-1).setEncounters(InitEncounter(locs.get(locs.size()-1)));
		locs.add(new Location("Whateley Farm"));
		locs.add(new Location("Wizard's Hill"));

		//enc.add(new Encounter("Blasted Heath"));
		locs.add(new Location("Devil's Hopyard"));
		locs.add(new Location("Gardners' Place"));
		locs.add(new Location("Harney Jones' Shack"));

		//enc.add(new Encounter("Village Commons"));
		locs.add(new Location("Bishop's Brook Bridge"));
		locs.add(new Location("Darke's Carnival"));
		locs.add(new Location("Dunwich Village"));

		//Kingsport
		//enc.add(new Encounter("Central Hill"));
		locs.add(new Location("7th House on the Left"));
		locs.add(new Location("Congregational Hospital"));
		locs.add(new Location("St. Erasmus's Home"));

		//enc.add(new Encounter("Harborside"));
		locs.add(new Location("607 Water St."));
		locs.add(new Location("North Point Lighthouse"));
		locs.add(new Location("The Rope and Anchor"));

		//enc.add(new Encounter("Kingsport Head"));
		locs.add(new Location("Strange High House"));
		locs.add(new Location("The Causeway"));
		locs.add(new Location("Wireless Station"));

		//enc.add(new Encounter("South Shore"));
		locs.add(new Location("Artists' Colony"));
		locs.add(new Location("Hall School"));
		locs.add(new Location("Neil's Curiosity Shop"));

		//Innsmouth
		//enc.add(new Encounter("Church Green"));
		locs.add(new Location("Esoteric Order of Dagon"));
		locs.add(new Location("Innsmouth Jail"));

		//enc.add(new Encounter("Factory District"));
		locs.add(new Location("First National Grocery"));
		locs.add(new Location("Gilman House Hotel"));
		locs.add(new Location("Marsh Refinery"));

		//enc.add(new Encounter("Innsmouth Shore"));
		locs.add(new Location("Devil Reef"));
		locs.add(new Location("Falcon Point"));
		locs.add(new Location("Y'ha-nthlei"));
		*/
		
		return locs;
	}
	
	static public void FetchBase(SQLiteDatabase db)
	{
		//Base
		
		Cursor c = db.query(DatabaseHelper.expTable, new String[]{DatabaseHelper.expID}, DatabaseHelper.expName+"=?", new String[]{"Base"}, null, null, null);
		c.moveToFirst();
		long baseID = c.getInt(0);
		c.close();
		
		ContentValues neiCV=new ContentValues();
		ContentValues locCV=new ContentValues();
		ContentValues encCV=new ContentValues();
		//Downtown
		long neiID = putNeighborhood(db,neiCV,"Downtown", baseID);
		long locID = putLocation(db,locCV,"Arkham Asylum", neiID);
		putEncounters(db,encCV,"Arkham Asylum",locID);
		locID = putLocation(db,locCV,"Bank of Arkham", neiID);
		locID = putLocation(db,locCV,"Independence Square", neiID);

		neiID = putNeighborhood(db,neiCV,"Easttown", baseID);
		locID = putLocation(db,locCV,"Hibb's Roadhouse", neiID);
		locID = putLocation(db,locCV,"Police Station", neiID);
		locID = putLocation(db,locCV,"Velma's Diner", neiID);

		neiID = putNeighborhood(db,neiCV,"Fench Hill", baseID);
		//locID = putLocation(db,locCV,"Inner Sanctum", neiID);
		locID = putLocation(db,locCV,"Silver Twilight Lodge", neiID);
		locID = putLocation(db,locCV,"The Witch House", neiID);

		neiID = putNeighborhood(db,neiCV,"Merchant District", baseID);
		locID = putLocation(db,locCV,"River Docks", neiID);
		locID = putLocation(db,locCV,"The Unnamable", neiID);
		locID = putLocation(db,locCV,"Unvisited Isle", neiID);

		neiID = putNeighborhood(db,neiCV,"Miskatonic University", baseID);
		locID = putLocation(db,locCV,"Administration Building", neiID);
		locID = putLocation(db,locCV,"Library", neiID);
		locID = putLocation(db,locCV,"Science Building", neiID);

		neiID = putNeighborhood(db,neiCV,"Northside", baseID);
		locID = putLocation(db,locCV,"Curiositie Shoppe", neiID);
		locID = putLocation(db,locCV,"Newspaper", neiID);
		locID = putLocation(db,locCV,"Train Station", neiID);

		neiID = putNeighborhood(db,neiCV,"Rivertown", baseID);
		locID = putLocation(db,locCV,"Black Cave", neiID);
		locID = putLocation(db,locCV,"General Store", neiID);
		locID = putLocation(db,locCV,"Graveyard", neiID);

		neiID = putNeighborhood(db,neiCV,"Southside", baseID);
		locID = putLocation(db,locCV,"Historical Society", neiID);
		locID = putLocation(db,locCV,"Ma's Boarding House", neiID);
		locID = putLocation(db,locCV,"South Church", neiID);

		neiID = putNeighborhood(db,neiCV,"Uptown", baseID);
		locID = putLocation(db,locCV,"St. Mary's Hospital", neiID);
		locID = putLocation(db,locCV,"Woods", neiID);
		locID = putLocation(db,locCV,"Ye Olde Magick Shoppe", neiID);
	}
	
	private static long putEncounter(SQLiteDatabase db, ContentValues cv, String locName, long locID, String encText)
	{
		cv.put(DatabaseHelper.encText, encText);
		cv.put(DatabaseHelper.encLocID, locID);
		return db.insert(DatabaseHelper.encounterTable, DatabaseHelper.encID, cv);
	}

	private static void putEncounters(SQLiteDatabase db, ContentValues cv,
			String locName, long locID) 
	{
		if(locName == "Arkham Asylum")
		{
			putEncounter(db, cv, locName, locID, "In the Doctor's study, you find a book of helpful notes gathered from inmate interviews. Make a Lore (+0) check and consult the following chart:\r\n" +
	
					"Successes:\r\n" +
	
					"\t0) Their stories fill you with horror even as you learn a few bits of knowledge. Lose 1 Sanity and gain 1 Clue token.\r\n" + 
					"\t1-2) You find several pieces of useful information. Gain 2 Clue tokens.\r\n" + 
					"\t3+) One of the interviews contains vital information. Gain 3 Clue tokens.\r\n");
			
			putEncounter(db, cv, locName, locID, "Nurse Heather accidentally injects you with a sleeping draught. You may make a Fight (-2) check to resist. If you fail or choose not to resist, lose your next turn and gain 2 Sanity from the prolonged rest. If you pass, nothing happens."); 	
			putEncounter(db, cv, locName, locID, "Nurse Heather is coming! Make a Speed (-1) check to hide in time. If you pass you see her drop something as she walks by. Draw 1 Unique Item. If you fail, she throws you out. Move to the street.");
			putEncounter(db, cv, locName, locID, "The guards of the sanitarium are aware that there is an intruder. Make a Sneak (-1) check to escape. If you pass, move to the street. If you fail, you are arrested and taken to the Police Station."); 	
			putEncounter(db, cv, locName, locID, "You are mistaken for an inmate. Doctor Mintz has the guards subdue you and conducts an experiment. Make a Will (-1) [2] check to discover the results. If you pass, the injections seem to increase your capacity for learning. Draw 1 Skill. If you fail, his memory drug fails miserably, resulting in lost knowledge. You must discard one of the following (your choice), if able: 4 Clue tokens, or 2 Spells, or 1 Skill."); 	
			putEncounter(db, cv, locName, locID, "You find some strange medicine labeled \"Dream Enhancers\" in a dusty cabinet. If you choose to take it, make a Lore (-1) check. If you pass, your visions show you how to perform a ritual. Draw 1 Spell. Otherwise, nothing happens.");
			putEncounter(db, cv, locName, locID, "You hear screaming. When you open a heavy cell door to investigate, a dark shape leaps out at you! It's an insane man in a straightjacket babbling about invisible horrors. Make a Lore (-2) check to glean some useful information from him. If you pass, gain 2 Clue tokens. If you fail, lose 1 Stamina as he attacks you.");
		}
		else if(locName == "Cold Spring Glen")
		{
			putEncounter(db, cv, locName, locID, "After a brisk swim in the murky river, you emerge to find yourself covered in brown, bloated leeches. Shuddering in the cold morning air, you begin the laborious task of pulling the squirming, glistening parasites loose one at a time. Lose 3 points, divided between Sanity and Stamina however you like.");
			putEncounter(db, cv, locName, locID, "As the sun sets beneath the horizon, hundreds of whippoorwills begin to sing in a wild, frenzied chorus that tears at your mind. Lose 1 Sanity.");
			putEncounter(db, cv, locName, locID, "As you push through some hanging moss, dozens of black and red spiders fall on your head and neck. Make a Will (-2) check. If you fail, you are bitten several times, reducing you to 0 Stamina. If you pass, you remain perfectly still until they crawl off, then you find an odd item beneath the moss. Draw 1 Unique Item.");
			putEncounter(db, cv, locName, locID, "Make a Luck (-2) check. If you pass, you discover a strange stone statue deep within the glen. Its hands are outstretched, waiting for you to place something in them. If you discard a Unique Item worth at least $5, then skip the Mythos Phase this turn. If you fail the check, then nothing happens.");
			putEncounter(db, cv, locName, locID, "Make a Luck (-2) check. If you pass, you discover a strange stone statue deep within the glen. Its hands are outstretched, waiting for you to place something in them. If you discard a Unique Item worth at least $5, then skip the Mythos Phase this turn. If you fail the Luck check, then nothing happens.");
			putEncounter(db, cv, locName, locID, "Moving quietly through the underbrush, you overhear a young woman talking to herself. She is fretting about some money her uncle owes to a rather unsavory character. If you wish, you may give her $5 to pay the debt. If you do, she introduces herself as Corinna Jones and asks if she can help you in any way. Take her Ally card if it's available. If it is not, gain 1 Skill as she teaches you something useful in exchange for your help.");
			putEncounter(db, cv, locName, locID, "Moving quietly through the underbrush, you overhear a young woman talking to herself. She is fretting about some money her uncle owes to a rather unsavory character. If you wish, you may give her $5 to pay the debt. If you do, she introduces herself as Corinna Jones and asks if she can help you in any way. Take her Ally card if it's available. If it is not, gain 1 Skill as she teaches you something useful in exchange for your help.");
			putEncounter(db, cv, locName, locID, "The pool is extremely cold, but clean and pure, allowing you to scrub away some of the grime from your adventures. Gain 1 Sanity and 1 Stamina.");
			putEncounter(db, cv, locName, locID, "The water splashes upwards as a monster appears.");
			putEncounter(db, cv, locName, locID, "Tripping as you climb down a steep incline, you roll a bit and smack up against an ancient stone statue. Gain 1 Spell, but lose 2 Stamina.");
			putEncounter(db, cv, locName, locID, "Walking along a narrow path through the woods, you duck to avoid some low-hanging foliage. The leaves brush the back of your neck. Pass a Luck (-1) check or something warm and moist slides down the back of your shirt. Lose 2 Sanity.");
			putEncounter(db, cv, locName, locID, "You come across a human skull with a star-shaped hole in it. Oddly, it seems to have been ruptured from the inside. Shivering, you replace the skull where you found it. Lose 1 Sanity.");
			putEncounter(db, cv, locName, locID, "You stumble across an ancient stone table. It has several deep groves carved into its surface and stained dark brown. If you spend 1 monster trophy with a moon dimensional symbol, the ancient beings here are pleased. Any one investigator you choose (even yourself) is Blessed.");
			putEncounter(db, cv, locName, locID, "You wander for several hours, then emerge in a clearing some time after dark. Looking up at the vast, starry sky, you are struck by just how insignificant mankind is within this cold, uncaring universe. Lose 1 Sanity.");
		}
	}

	private static long putLocation(SQLiteDatabase db, ContentValues cv,
			String locName, long neiID) 
	{
		cv.put(DatabaseHelper.locName, locName);
		cv.put(DatabaseHelper.locNeiID, neiID);
		return db.insert(DatabaseHelper.locTable, DatabaseHelper.locID, cv);
	}

	private static long putNeighborhood(SQLiteDatabase db, ContentValues cv, String neiName, long expID) 
	{
		cv.put(DatabaseHelper.neiName, neiName);
		cv.put(DatabaseHelper.neiExpID, expID);
		return db.insert(DatabaseHelper.neighborhoodTable, DatabaseHelper.neiID, cv);
	}

	public static void FetchExpansion(SQLiteDatabase db) 
	{
		ContentValues cv=new ContentValues();
		cv.put(DatabaseHelper.expName, "Base");
		db.insert(DatabaseHelper.expTable, DatabaseHelper.expID, cv);
		
	}
	
	
}
