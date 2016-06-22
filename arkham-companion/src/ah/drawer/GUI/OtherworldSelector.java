package ah.drawer.GUI;

import java.io.IOException;
import java.util.ArrayList;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.ColorCursor;
import ah.drawer.LocationCursor;
import ah.drawer.OtherWorldColor;
import ah.drawer.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import ah.drawer.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.ToggleButton;

public class OtherworldSelector extends Activity {
	private ListView lv1;
	private ListView lv2;
	private ArrayList<Long> selectedColorIDs;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherworld_selector);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        //Init blah = new Init();
        lv1=(ListView)findViewById(R.id.locationListView);
        
        //Bundle extras = getIntent().getExtras();

        //long expID = extras.getLong("expID");
        
        //tv1=(TextView)findViewById(R.id.TextView01);
        
		//tvo = new TextViewObserver(tv1, blah);
        //Stat str = blah.globalstats.get("Strength");
        
        //lv1.setAdapter(new ArrayAdapter<Modifier>(this,android.R.layout.simple_list_item_1 , blah.modifiers));
        
        Cursor cursor = new LocationCursor(AHFlyweightFactory.INSTANCE.getCurrentOtherWorldLocations());
        	
        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        //startManagingCursor(cursor);
 
        // the desired columns to be bound
        String[] columns = new String[] { "Name" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.location };
 
        final Activity act = this;
        final Bundle bundle = new Bundle();
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.location_button, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	
            	if(columnIndex == 1) {
            		//final LocationCursor locCurse = ((LocationCursor)cursor);
            		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
            
            		Button but = (Button) view;
            		Bitmap butBmp = null;
            		if(((LocationCursor)cursor).getLocation() == null)
            		{
            			but.setVisibility(View.INVISIBLE);
            		}
            		else
            		{
            			but.setVisibility(View.VISIBLE);
            			try {
            	        	butBmp = BitmapFactory.decodeStream(getAssets().open(((LocationCursor)cursor).getLocation().getLocationButtonPath()));
            			} catch (IOException e) {
            				//butBmp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
            			}
            		}
            		//but.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));

            		if(butBmp != null)
            		{
            			but.setBackgroundDrawable(new BitmapDrawable(butBmp));
            		}
            		else
            		{
            			//TODO Change to default OW button
            			but.setBackgroundResource(R.drawable.neighbourhood_overlay);
        			}
            		but.setText(cursor.getString(columnIndex));
            		but.setTypeface(tf);
            		
            		but.setOnClickListener(new OnClickListener()
            		{
            			private ah.drawer.Location loc = ((LocationCursor)cursor).getLocation();
            			//private ArrayList<Encounter> encounters = loc.getEncounters();
            			public void onClick(View arg0) {
            				Log.i("Neighborhood", "Neighborhood Clicked");
            				bundle.putLong("neighborhood", loc.getID());

            				//GameState.INSTANCE.randomizeNeighborhood(nei.getID());

            				Intent i = new Intent(act, OtherWorldDeckActivity.class);
            				i.putExtras(bundle);
            				act.startActivity(i);
            			}

            		});
            		
            		return true;
            	}
        	            
                return false;
            }
        });

        	 
        // set this adapter as your ListActivity's adapter
        lv1.setAdapter(mAdapter);
        
        // -----------------
        
        lv2=(ListView)findViewById(R.id.colorListView);
        
        //Bundle extras = getIntent().getExtras();

        //long expID = extras.getLong("expID");
        
        //tv1=(TextView)findViewById(R.id.TextView01);
        
		//tvo = new TextViewObserver(tv1, blah);
        //Stat str = blah.globalstats.get("Strength");
        
        //lv1.setAdapter(new ArrayAdapter<Modifier>(this,android.R.layout.simple_list_item_1 , blah.modifiers));
        
        cursor = new ColorCursor(AHFlyweightFactory.INSTANCE.getCurrentOtherWorldColors());
        
        selectedColorIDs = new ArrayList<Long>();
        	
        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        //startManagingCursor(cursor);
 
        // the desired columns to be bound
        columns = new String[] { "Name" };
        // the XML defined views which the data will be bound to
        to = new int[] { R.id.color };
 
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        mAdapter = new SimpleCursorAdapter(this, R.layout.color_toggle, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	
            	if(columnIndex == 1) {
            		//final LocationCursor locCurse = ((LocationCursor)cursor);
            		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
            
            		final OtherWorldColor owc = ((ColorCursor)cursor).getOtherWorldColor();
            		ToggleButton but = (ToggleButton) view;
            		Bitmap butBmp = null;
            		if(owc == null)
            		{
            			but.setVisibility(View.INVISIBLE);
            		}
            		else
            		{
            			but.setVisibility(View.VISIBLE);
            			try {
            	        	butBmp = BitmapFactory.decodeStream(getAssets().open(owc.getButtonPath()));
            			} catch (IOException e) {
            				//butBmp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
            			}
            		}
            		//but.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));

            		if(butBmp != null)
            		{
            			but.setBackgroundDrawable(new BitmapDrawable(butBmp));
            		}
            		else
            		{
            			//TODO Change to default COLOR button
            			but.setBackgroundResource(R.drawable.neighbourhood_overlay);
        			}
            		but.setText(cursor.getString(columnIndex));
            		but.setTextOff(cursor.getString(columnIndex)+ " Off");
            		but.setTextOn(cursor.getString(columnIndex)+ " On");
            		but.setTypeface(tf);
            		
            		but.setOnCheckedChangeListener(new OnCheckedChangeListener()
            		{

						public void onCheckedChanged(CompoundButton arg0,
								boolean arg1) {
							ToggleButton checkbox = (ToggleButton)arg0; 
					        boolean isChecked = checkbox.isChecked();
							if(isChecked)
							{
								selectedColorIDs.add(owc.getID());
							}
							else
							{
								selectedColorIDs.remove(owc.getID());
							}
						}
            			
            		});
//            		but.setOnClickListener(new OnClickListener()
//            		{
//            			private ah.drawer.OtherWorldColor loc = ((ColorCursor)cursor).getOtherWorldColor();
//            			//private ArrayList<Encounter> encounters = loc.getEncounters();
//						public void onClick(View arg0) {
//							Log.i("Neighborhood", "Neighborhood Clicked");
//							bundle2.putLong("neighborhood", loc.getID());
//							
//					        //GameState.INSTANCE.randomizeNeighborhood(nei.getID());
//
//							Intent i = new Intent(act, OtherWorldDeckActivity.class);
//							i.putExtras(bundle);
//							act.startActivity(i);
//							}
//            		
//            		});
            		
            		return true;
            	}
        	            
                return false;
            }
        });

        	 
        // set this adapter as your ListActivity's adapter
        lv2.setAdapter(mAdapter);
     
    }
    
    public void openEncHx(View view)
    {
    	final Bundle bundle = new Bundle();
    	Intent i = new Intent(this, LocationHxActivity.class);
    	long[] colorIDs = lv2.getCheckedItemIds();
    	bundle.putLongArray("otherworld", colorIDs);
    	i.putExtras(bundle);
		this.startActivity(i);
    }
    
    public void openOW(View view)
    {
    	final Bundle bundle = new Bundle();
    	Intent i = new Intent(this, OtherWorldDeckActivity.class);
    	long[] colorIDs = new long[selectedColorIDs.size()];
    	for(int j = 0; j < colorIDs.length; j++)
    	{
    		colorIDs[j] = selectedColorIDs.get(j);
    	}
    	bundle.putLongArray("otherworld", colorIDs);
    	i.putExtras(bundle);
		this.startActivity(i);
    }
}