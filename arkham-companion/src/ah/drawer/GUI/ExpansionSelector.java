package ah.drawer.GUI;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Expansion;
import ah.drawer.ExpansionCursor;
import ah.drawer.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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
        
        lv1=(ListView)findViewById(R.id.ListView01);
        Cursor cursor = new ExpansionCursor(AHFlyweightFactory.INSTANCE.getExpansions(this.getApplicationContext()));
        	
        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        //startManagingCursor(cursor);
 
        // the desired columns to be bound
        String[] columns = new String[] { "Checked", "Name" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.number_entry,R.id.name_entry };
 
        //final Bundle bundle = new Bundle();
        //final Random myRandom = new Random();
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.checkboxlist, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	if(columnIndex == 2) {
            		
            		CheckBox cb = (CheckBox) view;
            		cb.setText(((ExpansionCursor)cursor).getExpansion().getName());
                    cb.setOnCheckedChangeListener(new OnCheckedChangeListener()
                    {
            			private Expansion exp = ((ExpansionCursor)cursor).getExpansion();
            			//private ArrayList<Encounter> encounters = loc.getEncounters();
						@Override
						public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                        {
							AHFlyweightFactory.INSTANCE.applyExpansion(exp.getID(), isChecked);
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
    
    public void openNeighborhood(View view)
    {
    	Intent i = new Intent(this, NeighborhoodSelector.class);
		this.startActivity(i);
    }
}