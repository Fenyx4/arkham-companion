package ah.drawer;

public class OtherWorldColor {

	private long colorID;
	private String colorName;
	private String cardPath;
	private long expID;
	
	//DatabaseHelper.colorID,DatabaseHelper.colorName, DatabaseHelper.colorCardPath, DatabaseHelper.colorExpID};
	public OtherWorldColor(long colorID, String colorName, String cardPath, long expID) {
		this.colorID = colorID;
		this.colorName = colorName;
		this.cardPath = cardPath;
		this.expID = expID;
	}

	public long getID() {
		return colorID;
	}

	public String getName() {
		return colorName;
	}

	public String getCardPath() {
		return cardPath;
	}

	public long getExpID() {
		return expID;
	}
}
