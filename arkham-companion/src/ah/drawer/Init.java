package ah.drawer;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	/*
	static public void FetchCotDP(SQLiteDatabase db)
	{
		//Base
		
		Cursor c = db.query(DatabaseHelper.expTable, new String[]{DatabaseHelper.expID}, DatabaseHelper.expName+"=?", new String[]{"Curse of the Dark Pharoah"}, null, null, null);
		c.moveToFirst();
		long baseID = c.getInt(0);
		c.close();
		
	}
	*/
	 
	private static HashMap<String, Long> locationIDs = new HashMap<String, Long>();
	private static HashMap<String, Long> neighborIDs = new HashMap<String, Long>();
	static public void FetchLocationsOld(SQLiteDatabase db)
	{
		//Base
		
		Cursor c = db.query(DatabaseHelper.expTable, new String[]{DatabaseHelper.expID}, DatabaseHelper.expName+"=?", new String[]{"Base"}, null, null, null);
		c.moveToFirst();
		long baseID = c.getInt(0);
		c.close();
		
		ContentValues neiCV=new ContentValues();
		ContentValues locCV=new ContentValues();
		ContentValues cardCV=new ContentValues();
		//Downtown
		long neiID = insertNeighborhood(db,neiCV,"Downtown", baseID);
		long locID = insertLocation(db,locCV,"Arkham Asylum", neiID);
		locID = insertLocation(db,locCV,"Bank of Arkham", neiID);
		locID = insertLocation(db,locCV,"Independence Square", neiID);

		neiID = insertNeighborhood(db,neiCV,"Easttown", baseID);
		locID = insertLocation(db,locCV,"Hibb's Roadhouse", neiID);
		locID = insertLocation(db,locCV,"Police Station", neiID);
		locID = insertLocation(db,locCV,"Velma's Diner", neiID);

		neiID = insertNeighborhood(db,neiCV,"Fench Hill", baseID);
		locID = insertLocation(db,locCV,"Inner Sanctum", neiID);
		locID = insertLocation(db,locCV,"Silver Twilight Lodge", neiID);
		locID = insertLocation(db,locCV,"The Witch House", neiID);

		neiID = insertNeighborhood(db,neiCV,"Merchant District", baseID);
		locID = insertLocation(db,locCV,"River Docks", neiID);
		locID = insertLocation(db,locCV,"The Unnamable", neiID);
		locID = insertLocation(db,locCV,"Unvisited Isle", neiID);

		neiID = insertNeighborhood(db,neiCV,"Miskatonic University", baseID);
		locID = insertLocation(db,locCV,"Administration Building", neiID);
		locID = insertLocation(db,locCV,"Library", neiID);
		locID = insertLocation(db,locCV,"Science Building", neiID);

		neiID = insertNeighborhood(db,neiCV,"Northside", baseID);
		locID = insertLocation(db,locCV,"Curiositie Shoppe", neiID);
		locID = insertLocation(db,locCV,"Newspaper", neiID);
		locID = insertLocation(db,locCV,"Train Station", neiID);

		neiID = insertNeighborhood(db,neiCV,"Rivertown", baseID);
		locID = insertLocation(db,locCV,"Black Cave", neiID);
		locID = insertLocation(db,locCV,"General Store", neiID);
		locID = insertLocation(db,locCV,"Graveyard", neiID);

		neiID = insertNeighborhood(db,neiCV,"Southside", baseID);
		locID = insertLocation(db,locCV,"Historical Society", neiID);
		locID = insertLocation(db,locCV,"Ma's Boarding House", neiID);
		locID = insertLocation(db,locCV,"South Church", neiID);

		neiID = insertNeighborhood(db,neiCV,"Uptown", baseID);
		locID = insertLocation(db,locCV,"St. Mary's Hospital", neiID);
		locID = insertLocation(db,locCV,"Woods", neiID);
		locID = insertLocation(db,locCV,"Ye Olde Magick Shoppe", neiID);
		
		neiID = insertNeighborhood(db,neiCV,"Harborside", 5);
		locID = insertLocation(db,locCV,"607 Water St.", neiID);
		locID = insertLocation(db,locCV,"North Point Lighthouse", neiID);
		locID = insertLocation(db,locCV,"The Rope and Anchor", neiID);
		
		insertCards(db, cardCV);
	}
	
	private static void insertCards(SQLiteDatabase db, ContentValues cardCV) 
	{
		ContentValues encCV = new ContentValues();
		ContentValues cardToEncCV = new ContentValues();
		
		cardCV.put(DatabaseHelper.cardNeiID, getNeighborhoodID(db, "Downtown"));
		cardCV.put(DatabaseHelper.cardID, 1);
		cardCV.put(DatabaseHelper.cardExpID, 1);
		long cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		long encID = insertEncounter(db, encCV, getLocationID(db, "Arkham Asylum"), "You find some strange medicine labeled \"Dream Enhancers\" in a dusty cabinet. If you choose to take it, make a Lore (-1) check. If you pass, your visions show you how to perform a ritual. Draw 1 Spell. Otherwise, nothing happens."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Bank of Arkham"), "You find a penny with a strange sigil carved into it. Amused, you flip it in the air, then gasp as you feel the sudden gathering of magical forces around you. Make a Luck (-2) check. If you pass, the penny comes up heads. You are Blessed. If you fail, it comes up tails. You are Cursed.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Independence Square"), "There are gypsies camped in the park. They are master thieves and you are their target. Pass a Luck (-2) check or lose 1 item of your choice.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardID, 2);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Arkham Asylum"), "The guards of the sanitarium are aware that there is an intruder. Make a Sneak (-1) check to escape. If you pass, move to the street. If you fail, you are arrested and taken to the Police Station."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Bank of Arkham"), "\"This is a stick-up, see? Nobody move!\" Three men armed with tommy guns rob the bank while you're standing in line. Make a Combat (-1) check. If you pass, you drive them off. Nothing happens. If you fail, lose all of your money.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Independence Square"), "A shadow falls across you from no apparent source and you shiver with more than just cold. Pass a Will (-1) check or lose 1 Stamina and 1 Sanity.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardID, 3);
		cardCV.put(DatabaseHelper.cardNeiID, getNeighborhoodID(db, "Northside"));
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Curiositie Shoppe"), "Jackpot! You find just what you've been looking for. Search either the Common or Unique Item deck and purchase any one item of your choice at list price."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Newspaper"), "Editor Doyle Jefferies offers you a Retainer in return for your fascinating stories. Take a Retainer card.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Train Station"), "The old train hand Bill Washington sits on the train platform playing his guitar as he awaits the next train. As you listen to his singing you feel yourself healing inside. Gain 2 points divided between Stamina and Sanity however you choose.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardID, 4);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Curiositie Shoppe"), "As you wander into the back of the shop, you hear a noise. Pass a Speed (-1) check or you look up just in time to see a descending club. Everything goes black. When you awaken, you are somewhere else. Draw a mythos card and move to the gate location shown on it, then immediately have an encounter there."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Newspaper"), "You accidentally tip over a bottle of ink and are aghast at the pattern the ink forms on the newsroom floor. Lose 1 Sanity.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Train Station"), "A stranger in a turban steps off the Boston local train with a crazed look on his face. Make a Luck (-1) check. If you pass, the man pulls a strange object from beneath his cloak and gives it to you. Draw 1 Unique Item. If you fail, he pulls a poisoned blade out of his cloak and stabs you. Roll a die and lose that much Stamina.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardNeiID, getNeighborhoodID(db, "Downtown"));
		cardCV.put(DatabaseHelper.cardID, 5);
		cardCV.put(DatabaseHelper.cardExpID, 5);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Arkham Asylum"), "An absentminded orderly hands you a clipboard containing the wrong form. You're about to point out his mistake when he snaps, \"I haven't got all day! Are you the next of kin, or aren't you?\" You sign the form to defuse his anger, and he hands you a bag containing some deceased soul's personal effects. Among them, you find $4."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Bank of Arkham"), "\"You've miscounted,\" says the teller, recounting your deposit and demonstrating that-- sure enough-- you had two dollars more than you thought. Gain $2.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Independence Square"), "As you pass through the entry arch on Peabody Avenue, all sound dissolves into a cosmic silence. Make a Luck (-1) check. If you succeed, the mundane noises of Arkham return. If you fail, you are drawn through the gate nearest this location, and you are Cursed.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardID, 6);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Arkham Asylum"), "On the Healing of Mind and Spirit is the title of the book you find sitting, unattended, on one of the end tables in the lounge. Intrigued, you flip through its pages. Restore your Sanity to its maximum and gain a Clue token."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Bank of Arkham"), "As you stand in line for the teller, the bank Vice President motions you over to his office. \"We're aware of the good you've done. The Bank of Arkham thanks you.\" You may spend 10 toughness worth of monster trophies, 1 gate trophy and 5 toughness worth of monster trophies, or 2 gate trophies to either gain $10 or to discard any investigator's Bank Loan.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Independence Square"), "Make a Will (-1) check. If you succeed, you may take Anna Kaslow's Ally card, or, if it's not available, 2 Clue tokens.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardNeiID, getNeighborhoodID(db, "Downtown"));
		cardCV.put(DatabaseHelper.cardID, 7);
		cardCV.put(DatabaseHelper.cardExpID, 8);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Arkham Asylum"), "You discover that the patient you've been looking for has been lobotomized. He can't answer your questions now. Draw one Ally card from the Ally deck and return it to the box."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Bank of Arkham"), "You find a penny with a strange sigil carved into it. Amused, you flip it in the air, but then gasp as you feel the sudden gathering of magical forces around you. Make a Luck (-2) check. If you pass, the penny comes up heads. You are Blessed. If you fail, it comes up tails. you are Cursed.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Independence Square"), "You hoped to get near enough to the gypsy camp to eavesdrop, but a dog bark has alerted them that there is an intruder. Make a Sneak (-1) check to escape! If you fail, you are Cursed.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardID, 8);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Arkham Asylum"), "The doctors allow you to observe the therapy session of one of the asylum's most disturbed patients. Make a Will (-1) check to maintain your wits enough to garner useful information from his story. If you pass, gain 2 Clue tokens. Then, whether you pass or not, lose 1 Sanity after learning of his bone-chilling experiences."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Bank of Arkham"), "A large painting of historic Arkham hangs in the bank lobby. Examining it, you notice an unnerving circle of stones barely visible on the edge of the city. Lose 1 Sanity.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "Independence Square"), "A bronze plate near Founder's Rock commemorates the establishing of the city. You notice that a line of odd symbols runs along the border of the marker. Make a Lore (-1) check to interpret their meaning. If you pass, gain 1 Spell.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardNeiID, getNeighborhoodID(db, "Harborside"));
		cardCV.put(DatabaseHelper.cardID, 9);
		cardCV.put(DatabaseHelper.cardExpID, 5);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "607 Water St."), "As you knock, the door swings open before you. Cautiously entering, you see a number of bottles containing lead pendulums. Gradually, but with increasing violence, the pendulums begin to swing, and voices whisper terrible secrets into your ears. Gain 2 Clue tokens, but you are reduced to 1 Sanity."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "North Point Lighthouse"), "Basil Elton, the lighthouse keeper, politely invites you in for dinner. Gain 1 Sanity and 1 Stamina.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "The Rope and Anchor"), "Troubles weighing heavily upon your worried brow, you drink rather more than you intended. If your current Stamina is 3 or less, you are delayed and lose 1 item of your choice.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		
		cardCV.put(DatabaseHelper.cardID, 10);
		cardID = db.insert(DatabaseHelper.cardTable, DatabaseHelper.cardID, cardCV);
		cardToEncCV.put(DatabaseHelper.cardToEncCardID, cardID);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "607 Water St."), "No one appears to be home, and you've heard tales that the old man who lives here has a stash of money. You may choose to make a Sneak (-2) check. If you pass, you discover some of it. Gain $10. If you fail, you are caught in the act. Move to the street, and you are Cursed."); 
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "North Point Lighthouse"), "Basil Elton, the lighthouse keeper, talks with you about strange ships he's seen moored just off the island-- ships that no one else claims to have seen. Gain 2 Clue tokens.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
		
		encID = insertEncounter(db, encCV, getLocationID(db, "The Rope and Anchor"), "Tonight, the old Yankee fishermen who frequent the tavern are trading long, rambling tales of the sea. You listen for awhile, but although the tales are entertaining, they are uninformative. Nothing happens.");
		cardToEncCV.put(DatabaseHelper.cardToEncEncID, encID);
		db.insert(DatabaseHelper.cardToEncTable, DatabaseHelper.cardToEncCardID, cardToEncCV);
	}
	
	private static long getLocationID(SQLiteDatabase db, String name)
	{
		if(locationIDs.containsKey(name))
		{
			return locationIDs.get(name);
		}
		else
		{
			String select = DatabaseHelper.locName + " = ?";
			String[] columns = new String[]{DatabaseHelper.locID};
			String[] selectionArgs = new String[]{name};
			Cursor c = db.query(DatabaseHelper.locTable, columns, select, selectionArgs, null, null, null);
			
			c.moveToFirst();
	 
			long locID = -1;
			if(!c.isAfterLast())
			{
				locID = c.getLong(0);
			}
			else
			{
				System.out.print("Error. Could not find neighborhood.");
			}
			
			return locID;
		}
	}
	
	private static long getNeighborhoodID(SQLiteDatabase db, String name)
	{
		if(neighborIDs.containsKey(name))
		{
			return neighborIDs.get(name);
		}
		else
		{
			String select = DatabaseHelper.neiName + " = ?";
			String[] columns = new String[]{DatabaseHelper.neiID};
			String[] selectionArgs = new String[]{name};
			Cursor c = db.query(DatabaseHelper.neighborhoodTable, columns, select, selectionArgs, null, null, null);
			
			c.moveToFirst();
	 
			long neiID = -1;
			if(!c.isAfterLast())
			{
				neiID = c.getLong(0);
			}
			else
			{
				System.out.print("Error. Could not find neighborhood.");
			}
			
			return neiID;
		}
	}

	private static long insertEncounter(SQLiteDatabase db, ContentValues cv, long locID, String encText)
	{
		cv.put(DatabaseHelper.encText, encText);
		cv.put(DatabaseHelper.encLocID, locID);
		return db.insert(DatabaseHelper.encounterTable, DatabaseHelper.encID, cv);
	}

//	private static void putEncounters(SQLiteDatabase db, ContentValues cv,
//			String locName, long locID) 
//	{
//		if(locName == "Arkham Asylum")
	//	{
//		}
			/*
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
			*/
			/* Curse of the Dark Pharoah
			putEncounter(db, cv, locName, locID, "\"This one's got some wisdom to him,\" one of the orderlies says as he shows you a withered old Egyptian scholar who was recently committed. \"It's like he seen somethin', and if you look close in his eyes, you can see it too.\" If you look into the patient's eyes, make a Will (-2) check. If you pass, you gain 4 Clue tokens. If you fail, you immediately go insane. ");
			putEncounter(db, cv, locName, locID, "A doctor working on dream therapy asks if you'd be willing to venture into a patient's nightmares; he seems to be beset by dreams of animal-headed men, blinding sand, and strange pyramids. If you agree, you gain 3 Clue tokens but immediately move to the Dreamlands. ");
			putEncounter(db, cv, locName, locID, "All of the Asylum's patients begin speaking in the same strange tounge at once. Make a Lore (-1) check. If you pass, gain 1 Clue token as you realize that they're all speaking ancient Sumerian, a language that only a few scholars in the world know! ");
			putEncounter(db, cv, locName, locID, "The inmates begin to chant in unison, screaming about the \"black Kem of Re and Amen, Isis, and Osiris!\" It nearly drives you mad - but that which doesn't kill you only makes you stronger. If your Will is 1 or lower, you may search the Skill deck and take the Will card.");
			putEncounter(db, cv, locName, locID, "The screams of the insane drive you out of the Asylum... but then you realize that you can still hear them in your mind, praising the coming of the Dark Pharaoh! Take the Psychic card, but you cannot stand to be near the Asylum: You are Barred from Downtown. ");
			
		}
		else if(locName == "Bank of Arkham")
		{
			putEncounter(db, cv, locName, locID, "A dirty, bedraggled man in Egyptian robes stops you on your way into the bank, and intones, \"It is easier for a camel to pass through the eye of a needle than it is for a rich man to enter heaven!\" If you discard all of your money, you are Blessed. ");
			putEncounter(db, cv, locName, locID, "Father Michael is hesitant to walk back to South Church alone, saying that the \"Legacy of the Pharaohs\" exhibit has cast a pall upon Arkham. If you escort him, move immediately to South Church. Do not have an encounter there, but you may trade in monster and gate trophies to be Blessed as described at that location. If you escort him and have the Motorcycle or Map item or the Mists of Releh spell, you are Blessed for free. ");
			putEncounter(db, cv, locName, locID, "You are retrieving some papers from the safety deposit vault when a portal to another place and time suddenly opens, nearly sucking the guard in! If you push him out of the way, you are Blessed, but must immediately move to the Plateau of Leng. ");
			putEncounter(db, cv, locName, locID, "You head up the steps as a bank robber in a mask dashes out, running into you and dropping a sack full of money. If you would like to return the money, gain 1 Sanity. If you want to keep it and run away, gain $10 but lose 1 Sanity and take the Wanted card. ");
			putEncounter(db, cv, locName, locID, "You see a customer going into seizures. If you want to try to help, make a Fight (-2) check to restrain him and keep him from hurting himself or a Lore (-2) check to correctly sedate him. If you fail, lose 2 Stamina as he lashes out. If you pass, the convulsions subside and a nun rushes to you side, saying, \"Bless you, good sir, for helping.\" You are Blessed."); 
		}
		else if(locName == "Independence Square")
		{
			putEncounter(db, cv, locName, locID, "A well-dressed gentleman approaches a group of children and begins to lead one away... and something tells you that he's up to no good. If you confront him, he transforms, and you are surprised by a monster. If you defeat it, draw 1 Exhibit Item, but you are Barred from Downtown for assaulting a respected citizen. If you mind your own business, the child is later found dead. ");
			putEncounter(db, cv, locName, locID, "A sheaf of papers with hieroglyphics translations blows past you on the wind. Make a Speed (-1) check. If you fail, a young lady runs past you after them. If you pass, you catch them and are thanked profusely by Sarah Danforth, an archaeology student from Miskatonic. Take her Ally card. If it is not available, gain 1 Clue token instead as she chats with you about the visiting museum exhibit. ");
			putEncounter(db, cv, locName, locID, "From a bench in Independence Square you can watch the comings and goings of the town's major figures. Gain 1 Clue token. ");
			putEncounter(db, cv, locName, locID, "The staff of the visiting museum exhibit puts on an educational show in the park, but it is rather confusing. Make a Lore (-1) check. If you pass, you gain Clue tokens equal to your focus (maximum 3). If you fail, you lose Clue tokens equal to your focus (maximum 3). ");
			putEncounter(db, cv, locName, locID, "You learn that cultists are bribing the mayor with stolen items from the \"Legacy of the Pharaohs\" exhibit, and often drop them off on his doorstep. If you would like to reappropriate them, make a Sneak (-1) check. If you fail, you are arrested. If you roll 1 success, you get away, but empty-handed. If you roll 2 successes, you get away with the packages: Draw 1 Unique Item or Exhibit Item. ");
		}
		else if(locName == "Hibb's Roadhouse")
		{
			putEncounter(db, cv, locName, locID, "\"Friendly game of pool?\" Make a Speed (+0) check and consult the chart below.\r\n" +
			"\r\n" +
			"Successes:\r\n" +
			"\r\n" +
			"\t0) You lose $3.\r\n" + 
    		"\t1-2) You notice that your opponent is cheating! If you confront him, he shoves $3 at you but scowls, telling you you'd better not come back here. You are Barred from Easttown.\r\n" + 
    		"\t3) You gain $3. ");
			putEncounter(db, cv, locName, locID, "A man sets down a briefcase, muttering furtively. \"Have you seen the yellow sign?\" Pass a Lore (-3) check to draw the yellow sign in a pool of beer on the counter, at which he nods and leaves the briefcase. Search the Common Item deck and take the first Weapon you find, and gain $10! ");
			putEncounter(db, cv, locName, locID, "A truck driver at the bar has a flat tire and needs help changing it. If you pass a Fight (-1) check, you help him out and he offers you some of his cargo for free. Search the Common Item deck for your choice of a Lantern, Map of Arkham, or Dark Cloak, and take that card. ");
			putEncounter(db, cv, locName, locID, "Erica Carlyle is slumming it, and seems intrigued by your tales of mystery. If you have $3 or less, she agrees to join you and help pay your way. Take her Ally card or, if it is not available, gain a Retainer card. ");
			putEncounter(db, cv, locName, locID, "The man at the bar next to you is deep in his cups. Pass a Luck (+0) check to realize that he's a loan officer from the Bank. He is so drunk that he barely remembers his name. You may gain a Bank Loan from him, or if you have a Bank Loan already, may convince him that you have paid it off, and may discard the Bank Loan card. ");

		}
		else if(locName =="Police Station")
		{
			putEncounter(db, cv, locName, locID, "Make a Sneak (-1) check to listen in on an interrogation, and consult the following chart.\r\n" +
					"\r\n" +
					"Successes:\r\n" +
					"\r\n" +
					"\t0) You misunderstand what is discussed. Lose 1 Clue Token.\r\n" + 
					"\t1-2) Deputy Dingby sees you standing by the door. Pay $2 to gain 1 Clue Token.\r\n" + 
					"\t3+) What you overhear helps you put the pieces together. Gain 2 Clue Tokens.\r\n");
					putEncounter(db, cv, locName, locID, "One of the jail's \"guests\" decides to end it all rather than face justice, and Deputy Dingby offers you a pick of his belongings. Pass a Luck (+0) check to draw a number of cards from the Common Item deck equal to the number of successes rolled. Keep 1 card and discard the rest. ");
					putEncounter(db, cv, locName, locID, "With all the strange outsiders coming to see the visiting museum exhibit, Sheriff Engle worries about Arkham's safety. If you have a Physical weapon, he gives you some training, and you may search the Skill deck for the Marksman card and take it. If you do not have a Physical weapon, search the Common Item deck and take the first Weapon you find. ");
					putEncounter(db, cv, locName, locID, "You are called in for questioning about missing artifacts from the \"Legacy of the Pharaohs\" exhibit. Make a Will (-1) check. If you pass, the Sheriff believes you are innocent, and his questions tip you off about a few things; Gain 1 Clue Token. If you fail, he doubts your word, and accuses you of a crime! Choose between being arrested and taking the Wanted card. ");
					putEncounter(db, cv, locName, locID, "You stop by to say hello when you hear an argument from Sheriff Engle's office. \"But why would a killer perfume the body with lavender and peppermint?\" Make a Lore (-2) check. If you pass, you recognize those herbs as being used in an ancient Egyptian embalming practices. Gain 1 Clue Token and the Sheriff rewards you with the Private Investigator card. ");

		}
		if (locName =="Velma's Diner")
		{
			putEncounter(db, cv, locName, locID, "A reporter from the Arkham Advertiser offers you money to plant a dead scarab beetle in your soup bowl so he can get a story. If you do so, gain $3 but you are Barred from Easttown. ");
			putEncounter(db, cv, locName, locID, "Free Egyptian grain bread to make the newcomers welcome! Gain 1 Stamina. ");
			putEncounter(db, cv, locName, locID, "Velma asks you to sample her new Egyptian barley soup recipe. Pass a Luck (-2) check to gain Stamina equal to your number of successes. If you fail, lose 1 Stamina. ");
			putEncounter(db, cv, locName, locID, "You begin pumping the \"Legacy of the Pharoahs\" exhibit curator for information. He of course denies that the exhibit has anything to do with the strange occurrences in Arkham lately, and offers to pay for your meal to make sure you tell the same to anyone you work for. If you have the Retainer, Deputy of Arkham, or Silver Twilight Lodge Membership cards, you may discard one to gain 2 Stamina and $5. ");
			putEncounter(db, cv, locName, locID, "You take a job working in the diner for tips, and you'll never disparage a waitress again. Make a Speed (-1) check. If you succeed, gain $2. If you fail, lose 1 Stamina but you may search the Skill deck for the Speed card and take it."); 
		}
		if (locName =="Inner Sanctum")
		{
			putEncounter(db, cv, locName, locID, "A gorgeous youth invites you into a meditation chamber. If you go in, you must lose a total of 4 Spells or Stamina, divided up as you choose, but you may search the Exhibit Item deck for the Triune Mask (errata: should be Mask of the Three Fates) card and take it. If you do not go in, the young witch casts a hex upon you, and you are Barred from French Hill. ");
			putEncounter(db, cv, locName, locID, "\"Time to pay your dues, brother. We need a champion, and you've been chosen.\" You are handed a weapon and thrown through a doorway into oblivion. You may search the Unique Item deck and take the first magical weapon you find, but you are transported to R'lyeh. ");
			putEncounter(db, cv, locName, locID, "A newly ordained member of the Lodge should be seen but not heard. Pass a Sneak (-1) check to gain 2 Clue tokens. If you fail, the stern glares of the higher-ranking members at least give you motivation: You may search the Spell deck for the Stealth card and take it. ");
			putEncounter(db, cv, locName, locID, "Only the strongest of will may enter the Lodge's prized library. Make a Will (-1) check. If you pass, you gain 3 Clue tokens and may search the Spell deck for any one Spell and take it. If you fail, you lose your Silver Twilight Lodge Membership. ");
			putEncounter(db, cv, locName, locID, "There is an inscription above an alcove. Pass a Lore (-2) check to understand it. If you do, it reads \"Place herein a thing mundane, it will become a thing of fame.\" You gain 1 Clue token and may draw 1 Unique Item or Exhibit Item. If you discard a Common Item of your choice, you may keep the item drawn; otherwise, discard it. ");

		}
		if (locName =="Silver Twilight Lodge")
		{
			putEncounter(db, cv, locName, locID, "Make a Will (-2) check to convince the Lodge that you need one of its sacred items for the good of Arkham. If you pass, draw cards equal to the number of successes from the Unique Item or Exhibit Item deck, keep one, and discard the rest. If you fail, you are Barred from French Hill. ");
			putEncounter(db, cv, locName, locID, "\"Certainly, we'd love to have you,\" Carl Sanford says, \"if you can do something for us.\" Move to the City of the Great Race and have an encounter there, then immediately return. If you passed a test or defeated a monster encountered there, take a Silver Twilight Membership and gain 1 Clue token. ");
			putEncounter(db, cv, locName, locID, "\"You want to see what we're really about, then?\" If you accept the Order's invitation, you are introduced to the Black Man. Make a Luck (+0) check or be devoured. If you pass, take a Silver Twilight Membership card and gain 2 Clue tokens. ");
			putEncounter(db, cv, locName, locID, "The lights go out; you hear chanting and feel a knife at your throat. You may:\r\n" +
					"\r\n" +
			    "\t1) Flee. Lose 1 Stamina and move to the street.\r\n" +
			    "\t2) Allow them to cast their ritual upon you. Lose 2 Stamina, but take the Visions card and gain 1 Clue token.\r\n" +
			    "\t3) Attempt to take control of the ritual with a Lore (-1) check. If you pass, the Lodge offers you a Silver Twilight Membership. (errata: the following was not printed) If you fail, lose 3 Stamina and all of your Spells, then move to the street.");
			putEncounter(db, cv, locName, locID, "The Lodge is always eager to trade lore. Discard any number of Spells. Gain a number of Clue tokens equal to the total Sanity cost of the Spells discarded. ");
		}
		if (locName =="The Witch House")
		{
			putEncounter(db, cv, locName, locID, "Ever since you visited the witch house, you keep seeing a strange, rat-like creature out of the corner of you eye...and sometimes it looks like its face is almost human! Gain 1 Clue token, but take the Harried card. ");
			putEncounter(db, cv, locName, locID, "Something about the angles in the attic room opens your mind to the myriad possibilities of other, nearly identical universes. Search the Spell deck for a Spell you already have, and take another copy of it. Then, as you continue to stare into the impossible angle, a Hound of Tindalos appears! ");
			putEncounter(db, cv, locName, locID, "The graffiti on the walls is actually Egyptian hieroglyphics. Make a Lore (+0) check. You may draw cards from the Spell deck equal to the number of successes, and keep one of them. ");
			putEncounter(db, cv, locName, locID, "You see a prim and proper girl in puritanical attire, but there is something hungry in her eyes. \"Would you like to see?\" she asks, demurely. If you agree, she reaches forward to touch you. You feel a terrible cold, then the burning heat of the pyre! You realize that she is the ghost of Keziah Mason, who was burned at the stake for witchcraft over a century ago! Make a Will (-1) check. You may gain 1 Clue token for each success or 1 Spell for every two successes. ");
			putEncounter(db, cv, locName, locID, "You take a renowned visiting escape artist on a tour of the witch house. If you give him 2 of your Spells (discarding them), he introduces himself as Erich Weiss; take his Ally card if it's available. If it's not available, he shows you a trick instead, and you gain 2 Clue tokens. ");

		}
		if (locName =="River Docks")
		{
			putEncounter(db, cv, locName, locID, "A load of cargo, precariously balanced on the edge of the dock, goes into the river with a splash. If you dive in and try to retrieve it, a monster appears, and you suffer a -1 to your Combat checks. If you evade or defeat the monster, you may draw 2 Common Items. ");
			putEncounter(db, cv, locName, locID, "The docks are overloaded with shipments coming in to support the museum exhibit. No one will notice if something goes missing. Make a Sneak (-1) check. For each success, you may draw 1 Common Item. You may keep any non-Weapon cards, and must discard the rest. ");
			putEncounter(db, cv, locName, locID, "You see men of questionable character guiding one of the visiting museum curators toward the edge of the dock...his hands are tied! He pleads to you for help with silent eyes. If you aid him, make a Fight (-2) check. If you pass, you wrest the weapon from one and chase them off; you may search the Common Item deck and take the Tommy Gun card. If you fail, lose 2 Stamina. ");
			putEncounter(db, cv, locName, locID, "You stare into the river, contemplating its currents and depths. Make a Luck (+0) check. If you pass, you realize that time, fate, all of reality, are like a river; take the Visions card. If you fail, a pair of dock workers knock you into the river as a lark, and you catch a cold. Lose 1 Stamina. ");
			putEncounter(db, cv, locName, locID, "A rowdy dock hand doesn't like the looks of you, and challenges you to a fistfight. Make a Fight (+1) [2] check. If you pass, lose 1 Stamina, but you may search the Skill deck for the Fight card and take it. If you fail, the dock workers spit on you and you run off. Lose 2 Stamina and you are Barred from the Merchant District. ");

		}
		if (locName =="The Unnamable")
		{
			putEncounter(db, cv, locName, locID, "A group of cultists scampers through the night. If you follow them, make a Sneak (+0) check to watch where they bury their prize. If you pass, you may draw 1 Unique Item or Exhibit Item. If you fail, they turn and smile: a monster surprises you from behind! ");
			putEncounter(db, cv, locName, locID, "Luck finds those who need it. If you Luck is 1 or lower, you find a luck penny between the floorboards. You may search the Skill deck and take the Luck card. ");
			putEncounter(db, cv, locName, locID, "The house calls to you. If you follow its voice, it tells you which floorboards to pry up. You may draw 1 Unique item or Exhibit Item, but must also take the Tainted card. ");
			putEncounter(db, cv, locName, locID, "You pass the strange house and find yourself face to face with a foreign man with a penetrating gaze. If you have any Exhibit Items or your Will is 2 or lower, he seems to approve of your simpering manner, and he introduces himself as Dr. Ali Kafour. Take his Ally card or, if it is not available, listen to him expound upon the ancient Egyptian pantheon as it compares to that of Native American myths: Gain 2 Clue tokens. ");
			putEncounter(db, cv, locName, locID, "You see a warped mirror. If you look into it, you see yourself in another time and place, holding an ankh in one hand and a sacrificial blade in the other. Your number of Clue tokens doubles, but if you gain more than 3 Clue tokens in this manner, you are Cursed. ");

		}
		if (locName =="Unvisited Isle")
		{
			putEncounter(db, cv, locName, locID, "A man wearing exotic robes and a strange hat sits in a shaded clearing, seemingly in a trance. As you approach, he says, \"Come sit with me,\" without looking at you. If you are Cursed or have any Mask items, he tells you that he is called The Messenger and is meant to aid you. Take his Ally card or, if it is not available, gain 2 Clue Tokens. ");
			putEncounter(db, cv, locName, locID, "As you row along the island's shore, a tree branch cracks and falls toward you. Make a Speed (+0) check. If you fail, you are knocked out and wake up far downstream; move to the Graveyard and you turn ends. ");
			putEncounter(db, cv, locName, locID, "Something calls to you from the island's heart... if only you could find it! Make a Luck (-2) check or exhaust the Find Gate spell, Dynamite item, or Gate Box item to automatically pass. If you pass, you manage to create a tunnel down into the earth. Gain 1d6 Clue tokens. If you exhausted an item or spell to pass the check and gained more that 3 Clue tokens, you must discard the item or spell used. ");
			putEncounter(db, cv, locName, locID, "You come upon a tree that has grown, cancer-like, around an ancient prayer plaque. Make a Fight (-2) check or exhaust the Wither spell, Shrivelling spell, or the Axe item to automatically pass. If you pass, draw Spells equal to your focus. ");
			putEncounter(db, cv, locName, locID, "You see a group of masked Egyptian cultists performing a hideous ritual in a clearing. If you wish to get closer and listen, make a Sneak (+0) check. If you pass, draw 1 Spell. If you fail, the look up as one and point at you, and you know that you are marked. You are Barred from the Merchant District. ");

		}
		if (locName =="Administration Building")
		{
			putEncounter(db, cv, locName, locID, "A Miskatonic entomologist has heard rumors of an exotic species of beetle, previously only found along the Nile, that has been spotted in the campus hedgerows. Make a Luck (-1) [2] check to find it for her. If you pass, she gives you a $5 stipend for your work. ");
			putEncounter(db, cv, locName, locID, "The Dean would like you to escort the visiting Dr. Ali Kafour around Arkham and show him the sights. If you agree, you gain $3 as spending money, but must take the Local Guide card. ");
			putEncounter(db, cv, locName, locID, "You meet a research assistant who is quite taken with you. Roll a die. You gain that many free movement points, to be used immediately on any Tome or other item that requires an expenditure of movement points to use. ");
			putEncounter(db, cv, locName, locID, "You overhear a history student complaining to his friend about a lack of materials for his Civil War thesis. If you attempt to enlighten him, he pays $1 for each Clue token you are willing to discard. Also, if you have the Cavalry Saber, Ancient Tome, or Old Journal Common Items, he will pay you double the listed cost for them. ");
			putEncounter(db, cv, locName, locID, "\"You there. Friend. You are from this town, yes?\" A poor foreign student wants to enroll at the university, and asks if he can use your name because tuition is cheaper for local residents. If you agree, gain $10, but you are Barred from Miskatonic U. ");
		}
		if (locName =="Library")
		{
			putEncounter(db, cv, locName, locID, "You overhear two men whispering about the visiting exhibit at the museum. \"They cannot discover our plans. We must destroy their tomes.\" One of them pulls out a lighter and begins to burn the books! Make a Fight (-2) check. If you pass, you chase them off. If you fail, they escape and you are blamed for the arson; you are Barred from Miskatonic U. ");
			putEncounter(db, cv, locName, locID, "A poorly shelved collection of books falls on you. Make a Speed (+1) check or lose 1 Stamina. Regardless of your success or failure, a book lands open on the floor to a strange passage. Draw 1 Spell. ");
			putEncounter(db, cv, locName, locID, "A young, shy anthropology student trips as she's walking past you, dropping the artifact she is carrying into your hands. She apologizes profusely, adjusting her glasses and keeping her eyes on the floor. Make a Will (-2) check; if you are a male investigator, it is a Will (+0) check. If you succeed, she is so embarrassed that she dashes off without taking the artifact. You may draw 1 Exhibit Item or Unique Item. ");
			putEncounter(db, cv, locName, locID, "A young, shy history student bumps into you, dropping the package he is carrying. He apologizes profusely, stuttering as he avoids making eye contact. Make a Will (-2) check; if you are a female investigator, it is a Will (+0) check. If you succeed, he is so flustered that he dashes off without picking up the artifact. You may draw 1 Exhibit Item or Unique Item. ");
			putEncounter(db, cv, locName, locID, "Two archaeology students have fallen asleep over tomes on loan from the \"Legacy of the Pharaohs\" exhibit. Make a Sneak (+1) check. For every two successes (round down), you may draw 2 Spells, select one of them, and discard the other. ");

		}
		if (locName =="Science Building")
		{
			putEncounter(db, cv, locName, locID, "One of the janitors receives strange gifts from the faculty every Christmas. He offers to sell you \" one o' them thar kooky books 'r thingamajigs.\" If you pay him $5, you may draw 1 Exhibit Item or Unique Item. ");
			putEncounter(db, cv, locName, locID, "The faculty at Miskatonic is all abuzz about rumors of an invasion of exotic insect species in town. They have no time for you. You may immediately move to the Administration Building or the Library and have an encounter there. ");
			putEncounter(db, cv, locName, locID, "Wandering the labs at night, you are surprised by a strange, winged, crab-like creature. It attacks! Make a Speed (-2) check and encounter a Mi-Go from the monster cup. If you fail the check, it seems to move with preternatural, and you may not use any investigator cards in this encounter. ");
			putEncounter(db, cv, locName, locID, "You help a professor clean his classroom, and later on are shaking the chalk dust out of your clothes. Make a Luck (-1) check. If you fail, you cough and gag on the dust, losing 1 Stamina. If you pass, you realize that the dust is actually a mystical powder! You may search the Unique Item deck and take the Powder of Ibn-Ghazi card. ");
			putEncounter(db, cv, locName, locID, "You turn a corner and come face to face with a hideous beast! Make a Will (+0) check. If you fail, you faint in horror and hit your head, suffering a mild concussion. Discard 1 Spell or Skill of your choice. If you succeed, you realize that it is just a statue on loan from the \"Legacy of the Pharaohs\" exhibit, and your turn ends. ");

		}
		if (locName =="Curiositie Shoppe")
		{
			putEncounter(db, cv, locName, locID, "\"Durn roof keeps leakin'... ruinin' my wares!\" If you offer to fix the roof for the shopkeeper, make a Speed (-1) check. If you fail, you fall and lose 2 Stamina. If you pass, he is grateful, and offers to give you any Common Item in the deck with a value equal to or lower than your number of successes. ");
			putEncounter(db, cv, locName, locID, "If you look hard, you can find some real bargains here! Draw a number of cards from the Common Item deck equal to your focus (maximum 3). You may purchase any of the drawn items for $1 less than the list price, and must discard the rest. ");
			putEncounter(db, cv, locName, locID, "The shop seems to be closed early. You peer through the windows and see... something your mind cannot comprehend! Lose 1 Sanity. ");
			putEncounter(db, cv, locName, locID, "The shopkeeper has purchased a display of kitschy Egyptian items to drum up business. Make a Lore (+0) check. If you fail, it looks realistic to you. If you pass, you point out a few items that are set up improperly, and help him rearrange the display. In return, he offers you any one non-Weapon Common Item at half price. ");
			putEncounter(db, cv, locName, locID, "You get into a debate with the shopkeeper regarding the value of material wealth vs. knowledge, and he challenges you to prove your point. If you pass a Will (-1) check, you may discard a Common Item or any number of Clue tokens. If you discard a Common Item, draw a number of Clue tokens equal to its value. If you discard Clue tokens, search the Common Item deck and take any number of items with a total value equal to or less than the number of Clue tokens discarded. ");

		}
		if (locName =="Newspaper")
		{
			putEncounter(db, cv, locName, locID, "A competitor to the Arkham Advertiser offers you money to sabotage the presses. If you accept, gain $5 and make a Sneak (-2) check. If you fail, you are arrested as well as Barred from Northside. ");
			putEncounter(db, cv, locName, locID, "A reporter will pay you handsomely, whether in money or information, for an expos� on the life of a monster hunter. Discard any number of monster trophies to gain $1 or 2 Clue tokens (in any combination) (errata: should be $2 or 1 Clue token) for each point of toughness worth of monsters discarded. ");
			putEncounter(db, cv, locName, locID, "Staring into the presses is like watching the flow of history passing by you. You begin to see a strange pattern to it all. Take the Visions card. ");
			putEncounter(db, cv, locName, locID, "The editor asks you to answer phones on a busy night. You pick up one call and hear nothing at first. Then you hear your name being whispered by something that can't possibly be human. Make a Will (-1) check or lose 1 Sanity. Then make a Speed (-2) check to activate a call trace in time. If you pass, you learn that it came from the museum exhibit. Gain 2 Clue tokens ");
			putEncounter(db, cv, locName, locID, "You call around for a story, asking about mysterious occurrences related to the visiting museum exhibit. Make a Luck (+0) check. For each success, you may take 1 Clue token from any locations in Arkham and add it to your pool. If there are not Clue tokens in Arkham, you may not gain any. ");

		}
		if (locName =="Train Station")
		{
			putEncounter(db, cv, locName, locID, "The railroad bulls don't trust the influx of foreigners with the visiting museum exhibit, and are distracted. If you'd like to try to jump on board a freight train as it pulls out, make a Sneak (+0) check. If you pass, you may move to any Arkham location and end your turn. If you fail, you are caught and warned not to show your face around here again. Lose 1 Stamina and you are Barred from Northside. ");
			putEncounter(db, cv, locName, locID, "A wealthy foreigner steps off the train and mistakes you for his guide, handing you his baggage. Draw 1 Exhibit Item, 1 Unique Item, and 1 Common Item. Keep one of them and discard the rest. You must also take the Local Guide card. ");
			putEncounter(db, cv, locName, locID, "The station manager offers you a job helping to clean out the storage shed where lost and left-behind luggage is kept. Gain $3 and make a Luck (-2) check. If you pass, you may also draw 1 Unique Item or Exhibit Item. ");
			putEncounter(db, cv, locName, locID, "You fall asleep waiting for your train. Move to the Dreamlands and have an encounter there, then (unless you are lost in time and space) return immediately. When you awake, you are holding a strange artifact. Draw 1 Unique Item or Exhibit Item. ");
			putEncounter(db, cv, locName, locID, "You share a train car with a foreign visitor. When you step off and open your valise, you realize you grabbed the wrong one! Discard a Common or Unique Item if able, then make a Luck (+0) check. If you pass, draw a number of Unique or Exhibit Items equal to the number of successes rolled, and keep one. If you fail, follow the instructions as above but draw from the Common Item deck. (Clarification: you will need to discard a second item before you make the second Luck check. You receive nothing if you fail this second check. ");

		}
		if (locName =="Black Cave")
		{
			putEncounter(db, cv, locName, locID, "You hear a child's cries for help from deep within the cave. If you ignore them, the guilt haunts you whenever you are nearby, and you are Barred from Rivertown. If you try to rescue the child, make a Luck (-1) check. If you pass, you find her in a chamber covered with strange occult inscriptions, and may draw 2 Spells. If you fail, you are lost in space and time. ");
			putEncounter(db, cv, locName, locID, "A monster surprises you! After the battle, if you passed a Horror Check, draw Spells equal to the monster's Horror damage. If you failed a Horror check, you emerge with resolve: You may search the Skill deck for the Bravery card and take it. ");
			putEncounter(db, cv, locName, locID, "This is a mystic place, where meditation may have strange effects. If you wish to try to meditate, make a Will (+0) check. if you pass, draw 1 Spell. If you fail, lose 1 Sanity and take the Tainted card. ");
			putEncounter(db, cv, locName, locID, "You agree to map out the caves for the local land grant office. Pass a Speed (-2) check to find a cache of stolen goods. Draw 2 Common Items. ");
			putEncounter(db, cv, locName, locID, "You find the remains of a fire where someone attempted to burn incriminating evidence, but didn't finish the job. You may search the Common Item deck for the Research Materials card and take it. ");

		}
		if (locName =="General Store")
		{
			putEncounter(db, cv, locName, locID, "A pickpocket grabs your money and runs. Pass a Fight (-2) check to grab and regain not only your money, but other stolen cash as well. Gain $3. If you fail, discard all your money. ");
			putEncounter(db, cv, locName, locID, "If you wish, you may stay here next turn and make a Speed (+1) check. You gain $1 per success rolled. ");
			putEncounter(db, cv, locName, locID, "Mail order! Each investigator may give you money to purchase a single Common Item of his or her choice at list price. Place the items facedown in front of you. If you enter the same location as the investigator who requested the item, give it to him and receive $1 from the bank as a delivery fee. ");
			putEncounter(db, cv, locName, locID, "The shopkeeper has a terrible headache, and yells at you for stepping on all of the squeaky floorboards. Make a Sneak (+1) check. If you pass, he accidentally rings you up with a credit, and you gain $2. If you fail, you may search the Skill deck and take the Sneak card. ");
			putEncounter(db, cv, locName, locID, "You find the shopkeeper dead on the floor! Make a Luck (+0) check.\r\n" +
					"\r\n" +
			"Successes:\r\n" +
			"\r\n" +
			    "\t0) The Sheriff walks in and finds you at the scene. Take the Wanted card.\r\n" +
			    "\t1-2) Lose 1 Sanity. \r\n" +
			    "\t3) There's an invitation to the Silver Twilight Lodge in his pocket. Take a Silver Twilight Lodge Membership card."); 
		}
		if (locName =="Graveyard")
		{
			putEncounter(db, cv, locName, locID, "If you have any Ghoul, Vampire, or Zombie monster trophies, you may exchange any of them for Clue tokens equal to their toughness. If you have none of those trophies, the stench of death drives you to distraction, and you cannot bear to be near the graveyard. You are Barred from Rivertown. ");
			putEncounter(db, cv, locName, locID, "\"The thief went this way!\" someone shouts, coming from the direction of the museum exhibit. Make a Speed (-1) check. If you pass, you follow the thief into the graveyard and watch where he hides the stolen item. Draw 1 Unique Item or Exhibit Item. ");
			putEncounter(db, cv, locName, locID, "A priest kneels at the gravestone of one Walter Gilman. Hearing you approach, he rises up out of his prayer and brushes off his knees. \"A shame, a perfect shame.\" If you are Cursed or either your Stamina or Sanity is 2 or lower, he introduces himself as Father Iwanicki, and says \"And yet, perhaps the good Lord led you here so I could save you, whereas I could not save him.\" Take his Ally card or, if it is not available, you may search the Unique Item deck for the Holy Water card and take it. ");
			putEncounter(db, cv, locName, locID, "In the dead of night, you see a figure lurking in the graveyard, carrying an ancient artifact. If you investigate, a monster appears, and you suffer a -1 on both Horror checks and Combat checks. If you defeat the monster with your first Combat check, draw 1 Unique Item or Exhibit Item. If you defeat the monster after multiple Combat checks, the artifact falls to the ground, and its pieces hint at a diabolical scheme: Gain 2 Clue tokens. ");
			putEncounter(db, cv, locName, locID, "You notice that the graveyard is in terrible disrepair and consider donating money for its upkeep. For each $1 you donate, you may roll one die. Count the number of successes and consult the chart below:\r\n" +
					"\r\n" +
			"Successes:\r\n" +
			"\r\n" +
			    "\t0) You are thanked profusely.\r\n" +
			    "\t1-2) You gain a number of Clue tokens equal to your number of successes.\r\n" +
			    "\t3+) You gain 2 Clue tokens and may take the Anointed card. ");

		}
		if (locName =="Historical Society")
		{
			putEncounter(db, cv, locName, locID, "A past-life believer offers to channel the spirits of the ancients. You may join in and make a Will (+0) check to draw Spells until you draw one with a Sanity cost of 0; keep that Spell and discard the rest. Alternatively, you may watch her technique, and make a Luck (-1) check. If you pass, you may take the Psychic card. ");
			putEncounter(db, cv, locName, locID, "A weary old man holds out a stack of paper and says \"It's a memoir of my travels along the Nile, but I doubt the world will last long enough for it to be published.\" If you wish to read it, remain here next turn and make a Will (+0) check. You may draw cards from the Skill deck equal to your number of successes, and may keep one of them. ");
			putEncounter(db, cv, locName, locID, "Make a Lore (-1) check to dig up inspirational travel journals penned by residents of Arkham who traveled to the mysterious and dangerous Nile. If you pass, you may search the Skill deck and take the Bravery card. ");
			putEncounter(db, cv, locName, locID, "You find a cipher for interpreting old texts and hieroglyphics! You may immediately use any Tome or other item that requires an expenditure of movement points to use. ");
			putEncounter(db, cv, locName, locID, "You find a painting of your grandparents wearing strange occult pendants. You may search the Skill deck for the Expert Occultist or Lore card and take it, but if you do so you must also take the Tainted card.");
		}
		if (locName =="Ma's Boarding House")
		{
			putEncounter(db, cv, locName, locID, "You're invited to a midnight s�ance. If you attend, you may commune with the spirit realm: Look at the top two cards of the Mythos deck and replace them, facedown, in any order you like. However Ma Mathison breaks up the s�ance and says that \"yew devil worshippers better not come round no more!\" You are Barred from Southside. ");
			putEncounter(db, cv, locName, locID, "Ma Mathison offers board as well as room; the bigger the boarder, the bigger the lunch. Search the Common Item deck and take the Food card. Then make a Fight (-1) check. For each success, you may place a token on the Food card; when you use the Food, you may discard the token instead of discarding the card. ");
			putEncounter(db, cv, locName, locID, "The gable room faces east and brings in clean air from the sea. You gain 1 Stamina immediately, and may stay here next turn in order to gain an additional 2 Stamina. ");
			putEncounter(db, cv, locName, locID, "You ambush several monsters emerging from a secret tunnel! Make a Sneak (-2) check and consult the table below.\r\n" +
					"\r\n" +
					"Successes:\r\n" +
					"\r\n" +
					    "\t0) Three monsters appear!\r\n" +
					    "\t1) Draw 1 monster trophy from the cup, but 2 monsters appear!\r\n" +
					    "\t2) Draw 2 monster trophies from the cup, but 1 monster appears!\r\n" +
					    "\t3+) You tear aside the sub-window's curtain, revealing the dawn's light and all of the monsters disintegrate! Draw 3 monster trophies from the cup."); 
			putEncounter(db, cv, locName, locID, "Your room's last occupant left a small shrine to Osiris. Make a Luck (+0) check. If you pass, a monster appears. If you fail, a monster appears and you must take the Harried card. ");

		}
		if (locName =="South Church")
		{
			putEncounter(db, cv, locName, locID, "If you have any Exhibit Items, Father Michael calls them profane works and demands that you destroy them. If you refuse, you are Barred from Southside. If you agree, you gain 1 Sanity and 1 Clue token per item discarded. ");
			putEncounter(db, cv, locName, locID, "\"Father Michael?\" You look into the back office, and see the priest being assaulted by a demonic servitor of Horus! If you have a Cross, Holy Water, or Blessing card, you drive it off. Father Michael is shaken, and asks you to assist in running the church while he atones. If you drove off the being, you may take the Anointed card. ");
			putEncounter(db, cv, locName, locID, "\"Pray for Arkham, my son.\" Make a Will (-2) check and consult the chart below:\r\n" +
					"\r\n" +
			"Successes:\r\n" +
			"\r\n" +
			    "\t0) The Dark Pharaoh hears your prayer. Each investigator must make a Will (-2) check or be Cursed.\r\n" +
			    "\t1-2) New and old gods alike hear you. Each investigator gains 1 Stamina and 1 Sanity, but add 1 doom counter to the doom track.\r\n" +
			    "\t3+) Hope is rekindled. You gain 2 Sanity, and each investigator may make a Will (-2) check in order to be Blessed.");
			putEncounter(db, cv, locName, locID, "The morning sun shines through the stained-glass windows, warming your spirit. Gain Sanity equal to the number of locations with sealed gates. ");
			putEncounter(db, cv, locName, locID, "You stumble through the doors, desperately seeking peace. But then you realize that the powers you face care nothing for morals, or hope, or humanity. Lose an amount of Sanity equal to the number of gates currently open. ");

		}
		if (locName =="St. Mary's Hospital")
		{
			putEncounter(db, cv, locName, locID, "The waiting room is filled with people complaining about a cough they've developed from a strange dust in the air. If you interview them, pass a Fight (-1) check to gain 2 Clue tokens. If you fail, you develop the cough yourself and can't stay in the area without hacking and choking; you are Barred from Uptown. ");
			putEncounter(db, cv, locName, locID, "A patient appears to be choking on something. But then, horribly, a swarm of locusts vomits forth from his mouth! If you flee, move to the street. If you stay to try to help him, the locusts burrow into your body. Lose 1 Stamina and 1 Sanity, but you may search the Spell deck for a Plague of Locusts spell and take it. ");
			putEncounter(db, cv, locName, locID, "A visiting scholar, Dr. Ali Kafour, gives a lecture on the preparatory procedures used to create mummies. If you watch the brain removal demonstration, make a Will (+0) check. For each success you roll, you may gain 1 Clue token; for every clue token you choose to gain, however, you must discard 1 Sanity. ");
			putEncounter(db, cv, locName, locID, "An old man who looks to be near death gestures you toward his bedside. If you approach, he tries to hand you something as his last breath gurgles out. Make a Speed (-1) check. If you pass, you catch the object; draw 1 Exhibit Item. If you fail, the ancient canopic jar shatters on the ground, and you are Cursed! ");
			putEncounter(db, cv, locName, locID, "You stumble upon an autopsy room and see something on the table that looks like a man... but with the head of an alligator! Pass a Lore (+1) check to gain 1 Clue token, then pass a Will (-1) check or lose 1 Sanity. ");
		}
		if (locName =="Woods")
		{
			putEncounter(db, cv, locName, locID, "It's not safe this close to the edge of town. You encounter all monsters currently in the Outskirts, in the order of your choice. If you successfully evade any monster, you may choose to move to the street and your turn ends. ");
			putEncounter(db, cv, locName, locID, "The Sheldon Gang needs someone to distribute the \"product\" from their hidden still. Make a Sneak (-1) check. If you fail, you are arrested. If you pass, you gain $3 and may search the Common Item deck for the Whiskey card and take it. ");
			putEncounter(db, cv, locName, locID, "You find the rotting body of a foreign grifter that followed the museum exhibit into town. Pass a Fight (-1) check or become nauseous and move to the street. If you pass, you find his wallet and gun nearby. Gain $2 and you may search the Common Item deck for the .45 Automatic card and take it. ");
			putEncounter(db, cv, locName, locID, "You see a man being pursued across by hideous half-human, half-bestial creatures. If you help him fight them off, lose 3 Stamina. Even if you are knocked unconscious, the man, David Packard, owes you his life and intends to pay his debt. Take his Ally card or, if it is not available, he gives you something \"for protection.\" You may search the Common Item deck for Dynamite and take it. ");
			putEncounter(db, cv, locName, locID, "You trip over a bloodstained axe that had lain hidden beneath a tangle of brush. If you pass a Luck (+1) check, it isn't too badly rusted: You may search the Common Item deck for the Axe card and take it.? ");

		}
		if (locName =="Ye Olde Magick Shoppe")
		{
			putEncounter(db, cv, locName, locID, "You peek into the back room and see Miriam Beecher, the shopkeeper, unwrapping a mummy stolen from the visiting museum exhibit! If you turn her in, the Sheriff rewards you with a license to investigate as you see fit; take the Private Investigator card. However, Miriam's neighbors think you betrayed her, and you are Barred from Uptown. ");
			putEncounter(db, cv, locName, locID, "A strange man roams the aisles looking desperately for something, muttering to himself. Make a Speed (-1) check, or he catches you watching him and attacks! Pass a Fight (+0) check to fend him off, or lose 1 Stamina. ");
			putEncounter(db, cv, locName, locID, "As you wait in line to buy something, a swindler with scars on his face and a strange accent gives you a wink, then steps in front of you and begins to distract the shopkeeper. If you leave without paying, draw 1 Exhibit Item or Unique Item, but you are Cursed. ");
			putEncounter(db, cv, locName, locID, "Water damage! In order to unload damaged books, the shop is holding a sale. For every $1 you pay, you may draw 1 Unique Item. You may keep any Tomes that you draw, and must discard the rest. You must pay the total up front, before you draw. ");
			putEncounter(db, cv, locName, locID, "With the \"Legacy of the Pharaohs\" exhibit in town, folks are crazy for faux-Egyptian trinkets. Pay $3 if you'd like to buy one, then make a Luck (-1) check. If you pass, it's actually a real item! Draw 1 Exhibit Item or Unique Item. ");
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
		*/
//	}

	private static long insertLocation(SQLiteDatabase db, ContentValues cv,
			String locName, long neiID) 
	{
		cv.put(DatabaseHelper.locName, locName);
		cv.put(DatabaseHelper.locNeiID, neiID);
		
		long locID = db.insert(DatabaseHelper.locTable, DatabaseHelper.locID, cv);
		locationIDs.put(locName, locID);
		return locID;
	}

	private static long insertNeighborhood(SQLiteDatabase db, ContentValues cv, String neiName, long expID) 
	{
		cv.put(DatabaseHelper.neiName, neiName);
		cv.put(DatabaseHelper.neiExpID, expID);
		long neiID = db.insert(DatabaseHelper.neighborhoodTable, DatabaseHelper.neiID, cv);
		
		neighborIDs.put(neiName, neiID);
		return neiID;
	}

	public static void FetchExpansion(SQLiteDatabase db) 
	{
//		ContentValues cv=new ContentValues();
//		cv.put(DatabaseHelper.expName, "Base");
//		db.insert(DatabaseHelper.expTable, DatabaseHelper.expID, cv);
//		
//		cv.put(DatabaseHelper.expName, "Curse of the Dark Pharoah");
//		db.insert(DatabaseHelper.expTable, DatabaseHelper.expID, cv);
		
		String sqlInsert = "INSERT INTO " + DatabaseHelper.expTable + " (" + DatabaseHelper.expID + "," + DatabaseHelper.expName + ") VALUES ";//+
		   
		db.execSQL(sqlInsert + " (1, \"Base\")");
		db.execSQL(sqlInsert + " (2,\"Curse of the Dark Pharoah\")");
		db.execSQL(sqlInsert + " (3,\"Dunwich Horror\")");
		db.execSQL(sqlInsert + " (4,\"The King in Yellow\")");
		db.execSQL(sqlInsert + " (5,\"Kingsport Horror\")");
		db.execSQL(sqlInsert + " (6,\"Black Goat of the Woods\")");
		db.execSQL(sqlInsert + " (7,\"Innsmouth Horror\")");
		db.execSQL(sqlInsert + " (8,\"Lurker at the Threshold\")");
		db.execSQL(sqlInsert + " (9,\"Curse of the Dark Pharoah Revised\")");
		db.execSQL(sqlInsert + " (10,\"Miskatonic Horror\")");	
	}
	
	public static void FetchNeighborhoods(SQLiteDatabase db)
	{
		
		String sqlInsert = "INSERT INTO " + DatabaseHelper.neighborhoodTable + " (" + DatabaseHelper.neiID + "," + DatabaseHelper.neiExpID + "," + DatabaseHelper.neiName + "," + DatabaseHelper.neiCardPath + ") VALUES ";//+	

		//Base	
		db.execSQL(sqlInsert + " (1,1,\"Downtown\",\"encounter/encounter_front_downtown.png\")");	
		db.execSQL(sqlInsert + " (2,1,\"Easttown\",\"encounter/encounter_front_easttown.png\")");	
		db.execSQL(sqlInsert + " (3,1,\"French Hill\",\"encounter/encounter_front_frenchhill.png\")");	
		db.execSQL(sqlInsert + " (4,1,\"Merchant District\",\"encounter/encounter_front_merchant.png\")");	
		db.execSQL(sqlInsert + " (5,1,\"Miskatonic University\",\"encounter/encounter_front_miskatonic.png\")");	
		db.execSQL(sqlInsert + " (6,1,\"Northside\",\"encounter/encounter_front_northside.png\")");	
		db.execSQL(sqlInsert + " (7,1,\"Rivertown\",\"encounter/encounter_front_rivertown.png\")");	
		db.execSQL(sqlInsert + " (8,1,\"Southside\",\"encounter/encounter_front_southside.png\")");	
		db.execSQL(sqlInsert + " (9,1,\"Uptown\",\"encounter/encounter_front_uptown.png\")");	
		
		//Dunwich
		db.execSQL(sqlInsert + " (10,3,\"Backwoods Country\",\"encounter/encounter_front_backwoods.png\")");	
		db.execSQL(sqlInsert + " (11,3,\"Blasted Heath\",\"encounter/encounter_front_blasted.png\")");	
		db.execSQL(sqlInsert + " (12,3,\"Village Commons\",\"encounter/encounter_front_village.png\")");	

		//Kingsport
		db.execSQL(sqlInsert + " (13,5,\"Central Hill\",\"encounter/encounter_front_central.png\")");	
		db.execSQL(sqlInsert + " (14,5,\"Harborside\",\"encounter/encounter_front_harborside.png\")");	
		db.execSQL(sqlInsert + " (15,5,\"Kingsport Head\",\"encounter/encounter_front_kingsport.png\")");	
		db.execSQL(sqlInsert + " (16,5,\"South Shore\",\"encounter/encounter_front_south.png\")");	

		//Innsmouth	
		db.execSQL(sqlInsert + " (17,7,\"Church Green\",\"encounter/encounter_front_church.png\")");	
		db.execSQL(sqlInsert + " (18,7,\"Factory District\",\"encounter/encounter_front_factory.png\")");	
		db.execSQL(sqlInsert + " (19,7,\"Innsmouth Shore\",\"encounter/encounter_front_innsmouth.png\")");	
	}
	
	public static void FetchLocations(SQLiteDatabase db)
	{
		
		String sqlInsert = "INSERT INTO " + DatabaseHelper.locTable + " (" + DatabaseHelper.locID + "," + DatabaseHelper.locName + "," + DatabaseHelper.locNeiID + ") VALUES ";//+
		
		db.execSQL(sqlInsert + " (1,\"Administration Building\",5)");
		db.execSQL(sqlInsert + " (2,\"Arkham Asylum\",1)");
		db.execSQL(sqlInsert + " (3,\"Bank of Arkham\",1)");
		db.execSQL(sqlInsert + " (4,\"Black Cave\",7)");
		db.execSQL(sqlInsert + " (5,\"Curiositie Shoppe\",6)");
		db.execSQL(sqlInsert + " (6,\"General Store\",7)");
		db.execSQL(sqlInsert + " (7,\"Graveyard\",7)");
		db.execSQL(sqlInsert + " (8,\"Hibb's Roadhouse\",2)");
		db.execSQL(sqlInsert + " (9,\"Historical Society\",8)");
		db.execSQL(sqlInsert + " (10,\"Independence Square\",1)");
		db.execSQL(sqlInsert + " (11,\"Inner Sanctum\",3)");
		db.execSQL(sqlInsert + " (12,\"Library\",5)");
		db.execSQL(sqlInsert + " (13,\"Ma's Boarding House\",8)");
		db.execSQL(sqlInsert + " (14,\"Newspaper\",6)");
		db.execSQL(sqlInsert + " (15,\"Police Station\",2)");
		db.execSQL(sqlInsert + " (16,\"River Docks\",4)");
		db.execSQL(sqlInsert + " (17,\"Science Building\",5)");
		db.execSQL(sqlInsert + " (18,\"Silver Twilight Lodge\",3)");
		db.execSQL(sqlInsert + " (19,\"South Church\",8)");
		db.execSQL(sqlInsert + " (20,\"Cold Spring Glen\",10)");
		db.execSQL(sqlInsert + " (21,\"St. Mary's Hospital\",9)");
		db.execSQL(sqlInsert + " (22,\"The Unnamable\",4)");
		db.execSQL(sqlInsert + " (23,\"The Witch House\",3)");
		db.execSQL(sqlInsert + " (24,\"Train Station\",6)");
		db.execSQL(sqlInsert + " (25,\"Unvisited Isle\",4)");
		db.execSQL(sqlInsert + " (26,\"Velma's Diner\",2)");
		db.execSQL(sqlInsert + " (27,\"Woods\",9)");
		db.execSQL(sqlInsert + " (28,\"Ye Olde Magick Shoppe\",9)");
		db.execSQL(sqlInsert + " (29,\"Bishop's Brook Bridge\",12)");
		db.execSQL(sqlInsert + " (30,\"Darke's Carnival\",12)");
		db.execSQL(sqlInsert + " (31,\"Devil's Hopyard\",11)");
		db.execSQL(sqlInsert + " (32,\"Dunwich Village\",12)");
		db.execSQL(sqlInsert + " (33,\"Gardners' Place\",11)");
		db.execSQL(sqlInsert + " (34,\"Harney Jones' Shack\",11)");
		db.execSQL(sqlInsert + " (35,\"Whateley Farm\",10)");
		db.execSQL(sqlInsert + " (36,\"Wizard's Hill\",10)");
		db.execSQL(sqlInsert + " (37,\"607 Water St.\",14)");
		db.execSQL(sqlInsert + " (38,\"7th House on the Left\",13)");
		db.execSQL(sqlInsert + " (39,\"Artists' Colony\",16)");
		db.execSQL(sqlInsert + " (40,\"Congregational Hospital\",13)");
		db.execSQL(sqlInsert + " (41,\"Hall School\",16)");
		db.execSQL(sqlInsert + " (42,\"Neil's Curiosity Shop\",16)");
		db.execSQL(sqlInsert + " (43,\"North Point Lighthouse\",14)");
		db.execSQL(sqlInsert + " (44,\"St. Erasmus's Home\",13)");
		db.execSQL(sqlInsert + " (45,\"Strange High House\",15)");
		db.execSQL(sqlInsert + " (46,\"The Causeway\",15)");
		db.execSQL(sqlInsert + " (47,\"The Rope and Anchor\",14)");
		db.execSQL(sqlInsert + " (48,\"Wireless Station\",15)");
		db.execSQL(sqlInsert + " (49,\"Devil Reef\",19)");
		db.execSQL(sqlInsert + " (51,\"Esoteric Order of Dagon\",17)");
		db.execSQL(sqlInsert + " (52,\"Falcon Point\",19)");
		db.execSQL(sqlInsert + " (53,\"First National Grocery\",18)");
		db.execSQL(sqlInsert + " (54,\"Gilman House Hotel\",18)");
		db.execSQL(sqlInsert + " (55,\"Innsmouth Jail\",17)");
		db.execSQL(sqlInsert + " (56,\"Jail Cell\",17)");
		db.execSQL(sqlInsert + " (57,\"Marsh Refinery\",18)");
		db.execSQL(sqlInsert + " (58,\"Y'ha-nthlei\",19)");   
	}
	
	public static void FetchEncounters(SQLiteDatabase db)
	{
		String sqlInsertCard = "INSERT INTO " + DatabaseHelper.cardTable + " (" + DatabaseHelper.cardID + "," + DatabaseHelper.cardNeiID + "," + DatabaseHelper.cardExpID + ") VALUES ";//+
		String sqlInsertCardEnc = "INSERT INTO " + DatabaseHelper.cardToEncTable + " (" + DatabaseHelper.cardToEncCardID + "," + DatabaseHelper.cardToEncEncID + ") VALUES ";//+
		String sqlInsertEnc = "INSERT INTO " + DatabaseHelper.encounterTable + " (" + DatabaseHelper.encID + "," + DatabaseHelper.encLocID + "," + DatabaseHelper.encText + ") VALUES ";//+
		
		FetchDowntownEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);

		FetchEasttownEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);

		FetchFrenchHillEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);
		
		FetchMerchantEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);

		FetchMiskatonicEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);

		FetchNorthsideEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);
		
		FetchSouthsideEncounters(db, sqlInsertCard, sqlInsertCardEnc,
				sqlInsertEnc);


	}

	private static void FetchSouthsideEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		db.execSQL(sqlInsertCard + " (-39,8,9)");
		db.execSQL(sqlInsertCardEnc + " (-39,793)");
		db.execSQL(sqlInsertEnc + " (793,9,'You find a cipher for interpreting old texts and hieroglyphics! You may immediately use any <i><b>Tome</b></i> or other item that requires an expenditure of movement points to use.')");
		db.execSQL(sqlInsertCardEnc + " (-39,794)");
		db.execSQL(sqlInsertEnc + " (794,13,'Your room''s last occupant left a small shrine to Osiris. Make a <b>Luck (+0) check</b>. If you pass, a monster appears. If you fail, a monster appears and you must take the Harried card.')");
		db.execSQL(sqlInsertCardEnc + " (-39,795)");
		db.execSQL(sqlInsertEnc + " (795,19,'\"Pray for Arkham, my son.\" Make a <b>Will (-2) check</b> and consult the chart below:<br /><br />Successes:<br />0) The Dark Pharaoh hears your prayer. Each investigator must make a <b>Will (-2) check</b> or be <i>Cursed</i>. <br />1-2) New and old gods alike hear you. Each investigator gains 1 Stamina and 1 Sanity, but add 1 doom counter to the doom track.<br />3+) Hope is rekindled. You gain 2 Sanity, and each investigator may make a <b>Will (-2) check</b> in order to be <i>Blessed</i>.')");
		db.execSQL(sqlInsertCard + " (-38,8,9)");
		db.execSQL(sqlInsertCardEnc + " (-38,796)");
		db.execSQL(sqlInsertEnc + " (796,9,'Make a <b>Lore (-1) check</b> to dig up inspirational travel journals penned by residents of Arkham who traveled to the mysterious and dangerous Nile. If you pass, you may search the Skill deck and take the Bravery card.')");
		db.execSQL(sqlInsertCardEnc + " (-38,797)");
		db.execSQL(sqlInsertEnc + " (797,13,'You''re invited to a midnight s\u00E9ance. If you attend, you may commune with the spirit realm: look at the top 2 cards of the Mythos deck and replace them, facedown, in any order you like. However, Ma Mathison breaks up the s\u00E9ance and says, \"Yew devil worshippers better not come round no more!\" Place a Patrol marker on the street area of Southside.')");
		db.execSQL(sqlInsertCardEnc + " (-38,798)");
		db.execSQL(sqlInsertEnc + " (798,19,'If you have any Exhibit Items, Father Michael calls them profane works and demands that you destroy them. If you refuse, place a Patrol marker on the street area of Southside. If you agree, you gain 1 Sanity and 1 Clue token per item discarded.')");
		db.execSQL(sqlInsertCard + " (-37,8,9)");
		db.execSQL(sqlInsertCardEnc + " (-37,799)");
		db.execSQL(sqlInsertEnc + " (799,9,'A past-life believer offers to channel the spirits of the ancients. You may join in and make a <b>Will (+0) check</b> to draw Spells until you draw one with a Sanity cost of 0; keep that Spell and discard the rest. Alternatively, you may watch her technique, and make a <b> Luck (-1) check</b>. If you pass, you may take the Psychic card.')");
		db.execSQL(sqlInsertCardEnc + " (-37,800)");
		db.execSQL(sqlInsertEnc + " (800,13,'Ma Mathison offers board as well as room; the bigger the boarder, the bigger the lunch. Search the Common Item deck and take the Food card. Then make a <b>Fight (-1) check</b>. For each success, you may place a token on the Food card; when you use the Food, you may discard the token instead of discarding the card.')");
		db.execSQL(sqlInsertCardEnc + " (-37,801)");
		db.execSQL(sqlInsertEnc + " (801,19,'You stumble through the doors, desperately seeking peace. But then you realize that the powers you face care nothing for morals, or hope, or humanity. Lose an amount of Sanity equal to the number of gates currently open.')");
		db.execSQL(sqlInsertCard + " (-36,8,9)");
		db.execSQL(sqlInsertCardEnc + " (-36,802)");
		db.execSQL(sqlInsertEnc + " (802,9,'You find a painting of your grandparents wearing strange occult pendants. You may search the Skill deck for the Expert Occultist or Lore card and take it, but if you do so you must also take the Tainted card.')");
		db.execSQL(sqlInsertCardEnc + " (-36,803)");
		db.execSQL(sqlInsertEnc + " (803,13,'You ambush several monsters emerging from a secret tunnel! Make a <b>Sneak (-2) check</b> and consult the table below.<br /><br />Successes:<br />0) Three monsters appear!<br />1) Draw 1 monster trophy from the cup, but 2 monsters appear!<br />2) Draw 2 monster trophies from the cup, but 1 monster appears!<br />3+) You tear aside the sub-window''s curtain, revealing the dawn''s light and all of the monsters disintegrate! Draw 3 monster trophies from the cup.')");
		db.execSQL(sqlInsertCardEnc + " (-36,804)");
		db.execSQL(sqlInsertEnc + " (804,19,'The morning sun shines through the stained-glass windows, warming your spirit. Gain Sanity equal to the number of locations with sealed gates.')");
		db.execSQL(sqlInsertCard + " (-35,8,9)");
		db.execSQL(sqlInsertCardEnc + " (-35,805)");
		db.execSQL(sqlInsertEnc + " (805,9,'A weary old man holds out a stack of paper and says \"It''s a memoir of my travels along the Nile, but I doubt the world will last long enough for it to be published.\" If you wish to read it, remain here next turn and make a <b>Will (+0) check</b>. You may draw cards from the Skill deck equal to your number of successes, and may keep one of them.')");
		db.execSQL(sqlInsertCardEnc + " (-35,806)");
		db.execSQL(sqlInsertEnc + " (806,13,'The gable room faces east and brings in clean air from the sea. You gain 1 Stamina immediately, and may stay here next turn in order to gain an additional 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (-35,807)");
		db.execSQL(sqlInsertEnc + " (807,19,'\"Father Michael?\" You look into the back office, and see the priest being assaulted by a demonic servitor of Horus! If you have a Cross, Holy Water, or Blessing card, you drive it off. Father Michael is shaken, and asks you to assist in running the church while he atones. If you drove off the being, you may take the Anointed card.')");
		db.execSQL(sqlInsertCard + " (232,8,3)");
		db.execSQL(sqlInsertCardEnc + " (232,808)");
		db.execSQL(sqlInsertEnc + " (808,9,'One of the Society members is heading over to the library to do some research and offers you a ride. If you accept, move to the Library and draw 2 cards, encountering one card of your choice and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (232,809)");
		db.execSQL(sqlInsertEnc + " (809,13,'Deputy Dingby stops by Ma''s for breakfast. This is, as you might guess, an unmitigated disaster. After Ma shoos him out of her kitchen, everyone pitches in to help her clean up the mess. Stay here next turn.')");
		db.execSQL(sqlInsertCardEnc + " (232,810)");
		db.execSQL(sqlInsertEnc + " (810,19,'Make a <b>Luck (-2) check</b>. If you pass, then you stare up at the stained glass windows, see the light shining in through them, and realize that your troubles aren''t as bad as you thought they were. All investigators who are <i>Cursed</i> may discard their Curse cards.')");
		db.execSQL(sqlInsertCard + " (233,8,3)");
		db.execSQL(sqlInsertCardEnc + " (233,811)");
		db.execSQL(sqlInsertEnc + " (811,9,'You encounter a friendly old professor from Miskatonic University. If you spend 1 gate trophy, he introduces himself as <b>Professor Armitage</b> and offers to join forces with you. Take his Ally card if it is available, otherwise draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (233,812)");
		db.execSQL(sqlInsertEnc + " (812,13,'\"Jazz\" Mulligan, the head janitor from the college comes for some of Ma''s famous apple pie. While he''s visiting, he demonstrates how he got his nickname by playing some soulful blues on his harmonica. Gain 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (233,813)");
		db.execSQL(sqlInsertEnc + " (813,19,'Reading one of the bibles in the pews, you seek spiritual guidance. Letting it fall open to a page, you read, \"The Lord helps those who help themselves.\" Oddly, it makes you feel better. You may spend 2 Clue tokens to discard the current <i><b>Environment</b></i> from play.')");
		db.execSQL(sqlInsertCard + " (234,8,3)");
		db.execSQL(sqlInsertCardEnc + " (234,814)");
		db.execSQL(sqlInsertEnc + " (814,9,'You attempt to get some first-hand accounts of Arkham history from some of the older members of the society. Make a <b>Luck (-1) check</b>. If you pass, you''re able to glean several vital facts from their stories. Gain 1 Clue token. Whether you fail or not, stay here next turn.')");
		db.execSQL(sqlInsertCardEnc + " (234,815)");
		db.execSQL(sqlInsertEnc + " (815,13,'Oliver Thomas, the owner of the Curiositie Shoppe, stops by with a gift for Ma. \"Landsakes, what do I need with more knickknacks? Here, you give it someone who can actually use it!\" Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (234,816)");
		db.execSQL(sqlInsertEnc + " (816,19,'Knowing that you are engaged in God''s work, Father Michael <i>Blesses</i> you.')");
		db.execSQL(sqlInsertCard + " (235,8,3)");
		db.execSQL(sqlInsertCardEnc + " (235,817)");
		db.execSQL(sqlInsertEnc + " (817,9,'A monster appears and attacks you as you approach the front door!')");
		db.execSQL(sqlInsertCardEnc + " (235,818)");
		db.execSQL(sqlInsertEnc + " (818,13,'Joey \"the Rat\" waves to you from the side of the house. \"I''ve got some information you might be interested in. Only $4.\" You may pay $4 to gain 2 Clue tokens \"Hey, info like this don''t come cheap, ya know!\"')");
		db.execSQL(sqlInsertCardEnc + " (235,819)");
		db.execSQL(sqlInsertEnc + " (819,19,'Kneeling in one of the pews to pray, you come across an unusual book. Take the first <i><b>Tome</b></i> from the Unique Item deck.')");
		db.execSQL(sqlInsertCard + " (236,8,3)");
		db.execSQL(sqlInsertCardEnc + " (236,820)");
		db.execSQL(sqlInsertEnc + " (820,9,'You find a book with two of its pages stuck together. Pass a <b>Luck (-1) check</b> to pull them apart without damaging them. Between the two pages is a magical incantation. Draw 1 Spell. If you fail the check, you tear the pages and ruin the incantation.')");
		db.execSQL(sqlInsertCardEnc + " (236,821)");
		db.execSQL(sqlInsertEnc + " (821,13,'Abigail Foreman drops in for tea with Ma. You are invited to sit in as well. If you accept, gain 1 Stamina and 1 Clue token, and stay here next turn as you attend the tea party.')");
		db.execSQL(sqlInsertCardEnc + " (236,822)");
		db.execSQL(sqlInsertEnc + " (822,19,'Father Michael talks with you for a little while about your doubts and fears. You come away from the talk feeling a lot better than you did before. Gain 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (237,8,3)");
		db.execSQL(sqlInsertCardEnc + " (237,823)");
		db.execSQL(sqlInsertEnc + " (823,9,'Make a <b>Luck (-2) check</b>. If you pass, then while paging through the historical records, you come across a piece of information that makes everything come together for you. If you have fewer than 5 Clue tokens, gain enough Clue tokens to bring your total up to 5. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (237,824)");
		db.execSQL(sqlInsertEnc + " (824,13,'Zebulon Whateley visits from Dunwich to bring Ma a tonic for her cough. In addition, if your <b>Lore</b> is currently 4 or more, he takes you aside and teaches you a spell. Draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (237,825)");
		db.execSQL(sqlInsertEnc + " (825,19,'Stumbling into the church, you look up in horror to realize that you''ve just interrupted someone''s funeral. Stammering an apology, you move to the street.')");
		db.execSQL(sqlInsertCard + " (238,8,3)");
		db.execSQL(sqlInsertCardEnc + " (238,826)");
		db.execSQL(sqlInsertEnc + " (826,9,'Weary of your travels, you lean back in one of the comfortable chairs for a while and rest. Gain 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (238,827)");
		db.execSQL(sqlInsertEnc + " (827,13,'Sheriff Engle comes by to see his dear old mother and Ma cooks up a huge mess of grub for everybody. Gain 1 Sanity and 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (238,828)");
		db.execSQL(sqlInsertEnc + " (828,19,'Exhausted and drained, you sit and listen to the choir for a while. Their beautiful singing helps get you back on your feet. Perhaps there''s no meaning to the universe, but then again, perhaps we give it our own meaning. Gain 2 Stamina and 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (239,8,4)");
		db.execSQL(sqlInsertCardEnc + " (239,829)");
		db.execSQL(sqlInsertEnc + " (829,9,'An actor from \"The King in Yellow\" leads a theater course. It''s amazing what skills an actor needs to master in order to look like the real thing. Pass a <b>Will (-2) check</b> to draw Skill cards equal to the number of successes rolled. Keep one, and discard the rest. If you fail, you learn something you wish you hadn''t in the theater exercises, and are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (239,830)");
		db.execSQL(sqlInsertEnc + " (830,13,'You wake up to find your bed burning! Pass a <b>Speed (+0) check</b> to escape. If you fail, you are <i>lost in time and space</i>. In any event, there is no sign of the fire afterwards.')");
		db.execSQL(sqlInsertCardEnc + " (239,831)");
		db.execSQL(sqlInsertEnc + " (831,19,'\"A strong soul must be willing to make sacrifices,\" Father Michael says. You may discard a single beneficial Investigator card (a Spell, Item, Ally, etc.) to make a <b>Luck (+1) check</b>. If you pass, you are restored to full Sanity. If you fail, you gain only 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (240,8,4)");
		db.execSQL(sqlInsertCardEnc + " (240,832)");
		db.execSQL(sqlInsertEnc + " (832,9,'The Historical Society is holding more educational discussion groups than normal, thanks to the buzz of the \"King in Yellow\" performances. Make a <b>(+0) check</b> in your lowest current skill. If you pass, draw 1 Skill.')");
		db.execSQL(sqlInsertCardEnc + " (240,833)");
		db.execSQL(sqlInsertEnc + " (833,13,'Ma Mathison offers you a free night''s stay so that she doesn''t have open rooms in case \"one o'' them actor types looks to board here.\" You regain 1 Stamina, but pass a <b>Luck (-1) check</b> or you lose 1 Sanity due to bad dreams.')");
		db.execSQL(sqlInsertCardEnc + " (240,834)");
		db.execSQL(sqlInsertEnc + " (834,19,'An esteemed organist from the Church of St. Barnabe in France has been haunting South Church, disturbing the flock with his otherworldly playing. Father Michael asks you to convince him to leave. Pass a <b>Fight (-2) check</b> to intimidate him into leaving and gain 2 Sanity. If you fail, he troubles your dreams, and you are reduced to 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (241,8,4)");
		db.execSQL(sqlInsertCardEnc + " (241,835)");
		db.execSQL(sqlInsertEnc + " (835,9,'A retired actor, once the favorite of European theater, gestures to you. \"Take this, my young friend,\" he says. \"You''ll need it against what''s coming.\" He hands  you a collection of news articles regarding the run of \"The King in Yellow\" in Paris. Pass a <b>Lore (-1) check</b> to sense an arcane pattern to them and draw a Spell. If you fail, you must discard 2 Clue tokens, if able.')");
		db.execSQL(sqlInsertCardEnc + " (241,836)");
		db.execSQL(sqlInsertEnc + " (836,13,'Ma Mathison comments that you look pallid, and suggests some yard work to get you feeling fit. Pass a <b>Sneak (-1) check</b> to sneak a nap in the shed instead and gain 2 Stamina. If you fail, lose 1 Stamina from Ma''s \"tough love\" prescription.')");
		db.execSQL(sqlInsertCardEnc + " (241,837)");
		db.execSQL(sqlInsertEnc + " (837,19,'A man attacks Father Michael as he tends to the grounds! Pass a <b>Fight (-1) check</b> to drive the man off. If you fail, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (242,8,4)");
		db.execSQL(sqlInsertCardEnc + " (242,838)");
		db.execSQL(sqlInsertEnc + " (838,9,'The society''s latest treasure, an ancient cask from Europe, is not altogether harmless. A monster appears when it is opened, attacking you. If you pass a <b>Combat check</b> against the monster, you find it was entombed with an ancient scroll. Draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (242,839)");
		db.execSQL(sqlInsertEnc + " (839,13,'You black out somewhere in Southside and wake up to find yourself in the Boarding House. Regain 1 Stamina, then make a <b>Fight (+1) check</b>. If you fail, you regain another Stamina, but you fall back asleep and are <i>delayed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (242,840)");
		db.execSQL(sqlInsertEnc + " (840,19,'You admire a new stained-glass window from the pews, but if you could peer directly through it, how illuminated life would seem! Make a <b>Fight (-2) check</b> to climb up to it safely. If you pass, gain 1 Sanity. If you fail. lose 2 Stamina.')");
		db.execSQL(sqlInsertCard + " (243,8,6)");
		db.execSQL(sqlInsertCardEnc + " (243,841)");
		db.execSQL(sqlInsertEnc + " (841,9,'A monster appears and attacks you as you approach the front door!')");
		db.execSQL(sqlInsertCardEnc + " (243,842)");
		db.execSQL(sqlInsertEnc + " (842,13,'Ma sends you up to tell Mr. Ahrens that supper is ready. His door is ajar and as you push it open, you find that he has tied a noose to the rafters and taken his own life. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (243,843)");
		db.execSQL(sqlInsertEnc + " (843,19,'A terrified young man staggers into the church seeking sanctuary. He tries to explain what has traumatized him, but it is difficult to interpret his ravings. Pass a <b>Lore (-1) check</b> to gain 1 Clue token.')");
		db.execSQL(sqlInsertCard + " (244,8,6)");
		db.execSQL(sqlInsertCardEnc + " (244,844)");
		db.execSQL(sqlInsertEnc + " (844,9,'A large stone disc is on display which bears ancient pictograms. As you examine it, the room seems to fill with whispering voices. Pass a <b>Will (-1) check</b> to resist being overcome by its power or you are <i>lost in time and space</i>.')");
		db.execSQL(sqlInsertCardEnc + " (244,845)");
		db.execSQL(sqlInsertEnc + " (845,13,'You recognize the man asking after a room as a wanted murderer. Pass a <b>Speed (-2) check</b> to stop him from getting away and to collect a $5 reward from the police. If you fail, he fights his way free and you lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (244,846)");
		db.execSQL(sqlInsertEnc + " (846,19,'You light a candle in prayers for those souls believed to be lost. You may choose one Ally card that has been returned to the box and reshuffle it back into the Ally deck. If no Ally cards have been returned to the box, gain 1 Sanity instead.')");
		db.execSQL(sqlInsertCard + " (245,8,6)");
		db.execSQL(sqlInsertCardEnc + " (245,847)");
		db.execSQL(sqlInsertEnc + " (847,9,'A representative of the society is visiting a historic Arkham home to pick up old photos of the neighborhoods and invites you to tag along. If you accept, move to the Unnamable and draw 2 cards, encountering one card of your choice and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (245,848)");
		db.execSQL(sqlInsertEnc + " (848,13,'Ma asks you to give her a hand moving a piano into the house. If you agree to help, make a <b>Fight (-1) check</b>. If you pass, Ma gratefully tucks $3 into your pocket. If you fail, you lose 1 Stamina and are <i>delayed</i> by the frustrating struggle.')");
		db.execSQL(sqlInsertCardEnc + " (245,849)");
		db.execSQL(sqlInsertEnc + " (849,19,'The Cult of the Black Goat has vandalized the church, and Father Michael asks for your help in painting over the blasphemous graffiti and cleaning up the damage. If you wish to help, you are <i>delayed</i> by the effort, but Father Michael <i>Blesses</i> you for your hard work.')");
		db.execSQL(sqlInsertCard + " (246,8,6)");
		db.execSQL(sqlInsertCardEnc + " (246,850)");
		db.execSQL(sqlInsertEnc + " (850,9,'The diary of an early immigrant settler in Arkham mentions a band of pagans that resided in the Woods, worshipping a vile Black Goat. If you currently possess a \"One of the Thousand\" Cult Membership, gain 3 Clue tokens and lose 1 Sanity. If not, simply gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (246,851)");
		db.execSQL(sqlInsertEnc + " (851,13,'An elderly woman walks up to the porch and strikes up a conversation with you. She tells you that this had been her home during a very difficult time in her life. You spend the afternoon in nostalgic conversation about Arkham history. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (246,852)");
		db.execSQL(sqlInsertEnc + " (852,19,'The church is having a bake sale! Everything smells delicious. Spend $1 on treats to regain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (247,8,5)");
		db.execSQL(sqlInsertCardEnc + " (247,853)");
		db.execSQL(sqlInsertEnc + " (853,9,'Finding an unusual book, you read a spell from it. You may move any elder sign token on the board to any unsealed, unstable location. If there is a gate there, it is immediately sealed, and any monsters there are returned to the monster cup. If there are no elder sign tokens on he board, take a Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (247,854)");
		db.execSQL(sqlInsertEnc + " (854,13,'Ma''s is full to capacity this time of year. Although Ma is known to become cranky with those who steal away her business, you spend some time getting to know the guests, looking especially for those who might be of use in your investigation. You may become <i>Cursed</i> to draw a random Ally.')");
		db.execSQL(sqlInsertCardEnc + " (247,855)");
		db.execSQL(sqlInsertEnc + " (855,19,'Father Michael is impressed by your conviction in the fight against the rising evil. You are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCard + " (248,8,5)");
		db.execSQL(sqlInsertCardEnc + " (248,856)");
		db.execSQL(sqlInsertEnc + " (856,9,'You admire the artifacts donated to the Society over the years. One in particular catches your attention, and as you examine it, your hairs prickle. If there are three or fewer elder sign tokens on the board, draw a Skill. If there are four or more, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (248,857)");
		db.execSQL(sqlInsertEnc + " (857,13,'A reporter staying at Ma''s announces that he will pay handsomely for tales of the macabre. Take $1 for every elder sign token on the board as you relate your exploits.')");
		db.execSQL(sqlInsertCardEnc + " (248,858)");
		db.execSQL(sqlInsertEnc + " (858,19,'Father Michael, sensing that some evil may be afflicting you without your knowledge, suddenly submerges your head in the font of holy water. Make a <b>Luck (-1) check</b>. If you succeed, restore your Sanity to its maximum. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (249,8,5)");
		db.execSQL(sqlInsertCardEnc + " (249,859)");
		db.execSQL(sqlInsertEnc + " (859,9,'A white-haired professor offers to help you if you can prove the legitimacy of your mission. You may spend a gate trophy to take <b>Professor Armitage''s</b> Ally card, or, if it''s not available, draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (249,860)");
		db.execSQL(sqlInsertEnc + " (860,13,'It is dinner time, and Ma has spread all the fixings. You resist the urge to sit down and have a meal, but the same can''t be said of the rest of your party. If you have an Ally, discard it. Fortunately, another willing soul finds the prospect of helping you out exciting. Draw a random Ally. If the Ally deck is empty, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (249,861)");
		db.execSQL(sqlInsertEnc + " (861,19,'Father Michael directs you to the box for donations and tells you to take what you need. Take $2 or draw a Common Item.')");
		db.execSQL(sqlInsertCard + " (250,8,2)");
		db.execSQL(sqlInsertCardEnc + " (250,862)");
		db.execSQL(sqlInsertEnc + " (862,9,'A weary old man holds out a stack of paper and says \"It''s a memoir of my travels along the Nile, but I doubt the world will last long enough for it to be published.\" If you wish to read it, remain here next turn and make a <b>Will (+0) check</b>. You may draw cards from the Skill deck equal to your number of successes, and may keep one of them.')");
		db.execSQL(sqlInsertCardEnc + " (250,863)");
		db.execSQL(sqlInsertEnc + " (863,13,'The gable room faces east and brings in clean air from the sea. You gain 1 Stamina immediately, and may stay here next turn in order to gain an additional 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (250,864)");
		db.execSQL(sqlInsertEnc + " (864,19,'\"Father Michael?\" You look into the back office, and see the priest being assaulted by a demonic servitor of Horus! If you have a Cross, Holy Water, or Blessing card, you drive it off. Father Michael is shaken, and asks you to assist in running the church while he atones. If you drove off the being, you may take the Anointed card.')");
		db.execSQL(sqlInsertCard + " (251,8,2)");
		db.execSQL(sqlInsertCardEnc + " (251,865)");
		db.execSQL(sqlInsertEnc + " (865,9,'You find a painting of your grandparents wearing strange occult pendants. You may search the Skill deck for the Expert Occultist or Lore card and take it, but if you do so you must also take the Tainted card.')");
		db.execSQL(sqlInsertCardEnc + " (251,866)");
		db.execSQL(sqlInsertEnc + " (866,13,'You ambush several monsters emerging from a secret tunnel! Make a <b>Sneak (-2) check</b> and consult the table below.<br /><br />Successes:<br />0) Three monsters appear!<br />1) Draw 1 monster trophy from the cup, but 2 monsters appear!<br />2) Draw 2 monster trophies from the cup, but 1 monster appears!<br />3+) You tear aside the sub-window''s curtain, revealing the dawn''s light and all of the monsters disintegrate! Draw 3 monster trophies from the cup.')");
		db.execSQL(sqlInsertCardEnc + " (251,867)");
		db.execSQL(sqlInsertEnc + " (867,19,'The morning sun shines through the stained-glass windows, warming your spirit. Gain Sanity equal to the number of locations with sealed gates.')");
		db.execSQL(sqlInsertCard + " (252,8,2)");
		db.execSQL(sqlInsertCardEnc + " (252,868)");
		db.execSQL(sqlInsertEnc + " (868,9,'A past-life believer offers to channel the spirits of the ancients. You may join in and make a <b>Will (+0) check</b> to draw Spells until you draw one with a Sanity cost of 0; keep that Spell and discard the rest. Alternatively, you may watch her technique, and make a <b> Luck (-1) check</b>. If you pass, you may take the Psychic card.')");
		db.execSQL(sqlInsertCardEnc + " (252,869)");
		db.execSQL(sqlInsertEnc + " (869,13,'Ma Mathison offers board as well as room; the bigger the boarder, the bigger the lunch. Search the Common Item deck and take the Food card. Then make a <b>Fight (-1) check</b>. For each success, you may place a token on the Food card; when you use the Food, you may discard the token instead of discarding the card.')");
		db.execSQL(sqlInsertCardEnc + " (252,870)");
		db.execSQL(sqlInsertEnc + " (870,19,'You stumble through the doors, desperately seeking peace. But then you realize that the powers you face care nothing for morals, or hope, or humanity. Lose an amount of Sanity equal to the number of gates currently open.')");
		db.execSQL(sqlInsertCard + " (253,8,2)");
		db.execSQL(sqlInsertCardEnc + " (253,871)");
		db.execSQL(sqlInsertEnc + " (871,9,'Make a <b>Lore (-1) check</b> to dig up inspirational travel journals penned by residents of Arkham who traveled to the mysterious and dangerous Nile. If you pass, you may search the Skill deck and take the Bravery card.')");
		db.execSQL(sqlInsertCardEnc + " (253,872)");
		db.execSQL(sqlInsertEnc + " (872,13,'You''re invited to a midnight s\u00E9ance. If you attend, you may commune with the spirit realm: Look at the top two cards of the Mythos deck and replace them, facedown, in any order you like. However Ma Mathison breaks up the s\u00E9ance and says that \"yew devil worshippers better not come round no more!\" You are <i>Barred from Southside</i>.')");
		db.execSQL(sqlInsertCardEnc + " (253,873)");
		db.execSQL(sqlInsertEnc + " (873,19,'If you have any Exhibit Items, Father Michael calls them profane works and demands that you destroy them. If you refuse, you are <i>Barred from Southside</i>. If you agree, you gain 1 Sanity and 1 Clue token per item discarded.')");
		db.execSQL(sqlInsertCard + " (254,8,2)");
		db.execSQL(sqlInsertCardEnc + " (254,874)");
		db.execSQL(sqlInsertEnc + " (874,9,'You find a cipher for interpreting old texts and hieroglyphics! You may immediately use any <i><b>Tome</b></i> or other item that requires an expenditure of movement points to use.')");
		db.execSQL(sqlInsertCardEnc + " (254,875)");
		db.execSQL(sqlInsertEnc + " (875,13,'Your room''s last occupant left a small shrine to Osiris. Make a <b>Luck (+0) check</b>. If you pass, a monster appears. If you fail, a monster appears and you must take the Harried card.')");
		db.execSQL(sqlInsertCardEnc + " (254,876)");
		db.execSQL(sqlInsertEnc + " (876,19,'\"Pray for Arkham, my son.\" Make a <b>Will (-2) check</b> and consult the chart below:<br /><br />Successes:<br />0) The Dark Pharaoh hears your prayer. Each investigator must make a <b>Will (-2) check</b> or be <i>Cursed</i>. <br />1-2) New and old gods alike hear you. Each investigator gains 1 Stamina and 1 Sanity, but add 1 doom counter to the doom track.<br />3+) Hope is rekindled. You gain 2 Sanity, and each investigator may make a <b>Will (-2) check</b> in order to be <i>Blessed</i>.')");
		db.execSQL(sqlInsertCard + " (255,8,5)");
		db.execSQL(sqlInsertCardEnc + " (255,877)");
		db.execSQL(sqlInsertEnc + " (877,9,'When you arrive, you discover that the members of the Society are on their monthly outing to Independence Square. The janitor, who''s heading there shortly, offers to give you a lift. You may move to Independence Square and draw two cards, encountering one of your choice, and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (255,878)");
		db.execSQL(sqlInsertEnc + " (878,13,'It''s mystery meat Monday at Ma''s. As you walk into the kitchen, she shoves a spoonful of the unknown chow into your mouth and directs you to swallow. Make a <b>Luck (-1) check</b>. If you succeed, restore your Stamina to its maximum. If you fail, lose 1 Sanity, and your lunch.')");
		db.execSQL(sqlInsertCardEnc + " (255,879)");
		db.execSQL(sqlInsertEnc + " (879,19,'You touch the altar and a bright light flashes. Draw a mythos card and go to the gate location shown. Draw four location cards and choose one of them to encounter, discarding the others.')");
		db.execSQL(sqlInsertCard + " (256,8,1)");
		db.execSQL(sqlInsertCardEnc + " (256,880)");
		db.execSQL(sqlInsertEnc + " (880,9,'You meet Cindy Fleming, a young geology professor at the University. She offers to show you some interesting formations at the Black Cave. If you accept, move to the Black Cave and draw 2 cards, encountering one card of your choice and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (256,881)");
		db.execSQL(sqlInsertEnc + " (881,13,'Ma Mathison tells you that the best room on the house is available for the night. If you want, pay $3 to spend the night there. Gain 4 points split between Sanity and Stamina however you choose.')");
		db.execSQL(sqlInsertCardEnc + " (256,882)");
		db.execSQL(sqlInsertEnc + " (882,19,'Upon entering the church, you are attacked by Father Michael with a giant cross, who for some reason believes you to be in league with the devil. Make a <b>Speed (-1) check</b>. If you pass, you escape. If you fail, lose 2 Stamina. In either case, move to the street.')");
		db.execSQL(sqlInsertCard + " (257,8,1)");
		db.execSQL(sqlInsertCardEnc + " (257,883)");
		db.execSQL(sqlInsertEnc + " (883,9,'Pay  $3 fee to gain access to the private library. If you refuse, move to the street. If you pay, make a <b>Luck (-1) check</b>. If you pass, you learn an ancient spell from a dusty ledger. Draw 1 Spell. If you fail, you doze off and enter The Dreamlands. Have an encounter there, then immediately return here.')");
		db.execSQL(sqlInsertCardEnc + " (257,884)");
		db.execSQL(sqlInsertEnc + " (884,13,'You find a poorly boarded-up passage in the basement that opens into a winding tunnel. If you venture into it, you exit in the Silver Twilight Lodge. Draw 2 cards and encounter one card of your choice, discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (257,885)");
		db.execSQL(sqlInsertEnc + " (885,19,'Knowing that you are engaged in God''s work, Father Michael <i>Blesses</i> you.')");
		db.execSQL(sqlInsertCard + " (258,8,7)");
		db.execSQL(sqlInsertCardEnc + " (258,886)");
		db.execSQL(sqlInsertEnc + " (886,9,'A monster appears and attacks you as you approach the front door!')");
		db.execSQL(sqlInsertCardEnc + " (258,887)");
		db.execSQL(sqlInsertEnc + " (887,13,'Ma doesn''t like the look of you and your \"gang\". Pay $1, plus $1 for each Ally you have, or move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (258,888)");
		db.execSQL(sqlInsertEnc + " (888,19,'You interrupt an arguement between Father Michael and a member of the Esoteric Order of Dagon. If you join in on the side of Dagon, gain 2 Clue tokens as you urge the man to talk. If you join in on the side of the Church, Father Michael''s grateful smile restores 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (259,8,1)");
		db.execSQL(sqlInsertCardEnc + " (259,889)");
		db.execSQL(sqlInsertEnc + " (889,9,'You encounter a friendly old professor from Miskatonic University. If you spend 1 gate trophy, he introduces himself as <b>Professor Armitage</b> and offers to join forces with you. Take his Ally card if it is available, otherwise draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (259,890)");
		db.execSQL(sqlInsertEnc + " (890,13,'Chanting neighbors keep you up all night. Pass a <b>Luck (-1) check</b> or lose your choice of 1 Stamina or 1 Sanity')");
		db.execSQL(sqlInsertCardEnc + " (259,891)");
		db.execSQL(sqlInsertEnc + " (891,19,'You join in the morning mass. Spend 1 Clue token to ask for heavenly aid. If you do so, roll a die. On a success, your prayers are answered. Remove 1 doom token from the Ancient One''s doom track.')");
		db.execSQL(sqlInsertCard + " (260,8,1)");
		db.execSQL(sqlInsertCardEnc + " (260,892)");
		db.execSQL(sqlInsertEnc + " (892,9,'The Society members are bird watching in the woods. The janitor offers you a ride there. If you accept, move to the Woods and draw 2 cards, encountering one card of your choice and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (260,893)");
		db.execSQL(sqlInsertEnc + " (893,13,'Staring at a painting in one of the rooms, you find yourself drawn into it. Make a <b>Luck (+0) check</b>. If you pass, move to The Dreamlands. Have one encounter there and immediately return here. If you fail, move to the Abyss. Have one encounter there and immediately return here.')");
		db.execSQL(sqlInsertCardEnc + " (260,894)");
		db.execSQL(sqlInsertEnc + " (894,19,'You could swear a drain pipe gargoyle moved. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (261,8,8)");
		db.execSQL(sqlInsertCardEnc + " (261,895)");
		db.execSQL(sqlInsertEnc + " (895,9,'While researching, you find a story about a series of disappearances that occurred in the earliest days of Arkham. Coincidentally, you notice a newspaper reporting a similar disappearance just last week. Return 1 Ally at random from the Ally deck to the box. Then gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (261,896)");
		db.execSQL(sqlInsertEnc + " (896,13,'As a favor, you volunteer to head to the basement to have a look at the pipes. The steps are mostly rotten and are starting to fall apart under your weight. Make a <b>Speed (+0) check</b> to avoid injury. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (261,897)");
		db.execSQL(sqlInsertEnc + " (897,19,'Father Michael''s sermon is comforting, but a little dull, and you''ve dozed off. Stay here next turn and restore your Sanity to its maximum.')");
		db.execSQL(sqlInsertCard + " (262,8,8)");
		db.execSQL(sqlInsertCardEnc + " (262,898)");
		db.execSQL(sqlInsertEnc + " (898,9,'You encounter a friendly old professor from Miskatonic University. If you spend 1 Gate trophy, he introduces himself as <b>Professor Armitage</b> and offers to join forces with you. Take his Ally card if it is available; otherwise, draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (262,899)");
		db.execSQL(sqlInsertEnc + " (899,13,'A portrait of one of Arkham''s founding fathers hangs in Ma''s sitting room. On the back of the painting is a series of symbols and numbers. Pass a <b>Lore (-1) check</b> to interpret their meaning and gain a Clue token for each success.')");
		db.execSQL(sqlInsertCardEnc + " (262,900)");
		db.execSQL(sqlInsertEnc + " (900,19,'\"You! You are the one who has stood against the evil that plagues this town. We are all so grateful!\" A crowd surrounds you, expressing gratitude and adoration. Gain 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (263,8,1)");
		db.execSQL(sqlInsertCardEnc + " (263,901)");
		db.execSQL(sqlInsertEnc + " (901,9,'You notice a creepy man watching you as you peruse the books. With a feeling of dread you try to slip out without being followed. Make a <b>Sneak (-1) check</b>. If you pass, you lose the man. If you fail, you are accosted in the street. He is a wizard and he casts a dark spell on you as you flee. Lose 2 Stamina, move to the street, and you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (263,902)");
		db.execSQL(sqlInsertEnc + " (902,13,'Ma Mathison serves her special soup at supper. Roll a die and gain that much Stamina')");
		db.execSQL(sqlInsertCardEnc + " (263,903)");
		db.execSQL(sqlInsertEnc + " (903,19,'Father Michael convinces you that there are members of his congregation in greater need than you. Donate either half your money (rounded up) or half your items (your choice, rounded up) to the poor.')");
		db.execSQL(sqlInsertCard + " (264,8,7)");
		db.execSQL(sqlInsertCardEnc + " (264,904)");
		db.execSQL(sqlInsertEnc + " (904,9,'A golden tiara on display is covered in bizarre and unnatural engravings. Make a <b>Lore (-1) check</b> and gain 1 Clue token for each success.')");
		db.execSQL(sqlInsertCardEnc + " (264,905)");
		db.execSQL(sqlInsertEnc + " (905,13,'Ma apologizes, but her kitchen is being redone. If you want, she''ll give you a ride to <b>Velma''s Diner</b>. If you go there, immediately have an encounter.')");
		db.execSQL(sqlInsertCardEnc + " (264,906)");
		db.execSQL(sqlInsertEnc + " (906,19,'Whatever else might be wrong in Arkham, you feel safe here. Gain 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (265,8,7)");
		db.execSQL(sqlInsertCardEnc + " (265,907)");
		db.execSQL(sqlInsertEnc + " (907,9,'You encounter a friendly old professor from Miskatonic University. If you spend 1 gate trophy, he introduces himself as <b>Professor Armitage</b> and offers to join forces with you. Take his Ally card if it is available, otherwise draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (265,908)");
		db.execSQL(sqlInsertEnc + " (908,13,'Ma runs a tight ship! You awake refreshed. Gain 2 points split between Stamina and Sanity however you choose.')");
		db.execSQL(sqlInsertCardEnc + " (265,909)");
		db.execSQL(sqlInsertEnc + " (909,19,'Knowing that you are engaged in God''s work, Father Michael <i>Blesses</i> you.')");
		db.execSQL(sqlInsertCard + " (266,8,7)");
		db.execSQL(sqlInsertCardEnc + " (266,910)");
		db.execSQL(sqlInsertEnc + " (910,9,'The society is discarding what it calls a \"taxidermist''s trick.\" Draw a monster from the cup and claim it as a monster trophy, even if it has the <b>Endless</b> ability.')");
		db.execSQL(sqlInsertCardEnc + " (266,911)");
		db.execSQL(sqlInsertEnc + " (911,13,'You''re getting ready to turn in for the night when you discover a corpse lying in your bed. Pass a <b>Will (-1) check</b> to keep your cool. If you fail, the terror level increases by 1. In any case, examining the body yields 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (266,912)");
		db.execSQL(sqlInsertEnc + " (912,19,'When the donation tray comes around, you find yourself guiltily contributing. You lose $1.')");
		db.execSQL(sqlInsertCard + " (267,8,1)");
		db.execSQL(sqlInsertCardEnc + " (267,913)");
		db.execSQL(sqlInsertEnc + " (913,9,'Pass a <b>Luck (-1) [2] check</b> to gain insight into a skill while studying the old volumes of books. Draw 1 Skill, but stay here next turn.')");
		db.execSQL(sqlInsertCardEnc + " (267,914)");
		db.execSQL(sqlInsertEnc + " (914,13,'After supper while sitting on the porch you strike up a conversation with another guest: Ryan Dean, a traveling salesman. You may make a <b>Will (+0) check</b>. If you pass, Ryan has a deal for you. You may draw either 1 Common Item or 1 Unique Item and purchase it at list price. If you fail, stay here next turn listening to bawdy stories and tall tales.')");
		db.execSQL(sqlInsertCardEnc + " (267,915)");
		db.execSQL(sqlInsertEnc + " (915,19,'Noticing you eying the holy water, Father Michael tells you, \"Take what you need, my child.\" You may search the Unique Item deck for a Holy Water card and take it.')");
		db.execSQL(sqlInsertCard + " (268,8,8)");
		db.execSQL(sqlInsertCardEnc + " (268,916)");
		db.execSQL(sqlInsertEnc + " (916,9,'A guest lecturer provides a lengthy but informative presentation about his explorations of ancient sites. You may make a <b>Lore (-1) [2] check</b> and stay here next turn. If you pass, gain 1 Skill.')");
		db.execSQL(sqlInsertCardEnc + " (268,917)");
		db.execSQL(sqlInsertEnc + " (917,13,'If you''re healthy enough, Ma could sure use some help rebuilding the porch. If you have 3 or more Stamina, take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (268,918)");
		db.execSQL(sqlInsertEnc + " (918,19,'If you can show Father Michael proof of the doom that threatens Arkham, he will agree to lead the congregation in a prayer to purge the streets of evil. If you spend 1 Gate trophy, you may remove all monsters from the Southside neighborhood.')");
		db.execSQL(sqlInsertCard + " (269,8,1)");
		db.execSQL(sqlInsertCardEnc + " (269,919)");
		db.execSQL(sqlInsertEnc + " (919,9,'Perusing the county records, you discover something horrifying about your family tree. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (269,920)");
		db.execSQL(sqlInsertEnc + " (920,13,'The last guest to stay in your room had to leave in a hurry and left something behind. Draw 1 Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (269,921)");
		db.execSQL(sqlInsertEnc + " (921,19,'You enter the confessional. \"Bless me, Father, for I have sinned.\" Make a <b>Luck (+0) check</b> and consult the chart below:<br /><br />Successes:<br />0) \"\"Father? Are you there?\"\" You hear a scream in the next compartment! Lose 3 Sanity and move to the street.<br />1) \"\"Father?\"\" There is no answer. Sighing, you leave. Move to the street.<br />2+) \"\"I don''t remember my last confession.\"\" Raise your Sanity to its maximum value.')");
		db.execSQL(sqlInsertCard + " (270,8,8)");
		db.execSQL(sqlInsertCardEnc + " (270,922)");
		db.execSQL(sqlInsertEnc + " (922,9,'\"After my husband passed away, I thought the Society would be interested in his documents. He was very influential in Arkham.\" Make a <b>Luck (-2) check</b> to see if the curator recognizes their arcane significance. If you pass, gain 1 Spell as the Society passes these papers off to you.')");
		db.execSQL(sqlInsertCardEnc + " (270,923)");
		db.execSQL(sqlInsertEnc + " (923,13,'You sneak down to Ma''s kitchen for a midnight snack. Make a <b>Luck (+0) check</b> to see if there''s any leftovers waiting for you. Gain 1 Stamina per success.')");
		db.execSQL(sqlInsertCardEnc + " (270,924)");
		db.execSQL(sqlInsertEnc + " (924,19,'Someone left a box of donation items at the Church''s doorstep. You notice an odd, grotesque idol. Make a <b>Will (+0) check</b>. If you fail, you are <i>Cursed</i>.')");
	}

	private static void FetchNorthsideEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		db.execSQL(sqlInsertCard + " (-34,6,9)");
		db.execSQL(sqlInsertCardEnc + " (-34,661)");
		db.execSQL(sqlInsertEnc + " (661,5,'If you look hard, you can find some real bargains here! Draw a number of cards from the Common Item deck equal to your focus (maximum 3). You may purchase any of the drawn items for $1 less than the list price, and must discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (-34,662)");
		db.execSQL(sqlInsertEnc + " (662,14,'Staring into the presses is like watching the flow of history passing by you. You begin to see a strange pattern to it all. Take the Visions card.')");
		db.execSQL(sqlInsertCardEnc + " (-34,663)");
		db.execSQL(sqlInsertEnc + " (663,24,'The railroad bulls don''t trust the influx of foreigners with the visiting museum exhibit, and are distracted. If you''d like to try to jump on board a freight train as it pulls out, make a <b>Sneak (+0) check</b>. If you pass, you may move to any Arkham location and end your turn. If you fail, you are caught and warned not to show your face around here again. Lose 1 Stamina and place a Patrol marker on the street area of Northside.')");
		db.execSQL(sqlInsertCard + " (-33,6,9)");
		db.execSQL(sqlInsertCardEnc + " (-33,664)");
		db.execSQL(sqlInsertEnc + " (664,5,'\"Durn roof keeps leakin''... ruinin'' my wares!\" If you offer to fix the roof for the shopkeeper, make a <b>Speed (-1) check</b>. If you fail, you fall and lose 2 Stamina. If you pass, he is grateful, and offers to give you any Common Item in the deck with a value equal to or lower than your number of successes.')");
		db.execSQL(sqlInsertCardEnc + " (-33,665)");
		db.execSQL(sqlInsertEnc + " (665,14,'A reporter will pay you handsomely, whether in money or information, for an expos\u00E9 on the life of a monster hunter. Discard any number of monster trophies to gain $2 or 1 Clue token (in any combination) for each point of toughness worth of monsters discarded.')");
		db.execSQL(sqlInsertCardEnc + " (-33,666)");
		db.execSQL(sqlInsertEnc + " (666,24,'A wealthy foreigner steps off the train and mistakes you for his guide, handing you his baggage. Draw 1 Exhibit Item, 1 Unique Item, and 1 Common Item. Keep one of them and discard the rest. You must also take the Local Guide card.')");
		db.execSQL(sqlInsertCard + " (-32,6,9)");
		db.execSQL(sqlInsertCardEnc + " (-32,667)");
		db.execSQL(sqlInsertEnc + " (667,5,'The shopkeeper has purchased a display of kitschy Egyptian items to drum up business. Make a <b>Lore (+0) check</b>. If you fail, it looks realistic to you. If you pass, you point out a few items that are set up improperly, and help him rearrange the display. In return, he offers you any one non-<b>Weapon</b> Common Item at half price.')");
		db.execSQL(sqlInsertCardEnc + " (-32,668)");
		db.execSQL(sqlInsertEnc + " (668,14,'You call around for a story, asking about mysterious occurrences related to the visiting museum exhibit. Make a <b>Luck (+0) check</b>. For each success, you may take 1 Clue token from any locations in Arkham and add it to your pool. If there are not Clue tokens in Arkham, you may not gain any.')");
		db.execSQL(sqlInsertCardEnc + " (-32,669)");
		db.execSQL(sqlInsertEnc + " (669,24,'The station manager offers you a job helping to clean out the storage shed where lost and left-behind luggage is kept. Gain $3 and make a <b>Luck (-2) check</b>. If you pass, you may also draw 1 Unique Item or Exhibit Item.')");
		db.execSQL(sqlInsertCard + " (-31,6,9)");
		db.execSQL(sqlInsertCardEnc + " (-31,670)");
		db.execSQL(sqlInsertEnc + " (670,5,'You get into a debate with the shopkeeper regarding the value of material wealth vs. knowledge, and he challenges you to prove your point. If you pass a <b>Will (-1) check</b>, you may discard a Common Item or any number of Clue tokens. If you discard a Common Item, draw a number of Clue tokens equal to its value. If you discard Clue tokens, search the Common Item deck and take any number of items with a total value equal to or less than the number of Clue tokens discarded.')");
		db.execSQL(sqlInsertCardEnc + " (-31,671)");
		db.execSQL(sqlInsertEnc + " (671,14,'A competitor to the <i>Arkham Advertiser</i> offers you money to sabotage the presses. If you accept, gain $5 and make a <b>Sneak (-2) check</b>. If you fail, you are <i>arrested</i>. Regardless of the result, place a Patrol marker on the street area of Northside.')");
		db.execSQL(sqlInsertCardEnc + " (-31,672)");
		db.execSQL(sqlInsertEnc + " (672,24,'You fall asleep waiting for your train. Move to the Dreamlands and have an encounter there, then (unless you are <i>lost in time and space</i>) return immediately. When you awake, you are holding a strange artifact. Draw 1 Unique Item or Exhibit Item.')");
		db.execSQL(sqlInsertCard + " (-30,6,9)");
		db.execSQL(sqlInsertCardEnc + " (-30,673)");
		db.execSQL(sqlInsertEnc + " (673,5,'The shop seems to be closed early. You peer through the windows and see... something your mind cannot comprehend! Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (-30,674)");
		db.execSQL(sqlInsertEnc + " (674,14,'The editor asks you to answer phones on a busy night. You pick up one call and hear nothing at first. Then you hear your name being whispered by something that can''t possibly be human. Make a <b>Will (-1) check</b> or lose 1 Sanity. Then make a <b>Speed (-2) check</b> to activate a call trace in time. If you pass, you learn that it came from the museum exhibit. Gain 2 Clue tokens')");
		db.execSQL(sqlInsertCardEnc + " (-30,675)");
		db.execSQL(sqlInsertEnc + " (675,24,'You share a train car with a foreign visitor. When you step off and open your valise, you realize you grabbed the wrong one! Discard a Common or Unique Item if able, then make a <b>Luck (+0) check</b>. If you pass, draw a number of Unique or Exhibit Items equal to the number of successes rolled, and keep one. If you fail, follow the instructions as above but draw from the Common Item deck.')");
		db.execSQL(sqlInsertCard + " (-29,6,2)");
		db.execSQL(sqlInsertCardEnc + " (-29,676)");
		db.execSQL(sqlInsertEnc + " (676,5,'If you look hard, you can find some real bargains here! Draw a number of cards from the Common Item deck equal to your focus (maximum 3). You may purchase any of the drawn items for $1 less than the list price, and must discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (-29,677)");
		db.execSQL(sqlInsertEnc + " (677,14,'Staring into the presses is like watching the flow of history passing by you. You begin to see a strange pattern to it all. Take the Visions card.')");
		db.execSQL(sqlInsertCardEnc + " (-29,678)");
		db.execSQL(sqlInsertEnc + " (678,24,'The railroad bulls don''t trust the influx of foreigners with the visiting museum exhibit, and are distracted. If you''d like to try to jump on board a freight train as it pulls out, make a <b>Sneak (+0) check</b>. If you pass, you may move to any Arkham location and end your turn. If you fail, you are caught and warned not to show your face around here again. Lose 1 Stamina and you are <i>Barred from Northside</i>.')");
		db.execSQL(sqlInsertCard + " (-28,6,8)");
		db.execSQL(sqlInsertCardEnc + " (-28,679)");
		db.execSQL(sqlInsertEnc + " (679,5,'Oliver Thomas, the shopkeeper, greets you enthusiastically. \"There was an item here earlier that I just knew was meant for you. I''m not sure where it went, but I imagine if it was meant to be, you''ll be able to find it.\" Make a <b>Will (-2) check</b>. If you pass, gain 1 Unique Item. If you fail, gain 1 Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (-28,680)");
		db.execSQL(sqlInsertEnc + " (680,14,'\"Make yourself useful or get out of here!\" You may choose to help load papers onto trucks. If you do, make a <b>Fight (-1) check</b>. If you pass, gain $2. If you fail, lose 1 Stamina. If you choose not to help load the trucks.move to the streets.')");
		db.execSQL(sqlInsertCardEnc + " (-28,681)");
		db.execSQL(sqlInsertEnc + " (681,24,'You see a familiar face about to get on a train leaving Arkham. Draw an Ally card and then make a <b>Will (-2) [2] check</b>. If you pass, you''ve convinced your friend to stay and may take the Ally card. If you fail, the Ally card is returned to the box.')");
		db.execSQL(sqlInsertCard + " (195,6,1)");
		db.execSQL(sqlInsertCardEnc + " (195,682)");
		db.execSQL(sqlInsertEnc + " (682,5,'Jackpot! You find just what you''ve been looking for. Search either the Common or Unique Item deck and purchase any one item of your choice at list price.')");
		db.execSQL(sqlInsertCardEnc + " (195,683)");
		db.execSQL(sqlInsertEnc + " (683,14,'Editor Doyle Jefferies offers you a Retainer in return for your fascinating stories. Take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (195,684)");
		db.execSQL(sqlInsertEnc + " (684,24,'The old train hand Bill Washington sits on the train platform playing his guitar as he awaits the next train. As you listen to his singing you feel yourself healing inside. Gain 2 points divided between Stamina and Sanity however you choose.')");
		db.execSQL(sqlInsertCard + " (196,6,1)");
		db.execSQL(sqlInsertCardEnc + " (196,685)");
		db.execSQL(sqlInsertEnc + " (685,5,'A sale takes place. All players may participate. Turn over the top 3 Common Item cards and the top Unique Item card. Any player may buy one or more of these cards for their list price. If there is a disagreement over who gets to buy a certain card, you decide. Any items not sold are discarded.')");
		db.execSQL(sqlInsertCardEnc + " (196,686)");
		db.execSQL(sqlInsertEnc + " (686,14,'Flipping through the early edition, you are surprised to see that one of the classified ads begins with your name. Reading it, you realize that it contains several coded clues to the nature of the threat that faces Arkham. Pass a <b>Lore (-1) check</b> to gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (196,687)");
		db.execSQL(sqlInsertEnc + " (687,24,'Bill Washington moves the last of the baggage from his cart onto a truck and offers you a ride as he opens the driver''s door. If you accept, move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCard + " (197,6,7)");
		db.execSQL(sqlInsertCardEnc + " (197,688)");
		db.execSQL(sqlInsertEnc + " (688,5,'On a high shelf is a puzzle box. You may spend $1 to purchase it and then pass a <b>Lore (-1) check</b> and consult the following chart to determine what''s inside:<br /><br />Successes:<br />0) Nothing<br />1) Gain $3 and a Clue token<br />2+) Draw a Spell and gain $5')");
		db.execSQL(sqlInsertCardEnc + " (197,689)");
		db.execSQL(sqlInsertEnc + " (689,14,'While going through the archives, you find a yellowed collection of <i>Innsmouth Courier</i> newspapers. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (197,690)");
		db.execSQL(sqlInsertEnc + " (690,24,'You realize too late that the train you boarded is empty. Draw the top gate marker and travel to that Other World and replace the gate marker on top of the gate marker pile.')");
		db.execSQL(sqlInsertCard + " (198,6,7)");
		db.execSQL(sqlInsertCardEnc + " (198,691)");
		db.execSQL(sqlInsertEnc + " (691,5,'You come across a blasphemous idol sitting innocently on a shelf. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (198,692)");
		db.execSQL(sqlInsertEnc + " (692,14,'The staff of the <i>Advertiser</i> are uncharacteristically closemouthed. As you leave, you find yourself surrounded by sallow-skinned ruffians. Make a <b>Fight (-1) check</b> and lose 3 Stamina. This loss is reduced by 1 for every success (minimum 0).')");
		db.execSQL(sqlInsertCardEnc + " (198,693)");
		db.execSQL(sqlInsertEnc + " (693,24,'\"Hey, buddy, you forgot your bag!\" You didn''t, but before you can object, the man is gone. You open the bag and find a Common Item inside.')");
		db.execSQL(sqlInsertCard + " (199,6,8)");
		db.execSQL(sqlInsertCardEnc + " (199,694)");
		db.execSQL(sqlInsertEnc + " (694,5,'\"According to legend, this mirror was once used to travel from our world into the lands beyond. Does this interest you?\" If you wish, you may discard any Common Item, Unique Item, or Spell to move to the first area of any Other World.')");
		db.execSQL(sqlInsertCardEnc + " (199,695)");
		db.execSQL(sqlInsertEnc + " (695,14,'Someone has sent an anonymous package to the paper. Whatever is inside is leaking a dark, sticky fluid. Upon seeing what''s inside, lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (199,696)");
		db.execSQL(sqlInsertEnc + " (696,24,'You find a key to a locker on the ground, but the tag that shows its number has been removed. Make a <b>Luck (-2) check</b> to find the right locker. If you pass, gain 1 Common Item.')");
		db.execSQL(sqlInsertCard + " (200,6,1)");
		db.execSQL(sqlInsertCardEnc + " (200,697)");
		db.execSQL(sqlInsertEnc + " (697,5,'As you wander into the back of the shop, you hear a noise. Pass a <b>Speed (-1) check</b> or you look up just in time to see a descending club. Everything goes black. When you awaken, you are somewhere else. Draw a mythos card and move to the gate location shown on it, then immediately have an encounter there.')");
		db.execSQL(sqlInsertCardEnc + " (200,698)");
		db.execSQL(sqlInsertEnc + " (698,14,'You accidentally tip over a bottle of ink and are aghast at the pattern the ink forms on the newsroom floor. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (200,699)");
		db.execSQL(sqlInsertEnc + " (699,24,'A stranger in a turban steps off the Boston local train with a crazed look on his face. Make a <b>Luck (-1) check</b>. If you pass, the man pulls a strange object from beneath his cloak and gives it to you. Draw 1 Unique Item. If you fail, he pulls a poisoned blade out of his cloak and stabs you. Roll a die and lose that much Stamina.')");
		db.execSQL(sqlInsertCard + " (201,6,1)");
		db.execSQL(sqlInsertCardEnc + " (201,700)");
		db.execSQL(sqlInsertEnc + " (700,5,'A pulsing void gapes behind a bookshelf, sending out waves of heat. Pass a <b>Fight (-1) check</b> or it sucks you in, hurling you into the Abyss. Have one encounter there, then immediately return.')");
		db.execSQL(sqlInsertCardEnc + " (201,701)");
		db.execSQL(sqlInsertEnc + " (701,14,'Earn $5 for a story.')");
		db.execSQL(sqlInsertCardEnc + " (201,702)");
		db.execSQL(sqlInsertEnc + " (702,24,'A well-dressed man is standing on the platform. He turns and greets you by name. Although he seems oddly familiar, you don''t remember ever meeting him before. Then he steps off the platform into the path of a speeding train. Make a <b>Speed (-1) check</b>. If you pass, he vanishes as you leap right through him. On the ground, you find yourself clutching a scrap of paper. Gain 1 Spell. If you fail, he is obliterated before your eyes. Roll a die and lose that much Sanity.')");
		db.execSQL(sqlInsertCard + " (202,6,1)");
		db.execSQL(sqlInsertCardEnc + " (202,703)");
		db.execSQL(sqlInsertEnc + " (703,5,'Pass a <b>Luck (-1) check</b> or you accidentally drop an item. Discard 1 item of your choice. If you have no items to drop, then draw again for a different encounter.')");
		db.execSQL(sqlInsertCardEnc + " (202,704)");
		db.execSQL(sqlInsertEnc + " (704,14,'Editor Doyle Jefferies offers you a Retainer in return for your fascinating stories. Take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (202,705)");
		db.execSQL(sqlInsertEnc + " (705,24,'Joey \"the Rat\" is huddled in the shadows of the train station and motions for you to come over. He has an item for sale. Draw the top Common Item card and pay $1 more than list price if you wish to keep it.')");
		db.execSQL(sqlInsertCard + " (203,6,8)");
		db.execSQL(sqlInsertCardEnc + " (203,706)");
		db.execSQL(sqlInsertEnc + " (706,5,'Oliver Thomas has an extremely rare book on display, but it is not for sale. He''s willing to let you have a look at it. Make a <b>Will (-1) check</b> to quickly memorize as much as you can of this informative text. Gain 1 Clue token for each success you roll.')");
		db.execSQL(sqlInsertCardEnc + " (203,707)");
		db.execSQL(sqlInsertEnc + " (707,14,'A reporter has disappeared, leaving only cryptic and ominous notes about the story she was investigating. If you can make any sense of them, the editor would gladly pay you.Make a <b>Lore (-3) check</b>. If you pass, gain $2 and 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (203,708)");
		db.execSQL(sqlInsertEnc + " (708,24,'Hot peanuts are for sale at a pushcart. You may pay up to $3 and gain 1 Stamina for each $1 you spend.')");
		db.execSQL(sqlInsertCard + " (204,6,8)");
		db.execSQL(sqlInsertCardEnc + " (204,709)");
		db.execSQL(sqlInsertEnc + " (709,5,'Other customers are intrigued by your knowledge of the items in the shop. The more you describe the histories of these objects, the more people purchase. Make a <b>Lore (+0) check</b>. If you pass, Oliver Thomas is so grateful for your help with sales that he offers you $3 for your efforts.')");
		db.execSQL(sqlInsertCardEnc + " (204,710)");
		db.execSQL(sqlInsertEnc + " (710,14,'Editor Doyle Jefferies is offering top dollar for anyone who can provide a first-hand account of the strange events plaguing Arkham. You may move to the nearest Gate. If you do, take a Retainer card and you are drawn through the Gate. If no Gates are open, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (204,711)");
		db.execSQL(sqlInsertEnc + " (711,24,'A nervous-looking man is moving quickly through the crowd, with Sheriff Engle in pursuit. The anxious man bumps into you, falls to the ground, and drops a package. Make a <b>Speed (-2) check</b> to grab the package and escape before the sheriff arrives. If you pass, gain 1 Unique Item.')");
		db.execSQL(sqlInsertCard + " (205,6,1)");
		db.execSQL(sqlInsertCardEnc + " (205,712)");
		db.execSQL(sqlInsertEnc + " (712,5,'You examine an obscene statue. Pass a <b>Luck (-2) check</b> or else you feel a cold dread spread through your body as you hold it. You are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (205,713)");
		db.execSQL(sqlInsertEnc + " (713,14,'You earn a hefty fee for a story and get a ride with Doyle Jefferies, the editior. Gain $2 and move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCardEnc + " (205,714)");
		db.execSQL(sqlInsertEnc + " (714,24,'On the loading dock you investigate a large crate with strange markings. Make  <b>Sneak (-1) check</b>. If you pass, you find a very unusual item in the crate. Gain 1 Unique Item. If you fail, Deputy Dingby catches you breaking it open. You are arrested and taken to the Police Station.')");
		db.execSQL(sqlInsertCard + " (206,6,7)");
		db.execSQL(sqlInsertCardEnc + " (206,715)");
		db.execSQL(sqlInsertEnc + " (715,5,'The shopkeeper eyes one of your possessions. \"I have need of that object. Will you sell it to me?\" You may sell any one of your Unique Items for twice its listed price.')");
		db.execSQL(sqlInsertCardEnc + " (206,716)");
		db.execSQL(sqlInsertEnc + " (716,14,'You spin a yarn to a group of assembled reporters. Make a <b>Will (-1) check</b> to see how many of them believe you. Gain $1 per success.')");
		db.execSQL(sqlInsertCardEnc + " (206,717)");
		db.execSQL(sqlInsertEnc + " (717,24,'The train that just pulled into the station doesn''t look like it''s from around here. Make a <b>Sneak (-1) check</b> to lurk in the shadows. If you pass, you hide from the robed figures that get off the train and gain a Unique Item they left behind. If you fail, you are discovered. Move to the street.')");
		db.execSQL(sqlInsertCard + " (207,6,7)");
		db.execSQL(sqlInsertCardEnc + " (207,718)");
		db.execSQL(sqlInsertEnc + " (718,5,'An elderly blind man is running his hand along shelves, searching for a mysterious object. If you help him, he will gratefully offer to purchase something else in the store for you. Search the Common Item deck for one free item of your choice and be <i>Blessed</i>. Or instead, you can take the mysterious object for yourself. Search the Unique Item deck for one item of your choice to purchase for list price.')");
		db.execSQL(sqlInsertCardEnc + " (207,719)");
		db.execSQL(sqlInsertEnc + " (719,14,'Earn $5 for a story.')");
		db.execSQL(sqlInsertCardEnc + " (207,720)");
		db.execSQL(sqlInsertEnc + " (720,24,'Bill Washington moves the last of the baggage from his cart onto a truck and offers you a ride as he opens the driver''s door. If you accept, move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCard + " (208,6,1)");
		db.execSQL(sqlInsertCardEnc + " (208,721)");
		db.execSQL(sqlInsertEnc + " (721,5,'You weed through piles of junk looking for something useful. Make a <b>Luck (-1) check</b> to see what you find. If you pass, your search has resulted in success. You may look at the top cards of both the Common and Unique Item decks. You may purchase one, both, or neither at list price.  If you fail, there is little of interest here, but you may look at the top card of the Common Item deck and purchase it for its list price.')");
		db.execSQL(sqlInsertCardEnc + " (208,722)");
		db.execSQL(sqlInsertEnc + " (722,14,'Pass a <b>Luck (-1) check</b> to find an article that a local citizen told you would shed light on the recent strange activities. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (208,723)");
		db.execSQL(sqlInsertEnc + " (723,24,'Pay $3 at the Railroad Office to claim an item left in Lost and Found. If you do so, make a <b>Luck (-2) check</b>. If you pass, draw a Unique Item. If you fail, draw a Common Item')");
		db.execSQL(sqlInsertCard + " (209,6,3)");
		db.execSQL(sqlInsertCardEnc + " (209,724)");
		db.execSQL(sqlInsertEnc + " (724,5,'\"Perhaps we can help each other.\" Oliver Thomas, the shopkeep, searches you face with a speculative look. \"If you have some information for me, I could teach you something extremely useful.\" You may pay 2 Clue tokens to draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (209,725)");
		db.execSQL(sqlInsertEnc + " (725,14,'Editor Doyle Jefferies offers you a Retainer in return for your fascinating stories. Take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (209,726)");
		db.execSQL(sqlInsertEnc + " (726,24,'Wearily, you sit down on one of the benches near the rails. It seems as though the weight of the whole world rests upon your shoulders. If only you could just give up. You''re just about ready to buy a one-way ticket as far from here as you can go when the sound of two giggling children draws your attention. A little boy and girl are playing together under their mother''s watchful gaze. As you watch them play, you''re reminded of why you''re doing all this. Gain either 1 Sanity or 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (210,6,3)");
		db.execSQL(sqlInsertCardEnc + " (210,727)");
		db.execSQL(sqlInsertEnc + " (727,5,'The shopkeeper eyes one of your possessions. \"I have need of that object. Will you sell it to me?\" You may sell any one of your Unique Items for twice its listed price.')");
		db.execSQL(sqlInsertCardEnc + " (210,728)");
		db.execSQL(sqlInsertEnc + " (728,14,'You watch some workers cleaning the presses with rages while the machines are still running, and you wonder if that''s safe. A moment later, your thought proves prophetic as one of them screams, his arm caught in the press. Several workers rush to his aid, while others clear the room. You are moved to the street.')");
		db.execSQL(sqlInsertCardEnc + " (210,729)");
		db.execSQL(sqlInsertEnc + " (729,24,'Bill Washington comes up to you and offers to sell you a rail pass. \"Just $3, and you can ride the train all you want for a month.\" If you accept, pay $3 and take a <b>Rail Pass</b> card.')");
		db.execSQL(sqlInsertCard + " (211,6,3)");
		db.execSQL(sqlInsertCardEnc + " (211,730)");
		db.execSQL(sqlInsertEnc + " (730,5,'The shopkeeper eyes one of your possessions. \"I have need of that object. Will you sell it to me?\" You may sell any one of your Unique Items for twice its listed price.')");
		db.execSQL(sqlInsertCardEnc + " (211,731)");
		db.execSQL(sqlInsertEnc + " (731,14,'Talking to the editor, Doyle Jefferies, you realize that he could be a good source of information. You may either buy up to 3 Clue tokens for $2 each, or sell up to 3 Clue tokens for $2 each.')");
		db.execSQL(sqlInsertCardEnc + " (211,732)");
		db.execSQL(sqlInsertEnc + " (732,24,'Bill Washington comes up to you and offers to sell you a rail pass. \"Just $3, and you can ride the train all you want for a month.\" If you accept, pay $3 and take a <b>Rail Pass</b> card.')");
		db.execSQL(sqlInsertCard + " (212,6,3)");
		db.execSQL(sqlInsertCardEnc + " (212,733)");
		db.execSQL(sqlInsertEnc + " (733,5,'You disturb one of the antiques in the shop and a large cloud of dust rises from it. Coughing, you go outside for some fresh air. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (212,734)");
		db.execSQL(sqlInsertEnc + " (734,14,'Earn $5 for a story.')");
		db.execSQL(sqlInsertCardEnc + " (212,735)");
		db.execSQL(sqlInsertEnc + " (735,24,'Make a <b>Luck (-1) check</b>. If you pass, you find a battered old book lying on a ledge near the trains. Reading through it, you find that it contains a letter addressed to you. \"Please, take the information contained with this book and use it to combat those things that we both know are lurking just out of sight.\" The author remains anonymous, but reading further, you find that the book is full of useful information. Draw 1 Spell and gain 1 Clue token. If you fail the check, someone else grabs the book and walks off with it before you can get to it.')");
		db.execSQL(sqlInsertCard + " (213,6,5)");
		db.execSQL(sqlInsertCardEnc + " (213,736)");
		db.execSQL(sqlInsertEnc + " (736,5,'You trip over a stack of books obviously undisturbed for years, if not decades. Make a <b>Lore (-1) check</b>. If you succeed, search the Unique Item deck and take the first <i><b>Tome</b></i> you find.')");
		db.execSQL(sqlInsertCardEnc + " (213,737)");
		db.execSQL(sqlInsertEnc + " (737,14,'\"Get out!\" snarls the surly janitor, shaking a fist at you as he pokes his head into the archive room. \"We''re closed!\" As he moves off down the hallway, he shouts back over his shoulder, \"If I come back and you''re still here...\" Make a <b>Will (-1) check</b>. If you succeed, gain 2 Clue tokens. If you fail, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (213,738)");
		db.execSQL(sqlInsertEnc + " (738,24,'A conductor grabs your shoulder as you step onto the train. \"This train''s reserved,\" he rasps. You all but leap back onto the platform as the train begins to chug out of the station, fading from existence before your eyes. Choose a monster on an open gate and return it to the monster cup.')");
		db.execSQL(sqlInsertCard + " (214,6,5)");
		db.execSQL(sqlInsertCardEnc + " (214,739)");
		db.execSQL(sqlInsertEnc + " (739,5,'A portrait half obscured behind a bookshelf catches your eye. There''s something strange about it, but you''re in no mood to move the shelf. On the other hand, you''d be a fool to ignore the gnawing feeling that the pattern-- which you can just barely make out-- might be important. Make a <b>Lore (-2) [2] check</b>. If you succeed, search the Unique Items deck for an Elder Sign.')");
		db.execSQL(sqlInsertCardEnc + " (214,740)");
		db.execSQL(sqlInsertEnc + " (740,14,'You open what seems like the hundredth file whose contents bear no relation either to each other or the drawer where you found them. You are <i>delayed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (214,741)");
		db.execSQL(sqlInsertEnc + " (741,24,'You jump onto the train just as the cars begin to move. \"All aboard for Kingsport Station!\" To remain at this location, make a <b>Speed (-1) check</b> to leap off before the train gets up to speed. If you fail, or do not wish to roll, move to the Central Hill streets in Kingsport.')");
		db.execSQL(sqlInsertCard + " (215,6,5)");
		db.execSQL(sqlInsertCardEnc + " (215,742)");
		db.execSQL(sqlInsertEnc + " (742,5,'A man with a crate checks his watch outside the locked shop as you walk up. Seeing you, he turns. \"Do you know anyone who might be interested in these? I just want to be rid of them.\" Turn over the top three Unique Item cards. Any players may buy them for their list prices. If players disagree about who may buy what, you decide.')");
		db.execSQL(sqlInsertCardEnc + " (215,743)");
		db.execSQL(sqlInsertEnc + " (743,14,'\"Get out!\" snarls the surly janitor, shaking a fist at you as he pokes his head into the archive room. \"We''re closed!\" As he moves off down the hallway, he shouts back over his shoulder, \"If I come back and you''re still here...\" Make a <b>Will (-1) check</b>. If you succeed, gain 2 Clue tokens. If you fail, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (215,744)");
		db.execSQL(sqlInsertEnc + " (744,24,'\"I''ll swap you for one of these.\" Discard one Common Item or one Unique Item of your choice. Then draw one Item of the type you discarded.')");
		db.execSQL(sqlInsertCard + " (216,6,5)");
		db.execSQL(sqlInsertCardEnc + " (216,745)");
		db.execSQL(sqlInsertEnc + " (745,5,'You hear a clatter and a curse. Rushing to the sound, you find Oliver Thomas rubbing a bruised elbow among spilled curios. \"Damned rubbish!\" he seethes. \"Take it away and any that''s not broken is yours!\" Make a <b>Luck (-2) check</b>. If you succeed, draw 3 Unique Item cards and keep any that cost $4 or less. Discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (216,746)");
		db.execSQL(sqlInsertEnc + " (746,14,'You sigh loudly, folding an archive copy of the <i>Advertiser</i> shut, no wiser than when you opened it. The reporter on the other side of the room looks up. \"Help you find something?\" he asks. \"I''ve got nothing but time...for a price.\" Buy as many Clues as you like for $3 each.')");
		db.execSQL(sqlInsertCardEnc + " (216,747)");
		db.execSQL(sqlInsertEnc + " (747,24,'You step up to a waiting cab just as a well-dressed traveller does. \"I''m headed that way, too,\" says the other man. \"The fare''s on me.\" Move to any street or Arkham location and have an encounter there.')");
		db.execSQL(sqlInsertCard + " (217,6,4)");
		db.execSQL(sqlInsertCardEnc + " (217,748)");
		db.execSQL(sqlInsertEnc + " (748,5,'You find a dead cat on the front stoop of the shop. Pass a <b>Luck (-1) check</b> to find the weapon that killed it in the grass nearby. Search the Common Item deck and take the first <i><b>Weapon</b></i> you find.')");
		db.execSQL(sqlInsertCardEnc + " (217,749)");
		db.execSQL(sqlInsertEnc + " (749,14,'You''ve experienced some strange things. Doyle Jeffries, the editor, will pay you $5 for an interview. If you accept, you are <i>delayed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (217,750)");
		db.execSQL(sqlInsertEnc + " (750,24,'The porter went into that train car half an hour ago, and he hasn''t come out. If you investigate, you find his mutilated corpse clutching an item! Lose 2 Sanity but draw 1 Common Item.')");
		db.execSQL(sqlInsertCard + " (218,6,4)");
		db.execSQL(sqlInsertCardEnc + " (218,751)");
		db.execSQL(sqlInsertEnc + " (751,5,'There are some amusing games at the Shoppe to celebrate the opening night of \"The King in Yellow.\" Correctly guess the cost of the next Common Item in the deck, and you get to keep that item! Otherwise, discard it.')");
		db.execSQL(sqlInsertCardEnc + " (218,752)");
		db.execSQL(sqlInsertEnc + " (752,14,'They say there are hidden messages in the newsprint that can only be seen halfway through the printing process. Pass a <b>Sneak (-3) check</b> to catch a glimpse and gain 2 Clue tokens. If you fail, you are <i>arrested</i>.')");
		db.execSQL(sqlInsertCardEnc + " (218,753)");
		db.execSQL(sqlInsertEnc + " (753,24,'Make a <b>Fight (-2) [2] check</b> as you help unload the set materials for \"The King in Yellow.\" If you pass, you are rewarded. Draw 1 Unique Item. If you roll only one success, you are given 1 Common Item. If you fail, you overdo it, and lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (219,6,4)");
		db.execSQL(sqlInsertCardEnc + " (219,754)");
		db.execSQL(sqlInsertEnc + " (754,5,'\"Free. Help yourself.\" Make a <b>Lore (-1) check</b> to repair the item you find beneath the sign. If you pass, draw 1 Common Item. If you fail, lose 1 Stamina as you injure yourself.')");
		db.execSQL(sqlInsertCardEnc + " (219,755)");
		db.execSQL(sqlInsertEnc + " (755,14,'Good thing you had that camera with you earlier. You may spend 3 toughness worth of monster trophies to gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (219,756)");
		db.execSQL(sqlInsertEnc + " (756,24,'Pass a <b>Luck (+1) check</b> to find an unlabeled crate and draw both 1 Unique Item and 1 Common Item. You must either purchase both of them at list price or discard them both.')");
		db.execSQL(sqlInsertCard + " (220,6,4)");
		db.execSQL(sqlInsertCardEnc + " (220,757)");
		db.execSQL(sqlInsertEnc + " (757,5,'You never know what you''ll find in the lost and found box. Spend up to $5. For each $1 you pay, draw one card from the Common Item deck. You may keep one card, but you must discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (220,758)");
		db.execSQL(sqlInsertEnc + " (758,14,'\"You may be on to something about that new play. See what you can find out.\" If you do not already have a Retainer card, you may spend a Clue token to gain one.')");
		db.execSQL(sqlInsertCardEnc + " (220,759)");
		db.execSQL(sqlInsertEnc + " (759,24,'A porter drops what looks like an ancient relic on the tracks. If you want to try and grab it, make a <b>Speed (-3) check</b>. If you pass, you may draw 1 Unique Item. If you fail, you are reduced to 0 Stamina by the oncoming train.')");
		db.execSQL(sqlInsertCard + " (221,6,6)");
		db.execSQL(sqlInsertCardEnc + " (221,760)");
		db.execSQL(sqlInsertEnc + " (760,5,'A sale takes place. All players may participate. Turn over the top 2 Common Item cards and the top 2 Unique Item cards. Any player may buy one or more of these cards for their list price. If there is a disagreement over who gets to buy a certain card, you decide. Any items not sold are discarded.')");
		db.execSQL(sqlInsertCardEnc + " (221,761)");
		db.execSQL(sqlInsertEnc + " (761,14,'There are some real bargains in the classified ads. You may draw a Common Item and purchase it at half price, rounding up.')");
		db.execSQL(sqlInsertCardEnc + " (221,762)");
		db.execSQL(sqlInsertEnc + " (762,24,'You bump into a friend who''s returned from London with his fianc\u00E9e. They''ve brought back the most delightful souvenirs! Draw 3 Unique Items, keep 1, and discard the others.')");
		db.execSQL(sqlInsertCard + " (222,6,6)");
		db.execSQL(sqlInsertCardEnc + " (222,763)");
		db.execSQL(sqlInsertEnc + " (763,5,'There''s an inscription on the back of this mirror! If you spend $3 to purchase it, you can attempt to translate it. Pass a <b>Lore (-1) check</b> and draw 1 Spell if you pass.')");
		db.execSQL(sqlInsertCardEnc + " (222,764)");
		db.execSQL(sqlInsertEnc + " (764,14,'Editor Doyle Jefferies is ready to publish what he knows about what''s really going on in Arkham. Pass a <b>Will (-2) check</b> to talk him out of it. If you are unsuccessful, raise the Terror level by 1.')");
		db.execSQL(sqlInsertCardEnc + " (222,765)");
		db.execSQL(sqlInsertEnc + " (765,24,'You overhear the engineer talking. \"I swear to you we hit something just outside of town. Something unnatural. And it weren''t dead when we left it!\" Draw a monster and place it in the Outskirts.')");
		db.execSQL(sqlInsertCard + " (223,6,6)");
		db.execSQL(sqlInsertCardEnc + " (223,766)");
		db.execSQL(sqlInsertEnc + " (766,5,'You don''t see anyone in the shop, and yet a small army of wind-up toys wheel their way across the floor towards you. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (223,767)");
		db.execSQL(sqlInsertEnc + " (767,14,'A staff photographer pulls you aside and offers to sell you some pictures he took that the paper won''t publish. Spend $3 to gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (223,768)");
		db.execSQL(sqlInsertEnc + " (768,24,'Bill Washington moves the last of the baggage from his cart onto a truck and offers you a ride as he opens the driver''s door. If you accept, move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCard + " (224,6,6)");
		db.execSQL(sqlInsertCardEnc + " (224,769)");
		db.execSQL(sqlInsertEnc + " (769,5,'Examining a fragile vase, it slips out of your hands. Pass a <b>Speed (-1) check</b> to catch it or Oliver Thomas makes you buy it for $3. If you fail to catch it and don''t have $3, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (224,770)");
		db.execSQL(sqlInsertEnc + " (770,14,'Editor Doyle Jefferies offers you a Retainer in return for your fascinating stories. Take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (224,771)");
		db.execSQL(sqlInsertEnc + " (771,24,'There''s been a rash of pickpocketing in the train station. Pass a <b>Luck (-1) check</b> or lose all your money!')");
		db.execSQL(sqlInsertCard + " (225,6,3)");
		db.execSQL(sqlInsertCardEnc + " (225,772)");
		db.execSQL(sqlInsertEnc + " (772,5,'You are looking over an unusual item when Oliver Thomas, the shopkeep walks up behind you. \"Oh, you don''t want that,\" he says. \"Of course, if you''ll take it off my hands, you can have it for free.\" You may search the Unique Item deck for any one card and take it. If you do so, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (225,773)");
		db.execSQL(sqlInsertEnc + " (773,14,'If you pass a <b>Luck (-1) check</b>, then one of the newspaper delivery men offers you a ride in his truck while he makes his rounds. If you accept, move to any street area or location in Arkham. If you move to a location, immediately have an encounter there. If you fail the check, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (225,774)");
		db.execSQL(sqlInsertEnc + " (774,24,'If you pass a <b>Luck (-2) check</b>, an old man looks carefully around him before pressing a wrapped bundle into your hands. \"Here. This is what you need.\" With that, he walks away without another word. Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCard + " (226,6,3)");
		db.execSQL(sqlInsertCardEnc + " (226,775)");
		db.execSQL(sqlInsertEnc + " (775,5,'Oliver Thomas, the wizened old owner of the Curiositie Shoppe, offers you a fortune cookie. Thanking him, you open it, only to be overcome by a wave of dizziness as a hazy vision of the future rushes past your eyes. You may search the mythos deck for any one card and return it to the box.')");
		db.execSQL(sqlInsertCardEnc + " (226,776)");
		db.execSQL(sqlInsertEnc + " (776,14,'If <b>Coded Messages</b> is facedown, you come across the editor, Doyle Jefferies, in the hall and begin to tell hiim about the Mythos. \"Hang on now. Do you have any proof?\" You may spend 1 gate trophy, 1 monster trophy, and 1 Clue token to give him enough proof. If you do, turn <b>Coded Messages</b> faceup. \"Okay, I''m convinced. If you need to get a message to your friends, just let me know.\" If you do not spend the trophies, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (226,777)");
		db.execSQL(sqlInsertEnc + " (777,24,'\"Shine your shoes?\" A young shoe-shine boy looks up at you hopefully. If you agree, he talks about all sorts of interesting topics while shining your shoes. Pay $1 to gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (227,6,6)");
		db.execSQL(sqlInsertCardEnc + " (227,778)");
		db.execSQL(sqlInsertEnc + " (778,5,'A sale takes place. All players may participate. Turn over the top 2 Common Item cards and the top 2 Unique Item cards. Any player may buy one or more of these cards for their list price. If there is a disagreement over who gets to buy a certain card, you decide. Any items not sold are discarded.')");
		db.execSQL(sqlInsertCardEnc + " (227,779)");
		db.execSQL(sqlInsertEnc + " (779,14,'Walking down a narrow hallway, you bump into a young man carrying various chemicals used for the printing presses. He drops one of the jars he''s carrying and it breaks, sending burning fumes up into your face. Lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (227,780)");
		db.execSQL(sqlInsertEnc + " (780,24,'Bill Washington moves the last of the baggage from his cart onto a truck and offers you a ride as he opens the driver''s door. If you accept, move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCard + " (228,6,2)");
		db.execSQL(sqlInsertCardEnc + " (228,781)");
		db.execSQL(sqlInsertEnc + " (781,5,'The shop seems to be closed early. You peer through the windows and see... something your mind cannot comprehend! Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (228,782)");
		db.execSQL(sqlInsertEnc + " (782,14,'The editor asks you to answer phones on a busy night. You pick up one call and hear nothing at first. Then you hear your name being whispered by something that can''t possibly be human. Make a <b>Will (-1) check</b> or lose 1 Sanity. Then make a <b>Speed (-2) check</b> to activate a call trace in time. If you pass, you learn that it came from the museum exhibit. Gain 2 Clue tokens')");
		db.execSQL(sqlInsertCardEnc + " (228,783)");
		db.execSQL(sqlInsertEnc + " (783,24,'You share a train car with a foreign visitor. When you step off and open your valise, you realize you grabbed the wrong one! Discard a Common or Unique Item if able, then make a <b>Luck (+0) check</b>. If you pass, draw a number of Unique or Exhibit Items equal to the number of successes rolled, and keep one. If you fail, follow the instructions as above but draw from the Common Item deck.')");
		db.execSQL(sqlInsertCard + " (229,6,2)");
		db.execSQL(sqlInsertCardEnc + " (229,784)");
		db.execSQL(sqlInsertEnc + " (784,5,'You get into a debate with the shopkeeper regarding the value of material wealth vs. knowledge, and he challenges you to prove your point. If you pass a <b>Will (-1) check</b>, you may discard a Common Item or any number of Clue tokens. If you discard a Common Item, draw a number of Clue tokens equal to its value. If you discard Clue tokens, search the Common Item deck and take any number of items with a total value equal to or less than the number of Clue tokens discarded.')");
		db.execSQL(sqlInsertCardEnc + " (229,785)");
		db.execSQL(sqlInsertEnc + " (785,14,'A competitor to the <i>Arkham Advertiser</i> offers you money to sabotage the presses. If you accept, gain $5 and make a <b>Sneak (-2) check</b>. If you fail, you are <i>arrested</i> as well as <i>Barred from Northside</i>.')");
		db.execSQL(sqlInsertCardEnc + " (229,786)");
		db.execSQL(sqlInsertEnc + " (786,24,'You fall asleep waiting for your train. Move to the Dreamlands and have an encounter there, then (unless you are <i>lost in time and space</i>) return immediately. When you awake, you are holding a strange artifact. Draw 1 Unique Item or Exhibit Item.')");
		db.execSQL(sqlInsertCard + " (230,6,2)");
		db.execSQL(sqlInsertCardEnc + " (230,787)");
		db.execSQL(sqlInsertEnc + " (787,5,'The shopkeeper has purchased a display of kitschy Egyptian items to drum up business. Make a <b>Lore (+0) check</b>. If you fail, it looks realistic to you. If you pass, you point out a few items that are set up improperly, and help him rearrange the display. In return, he offers you any one non-<b>Weapon</b> Common Item at half price.')");
		db.execSQL(sqlInsertCardEnc + " (230,788)");
		db.execSQL(sqlInsertEnc + " (788,14,'You call around for a story, asking about mysterious occurrences related to the visiting museum exhibit. Make a <b>Luck (+0) check</b>. For each success, you may take 1 Clue token from any locations in Arkham and add it to your pool. If there are not Clue tokens in Arkham, you may not gain any.')");
		db.execSQL(sqlInsertCardEnc + " (230,789)");
		db.execSQL(sqlInsertEnc + " (789,24,'The station manager offers you a job helping to clean out the storage shed where lost and left-behind luggage is kept. Gain $3 and make a <b>Luck (-2) check</b>. If you pass, you may also draw 1 Unique Item or Exhibit Item.')");
		db.execSQL(sqlInsertCard + " (231,6,2)");
		db.execSQL(sqlInsertCardEnc + " (231,790)");
		db.execSQL(sqlInsertEnc + " (790,5,'\"Durn roof keeps leakin''... ruinin'' my wares!\" If you offer to fix the roof for the shopkeeper, make a <b>Speed (-1) check</b>. If you fail, you fall and lose 2 Stamina. If you pass, he is grateful, and offers to give you any Common Item in the deck with a value equal to or lower than your number of successes.')");
		db.execSQL(sqlInsertCardEnc + " (231,791)");
		db.execSQL(sqlInsertEnc + " (791,14,'A reporter will pay you handsomely, whether in money or information, for an expos\u00E9 on the life of a monster hunter. Discard any number of monster trophies to gain $2 or 1 Clue token (in any combination) for each point of toughness worth of monsters discarded.')");
		db.execSQL(sqlInsertCardEnc + " (231,792)");
		db.execSQL(sqlInsertEnc + " (792,24,'A wealthy foreigner steps off the train and mistakes you for his guide, handing you his baggage. Draw 1 Exhibit Item, 1 Unique Item, and 1 Common Item. Keep one of them and discard the rest. You must also take the Local Guide card.')");
	}

	private static void FetchMiskatonicEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		db.execSQL(sqlInsertCard + " (-27,5,9)");
		db.execSQL(sqlInsertCardEnc + " (-27,529)");
		db.execSQL(sqlInsertEnc + " (529,1,'The Dean would like you to escort the visiting Dr. Ali Kafour around Arkham and show him the sights. If you agree, you gain $3 as spending money, but must take the Local Guide card.')");
		db.execSQL(sqlInsertCardEnc + " (-27,530)");
		db.execSQL(sqlInsertEnc + " (530,12,'You overhear two men whispering about the visiting exhibit at the museum. \"They cannot discover our plans. We must destroy their tomes.\" One of them pulls out a lighter and begins to burn the books! Make a <b>Fight (-2) check</b>. If you pass, you chase them off. If you fail, they escape and you are blamed for the arson; place a Patrol marker on the street area of Miskatonic U.')");
		db.execSQL(sqlInsertCardEnc + " (-27,531)");
		db.execSQL(sqlInsertEnc + " (531,17,'You help a professor clean his classroom, and later on are shaking the chalk dust out of your clothes. Make a <b> Luck (-1) check</b>. If you fail, you cough and gag on the dust, losing 1 Stamina. If you pass, you realize that the dust is actually a mystical powder! You may search the Unique Item deck and take the Powder of Ibn-Ghazi card.')");
		db.execSQL(sqlInsertCard + " (-26,5,9)");
		db.execSQL(sqlInsertCardEnc + " (-26,532)");
		db.execSQL(sqlInsertEnc + " (532,1,'You overhear a history student complaining to his friend about a lack of materials for his Civil War thesis. If you attempt to enlighten him, he pays $1 for each Clue token you are willing to discard. Also, if you have the Cavalry Saber, Ancient Tome, or Old Journal Common Items, he will pay you double the listed cost for them.')");
		db.execSQL(sqlInsertCardEnc + " (-26,533)");
		db.execSQL(sqlInsertEnc + " (533,12,'Two archaeology students have fallen asleep over tomes on loan from the \"Legacy of the Pharaohs\" exhibit. Make a <b>Sneak (+1) check</b>. For every two successes (round down), you may draw 2 Spells, select one of them, and discard the other.')");
		db.execSQL(sqlInsertCardEnc + " (-26,534)");
		db.execSQL(sqlInsertEnc + " (534,17,'You turn a corner and come face to face with a hideous beast! Make a <b> Will (+0) check</b>. If you fail, you faint in horror and hit your head, suffering a mild concussion. Discard 1 Spell or Skill of your choice. If you succeed, you realize that it is just a statue on loan from the \"Legacy of the Pharaohs\" exhibit, and your turn ends.')");
		db.execSQL(sqlInsertCard + " (-25,5,9)");
		db.execSQL(sqlInsertCardEnc + " (-25,535)");
		db.execSQL(sqlInsertEnc + " (535,1,'A Miskatonic entomologist has heard rumors of an exotic species of beetle, previously only found along the Nile, that has been spotted in the campus hedgerows. Make a <b> Luck (-1) [2]</b> check to find it for her. If you pass, she gives you a $5 stipend for your work.')");
		db.execSQL(sqlInsertCardEnc + " (-25,536)");
		db.execSQL(sqlInsertEnc + " (536,12,'A poorly shelved collection of books falls on you. Make a <b>Speed (+1) check</b> or lose 1 Stamina. Regardless of your success or failure, a book lands open on the floor to a strange passage. Draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (-25,537)");
		db.execSQL(sqlInsertEnc + " (537,17,'Wandering the labs at night, you are surprised by a strange, winged, crab-like creature. It attacks! Make a <b> Speed (-2) check</b> and encounter a Mi-Go from the monster cup. If you fail the check, it seems to move with preternatural, and you may not use any investigator cards in this encounter.')");
		db.execSQL(sqlInsertCard + " (-24,5,9)");
		db.execSQL(sqlInsertCardEnc + " (-24,538)");
		db.execSQL(sqlInsertEnc + " (538,1,'You meet a research assistant who is quite taken with you. Roll a die. You gain that many free movement points, to be used immediately on any <i><b>Tome</b></i> or other item that requires an expenditure of movement points to use.')");
		db.execSQL(sqlInsertCardEnc + " (-24,539)");
		db.execSQL(sqlInsertEnc + " (539,12,'A young, shy history student bumps into you, dropping the package he is carrying. He apologizes profusely, stuttering as he avoids making eye contact. Make a <b>Will (-2) check</b>; if you are a female investigator, it is a <b>Will (+0) check</b>. If you succeed, he is so flustered that he dashes off without picking up the artifact. You may draw 1 Exhibit Item or Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (-24,540)");
		db.execSQL(sqlInsertEnc + " (540,17,'One of the janitors receives strange gifts from the faculty every Christmas. He offers to sell you \" one o'' them thar kooky books ''r thingamajigs.\" If you pay him $5, you may draw 1 Exhibit Item or Unique Item.')");
		db.execSQL(sqlInsertCard + " (-23,5,9)");
		db.execSQL(sqlInsertCardEnc + " (-23,541)");
		db.execSQL(sqlInsertEnc + " (541,1,'\"You there. Friend. You are from this town, yes?\" A poor foreign student wants to enroll at the university and asks if he can use your name because tuition is cheaper for local residents. If you agree, gain $10, but place a Patrol marker on the street area of Miskatonic U. The neighbors find it suspicious to have two people with the same name.')");
		db.execSQL(sqlInsertCardEnc + " (-23,542)");
		db.execSQL(sqlInsertEnc + " (542,12,'A young, shy anthropology student trips as she''s walking past you, dropping the artifact she is carrying into your hands. She apologizes profusely, adjusting her glasses and keeping her eyes on the floor. Make a <b>Will (-2) check</b>; if you are a male investigator, it is a <b>Will (+0) check</b>. If you succeed, she is so embarrassed that she dashes off without taking the artifact. You may draw 1 Exhibit Item or Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (-23,543)");
		db.execSQL(sqlInsertEnc + " (543,17,'The faculty at  Miskatonic is all abuzz about rumors of an invasion of exotic insect species in town. They have no time for you. You may immediately move to the Administration Building or the Library and have an encounter there.')");
		db.execSQL(sqlInsertCard + " (156,5,1)");
		db.execSQL(sqlInsertCardEnc + " (156,544)");
		db.execSQL(sqlInsertEnc + " (544,1,'Discuss the opportunity to sell a monograph with the President of the University. Pass a <b>Lore (-1) check</b> to make the sale and gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (156,545)");
		db.execSQL(sqlInsertEnc + " (545,12,'You look up to see Abigail Foreman leaning over you with hands on hips and a frustrated look on her face. Make a <b>Will (-1) check</b>. If you pass, she helps you find the book you were looking for. Take the first <i>Tome</i> from the Unique Item deck. If you fail, you''ve made too much noise. She escorts you out of the Library. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (156,546)");
		db.execSQL(sqlInsertEnc + " (546,17,'As you enter the Department of Alchemy, a professor looks up in horror. He grabs an ancient artifact from a locked drawer in his desk and holds it up before your face, chanting and making symbolic motions with the item. If you are <i>Cursed</i>, discard the Curse. If you are not <i>Cursed</i>, then you are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCard + " (157,5,8)");
		db.execSQL(sqlInsertCardEnc + " (157,547)");
		db.execSQL(sqlInsertEnc + " (547,1,'You own copies of some of the books being used this semester. Make a <b>Luck (+1) check</b> to find students willing to purchase your used copies of the texts. If you pass, gain $2.')");
		db.execSQL(sqlInsertCardEnc + " (157,548)");
		db.execSQL(sqlInsertEnc + " (548,12,'Someone left the door to the basement unlocked! There''s an abundance of texts and artifacts hidden away down here, but most of it is useless to you. Make a <b>Luck (-1) [2] check</b>. If you pass, gain 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (157,549)");
		db.execSQL(sqlInsertEnc + " (549,17,'Baffled scientists show you a wax cylinder which has apparently recorded the voices of people in the future, warning of what is to come. Make a <b>Lore (-2) check</b>. If you pass, you may look at the top three cards of the Mythos deck and then return them to the top of the deck in any order you choose.')");
		db.execSQL(sqlInsertCard + " (158,5,8)");
		db.execSQL(sqlInsertCardEnc + " (158,550)");
		db.execSQL(sqlInsertEnc + " (550,1,'You catch sight of one of the professors chanting quietly over talismans she had hidden in her desk. Make a <b>Sneak (-1) check</b> or she <i>Curses</i> you!')");
		db.execSQL(sqlInsertCardEnc + " (158,551)");
		db.execSQL(sqlInsertEnc + " (551,12,'The library has come into possession of an unidentified gramophone record. It is a recording of a strange language no one on the staff can interpret. Make a <b>Lore (-2) check</b> to see if you can make sense of the message. If you pass, you gain 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (158,552)");
		db.execSQL(sqlInsertEnc + " (552,17,'The staff is looking for exhausted or unhealthy subjects for medical experiments. If you are currently at less than your maximum Stamina, you may choose to gain $3. You must then make a <b>Luck (+0) [2] check</b>. If you succeed, you are restored to full Stamina. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (159,5,1)");
		db.execSQL(sqlInsertCardEnc + " (159,553)");
		db.execSQL(sqlInsertEnc + " (553,1,'You may choose to help an anthropology professor and his students decipher an ancient stone tablet. If so, make a <b>Lore (-2) check</b>. If you pass, you correctly interpret it, draw 1 Spell. If you fail, you mispronounce a word and are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (159,554)");
		db.execSQL(sqlInsertEnc + " (554,12,'You doze off and enter the Dreamlands. Have an encounter there, then immediately return here.')");
		db.execSQL(sqlInsertCardEnc + " (159,555)");
		db.execSQL(sqlInsertEnc + " (555,17,'You find a muscular, bored-looking man who challenges you to an arm wrestling match. Lose 2 Stamina if you accept. If this does not knock you unconscious, <b>Sir William Brinton</b> laughs and slaps your shoulder, offering to join your investigation. Take his Ally card. If it is not available, gain $5 instead.')");
		db.execSQL(sqlInsertCard + " (160,5,7)");
		db.execSQL(sqlInsertCardEnc + " (160,556)");
		db.execSQL(sqlInsertEnc + " (556,1,'You find yourself engrossed in a conversation with the Dean. He has to get to a fundraising event, but he offers you a ride on his way. Move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCardEnc + " (160,557)");
		db.execSQL(sqlInsertEnc + " (557,12,'The book seems to be on every shelf you turn to examine. Finally, seeing no other option, you take it with you. You are <i>Cursed,</i> and take the first <i><b>Tome</b></i> from the Unique Item deck.')");
		db.execSQL(sqlInsertCardEnc + " (160,558)");
		db.execSQL(sqlInsertEnc + " (558,17,'A graduate student explains that this is a stable gateway to another world. Theoretically. There are some kinks to work out still, of course. If you go through the gate, make a <b>Luck (+0) check</b>. If you pass, move to the Other World of your choice. If you fail, move to the <b>Woods</b> and immediately have an encounter there.')");
		db.execSQL(sqlInsertCard + " (161,5,8)");
		db.execSQL(sqlInsertCardEnc + " (161,559)");
		db.execSQL(sqlInsertEnc + " (559,1,'You encounter a student trying unsuccessfully to get a refund on tuition he overpaid. He''s having a hard time getting anyone to listen to him. Make a <b>Will (-2) check</b> to help him out. If you pass, he gets his refund and gratefull gives you $2.')");
		db.execSQL(sqlInsertCardEnc + " (161,560)");
		db.execSQL(sqlInsertEnc + " (560,12,'A particularly ancient and tattered text provides vital information. Make a <b>Lore (-2) check</b> and gain 1 Clue token for each success. Regardless of the result, lose 1 Stamina as the mold infiltrates your lungs.')");
		db.execSQL(sqlInsertCardEnc + " (161,561)");
		db.execSQL(sqlInsertEnc + " (561,17,'The Psychology Department would like to perform some deep hypnosis experiments on you. If you agree, make a <b>Will (-1) check</b>. If you pass, you make contact with a strange alien intelligence and gain 1 Spell. If you fail, the incident traumatizes you and you lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (162,5,7)");
		db.execSQL(sqlInsertCardEnc + " (162,562)");
		db.execSQL(sqlInsertEnc + " (562,1,'Discuss the opportunity to sell a monograph with the President of the University. Pass a <b>Lore (-1) check</b> to make the sale and gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (162,563)");
		db.execSQL(sqlInsertEnc + " (563,12,'In a shadowed section of the library, you find a pair of empty shoes lying near a musty, blood-spattered book. Wisely, you turn and leave. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (162,564)");
		db.execSQL(sqlInsertEnc + " (564,17,'You find a muscular, bored-looking man who challenges you to an arm wrestling match. Lose 2 Stamina if you accept. If this does not knock you unconscious, <b>Sir William Brinton</b> laughs and slaps your shoulder, offering to join your investigation. Take his Ally card. If it is not available, gain $5 instead.')");
		db.execSQL(sqlInsertCard + " (163,5,7)");
		db.execSQL(sqlInsertCardEnc + " (163,565)");
		db.execSQL(sqlInsertEnc + " (565,1,'You sneak into the back of a lecture on New England Coastal Folklore and Its Similarities to That of the South Seas Islanders. Gain 2 Clue tokens, then pass a <b>Will (-1) check</b> or lose 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (163,566)");
		db.execSQL(sqlInsertEnc + " (566,12,'You find a group of students cramming for exams. Help them by making a <b>Lore (-1) check</b>. If you pass, you realize that the students have no idea what they''re truly studying. Draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (163,567)");
		db.execSQL(sqlInsertEnc + " (567,17,'A professor with wild, bushy hair invites you to do the honors! He hurries out of the room and yells for you to pull the lever on his enormous, whirring machine. You may move any open gate from its current location to the unstable location of your choice.')");
		db.execSQL(sqlInsertCard + " (164,5,1)");
		db.execSQL(sqlInsertCardEnc + " (164,568)");
		db.execSQL(sqlInsertEnc + " (568,1,'A student mistakes you for the bursar. If you want to carry on the deception, make a <b>Will (-2) check</b>. If you pass, gain $8 in ill-gotten tuition money. If you fail, you''re arrested and taken to the Police Station.')");
		db.execSQL(sqlInsertCardEnc + " (164,569)");
		db.execSQL(sqlInsertEnc + " (569,12,'Pass a <b>Luck (-2) check</b> to find $5 someone was using as a bookmark.')");
		db.execSQL(sqlInsertCardEnc + " (164,570)");
		db.execSQL(sqlInsertEnc + " (570,17,'You find a student pounding on a strange device that he has hooked up to massive machinery. He states that it is a dimensional beam machine. If you offer to help him, make a <b> Lore (-2) check</b>. If you pass, beams shoot out in all directions, disrupting the gates open throughout the board. Roll a die for each open gate one at a time. On a success the gate is closed. However, you may not take it as a trophy, but instead return it to the pile of gate markers. If you fail, the machinery overheats and explodes. Roll a die and lose that much Stamina, then move to St. Mary''s Hospital.')");
		db.execSQL(sqlInsertCard + " (165,5,7)");
		db.execSQL(sqlInsertCardEnc + " (165,571)");
		db.execSQL(sqlInsertEnc + " (571,1,'You''re not sure how, but you find yourself interviewing for a guest lecturer position. Pass a <b>Will (-2) check</b> to gain a Retainer.')");
		db.execSQL(sqlInsertCardEnc + " (165,572)");
		db.execSQL(sqlInsertEnc + " (572,12,'Idly flipping open a tedious-looking novel, you discover that its binding is false - this is no novel, but something much more dire! Make a <b>Will (-1) check</b>. If you pass, take the first <i><b>Tome</b></i> from the Unique Item deck. If you fail, lose 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (165,573)");
		db.execSQL(sqlInsertEnc + " (573,17,'A chemistry professor offers you a draught of an experimental new concoction. If you accept, roll a die and set your current Stamina to the result of your die roll or your maximum Stamina, whichever is lower. Then do the same for your Sanity.')");
		db.execSQL(sqlInsertCard + " (166,5,1)");
		db.execSQL(sqlInsertCardEnc + " (166,574)");
		db.execSQL(sqlInsertEnc + " (574,1,'The Dean introduces you to an anthropology professor who gives you some insight into your investigation. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (166,575)");
		db.execSQL(sqlInsertEnc + " (575,12,'Make a <b>Will (+0) check</b> and consult the chart below:<br /><br />Successes:<br />:0) Abigail tosses you out. Move to the street.<br />:1) Abigail lets you into a private section of the library where you find an ancient tome. Draw 2 Spells and keep whichever one of them you want.<br />:2+) Abigail loans you one of the strange items in the library''s display case. Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (166,576)");
		db.execSQL(sqlInsertEnc + " (576,17,'Assisting a professor in his research, you find a valuable Spell. Draw 1 Spell. However, you must make a <b> Fight (-1) check</b> or some sticky-fingered student steals one of your items. Lose 1 Item of your choice.')");
		db.execSQL(sqlInsertCard + " (167,5,1)");
		db.execSQL(sqlInsertCardEnc + " (167,577)");
		db.execSQL(sqlInsertEnc + " (577,1,'Pass a <b>Will (-1) check</b> to get the Dean to offer you a retainer to write a manuscript for the college. Gain a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (167,578)");
		db.execSQL(sqlInsertEnc + " (578,12,'You find an unusual book that radiates evil at the touch. You begin to read and are drawn to it. Make a <b>Lore (-2) check</b>. If you pass, you obtain vast knowledge of the eldritch threat. Roll a die and gain that many Clue tokens. If you fail, the book consumes you-- mind and soul-- lose 2 Sanity and 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (167,579)");
		db.execSQL(sqlInsertEnc + " (579,17,'An archaeology professor shows you an item he recovered in an Egyptian pyramid. If you have 2 or fewer Spells, it glows in your hands and you find yourself outside, still holding it. Not wanting to confront the professor again, you decide to keep it. Gain 1 Unique Item and move to the street. If you have more than 2 Spells, nothing happens.')");
		db.execSQL(sqlInsertCard + " (168,5,1)");
		db.execSQL(sqlInsertCardEnc + " (168,580)");
		db.execSQL(sqlInsertEnc + " (580,1,'Your discussions on the Mythos lead campus security to conclude that you are off your rocker, and they escort you off campus. Move to Arkham Asylum and immediately have an encounter there.')");
		db.execSQL(sqlInsertCardEnc + " (168,581)");
		db.execSQL(sqlInsertEnc + " (581,12,'A book in a shadowy corner of the library begins to whisper terrible things to you. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (168,582)");
		db.execSQL(sqlInsertEnc + " (582,17,'A chemical brew bubbles on a nearby Bunsen burner. It smells delicious. If you drink it, make a <b> Luck (+0) check</b>. If you pass, the strange liquid fortifies you. Roll a die and gain that many points, split between your Stamina and Sanity however you like. If you fail, the liquid turns out to be coffee. Gain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (169,5,1)");
		db.execSQL(sqlInsertCardEnc + " (169,583)");
		db.execSQL(sqlInsertEnc + " (583,1,'Discuss the opportunity to sell a monograph with the President of the University. Pass a <b>Lore (-1) check</b> to make the sale and gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (169,584)");
		db.execSQL(sqlInsertEnc + " (584,12,'Overdue book fines of $4. Pay up, or move to the street!')");
		db.execSQL(sqlInsertCardEnc + " (169,585)");
		db.execSQL(sqlInsertEnc + " (585,17,'A professor of the occult asks you to hold a hideous statue that he believes to have strange powers while he reads a scroll. Energy shoots through your body. Make a <b> Luck (-1) check</b>. If you pass, your spirit rises from your body and you feel that you have the power to switch bodies with another investigator. You may choose another investigator from the pile of unused investigators and bring it into play as a new character, discarding your current investigator (along with all of his items, skills, trophies, etc.). If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (170,5,8)");
		db.execSQL(sqlInsertCardEnc + " (170,586)");
		db.execSQL(sqlInsertEnc + " (586,1,'A student is angrily complaining about his research being called \"too radical\". He needs funds badly and would be willing to sell you his work. You may pay $5 to draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (170,587)");
		db.execSQL(sqlInsertEnc + " (587,12,'You think you''ve found valuable information in this reference book, but a loud conversation near you is making it hard to concentrate. Make a <b>Will (-2) check</b> and gain 2 Clue tokens if you pass.')");
		db.execSQL(sqlInsertCardEnc + " (170,588)");
		db.execSQL(sqlInsertEnc + " (588,17,'A loud roaring noise emanates from a laboratory. Rushing to investigate, you see a swirling vortex collapsing in on itself, giving you a quick glimpse of the worlds beyond. Make a <b>Will (-2) check</b>. If you fail, lose 2 Sanity. Whether you succeed or not, if you are not driven insane, gain 1 Unique Item that the spiralling anomaly transports into the room.')");
		db.execSQL(sqlInsertCard + " (171,5,3)");
		db.execSQL(sqlInsertCardEnc + " (171,589)");
		db.execSQL(sqlInsertEnc + " (589,1,'Fear has swept through the campus and a mob has gathered at the steps of the Administration Building. Make a <b>Will (-1) check</b> to convince the students that everything is under control. If you succeed, gain $5 from a grateful University president. If you fail, increase the terror level by 1.')");
		db.execSQL(sqlInsertCardEnc + " (171,590)");
		db.execSQL(sqlInsertEnc + " (590,12,'Glancing over the shoulder of a dark-skinned man to see the book he''s reading, you''re startled to see that it''s written in an ancient language that only a few people, including yourself, can read. Pass a <b>Lore (-2) check</b> to absorb the information before he notices. If you pass, draw 1 Spell. If you fail, he notices you too soon, shuts the book, and takes it with him out of the library.')");
		db.execSQL(sqlInsertCardEnc + " (171,591)");
		db.execSQL(sqlInsertEnc + " (591,17,'\"Jazz\" Mulligan, the head janitor at the college, catches you wandering around in a restricted area of the building and escorts you outside. Move to the street.')");
		db.execSQL(sqlInsertCard + " (172,5,3)");
		db.execSQL(sqlInsertCardEnc + " (172,592)");
		db.execSQL(sqlInsertEnc + " (592,1,'One of the campus police overhears you talking about the occult and gently escorts you off campus, leaving you in Independence Square. Immediately move to Independence Square and have an encounter there.')");
		db.execSQL(sqlInsertCardEnc + " (172,593)");
		db.execSQL(sqlInsertEnc + " (593,12,'If you''re carrying a <i><b>Tome</b></i>, a shady man in the corner of the library motions you over. \"It just so happens that I''ve been looking for that book for some time. In exchange for it, I''d be happy to give you some information that could prove vital to you.\" You may discard a <i><b>Tome</b></i> to gain 3 Clue tokens. If you don''t have a <i><b>Tome</b></i>, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (172,594)");
		db.execSQL(sqlInsertEnc + " (594,17,'The shattered remains of an unusual object lie here. With some perseverance and luck, you might be able to reassemble it. Stay here next turn to make a <b> Luck (-1) check</b>. If you pass, draw 1 Unique Item. If you fail the check or choose not to attempt it, you have no idea how to reassemble the item. Nothing happens.')");
		db.execSQL(sqlInsertCard + " (173,5,3)");
		db.execSQL(sqlInsertCardEnc + " (173,595)");
		db.execSQL(sqlInsertEnc + " (595,1,'Sitting on one of a table, you find a silver whistle and a small scrap of paper with some unusual writing on it. If you pass a <b>Lore (-1) check</b>, then you may search the Spell deck for a Summon Shantak card and take it. If you fail, you leave the whistle there, not realizing its value.')");
		db.execSQL(sqlInsertCardEnc + " (173,596)");
		db.execSQL(sqlInsertEnc + " (596,12,'Make a <b>Luck (-2) check</b>. If you pass, you find an unusual item hidden between the books on the shelf. Draw 1 Unique Item. If you fail, you accidentally knock over a large pile of books and Abigail Foreman primly escorts you from the premises. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (173,597)");
		db.execSQL(sqlInsertEnc + " (597,17,'You are startled to hear a screech of pain from one of the labs, and you rush in just in time to see a large saw blade slice into a monkey''s brain. It seems that a vivisection is in progress. Staggering back outside, you are violently ill. Lose 1 Sanity and 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (174,5,3)");
		db.execSQL(sqlInsertCardEnc + " (174,598)");
		db.execSQL(sqlInsertEnc + " (598,1,'You discuss the opportunity to sell a monograph with the President of the University. Pass a <b>Lore (-1) check</b> to make the sale and gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (174,599)");
		db.execSQL(sqlInsertEnc + " (599,12,'If the <b>Rare Book Collection</b> card is facedown and you have the Necronomicon, Abigail Foreman approaches you, eying the book. \"Wherever did you get that book? We''ve been looking for another copy of it for years. I know it''s quite valuable, but if you''ll donate it to our collection, I''ll give you unrestricted access to the rare books. We have quite a collection!\" You may return the Necronomicon to the box to turn the <b>Rare Book Collection</b> card faceup. \"Oh, thank you so much! You won''t regret it!\" If the <b>Rare Books Collection</b> card is faceup, if you do not have the Necronomicon, or if you do not want to discard the Necronomicon, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (174,600)");
		db.execSQL(sqlInsertEnc + " (600,17,'As you enter a darkened laboratory, a monster appears and attacks you!')");
		db.execSQL(sqlInsertCard + " (175,5,3)");
		db.execSQL(sqlInsertCardEnc + " (175,601)");
		db.execSQL(sqlInsertEnc + " (601,1,'Pass a <b>Will (-1) check</b> to get the Dean to offer you a retainer to write a manuscript for the college. Gain a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (175,602)");
		db.execSQL(sqlInsertEnc + " (602,12,'The college''s head janitor, \"Jazz\" Mulligan pauses in his sweeping to look you over. \"Hey, I found something pretty interesting that they were throwing out of the library. I''ll let you have it for $3.\" You may pay $3 to draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (175,603)");
		db.execSQL(sqlInsertEnc + " (603,17,'You discover a dusty machine in a lab that hasn''t been used for several years. It appears to still be in working condition. If you wish, you may pull either the white or the black lever on the machine. If you do, all non-spawn, non-flying monsters in Arkham move in the direction of the arrow that is the same color as the lever you pulled. Monsters move normally in this fashion regardless of their actual movement type (i.e., all monsters are considered to be black-bordered for this purpose).')");
		db.execSQL(sqlInsertCard + " (176,5,3)");
		db.execSQL(sqlInsertCardEnc + " (176,604)");
		db.execSQL(sqlInsertEnc + " (604,1,'Talking with one of the professors, he seems very interested in your intellectual potential and offers to sponsor you for a partial scholarship. You may pay $4 to draw 2 Skills, keeping one of them and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (176,605)");
		db.execSQL(sqlInsertEnc + " (605,12,'Looking through one of the older books, you come across note note in its margin written in a crabbed hand. Make a <b>Lore (-1) check</b>. If you pass, you are able to decipher it. Draw 1 Spell. If you fail, you return the book to the shelf, none the wiser.')");
		db.execSQL(sqlInsertCardEnc + " (176,606)");
		db.execSQL(sqlInsertEnc + " (606,17,'You find a muscular, bored-looking man who challenges you to an arm wrestling match. Lose 2 Stamina if you accept. If this does not knock you unconscious, <b>Sir William Brinton</b> laughs and slaps your shoulder, offering to join your investigation. Take his Ally card. If it is not available, gain $5 instead.')");
		db.execSQL(sqlInsertCard + " (177,5,3)");
		db.execSQL(sqlInsertCardEnc + " (177,607)");
		db.execSQL(sqlInsertEnc + " (607,1,'\"Jazz\" Mulligan, the college''s head janitor, is here, mopping something up. \"You shouldn''t look in that room, now. It''s not a sight for decent folks, and the police are already on the case.\" Despite his warning, you take a peek and lose 1 Sanity as you see the red mess he''s cleaning up.')");
		db.execSQL(sqlInsertCardEnc + " (177,608)");
		db.execSQL(sqlInsertEnc + " (608,12,'If you have a <i><b>Tome</b></i> from the Unique Item deck, Abigail Foreman walks up to you. \"I can''t help but notice that book you''re carrying. I have some discretionary funds for acquisitions at my disposal, and if you''re agreeable, I''d like to purchase it for $10.\" If you agree, discard the <i><b>Tome</b></i> and gain $10. If you do not have a <i><b>Tome</b></i> from the Unique Item deck, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (177,609)");
		db.execSQL(sqlInsertEnc + " (609,17,'In this room, you discover a powerful weapon. If you dare activate it, roll a die for each monster on the board. On a success, the monster is returned to the  cup. On a failure, nothing happens. Afterwards, roll a die for yourself and lose that much Stamina.')");
		db.execSQL(sqlInsertCard + " (178,5,2)");
		db.execSQL(sqlInsertCardEnc + " (178,610)");
		db.execSQL(sqlInsertEnc + " (610,1,'\"You there. Friend. You are from this town, yes?\" A poor foreign student wants to enroll at the university, and asks if he can use your name because tuition is cheaper for local residents. If you agree, gain $10, but you are <i>Barred from Miskatonic U.</i>')");
		db.execSQL(sqlInsertCardEnc + " (178,611)");
		db.execSQL(sqlInsertEnc + " (611,12,'A young, shy anthropology student trips as she''s walking past you, dropping the artifact she is carrying into your hands. She apologizes profusely, adjusting her glasses and keeping her eyes on the floor. Make a <b>Will (-2) check</b>; if you are a male investigator, it is a <b>Will (+0) check</b>. If you succeed, she is so embarrassed that she dashes off without taking the artifact. You may draw 1 Exhibit Item or Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (178,612)");
		db.execSQL(sqlInsertEnc + " (612,17,'The faculty at  Miskatonic is all abuzz about rumors of an invasion of exotic insect species in town. They have no time for you. You may immediately move to the Administration Building or the Library and have an encounter there.')");
		db.execSQL(sqlInsertCard + " (179,5,6)");
		db.execSQL(sqlInsertCardEnc + " (179,613)");
		db.execSQL(sqlInsertEnc + " (613,1,'A familiar name appears as you pore over the student files. Make a <b>Lore (-2) check</b> and gain 1 Clue token for each success.')");
		db.execSQL(sqlInsertCardEnc + " (179,614)");
		db.execSQL(sqlInsertEnc + " (614,12,'You spy a suspicious-looking man attempting to sneak a rare book out of the building. Make a <b>Fight (+1) check</b> to stop him. If you succeed, a grateful Abigail Foreman offers you $3 as reward. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (179,615)");
		db.execSQL(sqlInsertEnc + " (615,17,'An experiment on dogs has gone horribly awry and now a student is willing to pay to get rid of the evidence. If you agree to help, pass a <b> Sneak (+0) check</b> to gain $3.')");
		db.execSQL(sqlInsertCard + " (180,5,2)");
		db.execSQL(sqlInsertCardEnc + " (180,616)");
		db.execSQL(sqlInsertEnc + " (616,1,'You meet a research assistant who is quite taken with you. Roll a die. You gain that many free movement points, to be used immediately on any <i><b>Tome</b></i> or other item that requires an expenditure of movement points to use.')");
		db.execSQL(sqlInsertCardEnc + " (180,617)");
		db.execSQL(sqlInsertEnc + " (617,12,'A young, shy history student bumps into you, dropping the package he is carrying. He apologizes profusely, stuttering as he avoids making eye contact. Make a <b>Will (-2) check</b>; if you are a female investigator, it is a <b>Will (+0) check</b>. If you succeed, he is so flustered that he dashes off without picking up the artifact. You may draw 1 Exhibit Item or Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (180,618)");
		db.execSQL(sqlInsertEnc + " (618,17,'One of the janitors receives strange gifts from the faculty every Christmas. He offers to sell you \" one o'' them thar kooky books ''r thingamajigs.\" If you pay him $5, you may draw 1 Exhibit Item or Unique Item.')");
		db.execSQL(sqlInsertCard + " (181,5,2)");
		db.execSQL(sqlInsertCardEnc + " (181,619)");
		db.execSQL(sqlInsertEnc + " (619,1,'A Miskatonic entomologist has heard rumors of an exotic species of beetle, previously only found along the Nile, that has been spotted in the campus hedgerows. Make a <b> Luck (-1) [2]</b> check to find it for her. If you pass, she gives you a $5 stipend for your work.')");
		db.execSQL(sqlInsertCardEnc + " (181,620)");
		db.execSQL(sqlInsertEnc + " (620,12,'A poorly shelved collection of books falls on you. Make a <b>Speed (+1) check</b> or lose 1 Stamina. Regardless of your success or failure, a book lands open on the floor to a strange passage. Draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (181,621)");
		db.execSQL(sqlInsertEnc + " (621,17,'Wandering the labs at night, you are surprised by a strange, winged, crab-like creature. It attacks! Make a <b> Speed (-2) check</b> and encounter a Mi-Go from the monster cup. If you fail the check, it seems to move with preternatural, and you may not use any investigator cards in this encounter.')");
		db.execSQL(sqlInsertCard + " (182,5,2)");
		db.execSQL(sqlInsertCardEnc + " (182,622)");
		db.execSQL(sqlInsertEnc + " (622,1,'You overhear a history student complaining to his friend about a lack of materials for his Civil War thesis. If you attempt to enlighten him, he pays $1 for each Clue token you are willing to discard. Also, if you have the Cavalry Saber, Ancient Tome, or Old Journal Common Items, he will pay you double the listed cost for them.')");
		db.execSQL(sqlInsertCardEnc + " (182,623)");
		db.execSQL(sqlInsertEnc + " (623,12,'Two archaeology students have fallen asleep over tomes on loan from the \"Legacy of the Pharaohs\" exhibit. Make a <b>Sneak (+1) check</b>. For every two successes (round down), you may draw 2 Spells, select one of them, and discard the other.')");
		db.execSQL(sqlInsertCardEnc + " (182,624)");
		db.execSQL(sqlInsertEnc + " (624,17,'You turn a corner and come face to face with a hideous beast! Make a <b> Will (+0) check</b>. If you fail, you faint in horror and hit your head, suffering a mild concussion. Discard 1 Spell or Skill of your choice. If you succeed, you realize that it is just a statue on loan from the \"Legacy of the Pharaohs\" exhibit, and your turn ends.')");
		db.execSQL(sqlInsertCard + " (183,5,4)");
		db.execSQL(sqlInsertCardEnc + " (183,625)");
		db.execSQL(sqlInsertEnc + " (625,1,'A professor of the occult pays you to post signs throughout the campus that he claims will ward off danger. However, the signs carry their own danger Gain $4, but pass a <b>Will (-2) check</b> or lose 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (183,626)");
		db.execSQL(sqlInsertEnc + " (626,12,'The doors close with a bang! You bolt upright from the book you fell asleep over. The library is closed for the night, and you are locked in. You are <i>delayed</i>. However, you may search the Unique Item deck and take the first <i><b>Tome</b></i> you find.')");
		db.execSQL(sqlInsertCardEnc + " (183,627)");
		db.execSQL(sqlInsertEnc + " (627,17,'You watch, disturbed, as two students immerse a live rabbit in fluid, instantly transforming it to marble! Make a <b> Sneak (-1) check</b> to take the fluid before they can do anything dangerous with it. If you pass, search the Unique Item deck for Petrifying Solution and take it. If you fail, they catch you in the act and splash some of the fluid on you. You are <i>delayed</i>.')");
		db.execSQL(sqlInsertCard + " (184,5,5)");
		db.execSQL(sqlInsertCardEnc + " (184,628)");
		db.execSQL(sqlInsertEnc + " (628,1,'A professor takes an interest in your presence and beckons for you to follow him. In a back room, he explains that he can provide you with knowledge that may be of use to you, although his experimental teaching method may cause other things to be unlearned. You may discard a Skill to draw a new Skill and take 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (184,629)");
		db.execSQL(sqlInsertEnc + " (629,12,'Although it is not yet time to close, security seems to be kicking everyone out of the Library. Pass a <b>Sneak (-1) check</b> or move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (184,630)");
		db.execSQL(sqlInsertEnc + " (630,17,'The science professor beckons you into his office. He points at a strange device on his workbench. \"Want to try it out?\" Pass a <b> Luck (-2) check</b> to return all monsters in the Sky and the Outskirts to the monster cup. You may choose one of them to keep as a monster trophy.')");
		db.execSQL(sqlInsertCard + " (185,5,4)");
		db.execSQL(sqlInsertCardEnc + " (185,631)");
		db.execSQL(sqlInsertEnc + " (631,1,'As students start leaving town in fear of their safety, the University begins to offer discounts on tuition and services. You may pay $5 to draw 2 Skills, keeping one and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (185,632)");
		db.execSQL(sqlInsertEnc + " (632,12,'Some archaeology professors seem to be having a wager, and they call you into the room to have fun at your expense. \"Be a good sport, and try to pick out the antique from these fakes we made up, will you?\" If you pass a <b>Lore (-1) check</b>, you may draw and keep 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (185,633)");
		db.execSQL(sqlInsertEnc + " (633,17,'A lab fire breaks out and the students are trapped inside! If you force your way in and save them, make a <b> Fight (-2) check</b>. If you pass, you rescue the students and one of the rewards you with a family heirloom. Draw 1 Unique Item. If you fail, lose 2 Stamina.')");
		db.execSQL(sqlInsertCard + " (186,5,4)");
		db.execSQL(sqlInsertCardEnc + " (186,634)");
		db.execSQL(sqlInsertEnc + " (634,1,'Make a <b>Luck (+0) check</b>. If you pass, your request for a stipend came through and you gain $2. If you fail, the processing fees come due, and you lose $1.')");
		db.execSQL(sqlInsertCardEnc + " (186,635)");
		db.execSQL(sqlInsertEnc + " (635,12,'You aren''t the only one interested in \"The King in Yellow.\" All Maniacs and Cultists in Arkham, the Sky, and the Outskirts move to your location. You must immediately evade or defeat them.')");
		db.execSQL(sqlInsertCardEnc + " (186,636)");
		db.execSQL(sqlInsertEnc + " (636,17,'\"It''s a simple transference principle, really,\" the professor explains. \"Simply place an everyday item on this platform...\" If you discard a Common Item, you may roll a number of dice equal to the item''s cost. You may draw a number of cards from the Unique Item deck equal to the number of successes rolled, keeping one and discarding the rest.')");
		db.execSQL(sqlInsertCard + " (187,5,5)");
		db.execSQL(sqlInsertCardEnc + " (187,637)");
		db.execSQL(sqlInsertEnc + " (637,1,'One of the students volunteering at the Office of the President slips you a note concerning a strange occurrence at the Library. Move to the Library and draw 2 cards, choosing one of them to encounter, and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (187,638)");
		db.execSQL(sqlInsertEnc + " (638,12,'While searching the card catalog for something else, you stumble across a forgotten card with crabbed, egnimatic scribbling on the back. You follow the lost clue to a most wondrous treasure. If you wish, you may discard a <i><b>Tome</b></i> to search the Unique Item deck and take the Necronomicon.')");
		db.execSQL(sqlInsertCardEnc + " (187,639)");
		db.execSQL(sqlInsertEnc + " (639,17,'The professor of arcane studies tells you of a sealed tomb that only the enlightened may open. Pass a <b> Lore (-2) check</b> to flip over the top three mythos cards and choose one of them. If there is an open gate at the gate opening location on that card, that gate is sealed.')");
		db.execSQL(sqlInsertCard + " (188,5,6)");
		db.execSQL(sqlInsertCardEnc + " (188,640)");
		db.execSQL(sqlInsertEnc + " (640,1,'Pass a <b>Will (-1) check</b> to get the Dean to offer you a retainer to write a manuscript for the college. Gain a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (188,641)");
		db.execSQL(sqlInsertEnc + " (641,12,'The text you are reading is accompanied by a gruesome collection of medieval illustrations. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (188,642)");
		db.execSQL(sqlInsertEnc + " (642,17,'You discover a mutilated corpse, the victim of some creature that seems to have escaped. Lose 1 Sanity, and a monster appears in the Miskatonic U. street!')");
		db.execSQL(sqlInsertCard + " (189,5,2)");
		db.execSQL(sqlInsertCardEnc + " (189,643)");
		db.execSQL(sqlInsertEnc + " (643,1,'The Dean would like you to escort the visiting Dr. Ali Kafour around Arkham and show him the sights. If you agree, you gain $3 as spending money, but must take the Local Guide card.')");
		db.execSQL(sqlInsertCardEnc + " (189,644)");
		db.execSQL(sqlInsertEnc + " (644,12,'You overhear two men whispering about the visiting exhibit at the museum. \"They cannot discover our plans. We must destroy their tomes.\" One of them pulls out a lighter and begins to burn the books! Make a <b>Fight (-2) check</b>. If you pass, you chase them off. If you fail, they escape and you are blamed for the arson; you are <i>Barred from Miskatonic U.</i>')");
		db.execSQL(sqlInsertCardEnc + " (189,645)");
		db.execSQL(sqlInsertEnc + " (645,17,'You help a professor clean his classroom, and later on are shaking the chalk dust out of your clothes. Make a <b> Luck (-1) check</b>. If you fail, you cough and gag on the dust, losing 1 Stamina. If you pass, you realize that the dust is actually a mystical powder! You may search the Unique Item deck and take the Powder of Ibn-Ghazi card.')");
		db.execSQL(sqlInsertCard + " (190,5,6)");
		db.execSQL(sqlInsertCardEnc + " (190,646)");
		db.execSQL(sqlInsertEnc + " (646,1,'The University is hosting their annual fundraising gala. It costs $3 to attend. If you do, make a <b>Luck (+0) check</b> and consult the chart below.<br /><br />Successes:<br />:0) A pleasant, but uneventful evening.<br />:1) The Head of the Anthropology Dept. is feeling chatty. Gain 1 Clue token as he elaborates on his recent work.<br />:2+) You''ve won the door prize! Draw a Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (190,647)");
		db.execSQL(sqlInsertEnc + " (647,12,'Abigail Foreman set aside a book for you, but someone seems to have moved it. You are <i>delayed</i> while she searches for it. Search the Unique Item deck and take the first <i><b>Tome</b></i> you find.')");
		db.execSQL(sqlInsertCardEnc + " (190,648)");
		db.execSQL(sqlInsertEnc + " (648,17,'The professors are willing to try some radical procedures for your condition. For every $3 you spend you may return one of your Corruption cards to the box.')");
		db.execSQL(sqlInsertCard + " (191,5,4)");
		db.execSQL(sqlInsertCardEnc + " (191,649)");
		db.execSQL(sqlInsertEnc + " (649,1,'You are asked to speak to the students regarding Lost Carcosa. Pass a <b>Lore (-1) check</b> to gain $1 for each success you roll.')");
		db.execSQL(sqlInsertCardEnc + " (191,650)");
		db.execSQL(sqlInsertEnc + " (650,12,'You check out a book of essays on the infamous \"The King in Yellow.\" Make a <b>Will (+0) check</b>. If you pass, you find a Spell scribbled in the margins. If you fail, you lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (191,651)");
		db.execSQL(sqlInsertEnc + " (651,17,'When paranoia and fear set in, accidents are more common. Make a <b>Speed check</b> with a penalty equal to the current terror level. If you fail, your Stamina is reduced to 0 in a lab accident.')");
		db.execSQL(sqlInsertCard + " (192,5,6)");
		db.execSQL(sqlInsertCardEnc + " (192,652)");
		db.execSQL(sqlInsertEnc + " (652,1,'You find it difficult to navigate the University''s bureaucracy. You are <i>delayed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (192,653)");
		db.execSQL(sqlInsertEnc + " (653,12,'Engrossed in your reading, you suddenly notice the Library is locking up for the evening. Make a <b>Speed (+0) check</b>. If you succeed, move to the street. If not, you are <i>delayed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (192,654)");
		db.execSQL(sqlInsertEnc + " (654,17,'Despite your sense of larger forces influencing your actions, more rational minds convince you that there is no such thing as blessings or curses. Discard any <i>Blessing</i> or <i>Curse</i> cards you have.')");
		db.execSQL(sqlInsertCard + " (193,5,5)");
		db.execSQL(sqlInsertCardEnc + " (193,655)");
		db.execSQL(sqlInsertEnc + " (655,1,'You go into the University President''s office for a chat. Upon entering, you learn that another investigator has recently been here interrogating the President about the same activities that brought you here. Pass a <b>Will (-2) check</b> to choose another investigator; each of you gains a Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (193,656)");
		db.execSQL(sqlInsertEnc + " (656,12,'You notice a strangely bound manuscript as you scan the titles of books on a shelf. When you attempt to pull it from the shelf, it tilts slightly and then pulls you into itself! Go to either Unknown Kadath or the Plateau of Leng (your choice) and have an encounter there before returning.')");
		db.execSQL(sqlInsertCardEnc + " (193,657)");
		db.execSQL(sqlInsertEnc + " (657,17,'The professor has set up an experiment to transfer knowledge from one person to another. You may choose another investigator and give him one of your Skills. He must then give you a different Skill back, if he has one.')");
		db.execSQL(sqlInsertCard + " (194,5,5)");
		db.execSQL(sqlInsertCardEnc + " (194,658)");
		db.execSQL(sqlInsertEnc + " (658,1,'You run into the Dean and try to convince him to let you write a manuscript for the college. Pass a <b>Will (-1) check</b> to take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (194,659)");
		db.execSQL(sqlInsertEnc + " (659,12,'The Librarian seems entranced by a book whose pages ripple as if in the wind, even when she''s not touching it. As you approach, she slams it shut and tells you to mind your own business. \"But madam,\" you begin... Pass a <b>Will (-1) check</b> to take the first <i><b>Tome</b></i> from the Unique Item deck. If you fail, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (194,660)");
		db.execSQL(sqlInsertEnc + " (660,17,'You pass a room where a muscular, bored-looking man stands before a pile of groaning, fallen men. \"What about you?\" he calls out to you. \"Can you take a punch?\" If you allow him to drive his fist into your gut, lose 2 Stamina. If this does not knock you unconscious, take <b>Sir William Brinton''s</b> Ally card, or, if it''s not available, take $5 instead.')");
	}

	
	private static void FetchMerchantEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		db.execSQL(sqlInsertCard + " (-22,4,9)");
		db.execSQL(sqlInsertCardEnc + " (-22,397)");
		db.execSQL(sqlInsertEnc + " (397,16,'A rowdy dock hand doesn''t like the looks of you and challenges you to a fistfight. Make a <b>Fight (+1) [2] check</b>. If you pass, lose 1 Stamina, but you may search the Skill deck for the Fight card and take it. If you fail, the dock workers spit on you, and you run off. Lose 2 Stamina and place a Patrol marker on the street area of the Merchant District.')");
		db.execSQL(sqlInsertCardEnc + " (-22,398)");
		db.execSQL(sqlInsertEnc + " (398,22,'The house calls to you. If you follow its voice, it tells you which floorboards to pry up. You may draw 1 Unique item or Exhibit Item, but must also take the Tainted card.')");
		db.execSQL(sqlInsertCardEnc + " (-22,399)");
		db.execSQL(sqlInsertEnc + " (399,25,'Something calls to you from the island''s heart... if only you could find it! Make a <b>Luck (-2) check</b> or exhaust the Find Gate spell, Dynamite item, or Gate Box item to automatically pass. If you pass, you manage to create a tunnel down into the earth. Gain 1d6 Clue tokens. If you exhausted an item or spell to pass the check and gained more that 3 Clue tokens, you must discard the item or spell used.')");
		db.execSQL(sqlInsertCard + " (-21,4,9)");
		db.execSQL(sqlInsertCardEnc + " (-21,400)");
		db.execSQL(sqlInsertEnc + " (400,16,'A load of cargo, precariously balanced on the edge of the dock, goes into the river with a splash. If you dive in and try to retrieve it, a monster appears, and you suffer a -1 to your <b>Combat checks</b>. If you evade or defeat the monster, you may draw 2 Common Items.')");
		db.execSQL(sqlInsertCardEnc + " (-21,401)");
		db.execSQL(sqlInsertEnc + " (401,22,'You see a warped mirror. If you look into it, you see yourself in another time and place, holding an ankh in one hand and a sacrificial blade in the other. Your number of Clue tokens doubles, but if you gain more than 3 Clue tokens in this manner, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (-21,402)");
		db.execSQL(sqlInsertEnc + " (402,25,'A man wearing exotic robes and a strange hat sits in a shaded clearing, seemingly in a trance. As you approach, he says, \"Come sit with me,\" without looking at you. If you are <i>Cursed</i> or have any <i><b>Mask</b></i> items, he tells you that he is called <b>The Messenger</b> and is meant to aid you. Take his Ally card or, if it is not available, gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCard + " (-20,4,9)");
		db.execSQL(sqlInsertCardEnc + " (-20,403)");
		db.execSQL(sqlInsertEnc + " (403,16,'You see men of questionable character guiding one of the visiting museum curators toward the edge of the dock...his hands are tied! He pleads to you for help with silent eyes. If you aid him, make a <b>Fight (-2) check</b>. If you pass, you wrest the weapon from one and chase them off; you may search the Common Item deck and take the Tommy Gun card. If you fail, lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (-20,404)");
		db.execSQL(sqlInsertEnc + " (404,22,'A group of cultists scampers through the night. If you follow them, make a <b>Sneak (+0) check</b> to watch where they bury their prize. If you pass, you may draw 1 Unique Item or Exhibit Item. If you fail, they turn and smile: a monster <i>surprises</i> you from behind!')");
		db.execSQL(sqlInsertCardEnc + " (-20,405)");
		db.execSQL(sqlInsertEnc + " (405,25,'You come upon a tree that has grown, cancer-like, around an ancient prayer plaque. Make a <b>Fight (-2) check</b> or exhaust the Wither spell, Shrivelling spell, or the Axe item to automatically pass. If you pass, draw Spells equal to your focus.')");
		db.execSQL(sqlInsertCard + " (-19,4,9)");
		db.execSQL(sqlInsertCardEnc + " (-19,406)");
		db.execSQL(sqlInsertEnc + " (406,16,'You stare into the river, contemplating its currents and depths. Make a <b>Luck (+0) check</b>. If you pass, you realize that time, fate, all of reality, are like a river; take the Visions card. If you fail, a pair of dock workers knock you into the river as a lark, and you catch a cold. Lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (-19,407)");
		db.execSQL(sqlInsertEnc + " (407,22,'Luck finds those who need it. If you Luck is 1 or lower, you find a luck penny between the floorboards. You may search the Skill deck and take the Luck card.')");
		db.execSQL(sqlInsertCardEnc + " (-19,408)");
		db.execSQL(sqlInsertEnc + " (408,25,'You see a group of masked Egyptian cultists performing a hideous ritual in a clearing. If you wish to get closer and listen, make a <b>Sneak (+0) check</b>. If you pass, draw 1 Spell. If you fail, the look up as one and point at you, and you know that you are marked. Place a Patrol marker on the street area of the Merchant District, as an aura of unnaturalness surrounds you.')");
		db.execSQL(sqlInsertCard + " (-18,4,9)");
		db.execSQL(sqlInsertCardEnc + " (-18,409)");
		db.execSQL(sqlInsertEnc + " (409,16,'The docks are overloaded with shipments coming in to support the museum exhibit. No one will notice if something goes missing. Make a <b>Sneak (-1) check</b>. For each success, you may draw 1 Common Item. You may keep any non-<b>Weapon</b> cards, and must discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (-18,410)");
		db.execSQL(sqlInsertEnc + " (410,22,'You pass the strange house and find yourself face to face with a foreign man with a penetrating gaze. If you have any Exhibit Items or your Will is 2 or lower, he seems to approve of your simpering manner, and he introduces himself as <b>Dr. Ali Kafour</b>. Take his Ally card or, if it is not available, listen to him expound upon the ancient Egyptian pantheon as it compares to that of Native American myths: Gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (-18,411)");
		db.execSQL(sqlInsertEnc + " (411,25,'As you row along the island''s shore, a tree branch cracks and falls toward you. Make a <b>Speed (+0) check</b>. If you fail, you are knocked out and wake up far downstream; move to the Graveyard and you turn ends.')");
		db.execSQL(sqlInsertCard + " (116,4,4)");
		db.execSQL(sqlInsertCardEnc + " (116,412)");
		db.execSQL(sqlInsertEnc + " (412,16,'The leading lady of \"The King in Yellow\" arrives via a steamer packet from the coast. She confuses you for a porter and hands you her bags to carry. Make a <b>Luck (-1) check</b>. If you pass, she leaves one of them with you as a souvenir. Draw 1 Common Item. If you fail, she accuses you of trying to steal it and you are <i>arrested</i>.')");
		db.execSQL(sqlInsertCardEnc + " (116,413)");
		db.execSQL(sqlInsertEnc + " (413,22,'A gleam of metal draws your attention to the fireplace, which suddenly ignites! You may attempt a <b>Speed (-3) check</b> to pull an item from the fire before it is destroyed. If you pass, draw 1 Unique Item. If you attempt it and fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (116,414)");
		db.execSQL(sqlInsertEnc + " (414,25,'You watch two women walk the island while they speak of the Hyades, Hali, and Lost Carcosa. Gain 1 Clue token, then make a <b>Sneak (-2) check</b>. If you pass, you hear further details, gaining 1 more Clue token. If you fail, they see you and call upon protection. A monster appears!')");
		db.execSQL(sqlInsertCard + " (117,4,4)");
		db.execSQL(sqlInsertCardEnc + " (117,415)");
		db.execSQL(sqlInsertEnc + " (415,16,'If you have any <i><b>Tomes</b></i> but no <i><b>Weapons</b></i>, a crew of roustabouts mocks you for your \"book learning\" and begins to push you around. Lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (117,416)");
		db.execSQL(sqlInsertEnc + " (416,22,'A voice - perhaps the house itself - begins whispering to you. Make a <b>Will (-2) check</b>. Gain 1 Clue token for each success, but lose either 1 Stamina or 1 Sanity if you fail.')");
		db.execSQL(sqlInsertCardEnc + " (117,417)");
		db.execSQL(sqlInsertEnc + " (417,25,'A monster is attacking a huddled figure in the shadows. If you pass the first <b>Combat check</b> you make against the monster, you may draw a random Ally or Spell.')");
		db.execSQL(sqlInsertCard + " (118,4,4)");
		db.execSQL(sqlInsertCardEnc + " (118,418)");
		db.execSQL(sqlInsertEnc + " (418,16,'A crate bobs by the dock. Pass a <b>Fight (-2) check</b> to pull it from the river and draw 1 Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (118,419)");
		db.execSQL(sqlInsertEnc + " (419,22,'As you look out of an upstairs window, you see an unfamiliar cityscape with twin suns setting over strange towers. Gain 1 Clue token, but you must pass a <b>Will (-2) check</b> or lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (118,420)");
		db.execSQL(sqlInsertEnc + " (420,25,'A monster appears! If you pass a <b>Combat check</b> against it, you find its skin is covered with the scrawl of archaic runes, and may draw 1 Spell.')");
		db.execSQL(sqlInsertCard + " (119,4,5)");
		db.execSQL(sqlInsertCardEnc + " (119,421)");
		db.execSQL(sqlInsertEnc + " (421,16,'\"Listen,\" says Joey \"The Rat\". \"These just fell off the back of the boat, you get me?\" Draw 2 Common Items. You may purchase one of them for $1 more than its list price.')");
		db.execSQL(sqlInsertCardEnc + " (119,422)");
		db.execSQL(sqlInsertEnc + " (422,22,'You turn to flee from the monster, but as it pursues you  the crumbling house gives way beneath it! Pass a <b>Luck (-2) check</b> to either gain 2 Clue tokens or claim 1 monster trophy at random from the cup, ignoring the <b>Endless</b> ability. If you fail, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (119,423)");
		db.execSQL(sqlInsertEnc + " (423,25,'You find carvings on a standing stone etched in an ancient tongue but by a modern hand. Make a <b>Lore (-1) check</b> and gain 1 Clue token per success.')");
		db.execSQL(sqlInsertCard + " (120,4,1)");
		db.execSQL(sqlInsertCardEnc + " (120,424)");
		db.execSQL(sqlInsertEnc + " (424,16,'A horrific stench draws your attention to the body of some bizarre marine creature, rotting on the edge of the docks. As you move towards it, an uneasy feeling grows in the pit of your stomach, as though you are meddling with something best left alone. Make a <b>Will (-1) check</b>. If you pass, lose 1 Sanity. If you fail, lose 2 Sanity. In either event, if you are not reduced to 0 Sanity, you find something clutched in its webbed hands. Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (120,425)");
		db.execSQL(sqlInsertEnc + " (425,22,'The ceiling beam suddenly buckles. Make a <b>Speed (-1) check</b>. If you pass, move to the street. If you fail, lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (120,426)");
		db.execSQL(sqlInsertEnc + " (426,25,'As you start to climb back into your canoe and row to shore, you see a huge, shadowy shape disturb the water near the island. Waves of intense dread grip you, and you must pass a <b>Will (-1) check</b> or be <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (121,4,1)");
		db.execSQL(sqlInsertCardEnc + " (121,427)");
		db.execSQL(sqlInsertEnc + " (427,16,'As you look out across the waves, you feel strangely compelled to throw yourself into the ocean''s watery embrace. Pass a <b>Will (+1) check</b> or you are <i>Lost in time and space</i>.')");
		db.execSQL(sqlInsertCardEnc + " (121,428)");
		db.execSQL(sqlInsertEnc + " (428,22,'You hear scurrying and squeaking of a horde of rats from inside the walls. Abruptly, you realize that they are moving to surround you. Pass a <b>Speed (-1) check</b> to make it to the front door first. If you fail, you are <i>lost in time and space</i>.')");
		db.execSQL(sqlInsertCardEnc + " (121,429)");
		db.execSQL(sqlInsertEnc + " (429,25,'Looking up at the night sky from the island, you see constellations that you''ve never seen before. The entire sky is different here! Lose 1 Sanity and gain 1 Clue token.')");
		db.execSQL(sqlInsertCard + " (122,4,1)");
		db.execSQL(sqlInsertCardEnc + " (122,430)");
		db.execSQL(sqlInsertEnc + " (430,16,'You bump into Abner Weems, the local drunk. You help him find a place to sleep for the night, and he mumbles something to you over and over. Make a <b>Luck (-1) check</b>. If you pass, his mumbling is a magical chant. Draw 1 Spell. If you fail, it''s gibberish. Nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (122,431)");
		db.execSQL(sqlInsertEnc + " (431,22,'You bump into <b>Eric Colt</b>. He tells you a horrible tale of the Mythos to test your nerve. If you listen, lose 2 Sanity. If this doesn''t drive you insane, take his Ally card if it is available. If it is not available, you may pump him for information instead. Gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (122,432)");
		db.execSQL(sqlInsertEnc + " (432,25,'You come across a large pile of human bones under the boughs of one of the willows on the isle. Lose 1 Sanity, but find a scroll among the bones. Draw 1 Spell.')");
		db.execSQL(sqlInsertCard + " (123,4,1)");
		db.execSQL(sqlInsertCardEnc + " (123,433)");
		db.execSQL(sqlInsertEnc + " (433,16,'You notice a piece of wood floating in the water; carved into it is the name of a ship long since sunk. As you touch it, visions of the drowning passengers'' last moments of life flood through your mind. Pass a <b>Speed (-1) check</b> to hurl it away from you. If you fail, you fall to the ground with a cry. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (123,434)");
		db.execSQL(sqlInsertEnc + " (434,22,'You notice a glint of light in a crevice. If you reach in, make a <b>Luck (-1) check</b>. If you pass, draw 1 Unique Item. If you fail, you feel a sharp pain as teeth clamp down on your hand. You manage to pull free, but you lose 2 Stamina and 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (123,435)");
		db.execSQL(sqlInsertEnc + " (435,25,'The willows sway in a wind that you cannot hear or feel, and for a moment, the hatred of these ancient trees for the invader who has come to their island drives you to your knees. Pass a <b>Will (-2) check</b> or lose 3 Sanity.')");
		db.execSQL(sqlInsertCard + " (124,4,8)");
		db.execSQL(sqlInsertCardEnc + " (124,436)");
		db.execSQL(sqlInsertEnc + " (436,16,'A terrified young student from Miskatonic University seems to have wound up here by accident. Make a <b>Will (+1) check</b> to keep him calm enough to safely guide him back to more familiar streets. If you pass, he gratefully offers you $2 for your assistance.')");
		db.execSQL(sqlInsertCardEnc + " (124,437)");
		db.execSQL(sqlInsertEnc + " (437,22,'A repellent, tar-like appendage is dragging an item of interest quickly through the halls. Make a <b>Speed (-2) check</b>. If you pass, draw 2 Unique Items and keep 1. If you fail, lose 2 Stamina as you are dragged across the floor.')");
		db.execSQL(sqlInsertCardEnc + " (124,438)");
		db.execSQL(sqlInsertEnc + " (438,25,'You see Carl Sanford covertly trying to find a place on the island to recite a ritual. Make a <b>Sneak (-2) check</b>. If you pass, you get close enough to hear what he is saying and gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (125,4,8)");
		db.execSQL(sqlInsertCardEnc + " (125,439)");
		db.execSQL(sqlInsertEnc + " (439,16,'As a truck is driving away from the warehouse, you see a crate fall off the back. Unfortuneately, Joey \"the Rat\" saw it too. Make a <b>Speed (+1) check</b> to beat him to the crate. If you pass, gain 1 Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (125,440)");
		db.execSQL(sqlInsertEnc + " (440,22,'A pen and paper rest on a table next to your chair. Picking up the pen, you black out for an uncertain amount of time. When you regain your senses, the paper is covered with strange messages, not written in your handwriting. Make a <b>Lore (-1) check</b> and gain 1 Clue token for each success. Then, whether you pass or not, lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (125,441)");
		db.execSQL(sqlInsertEnc + " (441,25,'The seclusion on the island is making you more withdrawn and paranoid. Make a <b>Will (+0) check</b> to keep your wits. If you fail, lose 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (126,4,1)");
		db.execSQL(sqlInsertCardEnc + " (126,442)");
		db.execSQL(sqlInsertEnc + " (442,16,'The dock workers are short-handed and offer you a job as a stevedore for the day. Make a <b>Fight (+0) check</b>. If you pass, gain $3 for every success you rolled. If you fail, the boss gets tired of your lollygagging and throws you out. Lose 1 Stamina and move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (126,443)");
		db.execSQL(sqlInsertEnc + " (443,22,'A monster and a gate appear!')");
		db.execSQL(sqlInsertCardEnc + " (126,444)");
		db.execSQL(sqlInsertEnc + " (444,25,'A silent man brushes past you on the trail. Your arm goes numb with cold from the brief contact, and you whirl around to look at him, but he has disappeared. Lose 1 Stamina and pass a <b>Will (-1) check</b> or lose 1 Sanity as well.')");
		db.execSQL(sqlInsertCard + " (127,4,8)");
		db.execSQL(sqlInsertCardEnc + " (127,445)");
		db.execSQL(sqlInsertEnc + " (445,16,'Items in an abandoned warehouse are being auctioned off. The selection is quite good, but prices are running high. Draw the top three Common Items from their deck. You may purchase 1 of them for $1 more than the listed price. Discard any items that are not purchased.')");
		db.execSQL(sqlInsertCardEnc + " (127,446)");
		db.execSQL(sqlInsertEnc + " (446,22,'A box full of documents in the closet has grown damp and moldy. Make a <b>Luck (+1) check</b> to see if anything of value has been spared. If you pass, gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (127,447)");
		db.execSQL(sqlInsertEnc + " (447,25,'The ground is covered with a strange luminescent substance. Make a <b>Lore (+0) check</b> to keep yourself safe from its damaging effects. If you fail, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (128,4,8)");
		db.execSQL(sqlInsertCardEnc + " (128,448)");
		db.execSQL(sqlInsertEnc + " (448,16,'This area has always smelled foul, but today something in the river smells absolutely noxious. Make a <b>Speed (-2) check</b> to reach fresher air. If you fail, lose 1 Stamina. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (128,449)");
		db.execSQL(sqlInsertEnc + " (449,22,'Things seem to just disappear here. Choose 1 Common Item and discard it. If you do not have a Common Item, lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (128,450)");
		db.execSQL(sqlInsertEnc + " (450,25,'You must have fallen into the water. A passerby managed to pull you out and resusitate you. He claims you were dead for a brief time. Perhaps you did go to the other side and returned with new knowledge. Make a <b>Will (-2) check</b> to recollect your experience. If you pass, gain 2 Spells. If you fail, lose 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (129,4,1)");
		db.execSQL(sqlInsertCardEnc + " (129,451)");
		db.execSQL(sqlInsertEnc + " (451,16,'You open some crates on the dock. Inside you find some useful things. Draw 2 Common Items. Next, make a <b>Luck (-1) check</b>. If you pass, you get away without being seen. If you fail, you are arrested and taken to the Police Station.')");
		db.execSQL(sqlInsertCardEnc + " (129,452)");
		db.execSQL(sqlInsertEnc + " (452,22,'In a dusty and decaying roll-top desk, you find a mysterious manuscript. If you read it, make a <b>Lore (-1) check</b>. If you pass, draw 1 Spell. If you fail, the manuscript is nothing but the insane babbling of a previous renter. Stay here next turn reading it, but gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (129,453)");
		db.execSQL(sqlInsertEnc + " (453,25,'You come across a man examining some old bones. Pass a <b>Sneak (-1) check</b> to get close enough to see what he''s doing. He finally notices you and is impressed with your skills, introducing himself as <b>John Legrasse</b>. Take his Ally card if it''s available, otherwise he shares a meal with you. Restore your Sanity and Stamina to their maximum value.')");
		db.execSQL(sqlInsertCard + " (130,4,3)");
		db.execSQL(sqlInsertCardEnc + " (130,454)");
		db.execSQL(sqlInsertEnc + " (454,16,'Walking along the river at night, you bump into a man smoking a stoagie and wearing a trenchcoat. \"You look like a person with problems. It just so happens that my business is making problems go away.\" You may pay $6 to automatically defeat any 1 non-Spawn monster on the board.')");
		db.execSQL(sqlInsertCardEnc + " (130,455)");
		db.execSQL(sqlInsertEnc + " (455,22,'You bump into <b>Eric Colt</b>. He tells you a horrible tale of the Mythos to test your nerve. If you listen, lose 2 Sanity. If this doesn''t drive you insane, take his Ally card if it is available. If it is not available, you may pump him for information instead. Gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (130,456)");
		db.execSQL(sqlInsertEnc + " (456,25,'A monster appears! If you do not defeat it you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (131,4,5)");
		db.execSQL(sqlInsertCardEnc + " (131,457)");
		db.execSQL(sqlInsertEnc + " (457,16,'Your footsteps on the wooden dock are echoed by splashing noises below that keep pace with you. Make a <b>Will (+0) check</b>. If you fail, lose 2 Sanity and move to the street. If you pass, lose 1 Sanity but stay where you are.')");
		db.execSQL(sqlInsertCardEnc + " (131,458)");
		db.execSQL(sqlInsertEnc + " (458,22,'A hideous monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (131,459)");
		db.execSQL(sqlInsertEnc + " (459,25,'The willows seem to grow closer and more malevolent the longer you linger. Make a <b>Speed (-1) check</b> to make it back to your boat in time. If you  fail, you trip over a protruding root and are tangled in grasping boughs. You are <i>delayed</i>.')");
		db.execSQL(sqlInsertCard + " (132,4,1)");
		db.execSQL(sqlInsertCardEnc + " (132,460)");
		db.execSQL(sqlInsertEnc + " (460,16,'Walking along the dock you see something floating in the water near the edge of the dock. You reach for it - make a <b>Luck (-1) check</b>. If you pass, you dredge up something useful. Draw 1 Common Item. If you fail, you pull to the surface the tentacle that immediately wraps around your neck and drags you under the water and out to sea. Lose 1 Sanity and 3 Stamina before you break free.')");
		db.execSQL(sqlInsertCardEnc + " (132,461)");
		db.execSQL(sqlInsertEnc + " (461,22,'Pass a <b>Luck (-1) check</b> to find a hidden cache concealed in the wall of an upstairs bedroom. Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (132,462)");
		db.execSQL(sqlInsertEnc + " (462,25,'A group of hooded cultists are having a meeting among the standing stones on the island. Pass a <b>Sneak (-1) check</b> to overhear some of what they have to say. Gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (133,4,5)");
		db.execSQL(sqlInsertCardEnc + " (133,463)");
		db.execSQL(sqlInsertEnc + " (463,16,'The men unloading those boxes have stooped postures and wide, staring eyes. If you try to investigate what they''re doing, make a <b>Sneak (-2) check</b>. If you pass, you find 1 Unique Item in a crate. If you fail, lose 2 Stamina and 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (133,464)");
		db.execSQL(sqlInsertEnc + " (464,22,'A monster and a gate appear!')");
		db.execSQL(sqlInsertCardEnc + " (133,465)");
		db.execSQL(sqlInsertEnc + " (465,25,'Walking into a clearing, you feel that you are at the center of a web of enormous magical energy. You may return one gate token in play to the bottom of the gate token pile, replacing it with a new gate token from the top of the pile. Monsters are returned to the cup as though you had closed the gate you returned to the pile.')");
		db.execSQL(sqlInsertCard + " (134,4,3)");
		db.execSQL(sqlInsertCardEnc + " (134,466)");
		db.execSQL(sqlInsertEnc + " (466,16,'Walking along the river at night, you bump into a man smoking a stoagie and wearing a trenchcoat. \"You look like a person with problems. It just so happens that my business is making problems go away.\" You may pay $6 to automatically defeat any 1 non-Spawn monster on the board.')");
		db.execSQL(sqlInsertCardEnc + " (134,467)");
		db.execSQL(sqlInsertEnc + " (467,22,'Walking down into the basement, you are startled when the light turns itself off just as you start to place your foot on the next step. Pass a <b>Speed (-2) check</b> or you fall down the stairs, badly injuring yourself. Draw 1 Injury.')");
		db.execSQL(sqlInsertCardEnc + " (134,468)");
		db.execSQL(sqlInsertEnc + " (468,25,'You come across a man examining some old bones. Pass a <b>Sneak (-1) check</b> to get close enough to see what he''s doing. He finally notices you and is impressed with your skills, introducing himself as <b>John Legrasse</b>. Take his Ally card if it''s available, otherwise he shares a meal with you. Restore your Sanity and Stamina to their maximum value.')");
		db.execSQL(sqlInsertCard + " (135,4,3)");
		db.execSQL(sqlInsertCardEnc + " (135,469)");
		db.execSQL(sqlInsertEnc + " (469,16,'Joey \"The Rat\" is huddled under the roof of one of warehouses. Seeing you, he waves you over. \"Look, I think I''ve gotten in over my head this time. Ever since I got this thing weird stuff''s been going on. I''ll give you $5 to take it off my hands! Please, think of my wife and kids!\" If you accept, draw 1 Common Item, gain $5, and become <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (135,470)");
		db.execSQL(sqlInsertEnc + " (470,22,'The house suddenly fills with terrible wails and screams. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (135,471)");
		db.execSQL(sqlInsertEnc + " (471,25,'Time and space distort around you. A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (136,4,3)");
		db.execSQL(sqlInsertCardEnc + " (136,472)");
		db.execSQL(sqlInsertEnc + " (472,16,'Staring out across the placid waters, you look at the stars reflected in their depths and let the soft sound of the waves comfort you. Gain 1 Sanity')");
		db.execSQL(sqlInsertCardEnc + " (136,473)");
		db.execSQL(sqlInsertEnc + " (473,22,'Pausing to wipe your brow, you make your way to the bathroom. Happily, the water still works, so you wash your face. However, after a moment, the cool water turns hot and sticky. Opening your eyes, you find that you are washing your face in blood pouring from the faucet and let out a shriek of terror. Pass a <b>Will (-2) check</b> or draw 1 Madness.')");
		db.execSQL(sqlInsertCardEnc + " (136,474)");
		db.execSQL(sqlInsertEnc + " (474,25,'Walking into a clearing, you feel that you are at the center of a web of enormous magical energy. You may return one gate token in play to the bottom of the gate token pile, replacing it with a new gate token from the top of the pile. Monsters are returned to the cup as though you had closed the gate.')");
		db.execSQL(sqlInsertCard + " (137,4,3)");
		db.execSQL(sqlInsertCardEnc + " (137,475)");
		db.execSQL(sqlInsertEnc + " (475,16,'Walking along the river at night, you bump into a man smoking a stoagie and wearing a trenchcoat. \"You look like a person with problems. It just so happens that my business is making problems go away.\" You may pay $6 to automatically defeat any 1 non-Spawn monster on the board.')");
		db.execSQL(sqlInsertCardEnc + " (137,476)");
		db.execSQL(sqlInsertEnc + " (476,22,'You bump into <b>Eric Colt</b>. He tells you a horrible tale of the Mythos to test your nerve. If you listen, lose 2 Sanity. If this doesn''t drive you insane, take his Ally card if it is available. If it is not available, you may pump him for information instead. Gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (137,477)");
		db.execSQL(sqlInsertEnc + " (477,25,'Time and space distort around you. A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (138,4,3)");
		db.execSQL(sqlInsertCardEnc + " (138,478)");
		db.execSQL(sqlInsertEnc + " (478,16,'One of the warehouse foremen could use someone who''s good with numbers. Make a <b>Lore (+0) check</b>. If you pass, gain $3 for every success you rolled. If you fail, he throws you out hard enough to make you bounce after checking your numbers. Lose 1 Stamina and move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (138,479)");
		db.execSQL(sqlInsertEnc + " (479,22,'Entering one of the rooms, you see a chess set on a table. In growing horror, you watch as the pieces begin moving by themselves and shattering into splinters as they are captured. Fleeing the house, you move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (138,480)");
		db.execSQL(sqlInsertEnc + " (480,25,'Walking into a clearing, you feel that you are at the center of a web of enormous magical energy. You may return one gate token in play to the bottom of the gate token pile, replacing it with a new gate token from the top of the pile. Monsters are returned to the cup as though you had closed the gate.')");
		db.execSQL(sqlInsertCard + " (139,4,6)");
		db.execSQL(sqlInsertCardEnc + " (139,481)");
		db.execSQL(sqlInsertEnc + " (481,16,'Rising from the watery depths, the corpse of a murder victim floats to the surface. Lose 1 Sanity, but gain $3 from the grateful police who are working on the case.')");
		db.execSQL(sqlInsertCardEnc + " (139,482)");
		db.execSQL(sqlInsertEnc + " (482,22,'You are attacked by some unseen force. Lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (139,483)");
		db.execSQL(sqlInsertEnc + " (483,25,'You come across a man examining some old bones. Pass a <b>Sneak (-1) check</b> to get close enough to see what he''s doing. He finally notices you and is impressed with your skills, introducing himself as <b>John Legrasse</b>. Take his Ally card if it''s available, otherwise he shares a meal with you. Restore your Sanity and Stamina to their maximum value.')");
		db.execSQL(sqlInsertCard + " (140,4,6)");
		db.execSQL(sqlInsertCardEnc + " (140,484)");
		db.execSQL(sqlInsertEnc + " (484,16,'A woman stands on the docks waiting for her husband to return, six years after his boat sank. As she tells you her sad tale, she hears her name called out by a familiar voice. Her husband has survived and returned at last! She calls you her lucky charm and <i>Blesses</i> you from the bottom of her heart.')");
		db.execSQL(sqlInsertCardEnc + " (140,485)");
		db.execSQL(sqlInsertEnc + " (485,22,'A stranger approaches and struggles to explain the nature of the creature inside the house. Pass a <b>Lore (+0) check</b> to understand his words and gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (140,486)");
		db.execSQL(sqlInsertEnc + " (486,25,'Pass a <b>Luck (-1) check</b> to notice an unusual shape in the reeds. Gain 1 Common Item.')");
		db.execSQL(sqlInsertCard + " (141,4,6)");
		db.execSQL(sqlInsertCardEnc + " (141,487)");
		db.execSQL(sqlInsertEnc + " (487,16,'An unruly gang has descended upon Abner Weems, the local drunk. Pass a <b>Fight (-1) check</b> to chase them off. If you succeed, Abner gives you the object he took which got him in trouble in the first place. Gain 1 Common Item. If you do not succeed, lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (141,488)");
		db.execSQL(sqlInsertEnc + " (488,22,'The door slams shut behind you! Spend a turn <i>delayed</i> as you search for another way out.')");
		db.execSQL(sqlInsertCardEnc + " (141,489)");
		db.execSQL(sqlInsertEnc + " (489,25,'You''ve stumbled upon the Cult of the Black Goat! You may join them if you wish. To do so, you must discard at least 2 toughness worth of monster trophies, lose 3 Stamina, or an Ally. Take a \"One of the Thousand\" Cult Membership card. If you cannot or choose not to join, you must pass a <b>Speed (-2) check</b> or lose 2 Stamina.')");
		db.execSQL(sqlInsertCard + " (142,4,6)");
		db.execSQL(sqlInsertCardEnc + " (142,490)");
		db.execSQL(sqlInsertEnc + " (490,16,'A young man is anxiously trying to arrange passage out of the city. Upon questioning him, he admits to horrific and revealing dreams of an impending doom. Gain 1 Clue Token.')");
		db.execSQL(sqlInsertCardEnc + " (142,491)");
		db.execSQL(sqlInsertEnc + " (491,22,'A hideous monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (142,492)");
		db.execSQL(sqlInsertEnc + " (492,25,'The fog fills your lungs, trying to change you. Pass a <b>Will (-1) check</b> to resist or gain one Corruption card.')");
		db.execSQL(sqlInsertCard + " (143,4,4)");
		db.execSQL(sqlInsertCardEnc + " (143,493)");
		db.execSQL(sqlInsertEnc + " (493,16,'A shambling heap clambers from the river and engulfs you. If you pass a <b>Fight (-2) check</b>, you find a Common Item in the aftermath. Otherwise, lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (143,494)");
		db.execSQL(sqlInsertEnc + " (494,22,'A useful weapon sits here in the center of a pentagram. Search the Unique Item deck and look at the first Weapon you find. You may either keep it and be <i>Cursed</i> or discard it and gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (143,495)");
		db.execSQL(sqlInsertEnc + " (495,25,'The clouds overhead begin to spiral. Pass a <b>Lore (-1) check</b> to make out the symbol of the Yellow Sign and gain 1 Clue token.')");
		db.execSQL(sqlInsertCard + " (144,4,3)");
		db.execSQL(sqlInsertCardEnc + " (144,496)");
		db.execSQL(sqlInsertEnc + " (496,16,'You bump into Abner Weems, the local drunk. Leaning on your shoulder, he cries as he tells you how his wife and daughter were taken away by a black, three-eyed creature one night. He then babbles for a while, talking about ways to fight such monsters. Make a <b>Luck (-1) check</b>. If you pass, his babbling is helpful. Gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCardEnc + " (144,497)");
		db.execSQL(sqlInsertEnc + " (497,22,'A hideous monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (144,498)");
		db.execSQL(sqlInsertEnc + " (498,25,'In the center of the island, you come across an ancient stone well with bones littering the ground around it. Staring into its black depths, a feeling of such dread overwhelms you that you immediately flee the area. Lose 1 Sanity and move to the street.')");
		db.execSQL(sqlInsertCard + " (145,4,3)");
		db.execSQL(sqlInsertCardEnc + " (145,499)");
		db.execSQL(sqlInsertEnc + " (499,16,'Sitting by the dock, you freeze in silent horror as something slowly rises from the water. You cannot make out what it is, but judging by the number of stars it blots out with its bulk, it is considerably bigger than a whale. After an eternity, it slowly sinks beneath the waves once more. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (145,500)");
		db.execSQL(sqlInsertEnc + " (500,22,'Looking through the drawers in one of the rooms, you come across a stunningly beautiful crystal. As you pick it up, it shimmers for a moment, then sinks into your hand. You convulse for a moment as new knowledge rushes through your mind, but no harm seems to have been done. Draw 1 Skill.')");
		db.execSQL(sqlInsertCardEnc + " (145,501)");
		db.execSQL(sqlInsertEnc + " (501,25,'Falling asleep beneath one of the ancient willows on the island, you dream of another life, one in which you called down strange entities and sacrificed in their name. When you awaken, you have retained some of the memories from that other life. Gain 1 Clue Token and 1 Spell.')");
		db.execSQL(sqlInsertCard + " (146,4,5)");
		db.execSQL(sqlInsertCardEnc + " (146,502)");
		db.execSQL(sqlInsertEnc + " (502,16,'As the walking dead unload cargo from a ship with no name, you notice a box of booty forgotten under the gangplank. Make a <b>Luck (-1) check</b>. If you succeed, draw one Common Item. If its value is $2 or less, draw an additional Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (146,503)");
		db.execSQL(sqlInsertEnc + " (503,22,'The roof caves in, but instead of a ceiling above, a swirling pool of shadow hurtles down towards you. Make a <b>Speed (-1) check</b> or become <i>lost in time and space</i>.')");
		db.execSQL(sqlInsertCardEnc + " (146,504)");
		db.execSQL(sqlInsertEnc + " (504,25,'A piece of driftwood conceals a book washed onto the beach by the tide. Oddly enough, the book does not seem to be wet. As you flip through the pages, the words burn themselves into your mind. Draw a Spell and immediately lose Sanity equal to its Sanity cost. If you are not drive insane, keep the Spell.')");
		db.execSQL(sqlInsertCard + " (147,4,5)");
		db.execSQL(sqlInsertCardEnc + " (147,505)");
		db.execSQL(sqlInsertEnc + " (505,16,'As the dock workers switch shifts for the night, you notice an ornate money clip at your feet. You pick it up, telling yourself you will use the bills clasped within for the greater good. Take $2, but pass a <b>Luck (-1) check</b> or become <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (147,506)");
		db.execSQL(sqlInsertEnc + " (506,22,'A monster and a gate appear!')");
		db.execSQL(sqlInsertCardEnc + " (147,507)");
		db.execSQL(sqlInsertEnc + " (507,25,'Looking across the clearing, you spy another shadowy figure watching the same malefactors you have your eye on. Although your surveillance proves fruitless, you later meet your counterpart on the beach. Pass a <b>Sneak (-1) check</b> to take <b>John Legrasse''s</b> Ally card, or, if it''s not available, to increase your Sanity and Stamina to their maximum values.')");
		db.execSQL(sqlInsertCard + " (149,4,5)");
		db.execSQL(sqlInsertCardEnc + " (149,508)");
		db.execSQL(sqlInsertEnc + " (508,16,'Rotten food in a shipping crate has attracted a multitude of maggots. Under the repulsive feast, you see a wad of cash. Make a <b>Will (-1) check</b> to reach through the writhing mass and take $3 per success. If you fail, lose 1 Stamina and move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (149,509)");
		db.execSQL(sqlInsertEnc + " (509,22,'You hear the voice of Eric Colt from the next room. Drawing nearer, you see his back to you, as he listens to a haunting tune from a radio whose cord has been cut. If you wish to rescue him from the music''s grasp, lose 2 Sanity. If this does not drive you insane, take <b>Eric Colt''s</b> Ally card or, if it''s not available, take 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (149,510)");
		db.execSQL(sqlInsertEnc + " (510,25,'Walking along the beach, you spy a hermit crab with a strange design on its shell. Looking more closely, you realize that the weird mottling spells out secrets. Make a <b>Will (-1) check</b> and take 1 Clue token per success.')");
		db.execSQL(sqlInsertCard + " (150,4,5)");
		db.execSQL(sqlInsertCardEnc + " (150,511)");
		db.execSQL(sqlInsertEnc + " (511,16,'At the end of the dock, an elderly gentleman graps a paper bag tightly, mumbling unintelligibly and pacing. He sees you and points, motioning for you to give him something. Not wanting to upset this strange hermit, you search for something to give him. You may discard 1 Common Item to draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (150,512)");
		db.execSQL(sqlInsertEnc + " (512,22,'A tapestry in the corridor catches your eye as the patterns in its weave appear to shift; you think it may be possible to reach into the hanging. If you choose to try, roll four dice. If you roll any failures, you are <b>devoured</b> as the patterns come alive. If you roll four successes, take a Doom token from the Doom track and place it on an unstable location of your choice as an Elder Sign token.')");
		db.execSQL(sqlInsertCardEnc + " (150,513)");
		db.execSQL(sqlInsertEnc + " (513,25,'Two monsters surface from the island''s dark waters. If you kill both them, you are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCard + " (151,4,2)");
		db.execSQL(sqlInsertCardEnc + " (151,514)");
		db.execSQL(sqlInsertEnc + " (514,16,'The docks are overloaded with shipments coming in to support the museum exhibit. No one will notice if something goes missing. Make a <b>Sneak (-1) check</b>. For each success, you may draw 1 Common Item. You may keep any non-<b>Weapon</b> cards, and must discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (151,515)");
		db.execSQL(sqlInsertEnc + " (515,22,'You pass the strange house and find yourself face to face with a foreign man with a penetrating gaze. If you have any Exhibit Items or your Will is 2 or lower, he seems to approve of your simpering manner, and he introduces himself as <b>Dr. Ali Kafour</b>. Take his Ally card or, if it is not available, listen to him expound upon the ancient Egyptian pantheon as it compares to that of Native American myths: Gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (151,516)");
		db.execSQL(sqlInsertEnc + " (516,25,'As you row along the island''s shore, a tree branch cracks and falls toward you. Make a <b>Speed (+0) check</b>. If you fail, you are knocked out and wake up far downstream; move to the Graveyard and you turn ends.')");
		db.execSQL(sqlInsertCard + " (152,4,2)");
		db.execSQL(sqlInsertCardEnc + " (152,517)");
		db.execSQL(sqlInsertEnc + " (517,16,'You stare into the river, contemplating its currents and depths. Make a <b>Luck (+0) check</b>. If you pass, you realize that time, fate, all of reality, are like a river; take the Visions card. If you fail, a pair of dock workers knock you into the river as a lark, and you catch a cold. Lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (152,518)");
		db.execSQL(sqlInsertEnc + " (518,22,'Luck finds those who need it. If you Luck is 1 or lower, you find a luck penny between the floorboards. You may search the Skill deck and take the Luck card.')");
		db.execSQL(sqlInsertCardEnc + " (152,519)");
		db.execSQL(sqlInsertEnc + " (519,25,'You see a group of masked Egyptian cultists performing a hideous ritual in a clearing. If you wish to get closer and listen, make a <b>Sneak (+0) check</b>. If you pass, draw 1 Spell. If you fail, the look up as one and point at you, and you know that you are marked. You are <i>Barred from the Merchant District</i>.')");
		db.execSQL(sqlInsertCard + " (153,4,2)");
		db.execSQL(sqlInsertCardEnc + " (153,520)");
		db.execSQL(sqlInsertEnc + " (520,16,'You see men of questionable character guiding one of the visiting museum curators toward the edge of the dock...his hands are tied! He pleads to you for help with silent eyes. If you aid him, make a <b>Fight (-2) check</b>. If you pass, you wrest the weapon from one and chase them off; you may search the Common Item deck and take the Tommy Gun card. If you fail, lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (153,521)");
		db.execSQL(sqlInsertEnc + " (521,22,'A group of cultists scampers through the night. If you follow them, make a <b>Sneak (+0) check</b> to watch where they bury their prize. If you pass, you may draw 1 Unique Item or Exhibit Item. If you fail, they turn and smile: a monster <i>surprises</i> you from behind!')");
		db.execSQL(sqlInsertCardEnc + " (153,522)");
		db.execSQL(sqlInsertEnc + " (522,25,'You come upon a tree that has grown, cancer-like, around an ancient prayer plaque. Make a <b>Fight (-2) check</b> or exhaust the Wither spell, Shrivelling spell, or the Axe item to automatically pass. If you pass, draw Spells equal to your focus.')");
		db.execSQL(sqlInsertCard + " (154,4,2)");
		db.execSQL(sqlInsertCardEnc + " (154,523)");
		db.execSQL(sqlInsertEnc + " (523,16,'A load of cargo, precariously balanced on the edge of the dock, goes into the river with a splash. If you dive in and try to retrieve it, a monster appears, and you suffer a -1 to your <b>Combat checks</b>. If you evade or defeat the monster, you may draw 2 Common Items.')");
		db.execSQL(sqlInsertCardEnc + " (154,524)");
		db.execSQL(sqlInsertEnc + " (524,22,'You see a warped mirror. If you look into it, you see yourself in another time and place, holding an ankh in one hand and a sacrificial blade in the other. Your number of Clue tokens doubles, but if you gain more than 3 Clue tokens in this manner, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (154,525)");
		db.execSQL(sqlInsertEnc + " (525,25,'A man wearing exotic robes and a strange hat sits in a shaded clearing, seemingly in a trance. As you approach, he says, \"Come sit with me,\" without looking at you. If you are <i>Cursed</i> or have any <i><b>Mask</b></i> items, he tells you that he is called <b>The Messenger</b> and is meant to aid you. Take his Ally card or, if it is not available, gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCard + " (155,4,2)");
		db.execSQL(sqlInsertCardEnc + " (155,526)");
		db.execSQL(sqlInsertEnc + " (526,16,'A rowdy dock hand doesn''t like the looks of you, and challenges you to a fistfight. Make a <b>Fight (+1) [2] check</b>. If you pass, lose 1 Stamina, but you may search the Skill deck for the Fight card and take it. If you fail, the dock workers spit on you and you run off. Lose 2 Stamina and you are <i>Barred from the Merchant District</i>.')");
		db.execSQL(sqlInsertCardEnc + " (155,527)");
		db.execSQL(sqlInsertEnc + " (527,22,'The house calls to you. If you follow its voice, it tells you which floorboards to pry up. You may draw 1 Unique item or Exhibit Item, but must also take the Tainted card.')");
		db.execSQL(sqlInsertCardEnc + " (155,528)");
		db.execSQL(sqlInsertEnc + " (528,25,'Something calls to you from the island''s heart... if only you could find it! Make a <b>Luck (-2) check</b> or exhaust the Find Gate spell, Dynamite item, or Gate Box item to automatically pass. If you pass, you manage to create a tunnel down into the earth. Gain 1d6 Clue tokens. If you exhausted an item or spell to pass the check and gained more that 3 Clue tokens, you must discard the item or spell used.')");
	}

	
	private static void FetchFrenchHillEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		db.execSQL(sqlInsertCard + " (80,3,1)");
		db.execSQL(sqlInsertCardEnc + " (80,265)");
		db.execSQL(sqlInsertEnc + " (265,11,'The Order of the Silver Twilight casts a banishment spell in their monthly ceremony. Spend 1 Sanity to make a <b>Luck (-1)</b> check. If you pass, claim any one monster on the board as a trophy. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (80,266)");
		db.execSQL(sqlInsertEnc + " (266,18,'You hear the quiet sounds of an intruder. If you investigate, you find a woman dress in black. Pass a <b>Fight (-1) check</b> to subdue her long enough to explain your investigation. You find out that her name is <b>Ruby Standish</b> and that she was robbing the Lodge. However, upon hearing your tale, she agrees to join you. Take her Ally card. If it is not available, draw a Unique Item instead.')");
		db.execSQL(sqlInsertCardEnc + " (80,267)");
		db.execSQL(sqlInsertEnc + " (267,23,'Pass a <b>Luck (-1) check</b> to find an odd-looking item in an old dusty display case. Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCard + " (81,3,1)");
		db.execSQL(sqlInsertCardEnc + " (81,268)");
		db.execSQL(sqlInsertEnc + " (268,11,'Carl Sanford does not trust you and at the climax of the monthly ceremony spits a spell at you. Pass a <b>Luck (-2) check</b> or you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (81,269)");
		db.execSQL(sqlInsertEnc + " (269,18,'Carl Sanford draws you into the study to talk and you feel the cold creep of dread listening to him. Make a <b>Lore (-1) check</b>. If you pass, your willpower stands up to the test of the ancient wizard and you even learn something of value. Gain 3 Clue tokens. If you fail, his hypnotic tones lull you into a trance. The conversation seems short, but when you leave the study, much time has passed and your thoughts are confused. Lose all of your Clue tokens and move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (81,270)");
		db.execSQL(sqlInsertEnc + " (270,23,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (82,3,1)");
		db.execSQL(sqlInsertCardEnc + " (82,271)");
		db.execSQL(sqlInsertEnc + " (271,11,'You attend a ceremony in which the order opens a gate and a monster bursts out of it before the gate closes once more. A monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (82,272)");
		db.execSQL(sqlInsertEnc + " (272,18,'\"Care to join the order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you to the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (82,273)");
		db.execSQL(sqlInsertEnc + " (273,23,'In an old journal you learn some horrible eldritch secrets. Roll a die. Lose that much Sanity and gain that many Clue tokens.')");
		db.execSQL(sqlInsertCard + " (93,3,1)");
		db.execSQL(sqlInsertCardEnc + " (93,274)");
		db.execSQL(sqlInsertEnc + " (274,11,'Pay your monthly dues of $3 or lose 2 Sanity from strange dreams sent to you by Carl Sanford when he kicks you out of the Order. If you are kicked out, lose your Silver Twilight Lodge Membership.')");
		db.execSQL(sqlInsertCardEnc + " (93,275)");
		db.execSQL(sqlInsertEnc + " (275,18,'\"Care to join the Order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you out the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (93,276)");
		db.execSQL(sqlInsertEnc + " (276,23,'You feel the house actually breathe and speak your name. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (94,3,1)");
		db.execSQL(sqlInsertCardEnc + " (94,277)");
		db.execSQL(sqlInsertEnc + " (277,11,'Participating in the monthly ceremony, you witness great power and great evil. Lose up to 3 Sanity and gain that many Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (94,278)");
		db.execSQL(sqlInsertEnc + " (278,18,'Brushing up against a strange object in the hall, you feel stretched and thin, like your skin is too tight. Pass a <b>Luck (-1) check</b> or you are <i>Cursed.</i>')");
		db.execSQL(sqlInsertCardEnc + " (94,279)");
		db.execSQL(sqlInsertEnc + " (279,23,'You find a banquet laid out in the dining room and feel compelled to sit down and eat. Make a <b>Luck (+0) check</b> and consult the following chart:<br /><br />Successes:<br />:0) You suddenly realize what you''ve been eating. Lose 3 Sanity.<br />:1) You gorge yourself,  unable to stop eating. Stay here next turn.<br />:2) The food makes you feel sick. Lose 1 Stamina.<br />:3+) The meal refreshes you. Gain 3 Stamina.')");
		db.execSQL(sqlInsertCard + " (96,3,1)");
		db.execSQL(sqlInsertCardEnc + " (96,280)");
		db.execSQL(sqlInsertEnc + " (280,11,'You''re invited to take part in a Gating ceremony. If you agree, spend 2 Clue tokens and 1 Sanity to make a <b>Lore (-2) check</b>. If you pass, close one gate of your choice. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (96,281)");
		db.execSQL(sqlInsertEnc + " (281,18,'Make a <b>Sneak (-2) check</b>. If you pass, you slip into the temple area of the Lodge and find 2 items of interest. Roll a die for each item. On a success, draw a Unique Item, otherwise draw a Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (96,282)");
		db.execSQL(sqlInsertEnc + " (282,23,'You are overcome by the echoing chants of the long-gone witches who have lived and died here - you pass out. Make a <b>Will (-2) check</b>. If you pass, you learn an ancient spell in your dreams. Draw 1 Spell. If you fail, you are missing half your items when you wake up. Discard half of your items (your choice, round down).')");
		db.execSQL(sqlInsertCard + " (99,3,1)");
		db.execSQL(sqlInsertCardEnc + " (99,283)");
		db.execSQL(sqlInsertEnc + " (283,11,'You are allowed into the vault of Silver Secrets. Pass a <b>Luck (-2) check</b> to steal a very unusual item. Search the Unique Item deck and take any one Unique Item you want.')");
		db.execSQL(sqlInsertCardEnc + " (99,284)");
		db.execSQL(sqlInsertEnc + " (284,18,'You find an old parchment in the study. Pass a <b>Lore (-1) check</b> to draw 2 Spells and keep one of your choice.')");
		db.execSQL(sqlInsertCardEnc + " (99,285)");
		db.execSQL(sqlInsertEnc + " (285,23,'\"Excuse me, stranger, but have you ever seen this symbol before?\" A man standing near the house holds up an occult symbol. Make a <b>Lore (-1) check</b>. If you pass, the man introduces himself as <b>Thomas F. Malone</b>, a police detective visiting Arkham on a case. He''s impressed with you and offers to join you. Take his Ally card. If it''s not available, he tells you some valuable information instead. Gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (101,3,3)");
		db.execSQL(sqlInsertCardEnc + " (101,286)");
		db.execSQL(sqlInsertEnc + " (286,11,'One of the Lodge brothers pulls you aside after a meeting. \"I had a very disturbing dream last night. It told me that something terrible would happen unless I gave you this.\" So saying, he presses $5 into your hands. Gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (101,287)");
		db.execSQL(sqlInsertEnc + " (287,18,'You hear the quiet sounds of an intruder. If you investigate, you find a woman dressed in black. She attacks you as soon as she sees you. Pass a <b>Fight (-1) check</b> to subdue her long enough to explain your investigation. You find out that her name is <b>Ruby Standish</b> and that she was robbing the Lodge. However, upon hearing your tale, she agrees to join you. Take her Ally card. If it is not available, draw a Unique Item instead.')");
		db.execSQL(sqlInsertCardEnc + " (101,288)");
		db.execSQL(sqlInsertEnc + " (288,23,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (102,3,3)");
		db.execSQL(sqlInsertCardEnc + " (102,289)");
		db.execSQL(sqlInsertEnc + " (289,11,'Carl Sanford has an important task for you. Take the first <i><b>Mission</b></i> card from the Unique Item deck. However, you''ll have the Lodge''s help completing it, so place 1 Clue token on it to begin (you may skip the first location on the card).')");
		db.execSQL(sqlInsertCardEnc + " (102,290)");
		db.execSQL(sqlInsertEnc + " (290,18,'\"Care to join the Order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you out the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (102,291)");
		db.execSQL(sqlInsertEnc + " (291,23,'Stepping into one of the disused upstairs rooms, you suddenly find yourself elsewhere. Enter Another Time and have an encounter there, then immediately return here.')");
		db.execSQL(sqlInsertCard + " (103,3,3)");
		db.execSQL(sqlInsertCardEnc + " (103,292)");
		db.execSQL(sqlInsertEnc + " (292,11,'One of the Lodge brothers notices your distress and casts a spell to help you. Restore either your Stamina or Sanity to its maximum.  If both are already at  your maximum, then you are <i>Blessed</i> instead.')");
		db.execSQL(sqlInsertCardEnc + " (103,293)");
		db.execSQL(sqlInsertEnc + " (293,18,'Walking through the garden outside the lodge, you come across a small, ugly statue of some horrific tentacled creature. It seems to awaken an irrational fear in you. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (103,294)");
		db.execSQL(sqlInsertEnc + " (294,23,'You discover an incredibly vital piece of information in one of the dusty old books in the library. Gain 1 Clue token for every open gate on the board.')");
		db.execSQL(sqlInsertCard + " (104,3,3)");
		db.execSQL(sqlInsertCardEnc + " (104,295)");
		db.execSQL(sqlInsertEnc + " (295,11,'Researching the dimensional gates that have been opening up in town, you find an arcane ritual for redirecting them. You may move any one open gate from its current location to any other unstable location without an elder sign token. Any monsters at the gate''s new location are returned to the cup, and any investigators there are drawn through the gate.')");
		db.execSQL(sqlInsertCardEnc + " (104,296)");
		db.execSQL(sqlInsertEnc + " (296,18,'\"Care to join the Order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you out the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (104,297)");
		db.execSQL(sqlInsertEnc + " (297,23,'Make a <b>Luck (-1) check</b>. If you pass, you find a dusty chest in an old closet. Draw 1 Common Item. If you fail, scratchy voices from the past claw at your mind. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (105,3,3)");
		db.execSQL(sqlInsertCardEnc + " (105,298)");
		db.execSQL(sqlInsertEnc + " (298,11,'One of the Lodge brothers has a valuable opportunity for you. Take the first <i><b>Task</b></i> card from the Common Item deck. However, thanks to your connections in the Lodge, place 1 Clue token on it to begin (you may skip the first location on the card).')");
		db.execSQL(sqlInsertCardEnc + " (105,299)");
		db.execSQL(sqlInsertEnc + " (299,18,'Crouching underneath one of the Lodge''s windows, you listen carefully. Pass a <b>Sneak (-1) check</b> to overhear something important and gain 2 Clue tokens. If you fail, security is sent to escort you off the premises. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (105,300)");
		db.execSQL(sqlInsertEnc + " (300,23,'The ancient witch Keziah Mason appears before you. Make a <b>Will (-2) check</b>. If you pass, she teaches you something of value. Draw 1 Spell. If you fail, she casts a terrible spell upon you: You are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (106,3,3)");
		db.execSQL(sqlInsertCardEnc + " (106,301)");
		db.execSQL(sqlInsertEnc + " (301,11,'You participate in a warding ritual led by Carl Sanford. You may spend 2 more Clue tokens than it would normally cost you to seal a gate in order to place an elder sign token on any unstable location without an open gate. If you do not spend the Clue tokens or cannot currently seal gates, then nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (106,302)");
		db.execSQL(sqlInsertEnc + " (302,18,'Make a <b>Luck (-2) check</b>. If you pass, Carl Sanford opens the door as you''re about to knock. \"It''s about time you showed up, you fool. Here, take this. You know what to do with it.\"  Carl then hands you a package and closes the door. Draw 1 Unique Item. If you fail the check, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (106,303)");
		db.execSQL(sqlInsertEnc + " (303,23,'The strange, rat-like creature known as Brown Jenkin leaps out of the darkness at you! Search the monster cup for a Rat-thing. If you find one, battle it with a -1 penalty to your <b>Combat checks</b>. If you don''t, Brown Jenkin grabs one of your items and runs. Lose 1 Item of your choice.')");
		db.execSQL(sqlInsertCard + " (107,3,3)");
		db.execSQL(sqlInsertCardEnc + " (107,304)");
		db.execSQL(sqlInsertEnc + " (304,11,'Carl Sanford places a powerful spell of protection on you. If you are <i>Cursed,</i> discard the Curse card. If you are not <i>Cursed,</i> you may search the Mythos deck for any two cards of your choice and return them to the box.')");
		db.execSQL(sqlInsertCardEnc + " (107,305)");
		db.execSQL(sqlInsertEnc + " (305,18,'A monster appears, leaping out of the shadows at you!')");
		db.execSQL(sqlInsertCardEnc + " (107,306)");
		db.execSQL(sqlInsertEnc + " (306,23,'\"Excuse me, stranger, but have you ever seen this symbol before?\" A man standing near the house holds up an occult symbol. Make a <b>Lore (-1) check</b>. If you pass, the man introduces himself as <b>Thomas F. Malone</b>, a police detective visiting Arkham on a case. He''s impressed with you and offers to join you. Take his Ally card. If it''s not available, he tells you some valuable information instead. Gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (108,3,4)");
		db.execSQL(sqlInsertCardEnc + " (108,307)");
		db.execSQL(sqlInsertEnc + " (307,11,'A strange maze-like symbol has been carved in the wall. Do you dare to follow it with your eyes? If so, pass a <b>Will (+0) check</b> to gain a Clue token. If you fail, you lose 1 Sanity. ')");
		db.execSQL(sqlInsertCardEnc + " (108,308)");
		db.execSQL(sqlInsertEnc + " (308,18,'When you inquire about membership, the lodge members get a gleam in their eyes. If you have an Ally, you may discard it to take both a Silver Twilight Membership card and a Unique Item, but you are <i>Cursed</i>. If you do not have an Ally or do not wish to discard one, pass a <b>Fight (-3) check</b> or you are <i>lost in time and space</i>.')");
		db.execSQL(sqlInsertCardEnc + " (108,309)");
		db.execSQL(sqlInsertEnc + " (309,23,'An artist''s address book lies on a table with a list of names: Lizzie Burke, Pinkie McCormick, Tessie. You feel like you know them all, or knew them, and feel a stab of sadness. Gain 1 Clue token, but pass a <b>Will (+0) check</b> or lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (109,3,4)");
		db.execSQL(sqlInsertCardEnc + " (109,310)");
		db.execSQL(sqlInsertEnc + " (310,11,'Membership has it privileges. Pass a <b>Will (-1) check</b> to draw Unique Items equal to the number of successes. You may purchase any of the items drawn, using any combination of money, Clue tokens (1 Clue token = $2), or Spells (1 Spell = $3).')");
		db.execSQL(sqlInsertCardEnc + " (109,311)");
		db.execSQL(sqlInsertEnc + " (311,18,'A lovely young woman stumbles into you as you''re searching for the library. \"Pardon me,\" she says, \"my name is Constance Hawberk. Have you seen my father?\" Pass a <b>Luck (-1) check</b> to point her in the right direction. In return, she points you to the library and you gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (109,312)");
		db.execSQL(sqlInsertEnc + " (312,23,'A muffled cry and some thumping comes from a nearby closet. Pass a <b>Fight (-2) check</b> to open it and rescue whoever is inside, drawing a random Ally. If you fail, whatever trapped him attacks you too: A monster appears.')");
		db.execSQL(sqlInsertCard + " (110,3,4)");
		db.execSQL(sqlInsertCardEnc + " (110,313)");
		db.execSQL(sqlInsertEnc + " (313,11,'Entering the workroom, you see a smith working on an ancient heirloom. He says \"Your piece is finished, you vulture,\" and throws it at you in disgust. Make a <b>Speed (-2) check</b>. If you pass, you may search the Unique Item deck and take the first <i><b>Weapon</b></i> you find. If you fail, you lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (110,314)");
		db.execSQL(sqlInsertEnc + " (314,18,'The members are extremely concerned about something regarding the celestial bodies being \"changed\" by some outside force. Pass a <b>Sneak  (-2) check</b> to gain 2 Clue tokens. If you fail, you are pushed out into the street.')");
		db.execSQL(sqlInsertCardEnc + " (110,315)");
		db.execSQL(sqlInsertEnc + " (315,23,'A woman poses by a window; the dim light revealing the outline of her beautiful figure, but hiding her face. \"Will you paint me?\" she asks. Make a <b>Luck (-2) check</b>. If you pass, you find a painting of the woman where she was standing. It has a Spell scribed on the back. Draw one Spell. If you fail, a monster appears!')");
		db.execSQL(sqlInsertCard + " (111,3,4)");
		db.execSQL(sqlInsertCardEnc + " (111,316)");
		db.execSQL(sqlInsertEnc + " (316,11,'The members are extremely concerned about the celestial bodies being \"changed\" by some outside force, ask you to investigate. Make a <b>Lore (-1) check</b>. If you pass, you gain 2 Clue tokens and draw a Spell to aid you on your mission.')");
		db.execSQL(sqlInsertCardEnc + " (111,317)");
		db.execSQL(sqlInsertEnc + " (317,18,'\"Tut-tut,\" says Carl Sanford. \"A sound mind is essential for membership, I''m afraid.\" For each point of Sanity you have, you may roll a die. If you roll any successes, you may draw a Twilight Lodge Membership card. For each unsuccessful die you roll, you lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (111,318)");
		db.execSQL(sqlInsertEnc + " (318,23,'\"What a shame,\" a voice whispers, \"such unused potential.\" Search the Unique Item deck and take the first <i><b>Tome</b></i> you find. If it requires a skill check to read, then you may immediately make a check to read it, without spending any movement points to do so.')");
		db.execSQL(sqlInsertCard + " (90,3,5)");
		db.execSQL(sqlInsertCardEnc + " (90,319)");
		db.execSQL(sqlInsertEnc + " (319,11,'A glass orb in this chamber contains a swirling fog. As you handle the sphere, the misty shroud parts to divulge what seems to be the future. Draw the top five cards from the Mythos deck and put them back on top of the deck in any order you desire.')");
		db.execSQL(sqlInsertCardEnc + " (90,320)");
		db.execSQL(sqlInsertEnc + " (320,18,'A member of the Lodge ushers you into a side room, where he shows you a magic sphere and explains that it will provide answers to your question... if you are lucky. Make a <b>Luck (-1) check</b>. If you succeed, take Clue tokens equal to the number of successes you rolled.')");
		db.execSQL(sqlInsertCardEnc + " (90,321)");
		db.execSQL(sqlInsertEnc + " (321,23,'A force from within the house threatens to take over your mind. Pass a <b>Will (-1) check</b> to avoid moving to the nearest monster''s location and the encountering it. If there are no monsters in any street area or location, a monster appears!')");
		db.execSQL(sqlInsertCard + " (91,3,5)");
		db.execSQL(sqlInsertCardEnc + " (91,322)");
		db.execSQL(sqlInsertEnc + " (322,11,'While in the Inner Sanctum, you examine a scroll concerning the aspects of gates. Make a <b>Lore (+0) check</b>, rolling one extra die for each open gate. Take a Clue token for each success you roll.')");
		db.execSQL(sqlInsertCardEnc + " (91,323)");
		db.execSQL(sqlInsertEnc + " (323,18,'Carl Sanford explains that membership in the Silver Twilight Lodge requires sacrifice, and that the Lodge has need of one of your friends. Discard an Ally to take a \"Silver Twilight Lodge Membership\" card and draw a Unique Item. If you can''t or won''t, you are cursed, and must pass a <b>Fight (-3) check</b> to avoid becoming <i>lost in time and space</i>.')");
		db.execSQL(sqlInsertCardEnc + " (91,324)");
		db.execSQL(sqlInsertEnc + " (324,23,'\"You will be rewarded according to what you have learned,\" whispers the voice of a long-dead warlock. Lose 1 Stamina but take a Clue token for each Spell you possess.')");
		db.execSQL(sqlInsertCard + " (95,3,5)");
		db.execSQL(sqlInsertCardEnc + " (95,325)");
		db.execSQL(sqlInsertEnc + " (325,11,'A member of the Lodge leads you into the Inner Sanctum and shows you a ring that can be used to fight against evil. As you slip it on, he directs you to concentrate on a target and try to overpower it with your mind. You may spend 1 Stamina to make a <b>Will (-1) check</b>. If you succeed, claim any non-spawn monster on the board as a trophy.')");
		db.execSQL(sqlInsertCardEnc + " (95,326)");
		db.execSQL(sqlInsertEnc + " (326,18,'A woman fleeing something runs right into you. As you try to help her up, she blindly attacks you. Pass a <b>Fight (-1) check</b> to restrain her; if you succeed, take <b>Ruby Standish''s</b> Ally card, or draw a Unique Item if it''s not available.')");
		db.execSQL(sqlInsertCardEnc + " (95,327)");
		db.execSQL(sqlInsertEnc + " (327,23,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (98,3,5)");
		db.execSQL(sqlInsertCardEnc + " (98,328)");
		db.execSQL(sqlInsertEnc + " (328,11,'A member of the inner circle explains that the Lodge sometimes supports the studies and explorations of the like-minded. Give any other investigator all of your Clue tokens. You are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (98,329)");
		db.execSQL(sqlInsertEnc + " (329,18,'As you leave the lodge, a green glow surrounds the door frame. Move to the street. All monsters in the sky immediately go there as well.')");
		db.execSQL(sqlInsertCardEnc + " (98,330)");
		db.execSQL(sqlInsertEnc + " (330,23,'A man motions you over and points to a chalk outline in the atrium of the old house. He directs your attention to a trail of what seems to be green blood. Pass a <b>Lore (-1) check</b> to offer useful assistance; if you do, take <b>Thomas F. Malone''s</b> Ally card, or, if it is not available, take 2 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (83,3,6)");
		db.execSQL(sqlInsertCardEnc + " (83,331)");
		db.execSQL(sqlInsertEnc + " (331,11,'The Lodge has decided to clean up the town. Choose one dimension symbol other than the moon and return all non-Spawn monsters in Arkham with that symbol to the cup.')");
		db.execSQL(sqlInsertCardEnc + " (83,332)");
		db.execSQL(sqlInsertEnc + " (332,18,'The wind has pinned an odd piece of paper against the fence surrounding the Lodge. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (83,333)");
		db.execSQL(sqlInsertEnc + " (333,23,'\"Excuse me, stranger, but have you ever seen this symbol before?\" A man standing near the house holds up an occult symbol. Make a <b>Lore (-1) check</b>. If you pass, the man introduces himself as <b>Thomas F. Malone</b>, a police detective visiting Arkham on a case. He''s impressed with you and offers to join you. Take his Ally card. If it''s not available, he tells you some valuable information instead. Gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (84,3,6)");
		db.execSQL(sqlInsertCardEnc + " (84,334)");
		db.execSQL(sqlInsertEnc + " (334,11,'If you currently posses a \"One of the Thousand\" Cult Membership, the Inner Sanctum has found out about your double life! You must immediately lose either your Inner Sanctum* of \"One of the Thousand\" card. Either way, you lose 2 Stamina. If you are not One of the Thousand, you have no encounter.')");
		db.execSQL(sqlInsertCardEnc + " (84,335)");
		db.execSQL(sqlInsertEnc + " (335,18,'\"Care to join the Order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you out the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (84,336)");
		db.execSQL(sqlInsertEnc + " (336,23,'On the front lawn a group of children hold hands and circle around a dead bird, chanting words you don''t recognize. Make a <b>Lore (-2) check</b>. If you pass draw 1 Spell.')");
		db.execSQL(sqlInsertCard + " (85,3,6)");
		db.execSQL(sqlInsertCardEnc + " (85,337)");
		db.execSQL(sqlInsertEnc + " (337,11,'An executive at the Bank of Arkham is also a member and offers to pull a few strings. You may choose any one player who currently has a Bank Loan and discard it without paying.')");
		db.execSQL(sqlInsertCardEnc + " (85,338)");
		db.execSQL(sqlInsertEnc + " (338,18,'From the darkest shadows, a monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (85,339)");
		db.execSQL(sqlInsertEnc + " (339,23,'You find a terrible collection of human remains with the walls. Pass a <b>Will (-1) check</b> or lose 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (86,3,6)");
		db.execSQL(sqlInsertCardEnc + " (86,340)");
		db.execSQL(sqlInsertEnc + " (340,11,'A fellow Lodge member helps you perform a ritual designed to protect you and your friends. Make a <b>Lore (+0) check</b> to see the deeper meanings. Gain 1 Clue token for each success.')");
		db.execSQL(sqlInsertCardEnc + " (86,341)");
		db.execSQL(sqlInsertEnc + " (341,18,'The Lodge has a strange and compelling oil painting on display. Its alien landscape both fascinates and nauseates you. Pass a <b>Will (+0) check</b> or lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (86,342)");
		db.execSQL(sqlInsertEnc + " (342,23,'Someone has left their mathematics homework lying on the dining room table. Pass a <b>Lore (-1) check</b> to see the deeper meanings. Gain 1 Clue token for each success.')");
		db.execSQL(sqlInsertCard + " (112,3,7)");
		db.execSQL(sqlInsertCardEnc + " (112,343)");
		db.execSQL(sqlInsertEnc + " (343,11,'\"You must always be studying,\" Carl Sanford tells you. Make a <b>Lore (-1) check</b>. If you pass, draw 1 Spell. If you fail, you are <i>delayed,</i> and then draw 1 Spell.')");
		db.execSQL(sqlInsertCardEnc + " (112,344)");
		db.execSQL(sqlInsertEnc + " (344,18,'You hear the quiet sounds of an intruder. If you investigate, you find a woman dressed in black. She attacks you as soon as she sees you. Pass a <b>Fight (-1) check</b> to subdue her long enough to explain your investigation. You find out that her name is <b>Ruby Standish</b> and that she was robbing the Lodge. However, upon hearing your tale, she agrees to join you. Take her Ally card. If it is not available, draw a Unique Item instead.')");
		db.execSQL(sqlInsertCardEnc + " (112,345)");
		db.execSQL(sqlInsertEnc + " (345,23,'You turn to see a small furry form dart quickly out of the room, making off with one of your possessions. Discard 1 item of your choice. If you have no items, then nothing happens.')");
		db.execSQL(sqlInsertCard + " (113,3,7)");
		db.execSQL(sqlInsertCardEnc + " (113,346)");
		db.execSQL(sqlInsertEnc + " (346,11,'\"In a hurry?\" Carl Sanford asks. He offers to guide you through the old tunnels that connect the Lodge to the rest of the city. Move to any location or  street area in Arkham. If you move to a location, immediately have an encounter there, drawing 2 cards and encountering either of them.')");
		db.execSQL(sqlInsertCardEnc + " (113,347)");
		db.execSQL(sqlInsertEnc + " (347,18,'A monster appears, leaping out of the shadows at you!')");
		db.execSQL(sqlInsertCardEnc + " (113,348)");
		db.execSQL(sqlInsertEnc + " (348,23,'One of the steps leading upstairs has rotted through. Pass a <b>Speed (-1) check</b> or lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (114,3,7)");
		db.execSQL(sqlInsertCardEnc + " (114,349)");
		db.execSQL(sqlInsertEnc + " (349,11,'You may make a <b>Lore (-1) check</b> to assist in a ritual. If you pass, heal every investigator, including yourself, to full Sanity and Stamina. If you attempt to assist and fail, the ritual goes terribly awry, sending nightmares throughout the city. Raise the terror level by 1.')");
		db.execSQL(sqlInsertCardEnc + " (114,350)");
		db.execSQL(sqlInsertEnc + " (350,18,'Carl Sanford has taken an interest in your possessions. If you have a Unique Item, you may sell it for its list price. If you do not sell it, the Lodge''s henchmen will try to take it by force. Pass a <b>Fight (+1) check</b> or discard a Unique Item of your choice. If you do not have a Unique Item, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (114,351)");
		db.execSQL(sqlInsertEnc + " (351,23,'You wake up suddenly after terrible dreams, unsure of how long you have been here. Lose 1 Sanity, and you are <i>delayed</i>.')");
		db.execSQL(sqlInsertCard + " (115,3,7)");
		db.execSQL(sqlInsertCardEnc + " (115,352)");
		db.execSQL(sqlInsertEnc + " (352,11,'The Inner Sanctum asks for your help in a banishing ritual. Discard one monster trophy with a dimensional symbol other than moon to return all monsters in Arkham with the same dimensional symbol to the cup.')");
		db.execSQL(sqlInsertCardEnc + " (115,353)");
		db.execSQL(sqlInsertEnc + " (353,18,'\"Care to join the Order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you out the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (115,354)");
		db.execSQL(sqlInsertEnc + " (354,23,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (89,3,8)");
		db.execSQL(sqlInsertCardEnc + " (89,355)");
		db.execSQL(sqlInsertEnc + " (355,11,'\"Admiring our library?\" Carl Sanford asks you. \"Membership has privileges. Borrow one of our texts if you wish.\" Search Unique Item deck and take the first <i><b>Tome</b></i> you find.')");
		db.execSQL(sqlInsertCardEnc + " (89,356)");
		db.execSQL(sqlInsertEnc + " (356,18,'You recognize one of the Lodge Members as a friend from years ago. Make a <b>Will (-2) check</b> to convince him to help you in some way. If you pass, draw 1 Unique Item. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (89,357)");
		db.execSQL(sqlInsertEnc + " (357,23,'In the middle of the night, something in the dark is clutching at your chest! Make a <b>Fight (+0) check</b> and lose 2 Stamina if you fail.')");
		db.execSQL(sqlInsertCard + " (92,3,8)");
		db.execSQL(sqlInsertCardEnc + " (92,358)");
		db.execSQL(sqlInsertEnc + " (358,11,'Within this spiritually attuned chamber, you find that if you open your mind to the spirit world, the spirits will bestow eldritch knowledge upon you. Gain up to 3 Spells and then lose 1 Sanity for each spell chosen.')");
		db.execSQL(sqlInsertCardEnc + " (92,359)");
		db.execSQL(sqlInsertEnc + " (359,18,'\"Care to join the Order?\" Carl Sanford and several of his henchmen ask. If you accept, pay $3 and take a Silver Twilight Membership. If you decline, pass a <b>Will (-1) check</b> or lose 3 Stamina as the henchmen assist you out the door. Whether you pass or not, move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (92,360)");
		db.execSQL(sqlInsertEnc + " (360,23,'The room is filled with glowing bubbles! You are having a hard time gaining your bearings and finding the door. Lose 1 Sanity and you are <i>delayed</i>, but then gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (97,3,8)");
		db.execSQL(sqlInsertCardEnc + " (97,361)");
		db.execSQL(sqlInsertEnc + " (361,11,'Carl Sanford accuses you of stealing from the Lodge. Make a <b>Will (-1) check</b> to prove that you''ve been framed. If you fail, lose 1 Stamina and your Silver Twilight Membership, and then move to the streets. If you pass, there is no effect.')");
		db.execSQL(sqlInsertCardEnc + " (97,362)");
		db.execSQL(sqlInsertEnc + " (362,18,'Carl Sanford sits in the center of the room chanting while books and other small objects appear to be flying around the room of their own accord! Make a <b>Fight (-1) check</b> to avoid being clobbered by these items and to understand what Sanford is saying. If you pass, gain 2 Clue tokens. If you fail, you awaken bruised and sore. Lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (97,363)");
		db.execSQL(sqlInsertEnc + " (363,23,'In the attic, you feel a force in your mind, trying to replace your thoughts with those of another. Make a <b>Speed (-1) check</b> to escape. If you pass, move to the streets. If you fail, lose 1 Spell, or if you have no Spells, lose 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (100,3,8)");
		db.execSQL(sqlInsertCardEnc + " (100,364)");
		db.execSQL(sqlInsertEnc + " (364,11,'The Lodge Members have gathered to perform a powerful banishment ritual. Make a <b>Lore (-2) check</b>. If you pass, you may either gain 2 Clue tokens or choose one monster in the same location as an open Gate and return that monster to the monster cup.')");
		db.execSQL(sqlInsertCardEnc + " (100,365)");
		db.execSQL(sqlInsertEnc + " (365,18,'You hear the quiet sounds of an intruder. If you investigate, you find a woman dressed in black. She attacks you as soon as she sees you. Pass a <b>Fight (-1) check</b> to subdue her long enough to explain your investigation. You find out that her name is <b>Ruby Standish</b> and that she was robbing the Lodge. However, upon hearing your tale, she agrees to join you. Take her Ally card. If it is not available, draw a Unique Item instead.')");
		db.execSQL(sqlInsertCardEnc + " (100,366)");
		db.execSQL(sqlInsertEnc + " (366,23,'You find an old journal, largely devoured by vermin. Mkae a <b>Luck (-3) check</b> to see if certain vital pages remain intact. If you pass, draw 2 Spells and keep 1.')");
		db.execSQL(sqlInsertCard + " (77,3,2)");
		db.execSQL(sqlInsertCardEnc + " (77,367)");
		db.execSQL(sqlInsertEnc + " (367,11,'There is an inscription above an alcove. Pass a <b>Lore (-2) check</b> to understand it. If you do, it reads \"Place herein a thing mundane, it will become a thing of fame.\" You gain 1 Clue token and may draw 1 Unique Item or Exhibit Item. If you discard a Common Item of your choice, you may keep the item drawn; otherwise, discard it.')");
		db.execSQL(sqlInsertCardEnc + " (77,368)");
		db.execSQL(sqlInsertEnc + " (368,18,'\"You want to see what we''re really about, then?\" If you accept the Order''s invitation, you are introduced to the Black Man. Make a <b>Luck (+0) check</b> or be <b>devoured</b>. If you pass, take a Silver Twilight Membership card and gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (77,369)");
		db.execSQL(sqlInsertEnc + " (369,23,'Something about the angles in the attic room opens your mind to the myriad possibilities of other, nearly identical universes. Search the Spell deck for a Spell you already have, and take another copy of it. Then, as you continue to stare into the impossible angle, a Hound of Tindalos appears!')");
		db.execSQL(sqlInsertCard + " (78,3,2)");
		db.execSQL(sqlInsertCardEnc + " (78,370)");
		db.execSQL(sqlInsertEnc + " (370,11,'Only the strongest of will may enter the Lodge''s prized library. Make a <b>Will (-1) check</b>. If you pass, you gain 3 Clue tokens and may search the Spell deck for any one Spell and take it. If you fail, you lose your Silver Twilight Lodge Membership.')");
		db.execSQL(sqlInsertCardEnc + " (78,371)");
		db.execSQL(sqlInsertEnc + " (371,18,'The lights go out; you hear chanting and feel a knife at your throat. You may:<br />:1) Flee. Lose 1 Stamina and move to the street.<br />:2) Allow them to cast their ritual upon you. Lose 2 Stamina, but take the Visions card and gain 1 Clue token.<br />:3) Attempt to take control of the ritual with a <b>Lore (-1) check</b>. If you pass, the Lodge offers you a Silver Twilight Membership. If you fail, lose 3 Stamina and all of your Spells, then move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (78,372)");
		db.execSQL(sqlInsertEnc + " (372,23,'The graffiti on the walls is actually Egyptian hieroglyphics. Make a <b>Lore (+0) check</b>. You may draw cards from the Spell deck equal to the number of successes, and keep one of them. ')");
		db.execSQL(sqlInsertCard + " (79,3,2)");
		db.execSQL(sqlInsertCardEnc + " (79,373)");
		db.execSQL(sqlInsertEnc + " (373,11,'A newly ordained member of the Lodge should be seen but not heard. Pass a <b>Sneak (-1) check</b> to gain 2 Clue tokens. If you fail, the stern glares of the higher-ranking members at least give you motivation: You may search the Spell deck for the Stealth card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (79,374)");
		db.execSQL(sqlInsertEnc + " (374,18,'Make a <b>Will (-2) check</b> to convince the Lodge that you need one of its sacred items for the good of Arkham. If you pass, draw cards equal to the number of successes from the Unique Item or Exhibit Item deck, keep one, and discard the rest. If you fail, you are <i>Barred from French Hill</i>.')");
		db.execSQL(sqlInsertCardEnc + " (79,375)");
		db.execSQL(sqlInsertEnc + " (375,23,'You take a renowned visiting escape artist on a tour of the witch house. If you give him 2 of your Spells (discarding them), he introduces himself as <b>Erich Weiss</b>; take his Ally card if it''s available. If it''s not available, he shows you a trick instead, and you gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (87,3,2)");
		db.execSQL(sqlInsertCardEnc + " (87,376)");
		db.execSQL(sqlInsertEnc + " (376,11,'\"Time to pay your dues, brother. We need a champion, and you''ve been chosen.\" You are handed a weapon and thrown through a doorway into oblivion. You may search the Unique Item deck and take the first <b>magical weapon</b> you find, but you are transported to R''lyeh.')");
		db.execSQL(sqlInsertCardEnc + " (87,377)");
		db.execSQL(sqlInsertEnc + " (377,18,'The Lodge is always eager to trade lore. Discard any number of Spells. Gain a number of Clue tokens equal to the total Sanity cost of the Spells discarded.')");
		db.execSQL(sqlInsertCardEnc + " (87,378)");
		db.execSQL(sqlInsertEnc + " (378,23,'You see a prim and proper girl in puritanical attire, but there is something hungry in her eyes. \"Would you like to see?\" she asks, demurely. If you agree, she reaches forward to touch you. You feel a terrible cold, then the burning heat of the pyre! You realize  that she is the ghost of Keziah Mason, who was burned at the stake for witchcraft over a century ago! Make a <b>Will (-1) check</b>. You may gain 1 Clue token for each success or 1 Spell for every two successes.')");
		db.execSQL(sqlInsertCard + " (88,3,2)");
		db.execSQL(sqlInsertCardEnc + " (88,379)");
		db.execSQL(sqlInsertEnc + " (379,11,'A gorgeous youth invites you into a meditation chamber. If you go in, you must lose a total of 4 Spells or Stamina, divided up as you choose, but you may search the Exhibit Item deck for the Mask of the Three Fates card and take it. If you do not go in, the young witch casts a hex upon you, and you are <i>Barred from French Hill</i>.')");
		db.execSQL(sqlInsertCardEnc + " (88,380)");
		db.execSQL(sqlInsertEnc + " (380,18,'\"Certainly, we''d love to have you,\" Carl Sanford says, \"if you can do something for us.\" Move to the City of the Great Race and have an encounter there, then immediately return. If you passed a test or defeated a monster encountered there, take a Silver Twilight Membership and gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (88,381)");
		db.execSQL(sqlInsertEnc + " (381,23,'Ever since you visited the witch house, you keep seeing a strange, rat-like creature out of the corner of you eye...and sometimes it looks like its face is almost human! Gain 1 Clue token, but take the Harried card.')");
		db.execSQL(sqlInsertCard + " (-13,3,9)");
		db.execSQL(sqlInsertCardEnc + " (-13,382)");
		db.execSQL(sqlInsertEnc + " (382,11,'There is an inscription above an alcove. Pass a <b>Lore (-2) check</b> to understand it. If you do, it reads \"Place herein a thing mundane, it will become a thing of fame.\" You gain 1 Clue token and may draw 1 Unique Item or Exhibit Item. If you discard a Common Item of your choice, you may keep the item drawn; otherwise, discard it.')");
		db.execSQL(sqlInsertCardEnc + " (-13,383)");
		db.execSQL(sqlInsertEnc + " (383,18,'\"You want to see what we''re really about, then?\" If you accept the Order''s invitation, you are introduced to the Black Man. Make a <b>Luck (+0) check</b> or be <b>devoured</b>. If you pass, take a Silver Twilight Membership card and gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (-13,384)");
		db.execSQL(sqlInsertEnc + " (384,23,'Something about the angles in the attic room opens your mind to the myriad possibilities of other, nearly identical universes. Search the Spell deck for a Spell you already have, and take another copy of it. Then, as you continue to stare into the impossible angle, a Hound of Tindalos appears!')");
		db.execSQL(sqlInsertCard + " (-14,3,9)");
		db.execSQL(sqlInsertCardEnc + " (-14,385)");
		db.execSQL(sqlInsertEnc + " (385,11,'Only the strongest of will may enter the Lodge''s prized library. Make a <b>Will (-1) check</b>. If you pass, you gain 3 Clue tokens and may search the Spell deck for any one Spell and take it. If you fail, you lose your Silver Twilight Lodge Membership.')");
		db.execSQL(sqlInsertCardEnc + " (-14,386)");
		db.execSQL(sqlInsertEnc + " (386,18,'The lights go out; you hear chanting and feel a knife at your throat. You may:<br />:1) Flee. Lose 1 Stamina and move to the street.<br />:2) Allow them to cast their ritual upon you. Lose 2 Stamina, but take the Visions card and gain 1 Clue token.<br />:3) Attempt to take control of the ritual with a <b>Lore (-1) check</b>. If you pass, the Lodge offers you a Silver Twilight Membership. If you fail, lose 3 Stamina and all of your Spells, then move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (-14,387)");
		db.execSQL(sqlInsertEnc + " (387,23,'The graffiti on the walls is actually Egyptian hieroglyphics. Make a <b>Lore (+0) check</b>. You may draw cards from the Spell deck equal to the number of successes, and keep one of them. ')");
		db.execSQL(sqlInsertCard + " (-15,3,9)");
		db.execSQL(sqlInsertCardEnc + " (-15,388)");
		db.execSQL(sqlInsertEnc + " (388,11,'A newly ordained member of the Lodge should be seen but not heard. Pass a <b>Sneak (-1) check</b> to gain 2 Clue tokens. If you fail, the stern glares of the higher-ranking members at least give you motivation: You may search the Spell deck for the Stealth card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (-15,389)");
		db.execSQL(sqlInsertEnc + " (389,18,'Make a <b>Will (-2) check</b> to convince the Lodge that you need one of its sacred items for the good of Arkham. If you pass, draw cards equal to the number of successes from the Unique Item or Exhibit Item deck, keep one, and discard the rest. If you fail, place a Patrol marker on the street area of French Hill.')");
		db.execSQL(sqlInsertCardEnc + " (-15,390)");
		db.execSQL(sqlInsertEnc + " (390,23,'You take a renowned visiting escape artist on a tour of the witch house. If you give him 2 of your Spells (discarding them), he introduces himself as <b>Erich Weiss</b>; take his Ally card if it''s available. If it''s not available, he shows you a trick instead, and you gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (-16,3,9)");
		db.execSQL(sqlInsertCardEnc + " (-16,391)");
		db.execSQL(sqlInsertEnc + " (391,11,'\"Time to pay your dues, brother. We need a champion, and you''ve been chosen.\" You are handed a weapon and thrown through a doorway into oblivion. You may search the Unique Item deck and take the first <b>magical weapon</b> you find, but you are transported to R''lyeh.')");
		db.execSQL(sqlInsertCardEnc + " (-16,392)");
		db.execSQL(sqlInsertEnc + " (392,18,'The Lodge is always eager to trade lore. Discard any number of Spells. Gain a number of Clue tokens equal to the total Sanity cost of the Spells discarded.')");
		db.execSQL(sqlInsertCardEnc + " (-16,393)");
		db.execSQL(sqlInsertEnc + " (393,23,'You see a prim and proper girl in puritanical attire, but there is something hungry in her eyes. \"Would you like to see?\" she asks, demurely. If you agree, she reaches forward to touch you. You feel a terrible cold, then the burning heat of the pyre! You realize  that she is the ghost of Keziah Mason, who was burned at the stake for witchcraft over a century ago! Make a <b>Will (-1) check</b>. You may gain 1 Clue token for each success or 1 Spell for every two successes.')");
		db.execSQL(sqlInsertCard + " (-17,3,9)");
		db.execSQL(sqlInsertCardEnc + " (-17,394)");
		db.execSQL(sqlInsertEnc + " (394,11,'A gorgeous youth invites you into a meditation chamber. If you go in, you must lose a total of 4 Spells or Stamina, divided up as you choose, but you may search the Exhibit Item deck for the Mask of the Three Fates card and take it. If it is not there, gain 4 Clue tokens instead. If you do not go in, the young witch casts a hex to make others mistrust you. Place a Patrol marker on the street area of French Hill.')");
		db.execSQL(sqlInsertCardEnc + " (-17,395)");
		db.execSQL(sqlInsertEnc + " (395,18,'\"Certainly, we''d love to have you,\" Carl Sanford says, \"if you can do something for us.\" Move to the City of the Great Race and have an encounter there, then immediately return. If you passed a test or defeated a monster encountered there, take a Silver Twilight Membership and gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (-17,396)");
		db.execSQL(sqlInsertEnc + " (396,23,'Ever since you visited the witch house, you keep seeing a strange, rat-like creature out of the corner of you eye...and sometimes it looks like its face is almost human! Gain 1 Clue token, but take the Harried card.')");
	}

	
	private static void FetchEasttownEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		db.execSQL(sqlInsertCard + " (-6,2,7)");
		db.execSQL(sqlInsertCardEnc + " (-6,133)");
		db.execSQL(sqlInsertEnc + " (133,8,'\"Hey, psst. You look like someone who could use a little information.\" Looking over at the bartender, you see him holding out his hand. You may pay him up to $6, gaining 1 Clue Token for every $2 you pay him.')");
		db.execSQL(sqlInsertCardEnc + " (-6,134)");
		db.execSQL(sqlInsertEnc + " (134,15,'Looking at one of the wanted posters, you realize that you''ve already taken care of that particular threat. You may spend 1 monster trophy with a moon dimensional symbol to gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (-6,135)");
		db.execSQL(sqlInsertEnc + " (135,26,'Velma comments on how skinny you look and gives you a sandwich on the house. You may search the Common Item deck for a Food and take it.')");
		db.execSQL(sqlInsertCard + " (40,2,7)");
		db.execSQL(sqlInsertCardEnc + " (40,136)");
		db.execSQL(sqlInsertEnc + " (136,8,'A stranger buys you a drink. You may search the Common Item deck for a Whiskey card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (40,137)");
		db.execSQL(sqlInsertEnc + " (137,15,'Sheriff Engle eyes you suspiciously. \"Hey, you were part of that trouble earlier.\" Pay him $3 or spend the next turn <i>delayed</i> answering his questions.')");
		db.execSQL(sqlInsertCardEnc + " (40,138)");
		db.execSQL(sqlInsertEnc + " (138,26,'An irritable stranger in ragged clothes is demanding money from Velma''s diners. If you do not give him $1, he <i>Curses</i> you before Velma throws him out.')");
		db.execSQL(sqlInsertCard + " (41,2,7)");
		db.execSQL(sqlInsertCardEnc + " (41,139)");
		db.execSQL(sqlInsertEnc + " (139,8,'Pass a <b>Speed (-2) check</b> to avoid being bumped into and knocked over. If you pass, nothing happens. If you do not, the proprietor tells you that you''ve had enough for one night and you are moved to the street.')");
		db.execSQL(sqlInsertCardEnc + " (41,140)");
		db.execSQL(sqlInsertEnc + " (140,15,'The phone at the front desk is ringing, but no one seems to be answering it. If you pick up the receiver, an unearthly voice whispers awful secrets to you. Lose 1 Sanity, but make a <b>Will (-1) check</b> and gain 1 Clue Token for each success.')");
		db.execSQL(sqlInsertCardEnc + " (41,141)");
		db.execSQL(sqlInsertEnc + " (141,26,'Whoever sat here before you had been scribbling on his napkin. Pass a <b>Lore (-1) check</b> to gain a Clue token.')");
		db.execSQL(sqlInsertCard + " (42,2,1)");
		db.execSQL(sqlInsertCardEnc + " (42,142)");
		db.execSQL(sqlInsertEnc + " (142,8,'A horrible monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (42,143)");
		db.execSQL(sqlInsertEnc + " (143,15,'Deputy Dingby has left the keys to the evidence locker sitting on his desk. Make a <b>Sneak (-2) check</b> and, if you succeed, search the Common Item deck for an item of your choice.')");
		db.execSQL(sqlInsertCardEnc + " (42,144)");
		db.execSQL(sqlInsertEnc + " (144,26,'Velma is brewing up a fresh pot of her famous coffee. Gain 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (43,2,6)");
		db.execSQL(sqlInsertCardEnc + " (43,145)");
		db.execSQL(sqlInsertEnc + " (145,8,'An old-timer sits down next to you and offers to teach you a trick in exchange for a drink. If you agree, gain 1 Spell for the price of $3.')");
		db.execSQL(sqlInsertCardEnc + " (43,146)");
		db.execSQL(sqlInsertEnc + " (146,15,'The police are desperate for leads and are offering a reward for information. Gain $1 for each Clue Token in your possession.')");
		db.execSQL(sqlInsertCardEnc + " (43,147)");
		db.execSQL(sqlInsertEnc + " (147,26,'You don''t notice right away, but Velma has accidentally given you too much change. Gain $1.')");
		db.execSQL(sqlInsertCard + " (44,2,6)");
		db.execSQL(sqlInsertCardEnc + " (44,148)");
		db.execSQL(sqlInsertEnc + " (148,8,'You find that tipping well gets the proprietor talking. For every $1 you spend, gain 1 Clue Token, to a maximum of $3.')");
		db.execSQL(sqlInsertCardEnc + " (44,149)");
		db.execSQL(sqlInsertEnc + " (149,15,'On the wall is a map of the city with pins marking the places where incidents have occured. Imagining lines between these points, an unnerving symbol is revealed to you. Pass a <b>Will (-1) check</b> or lose 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (44,150)");
		db.execSQL(sqlInsertEnc + " (150,26,'While eating your pork chops, a pale stranger comes out from the kitchen and whispers in your ear what you are actually eating. The stranger disappears into the night and you lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (45,2,6)");
		db.execSQL(sqlInsertCardEnc + " (45,151)");
		db.execSQL(sqlInsertEnc + " (151,8,'A horrible Monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (45,152)");
		db.execSQL(sqlInsertEnc + " (152,15,'Sheriff Engle listens to your tale. He''s ready to take action, assuming that he believes you. Pass a <b>Will (-3) check</b> to convince him. If you do, choose one location or street area and return all monsters in it to the cup as armed law enforcement officers storm in.')");
		db.execSQL(sqlInsertCardEnc + " (45,153)");
		db.execSQL(sqlInsertEnc + " (153,26,'An old man sitting alone starts choking on his meatloaf. Pass a <b>Speed (-1) check</b> to slap him on the back and dislodge the food in time. If you succeed, he tearfully thanks you and offers you his fondest possession as a reward. Draw one Unique Item. If you fail, lose 1 Sanity as you watch him pass away.')");
		db.execSQL(sqlInsertCard + " (46,2,6)");
		db.execSQL(sqlInsertCardEnc + " (46,154)");
		db.execSQL(sqlInsertEnc + " (154,8,'\"So, what''s your story, friend?\" A smiling man inquires about your adventures over a glass of gin. You tell him your story. If you spend 3 Clue Tokens, he introduces himself as <b>Ryan Dean</b> and asks to join you. Take his Ally card. If it''s not available, he gives you some useful items instead. Draw 2 Common Items.')");
		db.execSQL(sqlInsertCardEnc + " (46,155)");
		db.execSQL(sqlInsertEnc + " (155,15,'A brawl breaks out at the front desk and you get swept up into the fray. Make a <b>Fight (+0) check</b> or lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (46,156)");
		db.execSQL(sqlInsertEnc + " (156,26,'Whoever is sitting at the table behind you is having a fascinating conversation. Pass a <b>Sneak (-1) check</b> to eavesdrop, gaining one Clue token for each success.')");
		db.execSQL(sqlInsertCard + " (47,2,4)");
		db.execSQL(sqlInsertCardEnc + " (47,157)");
		db.execSQL(sqlInsertEnc + " (157,8,'Make a <b>Speed (-1) check</b> to complete a transaction. If you pass, you make $2 out of the deal. If you fail, someone catches you doing something you shouldn''t, and blackmails you. You either lose $5 or, if you either cannot or will not pay, you are reduced to 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (47,158)");
		db.execSQL(sqlInsertEnc + " (158,15,'The police department is decommissioning one of its paddy wagons and empties its trunk into the garbage. Pass a <b>Luck (+1) check</b> to draw a number of Common Items equal to the successes rolled. Choose one Item and discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (47,159)");
		db.execSQL(sqlInsertEnc + " (159,26,'Velma decides to treat you to a hero''s feast. Roll a die for each gate or monster trophy you have. For each success you roll, gain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (48,2,4)");
		db.execSQL(sqlInsertCardEnc + " (48,160)");
		db.execSQL(sqlInsertEnc + " (160,8,'The only empty seat is next to a strange, diminutive man. He has no ears, and is missing all of the fingers on his left hand. If you pass a <b>Luck (+0) check</b>, he cackles, says \"You did well, though you knew it not,\" and hands you $2.')");
		db.execSQL(sqlInsertCardEnc + " (48,161)");
		db.execSQL(sqlInsertEnc + " (161,15,'Sheriff Engle is training security guards for performances of \"The King in Yellow,\" but the training is rigorous. Make a <b>Fight (-1) check</b> to qualify. If you pass, you may search the Common Item deck and take the first <i><b>Weapon</b></i> you find. If you fail, you lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (48,162)");
		db.execSQL(sqlInsertEnc + " (162,26,'You bite into a biscuit and find a plump, white grave worm writhing inside! Make a <b>Fight (+1) check</b> to keep your lunch down. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (49,2,4)");
		db.execSQL(sqlInsertCardEnc + " (49,163)");
		db.execSQL(sqlInsertEnc + " (163,8,'The proprietor asks you to clean out the old shed and offers you your choice of money or whatever you find inside. You may either gain $1 or draw 2 Common Items, keeping one and discarding the other.')");
		db.execSQL(sqlInsertCardEnc + " (49,164)");
		db.execSQL(sqlInsertEnc + " (164,15,'You''re called in for your expertise in the unusual to help examine a violent man who attacked cast members of \"The King in Yellow.\" Make a <b>Lore (-1) check</b>. If you pass, gain 2 Clue Tokens. If you fail, Sheriff Engle demands that you stay and sort out the case. Stay here next turn.')");
		db.execSQL(sqlInsertCardEnc + " (49,165)");
		db.execSQL(sqlInsertEnc + " (165,26,'You forgot to pay for your meal. Make a <b>Luck (+0) check</b>. If you pass, you realize it later and Velma tells you not to worry about it, so nothing happens. If you fail, she sends Deputy Dingby after you. You are taken to the Police Station and <i>arrested</i>, unless you''re the Deputy.')");
		db.execSQL(sqlInsertCard + " (50,2,4)");
		db.execSQL(sqlInsertCardEnc + " (50,166)");
		db.execSQL(sqlInsertEnc + " (166,8,'A regular needs funds to get out of town, fast. He offers to sell you whatever is in his trunk. Make a <b>Will (+0) check</b> to convince him to show you his best goods. If you pass, draw a number of Common Items equal to the number of successes you rolled, and purchase any that you wish for their list price. Discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (50,167)");
		db.execSQL(sqlInsertEnc + " (167,15,'A protestor was arrested outside a performance of \"The King in Yellow,\" and his ranting can be heard from the cells. Pass a <b>Lore (-1) check</b> to gain a Clue Token.')");
		db.execSQL(sqlInsertCardEnc + " (50,168)");
		db.execSQL(sqlInsertEnc + " (168,26,'You overhear a man threatening an elderly woman with blackmail. He shows her an envelope, smiles, then returns it to his pocket and heads for the door. Make a <b>Sneak (-1) check</b> to lift the envelope from his pocket. If you pass, you may either look inside to gain a Clue token or sell it back to the woman for $1.')");
		db.execSQL(sqlInsertCard + " (51,2,3)");
		db.execSQL(sqlInsertCardEnc + " (51,169)");
		db.execSQL(sqlInsertEnc + " (169,8,'\"So, what''s your story, friend?\" A smiling man inquires about your adventures over a glass of gin. You tell him your story. If you spend 3 Clue Tokens, he introduces himself as <b>Ryan Dean</b> and asks to join you. Take his Ally card. If it''s not available, he gives you some useful items instead. Gain 2 Common Items.')");
		db.execSQL(sqlInsertCardEnc + " (51,170)");
		db.execSQL(sqlInsertEnc + " (170,15,'Deputy Dingby somehow manages to handcuff the two of you together. Stay here next turn, but you actually gain some valuable information listening to Dingby prattle on until Sheriff Engle returns. Gain 1 Clue Token.')");
		db.execSQL(sqlInsertCardEnc + " (51,171)");
		db.execSQL(sqlInsertEnc + " (171,26,'Joey \"The Rat\" is sitting at the counter and motions for you to come over. \"You looking for anything in particular?\" He has several items for sale. Draw 2 Common Item cards and pay $2 more than the list price if you wish to purchase one or both of them. \"Sorry, I got kids to feed, ya know.\"')");
		db.execSQL(sqlInsertCard + " (52,2,5)");
		db.execSQL(sqlInsertCardEnc + " (52,172)");
		db.execSQL(sqlInsertEnc + " (172,8,'\"Hey, psst. You look like someone who could use a little information.\" Looking over at the bartender, you see him holding out his hand. You may pay him up to $6, gaining 1 Clue Token for every $2 you pay him.')");
		db.execSQL(sqlInsertCardEnc + " (52,173)");
		db.execSQL(sqlInsertEnc + " (173,15,'Sheriff Engle nods to you as you enter the Police Station. \"Something I can help you with?\" If you spend 3 Clue tokens, you convince him that Arkham is in danger and he issues you a weapon. Take the first <i><b>Weapon</b></i> from the Common Item deck.')");
		db.execSQL(sqlInsertCardEnc + " (52,174)");
		db.execSQL(sqlInsertEnc + " (174,26,'\"Good grief, look at this mess. Hey, you want to make some quick cash? I''ll give you $2 to sweep the diner and take out the trash.\" If you accept, gain $2 and stay here next turn.')");
		db.execSQL(sqlInsertCard + " (53,2,3)");
		db.execSQL(sqlInsertCardEnc + " (53,175)");
		db.execSQL(sqlInsertEnc + " (175,8,'As you sip your drink, suddenly a fight breaks out in the bar! Pass a <b>Luck (-1) check</b> to make it to the door before the cops show up. If you fail, you''re arrested unless you''re the Deputy.')");
		db.execSQL(sqlInsertCardEnc + " (53,176)");
		db.execSQL(sqlInsertEnc + " (176,15,'Sheriff Engle blocks the door into the Police Station. \"Sorry, I''ve got to lock up for a bit. I''ll be back later\". Everyone in the Police Station (but not the Jail Cell) is moved to the street.')");
		db.execSQL(sqlInsertCardEnc + " (53,177)");
		db.execSQL(sqlInsertEnc + " (177,26,'Velma comments on how skinny you look and gives you a sandwich on the house. You may search the Common Item deck for a Food card and take it.')");
		db.execSQL(sqlInsertCard + " (54,2,3)");
		db.execSQL(sqlInsertCardEnc + " (54,178)");
		db.execSQL(sqlInsertEnc + " (178,8,'A sly, smiling man challenges you to a game of billiards. Incensed by his insulting manner, you accept. You bet either $2 or an item of your choice. Unfortunately, he turns out to be a pool shark and cleans you out. You lose your bet')");
		db.execSQL(sqlInsertCardEnc + " (54,179)");
		db.execSQL(sqlInsertEnc + " (179,15,'One of the prisoners carefully searches your face for any sign of pity, \"Please, you gotta get me outta here! Something''s coming to Arkham! Something horrible!\" You try to laugh away his concerns, but the abject terror in his voice sends a chill down your spine. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (54,180)");
		db.execSQL(sqlInsertEnc + " (180,26,'Today''s special is the lumberjack breakfast: a huge pile of eggs, bacon, sausage, and hash browns. If you''d like to try it, pay $2 and gain 2 Stamina and 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (55,2,3)");
		db.execSQL(sqlInsertCardEnc + " (55,181)");
		db.execSQL(sqlInsertEnc + " (181,8,'One of the bigger men in the bar challenges you to a game of darts. You must pay $1 to play, since bets are placed up front. Then, make a <b>Luck (-2) check</b>. If you pass, you win with a big bullseye. Gain $3. If you fail, the big guy claps you on the shoulder and says, \"No hard feelings, eh? I''ll buy you a drink.\" Gain 1 Sanity. If you cannot pay, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (55,182)");
		db.execSQL(sqlInsertEnc + " (182,15,'Looking at one of the wanted posters, you realize that you''ve already taken care of that particular threat. You may spend 1 monster trophy with a moon dimensional symbol to gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (55,183)");
		db.execSQL(sqlInsertEnc + " (183,26,'Today''s special is a turkey dinner with all the trimmings. You may spend $3 to gain 4 points split between your Sanity and Stamina however you like.')");
		db.execSQL(sqlInsertCard + " (56,2,3)");
		db.execSQL(sqlInsertCardEnc + " (56,184)");
		db.execSQL(sqlInsertEnc + " (184,8,'A stranger buys you a drink. You may search the Common Item deck for a Whiskey card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (56,185)");
		db.execSQL(sqlInsertEnc + " (185,15,'Looking at one of the wanted posters, you realize that you''ve already taken care of that particular threat. You may spend 1 monster trophy with a moon dimensional symbol to gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (56,186)");
		db.execSQL(sqlInsertEnc + " (186,26,'If <b>Velma''s Gratitude</b> is facedown, a muscular man begins to tear up the joint. If your current Fight is at least 4, you may draw 1 Injury to throw him out. If you do so, turn <b>Velma''s Gratitude</b> faceup. \"Thanks so much, hon. You and your friends can eat here for free whenever you like.\"')");
		db.execSQL(sqlInsertCard + " (57,2,2)");
		db.execSQL(sqlInsertCardEnc + " (57,187)");
		db.execSQL(sqlInsertEnc + " (187,8,'A truck driver at the bar has a flat tire and needs help changing it. If you pass a <b>Fight (-1) check</b>, you help him out and he offers you some of his cargo for free. Search the Common Item deck for your choice of a Lantern, Map of Arkham, or Dark Cloak, and take that card.')");
		db.execSQL(sqlInsertCardEnc + " (57,188)");
		db.execSQL(sqlInsertEnc + " (188,15,'You stop by to say hello when you hear an argument from Sheriff Engle''s office. \"But why would a killer perfume the body with lavender and peppermint?\" Make a <b>Lore (-2) check</b>. If you pass, you recognize those herbs as being used in an ancient Egyptian embalming practices. Gain 1 Clue Token and the Sheriff rewards you with the Private Investigator card.')");
		db.execSQL(sqlInsertCardEnc + " (57,189)");
		db.execSQL(sqlInsertEnc + " (189,26,'You take a job working in the diner for tips, and you''ll never disparage a waitress again. Make a <b>Speed (-1) check</b>. If you succeed, gain $2. If you fail, lose 1 Stamina but you may search the Skill deck for the Speed card and take it.')");
		db.execSQL(sqlInsertCard + " (58,2,2)");
		db.execSQL(sqlInsertCardEnc + " (58,190)");
		db.execSQL(sqlInsertEnc + " (190,8,'A man sets down a briefcase, muttering furtively. \"Have you seen the yellow sign?\" Pass a <b>Lore (-3) check</b> to draw the yellow sign in a pool of beer on the counter, at which he nods and leaves the briefcase. Search the Common Item deck and take the first <b>Weapon</b> you find, and gain $10!')");
		db.execSQL(sqlInsertCardEnc + " (58,191)");
		db.execSQL(sqlInsertEnc + " (191,15,'Make a <b>Sneak (-1) check</b> to listen in on an interrogation, and consult the following chart.<br /><br />Successes:<br />:0) You misunderstand what is discussed. Lose 1 Clue Token. <br />:1-2) Deputy Dingby sees you standing by the door. Pay $2 to gain 1 Clue Token. <br />:3+) What you overhear helps you put the pieces together. Gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCardEnc + " (58,192)");
		db.execSQL(sqlInsertEnc + " (192,26,'Velma asks you to sample her new Egyptian barley soup recipe. Pass a <b>Luck (-2) check</b> to gain Stamina equal to your number of successes. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (59,2,2)");
		db.execSQL(sqlInsertCardEnc + " (59,193)");
		db.execSQL(sqlInsertEnc + " (193,8,'\"Friendly game of pool?\" Make a <b>Speed (+0) check</b> and consult the chart below.<br /><br />Successes:<br />:0) You lose $3.<br />:1-2) You notice that your opponent is cheating! If you confront him, he shoves $3 at you but scowls, telling you you''d better not come back here. You are <i>Barred from Easttown</i>.<br />:3) You gain $3.')");
		db.execSQL(sqlInsertCardEnc + " (59,194)");
		db.execSQL(sqlInsertEnc + " (194,15,'With all the strange outsiders coming to see the visiting museum exhibit, Sheriff Engle worries about Arkham''s safety. If you have a <b>Physical weapon</b>, he gives you some training, and you may search the Skill deck for the Marksman card and take it. If you do not have a <b>Physical weapon</b>, search the Common Item deck and take the first <b>Weapon</b> you find.')");
		db.execSQL(sqlInsertCardEnc + " (59,195)");
		db.execSQL(sqlInsertEnc + " (195,26,'Free Egyptian grain bread to make the newcomers welcome! Gain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (60,2,2)");
		db.execSQL(sqlInsertCardEnc + " (60,196)");
		db.execSQL(sqlInsertEnc + " (196,8,'<b>Erica Carlyle</b> is slumming it, and seems intrigued by your tales of mystery. If you have $3 or less, she agrees to join you and help pay your way. Take her Ally card or, if it is not available, gain a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (60,197)");
		db.execSQL(sqlInsertEnc + " (197,15,'One of the jail''s \"guests\" decides to end it all rather than face justice, and Deputy Dingby offers you a pick of his belongings. Pass a <b>Luck (+0) check</b> to draw a number of cards from the Common Item deck equal to the number of successes rolled. Keep 1 card and discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (60,198)");
		db.execSQL(sqlInsertEnc + " (198,26,'You begin pumping the \"Legacy of the Pharoahs\" exhibit curator for information. He of course denies that the exhibit has anything to do with the strange occurrences in Arkham lately, and offers to pay for your meal to make sure you tell the same to anyone you work for. If you have the Retainer, Deputy of Arkham, or Silver Twilight Lodge Membership cards, you may discard one to gain 2 Stamina and $5.')");
		db.execSQL(sqlInsertCard + " (61,2,2)");
		db.execSQL(sqlInsertCardEnc + " (61,199)");
		db.execSQL(sqlInsertEnc + " (199,8,'The man at the bar next to you is deep in his cups. Pass a <b>Luck (+0) check</b> to realize that he''s a loan officer from the Bank. He is so drunk that he barely remembers his name. You may gain a Bank Loan from him, or if you have a Bank Loan already, may convince him that you have paid it off, and may discard the Bank Loan card.')");
		db.execSQL(sqlInsertCardEnc + " (61,200)");
		db.execSQL(sqlInsertEnc + " (200,15,'You are called in for questioning about missing artifacts from the \"Legacy of the Pharaohs\" exhibit. Make a <b>Will (-1) check</b>. If you pass, the Sheriff believes you are innocent, and his questions tip you off about a few things; Gain 1 Clue Token. If you fail, he doubts your word, and accuses you of a crime! Choose between being <i>arrested</i> and taking the Wanted card.')");
		db.execSQL(sqlInsertCardEnc + " (61,201)");
		db.execSQL(sqlInsertEnc + " (201,26,'A reporter from the <i>Arkham Advertiser</i> offers you money to plant a dead scarab beetle in your soup bowl so he can get a story. If you do so, gain $3 but you are <i>Barred from Easttown</i>.')");
		db.execSQL(sqlInsertCard + " (62,2,8)");
		db.execSQL(sqlInsertCardEnc + " (62,202)");
		db.execSQL(sqlInsertEnc + " (202,8,'A barfly sits down next to you and shares boring and incoherent stories. Make a <b>Will (-1) check</b> to endure these dull tales until he''s finished talking. If you pass, he tells you, \"You''re a good sort,\" and offers you a gift. Draw 1 Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (62,203)");
		db.execSQL(sqlInsertEnc + " (203,15,'Sheriff Engle wrestles a prisoner into the lobby of the Police Station. The handcuffed man bumps into you and whispers, \"I can''t be found with this.\" Make a <b>Sneak (-1) check</b>. If you pass, draw 1 Common item.')");
		db.execSQL(sqlInsertCardEnc + " (62,204)");
		db.execSQL(sqlInsertEnc + " (204,26,'You see a veteran, blinded by gas during the Great War, come into the diner. Spend $2 to buy him dinner or lose 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (63,2,5)");
		db.execSQL(sqlInsertCardEnc + " (63,205)");
		db.execSQL(sqlInsertEnc + " (205,8,'\"Nothing interesting''s happened here in a week,\" sighs a bored barfly as you step up to the bar. Taking stock of the mostly empty place, you believe it. As you think better and turn to go, the man takes a cue from the owner''s dirty look and stands to go with you, asking \"Where are you headed?\" Take <b>Ryan Dean''s</b> Ally card. If it''s not available, draw two Common Items instead.')");
		db.execSQL(sqlInsertCardEnc + " (63,206)");
		db.execSQL(sqlInsertEnc + " (206,15,'The word \"Reward\" on a leaflet gets your attention. You may spend one monster trophy with a moon dimensional symbol on it to gain $5.')");
		db.execSQL(sqlInsertCardEnc + " (63,207)");
		db.execSQL(sqlInsertEnc + " (207,26,'The diner in the next booth suddenly checks his watch, stands, and rushes out the door. When Velma comes over with his blue-plate special and you explain his absence, she offers it to you, on the house. \"No sense throwing it out,\" she says. Search the Common Item deck for a Food card and take it.')");
		db.execSQL(sqlInsertCard + " (64,2,8)");
		db.execSQL(sqlInsertCardEnc + " (64,208)");
		db.execSQL(sqlInsertEnc + " (208,8,'\"Care to make a couple extra bucks?\" The proprietor needs some help moving in the new pool table. Make a <b>Fight (-1) check</b> and gain $2 if you pass.')");
		db.execSQL(sqlInsertCardEnc + " (64,209)");
		db.execSQL(sqlInsertEnc + " (209,15,'Deputy Dingby forgot to bring his lunch today, and if you help him out, he''ll become very friendly and chatty. You may give the Deputy either the Food Common Item card or $1 to gain 1 Clue token in return.')");
		db.execSQL(sqlInsertCardEnc + " (64,210)");
		db.execSQL(sqlInsertEnc + " (210,26,'Velma''s got a fire in the kitchen! Make a <b>Speed (-2) check</b> to extinguish it before any damage is done. If you pass, Velma''s grateful expression inspires you and you recover 1 Sanity. If you fail, lose 1 Stamina from some bad burns.')");
		db.execSQL(sqlInsertCard + " (65,2,5)");
		db.execSQL(sqlInsertCardEnc + " (65,211)");
		db.execSQL(sqlInsertEnc + " (211,8,'\"You''re in my seat, friend,\" says someone behind you. If you succeed in a <b>Will (-1) check</b>, you stare him down and keep you chair. If you fail, his meaty associates toss you in their trunk and dump you somewhere. Draw a Mythos card and move to the Gate location shown on it, then have an encounter in your new location.')");
		db.execSQL(sqlInsertCardEnc + " (65,212)");
		db.execSQL(sqlInsertEnc + " (212,15,'\"Sure, Deputy, I''ve got a permit for that. Yeah, that too.\" You''re lying through your teeth, but if you can sell it, he''ll drop the issue. Make a <b>Will (-1) check</b>. If you fail, you must discard all of your <i><b>Weapon</b></i> cards, and are <i>arrested</i>.')");
		db.execSQL(sqlInsertCardEnc + " (65,213)");
		db.execSQL(sqlInsertEnc + " (213,26,'There''s a hideous shriek outside. You may move to the street, where - if the Sky contains any monsters - you find some poor fallen soul, still clutching a weapon. Search the Common Item deck and take the first <i><b>Weapon</b></i> you find. Otherwise, nothing happens.')");
		db.execSQL(sqlInsertCard + " (66,2,1)");
		db.execSQL(sqlInsertCardEnc + " (66,214)");
		db.execSQL(sqlInsertEnc + " (214,8,'Joey \"The Rat\" Vigil slips into an empty chair at your table and whispers, \"Pssst! Wanna buy something?\" Look at the top 3 cards of the Common Item deck. You may purchase any or all of them for $1 above the list price. \"Hey, I''ve got overhead!\" the Rat explains')");
		db.execSQL(sqlInsertCardEnc + " (66,215)");
		db.execSQL(sqlInsertEnc + " (215,15,'If you succeed at a <b>Luck (-1) check</b>, then Deputy Dingby absentmindedly leaves you holding his gun. You may search the Common Item deck for a .38 Revolver card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (66,216)");
		db.execSQL(sqlInsertEnc + " (216,26,'You spot a rat leaving the kitchen. Pass a <b>Will (-2) check</b> to convince Velma to bribe you $5 not to tell anyone.')");
		db.execSQL(sqlInsertCard + " (67,2,1)");
		db.execSQL(sqlInsertCardEnc + " (67,217)");
		db.execSQL(sqlInsertEnc + " (217,8,'A stranger buys you a drink. You may search the Common Item deck for a Whiskey card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (67,218)");
		db.execSQL(sqlInsertEnc + " (218,15,'Pass a <b>Will (-1) check</b> to convince Deputy Dingby to share some files with you that are very interesting. Gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCardEnc + " (67,219)");
		db.execSQL(sqlInsertEnc + " (219,26,'\"This must be where pies go when they die.\" If you want, pay $1 to enjoy a fine slice of cherry pie. If you do, gain 2 Stamina')");
		db.execSQL(sqlInsertCard + " (68,2,1)");
		db.execSQL(sqlInsertCardEnc + " (68,220)");
		db.execSQL(sqlInsertEnc + " (220,8,'You enter a \"friendly\" card game. Make a <b>Luck (-1) check</b>. If you pass, you win $5. If you fail, you lose $3. If you lose and can''t pay, the boys rough you up and throw you outside. Lose 1 Stamina and move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (68,221)");
		db.execSQL(sqlInsertEnc + " (221,15,'Deputy Dingby, excitedly cleaning his gun, fires a bullet from the chamber in your direction. Pass a <b> Luck (-1) check</b> to avoid getting shot. If you fail, lose 2 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (68,222)");
		db.execSQL(sqlInsertEnc + " (222,26,'Velma comments on how skinny you look and gives you a sandwich on the house. You may search the Common Item deck for a Food card and take it.')");
		db.execSQL(sqlInsertCard + " (69,2,1)");
		db.execSQL(sqlInsertCardEnc + " (69,223)");
		db.execSQL(sqlInsertEnc + " (223,8,'Pass a <b>Luck (-1) check</b> or a pickpocket cleans you out! Lose all your money.')");
		db.execSQL(sqlInsertCardEnc + " (69,224)");
		db.execSQL(sqlInsertEnc + " (224,15,'Deputy Dingby accidently drops a case file as he makes his way past you. Pass a <b>Sneak (+0) check</b> to search the Common Item deck for a Research Materials card and take it.')");
		db.execSQL(sqlInsertCardEnc + " (69,225)");
		db.execSQL(sqlInsertEnc + " (225,26,'You find some money on the floor under the back booth. If you take it, make a <b>Sneak (-1) check</b>. If you pass, roll a die and gain that much money. If you fail, Velma sees you pick up the money. She comes over and swipes it out of your hands screaming, \"Stealing my tips!\" so loudly that you flee the diner. Move to the street')");
		db.execSQL(sqlInsertCard + " (70,2,8)");
		db.execSQL(sqlInsertCardEnc + " (70,226)");
		db.execSQL(sqlInsertEnc + " (226,8,'A man with an accordian is playing tunes and everybody is singing along. If you choose to stay late into the evening, gain 2 Sanity, but lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (70,227)");
		db.execSQL(sqlInsertEnc + " (227,15,'\"You okay, fella? You''re not making sense.\" Sheriff Engle wants to keep you out of trouble. If you currently have 2 or less Sanity, make a <b>Fight (+0) check</b>. If you fail, lose all your <i><b>Weapons</b></i> and lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (70,228)");
		db.execSQL(sqlInsertEnc + " (228,26,'Velma''s hot turkey sandwich with potatoes and gravy hits the spot! Gain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (71,2,5)");
		db.execSQL(sqlInsertCardEnc + " (71,229)");
		db.execSQL(sqlInsertEnc + " (229,8,'You stand inside the door, surveying the crooks, drunks, and miscreants. Would anyone even be able to notice if a greater evil arose among this scum? The only way to ensure Arkham''s safety is to act now. If you have an Elder Sign, you may discard it to seal this location.')");
		db.execSQL(sqlInsertCardEnc + " (71,230)");
		db.execSQL(sqlInsertEnc + " (230,15,'\"Haven''t had time to bring him out to the asylum,\" Sheriff Engle explains when he notices you eyeing a straitjacketed lunatic ranting in one of the cells. That''s when you realize what the madman''s saying. You are <i>delayed</i> as you jot notes about his ravings, but gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCardEnc + " (71,231)");
		db.execSQL(sqlInsertEnc + " (231,26,'A mugger emerges from out back, and sees you just as you see him. \"Keep it quiet and we''ll split the proceeds,\" he says, holding out a wallet. Either accept the stolen money and gain $3, or shout for the police and allow karma to reward you with 1 Sanity and 1 Stamina instead.')");
		db.execSQL(sqlInsertCard + " (72,2,8)");
		db.execSQL(sqlInsertCardEnc + " (72,232)");
		db.execSQL(sqlInsertEnc + " (232,8,'Whoever was sitting here before you used a knife to carve a horribe symbol into the surface of the table. Make a <b>Will (-1) check</b> and lose 1 Sanity if you fail. Then, whether you passed or not, search the Common Item deck for the Knife and take it.')");
		db.execSQL(sqlInsertCardEnc + " (72,233)");
		db.execSQL(sqlInsertEnc + " (233,15,'\"Please! My husband is innocent! He could never commit those atrocities!\" Deputy Dingby refuses to listen to the woman, but her story explains much of what has been going on. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (72,234)");
		db.execSQL(sqlInsertEnc + " (234,26,'Two businessmen are arguing over who will pay the bill, and both have put several dollars on the table. If you can sneak one of the payments off the table, each of the businessmen will think the other relented and will drop the argument. Plus, you''ll make a little money. Make a <b>Sneak (-2) check</b> and gain $3 if you pass.')");
		db.execSQL(sqlInsertCard + " (73,2,1)");
		db.execSQL(sqlInsertCardEnc + " (73,235)");
		db.execSQL(sqlInsertEnc + " (235,8,'A horrible monster appears!')");
		db.execSQL(sqlInsertCardEnc + " (73,236)");
		db.execSQL(sqlInsertEnc + " (236,15,'Sheriff Engle notes that you''re carrying an awful lot of weapons. Either pay him $5 or discard all of your <i><b>Weapons</b></i>.')");
		db.execSQL(sqlInsertCardEnc + " (73,237)");
		db.execSQL(sqlInsertEnc + " (237,26,'Velma reads the tea leaves left in your cup. Make a <b>Luck (-1) check</b>. If you pass, the formation of the leaves indicates hope, you are <i>Blessed</i>. If you fail, the future looks bleak, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (74,2,1)");
		db.execSQL(sqlInsertCardEnc + " (74,238)");
		db.execSQL(sqlInsertEnc + " (238,8,'Prohibition failed to influence the proprietor of Hibb''s. You drink heavily while quizzing the locals about the strange goings-on in Arkham. Make a <b>Will (-1) check</b>. If you pass, you hold your liquor and learn something. Gain 2 Clue tokens. If you fail, you pass out. Move to the street and either have 1 item (your choice) or all of your money stolen.')");
		db.execSQL(sqlInsertCardEnc + " (74,239)");
		db.execSQL(sqlInsertEnc + " (239,15,'Sheriff Engle trusts you and asks you to step into his office to discuss the recent strange events. Pass a <b>Luck (-2) check</b> to convince him to take you into his confidence and give you something to help you out. Draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (74,240)");
		db.execSQL(sqlInsertEnc + " (240,26,'You get food poisoning! Pass a <b>Luck (-1) check</b> or lose 2 Stamina.')");
		db.execSQL(sqlInsertCard + " (75,2,1)");
		db.execSQL(sqlInsertCardEnc + " (75,241)");
		db.execSQL(sqlInsertEnc + " (241,8,'\"So, what''s your story, friend?\" A smiling man inquires about your adventures over a glass of gin. You tell him your story. If you spend 3 Clue Tokens, he introduces himself as <b>Ryan Dean</b> and asks to join you. Take his Ally card. If it''s not available, he gives you some useful items instead. Gain 2 Common Items.')");
		db.execSQL(sqlInsertCardEnc + " (75,242)");
		db.execSQL(sqlInsertEnc + " (242,15,'One of the men in the holding cells tries to intimidate you with stories about the things he''s seen. Make a <b>Will (-1) check</b>. If you pass, gain 1 Clue Token. If you fail, move to the street and lose 1 Sanity as the man laughs at your retreating back. ')");
		db.execSQL(sqlInsertCardEnc + " (75,243)");
		db.execSQL(sqlInsertEnc + " (243,26,'\"What''ll it be, hon?\" Velma takes your order. Pay up to $6 to gain that many points split between Sanity and Stamina however you like.')");
		db.execSQL(sqlInsertCard + " (76,2,5)");
		db.execSQL(sqlInsertCardEnc + " (76,244)");
		db.execSQL(sqlInsertEnc + " (244,8,'You look up and everyone''s gone - you must have fallen asleep at the bar. Unnerved by the eerie silence of the previously hopping establishment, you grab the bottle in front of you and skedaddle. Search the Common Items deck for a Whiskey card.')");
		db.execSQL(sqlInsertCardEnc + " (76,245)");
		db.execSQL(sqlInsertEnc + " (245,15,'You''re sitting in the reception area when Sheriff Engle steps out of the back. He looks at you intently. Make a <b>Will (-1) check</b>. If you succeed, he hands you a pair of handcuffs and says \"you look like you could put these to good use.\" Search the common Items deck for a Handcuffs card. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (76,246)");
		db.execSQL(sqlInsertEnc + " (246,26,'\"You want the regular pie, or the magic pie?\" asks Velma, with no apparent trace of irony. You may spend $5 to gain 1 Stamina, 1 Sanity, and become <i>Blessed</i>.')");
		db.execSQL(sqlInsertCard + " (-7,2,9)");
		db.execSQL(sqlInsertCardEnc + " (-7,247)");
		db.execSQL(sqlInsertEnc + " (247,8,'\"Friendly game of pool?\" Make a <b>Speed (+0) check</b> and consult the chart below.<br /><br />Successes:<br />:0) You lose $3.<br />:1-2) You notice that your opponent is cheating! If you confront him, place a Patrol marker on the street area of Easttown and gain $3. As he shoves the money at you, he scowls, telling you you''d better not come back here.<br />:3) You gain $3.')");
		db.execSQL(sqlInsertCardEnc + " (-7,248)");
		db.execSQL(sqlInsertEnc + " (248,15,'With all the strange outsiders coming to see the visiting museum exhibit, Sheriff Engle worries about Arkham''s safety. If you have a <b>Physical weapon</b>, he gives you some training, and you may search the Skill deck for the Marksman card and take it. If you do not have a <b>Physical weapon</b>, search the Common Item deck and take the first <b>Weapon</b> you find.')");
		db.execSQL(sqlInsertCardEnc + " (-7,249)");
		db.execSQL(sqlInsertEnc + " (249,26,'Free Egyptian grain bread to make the newcomers welcome! Gain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (-8,2,9)");
		db.execSQL(sqlInsertCardEnc + " (-8,250)");
		db.execSQL(sqlInsertEnc + " (250,8,'The man at the bar next to you is deep in his cups. Pass a <b>Luck (+0) check</b> to realize that he''s a loan officer from the Bank. He is so drunk that he barely remembers his name. You may gain a Bank Loan from him, or if you have a Bank Loan already, may convince him that you have paid it off, and may discard the Bank Loan card.')");
		db.execSQL(sqlInsertCardEnc + " (-8,251)");
		db.execSQL(sqlInsertEnc + " (251,15,'You are called in for questioning about missing artifacts from the \"Legacy of the Pharaohs\" exhibit. Make a <b>Will (-1) check</b>. If you pass, the Sheriff believes you are innocent, and his questions tip you off about a few things; Gain 1 Clue Token. If you fail, he doubts your word, and accuses you of a crime! Choose between being <i>arrested</i> and taking the Wanted card.')");
		db.execSQL(sqlInsertCardEnc + " (-8,252)");
		db.execSQL(sqlInsertEnc + " (252,26,'A reporter from the <i>Arkham Advertiser</i> offers you money to plant a dead scarab beetle in your soup bowl so he can get a story. If you do so, gain $3 but place a Patrol marker on the street area of Easttown.')");
		db.execSQL(sqlInsertCard + " (-9,2,9)");
		db.execSQL(sqlInsertCardEnc + " (-9,253)");
		db.execSQL(sqlInsertEnc + " (253,8,'A truck driver at the bar has a flat tire and needs help changing it. If you pass a <b>Fight (-1) check</b>, you help him out and he offers you some of his cargo for free. Search the Common Item deck for your choice of a Lantern, Map of Arkham, or Dark Cloak, and take that card.')");
		db.execSQL(sqlInsertCardEnc + " (-9,254)");
		db.execSQL(sqlInsertEnc + " (254,15,'You stop by to say hello when you hear an argument from Sheriff Engle''s office. \"But why would a killer perfume the body with lavender and peppermint?\" Make a <b>Lore (-2) check</b>. If you pass, you recognize those herbs as being used in an ancient Egyptian embalming practices. Gain 1 Clue Token and the Sheriff rewards you with the Private Investigator card.')");
		db.execSQL(sqlInsertCardEnc + " (-9,255)");
		db.execSQL(sqlInsertEnc + " (255,26,'You take a job working in the diner for tips, and you''ll never disparage a waitress again. Make a <b>Speed (-1) check</b>. If you succeed, gain $2. If you fail, lose 1 Stamina but you may search the Skill deck for the Speed card and take it.')");
		db.execSQL(sqlInsertCard + " (-10,2,9)");
		db.execSQL(sqlInsertCardEnc + " (-10,256)");
		db.execSQL(sqlInsertEnc + " (256,8,'A man sets down a briefcase, muttering furtively. \"Have you seen the yellow sign?\" Pass a <b>Lore (-3) check</b> to draw the yellow sign in a pool of beer on the counter, at which he nods and leaves the briefcase. Search the Common Item deck and take the first <b>Weapon</b> you find, and gain $10!')");
		db.execSQL(sqlInsertCardEnc + " (-10,257)");
		db.execSQL(sqlInsertEnc + " (257,15,'Make a <b>Sneak (-1) check</b> to listen in on an interrogation, and consult the following chart.<br /><br />Successes:<br />:0) You misunderstand what is discussed. Lose 1 Clue Token. <br />:1-2) Deputy Dingby sees you standing by the door. Pay $2 to gain 1 Clue Token. <br />:3+) What you overhear helps you put the pieces together. Gain 2 Clue Tokens.')");
		db.execSQL(sqlInsertCardEnc + " (-10,258)");
		db.execSQL(sqlInsertEnc + " (258,26,'Velma asks you to sample her new Egyptian barley soup recipe. Pass a <b>Luck (-2) check</b> to gain Stamina equal to your number of successes. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (-11,2,9)");
		db.execSQL(sqlInsertCardEnc + " (-11,259)");
		db.execSQL(sqlInsertEnc + " (259,8,'<b>Erica Carlyle</b> is slumming it, and seems intrigued by your tales of mystery. If you have $3 or less, she agrees to join you and help pay your way. Take her Ally card or, if it is not available, gain a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (-11,260)");
		db.execSQL(sqlInsertEnc + " (260,15,'One of the jail''s \"guests\" decides to end it all rather than face justice, and Deputy Dingby offers you a pick of his belongings. Pass a <b>Luck (+0) check</b> to draw a number of cards from the Common Item deck equal to the number of successes rolled. Keep 1 card and discard the rest.')");
		db.execSQL(sqlInsertCardEnc + " (-11,261)");
		db.execSQL(sqlInsertEnc + " (261,26,'You begin pumping the \"Legacy of the Pharoahs\" exhibit curator for information. He of course denies that the exhibit has anything to do with the strange occurrences in Arkham lately, and offers to pay for your meal to make sure you tell the same to anyone you work for. If you have the Retainer, Deputy of Arkham, or Silver Twilight Lodge Membership cards, you may discard one to gain 2 Stamina and $5.')");
		db.execSQL(sqlInsertCard + " (-12,2,3)");
		db.execSQL(sqlInsertCardEnc + " (-12,262)");
		db.execSQL(sqlInsertEnc + " (262,8,'\"Hey, psst. You look like someone who could use a little information.\" Looking over at the bartender, you see him holding out his hand. You may pay him up to $6, gaining 1 Clue Token for every $2 you pay him.')");
		db.execSQL(sqlInsertCardEnc + " (-12,263)");
		db.execSQL(sqlInsertEnc + " (263,15,'Deputy Dingby accidently locks you in a cell. Stay here next turn while he looks for the keys, apologizing all the while.')");
		db.execSQL(sqlInsertCardEnc + " (-12,264)");
		db.execSQL(sqlInsertEnc + " (264,26,'A young man throws down his apron as he storms out of the kitchen. \"That does it, I quit!\" Looking up, Velma yells, \"What? But where am I going to find a dishwasher on this short notice?\" If you want, you may make a <b>Will (-1) check</b> to talk her into giving you the job. Ff you pass, you gain a Retainer.')");
	}

	private static void FetchDowntownEncounters(SQLiteDatabase db,
			String sqlInsertCard, String sqlInsertCardEnc, String sqlInsertEnc) {
		// Downtown
		db.execSQL(sqlInsertCard + " (1,1,1)");
		db.execSQL(sqlInsertCardEnc + " (1,1)");
		db.execSQL(sqlInsertEnc + " (1,2,'In the Doctor''s study, you find a book of helpful notes gathered from inmate interviews.  Make a <b>Lore (+0) check</b> and consult the following chart:<br /><br />Successes:<br />:0) Their stories fill you with horror even as you learn a few bits of knowledge.  Lose 1 Sanity and gain 1 Clue token.<br />:1-2) You find several pieces of useful information.  Gain 2 Clue tokens.<br />:3+) One of the interviews contains vital information.  Gain 3 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (1,2)");
		db.execSQL(sqlInsertEnc + " (2,3,'One of the other customers in the bank recognizes you and offers you a lift. Move to any location or street area in Arkham. If you move to a location, immediately have an encounter there.')");
		db.execSQL(sqlInsertCardEnc + " (1,3)");
		db.execSQL(sqlInsertEnc + " (3,10,'A pair of friendly picnickers share their lunch with you. Gain 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (2,1,5)");
		db.execSQL(sqlInsertCardEnc + " (2,4)");
		db.execSQL(sqlInsertEnc + " (4,2,'<i>On the Healing of Mind and Spirit</i> is the title of the book you find sitting, unattended, on one of the end tables in the lounge.  Intrigued, you flip through its pages.  Restore your Sanity to its maximum and gain a Clue token.')");
		db.execSQL(sqlInsertCardEnc + " (2,5)");
		db.execSQL(sqlInsertEnc + " (5,3,'As you stand in line for the teller, the bank Vice President motions you over to his office. \"We''re aware of the good you''ve done. The Bank of Arkham thanks you.\" You may spend  10 toughness worth of monster trophies, 1 gate trophy and 5 toughness worth of monster trophies, or 2 gate trophies to either gain $10 or to discard any investigator''s Bank Loan.')");
		db.execSQL(sqlInsertCardEnc + " (2,6)");
		db.execSQL(sqlInsertEnc + " (6,10,'Make a <b>Will (-1) check</b>. If you succeed, you may take <b>Anna Kaslow''s</b> Ally card, or, if it''s not available, 2 Clue tokens.')");
		db.execSQL(sqlInsertCard + " (3,1,8)");
		db.execSQL(sqlInsertCardEnc + " (3,7)");
		db.execSQL(sqlInsertEnc + " (7,2,'The doctors allow you to observe the therapy session of one of the asylum''s most disturbed patients. Make a <b>Will (-1) check</b> to maintain your wits enough to garner useful information from his story. If you pass, gain 2 Clue tokens. Then, whether you pass or not, lose 1 Sanity after learning of his bone-chilling experiences.')");
		db.execSQL(sqlInsertCardEnc + " (3,8)");
		db.execSQL(sqlInsertEnc + " (8,3,'A large painting of historic Arkham hangs in the bank lobby. Examining it, you notice an unnerving circle of stones barely visible on the edge of the city. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (3,9)");
		db.execSQL(sqlInsertEnc + " (9,10,'A bronze plate near Founder''s Rock commemorates the establishing of the city. You notice that a line of odd symbols runs along the border of the marker. Make a <b>Lore (-1) check</b> to interpret their meaning. If you pass, gain 1 Spell.')");
		db.execSQL(sqlInsertCard + " (4,1,4)");
		db.execSQL(sqlInsertCardEnc + " (4,10)");
		db.execSQL(sqlInsertEnc + " (10,2,'A surprising number of society''s elite have checked in lately, and they need assistants to represent their interests during their \"time abroad.\" Pass a <b>Will (-2) check</b> to gain a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (4,11)");
		db.execSQL(sqlInsertEnc + " (11,3,'The bank offers a special incentive to anyone who opens an account: Take out a loan and get free tickets to the next performance of \"The King in Yellow.\" You may take out a Bank Loan if you don''t already have one, gaining $12 from the loan instead of $10. However, if you do so, you also lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (4,12)");
		db.execSQL(sqlInsertEnc + " (12,10,'You see someone battling a monster and rush to help. A monster appears! If you fight and defeat it, you may roll a number of dice equal to its toughness. If you roll a success, you may draw a random Ally. If you do not roll any successes, you may draw a Unique Item.')");
		db.execSQL(sqlInsertCard + " (5,1,8)");
		db.execSQL(sqlInsertCardEnc + " (5,13)");
		db.execSQL(sqlInsertEnc + " (13,2,'You discover that the patient you''ve been looking for has been lobotomized. He can''t answer your questions now. Draw one Ally card from the Ally deck and return it to the box.')");
		db.execSQL(sqlInsertCardEnc + " (5,14)");
		db.execSQL(sqlInsertEnc + " (14,3,'You find a penny with a strange sigil carved into it. Amused, you flip it in the air, but then gasp as you feel the sudden gathering of magical forces around you. Make a <b>Luck (-2) check</b>. If you pass, the penny comes up heads. You are <i>Blessed</i>. If you fail, it comes up tails. you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (5,15)");
		db.execSQL(sqlInsertEnc + " (15,10,'You hoped to get near enough to the gypsy camp to eavesdrop, but a dog bark has alerted them that there is an intruder. Make a <b>Sneak (-1) check</b> to escape! If you fail, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (6,1,5)");
		db.execSQL(sqlInsertCardEnc + " (6,16)");
		db.execSQL(sqlInsertEnc + " (16,2,'An absentminded orderly hands you a clipboard containing the wrong form.  You''re about to point out his mistake when he snaps, \"I haven''t got all day!  Are you the next of kin, or aren''t you?\"  You sign the form to defuse his anger, and he hands you a bag containing some deceased soul''s personal effects.  Among them, you find $4.')");
		db.execSQL(sqlInsertCardEnc + " (6,17)");
		db.execSQL(sqlInsertEnc + " (17,3,'\"You''ve miscounted,\" says the teller, recounting your deposit and demonstrating that-- sure enough-- you had two dollars more than you thought. Gain $2.')");
		db.execSQL(sqlInsertCardEnc + " (6,18)");
		db.execSQL(sqlInsertEnc + " (18,10,'As you pass through the entry arch on Peabody Avenue, all sound dissolves into a cosmic silence. Make a <b>Luck (-1) check</b>. If you succeed, the mundane noises of Arkham return. If you fail, you are drawn through the gate nearest this location, and you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (7,1,1)");
		db.execSQL(sqlInsertCardEnc + " (7,19)");
		db.execSQL(sqlInsertEnc + " (19,2,'The guards of the sanitarium are aware that there is an intruder.  Make a <b>Sneak (-1) check</b> to escape.  If you pass, move to the street.  If you fail, you are arrested and taken to the Police Station.')");
		db.execSQL(sqlInsertCardEnc + " (7,20)");
		db.execSQL(sqlInsertEnc + " (20,3,'\"This is a stick-up, see? Nobody move!\" Three men armed with tommy guns rob the bank while you''re standing in line. Make a <b>Combat (-1) check</b>. If you pass, you drive them off. Nothing happens. If you fail, lose all of your money.')");
		db.execSQL(sqlInsertCardEnc + " (7,21)");
		db.execSQL(sqlInsertEnc + " (21,10,'A shadow falls across you from no apparent source and you shiver with more than just cold. Pass a <b>Will (-1) check</b> or lose 1 Stamina and 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (8,1,1)");
		db.execSQL(sqlInsertCardEnc + " (8,22)");
		db.execSQL(sqlInsertEnc + " (22,2,'You find some strange medicine labeled \"Dream Enhancers\" in a dusty cabinet.  If you choose to take it, make a <b>Lore (-1) check</b>.  If you pass, your visions show you how to perform a ritual.  Draw 1 Spell.  Otherwise, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (8,23)");
		db.execSQL(sqlInsertEnc + " (23,3,'You find a penny with a strange sigil carved into it. Amused, you flip it in the air, then gasp as you feel the sudden gathering of magical forces around you. Make a <b>Luck (-2) check</b>. If you pass, the penny comes up heads. You are <i>Blessed</i>. If you fail, it comes up tails. You are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (8,24)");
		db.execSQL(sqlInsertEnc + " (24,10,'There are gypsies camped out in the park. They are master thieves and you are their target. Pass a <b>Luck (-2) check</b> or lose 1 item of your choice.')");
		db.execSQL(sqlInsertCard + " (9,1,4)");
		db.execSQL(sqlInsertCardEnc + " (9,25)");
		db.execSQL(sqlInsertEnc + " (25,2,'The more time you spend with them, the more their ramblings make sense. Gain up to 3 Clue tokens, but for every Clue token you take, you lose 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (9,26)");
		db.execSQL(sqlInsertEnc + " (26,3,'The lines of businessmen. The tellers at their alters. The communion of the safety deposit room. In a flash of insight, or perhaps madness, you realize that a bank is simply another form of church and that whatever god it is consecrated to is <i>watching you</i>. You may spend any or all of your Sanity. After spending the Sanity, roll 1 die for each point you spent. If you rolled any successes, you are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (9,27)");
		db.execSQL(sqlInsertEnc + " (27,10,'A storm strikes in the midst of rehearsals, and the actors flee for cover, leaving some of their props behind. Pass a <b>Lore (-2) check</b> to realize that one of the props is real, and draw a Unique Item.')");
		db.execSQL(sqlInsertCard + " (10,1,4)");
		db.execSQL(sqlInsertCardEnc + " (10,28)");
		db.execSQL(sqlInsertEnc + " (28,2,'You hear a strange singsong voice that says, \"The way of an eagle in the air; the way of a serpent upon the rock.\" Pass a <b>Lore (-1) check</b> to gain 1 Clue token')");
		db.execSQL(sqlInsertCardEnc + " (10,29)");
		db.execSQL(sqlInsertEnc + " (29,3,'You wander past the bank after hours, and see the night watchman convulsing on the floor! Make a <b>Fight (-2) check</b> to restrain him. If you fail, you lose 1 Stamina. If you pass, he begins speaking in tongues, and some unknown power <i>Blesses</i> you.')");
		db.execSQL(sqlInsertCardEnc + " (10,30)");
		db.execSQL(sqlInsertEnc + " (30,10,'Pass a <b>Sneak (-2) check</b> to catch a glimpse of the actors rehearsing for the play, gaining 2 Clue tokens. If you fail, no sooner do they notice you than a monster appears!')");
		db.execSQL(sqlInsertCard + " (11,1,3)");
		db.execSQL(sqlInsertCardEnc + " (11,31)");
		db.execSQL(sqlInsertEnc + " (31,2,'Getting lost as you wander the halls, you wind up in the basement just in time to see two orderlies toss a bodybag into the furnace.  Make a <b>Luck (-1) check</b>.  If you pass, you manage to quietly flee the asylum.  Move to the street.  If you fail, you cry out, attracting their attention.  Fleeing through the halls, you eventually lose them, but not before hours have passed.  Stay here next turn.')");
		db.execSQL(sqlInsertCardEnc + " (11,32)");
		db.execSQL(sqlInsertEnc + " (32,3,'The old man behind you in line hands you a folded paper oracle. \"Lucky five. Trust me.\" Folding it back and forth five times, you lift the paper flap to see what it says. Make a <b>Luck (-1) check</b>. If you pass, it says, \"Fortune favors you.\" You are <i>Blessed</i>. If you fail, it says, \"Too bad.\" You are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (11,33)");
		db.execSQL(sqlInsertEnc + " (33,10,'Luckily, it''s just another quiet day in the Square. No encounter.')");
		db.execSQL(sqlInsertCard + " (12,1,3)");
		db.execSQL(sqlInsertCardEnc + " (12,34)");
		db.execSQL(sqlInsertEnc + " (34,2,'One of the doctors tells you about an experimental treatment that might help you.  It''s expensive, however.  You may pay $5 to roll a die.  On a success, discard one of your Madness cards.  On a failure, gain 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (12,35)");
		db.execSQL(sqlInsertEnc + " (35,3,'\"Have you come to empty out your safety deposit box?\" One of the tellers hands you a key. \"This way, please.\" Confused, you follow her as she leads you down into the vault, where you retrieve a small box and open it up with the key. Make a <b>Luck (-1) check</b>. If you pass, you find an odd object inside. Gain 1 Unique Item. If you fail, the box contains only a stern warning for you to flee Arkham immediately, never to return. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (12,36)");
		db.execSQL(sqlInsertEnc + " (36,10,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (13,1,3)");
		db.execSQL(sqlInsertCardEnc + " (13,37)");
		db.execSQL(sqlInsertEnc + " (37,2,'Sneaking into the file room, you begin looking through the patient interviews for information that could be of use to you.  If you pass a <b>Lore (-1) [2] check</b>, then roll a die and gain that many Clue tokens.  If you fail, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (13,38)");
		db.execSQL(sqlInsertEnc + " (38,3,'It seems that bank interest rates are especially favorable today. You may take out a <b>Bank Loan</b> if you don''t already have one. If you do so, Gain $15 instead of the normal $10. However, you still only need to pay back the normal $10.')");
		db.execSQL(sqlInsertCardEnc + " (13,39)");
		db.execSQL(sqlInsertEnc + " (39,10,'Anna Kaslow gives you a tarot reading. Look at the top card of the mythos deck. If it isn''t \"The Story Continues,\" then you may choose to discard it to the bottom of the deck. If it is \"The Story Continues,\" return it to the top of the deck.')");
		db.execSQL(sqlInsertCard + " (14,1,3)");
		db.execSQL(sqlInsertCardEnc + " (14,40)");
		db.execSQL(sqlInsertEnc + " (40,2,'One of the doctors tries hypnotic therapy to allow you to tap into your subconscious.  You have strange visions of faraway places and times that allow you to reach a greater understanding of yourself.  Gain 1 Sanity and 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (14,41)");
		db.execSQL(sqlInsertEnc + " (41,3,'You recognize several members of the Sheldon Gang in line. If you have a <b>Sheldon Gang Membership</b>, you keep silent as they run a classic con on the bank teller, and they slip you $4 on the way out of the bank. If you do not have a membership, knowing that they''ve got to be up to no good, you warn the bank guard and directs them to leave. However, you get punched in the stomach by one of the Sheldon boys on their way out. Lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (14,42)");
		db.execSQL(sqlInsertEnc + " (42,10,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (15,1,4)");
		db.execSQL(sqlInsertCardEnc + " (15,43)");
		db.execSQL(sqlInsertEnc + " (43,2,'Volunteers for art therapy are requested. The inmates'' paintings are a window into their madness. Pass a <b>Will (-1) check</b> to gain 2 Clue tokens. If you fail, lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (15,44)");
		db.execSQL(sqlInsertEnc + " (44,3,'The bank hosts a fund drive for the arts. If you spend $1 to make a donation, you are entered in a lottery. Pass a <b>Luck (-2) check</b> to draw 1 Unique Item.')");
		db.execSQL(sqlInsertCardEnc + " (15,45)");
		db.execSQL(sqlInsertEnc + " (45,10,'A fluttering yellow leaf falls from the old oak in the center of the square, and you glimpse a design on its surface. Make a <b>Speed (-1) check</b> to catch it before it falls among the other leaves. If you pass, you see that the leaf''s veins form the shape of the Yellow Sign: Gain 1 Clue token.')");
		db.execSQL(sqlInsertCard + " (16,1,6)");
		db.execSQL(sqlInsertCardEnc + " (16,46)");
		db.execSQL(sqlInsertEnc + " (46,2,'Doctor Mintz says that one of the patients has been specifically asking for you. The lunatic calmly offers to put you in touch with unearthly power in exchange for information. For each Clue token you spend, you may draw 1 Spell. Choose 1 Spell to keep from among those you draw and discard the others.')");
		db.execSQL(sqlInsertCardEnc + " (16,47)");
		db.execSQL(sqlInsertEnc + " (47,3,'A man approaches you with a business proposition. \"The Bank won''t give me any money, but I know I can make us a fortune!\" If you''re interested in investing, give him $5 and take a Retainer card.')");
		db.execSQL(sqlInsertCardEnc + " (16,48)");
		db.execSQL(sqlInsertEnc + " (48,10,'You meet Anna Kaslow, a fortune teller who may have some insight into your investigation. Make a <b>Will (-1) check</b>. If you pass, you persuade her to help you. Take her Ally card if it is available. Otherwise, gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (17,1,3)");
		db.execSQL(sqlInsertCardEnc + " (17,49)");
		db.execSQL(sqlInsertEnc + " (49,2,'One of the doctors seems especially interested in your dreams.  \"Dreams are the key to the subconscious, and you clearly have some very deep-seated issues.\"  Amazingly, telling someone else about your nightmares seems to free you of them.  Stay here next turn and restore your Sanity to its maximum value.')");
		db.execSQL(sqlInsertCardEnc + " (17,50)");
		db.execSQL(sqlInsertEnc + " (50,3,'The old man standing outside the bank looks into you face hopefully. \"Spare some change?\" If you give him $2 or discard a Whiskey card, he whispers a few words of power in your ears. Draw 1 Spell. If you do not give him $2, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (17,51)");
		db.execSQL(sqlInsertEnc + " (51,10,'A brass band plays some soft music from the veranda. Tapping your feet along with the catchy tunes, you feel better than you have in a while. Gain 2 Sanity.')");
		db.execSQL(sqlInsertCard + " (18,1,6)");
		db.execSQL(sqlInsertCardEnc + " (18,52)");
		db.execSQL(sqlInsertEnc + " (52,2,'You discover two men struggling, each claiming that he is a doctor and that the other is an inmate. Make a <b>Luck (-2) check</b>. If you succeed, you assist the real doctor in subduing the patient and regain 2 Sanity as you reaffirm your ability to discern between the rational and the mad. If you do not succeed, lose 2 Stamina as the real maniac stabs you in the back.')");
		db.execSQL(sqlInsertCardEnc + " (18,53)");
		db.execSQL(sqlInsertEnc + " (53,3,'The bank guard starts making friendly conversation with you about the people he sees every day. Make a <b>Luck (+0) check</b>. If you pass, gain 1 Clue token. If you fail, his manager interrupts him before he can share anything useful.')");
		db.execSQL(sqlInsertCardEnc + " (18,54)");
		db.execSQL(sqlInsertEnc + " (54,10,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (19,1,5)");
		db.execSQL(sqlInsertCardEnc + " (19,55)");
		db.execSQL(sqlInsertEnc + " (55,2,'Doctor Mintz has a maniacal gleam in his eye as he approaches. Pass a <b>Fight (-2) check</b> to escape. If you fail, lose 1 Stamina and gain 1 Sanity under his new treatment.')");
		db.execSQL(sqlInsertCardEnc + " (19,56)");
		db.execSQL(sqlInsertEnc + " (56,3,'The teller hands you a safety deposit box key. \"This is for you.\" If you choose  to open the box, make a <b>Luck (-2) check</b>. If you pass, draw 1 Unique item. If you fail, lose 2 Sanity and move to the street as you flee the bank in terror.')");
		db.execSQL(sqlInsertCardEnc + " (19,57)");
		db.execSQL(sqlInsertEnc + " (57,10,'The gypsies are singing and dancing. You may join them. Make a <b>Luck (-1) check</b>. If you pass, gain 2 Clue tokens as you realize what they''re singing about. If you fail, the gypsy spell is completed and a gate appears!')");
		db.execSQL(sqlInsertCard + " (20,1,6)");
		db.execSQL(sqlInsertCardEnc + " (20,58)");
		db.execSQL(sqlInsertEnc + " (58,2,'An inmate confides in you that he is actually a reporter, investigating the conditions at the asylum. He fears he will not keep his sanity much longer and begs you to smuggle his notes to Editor Doyle Jeffries. Pass a <b>Sneak (-1) check</b> to receive $3 for your troubles. If not, the nursing staff confiscates the notes and burns them. You must move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (20,59)");
		db.execSQL(sqlInsertEnc + " (59,3,'A group of women are collecting charitable donations on behalf of orphans and widows. If you contribute $3, regain 1 Sanity as they thank you profusely.')");
		db.execSQL(sqlInsertCardEnc + " (20,60)");
		db.execSQL(sqlInsertEnc + " (60,10,'As you pass by a game of horseshoes, a bad throw sends one straight at you. Pass a <b>Speed (+0) check</b> or lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (21,1,6)");
		db.execSQL(sqlInsertCardEnc + " (21,61)");
		db.execSQL(sqlInsertEnc + " (61,2,'A voice on the other side of a locked door sounds familiar. It seems like someone from your childhood, maybe a teacher or a friend of your parents. The voice calls out your name and promises you a slow, painful death. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (21,62)");
		db.execSQL(sqlInsertEnc + " (62,3,'The strange events have prompted a mob of people to empty their accounts and leave town. Pass a <b>Will (-2) check</b> to change their minds or the bank closes for the rest of the game. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (21,63)");
		db.execSQL(sqlInsertEnc + " (63,10,'You find the remains of a small fire. Among the ashes you find a few scraps of paper that didn''t completely burn. Make a <b>Luck (+0) check</b> and consult the chart below.<br /><br />Successes:<br />:0) You are <i>Cursed</i>.<br />:1) Gain 1 Clue token.<br />:2+) Gain 1 Spell.')");
		db.execSQL(sqlInsertCard + " (22,1,3)");
		db.execSQL(sqlInsertCardEnc + " (22,64)");
		db.execSQL(sqlInsertEnc + " (64,2,'One of the doctors tells you about an experimental treatment that might help you.  It''s expensive, however.  You may pay $5 to roll a die.  On a success, discard one of your Madness cards.  On a failure, gain 2 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (22,65)");
		db.execSQL(sqlInsertEnc + " (65,3,'Looking down at your bank statement, it appears that the bank has made an error in your favor. When you try to bring it to the teller''s attention, she primly tells you, \"We don''t make mistakes here at the First Bank of Arkham.\" Shrugging, you keep the money. Gain $3.')");
		db.execSQL(sqlInsertCardEnc + " (22,66)");
		db.execSQL(sqlInsertEnc + " (66,10,'Make a <b>Will (-1) check</b>. If you pass it, <b>Anna Kaslow</b> the fortune teller, offers her help in your investigation. Take her Ally card if it is still available. Otherwise, gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (23,1,5)");
		db.execSQL(sqlInsertCardEnc + " (23,67)");
		db.execSQL(sqlInsertEnc + " (67,2,'You hear Nurse Heather use your name in a discussion with an orderly. They must know you''re here! Make a <b>Sneak (-1) check</b> to eavesdrop. If you pass, gain 1 Clue token. If you fail, you''re thrown out. Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (23,68)");
		db.execSQL(sqlInsertEnc + " (68,3,'\"Please,\" says the man outside the bank. \"We lost everything. Please help.\" For every $1 you give him, gain 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (23,69)");
		db.execSQL(sqlInsertEnc + " (69,10,'The gazebo seems to swell with menace and you dare not approach. Pass a <b>Will (-2) check</b> or move to the street.')");
		db.execSQL(sqlInsertCard + " (24,1,3)");
		db.execSQL(sqlInsertCardEnc + " (24,70)");
		db.execSQL(sqlInsertEnc + " (70,2,'You feel a moment''s guilt at wandering into a restricted area, but something''s just not right in this place.  Unfortunately, before you can get far, Nurse Heather steps up behind you and injects something into your arm.  \"Come with me. You shouldn''t be back here.\"  Your head swimming, you easily agree with her.  The next thing you know, you''re standing outside the gates with no memory of what happened.  Move to the street and gain 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (24,71)");
		db.execSQL(sqlInsertEnc + " (71,3,'The line stretches on forever. However, you hear two people in front of you whispering something important. Gain 1 Clue token, but stay here next turn.')");
		db.execSQL(sqlInsertCardEnc + " (24,72)");
		db.execSQL(sqlInsertEnc + " (72,10,'As you brush up against Founder''s Rock, a strange lethargy seizes your limbs. Lose 1 Stamina.')");
		db.execSQL(sqlInsertCard + " (25,1,5)");
		db.execSQL(sqlInsertCardEnc + " (25,73)");
		db.execSQL(sqlInsertEnc + " (73,2,'\"Everything''s going to be fine,\" says a kindly patient in the lounge, seeming quite lucid.  He pats your hand, gets up, and walks off.  The strange thing is, you find yourself quite convinced.  Gain 3 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (25,74)");
		db.execSQL(sqlInsertEnc + " (74,3,'As you step in front of the teller line, you see that there are two windows open. \"Next!\" both call out at the same time. Make a <b>Luck (-1) check</b>. If you succeed, your are <i>Blessed</i>. If you fail, you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (25,75)");
		db.execSQL(sqlInsertEnc + " (75,10,'A dark shadow fall across Founder''s Rock, and then dissolves as the sun passes behind a bank of clouds. A monster appears!')");
		db.execSQL(sqlInsertCard + " (26,1,5)");
		db.execSQL(sqlInsertCardEnc + " (26,76)");
		db.execSQL(sqlInsertEnc + " (76,2,'\"It''s a new treatment,\" says the doctor, as orderlies you didn''t notice before grab your arms from behind.  \"It''s very promising.\"  Roll a die.  On a success, restore both your Sanity and Stamina to their maximum values.  On a failure, reduce them to 1.')");
		db.execSQL(sqlInsertCardEnc + " (26,77)");
		db.execSQL(sqlInsertEnc + " (77,3,'The bank Vice President tucks something into your pocket as he passes by. \"A bit of help for you and your friends,\" he whispers in your ear. All investigators gain $1.')");
		db.execSQL(sqlInsertCardEnc + " (26,78)");
		db.execSQL(sqlInsertEnc + " (78,10,'A group of boys play baseball on the public diamond, shouting and laughing. You stop to watch for a while, and find yourself both refreshed and heartened. Gain 1 Stamina and 1 Sanity.')");
		db.execSQL(sqlInsertCard + " (27,1,5)");
		db.execSQL(sqlInsertCardEnc + " (27,79)");
		db.execSQL(sqlInsertEnc + " (79,2,'An irate orderly shoves a babbling madman at you, shouting \"You deal with him!\" before storming off. Pass a <b>Will (-2) check</b> to calm him down enough to decipher his ravings and gain 2 Clue tokens.')");
		db.execSQL(sqlInsertCardEnc + " (27,80)");
		db.execSQL(sqlInsertEnc + " (80,3,'An old woman has just absentmindedly left the envelope the teller gave her behind. Will you return it to her? You may either gain $5 or become <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (27,81)");
		db.execSQL(sqlInsertEnc + " (81,10,'A gate and a monster appear!')");
		db.execSQL(sqlInsertCard + " (28,1,1)");
		db.execSQL(sqlInsertCardEnc + " (28,82)");
		db.execSQL(sqlInsertEnc + " (82,2,'You hear screaming.  When you open a heavy cell door to investigate, a dark shape leaps out at you!  It''s an insane man in a straightjacket babbling about invisible horrors.  Make a <b>Lore (-2) check</b> to glean some useful information from him.  If you pass, gain 2 Clue tokens.  If you fail, lose 1 Stamina as he attacks you.')");
		db.execSQL(sqlInsertCardEnc + " (28,83)");
		db.execSQL(sqlInsertEnc + " (83,3,'A little old lady stands in front of you in line counting out a bag of pennies to deposit. Lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (28,84)");
		db.execSQL(sqlInsertEnc + " (84,10,'There are gypsies camped in the park. Make a <b>Luck (-1) check</b> if you wish to interact with them. If you pass, an old man has spread several items on a blanket for sale. Draw 1 Unique Item and you may buy it for $1 less than the list price. If you fail, a hag comes up to you and tells you that death shadows you. You scoff at her and she cuts the side of your face with her fingernail, drawing blood. Lose 1 Stamina and you are <i>Cursed</i>.')");
		db.execSQL(sqlInsertCard + " (29,1,1)");
		db.execSQL(sqlInsertCardEnc + " (29,85)");
		db.execSQL(sqlInsertEnc + " (85,2,'Nurse Heather accidentally injects you with a sleeping draught. You may make a <b>Fight (-2) check</b> to resist.  If you fail or choose not to resist, lose your next turn and gain 2 Sanity from the prolonged rest.  If you pass, nothing happens.')");
		db.execSQL(sqlInsertCardEnc + " (29,86)");
		db.execSQL(sqlInsertEnc + " (86,3,'A teller you''ve never seen before insists she just saw you come in and make a deposit the day before. She proves it by showing you your signature. Gain $5, but lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (29,87)");
		db.execSQL(sqlInsertEnc + " (87,10,'You touch Founder''s Rock. Make a <b>Luck (-1) check</b>. If you pass, there is an electrifying shock that opens your mind to the elder things of eons past. Lose 1 Stamina, but gain 2 Clue tokens and draw 1 Spell. If you fail, you find a strange carving. As you finger the grooves, a gate opens here and you are drawn through it.')");
		db.execSQL(sqlInsertCard + " (30,1,5)");
		db.execSQL(sqlInsertCardEnc + " (30,88)");
		db.execSQL(sqlInsertEnc + " (88,2,'You sneak into a finger-painting session. Gain 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (30,89)");
		db.execSQL(sqlInsertEnc + " (89,3,'The money you''ve just withdrawn is not from any country you know. Gain $3, but pass a <b>Will (-1) check</b> or lose 1 Sanity.')");
		db.execSQL(sqlInsertCardEnc + " (30,90)");
		db.execSQL(sqlInsertEnc + " (90,10,'Make a <b>Will (-1) check</b>. If you pass it, <b>Anna Kaslow</b> the fortune teller offers her help in your investigation. Take her Ally card if it is still available. Otherwise, gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (31,1,1)");
		db.execSQL(sqlInsertCardEnc + " (31,91)");
		db.execSQL(sqlInsertEnc + " (91,2,'You are mistaken for an inmate.  Doctor Mintz has the guards subdue you and conducts an experiment.  Make a <b>Will (-1) [2] check</b> to discover the results.  If you pass, the injections seem to increase your capacity for learning.  Draw 1 Skill.  If you fail, his memory drug fails miserably, resulting in lost knowledge.  You must discard one of the following (your choice), if able: 4 Clue tokens, or 2 Spells, or 1 Skill.')");
		db.execSQL(sqlInsertCardEnc + " (31,92)");
		db.execSQL(sqlInsertEnc + " (92,3,'You see a richly dressed man making a large withdrawal. On the way out, he lights his cigar with a piece of green paper which he then drops on the ground. Pass a <b>Speed (-1) check</b> to stub it out with your toe before it burns up. You discover it to be a slightly singed two dollar bill. Gain $2.')");
		db.execSQL(sqlInsertCardEnc + " (31,93)");
		db.execSQL(sqlInsertEnc + " (93,10,'Pass a <b>Fight (-1) check</b> to intimidate a policeman or he rousts you from the park. Move to the street.')");
		db.execSQL(sqlInsertCard + " (32,1,1)");
		db.execSQL(sqlInsertCardEnc + " (32,94)");
		db.execSQL(sqlInsertEnc + " (94,2,'Nurse Heather is coming!  Make a <b>Speed (-1) check</b> to hide in time.  If you pass you see her drop something as she walks by.  Draw 1 Unique Item.  If you fail, she throws you out.  Move to the street.')");
		db.execSQL(sqlInsertCardEnc + " (32,95)");
		db.execSQL(sqlInsertEnc + " (95,3,'A man wearing dirty and tattered clothing is loitering outside the bank. He offers to sell you his last possession to get some food money for him and his family. If you accept, pay $2 and make a <b>Luck (-1) check</b>. If you pass, draw 1 Unique Item. If you fail, draw 1 Common Item.')");
		db.execSQL(sqlInsertCardEnc + " (32,96)");
		db.execSQL(sqlInsertEnc + " (96,10,'Make a <b>Will (-1) check</b>. If you pass it, <b>Anna Kaslow</b> the fortune teller, offers her help in your investigation. Take her Ally card if it is still available. If it is not, gain 2 Clue tokens. If you fail, nothing happens.')");
		db.execSQL(sqlInsertCard + " (33,1,8)");
		db.execSQL(sqlInsertCardEnc + " (33,97)");
		db.execSQL(sqlInsertEnc + " (97,2,'A seemingly-sane inmate is willing to pay you to help him escape. If you agree to help, you may make a <b>Sneak (-1) check</b>. If you succeed, gain $3. If you fail, you are <i>arrested</i>.')");
		db.execSQL(sqlInsertCardEnc + " (33,98)");
		db.execSQL(sqlInsertEnc + " (98,3,'A young woman is examining the contents of a safe deposit box bequethed to her by her late mother. It is an ancient book written in a language she doesn''t understand, and she asks you if you recognize the language. Make a <b>Lore (-1) [2] check</b>. If you pass, gain 2 Clue tokens as you decipher the text.')");
		db.execSQL(sqlInsertCardEnc + " (33,99)");
		db.execSQL(sqlInsertEnc + " (99,10,'An old gypsy man is being attacked by a mysterious robed figure. Make a <b>Fight (-2) check</b> to help fend off the assailant. If you pass, the gypsy insists you accept a token of his gratitude. Gain 1 Unique Item.')");
		db.execSQL(sqlInsertCard + " (34,1,8)");
		db.execSQL(sqlInsertCardEnc + " (34,100)");
		db.execSQL(sqlInsertEnc + " (100,2,'A patient becomes irrationally possessive over one of your belongings. Make a <b>Fight (-3) check</b>. If you fail choose 1 Common Item or Unique Item and discard it.')");
		db.execSQL(sqlInsertCardEnc + " (34,101)");
		db.execSQL(sqlInsertEnc + " (101,3,'A child is struggling to bring an enormous jar of pennies to the teller. You may make a <b>Fight (-1) check</b> to help him out. If you pass, gain 1 Sanity and $1 for your efforts. If you fail, lose 1 Stamina.')");
		db.execSQL(sqlInsertCardEnc + " (34,102)");
		db.execSQL(sqlInsertEnc + " (102,10,'You start digging in a patch of grond where, as long as you can recall, no grass has ever grown. Make a <b>Luck (-2) check</b>. If you pass, gain 2 Clue tokens as you unearth a pocket watch inscribed with the name of a man who went missing decades ago. If you fail, lose 1 Stamina for exhausting yourself fruitlessly.')");
		db.execSQL(sqlInsertCard + " (-1,1,9)");
		db.execSQL(sqlInsertCardEnc + " (-1,103)");
		db.execSQL(sqlInsertEnc + " (103,2,'All of the Asylum''s patients begin speaking in the same strange tounge at once. Make a <b>Lore (-1) check</b>. If you pass, gain 1 Clue token as you realize that they''re all speaking ancient Sumerian, a language that only a few scholars in the world know!')");
		db.execSQL(sqlInsertCardEnc + " (-1,104)");
		db.execSQL(sqlInsertEnc + " (104,3,'You head up the steps as a bank robber in a mask dashes out, running into you and dropping a sack full of money. If you would like to return the money, gain 1 Sanity. If you want to keep it and run away, gain $10 but lose 1 Sanity and take the Wanted card.')");
		db.execSQL(sqlInsertCardEnc + " (-1,105)");
		db.execSQL(sqlInsertEnc + " (105,10,'You learn that cultists are bribing the mayor with stolen items from the \"Legacy of the Pharaohs\" exhibit, and often drop them off on his doorstep. If you would like to reappropriate them, make a <b>Sneak (-1) check</b>. If you fail, you are <i>arrested</i>. If you roll 1 success, you get away, but empty-handed. If you roll 2 successes, you get away with the packages: Draw 1 Unique Item or Exhibit Item.')");
		db.execSQL(sqlInsertCard + " (35,1,2)");
		db.execSQL(sqlInsertCardEnc + " (35,106)");
		db.execSQL(sqlInsertEnc + " (106,2,'All of the Asylum''s patients begin speaking in the same strange tounge at once. Make a <b>Lore (-1) check</b>. If you pass, gain 1 Clue token as you realize that they''re all speaking ancient Sumerian, a language that only a few scholars in the world know!')");
		db.execSQL(sqlInsertCardEnc + " (35,107)");
		db.execSQL(sqlInsertEnc + " (107,3,'You head up the steps as a bank robber in a mask dashes out, running into you and dropping a sack full of money. If you would like to return the money, gain 1 Sanity. If you want to keep it and run away, gain $10 but lose 1 Sanity and take the Wanted card.')");
		db.execSQL(sqlInsertCardEnc + " (35,108)");
		db.execSQL(sqlInsertEnc + " (108,10,'You learn that cultists are bribing the mayor with stolen items from the \"Legacy of the Pharaohs\" exhibit, and often drop them off on his doorstep. If you would like to reappropriate them, make a <b>Sneak (-1) check</b>. If you fail, you are <i>arrested</i>. If you roll 1 success, you get away, but empty-handed. If you roll 2 successes, you get away with the packages: Draw 1 Unique Item or Exhibit Item.')");
		db.execSQL(sqlInsertCard + " (-2,1,9)");
		db.execSQL(sqlInsertCardEnc + " (-2,109)");
		db.execSQL(sqlInsertEnc + " (109,2,'A doctor working on dream therapy asks if you''d be willing to venture into a patient''s nightmares; he seems to be beset by dreams of animal-headed men, blinding sand, and strange pyramids. If you agree, you gain 3 Clue tokens but immediately move to the Dreamlands.')");
		db.execSQL(sqlInsertCardEnc + " (-2,110)");
		db.execSQL(sqlInsertEnc + " (110,3,'A dirty, bedraggled man in Egyptian robes stops you on your way into the bank, and intones, \"It is easier for a camel to pass through the eye of a needle than it is for a rich man to enter heaven!\" If you discard all of your money, you are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (-2,111)");
		db.execSQL(sqlInsertEnc + " (111,10,'A well-dressed gentleman approaches a group of children and begins to lead one away... and something tells you that he''s up to no good. If you confront him, he transforms. A monster appears! Treat this monster as if it had the <b>Ambush</b> special ability. If you defeat it, draw 1 Exhibit Item, but place a Patrol marker on the street area of Downtown after being seen assaulting a respected citizen.')");
		db.execSQL(sqlInsertCard + " (36,1,2)");
		db.execSQL(sqlInsertCardEnc + " (36,112)");
		db.execSQL(sqlInsertEnc + " (112,2,'A doctor working on dream therapy asks if you''d be willing to venture into a patient''s nightmares; he seems to be beset by dreams of animal-headed men, blinding sand, and strange pyramids. If you agree, you gain 3 Clue tokens but immediately move to the Dreamlands.')");
		db.execSQL(sqlInsertCardEnc + " (36,113)");
		db.execSQL(sqlInsertEnc + " (113,3,'A dirty, bedraggled man in Egyptian robes stops you on your way into the bank, and intones, \"It is easier for a camel to pass through the eye of a needle than it is for a rich man to enter heaven!\" If you discard all of your money, you are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (36,114)");
		db.execSQL(sqlInsertEnc + " (114,10,'A well-dressed gentleman approaches a group of children and begins to lead one away... and something tells you that he''s up to no good. If you confront him, he transforms, and you are <i>surprised</i> by a monster. If you defeat it, draw 1 Exhibit Item, but you are <i>Barred from Downtown</i> for assaulting a respected citizen. If you mind your own business, the child is later found dead.')");
		db.execSQL(sqlInsertCard + " (-3,1,9)");
		db.execSQL(sqlInsertCardEnc + " (-3,115)");
		db.execSQL(sqlInsertEnc + " (115,2,'The screams of the insane seem to permeate the Asylum... and you realize that you are hearing the voices in your mind! You cry out to silence voices only you can hear. Passers-by stare at you suspiciously. Place a Patrol marker on the street area of Downtown Then take the Psychic card, if it is available.')");
		db.execSQL(sqlInsertCardEnc + " (-3,116)");
		db.execSQL(sqlInsertEnc + " (116,3,'You see a customer going into seizures. If you want to try to help, make a <b>Fight (-2) check</b> to restrain him and keep him from hurting himself or a <b>Lore (-2) check</b> to correctly sedate him. If you fail, lose 2 Stamina as he lashes out. If you pass, the convulsions subside and a nun rushes to you side, saying, \"Bless you, good sir, for helping.\" You are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (-3,117)");
		db.execSQL(sqlInsertEnc + " (117,10,'The staff of the visiting museum exhibit puts on an educational show in the park, but it is rather confusing. Make a <b>Lore (-1) check</b>. If you pass, you gain Clue tokens equal to your focus (maximum 3). If you fail, you lose Clue tokens equal to your focus (maximum 3).')");
		db.execSQL(sqlInsertCard + " (37,1,2)");
		db.execSQL(sqlInsertCardEnc + " (37,118)");
		db.execSQL(sqlInsertEnc + " (118,2,'The screams of the insane drive you out of the Asylum... but then you realize that you can still hear them in your mind, praising the coming of the Dark Pharaoh! Take the Psychic card, but you cannot stand to be near the Asylum: You are <i>Barred from Downtown</i>.')");
		db.execSQL(sqlInsertCardEnc + " (37,119)");
		db.execSQL(sqlInsertEnc + " (119,3,'You see a customer going into seizures. If you want to try to help, make a <b>Fight (-2) check</b> to restrain him and keep him from hurting himself or a <b>Lore (-2) check</b> to correctly sedate him. If you fail, lose 2 Stamina as he lashes out. If you pass, the convulsions subside and a nun rushes to you side, saying, \"Bless you, good sir, for helping.\" You are <i>Blessed</i>.')");
		db.execSQL(sqlInsertCardEnc + " (37,120)");
		db.execSQL(sqlInsertEnc + " (120,10,'The staff of the visiting museum exhibit puts on an educational show in the park, but it is rather confusing. Make a <b>Lore (-1) check</b>. If you pass, you gain Clue tokens equal to your focus (maximum 3). If you fail, you lose Clue tokens equal to your focus (maximum 3).')");
		db.execSQL(sqlInsertCard + " (-4,1,9)");
		db.execSQL(sqlInsertCardEnc + " (-4,121)");
		db.execSQL(sqlInsertEnc + " (121,2,'\"This one''s got some wisdom to him,\" one of the orderlies says as he shows you a withered old Egyptian scholar who was recently committed. \"It''s like he seen somethin'', and if you look close in his eyes, you can see it too.\" If you look into the patient''s eyes, make a <b>Will (-2) check</b>. If you pass, you gain 4 Clue tokens. If you fail, you immediately go insane.')");
		db.execSQL(sqlInsertCardEnc + " (-4,122)");
		db.execSQL(sqlInsertEnc + " (122,3,'Father Michael is hesitant to walk back to South Church alone, saying that the \"Legacy of the Pharaohs\" exhibit has cast a pall upon Arkham. If you escort him, move immediately to South Church. Do not have an encounter there, but you may trade in monster and gate trophies to be <i>Blessed</i> as described at that location. If you escort him and have the Motorcycle or Map item or the Mists of Releh spell, you are <i>Blessed</i> for free.')");
		db.execSQL(sqlInsertCardEnc + " (-4,123)");
		db.execSQL(sqlInsertEnc + " (123,10,'From a bench in Independence Square you can watch the comings and goings of the town''s major figures. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCard + " (38,1,2)");
		db.execSQL(sqlInsertCardEnc + " (38,124)");
		db.execSQL(sqlInsertEnc + " (124,2,'\"This one''s got some wisdom to him,\" one of the orderlies says as he shows you a withered old Egyptian scholar who was recently committed. \"It''s like he seen somethin'', and if you look close in his eyes, you can see it too.\" If you look into the patient''s eyes, make a <b>Will (-2) check</b>. If you pass, you gain 4 Clue tokens. If you fail, you immediately go insane.')");
		db.execSQL(sqlInsertCardEnc + " (38,125)");
		db.execSQL(sqlInsertEnc + " (125,3,'Father Michael is hesitant to walk back to South Church alone, saying that the \"Legacy of the Pharaohs\" exhibit has cast a pall upon Arkham. If you escort him, move immediately to South Church. Do not have an encounter there, but you may trade in monster and gate trophies to be <i>Blessed</i> as described at that location. If you escort him and have the Motorcycle or Map item or the Mists of Releh spell, you are <i>Blessed</i> for free.')");
		db.execSQL(sqlInsertCardEnc + " (38,126)");
		db.execSQL(sqlInsertEnc + " (126,10,'From a bench in Independence Square you can watch the comings and goings of the town''s major figures. Gain 1 Clue token.')");
		db.execSQL(sqlInsertCard + " (-5,1,9)");
		db.execSQL(sqlInsertCardEnc + " (-5,127)");
		db.execSQL(sqlInsertEnc + " (127,2,'The inmates begin to chant in unison, screaming about the \"black Kem of Re and Amen, Isis, and Osiris!\" It nearly drives you mad - but that which doesn''t kill you only makes you stronger. If your Will is 1 or lower, you may search the Skill deck and take the Will card.')");
		db.execSQL(sqlInsertCardEnc + " (-5,128)");
		db.execSQL(sqlInsertEnc + " (128,3,'You are retrieving some papers from the safety deposit vault when a portal to another place and time suddenly opens, nearly sucking the guard in! If you push him out of the way, you are <i>Blessed</i>, but must immediately move to the Plateau of Leng.')");
		db.execSQL(sqlInsertCardEnc + " (-5,129)");
		db.execSQL(sqlInsertEnc + " (129,10,'A sheaf of papers with hieroglyphics translations blows past you on the wind. Make a <b>Speed (-1) check</b>. If you fail, a young lady runs past you after them. If you pass, you catch them and are thanked profusely by <b>Sarah Danforth</b>, an archaeology student from Miskatonic. Take her Ally card. If it is not available, gain 1 Clue token instead as she chats with you about the visiting museum exhibit.')");
		db.execSQL(sqlInsertCard + " (39,1,2)");
		db.execSQL(sqlInsertCardEnc + " (39,130)");
		db.execSQL(sqlInsertEnc + " (130,2,'The inmates begin to chant in unison, screaming about the \"black Kem of Re and Amen, Isis, and Osiris!\" It nearly drives you mad - but that which doesn''t kill you only makes you stronger. If your Will is 1 or lower, you may search the Skill deck and take the Will card.')");
		db.execSQL(sqlInsertCardEnc + " (39,131)");
		db.execSQL(sqlInsertEnc + " (131,3,'You are retrieving some papers from the safety deposit vault when a portal to another place and time suddenly opens, nearly sucking the guard in! If you push him out of the way, you are <i>Blessed</i>, but must immediately move to the Plateau of Leng.')");
		db.execSQL(sqlInsertCardEnc + " (39,132)");
		db.execSQL(sqlInsertEnc + " (132,10,'A sheaf of papers with hieroglyphics translations blows past you on the wind. Make a <b>Speed (-1) check</b>. If you fail, a young lady runs past you after them. If you pass, you catch them and are thanked profusely by <b>Sarah Danforth</b>, an archaeology student from Miskatonic. Take her Ally card. If it is not available, gain 1 Clue token instead as she chats with you about the visiting museum exhibit.')");
	}
	
	
	
}
