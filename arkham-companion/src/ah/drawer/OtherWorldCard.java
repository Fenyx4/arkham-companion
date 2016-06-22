package ah.drawer;

public class OtherWorldCard extends ACard {

	private long colorID;
	
	public OtherWorldCard(long ID, long colorID) {
		super(ID);
		this.colorID = colorID;
	}
	
    @Override public String toString()
    {
    	return "CardID: " + getID() + " ColorID: " + colorID;
    }

	public OtherWorldColor getOtherWorldColor() {
		return AHFlyweightFactory.INSTANCE.getOtherWorldColor(colorID);	
	}
	
	public String getCardPath()
	{
		return getOtherWorldColor().getCardPath();
	}

}
