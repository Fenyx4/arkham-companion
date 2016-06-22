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

import com.fenyx4.arkham.AHFlyweightFactory;
import com.fenyx4.arkham.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EncounterActivity extends Activity {
	private TextView tv1;
	//private Encounter encounter;
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encounter);
        
        AHFlyweightFactory.INSTANCE.Init(this.getApplicationContext());
        
        tv1=(TextView)findViewById(R.id.textView01);
        
        Bundle extras = getIntent().getExtras();

        long encID = extras.getLong("encounter");
        
        tv1.setText(AHFlyweightFactory.INSTANCE.getEncounterText(encID));
        
    }

    /*
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public Encounter getEncounter() {
		return encounter;
	}
	*/
}
