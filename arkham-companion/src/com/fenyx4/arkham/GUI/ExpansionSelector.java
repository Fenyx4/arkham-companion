package com.fenyx4.arkham.GUI;

import java.io.IOException;

import com.fenyx4.arkham.AHFlyweightFactory;
import com.fenyx4.arkham.Expansion;
import com.fenyx4.arkham.ExpansionCursor;
import com.fenyx4.arkham.GameState;
import com.fenyx4.arkham.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ExpansionSelector extends Activity {
	private ListView lv1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expansion);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        //GameState.getInstance().onRestoreInstanceState(savedInstanceState);
        
        lv1=(ListView)findViewById(R.id.ListView01);
        Cursor cursor = new ExpansionCursor(AHFlyweightFactory.INSTANCE.getExpansions());
        	
        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        //startManagingCursor(cursor);
 
        // the desired columns to be bound
        String[] columns = new String[] { "Checked" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.number_entry };
 
        //final Bundle bundle = new Bundle();
        //final Random myRandom = new Random();
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        //TODO replace the deprecated conctructor
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.checkboxlist, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	if(columnIndex == 2) {
            		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
            		
            		CheckBox cb = (CheckBox) view;
            		
            		Expansion exp = ((ExpansionCursor)cursor).getExpansion();
            		cb.setChecked(exp.getApplied());
            		
            		StateListDrawable myStates = new StateListDrawable();
            	    int stateChecked = android.R.attr.state_checked;

            	    Bitmap checkOffBMP;
					try {
						BitmapFactory.Options opts = new BitmapFactory.Options();
					    opts.inScaled = true;
					    opts.inDensity = 120;//DisplayMetrics.DENSITY_MEDIUM;
					    Rect padding = new Rect();
					    opts.inTargetDensity = view.getResources().getDisplayMetrics().densityDpi;
						checkOffBMP = BitmapFactory.decodeStream(getAssets().open(((ExpansionCursor)cursor).getExpansion().getCheckboxOffPath()), padding, opts);
					
	            	    BitmapDrawable checkOffDrawable = new BitmapDrawable(checkOffBMP);
	            	    myStates.addState(new int[]{ -stateChecked }, checkOffDrawable);
	            	    Bitmap checkOnBMP = BitmapFactory.decodeStream(getAssets().open(((ExpansionCursor)cursor).getExpansion().getCheckboxOnPath()), padding, opts);
	            	    BitmapDrawable checkOnDrawable = new BitmapDrawable(checkOnBMP);
	            	    myStates.addState(new int[]{ stateChecked }, checkOnDrawable);
	            	    cb.setButtonDrawable(myStates);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
            		cb.setTypeface(tf);
            		cb.setText(((ExpansionCursor)cursor).getExpansion().getName());
                    cb.setOnCheckedChangeListener(new OnCheckedChangeListener()
                    {
            			private Expansion exp = ((ExpansionCursor)cursor).getExpansion();
            			//private ArrayList<Encounter> encounters = loc.getEncounters();
						public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                        {
							GameState.getInstance().applyExpansion(exp.getID(), isChecked);
							//AHFlyweightFactory.INSTANCE.getCurrentLocations();
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
    
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//      super.onSaveInstanceState(savedInstanceState);
//      GameState.getInstance().onSaveInstanceState(savedInstanceState);
//      // Save UI state changes to the savedInstanceState.
//      // This bundle will be passed to onCreate if the process is
//      // killed and restarted.
////      savedInstanceState.putBoolean("MyBoolean", true);
////      savedInstanceState.putDouble("myDouble", 1.9);
////      savedInstanceState.putInt("MyInt", 1);
////      savedInstanceState.putString("MyString", "Welcome back to Android");
//      // etc.
//    }
    
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//      super.onRestoreInstanceState(savedInstanceState);
//      // Restore UI state from the savedInstanceState.
//      // This bundle has also been passed to onCreate.
//      GameState.getInstance().onRestoreInstanceState(savedInstanceState);
//    }
    
    public void openNeighborhood(View view)
    {
    	Intent i = new Intent(this, NeighborhoodSelector.class);
		this.startActivity(i);
    }
    
    public void openOW(View view)
    {
    	Intent i = new Intent(this, OtherworldSelector.class);
		this.startActivity(i);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.expansion_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                newGame();
                return true;
            case R.id.about_app:
            	about();
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    private void about()
    {
    	Intent i = new Intent(this, AboutActivity.class);
		this.startActivity(i);
    }
    

	private void newGame() {
		GameState.getInstance().newGame();
		lv1.setAdapter(lv1.getAdapter());
	}
}