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
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

public class LocationDeckActivity extends Activity {
	//private Encounter encounter;
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationdeck);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        Bundle extras = getIntent().getExtras();

        long neiID = extras.getLong("neighborhood");
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new CardAdapter(this, GameState.INSTANCE.getDeckByNeighborhood(neiID)));

	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(LocationDeckActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
        
	    gallery.setSelected(true);
	    gallery.setSelection(0);
    }

    public class CardAdapter extends BaseAdapter {
	    //int mGalleryItemBackground;
	    private Context mContext;

	    private ArrayList<Card> cardArr;

	    public CardAdapter(Context c, ArrayList<Card> cardArr) 
	    {
	        mContext = c;
	        this.cardArr = cardArr;
	        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
	        
	        Log.w("AHDecks", cardArr.size() + " cards in deck.");
	        
	        //mGalleryItemBackground = attr.getResourceId(
	        //        R.styleable.HelloGallery_android_galleryItemBackground, 0);
	        attr.recycle();
	    }

	    public int getCount() {
	        return cardArr.size();
	    }

	    public Object getItem(int position) {
	        return cardArr.get(position);
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
	    	final Card theCard = cardArr.get(position);
	    	final ArrayList<Encounter> encounters = theCard.getEncounters();
	    	
		    LinearLayout cardLayout = new LinearLayout(getApplicationContext());
	    	cardLayout.setOrientation(LinearLayout.VERTICAL);
	    	cardLayout.setGravity(Gravity.CENTER);
	    	
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
	        	
	        	RelativeLayout headerLayout = new RelativeLayout(getApplicationContext());
	        	//encounterLayout.setOrientation(LinearLayout.HORIZONTAL);
	        	//LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f);
	        	//linearParams.gravity(1);
	        	headerLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
	        	headerLayout.setPadding(0, 0, 0, 0);
	        	headerLayout.setGravity(Gravity.CENTER);
		        //encounterLayout.setBackgroundColor(Color.MAGENTA);
		        
		    	//Header 1
		    	TextView tv = new TextView(mContext);
		    	
		    	if(csl != null)
		    	{
		    		tv.setTextColor(csl);
		    	}
		    	
		    	tv.setText(encounters.get(0).getLocation().getLocationName());
		    	//tv.setGravity(Gravity.CENTER|Gravity.TOP);
		    
		    	tv.setTextSize(18);
		    	tv.setTypeface(Typeface.SERIF);
		        tv.setPadding(0, firstTopPadding, 5, titleBottomPadding);	       
		        //tv.setWidth(dm.widthPixels);
		        //tv.setHeight();
		        //tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
		        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		        
		        tv.setLayoutParams(params);
		        //params.addRule(RelativeLayout., RelativeLayout.TRUE);
		        
		        //tv.setBackgroundColor(Color.CYAN);
		        tv.setId(1);
		        //tv.setBackgroundColor(Color.GREEN);
		        headerLayout.addView(tv);
		        cardLayout.addView(headerLayout);
		        
		        Button chooseEncounterBtn = new Button(getApplicationContext());
		        //chooseEncounterBtn.setText("Blah");
		        chooseEncounterBtn.setGravity(Gravity.CENTER);
		        chooseEncounterBtn.setPadding(0, 0, 10, 0);
		        //chooseEncounterBtn.setHeight(10);
		        //chooseEncounterBtn.setWidth(10);
		        //chooseEncounterBtn.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
		        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		        //params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		        //params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		        params.addRule(RelativeLayout.ALIGN_BASELINE, tv.getId());
		        //params.addRule(RelativeLayout.ALIGN_RIGHT, RelativeLayout.TRUE);
		        params.addRule(RelativeLayout.RIGHT_OF, tv.getId());
		        //chooseEncounterBtn.setLayoutParams(params);
		        chooseEncounterBtn.setBackgroundResource(R.drawable.end_right);
		        
		        chooseEncounterBtn.setOnClickListener(
		        		new OnClickListener()
                {                	 
                	private Encounter enc = encounters.get(0);
                	private Card cardHx = theCard; 

					@Override
					public void onClick(View v) {
						GameState.INSTANCE.AddHistory(cardHx, enc);
						
					}
                });
		        
		        headerLayout.addView(chooseEncounterBtn,params);
		        
	        	//RelativeLayout encounterLayout = new RelativeLayout(getApplicationContext());
	        	////encounterLayout.setOrientation(LinearLayout.HORIZONTAL);
		       // encounterLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
		        //encounterLayout.setPadding(0, 0, 0, 0);
		        ////encounterLayout.setBackgroundColor(Color.MAGENTA);

		        tv = new TextView(mContext);
		    	
		        if(csl != null)
		    	{
		    		tv.setTextColor(csl);
		    	}
		        
		    	tv.setText(Html.fromHtml(encounters.get(0).getEncounterText()));
		        //tv.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		    	tv.setGravity(Gravity.TOP);
		    
		    	tv.setTextSize(12);
		    	tv.setTypeface(Typeface.SERIF);
		        tv.setPadding(leftPadding, textTopPadding, rightPadding, textBottomPadding);	       
		        tv.setWidth(dm.widthPixels);
		        //tv.setHeight(dm.heightPixels);
		        
		        //params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		        //params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0f));
		        //params.addRule(RelativeLayout., RelativeLayout.TRUE);
		        
		        //tv.setBackgroundColor(Color.CYAN);
		        tv.setId(1);
		        cardLayout.addView(tv);
		        //encounterLayout.addView(tv);
		        
		        
		        
		        
		        //encounterLayout.addView(chooseEncounterBtn,params);
		        
		        //cardLayout.addView(tv);
		        //cardLayout.addView(chooseEncounterBtn);
		        //cardLayout.addView(encounterLayout);
	        
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
			        
			      //TODO Remove
			        tv.setOnClickListener(
					        //chooseEncounterBtn.setOnClickListener(
					        		new OnClickListener()
			                {                	 
			                	private Encounter enc = encounters.get(0);
			                	private Card cardHx = theCard; 

								@Override
								public void onClick(View v) {
									GameState.INSTANCE.AddHistory(cardHx, enc);
									
								}
			                });
			        
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
			        
			        chooseEncounterBtn = new Button(getApplicationContext());
			        chooseEncounterBtn.setText("Blah");
			        //chooseEncounter.setHeight(20);
			        //chooseEncounter.setWidth(20);
			        chooseEncounterBtn.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0f));
			        
			        chooseEncounterBtn.setOnClickListener(
			        		new OnClickListener()
	                {                	 
	                	private Encounter enc = encounters.get(0);
	                	private Card cardHx = theCard; 

						@Override
						public void onClick(View v) {
							GameState.INSTANCE.AddHistory(cardHx, enc);
							
						}
	                });
			        
			        cardLayout.addView(tv);
			        //cardLayout.addView(chooseEncounterBtn);
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
