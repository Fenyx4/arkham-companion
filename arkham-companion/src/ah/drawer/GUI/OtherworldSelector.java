package ah.drawer.GUI;

import java.io.IOException;
import java.util.ArrayList;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.GameState;
import ah.drawer.LocationCursor;
import ah.drawer.OtherWorldColor;
import ah.drawer.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import ah.drawer.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.CheckBox;

public class OtherworldSelector extends Activity {
	private ListView lv1;
	//private ListView lv2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherworld_selector);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        //Need to init here for some reason...
        GameState.getInstance();
        
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
        
		final Context myself = this;
 
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
            		Location otherWorld = ((LocationCursor)cursor).getLocation();
            		if(otherWorld == null)
            		{
            			but.setVisibility(View.INVISIBLE);
            		}
            		else
            		{
            			but.setVisibility(View.VISIBLE);
            			try {
            	        	butBmp = BitmapFactory.decodeStream(getAssets().open(otherWorld.getLocationButtonPath()));
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
            				ArrayList<OtherWorldColor> owcs = loc.getOtherWorldColors();
            				GameState.getInstance().clearSelectedOtherWorldColor();
            				CheckBox colorCheckbox;
				    		colorCheckbox = (CheckBox)findViewById(R.id.yellow_pip);
				    		colorCheckbox.setChecked(false);
    		        		colorCheckbox = (CheckBox)findViewById(R.id.red_pip);
    		        		colorCheckbox.setChecked(false);
    				    	colorCheckbox = (CheckBox)findViewById(R.id.blue_pip);
    				    	colorCheckbox.setChecked(false);
    				    	colorCheckbox = (CheckBox)findViewById(R.id.green_pip);
    				    	colorCheckbox.setChecked(false);
            				for(int i = 0; i < owcs.size(); i++)
            				{
            					GameState.getInstance().addSelectedOtherWorldColor(owcs.get(i));
            					switch ((int)owcs.get(i).getID())
            		        	{
            		        	case 1:
        				    		colorCheckbox = (CheckBox)findViewById(R.id.yellow_pip);
        				    		colorCheckbox.setChecked(true);
            		        		break;
            		        	case 2:
            		        		colorCheckbox = (CheckBox)findViewById(R.id.red_pip);
            		        		colorCheckbox.setChecked(true);
            		        		break;
            		        	case 3:
            				    	colorCheckbox = (CheckBox)findViewById(R.id.blue_pip);
            				    	colorCheckbox.setChecked(true);
            		        		break;
            		        	case 4:
            				    	colorCheckbox = (CheckBox)findViewById(R.id.green_pip);
            				    	colorCheckbox.setChecked(true);
            		        		break;
//            		        	default:
//            		        		colorCheckbox = (CheckBox)findViewById(R.id.grey_pip);
//            		        		setupColorCheckBox(colorCheckbox, R.drawable.yellow_off, R.drawable.yellow_on);
//            		        		break;
            		        	}
            				}
            				
            		    	Intent i = new Intent(myself, OtherWorldDeckActivity.class);

            		    	myself.startActivity(i);
            				
//            				for(int i = 0; i < lv2.getChildCount(); i++)
//            				{
//            					if(owcs.contains(lv2.getChildAt(i).getTag()))
//            					{
//            						((CheckBox)lv2.getChildAt(i)).setChecked(true);
//            					}
//            					else
//            					{
//            						((CheckBox)lv2.getChildAt(i)).setChecked(false);
//            					}
//            				}
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
        
        //lv2=(ListView)findViewById(R.id.colorListView);
        
        //Bundle extras = getIntent().getExtras();

        //long expID = extras.getLong("expID");
        
        //tv1=(TextView)findViewById(R.id.TextView01);
        
		//tvo = new TextViewObserver(tv1, blah);
        //Stat str = blah.globalstats.get("Strength");
        
        //lv1.setAdapter(new ArrayAdapter<Modifier>(this,android.R.layout.simple_list_item_1 , blah.modifiers));
        
        ArrayList<OtherWorldColor> colors = AHFlyweightFactory.INSTANCE.getCurrentOtherWorldColors();
        
        LinearLayout colorLayout = (LinearLayout)findViewById(R.id.colorLinearLayout);
        
        for( int i = 0; i < colors.size(); i++)
        {
        	switch ((int)colors.get(i).getID())
        	{
        	case 1:
		    	{
		    		final OtherWorldColor owc = colors.get(i);
		    		final CheckBox colorCheckbox = (CheckBox)findViewById(R.id.yellow_pip);
		    		// post a runnable to the parent view's message queue so its run after 
		    	    // the view is drawn 
		    		colorLayout.post(new Runnable() { 
			    	    //  @Override 
			    	      public void run() { 
			    	    	  colorCheckbox.setChecked(GameState.getInstance().isSelectedOtherWorldColor(owc));
			    	      } 
			    	    }); 
		    		setupColorCheckBox(colorCheckbox, R.drawable.yellow_off, R.drawable.yellow_on);
		    		colorCheckbox.setOnClickListener(new OnClickListener()
		    		{
		    			public void onClick(View arg0) {
							CheckBox checkbox = (CheckBox)arg0; 
					        boolean isChecked = checkbox.isChecked();
							if(isChecked)
							{
								GameState.getInstance().addSelectedOtherWorldColor(owc);
							}
							else
							{
								GameState.getInstance().removeSelectedOtherWorldColor(owc);
							}
						}
		    			
		    		});
		    	}
        		break;
        	case 2:
		    	{
		    		final OtherWorldColor owc = colors.get(i);
		    		final CheckBox colorCheckbox = (CheckBox)findViewById(R.id.red_pip);
		    		// post a runnable to the parent view's message queue so its run after 
		    	    // the view is drawn 
		    		colorLayout.post(new Runnable() { 
			    	    //  @Override 
			    	      public void run() { 
			    	    	  colorCheckbox.setChecked(GameState.getInstance().isSelectedOtherWorldColor(owc));
			    	      } 
			    	    }); 
		    		setupColorCheckBox(colorCheckbox, R.drawable.red_off, R.drawable.red_on);
		    		colorCheckbox.setOnClickListener(new OnClickListener()
		    		{
		    			public void onClick(View arg0) {
							CheckBox checkbox = (CheckBox)arg0; 
					        boolean isChecked = checkbox.isChecked();
							if(isChecked)
							{
								GameState.getInstance().addSelectedOtherWorldColor(owc);
							}
							else
							{
								GameState.getInstance().removeSelectedOtherWorldColor(owc);
							}
						}
		    			
		    		});
		    	}
        		break;
        	case 3:
		    	{
		    		final OtherWorldColor owc = colors.get(i);
		    		final CheckBox colorCheckbox = (CheckBox)findViewById(R.id.blue_pip);
		    		// post a runnable to the parent view's message queue so its run after 
		    	    // the view is drawn 
		    		colorLayout.post(new Runnable() { 
			    	    //  @Override 
			    	      public void run() { 
			    	    	  colorCheckbox.setChecked(GameState.getInstance().isSelectedOtherWorldColor(owc));
			    	      } 
			    	    }); 
		    		setupColorCheckBox(colorCheckbox, R.drawable.blue_off, R.drawable.blue_on);
		    		colorCheckbox.setOnClickListener(new OnClickListener()
		    		{
		    			public void onClick(View arg0) {
							CheckBox checkbox = (CheckBox)arg0; 
					        boolean isChecked = checkbox.isChecked();
							if(isChecked)
							{
								GameState.getInstance().addSelectedOtherWorldColor(owc);
							}
							else
							{
								GameState.getInstance().removeSelectedOtherWorldColor(owc);
							}
						}
		    			
		    		});
		    	}
        		break;
        	case 4:
		    	{
		    		final OtherWorldColor owc = colors.get(i);
		    		final CheckBox colorCheckbox = (CheckBox)findViewById(R.id.green_pip);
		    		// post a runnable to the parent view's message queue so its run after 
		    	    // the view is drawn 
		    		colorLayout.post(new Runnable() { 
			    	    //  @Override 
			    	      public void run() { 
			    	    	  colorCheckbox.setChecked(GameState.getInstance().isSelectedOtherWorldColor(owc));
			    	      } 
			    	    }); 
		    		setupColorCheckBox(colorCheckbox, R.drawable.green_off, R.drawable.green_on);
		    		colorCheckbox.setOnClickListener(new OnClickListener()
		    		{
		    			public void onClick(View arg0) {
							CheckBox checkbox = (CheckBox)arg0; 
					        boolean isChecked = checkbox.isChecked();
							if(isChecked)
							{
								GameState.getInstance().addSelectedOtherWorldColor(owc);
							}
							else
							{
								GameState.getInstance().removeSelectedOtherWorldColor(owc);
							}
						}
		    			
		    		});
		    	}
        		break;
//        	default:
//        		colorCheckbox = (CheckBox)findViewById(R.id.grey_pip);
//        		setupColorCheckBox(colorCheckbox, R.drawable.yellow_off, R.drawable.yellow_on);
//        		break;
        	}
        }
        	
//        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
//        //startManagingCursor(cursor);
// 
//        // the desired columns to be bound
//        columns = new String[] { "Name" };
//        // the XML defined views which the data will be bound to
//        to = new int[] { R.id.color };
// 
//        // create the adapter using the cursor pointing to the desired data as well as the layout information
//        mAdapter = new SimpleCursorAdapter(this, R.layout.color_toggle, cursor, columns, to);
//        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
//        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
//            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
//            	
//            	if(columnIndex == 1) {
//            		//final LocationCursor locCurse = ((LocationCursor)cursor);
//            		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
//            
//            		final OtherWorldColor owc = ((ColorCursor)cursor).getOtherWorldColor();
//            		final CheckBox but = (CheckBox) view;
//            		but.setTag(owc);
//            		Bitmap butBmp = null;
//            		if(owc == null)
//            		{
//            			but.setVisibility(View.INVISIBLE);
//            		}
//            		else
//            		{
//            			but.setVisibility(View.VISIBLE);
//            			try {
//            	        	butBmp = BitmapFactory.decodeStream(getAssets().open(owc.getButtonPath()));
//            			} catch (IOException e) {
//            				//butBmp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.encounter_front);
//            			}
//            		}
//            		//but.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
//
//            		final boolean checked = GameState.getInstance().isSelectedOtherWorldColor(owc);
//            		if(checked)
//            		{
//            			but.setChecked(true);
//						but.setText(owc.toString()+ " On");
//            		}
//					else
//					{
//						but.setChecked(false);
//						but.setText(owc.toString()+ " Off");
//					}
//            		
//            		// post a runnable to the parent view's message queue so its run after 
//    	    	    // the view is drawn 
//    	    	    lv2.post(new Runnable() { 
//    		    	    //  @Override 
//    		    	      public void run() { 
//    		    	    	  but.setChecked(GameState.getInstance().isSelectedOtherWorldColor(owc));
//    		    	      } 
//    		    	    }); 
//            		
//            		if(butBmp != null)
//            		{
//            			but.setBackgroundDrawable(new BitmapDrawable(butBmp));
//            		}
//            		else
//            		{
//            			//TODO Change to default COLOR button
//            			but.setBackgroundResource(R.drawable.neighbourhood_overlay);
//        			}
//            		but.setText(cursor.getString(columnIndex));
//            		but.setTypeface(tf);
//            		
//            		but.setOnClickListener(new OnClickListener()
//            		{
//
//            			public void onClick(View arg0) {
//							CheckBox checkbox = (CheckBox)arg0; 
//					        boolean isChecked = checkbox.isChecked();
//							if(isChecked)
//							{
//								checkbox.setText(owc.toString()+ " On");
//								GameState.getInstance().addSelectedOtherWorldColor(owc);
//							}
//							else
//							{
//								checkbox.setText(owc.toString()+ " Off");
//								GameState.getInstance().removeSelectedOtherWorldColor(owc);
//							}
//						}
//            			
//            		});
////            		but.setOnClickListener(new OnClickListener()
////            		{
////            			private ah.drawer.OtherWorldColor loc = ((ColorCursor)cursor).getOtherWorldColor();
////            			//private ArrayList<Encounter> encounters = loc.getEncounters();
////						public void onClick(View arg0) {
////							Log.i("Neighborhood", "Neighborhood Clicked");
////							bundle2.putLong("neighborhood", loc.getID());
////							
////					        //GameState.getInstance().randomizeNeighborhood(nei.getID());
////
////							Intent i = new Intent(act, OtherWorldDeckActivity.class);
////							i.putExtras(bundle);
////							act.startActivity(i);
////							}
////            		
////            		});
//            		
//            		return true;
//            	}
//        	            
//                return false;
//            }
//        });
//
//        	 
//        // set this adapter as your ListActivity's adapter
//        lv2.setAdapter(mAdapter);
     
    }
    
    private void setupColorCheckBox(CheckBox colorCheckbox, int off,
			int on) {
    	StateListDrawable myStates = new StateListDrawable();
	    int stateChecked = android.R.attr.state_checked;

	    Bitmap checkOffBMP;
		checkOffBMP = BitmapFactory.decodeResource(this.getResources(), off);
		checkOffBMP = Bitmap.createScaledBitmap(checkOffBMP, 35, 35, false);
		//checkOffBMP.setDensity(20);
	    BitmapDrawable checkOffDrawable = new BitmapDrawable(checkOffBMP);
	    myStates.addState(new int[]{ -stateChecked }, checkOffDrawable);
	    Bitmap checkOnBMP = BitmapFactory.decodeResource(this.getResources(), on);
	    checkOnBMP = Bitmap.createScaledBitmap(checkOnBMP, 35, 35, false);
	    BitmapDrawable checkOnDrawable = new BitmapDrawable(checkOnBMP);
	    myStates.addState(new int[]{ stateChecked }, checkOnDrawable);
	    colorCheckbox.setButtonDrawable(myStates);
		
	}

	public void openNeighborhood(View view)
    {
    	Intent i = new Intent(this, NeighborhoodSelector.class);
    	i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		this.startActivity(i);
    }
    
    public void openEncHx(View view)
    {
    	//final Bundle bundle = new Bundle();
    	Intent i = new Intent(this, LocationHxActivity.class);
    	//long[] colorIDs = lv2.getCheckedItemIds();
    	//bundle.putLongArray("otherworld", colorIDs);
    	//i.putExtras(bundle);
		this.startActivity(i);
    }
    
    public void openOW(View view)
    {
    	//final Bundle bundle = new Bundle();
    	Intent i = new Intent(this, OtherWorldDeckActivity.class);
    	//long[] colorIDs = new long[selectedColorIDs.size()];
    	//for(int j = 0; j < colorIDs.length; j++)
    	//{
//    		colorIDs[j] = selectedColorIDs.get(j);
  //  	}
    //	bundle.putLongArray("otherworld", colorIDs);
    	//i.putExtras(bundle);
		this.startActivity(i);
    }
}