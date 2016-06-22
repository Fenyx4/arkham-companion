/*
 * This file is part of Arkham Companion.
 *
 *  Arkham Companion is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Arkham Companion is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Arkham Companion.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fenyx4.arkham.GUI;

import java.io.IOException;
import java.util.ArrayList;

import com.fenyx4.arkham.AHFlyweightFactory;
import com.fenyx4.arkham.EncounterHx;
import com.fenyx4.arkham.ICard;
import com.fenyx4.arkham.Encounter;
import com.fenyx4.arkham.GameState;
import com.fenyx4.arkham.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class LocationHxActivity extends Activity {
	//private Encounter encounter;
	
	EncounterHxAdapter encAdapter;
	boolean noHx = true;
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        ArrayList<EncounterHx> encHx = GameState.getInstance().getEncounterHx();
        
        if(encHx.size() != 0)
        {       
        	noHx = false;
		    setContentView(R.layout.locationdeck);
		    
		    ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
		    encAdapter = new EncounterHxAdapter(this, encHx);
		    viewpager.setAdapter(encAdapter);
        }
        else
        {
        	noHx = true;
        	setContentView(R.layout.empty_hx);
        }

//	    gallery.setOnItemClickListener(new OnItemClickListener() {
//	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//	            Toast.makeText(LocationHxActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//	        }
//	    });
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	if(noHx)
    	{
    		return false;
    	}
    	else
    	{
    		MenuInflater inflater = getMenuInflater();
    		inflater.inflate(R.menu.location_hx_menu, menu);
    		return true;
    	}
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.delete_card:
                deleteCard();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    private void deleteCard()
    {
    	ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
    	encAdapter.remove(viewpager.getCurrentItem());
    	encAdapter.notifyDataSetChanged();
    	
    	if(encAdapter.getCount() == 0)
    	{
    		noHx = true;
        	setContentView(R.layout.empty_hx);
    	}
    }

    public class EncounterHxAdapter extends PagerAdapter {
	    //int mGalleryItemBackground;
	    private Context mContext;

	    private ArrayList<EncounterHx> encArr;
	    
	    private LayoutInflater mInflater;

	    public EncounterHxAdapter(Context c, ArrayList<EncounterHx> encArr) 
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
	    public int getItemPosition(Object object) {
	        return POSITION_NONE;
	    }
	    
	    @Override
	    public Object instantiateItem( View pager, int position )
	    {
	    	final ICard theCard = GameState.getInstance().getEncounterHx().get(position).getCard();
	    	final ArrayList<Encounter> encounters = theCard.getEncounters();

	    	final ScrollView layout = (ScrollView)mInflater.inflate(R.layout.cardlistitem, null);
            final LinearLayout cardContents = (LinearLayout) layout.findViewById(R.id.card_contents);
	    	//Set stuff

	    	TextView text = null;
	    	for(int i = 0; i < encounters.size(); i++)
	    	{
		    	RelativeLayout header = (RelativeLayout)mInflater.inflate(R.layout.encounterheader, null);
		    	TextView title = (TextView)header.findViewById(R.id.titleTV1);
		    	title.setPadding(getIndependentWidth(title.getPaddingLeft()), getIndependentHeight(title.getPaddingTop()), getIndependentWidth(title.getPaddingRight()), getIndependentHeight(title.getPaddingBottom()));
		    	title.setText(encounters.get(i).getLocation().getLocationName());
		    	Typeface tf = Typeface.createFromAsset(getAssets(),
		                "fonts/se-caslon-ant.ttf");
		        title.setTypeface(tf);
		    	Button chooseEncounterBtn = ((Button)header.findViewById(R.id.button1));
		    	//Don't need to select counters in our Hx
		    	header.removeView(chooseEncounterBtn);
		    	
		    	text = (TextView)mInflater.inflate(R.layout.encountertext, null);
		    	text.setText(Html.fromHtml(encounters.get(i).getEncounterText()));
		    	text.setPadding(getIndependentWidth(text.getPaddingLeft()), getIndependentHeight(text.getPaddingTop()), getIndependentWidth(text.getPaddingRight()), getIndependentHeight(text.getPaddingBottom()));
		    	
		    	if( !encounters.get(i).equals(encArr.get(position)))
		    	{
		    		header.setBackgroundColor(getResources().getColor(R.color.shaded_hx));
		    		text.setBackgroundColor(getResources().getColor(R.color.shaded_hx));
		    	}
		    	
		    
		    	cardContents.addView(header);
		    	cardContents.addView(text);
	    	}
	    	
	    	//Last text fills the rest of the space
	    	if(text != null)
	    	{
	    		text.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
	    	}
	    	
	    	
	    	((ViewPager) pager).addView(layout);
	    	
	        Bitmap front;
	        try {
	        	front = BitmapFactory.decodeStream(getAssets().open(theCard.getCardPath()));
			} catch (IOException e) {
				front = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
			}
	        
	        //Bitmap expansion = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.blackgoaticon);
	        Bitmap result = overlayCard(front, theCard);
	        
	        layout.setBackgroundDrawable(new BitmapDrawable(result));
	    	
	    	return layout;
	    }
	    
	    public void remove(int position)
	    {
	    	GameState.getInstance().removeHx(position);
	    	encArr.remove(position);
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
	        

	        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
	        Canvas canvas = new Canvas(bmOverlay);
	        canvas.drawBitmap(bmp1, 0,0, null);
	        Matrix mtx = new Matrix();
	        //float resizeHeightPercentage = bmp1.getHeight()/491.0f;
	        float resizeWidthPercentage = bmp1.getWidth()/305.0f;
	        float top = bmp1.getHeight() - (bmp2.getHeight()+10)*resizeWidthPercentage;
	        float left = bmp1.getWidth() - (bmp2.getWidth()+rightMargin)*resizeWidthPercentage;
	        mtx.setScale(resizeWidthPercentage, resizeWidthPercentage);
	        mtx.postTranslate(left, top);
	        Paint paint = new Paint();
	        paint.setFilterBitmap(true);
	        canvas.drawBitmap(bmp2, mtx, paint);
	        return bmOverlay;
	    }
		
		protected int getIndependentWidth(int origWidth)
		{
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm); 
			return (int) Math.ceil((origWidth*dm.widthPixels)/480.0f);
		}
		
		protected int getIndependentHeight(int origHeight)
		{
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm); 	
			return (int) Math.ceil((origHeight*dm.heightPixels)/800.0f);
		}
	}
}
