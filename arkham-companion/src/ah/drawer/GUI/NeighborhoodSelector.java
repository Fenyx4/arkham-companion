package ah.drawer.GUI;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Neighborhood;
import ah.drawer.NeighborhoodCursor;
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

public class NeighborhoodSelector extends Activity {
	private ListView lv1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
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
        String[] columns = new String[] { "Name" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.name_entry };
 
        final Activity act = this;
        final Bundle bundle = new Bundle();
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
            			private Neighborhood nei = ((NeighborhoodCursor)cursor).getNeighborhood();
            			//private ArrayList<Encounter> encounters = loc.getEncounters();
						@Override
						public void onClick(View arg0) {
							Log.i("Neighborhood", "Neighborhood Clicked");
							bundle.putLong("neighborhood", nei.getID());

							Intent i = new Intent(act, LocationList.class);
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
}