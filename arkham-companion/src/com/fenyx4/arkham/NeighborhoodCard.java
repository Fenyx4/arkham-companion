package ah.drawer;

public class NeighborhoodCard extends ACard {
	
	private long neiID;
	
	public NeighborhoodCard(long ID, long neiID) {
		super(ID);
		this.neiID = neiID;
	}
	
    @Override public String toString()
    {
    	return "CardID: " + getID() + " NeiID: " + neiID;
    }

	public Neighborhood getNeighborhood() {
		return AHFlyweightFactory.INSTANCE.getNeighborhood(neiID);
		
	}
	
	public String getCardPath()
	{
		return getNeighborhood().getCardPath();
	}
}
