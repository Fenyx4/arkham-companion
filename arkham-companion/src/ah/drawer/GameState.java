package ah.drawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class GameState 
{
	public final static GameState INSTANCE = new GameState();
	//Sorted arrays for each neighborhood representing the deck of cards
	private HashMap<Long,ArrayList<NeighborhoodCard>> neighborhoodCardsList;
	private Random rand;
	private ArrayList<Encounter> encounterHx = null;
	private ArrayList<ICard> cardHx = null;
	
	//The expansions selected for this play session
	private HashMap<Long,Long> currentExpansions;
	
	private GameState()
	{
		currentExpansions = new HashMap<Long,Long>();
		neighborhoodCardsList = new HashMap<Long,ArrayList<NeighborhoodCard>>();
		encounterHx = new ArrayList<Encounter>();
		cardHx = new ArrayList<ICard>();
		rand = new Random(522348);
	}
	public ArrayList<NeighborhoodCard> getDeckByNeighborhood(long neiID)
	{
		if(neighborhoodCardsList.containsKey(neiID))
		{
			return neighborhoodCardsList.get(neiID);
		}
		else
		{
			ArrayList<NeighborhoodCard> cards = AHFlyweightFactory.INSTANCE.getCurrentNeighborhoodsCards(neiID);
			randomize(cards);
			
			neighborhoodCardsList.put(neiID, cards);
			return cards;
		}
	}
	
	public void randomizeNeighborhood(long neiID)
	{
		if(neighborhoodCardsList.containsKey(neiID))
		{
			randomize(neighborhoodCardsList.get(neiID));
		}
	}
	
	private <T> void randomize(ArrayList<T> cards) {
		
		int randIdx;
		T swap;
		// i is the index the random card is insert
		for(int i = 0; i < cards.size()-1; i++)
		{
			//randIdx is the card to be inserted into i
			randIdx = rand.nextInt(cards.size()-i)+i;
			swap = cards.remove(randIdx);
			cards.add(i, swap);
		}
	}

	public Set<Long> getAppliedExpansions()
	{
		return currentExpansions.keySet();
	}
	
	public void applyExpansion(long expID, boolean isChecked) 
	{
		if(!currentExpansions.containsKey(expID) && isChecked)
		{
			currentExpansions.put(expID,expID);
		}
		else if (currentExpansions.containsKey(expID) && !isChecked)
		{
			currentExpansions.remove(expID);
		}
		
		//Clear the deck lists
		neighborhoodCardsList = new HashMap<Long,ArrayList<NeighborhoodCard>>();
		encounterHx = new ArrayList<Encounter>();
		cardHx = new ArrayList<ICard>();
	}
	
	public void AddHistory(ICard card, Encounter enc) 
	{
		cardHx.add(0,card);
		encounterHx.add(0, enc);
	}
	
	public ArrayList<Encounter> getEncounterHx()
	{
		return encounterHx;
	}
	
	public ArrayList<ICard> getCardHx()
	{
		return cardHx;
	}
}
