package ah.drawer;

import java.util.ArrayList;

public class OtherWorldCard extends ACard {

	private ArrayList<OtherWorldColor> colors;
	
	public OtherWorldCard(long ID) {
		super(ID);
	}
	
    @Override public String toString()
    {
    	return "CardID: " + getID();
    }

	public ArrayList<OtherWorldColor> getOtherWorldColors() {
		if(colors == null)
		{
			colors = AHFlyweightFactory.INSTANCE.getOtherWorldColorsForCard(getID());	
		}
		return colors;
	}
	
	public String getCardPath()
	{
		return AHFlyweightFactory.INSTANCE.getOtherWorldCardPathForColoredCard(getID());
	}

}
