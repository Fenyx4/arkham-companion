package ah.drawer.GUI;

import java.util.ArrayList;

import ah.drawer.AHFlyweightFactory;
import ah.drawer.Card;
import ah.drawer.CardCursor;
import ah.drawer.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

public class LocationDeckActivity extends Activity {
	//private Encounter encounter;
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationdeck);
        
        Bundle extras = getIntent().getExtras();

        long neiID = extras.getLong("neighborhood");
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new CardAdapter(this, AHFlyweightFactory.INSTANCE.getCards(neiID)));

	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(LocationDeckActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
        
    }

    public class CardAdapter extends BaseAdapter {
	    //int mGalleryItemBackground;
	    private Context mContext;

	    private ArrayList<Card> cardArr;

	    public CardAdapter(Context c, ArrayList<Card> cardArr) 
	    {
	        mContext = c;
	        this.cardArr = cardArr;
	        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
	        
	        Log.w("AHDecks", cardArr.size() + " cards in deck.");
	        
	        //mGalleryItemBackground = attr.getResourceId(
	        //        R.styleable.HelloGallery_android_galleryItemBackground, 0);
	        attr.recycle();
	    }

	    public int getCount() {
	        return cardArr.size();
	    }

	    public Object getItem(int position) {
	        return cardArr.get(position);
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) 
	    {
	    	LinearLayout layout = new LinearLayout(getApplicationContext());
	        layout.setOrientation(LinearLayout.VERTICAL);
	        layout.setLayoutParams(new Gallery.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
	        layout.setBackgroundResource(R.drawable.encounter_front);
	        
	        TextView tv = new TextView(mContext);

	        String titolo = "";

	        if (position == 0) {
	            titolo = "The guards of the sanitarium are aware that there is an intruder. Make a Sneak (-1) check to escape. If you pass, move to the street. If you fail, you are arrested and taken to the Police Station.";
	        } else if (position == 1) {
	            titolo = "You are mistaken for an inmate. Doctor Mintz has the guards subdue you and conducts an experiment. Make a Will (-1) [2] check to discover the results. If you pass, the injections seem to increase your capacity for learning. Draw 1 Skill. If you fail, his memory drug fails miserably, resulting in lost knowledge. You must discard one of the following (your choice), if able: 4 Clue tokens, or 2 Spells, or 1 Skill.";
	        } else if (position == 2) {
	            titolo = "i Servizi";
	        }
	        else
	        {
	        	titolo = "Blah";
	        }

	        tv.setText(titolo);
	        tv.setGravity(Gravity.TOP);

	        // Utilizzo l'AssetManager per cambiare il font
	        AssetManager assetManager = getResources().getAssets();
	        //Typeface typeface = Typeface.createFromAsset(assetManager,
	        //        "fonts/CALIFR.TTF");
	        //tv.setTypeface(typeface);
	        tv.setTextSize(12);
	        tv.setPadding(45, 50, 45, 40); 
	       
	        DisplayMetrics dm = new DisplayMetrics();
	        getWindowManager().getDefaultDisplay().getMetrics(dm);
	       
	        tv.setWidth(dm.widthPixels );
	        //tv.setHeight(dm.heightPixels);
	        tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1f));
	    	
	        layout.addView(tv);

	        return layout;
	    }
	}
}
