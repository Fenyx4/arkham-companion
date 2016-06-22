package ah.drawer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class GameState 
{
	private final static GameState INSTANCE = new GameState();
	private static boolean loaded = false;
	//Sorted arrays for each neighborhood representing the deck of cards
	private HashMap<Long,ArrayList<NeighborhoodCard>> neighborhoodCardsList;
	private ArrayList<OtherWorldCard> otherWorldCards = null;
	private Random rand;
	private ArrayList<Encounter> encounterHx = null;
	private HashMap<Long,OtherWorldColor> currentColors = null;
	
	private long gameID;
	
	//The expansions selected for this play session
	private HashMap<Long,Long> currentExpansions;
	
	public static GameState getInstance()
	{
		if(!loaded)
		{
			INSTANCE.Load();
			loaded = true;
		}
		
		return INSTANCE;
	}
	
	private void Load()
	{
		Long currGameID = AHFlyweightFactory.INSTANCE.getMostRecentGameID();
		if(currGameID == null)
		{
			gameID = AHFlyweightFactory.INSTANCE.createNewGame();
		}
		else
		{
			gameID = currGameID;
			currentExpansions = AHFlyweightFactory.INSTANCE.getGameExps(gameID);
			encounterHx = AHFlyweightFactory.INSTANCE.getGameEncHx(gameID);
		}
	}
	
	private GameState()
	{
		currentExpansions = new HashMap<Long,Long>();
		neighborhoodCardsList = new HashMap<Long,ArrayList<NeighborhoodCard>>();
		encounterHx = new ArrayList<Encounter>();
		currentColors = new HashMap<Long,OtherWorldColor>();
		rand = new Random(522348);
	}
	
//	public void onSaveInstanceState(Bundle savedInstanceState) 
//	{
//	  // Save UI state changes to the savedInstanceState.
//	  // This bundle will be passed to onCreate if the process is
//	  // killed and restarted.
//		for (Long expID : currentExpansions.keySet())
//		{
//			savedInstanceState.putBoolean("Exp"+expID.toString(), true);	
//		}
//	  //savedInstanceState.putBoolean("MyBoolean", true);
//	  //savedInstanceState.putDouble("myDouble", 1.9);
//	  //savedInstanceState.putInt("MyInt", 1);
//	  //savedInstanceState.putString("MyString", "Welcome back to Android");
//	  // etc.
//	}
	
//	public void onRestoreInstanceState(Bundle savedInstanceState) {
//		if(savedInstanceState != null)
//		{
//	  // Restore UI state from the savedInstanceState.
//	  // This bundle has also been passed to onCreate.
//			for( Expansion exp : AHFlyweightFactory.INSTANCE.getExpansions())
//			{
//				if (savedInstanceState.getBoolean("Exp"+Long.toString(exp.getID())))
//				{
//					applyExpansion(exp.getID(), true);
//				}
//					
//			}
//		}
//	}
	
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
			AHFlyweightFactory.INSTANCE.addGameEx(expID, gameID);
		}
		else if (currentExpansions.containsKey(expID) && !isChecked)
		{
			currentExpansions.remove(expID);
			AHFlyweightFactory.INSTANCE.removeGameEx(expID, gameID);
		}
		
		//Clear the deck lists
		neighborhoodCardsList = new HashMap<Long,ArrayList<NeighborhoodCard>>();
		encounterHx = new ArrayList<Encounter>();
		AHFlyweightFactory.INSTANCE.clearEncounterHx(gameID);
	}
	
	public void AddHistory(Encounter enc) 
	{
		encounterHx.add(0, enc);

		AHFlyweightFactory.INSTANCE.addEncounterHx(enc, gameID);
	}
	
	public ArrayList<Encounter> getEncounterHx()
	{
		return encounterHx;
	}
	
	public ArrayList<OtherWorldCard> getAllOtherWorldDeck() {
		if (otherWorldCards == null)
		{
			prepOtherWorldDeck();
		}
		
		return otherWorldCards;
	}
	
	public void addSelectedOtherWorldColor(OtherWorldColor color)
	{
		if(!currentColors.containsKey(color.getID()))
		{
				currentColors.put(color.getID(), color);
		}
	}
	
	public void removeSelectedOtherWorldColor(OtherWorldColor color)
	{
		if(currentColors.containsKey(color.getID()))
		{
				currentColors.remove(color.getID());
		}
	}
	
	public void clearSelectedOtherWorldColor()
	{
		currentColors.clear();
	}
	
	public boolean isSelectedOtherWorldColor(OtherWorldColor owc)
	{
		if( currentColors == null )
		{
			return false;
		}
		
		return currentColors.containsKey(owc.getID());
	}
	
	public ArrayList<OtherWorldCard> getFilteredOtherWorldDeck() {
		Collection<OtherWorldColor> colorIDs = currentColors.values();
		if( colorIDs == null || colorIDs.size() == 0 )
		{
			return getAllOtherWorldDeck();
		}
		else
		{
			ArrayList<OtherWorldCard> cards = getAllOtherWorldDeck();
			ArrayList<OtherWorldCard> filteredCards = new ArrayList<OtherWorldCard>();

			for(int i = 0; i < cards.size(); i++)
			{
				if(colorIDs.containsAll(cards.get(i).getOtherWorldColors()))
				{
					filteredCards.add(cards.get(i));
				}
			}
			
			//Grab stars are right
			filteredCards.add(cards.get(cards.size()-1));
			
			return filteredCards;
		}
			
	}
	
	
	public boolean otherWorldCardSelected(long cardId) {
		
		while( otherWorldCards.size() != 0 && otherWorldCards.get(0).getID() != cardId)
		{
			otherWorldCards.remove(0);
		}
		otherWorldCards.remove(0);
		if(otherWorldCards.size() == 0)
		{
			prepOtherWorldDeck();
			return true;
		}
		return false;
	}
	
	private void prepOtherWorldDeck()
	{
		otherWorldCards = AHFlyweightFactory.INSTANCE.getCurrentOtherWorldCards();
		randomize(otherWorldCards);
		//Where should stars are right go?
		
		int numberOfCardsAfterStars = rand.nextInt(otherWorldCards.size());
		for(int i = 0; i < numberOfCardsAfterStars; i++)
		{
			otherWorldCards.remove(otherWorldCards.size()-1);
		}
		
		otherWorldCards.add(AHFlyweightFactory.INSTANCE.getStarsAreRight());
	}
}
