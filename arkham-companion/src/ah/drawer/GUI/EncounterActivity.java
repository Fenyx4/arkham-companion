package ah.drawer.GUI;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.R;
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
