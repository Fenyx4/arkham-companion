package ah.drawer.GUI;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Card;
import ah.drawer.Encounter;
import ah.drawer.GameState;
import ah.drawer.Neighborhood;
import ah.drawer.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

public class LocationHxActivity extends Activity {
	//private Encounter encounter;
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationdeck);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());

        //long neiID = extras.getLong("neighborhood");
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new EncounterHxAdapter(this, GameState.INSTANCE.getEncounterHx()));

	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(LocationHxActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
        
	    gallery.setSelected(true);
	    gallery.setSelection(0);
    }

    public class EncounterHxAdapter extends BaseAdapter {
	    //int mGalleryItemBackground;
	    private Context mContext;

	    private ArrayList<Encounter> encArr;

	    public EncounterHxAdapter(Context c, ArrayList<Encounter> encArr) 
	    {
	        mContext = c;
	        this.encArr = encArr;
	        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
	        
	        Log.w("AHEncounters", encArr.size() + " encounters in Hx.");
	        
	        //mGalleryItemBackground = attr.getResourceId(
	        //        R.styleable.HelloGallery_android_galleryItemBackground, 0);
	        attr.recycle();
	    }

	    public int getCount() {
	        return encArr.size();
	    }

	    public Object getItem(int position) {
	        return encArr.get(position);
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) 
	    {
	    	int leftPadding = 30;
	    	int rightPadding = 30;
	    	int firstTopPadding = 30;
	    	int titleTopPadding = 10;
	    	int titleBottomPadding = 0;
	    	int textTopPadding = 0;
	    	int textBottomPadding = 0;
	    	Encounter theEnc = encArr.get(position);
	    	final Card theCard = GameState.INSTANCE.getCardHx().get(position);
	    	final ArrayList<Encounter> encounters = theCard.getEncounters();
	    	
		    LinearLayout cardLayout = new LinearLayout(getApplicationContext());
	    	cardLayout.setOrientation(LinearLayout.VERTICAL);
	    	
	        DisplayMetrics dm = new DisplayMetrics();
	        getWindowManager().getDefaultDisplay().getMetrics(dm);
	        
	        XmlResourceParser xpp=getResources().getXml(R.color.deck_textview_style); 
	        ColorStateList csl = null;
	        try {
				csl = ColorStateList.createFromXml(getResources(), xpp);
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        //ColorStateList states = ColorStateList.createFromXml(r, parser)
	    	
	        if(encounters.size() > 0)
	        {
		    	//Header 1
		    	TextView tv = new TextView(mContext);
		    	
		    	if(csl != null)
		    	{
		    		tv.setTextColor(csl);
		    	}
		    	
		    	tv.setText(encounters.get(0).getLocation().getLocationName());
		    	tv.setGravity(Gravity.CENTER|Gravity.TOP);
		    
		    	tv.setTextSize(18);
		    	tv.setTypeface(Typeface.SERIF);
		        tv.setPadding(leftPadding, firstTopPadding, rightPadding, titleBottomPadding);	       
		        tv.setWidth(dm.widthPixels );
		        //tv.setHeight();
		        tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
		        
		        //tv.setBackgroundColor(Color.GREEN);
		        cardLayout.addView(tv);
		        
	        	LinearLayout encounterLayout = new LinearLayout(getApplicationContext());

		        tv = new TextView(mContext);
		    	
		        if(csl != null)
		    	{
		    		tv.setTextColor(csl);
		    	}
		        
		    	tv.setText(Html.fromHtml(encounters.get(0).getEncounterText()));
		    	tv.setGravity(Gravity.TOP);
		    
		    	tv.setTextSize(12);
		    	tv.setTypeface(Typeface.SERIF);
		        tv.setPadding(leftPadding, textTopPadding, rightPadding, textBottomPadding);	       
		        tv.setWidth(dm.widthPixels );
		        //tv.setHeight(dm.heightPixels);
		        tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
		        
		        encounterLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
		        
		        cardLayout.addView(tv);
	        
		        for(int i = 1; i < encounters.size(); i++)
		        {
		        	//Header
		        	tv = new TextView(mContext);
			    	
		        	if(csl != null)
			    	{
			    		tv.setTextColor(csl);
			    	}
		        	
			    	tv.setText(encounters.get(i).getLocation().getLocationName());
			    	tv.setGravity(Gravity.CENTER|Gravity.TOP);
			    
			    	tv.setTextSize(18);
			    	tv.setTypeface(Typeface.SERIF);
			        tv.setPadding(leftPadding, titleTopPadding, rightPadding, titleBottomPadding);	       
			        tv.setWidth(dm.widthPixels );
			        //tv.setHeight();
			        tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
			        
			        //tv.setBackgroundColor(Color.GREEN);
			        cardLayout.addView(tv);
			        
			        //Encounter Text
			        tv = new TextView(mContext);
			    	
			        if(csl != null)
			    	{
			    		tv.setTextColor(csl);
			    	}
			        
			    	tv.setText(Html.fromHtml(encounters.get(i).getEncounterText()));
			    	tv.setGravity(Gravity.TOP);
			    
			    	tv.setTextSize(12);
			    	tv.setTypeface(Typeface.SERIF);
			        tv.setPadding(leftPadding, textTopPadding, rightPadding, textBottomPadding);	       
			        tv.setWidth(dm.widthPixels );
			        //tv.setHeight(dm.heightPixels);
			        tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
			        
			        //tv.setBackgroundColor(Color.CYAN);
			        
			        cardLayout.addView(tv);
		        }
		        
		        // Last one takes up the remaining space
		        tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
	        }
	        
	        cardLayout.setLayoutParams(new Gallery.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
	        //layout.setBackgroundColor(Color.CYAN);
	        Neighborhood nei = theCard.getNeighborhood();
	        Bitmap front;
	        try {
	        	front = BitmapFactory.decodeStream(getAssets().open(nei.getCardPath()));
			} catch (IOException e) {
				front = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
			}
	        
	        //Bitmap expansion = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.blackgoaticon);
	        Bitmap result = overlayCard(front, theCard);
	        
	        cardLayout.setBackgroundDrawable(new BitmapDrawable(result));

	        //layout.setBackgroundResource(R.drawable.encounter_front);
	        
	        return cardLayout;
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
