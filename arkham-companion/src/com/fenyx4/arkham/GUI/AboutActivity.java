package com.fenyx4.arkham.GUI;

import com.fenyx4.arkham.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        TextView GPL = (TextView)findViewById(R.id.tvGPL);
        
        GPL.setText(Html.fromHtml(getString(R.string.GPL)));
    }
}
