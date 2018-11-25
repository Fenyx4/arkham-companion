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
package com.example.fenyx4.navigationviewtest.GUI;

import java.io.IOException;

import com.example.fenyx4.navigationviewtest.AHFlyweightFactory;
import com.example.fenyx4.navigationviewtest.Expansion;
import com.example.fenyx4.navigationviewtest.ExpansionCursor;
import com.example.fenyx4.navigationviewtest.GameState;
import com.example.fenyx4.navigationviewtest.R;
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
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;

import android.util.Log;

public class ExpansionSelector extends Fragment {
    private ListView lv1;
    /** Called when the activity is first created. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("Testing","Sup I am in ExpansionSelector!!!");
        return inflater.inflate(R.layout.content_main, container, false);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Log.i("Testing","Sup I am in ExpansionSelector!!!");
//        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
//
//        //GameState.getInstance().onRestoreInstanceState(savedInstanceState);
//
//        lv1=(ListView)findViewById(R.id.ListView01);
//        Cursor cursor = new ExpansionCursor(AHFlyweightFactory.INSTANCE.getExpansions());
//
//        //Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
//        //startManagingCursor(cursor);
//
//        // the desired columns to be bound
//        String[] columns = new String[] { "Checked" };
//        // the XML defined views which the data will be bound to
//        int[] to = new int[] { R.id.number_entry };
//
//        //final Bundle bundle = new Bundle();
//        //final Random myRandom = new Random();
//        // create the adapter using the cursor pointing to the desired data as well as the layout information
//        //TODO replace the deprecated conctructor
//        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.checkboxlist, cursor, columns, to);
//        //SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(/* ur stuff */);
//        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
//            public boolean setViewValue(View view, final Cursor cursor, int columnIndex) {
//                if(columnIndex == 2) {
//                    Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/se-caslon-ant.ttf");
//
//                    CheckBox cb = (CheckBox) view;
//                    //Checkbox view is reused when scrolling. Removed previous check listener or things will check and uncheck randomly.
//                    cb.setOnCheckedChangeListener(null);
//                    Expansion exp = ((ExpansionCursor)cursor).getExpansion();
//                    cb.setChecked(exp.getApplied());
//
//                    StateListDrawable myStates = new StateListDrawable();
//                    int stateChecked = android.R.attr.state_checked;
//
//                    Bitmap checkOffBMP;
//                    try {
//                        BitmapFactory.Options opts = new BitmapFactory.Options();
//                        opts.inScaled = true;
//                        opts.inDensity = 120;//DisplayMetrics.DENSITY_MEDIUM;
//                        Rect padding = new Rect();
//                        opts.inTargetDensity = view.getResources().getDisplayMetrics().densityDpi;
//                        checkOffBMP = BitmapFactory.decodeStream(getAssets().open(((ExpansionCursor)cursor).getExpansion().getCheckboxOffPath()), padding, opts);
//
//                        BitmapDrawable checkOffDrawable = new BitmapDrawable(checkOffBMP);
//                        myStates.addState(new int[]{ -stateChecked }, checkOffDrawable);
//                        Bitmap checkOnBMP = BitmapFactory.decodeStream(getAssets().open(((ExpansionCursor)cursor).getExpansion().getCheckboxOnPath()), padding, opts);
//                        BitmapDrawable checkOnDrawable = new BitmapDrawable(checkOnBMP);
//                        myStates.addState(new int[]{ stateChecked }, checkOnDrawable);
//                        cb.setButtonDrawable(myStates);
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//
//                    cb.setTypeface(tf);
//                    cb.setText(((ExpansionCursor)cursor).getExpansion().getName());
//                    cb.setOnCheckedChangeListener(new OnCheckedChangeListener()
//                    {
//                        private Expansion exp = ((ExpansionCursor)cursor).getExpansion();
//                        //private ArrayList<Encounter> encounters = loc.getEncounters();
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
//                        {
//                            GameState.getInstance().applyExpansion(exp.getID(), isChecked);
//                            //AHFlyweightFactory.INSTANCE.getCurrentLocations();
//                        }
//
//                    });
//
//                    return true;
//                }
//
//                return false;
//            }
//        });
//
//
//        // set this adapter as your ListActivity's adapter
//        lv1.setAdapter(mAdapter);

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
        //Intent i = new Intent(this, NeighborhoodSelector.class);
        //this.startActivity(i);
    }

    public void openOW(View view)
    {
        //Intent i = new Intent(this, OtherworldSelector.class);
        //this.startActivity(i);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //MenuInflater inflater = getMenuInflater();
//        //inflater.inflate(R.menu.expansion_menu, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        /*switch (item.getItemId()) {
            case R.id.new_game:
                newGame();
                return true;
            case R.id.about_app:
                about();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
        return true;
    }

    private void about()
    {
        //Intent i = new Intent(this, AboutActivity.class);
        //this.startActivity(i);
    }


    private void newGame() {
        GameState.getInstance().newGame();
        lv1.setAdapter(lv1.getAdapter());
    }
}