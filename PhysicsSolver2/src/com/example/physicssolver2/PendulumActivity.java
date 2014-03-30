package com.example.physicssolver2;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PendulumActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pendulum);
		EditText t1=(EditText)findViewById(R.id.editText1);
		EditText t2=(EditText)findViewById(R.id.EditText2);
		t1.addTextChangedListener(updateAnswer);
		t2.addTextChangedListener(updateAnswer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pendulum, menu);
		return true;
	}
	
	TextWatcher updateAnswer=new TextWatcher(){
		public void afterTextChanged(Editable s) {
			EditText t1=(EditText)findViewById(R.id.editText1);
			EditText t2=(EditText)findViewById(R.id.EditText2);
			if(t1.length()>0 && t2.length()>0) {
				EditText t3=(EditText)findViewById(R.id.EditText3);
				RadioButton bT=(RadioButton)findViewById(R.id.radio0);
				RadioButton bL=(RadioButton)findViewById(R.id.radio1);
				RadioButton bg=(RadioButton)findViewById(R.id.radio2);
				if(bT.isChecked()) {
					t3.setText(String.format("%f",2*Math.PI*Math.sqrt(Float.parseFloat(t2.getText().toString())/Float.parseFloat(t1.getText().toString()))));
				}
				if(bL.isChecked()) {
					t3.setText(String.format("%f",Float.parseFloat(t1.getText().toString())*Math.pow(Float.parseFloat(t2.getText().toString())/2/Math.PI, 2)));
				}
				if(bg.isChecked()) {
					t3.setText(String.format("%f",Math.pow(2*Math.PI/Float.parseFloat(t1.getText().toString()), 2)/Float.parseFloat(t2.getText().toString())));
				}
			}
		}
		public void beforeTextChanged(CharSequence s, int start, int count, int after){}
		public void onTextChanged(CharSequence s, int start, int before, int count){}
	};

	public void solveForT(View view) {
		TextView t1=(TextView)findViewById(R.id.textView4);
		TextView t2=(TextView)findViewById(R.id.TextView01);
		TextView t3=(TextView)findViewById(R.id.textView3);
		t1.setText("g");
		t2.setText("L");
		t3.setText("T");
	}
	
	public void solveForL(View view) {
		TextView t1=(TextView)findViewById(R.id.textView4);
		TextView t2=(TextView)findViewById(R.id.TextView01);
		TextView t3=(TextView)findViewById(R.id.textView3);
		t1.setText("g");
		t2.setText("T");
		t3.setText("L");
	}
	
	public void solveForG(View view) {
		TextView t1=(TextView)findViewById(R.id.textView4);
		TextView t2=(TextView)findViewById(R.id.TextView01);
		TextView t3=(TextView)findViewById(R.id.textView3);
		t1.setText("T");
		t2.setText("L");
		t3.setText("g");
	}

}
