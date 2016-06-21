package ah.drawer.GUI;

import java.io.IOException;
import java.util.ArrayList;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Card;
import ah.drawer.Encounter;
import ah.drawer.GameState;
import ah.drawer.Neighborhood;
import ah.drawer.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class LocationHxActivity extends Activity {
	//private Encounter encounter;
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationdeck);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new EncounterHxAdapter(this, GameState.INSTANCE.getEncounterHx()));

//	    gallery.setOnItemClickListener(new OnItemClickListener() {
//	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//	            Toast.makeText(LocationHxActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//	        }
//	    });
        
    }

    public class EncounterHxAdapter extends PagerAdapter {
	    //int mGalleryItemBackground;
	    private Context mContext;

	    private ArrayList<Encounter> encArr;
	    
	    private LayoutInflater mInflater;

	    public EncounterHxAdapter(Context c, ArrayList<Encounter> encArr) 
	    {
	        mContext = c;
	        this.encArr = encArr;

	        Log.w("AHEncounters", encArr.size() + " encounters in Hx.");	
	        
	        mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    }

	    public int getCount() {
	        return encArr.size();
	    }
	    
	    @Override
	    public Object instantiateItem( View pager, int position )
	    {
	    	final Card theCard = GameState.INSTANCE.getCardHx().get(position);
	    	final ArrayList<Encounter> encounters = theCard.getEncounters();

	    	final LinearLayout layout = (LinearLayout)mInflater.inflate(R.layout.cardlistitem, null);
	    	//Set stuff

	    	TextView text = null;
	    	for(int i = 0; i < encounters.size(); i++)
	    	{
		    	RelativeLayout header = (RelativeLayout)mInflater.inflate(R.layout.encounterheader, null);
		    	((TextView)header.findViewById(R.id.titleTV1)).setText(encounters.get(i).getLocation().getLocationName());
		    	Button chooseEncounterBtn = ((Button)header.findViewById(R.id.button1));
		    	//Don't need to select counters in our Hx
		    	header.removeView(chooseEncounterBtn);
		    	
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
	    	
	    	Neighborhood nei = theCard.getNeighborhood();
	        Bitmap front;
	        try {
	        	front = BitmapFactory.decodeStream(getAssets().open(nei.getCardPath()));
			} catch (IOException e) {
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
	   
	    private Bitmap overlayCard(Bitmap bmp1, Card card)
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
