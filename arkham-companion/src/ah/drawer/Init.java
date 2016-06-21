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
	static public void FetchBase(SQLiteDatabase db)
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
		
		insertCards(db, cardCV);
	}
	
	private static void insertCards(SQLiteDatabase db, ContentValues cardCV) 
	{
		ContentValues encCV = new ContentValues();
		ContentValues cardToEncCV = new ContentValues();
		
		cardCV.put(DatabaseHelper.cardNeiID, getNeighborhoodID(db, "Downtown"));
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
			putEncounter(db, cv, locName, locID, "A reporter will pay you handsomely, whether in money or information, for an exposé on the life of a monster hunter. Discard any number of monster trophies to gain $1 or 2 Clue tokens (in any combination) (errata: should be $2 or 1 Clue token) for each point of toughness worth of monsters discarded. ");
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
			putEncounter(db, cv, locName, locID, "You're invited to a midnight séance. If you attend, you may commune with the spirit realm: Look at the top two cards of the Mythos deck and replace them, facedown, in any order you like. However Ma Mathison breaks up the séance and says that \"yew devil worshippers better not come round no more!\" You are Barred from Southside. ");
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
		ContentValues cv=new ContentValues();
		cv.put(DatabaseHelper.expName, "Base");
		db.insert(DatabaseHelper.expTable, DatabaseHelper.expID, cv);
		
		cv.put(DatabaseHelper.expName, "Curse of the Dark Pharoah");
		db.insert(DatabaseHelper.expTable, DatabaseHelper.expID, cv);
		
	}
	
	
}
