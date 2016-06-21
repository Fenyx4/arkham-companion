package ah.drawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class GameState 
{
	public final static GameState INSTANCE = new GameState();
	//Sorted arrays for each neighborhood representing the deck of cards
	private HashMap<Long,ArrayList<Card>> encounterCardsList;
	private Random rand;
	
	//The expansions selected for this play session
	private HashMap<Long,Long> currentExpansions;
	
	private GameState()
	{
		currentExpansions = new HashMap<Long,Long>();
		encounterCardsList = new HashMap<Long,ArrayList<Card>>();
		rand = new Random(522348);
	}
	public ArrayList<Card> getDeckByNeighborhood(long neiID)
	{
		if(encounterCardsList.containsKey(neiID))
		{
			return encounterCardsList.get(neiID);
		}
		else
		{
			ArrayList<Card> cards = AHFlyweightFactory.INSTANCE.getCurrentCards(neiID);
			randomize(cards);
			
			encounterCardsList.put(neiID, cards);
			return cards;
		}
	}
	
	public void randomize(long neiID)
	{
		if(encounterCardsList.containsKey(neiID))
		{
			randomize(encounterCardsList.get(neiID));
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
		encounterCardsList = new HashMap<Long,ArrayList<Card>>();
	}
}
