package com.medha.imagesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends Activity {

	Spinner spinImageSize;
	Spinner spinColorFilter;
	Spinner spinImageType;
	EditText etSiteFilter;
	Button bSave;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		spinImageSize = (Spinner) findViewById(R.id.spinImageSize);
		spinColorFilter = (Spinner) findViewById(R.id.spinColorFilter);
		spinImageType = (Spinner) findViewById(R.id.spinImageType);
		etSiteFilter = (EditText) findViewById(R.id.etSiteFilter);
		bSave = (Button) findViewById(R.id.bSave);
		
		spinImageSize.setSelection(getIntent().getExtras().getInt("imgszPos"));
		spinColorFilter.setSelection(getIntent().getExtras().getInt("imgcolorPos"));
		spinImageType.setSelection(getIntent().getExtras().getInt("imgtypePos"));
		etSiteFilter.setText(getIntent().getExtras().getString("as_sitesearch"));
		
		bSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				  // Prepare data intent 
				  Intent data = new Intent();
				  data.putExtra("imgsz", spinImageSize.getSelectedItem().toString());
				  data.putExtra("imgcolor", spinColorFilter.getSelectedItem().toString());
				  data.putExtra("imgtype", spinImageType.getSelectedItem().toString());
				  data.putExtra("as_sitesearch", etSiteFilter.getText().toString());
				  
				  data.putExtra("imgszPos", spinImageSize.getSelectedItemPosition());
				  data.putExtra("imgcolorPos", spinColorFilter.getSelectedItemPosition());
				  data.putExtra("imgtypePos", spinImageType.getSelectedItemPosition());
				  
				  // Activity finished ok, return the data
				  setResult(1, data); // set result code and bundle data for response
				  finish(); // closes the activity, pass data to parent
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

}
