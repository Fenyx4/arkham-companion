package ah.drawer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper 
{

	static final String dbName="ahDB";
	
	//Neighborhoods
	static final String neighborhoodTable="Neighborhood";
	static final String neiID="NeighborhoodID";
	static final String neiName="Name";
	static final String neiExpID="ExpansionID";
	static final String neiCardPath="CardPath";
	static final String neiButtonPath="ButtonPath"; 

	//Locations
	static final String locTable="Location";
	static final String locID="locID";
	static final String locExpID="locExpID"; // Only needed for OW
	static final String locName="locName";
	static final String locNeiID = "neiID"; // Null if OW
	static final String locSort = "sort";
	static final String locButtonPath = "locButtonPath";
	
	//Expansions
	static final String expTable="Expansion";
	static final String expID="expID";
	static final String expName="expName";
	static final String expIconPath="expIconPath";
	
	//Encounters
	static final String encounterTable="Encounter";
	static final String encID = "encID";
	static final String encLocID = "locID";
	static final String encText = "encText";
	
	//Cards
	static final String cardTable="Card";
	static final String cardID = "cardID";
	static final String cardNeiID = "neiID";
	//static final String cardColorID = "colorID";
	
	//CardToColors
	static final String cardToColorTable="CardToColor";
	static final String cardToColorColorID="cardToColorColorID";
	static final String cardToColorCardID="cardToColorCardID";
	
	//CardsToExpansion
	static final String cardToExpTable = "CardToExpansion";
	static final String cardToExpCardID = "cardID";
	static final String cardToExpExpID = "expID";
	
	//CardsToEncounter
	static final String cardToEncTable = "CardToEncounter";
	static final String cardToEncCardID = "cardID";
	static final String cardToEncEncID = "encID";
	  
	//LocToColors
	static final String locToColorTable = "LocationToColor";
	static final String locToColorColorID = "colorID";
	static final String locToColorLocID = "locID";  
	
	//Colors
	static final String colorTable = "Color";
	static final String colorID = "colorID";
	static final String colorName = "colorName";
	static final String colorExpID = "colorExpID";
	static final String colorButtonPath = "colorButtonPath";
	
	//CardPath
	static final String pathTable = "Path";
	static final String pathID = "pathID";
	static final String path = "path";
	
	//ColorsToCardPath
	static final String colorToPathTable = "colorToPath";
	static final String colorToPathColorID = "colorID";
	static final String colorToPathPathID = "pathID";
	
	//GameState
	//Game
	static final String gameTable = "gameTable";
	static final String gameID = "gameID";
	static final String gameDate = "gameDate";
	
	//GameToExp
	static final String gameToExpTable = "gameToExpTable";
	static final String gameToExpGameID = "gameToExpGameID";
	static final String gameToExpExpID = "gameToExpExpID";
	
	//EncounterHx
	static final String encounterHxTable = "encounterHxTable";
	static final String encHxGameID = "encHxGameID";
	static final String encHxEncID = "encHxEncID";
	static final String encHxInverseOrder = "encHxOrder";
	
	
	

	static final String viewEmps="ViewEmps";
	
	public static DatabaseHelper instance;
	
	private DatabaseHelper(Context context) {
		  super(context, dbName, null,124); 
		  }
	
	static public DatabaseHelper getInstance(Context context)
	{
		if(instance == null)
		{
			instance = new DatabaseHelper(context);
		}
		
		return instance;
	}
	
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		 
		  db.execSQL("CREATE TABLE "+expTable+" ("+expID+ " INTEGER PRIMARY KEY, "+
				  expIconPath + " TEXT, "+
				  expName + " TEXT)");
		  
		  db.execSQL("CREATE TABLE "+neighborhoodTable+" ("+neiID+" INTEGER PRIMARY KEY, "+
				    		neiName+" TEXT, "+
				    		neiExpID+" INTEGER NOT NULL, " + 
				    		neiCardPath + " TEXT, "+
				    		neiButtonPath + " TEXT, "+ 
				    		"FOREIGN KEY ("+neiExpID+") REFERENCES "+expTable+" ("+expID+"));");
		  
		  db.execSQL("CREATE TABLE "+locTable+" ("+locID+ " INTEGER PRIMARY KEY, "+
				  locName + " TEXT, "+
				  locNeiID+" INTEGER NULL, "+
				  locExpID+" INTEGER NULL, "+
				  locButtonPath + " TEXT NULL, "+ 
				  locSort+" INTEGER NOT NULL, "+
				  "FOREIGN KEY ("+locExpID+") REFERENCES "+expTable+" ("+expID+"), " +
				  "FOREIGN KEY ("+locNeiID+") REFERENCES "+neighborhoodTable+" ("+neiID+"));");
		  
		  db.execSQL("CREATE TABLE "+encounterTable+" ("+encID+" INTEGER PRIMARY KEY, "+
		    		encText+" TEXT, "+encLocID+" INTEGER NOT NULL ,FOREIGN KEY ("+encLocID+") REFERENCES "+locTable+" ("+locID+"));");
		  
		  db.execSQL("CREATE TABLE "+cardTable+" ("+cardID+" INTEGER PRIMARY KEY, "+
				  //cardEncID+" INTEGER NOT NULL ,"+
				  cardNeiID+" INTEGER NULL ,"+
				  //cardColorID+" INTEGER NULL ,"+
				  //"FOREIGN KEY ("+cardColorID+") REFERENCES "+colorTable+" ("+colorID+"), "+
				  "FOREIGN KEY ("+cardNeiID+") REFERENCES "+neighborhoodTable+" ("+neiID+"));");//+
				  //"FOREIGN KEY ("+cardEncID+") REFERENCES "+encounterTable+" ("+encID+"));");
		  
		  db.execSQL("CREATE TABLE "+cardToColorTable+" ("+
				  //cardEncID+" INTEGER NOT NULL ,"+
				  cardToColorCardID+" INTEGER NOT NULL, "+
				  cardToColorColorID+" INTEGER NOT NULL, "+
				  "FOREIGN KEY ("+cardToColorCardID+") REFERENCES "+cardTable+" ("+cardID+"), "+
				  "FOREIGN KEY ("+cardToColorColorID+") REFERENCES "+colorTable+" ("+colorID+"));");//+
				  //"FOREIGN KEY ("+cardEncID+") REFERENCES "+encounterTable+" ("+encID+"));");
		  
		  db.execSQL("CREATE TABLE "+cardToExpTable+" ("+
				  //cardEncID+" INTEGER NOT NULL ,"+
				  cardToExpCardID+" INTEGER NOT NULL, "+
				  cardToExpExpID+" INTEGER NOT NULL, "+
				  "FOREIGN KEY ("+cardToExpCardID+") REFERENCES "+cardTable+" ("+cardID+"), "+
				  "FOREIGN KEY ("+cardToExpExpID+") REFERENCES "+expTable+" ("+expID+"));");//+
				  //"FOREIGN KEY ("+cardEncID+") REFERENCES "+encounterTable+" ("+encID+"));");
		  
		  db.execSQL("CREATE TABLE "+cardToEncTable+" ("+cardToEncCardID+" INTEGER NOT NULL , "+
				  //cardEncID+" INTEGER NOT NULL ,"+
				  cardToEncEncID+" INTEGER NOT NULL ,"+
				  "PRIMARY KEY ("+cardToEncCardID+","+cardToEncEncID+"), "+
				  "FOREIGN KEY ("+cardToEncCardID+") REFERENCES "+cardTable+" ("+cardID+"), "+
				  "FOREIGN KEY ("+cardToEncEncID+") REFERENCES "+encounterTable+" ("+encID+"));");//+
		  
		  db.execSQL("CREATE TABLE "+colorTable+" ("+colorID+" INTEGER PRIMARY KEY, "+
		    		colorName+" TEXT, "+
		    		colorExpID+" INTEGER NOT NULL, " +
		    		colorButtonPath + " TEXT, "+ 
		    		"FOREIGN KEY ("+colorExpID+") REFERENCES "+expTable+" ("+expID+"));");
		  
		  db.execSQL("CREATE TABLE "+locToColorTable+" ("+
				  locToColorColorID+" INTEGER NOT NULL , "+
				  locToColorLocID+" INTEGER NOT NULL ,"+
				  "PRIMARY KEY ("+locToColorColorID+","+locToColorLocID+"), "+
				  "FOREIGN KEY ("+locToColorColorID+") REFERENCES "+colorTable+" ("+colorID+"), "+
				  "FOREIGN KEY ("+locToColorLocID+") REFERENCES "+locTable+" ("+locID+"));");//+
		  
		  db.execSQL("CREATE TABLE "+pathTable+" ("+pathID+ " INTEGER PRIMARY KEY, "+
				  path + " TEXT)");
		  
		  db.execSQL("CREATE TABLE "+colorToPathTable+" ("+
				  //cardEncID+" INTEGER NOT NULL ,"+
				  colorToPathColorID+" INTEGER NOT NULL, "+
				  colorToPathPathID+" INTEGER NOT NULL, "+
				  "FOREIGN KEY ("+colorToPathColorID+") REFERENCES "+colorTable+" ("+colorID+"), "+
				  "FOREIGN KEY ("+colorToPathPathID+") REFERENCES "+pathTable+" ("+pathID+"));");//+
		  
		  // --- Game State
		  db.execSQL("CREATE TABLE "+gameTable+" ("+gameID+ " INTEGER PRIMARY KEY, "+
				  gameDate + " TEXT)");

		  db.execSQL("CREATE TABLE "+gameToExpTable+" ("+
				  gameToExpGameID+" INTEGER NOT NULL, "+
				  gameToExpExpID+" INTEGER NOT NULL, "+
				  "FOREIGN KEY ("+gameToExpGameID+") REFERENCES "+gameTable+" ("+gameID+"), "+
				  "FOREIGN KEY ("+gameToExpExpID+") REFERENCES "+expTable+" ("+expID+"));");//+

		  db.execSQL("CREATE TABLE "+encounterHxTable+" ("+
				  encHxGameID+" INTEGER NOT NULL, "+
				  encHxEncID+" INTEGER NOT NULL, "+
				  encHxInverseOrder+" INTEGER NOT NULL, "+
				  "FOREIGN KEY ("+encHxGameID+") REFERENCES "+gameTable+" ("+gameID+"), "+
				  "FOREIGN KEY ("+encHxEncID+") REFERENCES "+encounterTable+" ("+encID+"));");//+
		  
//		  //For referential integrity
//		  db.execSQL("CREATE TRIGGER fk_neiexp_expid " +
//				    " BEFORE INSERT "+
//				    " ON "+neighborhoodTable+
//				    
//				    " FOR EACH ROW BEGIN"+
//				    " SELECT CASE WHEN ((SELECT "+expID+" FROM "+expTable+
//				    " WHERE "+expID+"=new."+neiExpID+" ) IS NULL)"+
//				    " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
//				    "  END;");
//		  
//		  //For referential integrity
//		  db.execSQL("CREATE TRIGGER fk_locnei_neiid " +
//				    " BEFORE INSERT "+
//				    " ON "+locTable+
//				    
//				    " FOR EACH ROW BEGIN"+
//				    " SELECT CASE WHEN ((SELECT "+neiID+" FROM "+neighborhoodTable+
//				    " WHERE "+neiID+"=new."+locNeiID+" ) IS NULL)"+
//				    " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
//				    "  END;");
//		  
//		  //For referential integrity
//		  db.execSQL("CREATE TRIGGER fk_encloc_locid " +
//				    " BEFORE INSERT "+
//				    " ON "+encounterTable+
//				    " FOR EACH ROW BEGIN"+
//				    " SELECT CASE WHEN ((SELECT "+locID+" FROM "+locTable+
//				    " WHERE "+locID+"=new."+encLocID+" ) IS NULL)"+
//				    " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
//				    "  END;");
//		  
//		//For referential integrity
//		  db.execSQL("CREATE TRIGGER fk_cardtoencenc_encid " +
//				    " BEFORE INSERT "+
//				    " ON "+cardToEncTable+
//				    " FOR EACH ROW BEGIN"+
//				    " SELECT CASE WHEN ((SELECT "+encID+" FROM "+encounterTable+
//				    " WHERE "+encID+"=new."+cardToEncEncID+" ) IS NULL)"+
//				    " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
//				    "  END;");
//		  
//		  db.execSQL("CREATE TRIGGER fk_cardtoencenc_cardid " +
//				    " BEFORE INSERT "+
//				    " ON "+cardToEncTable+
//				    " FOR EACH ROW BEGIN"+
//				    " SELECT CASE WHEN ((SELECT "+cardID+" FROM "+cardTable+
//				    " WHERE "+cardID+"=new."+cardToEncCardID+" ) IS NULL)"+
//				    " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
//				    "  END;");

		  Init.FetchExpansion(db);
		  Init.FetchNeighborhoods(db);
		  Init.FetchLocations(db);
		  Init.FetchColors(db);
		  Init.FetchEncounters(db);
		  
		  Init.FetchOtherWorldLocations(db);
		  Init.FetchOtherWorldEncounter(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

		  db.execSQL("DROP TABLE IF EXISTS "+encounterTable);
		  db.execSQL("DROP TABLE IF EXISTS "+expTable);
		  db.execSQL("DROP TABLE IF EXISTS "+locTable);
		  db.execSQL("DROP TABLE IF EXISTS "+neighborhoodTable);
		  db.execSQL("DROP TABLE IF EXISTS "+cardTable);
		  db.execSQL("DROP TABLE IF EXISTS "+cardToExpTable);
		  db.execSQL("DROP TABLE IF EXISTS "+cardToEncTable);
		  db.execSQL("DROP TABLE IF EXISTS "+colorTable);
		  db.execSQL("DROP TABLE IF EXISTS "+locToColorTable);
		  db.execSQL("DROP TABLE IF EXISTS "+cardToColorTable);
		  db.execSQL("DROP TABLE IF EXISTS "+pathTable);
		  db.execSQL("DROP TABLE IF EXISTS "+colorToPathTable);
		  db.execSQL("DROP TABLE IF EXISTS "+gameTable);
		  db.execSQL("DROP TABLE IF EXISTS "+gameToExpTable);
		  db.execSQL("DROP TABLE IF EXISTS "+encounterHxTable);
		  
		  
		  db.execSQL("DROP TRIGGER IF EXISTS fk_neiexp_expid");
		  db.execSQL("DROP TRIGGER IF EXISTS fk_locnei_neiid");
		  db.execSQL("DROP TRIGGER IF EXISTS fk_encloc_locid");
		  db.execSQL("DROP TRIGGER IF EXISTS fk_cardtoencenc_encid");
		  db.execSQL("DROP TRIGGER IF EXISTS fk_cardtoencenc_cardid");

		  db.execSQL("DROP VIEW IF EXISTS "+viewEmps);
		  onCreate(db);
	}
}
