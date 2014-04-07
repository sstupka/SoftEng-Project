package com.example.physicssolver2;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PendulumActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		res = getResources();
		
		setContentView(R.layout.activity_pendulum);
		EditText t1=(EditText)findViewById(R.id.editText1);
		EditText t2=(EditText)findViewById(R.id.EditText2);
		t1.addTextChangedListener(updateAnswer);
		t2.addTextChangedListener(updateAnswer);

		Spinner solveFor=(Spinner)findViewById(R.id.spinner2);
		solveFor.setOnItemSelectedListener(updateSolveFor);
		
		Spinner units1=(Spinner)findViewById(R.id.spinner1);
		units1.setOnItemSelectedListener(updateUnits);
		Spinner units2=(Spinner)findViewById(R.id.spinner3);
		units2.setOnItemSelectedListener(updateUnits);
		Spinner units3=(Spinner)findViewById(R.id.spinner4);
		units3.setOnItemSelectedListener(updateUnits);
		Spinner units4=(Spinner)findViewById(R.id.spinner5);
		units4.setOnItemSelectedListener(updateUnits);
		Spinner units5=(Spinner)findViewById(R.id.spinner6);
		units5.setOnItemSelectedListener(updateUnits);
		Spinner units6=(Spinner)findViewById(R.id.spinner7);
		units6.setOnItemSelectedListener(updateUnits);

		TextView div2=(TextView)findViewById(R.id.textView6);
		TextView div3=(TextView)findViewById(R.id.textView7);
		units4.setVisibility(View.INVISIBLE);
		units6.setVisibility(View.INVISIBLE);
		div2.setVisibility(View.INVISIBLE);
		div3.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pendulum, menu);
		return true;
	}
	
	private void updateAll() {
		EditText t1=(EditText)findViewById(R.id.editText1);
		EditText t2=(EditText)findViewById(R.id.EditText2);
		if(t1.length()>0 && t2.length()>0) {
			float n1=Float.parseFloat(t1.getText().toString());
			float n2=Float.parseFloat(t2.getText().toString());

			String units1=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
			String units2=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
			String units3=((Spinner)findViewById(R.id.spinner4)).getSelectedItem().toString();
			String units5=((Spinner)findViewById(R.id.spinner6)).getSelectedItem().toString();
			String units6=((Spinner)findViewById(R.id.spinner7)).getSelectedItem().toString();
			
			EditText t3=(EditText)findViewById(R.id.EditText3);
			String solveFor=((Spinner)findViewById(R.id.spinner2)).getSelectedItem().toString();
			if(solveFor.equals("T (Period)")) {
				if(units1.equals("nm")) n1*=Math.pow(10,-9);
				if(units1.equals("μm")) n1*=Math.pow(10,-6);
				if(units1.equals("mm")) n1*=Math.pow(10,-3);
				if(units1.equals("cm")) n1*=Math.pow(10,-2);
				if(units1.equals("dm")) n1*=Math.pow(10,-1);
				if(units1.equals("m"))  ;
				if(units1.equals("km")) n1*=Math.pow(10,3);
				if(units1.equals("Mm")) n1*=Math.pow(10,6);
				if(units1.equals("Gm")) n1*=Math.pow(10,9);

				if(units2.equals("ns")) n1*=Math.pow(10,9);
				if(units2.equals("ms")) n1*=Math.pow(10,3);
				if(units2.equals("s"))  ;
				if(units2.equals("min")) n1/=60;
				if(units2.equals("hr")) n1/=60*60;
				if(units2.equals("day")) n1/=60*60*24;
				if(units2.equals("yr")) n1/=60*60*24*365;
				
				if(units3.equals("nm")) n2*=Math.pow(10,-9);
				if(units3.equals("μm")) n2*=Math.pow(10,-6);
				if(units3.equals("mm")) n2*=Math.pow(10,-3);
				if(units3.equals("cm")) n2*=Math.pow(10,-2);
				if(units3.equals("dm")) n2*=Math.pow(10,-1);
				if(units3.equals("m"))  ;
				if(units3.equals("km")) n2*=Math.pow(10,3);
				if(units3.equals("Mm")) n2*=Math.pow(10,6);
				if(units3.equals("Gm")) n2*=Math.pow(10,9);

				double n3=2*Math.PI*Math.sqrt(n2/n1);
				
				if(units5.equals("ns")) n3*=Math.pow(10,9);
				if(units5.equals("ms")) n3*=Math.pow(10,3);
				if(units5.equals("s"))  ;
				if(units5.equals("min")) n3/=60;
				if(units5.equals("hr")) n3/=60*60;
				if(units5.equals("day")) n3/=60*60*24;
				if(units5.equals("yr")) n3/=60*60*24*365;
				
				t3.setText(String.format("%.2e",n3));
			}
			if(solveFor.equals("L (Length)")) {
				if(units1.equals("nm")) n1*=Math.pow(10,-9);
				if(units1.equals("μm")) n1*=Math.pow(10,-6);
				if(units1.equals("mm")) n1*=Math.pow(10,-3);
				if(units1.equals("cm")) n1*=Math.pow(10,-2);
				if(units1.equals("dm")) n1*=Math.pow(10,-1);
				if(units1.equals("m"))  ;
				if(units1.equals("km")) n1*=Math.pow(10,3);
				if(units1.equals("Mm")) n1*=Math.pow(10,6);
				if(units1.equals("Gm")) n1*=Math.pow(10,9);

				if(units2.equals("ns")) n1*=Math.pow(10,9);
				if(units2.equals("ms")) n1*=Math.pow(10,3);
				if(units2.equals("s"))  ;
				if(units2.equals("min")) n1/=60;
				if(units2.equals("hr")) n1/=60*60;
				if(units2.equals("day")) n1/=60*60*24;
				if(units2.equals("yr")) n1/=60*60*24*365;

				if(units3.equals("ns")) n2/=Math.pow(10,9);
				if(units3.equals("ms")) n2/=Math.pow(10,3);
				if(units3.equals("s"))  ;
				if(units3.equals("min")) n2*=60;
				if(units3.equals("hr")) n2*=60*60;
				if(units3.equals("day")) n2*=60*60*24;
				if(units3.equals("yr")) n2*=60*60*24*365;

				double n3=n1*Math.pow(n2/2/Math.PI, 2);
				
				if(units5.equals("nm")) n3/=Math.pow(10,-9);
				if(units5.equals("μm")) n3/=Math.pow(10,-6);
				if(units5.equals("mm")) n3/=Math.pow(10,-3);
				if(units5.equals("cm")) n3/=Math.pow(10,-2);
				if(units5.equals("dm")) n3/=Math.pow(10,-1);
				if(units5.equals("m"))  ;
				if(units5.equals("km")) n3/=Math.pow(10,3);
				if(units5.equals("Mm")) n3/=Math.pow(10,6);
				if(units5.equals("Gm")) n3/=Math.pow(10,9);

				t3.setText(String.format("%.2e",n3));
			}
			if(solveFor.equals("g (Acceleration due to gravity)")) {
				if(units1.equals("ns")) n1/=Math.pow(10,9);
				if(units1.equals("ms")) n1/=Math.pow(10,3);
				if(units1.equals("s"))  ;
				if(units1.equals("min")) n1*=60;
				if(units1.equals("hr")) n1*=60*60;
				if(units1.equals("day")) n1*=60*60*24;
				if(units1.equals("yr")) n1*=60*60*24*365;
				
				if(units2.equals("nm")) n2*=Math.pow(10,-9);
				if(units2.equals("μm")) n2*=Math.pow(10,-6);
				if(units2.equals("mm")) n2*=Math.pow(10,-3);
				if(units2.equals("cm")) n2*=Math.pow(10,-2);
				if(units2.equals("dm")) n2*=Math.pow(10,-1);
				if(units2.equals("m"))  ;
				if(units2.equals("km")) n2*=Math.pow(10,3);
				if(units2.equals("Mm")) n2*=Math.pow(10,6);
				if(units2.equals("Gm")) n2*=Math.pow(10,9);

				double n3=Math.pow(2*Math.PI/n1, 2)/n2;
				
				if(units5.equals("nm")) n3/=Math.pow(10,-9);
				if(units5.equals("μm")) n3/=Math.pow(10,-6);
				if(units5.equals("mm")) n3/=Math.pow(10,-3);
				if(units5.equals("cm")) n3/=Math.pow(10,-2);
				if(units5.equals("dm")) n3/=Math.pow(10,-1);
				if(units5.equals("m"))  ;
				if(units5.equals("km")) n3/=Math.pow(10,3);
				if(units5.equals("Mm")) n3/=Math.pow(10,6);
				if(units5.equals("Gm")) n3/=Math.pow(10,9);

				if(units6.equals("ns")) n3/=Math.pow(10,9);
				if(units6.equals("ms")) n3/=Math.pow(10,3);
				if(units6.equals("s"))  ;
				if(units6.equals("min")) n3*=60;
				if(units6.equals("hr")) n3*=60*60;
				if(units6.equals("day")) n3*=60*60*24;
				if(units6.equals("yr")) n3*=60*60*24*365;

				t3.setText(String.format("%.2e",n3));
			}
		}
	}
	
	TextWatcher updateAnswer=new TextWatcher(){
		public void afterTextChanged(Editable s) {
			updateAll();
		}
		public void beforeTextChanged(CharSequence s, int start, int count, int after){}
		public void onTextChanged(CharSequence s, int start, int before, int count){}
	};

	AdapterView.OnItemSelectedListener updateUnits = new AdapterView.OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
	        updateAll();
	    }
	    public void onNothingSelected(AdapterView<?> adapterView) {} 
	};
	
	AdapterView.OnItemSelectedListener updateSolveFor = new AdapterView.OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
			String solveFor=((Spinner)findViewById(R.id.spinner2)).getSelectedItem().toString();
			if(solveFor.equals("T (Period)")) {
				TextView t1=(TextView)findViewById(R.id.textView4);
				TextView t2=(TextView)findViewById(R.id.TextView01);
				TextView t3=(TextView)findViewById(R.id.textView3);
				t1.setText("g");
				t2.setText("L");
				t3.setText("T");

				Spinner units1=(Spinner)findViewById(R.id.spinner1);
				ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.meterUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units1.setAdapter(spinnerAdapter1);
				spinnerAdapter1.notifyDataSetChanged();
				
				Spinner units3=(Spinner)findViewById(R.id.spinner4);
				ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.meterUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units3.setAdapter(spinnerAdapter2);
				spinnerAdapter2.notifyDataSetChanged();

				Spinner units5=(Spinner)findViewById(R.id.spinner6);
				ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.timeUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units5.setAdapter(spinnerAdapter3);
				spinnerAdapter3.notifyDataSetChanged();

				Spinner units2=(Spinner)findViewById(R.id.spinner3);
				Spinner units6=(Spinner)findViewById(R.id.spinner7);
				TextView div1=(TextView)findViewById(R.id.textView5);
				TextView div3=(TextView)findViewById(R.id.textView7);
				
				units2.setVisibility(View.VISIBLE);
				units6.setVisibility(View.INVISIBLE);
				div1.setVisibility(View.VISIBLE);
				div3.setVisibility(View.INVISIBLE);
			}
			if(solveFor.equals("L (Length)")) {
				TextView t1=(TextView)findViewById(R.id.textView4);
				TextView t2=(TextView)findViewById(R.id.TextView01);
				TextView t3=(TextView)findViewById(R.id.textView3);
				t1.setText("g");
				t2.setText("T");
				t3.setText("L");

				Spinner units1=(Spinner)findViewById(R.id.spinner1);
				ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.meterUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units1.setAdapter(spinnerAdapter1);
				spinnerAdapter1.notifyDataSetChanged();
				
				Spinner units3=(Spinner)findViewById(R.id.spinner4);
				ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.timeUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units3.setAdapter(spinnerAdapter2);
				spinnerAdapter2.notifyDataSetChanged();

				Spinner units5=(Spinner)findViewById(R.id.spinner6);
				ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.meterUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units5.setAdapter(spinnerAdapter3);
				spinnerAdapter3.notifyDataSetChanged();

				Spinner units2=(Spinner)findViewById(R.id.spinner3);
				Spinner units6=(Spinner)findViewById(R.id.spinner7);
				TextView div1=(TextView)findViewById(R.id.textView5);
				TextView div3=(TextView)findViewById(R.id.textView7);
				
				units2.setVisibility(View.VISIBLE);
				units6.setVisibility(View.INVISIBLE);
				div1.setVisibility(View.VISIBLE);
				div3.setVisibility(View.INVISIBLE);
			}
			if(solveFor.equals("g (Acceleration due to gravity)")) {
				TextView t1=(TextView)findViewById(R.id.textView4);
				TextView t2=(TextView)findViewById(R.id.TextView01);
				TextView t3=(TextView)findViewById(R.id.textView3);
				t1.setText("T");
				t2.setText("L");
				t3.setText("g");

				Spinner units1=(Spinner)findViewById(R.id.spinner1);
				ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.timeUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units1.setAdapter(spinnerAdapter1);
				spinnerAdapter1.notifyDataSetChanged();
				
				Spinner units3=(Spinner)findViewById(R.id.spinner4);
				ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.meterUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units3.setAdapter(spinnerAdapter2);
				spinnerAdapter2.notifyDataSetChanged();

				Spinner units5=(Spinner)findViewById(R.id.spinner6);
				ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, res.getStringArray(R.array.meterUnits)) {
					public View getView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getView(position, convertView, parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
					public View getDropDownView(int position, View convertView,ViewGroup parent) {
	                    View v = super.getDropDownView(position, convertView,parent);
	                    ((TextView) v).setTextColor(Color.parseColor("#000000"));
	                    return v;
	                }
				};
				spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				units5.setAdapter(spinnerAdapter3);
				spinnerAdapter3.notifyDataSetChanged();

				Spinner units2=(Spinner)findViewById(R.id.spinner3);
				Spinner units6=(Spinner)findViewById(R.id.spinner7);
				TextView div1=(TextView)findViewById(R.id.textView5);
				TextView div3=(TextView)findViewById(R.id.textView7);
				
				units2.setVisibility(View.INVISIBLE);
				units6.setVisibility(View.VISIBLE);
				div1.setVisibility(View.INVISIBLE);
				div3.setVisibility(View.VISIBLE);
			}
	        updateAll();
	    }
	    public void onNothingSelected(AdapterView<?> adapterView) {} 
	};
	Resources res;
}
