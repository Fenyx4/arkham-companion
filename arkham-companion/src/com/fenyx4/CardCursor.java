package ah.drawer;

import java.util.ArrayList;

import android.database.AbstractCursor;

public class CardCursor extends AbstractCursor {
	
	private ArrayList<ICard> cards;
	
	public CardCursor(ArrayList<ICard> cards)
	{
		this.cards = cards;
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "_ID"};
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
	public double getDouble(int arg0) {
		if(arg0 == 0)
			return mPos;
		return 0;
	}

	@Override
	public float getFloat(int arg0) {
		if(arg0 == 0)
			return mPos;
		return 0;
	}

	@Override
	public int getInt(int arg0) {
		if(arg0 == 0)
		{
			return mPos;
		}
		return 0;
	}

	@Override
	public long getLong(int arg0) {
		if(arg0 == 0)
			return mPos;
		return 0;
	}

	@Override
	public short getShort(int arg0) {
		if(arg0 == 0)
			return (short)mPos;
		return 0;
	}
	
	public ICard getCard()
	{
		return cards.get(mPos);
	}

	@Override
	public String getString(int arg0) {
		if( arg0 == 1)
		{
			
			return cards.get(mPos).toString();
		}
		else
		{
			return String.valueOf(mPos);
		}
		
	}

	@Override
	public boolean isNull(int arg0) {
		
		return cards.get(arg0) == null;
	}

}
