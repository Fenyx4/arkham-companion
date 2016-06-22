package ah.drawer.GUI;

import java.util.ArrayList;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.GameState;
import ah.drawer.LocationCursor;
import ah.drawer.OtherWorldColor;
import ah.drawer.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import ah.drawer.Location;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.SparseArray;
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
        String[] columns = new String[] { "Left","Right" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.name_entry, R.id.name_entry2 };
        
		final OtherworldSelector myself = this;
 
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.location_button, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	final int colIdx = columnIndex;
            	if(columnIndex == 1 || columnIndex == 2) {
            		//final LocationCursor locCurse = ((LocationCursor)cursor);
            		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
            
            		Button but = (Button) view;
            		Location otherWorld = ((LocationCursor)cursor).getLocation(columnIndex);
            		if(otherWorld == null)
            		{
            			but.setVisibility(View.INVISIBLE);
            		}
            		else
            		{
            			but.setVisibility(View.VISIBLE);
            		}

            		//but.setBackgroundResource(R.drawable.otherworld_loc_btn);
            		Bitmap bmp;
            		if(bmpCache.get((int) otherWorld.getID(), null) != null)
            		{
            			bmp = bmpCache.get((int) otherWorld.getID());
            		}
            		else
            		{
            			if(bmpCache.get(-1, null) != null)
            			{
            				bmp = bmpCache.get(-1);
            			}
            			else
            			{
            				bmp = BitmapFactory.decodeResource(myself.getResources(), R.drawable.otherworld_loc_btn);
            				bmpCache.append(-1, bmp);
            			}
            			bmp = myself.overlayBtn(bmp, otherWorld);
            			
            			//bmpCache.append((int) otherWorld.getID(), bmp);
            		}
            		but.setBackgroundDrawable(new BitmapDrawable(bmp));
            		
            		but.setText(cursor.getString(columnIndex));
            		but.setTypeface(tf);
            		
            		but.setOnClickListener(new OnClickListener()
            		{
            			private ah.drawer.Location loc = ((LocationCursor)cursor).getLocation(colIdx);
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
    
    private SparseArray<Bitmap> bmpCache = new SparseArray<Bitmap> ();
    private Bitmap overlayBtn(Bitmap bmp1, Location loc)
    {
    	Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmOverlay);
    	canvas.drawBitmap(bmp1, 0,0, null);
    	Matrix mtx;
    	float resizeWidthPercentage = (bmp1.getWidth()-250)/305.0f;
    	Paint paint = new Paint();
        paint.setFilterBitmap(true);
    	
    	Bitmap colorBmp = null;
    	
    	ArrayList<OtherWorldColor> owcs = loc.getOtherWorldColors();
    	for(int i = 0; i < owcs.size(); i++)
    	{
    		mtx = new Matrix();
    		mtx.setScale(resizeWidthPercentage, resizeWidthPercentage);
    		if(bmpCache.get((int)owcs.get(i).getID()+100, null) != null)
			{
    			colorBmp = bmpCache.get((int)owcs.get(i).getID()+100);
			}
			else
			{
	    		switch ((int)owcs.get(i).getID())
	    		{
		    		case 1: //yellow
		    			colorBmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.yellow_on);
		    			break;
		    		case 2: //red
		    			colorBmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.red_on);
		    			break;
		    		case 3: //blue
		    			colorBmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.blue_on);
		    			break;
		    		case 4: //green
		    			colorBmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.green_on);
		    			break;
	    		}
	    		
	    		bmpCache.append((int)owcs.get(i).getID()+100, colorBmp);
			}
    		int topMargin = 10;
    		int rightMargin = 10;
	    	if(i/2 == 0)
	    	{
	    		topMargin = topMargin + colorBmp.getHeight() + 5;
	    	}
	    	if(i%2 == 0)
	    	{
	    		rightMargin = rightMargin + colorBmp.getWidth() + 5;
	    	}
	        float top = (topMargin)*resizeWidthPercentage;
	        float left = bmp1.getWidth() - (colorBmp.getWidth()+rightMargin)*resizeWidthPercentage;
	        mtx.postTranslate(left, top);
	        canvas.drawBitmap(colorBmp, mtx, paint);
	    	//retBmp = overlay(retBmp, colorBmp, topMargin, rightMargin);
    	}
    	
    	return bmOverlay;
    }
    
	protected int getIndependentWidth(int origWidth)
	{
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm); 
		return (int) FloatMath.ceil((origWidth*dm.widthPixels)/480.0f);
	}
	
	protected int getIndependentHeight(int origHeight)
	{
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm); 	
		return (int) FloatMath.ceil((origHeight*dm.heightPixels)/800.0f);
	}
}