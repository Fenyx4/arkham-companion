package ah.drawer.GUI;

import java.io.IOException;
import java.util.ArrayList;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Encounter;
import ah.drawer.GameState;
import ah.drawer.ICard;
import ah.drawer.OtherWorldCard;
import ah.drawer.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import android.support.v4.view.*;

public class OtherWorldDeckActivity extends Activity {
	//private Encounter encounter;
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationdeck);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
       // Bundle extras = getIntent().getExtras();

        //long[] colorIDs = extras.getLongArray("otherworld"); //.getLong("otherworld");
        
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new CardAdapter(this, GameState.INSTANCE.getFilteredOtherWorldDeck()));

        //viewpager.setBackgroundColor(Color.CYAN);
        
    }
    
    @Override
    public void onBackPressed() {
    	Toast.makeText(OtherWorldDeckActivity.this, R.string.location_deck_back, Toast.LENGTH_SHORT).show();
    	super.onBackPressed();
    }


    public class CardAdapter extends PagerAdapter {
	    //int mGalleryItemBackground;
	    private Context mContext;

	    private ArrayList<OtherWorldCard> cardArr;
	    
	    private LayoutInflater mInflater;

	    public CardAdapter(Context c, ArrayList<OtherWorldCard> cardArr) 
	    {
	        mContext = c;
	        this.cardArr = cardArr;
	        
	        Log.w("AHDecks", cardArr.size() + " cards in deck.");
	        
	        mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    }

	    public int getCount() {
	        return cardArr.size();
	    }
	    
	    @Override
	    public Object instantiateItem( View pager, int position )
	    {
	    	final OtherWorldCard theCard = cardArr.get(position);
	    	
	    	if(theCard == null)
	    	{
	    		return null;
	    	}
	    	
	    	final ArrayList<Encounter> encounters = theCard.getEncounters();

	    	final LinearLayout layout = (LinearLayout)mInflater.inflate(R.layout.cardlistitem, null);
	    	//Set stuff

	    	TextView text = null;
	    	for(int i = 0; i < encounters.size(); i++)
	    	{
	    		final int idx = i;
		    	RelativeLayout header = (RelativeLayout)mInflater.inflate(R.layout.encounterheader, null);
		    	((TextView)header.findViewById(R.id.titleTV1)).setText(encounters.get(i).getLocation().getLocationName());
		    	Button chooseEncounterBtn = ((Button)header.findViewById(R.id.button1));
		    	OnClickListener listener = new OnClickListener()
                {                	 
                	private Encounter enc = encounters.get(idx);
                	private OtherWorldCard cardHx = theCard; 

					public void onClick(View v) {
						GameState.INSTANCE.AddHistory(cardHx, enc);
						if(GameState.INSTANCE.otherWorldCardSelected(cardHx.getID()))
						{
							Toast.makeText(OtherWorldDeckActivity.this, R.string.otherword_arrow_clicked_true, Toast.LENGTH_SHORT).show();
						}
						else
						{
							Toast.makeText(OtherWorldDeckActivity.this, R.string.otherword_arrow_clicked_false, Toast.LENGTH_SHORT).show();
						}
						finish();
					}
                };
                

		    	header.setOnClickListener(listener);
		    	chooseEncounterBtn.setOnClickListener(listener);
		    	
		    	//header.setBackgroundColor(Color.CYAN);
		    	
//		    	// post a runnable to the parent view's message queue so its run after 
//	    	    // the view is drawn 
//	    	    pager.post(new Runnable() { 
//		    	    //  @Override 
//		    	      public void run() { 
//		    	        Rect delegateArea = new Rect(); 
//		    	        Button delegate = chooseEncounterBtn; 
//		    	        delegate.getHitRect(delegateArea); 
//		    	        delegateArea.top -= 50; 
//		    	        delegateArea.left -= 50;
//		    	        delegateArea.right += 50;
//		    	        delegateArea.bottom += 50;
//		    	        TouchDelegate expandedArea = new TouchDelegate(delegateArea, delegate); 
//		    	        // give the delegate to an ancestor of the view we're delegating the 
//		    	        // area to 
//		    	        if (View.class.isInstance(delegate.getParent())) { 
//		    	          layout.setTouchDelegate(expandedArea); 
//		    	        } 
//		    	      } 
//		    	    }); 
		    	
		    	
		    	text = (TextView)mInflater.inflate(R.layout.encountertext, null);
		    	text.setText(Html.fromHtml(encounters.get(i).getEncounterText()));
		    	
		    
		    	layout.addView(header);
		    	layout.addView(text);
	    	}
	    	
	    	//Last text fills the rest of the space
	    	if(text != null)
	    	{
	    		text.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
	    	}
	    	
	    	
	    	((ViewPager) pager).addView(layout);
	    	
	        Bitmap front = null;
	        try {
	        	String path = theCard.getCardPath();
	        	if( path != null )
	        	{
	        		front = BitmapFactory.decodeStream(getAssets().open(path));	
	        	}
	        	
			} catch (IOException e) {
				//front = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
			}
	        
	        if( front == null )
	        {
	        	front = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
	        }
	        //Bitmap expansion = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.blackgoaticon);
	        Bitmap result = overlayCard(front, theCard);
	        
	        layout.setBackgroundDrawable(new BitmapDrawable(result));
	    	
	    	return layout;
	    }
	    
	    @Override
	    public void destroyItem( View pager, int position, Object view )
	    {
	        ((ViewPager)pager).removeView( (View)view );
	    }
	 
	    @Override
	    public boolean isViewFromObject( View view, Object object )
	    {
	        return view.equals( object );
	    }
	    
	    private Bitmap overlayCard(Bitmap bmp1, ICard card)
	    {
	    	Bitmap retBmp = bmp1;
	    	int totalWidth = 0;
	    
	    	String path = AHFlyweightFactory.INSTANCE.getExpansion(card.getExpIDs().get(0)).getExpansionIconPath();
	    	Bitmap expBmp = null;
	    	
	    	for(int i = 0; i < card.getExpIDs().size(); i++)
	    	{
	    		path = AHFlyweightFactory.INSTANCE.getExpansion(card.getExpIDs().get(i)).getExpansionIconPath();
	    	
		    	if(path != null)
		    	{
			    	try {
						expBmp = BitmapFactory.decodeStream(getAssets().open(path));
				        
					} catch (IOException e) {
						expBmp = null;
					}
		    	}
		    	
		    	retBmp = overlay(retBmp, expBmp, totalWidth+10);
		    	if(expBmp != null)
		    	{
		    		totalWidth += expBmp.getWidth();
		    	}
	    	}
	    	
	    	return retBmp;
	    }
	    
		private Bitmap overlay(Bitmap bmp1, Bitmap bmp2, int rightMargin) 
	    {
			if(bmp2 ==null)
			{
				return bmp1;
			}
	    	//DisplayMetrics dm = new DisplayMetrics();
	        //getWindowManager().getDefaultDisplay().getMetrics(dm);
	        
	        float top = bmp1.getHeight() - bmp2.getHeight()-10;
	        float left = bmp1.getWidth() - bmp2.getWidth()-rightMargin;
	        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
	        Canvas canvas = new Canvas(bmOverlay);
	        canvas.drawBitmap(bmp1, 0,0, null);
	        canvas.drawBitmap(bmp2, left,top, null);
	        return bmOverlay;
	    }
	}
}
