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

import com.fenyx4.arkham.AHFlyweightFactory;
import com.fenyx4.arkham.GameState;
import com.fenyx4.arkham.Neighborhood;
import com.fenyx4.arkham.NeighborhoodCursor;
import com.fenyx4.arkham.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class NeighborhoodSelector extends Activity {
	private ListView lv1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        //Need to init here for some reason...
        GameState.getInstance();
        
        //GameState.INSTANCE.onRestoreInstanceState(savedInstanceState);
        
        //Init blah = new Init();
        lv1=(ListView)findViewById(R.id.ListView01);
        
        //Bundle extras = getIntent().getExtras();

        //long expID = extras.getLong("expID");
        
        //tv1=(TextView)findViewById(R.id.TextView01);
        
		//tvo = new TextViewObserver(tv1, blah);
        //Stat str = blah.globalstats.get("Strength");
        
        //lv1.setAdapter(new ArrayAdapter<Modifier>(this,android.R.layout.simple_list_item_1 , blah.modifiers));
        
        Cursor cursor = new NeighborhoodCursor(AHFlyweightFactory.INSTANCE.getCurrentNeighborhoods());
        	
        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        //startManagingCursor(cursor);
 
        // the desired columns to be bound
        String[] columns = new String[] { "Left","Right" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.name_entry, R.id.name_entry2 };
 
        final Activity act = this;
        final Bundle bundle = new Bundle();
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list_example_entry, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	final int colIdx = columnIndex;
            	if(columnIndex == 1 || columnIndex == 2) {
            		//final LocationCursor locCurse = ((LocationCursor)cursor);
            		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
            
            		Button but = (Button) view;
            		Bitmap butBmp = null;
            		if(((NeighborhoodCursor)cursor).getNeighborhood(colIdx) == null)
            		{
            			but.setVisibility(View.INVISIBLE);
            		}
            		else
            		{
            			but.setVisibility(View.VISIBLE);
            			try {
            	        	butBmp = BitmapFactory.decodeStream(getAssets().open(((NeighborhoodCursor)cursor).getNeighborhood(colIdx).getNeighborhoodButtonPath()));
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
            			but.setBackgroundResource(R.drawable.neighbourhood_overlay);
        			}
            		but.setText(cursor.getString(columnIndex));
            		but.setTypeface(tf);
            		
            		but.setOnClickListener(new OnClickListener()
            		{
            			private Neighborhood nei = ((NeighborhoodCursor)cursor).getNeighborhood(colIdx);
            			//private ArrayList<Encounter> encounters = loc.getEncounters();
						public void onClick(View arg0) {
							Log.i("Neighborhood", "Neighborhood Clicked");
							bundle.putLong("neighborhood", nei.getID());
							
					        //GameState.INSTANCE.randomizeNeighborhood(nei.getID());

							Intent i = new Intent(act, LocationDeckActivity.class);
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
     
    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    }
    
    public void openEncHx(View view)
    {
    	Intent i = new Intent(this, LocationHxActivity.class);
		this.startActivity(i);
    }
    
    public void openOW(View view)
    {
    	Intent i = new Intent(this, OtherworldSelector.class);
    	i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		this.startActivity(i);
    }
}