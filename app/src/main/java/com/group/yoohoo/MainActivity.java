package com.group.yoohoo;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText et;
	ImageButton btn;
	TextView tv;
	public static String keyword;
	SMSProcessor keywordStore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView)findViewById(R.id.textbox1);

		et = (EditText)findViewById(R.id.editText1);

		//Set text on EditText box from SharedPrefernces
		SharedPreferences settings = getSharedPreferences("KeywordStorage",0);
//Open SharedPreferences file named "KeywordStorage". If it does not exist,
		//create it.
		keyword = settings.getString("KeyWord", "TeamC13Rockz");
		et.setText(keyword);


		btn = (ImageButton)findViewById(R.id.imageButton2);
		btn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0)
//events inside this method occur in sequence when the button is clicked.
			{
				// TODO Auto-generated method stub

				keyword = et.getText().toString();	
//Store the string in the EditText box 'et' in the String variable 'keyword'


				//Store the freshly set keyword in SharedPrefernces
				SharedPreferences settings = getSharedPreferences("KeywordStorage",0); //Open the same SharedPreferences file as above
				SharedPreferences.Editor editor = settings.edit(); 
				//call the edit method that returns to the editor instance
				editor.putString("KeyWord", keyword); 
//Open the string with the key/name - "KeyWord". If it doesn't exist, create it. 
				//Put the value of the variable "keyword" in it.
				editor.commit(); //commit or save the edit

				//Toast to show new keyword has been set
Toast toast = Toast.makeText(MainActivity.this, "Key Phrase '"+keyword+"' has been set.", Toast.LENGTH_LONG);
				toast.show();

			}

		});


	}





	

}
