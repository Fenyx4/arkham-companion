package ah.drawer.GUI;

import java.util.Random;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Encounter;
import ah.drawer.Location;
import ah.drawer.LocationCursor;
import ah.drawer.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class LocationList extends Activity {
	private ListView lv1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Init blah = new Init();
        lv1=(ListView)findViewById(R.id.ListView01);
        
        Bundle extras = getIntent().getExtras();
        long neiID = extras.getLong("neighborhood");
        
        Cursor cursor = new LocationCursor(AHFlyweightFactory.INSTANCE.getCurrentLocations(neiID));
        	
        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        //startManagingCursor(cursor);
 
        // the desired columns to be bound
        String[] columns = new String[] { "Name" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.name_entry };
 
        final Activity act = this;
        final Bundle bundle = new Bundle();
        final Random myRandom = new Random();
        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list_example_entry, cursor, columns, to);
        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
            	if(columnIndex == 1) {
            		//final LocationCursor locCurse = ((LocationCursor)cursor);
            		Button but = (Button) view;
            		but.setText(cursor.getString(columnIndex));
            		
            		but.setOnClickListener(new OnClickListener()
            		{
            			private Location loc = ((LocationCursor)cursor).getLocation();
            			//private ArrayList<Encounter> encounters = loc.getEncounters();
						@Override
						public void onClick(View arg0) {
							Log.i("Location", "Encounter Clicked");
							Encounter encounter = null; 
							
							Log.i("Location", "Location: " + loc.getLocationName());
							Log.i("Location", "Encounters: " + loc.getEncounters().size());
							if( loc.getEncounters().size() != 0 )
							{
								encounter = loc.getEncounters().get(myRandom.nextInt(loc.getEncounters().size()));
							}
							
							if(encounter != null)
							{
								Log.i("Location", "Encounter not null");
								bundle.putLong("encounter", encounter.getID());
								
								Intent i = new Intent(act, EncounterActivity.class);
								i.putExtras(bundle);
								act.startActivity(i);
							}
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
}