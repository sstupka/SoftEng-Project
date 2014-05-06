package com.example.physicssolver2;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ImpulseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.impulseactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t5=(EditText)findViewById(R.id.editText5);
        t5.addTextChangedListener(updateAnswer);
        EditText t7=(EditText)findViewById(R.id.editText7);
        t7.addTextChangedListener(updateAnswer);
        Spinner units3=(Spinner)findViewById(R.id.spinner3);
        units3.setOnItemSelectedListener(updateUnits);
        Spinner units4=(Spinner)findViewById(R.id.spinner4);
        units4.setOnItemSelectedListener(updateUnits);
        Spinner units6=(Spinner)findViewById(R.id.spinner6);
        units6.setOnItemSelectedListener(updateUnits);
        Spinner units8=(Spinner)findViewById(R.id.spinner8);
        units8.setOnItemSelectedListener(updateUnits);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pendulum, menu);
        return true;
    }

    TextWatcher updateAnswer=new TextWatcher(){
        private String old="";

        public void afterTextChanged(Editable s) {
            if(!s.toString().equals(old)) { //Prevents recursion here.
                updateAll();
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after){
            old=s.toString();
        }
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
            updateAll();
        }
        public void onNothingSelected(AdapterView<?> adapterView) {} 
    };
    
    private void updateAll() {
        EditText t2=(EditText)findViewById(R.id.editText2);
        EditText t5=(EditText)findViewById(R.id.editText5);
        EditText t7=(EditText)findViewById(R.id.editText7);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units4=((Spinner)findViewById(R.id.spinner4)).getSelectedItem().toString();
        String units6=((Spinner)findViewById(R.id.spinner6)).getSelectedItem().toString();
        String units8=((Spinner)findViewById(R.id.spinner8)).getSelectedItem().toString();
        if(solveFor.equals("J (Impulse)") && t5.length()>0 && t7.length()>0) {

            float n1;
            try {
                n1=Float.parseFloat(t5.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units6.equals("nN")) n1*=Math.pow(10,-9);
            if(units6.equals("μN")) n1*=Math.pow(10,-6);
            if(units6.equals("mN")) n1*=Math.pow(10,-3);
            if(units6.equals("cN")) n1*=Math.pow(10,-2);
            if(units6.equals("dN")) n1*=Math.pow(10,-1);
            if(units6.equals("N"))  ;
            if(units6.equals("kN")) n1*=Math.pow(10,3);
            if(units6.equals("MN")) n1*=Math.pow(10,6);
            if(units6.equals("GN")) n1*=Math.pow(10,9);

            float n2;
            try {
                n2=Float.parseFloat(t7.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }
                
            if(units8.equals("ns")) n2*=Math.pow(10,9);
            if(units8.equals("ms")) n2*=Math.pow(10,3);
            if(units8.equals("s"))  ;
            if(units8.equals("min")) n2*=1.0/(60);
            if(units8.equals("hr")) n2*=1.0/(60*60);
            if(units8.equals("day")) n2*=1.0/(60*60*24);
            if(units8.equals("yr")) n2*=1.0/(60*60*24*365);

            double n_=n1*n2;

            if(units3.equals("nN")) n_/=Math.pow(10,-9);
            if(units3.equals("μN")) n_/=Math.pow(10,-6);
            if(units3.equals("mN")) n_/=Math.pow(10,-3);
            if(units3.equals("cN")) n_/=Math.pow(10,-2);
            if(units3.equals("dN")) n_/=Math.pow(10,-1);
            if(units3.equals("N"))  ;
            if(units3.equals("kN")) n_/=Math.pow(10,3);
            if(units3.equals("MN")) n_/=Math.pow(10,6);
            if(units3.equals("GN")) n_/=Math.pow(10,9);
                
            if(units4.equals("ns")) n_/=Math.pow(10,9);
            if(units4.equals("ms")) n_/=Math.pow(10,3);
            if(units4.equals("s"))  ;
            if(units4.equals("min")) n_/=1.0/(60);
            if(units4.equals("hr")) n_/=1.0/(60*60);
            if(units4.equals("day")) n_/=1.0/(60*60*24);
            if(units4.equals("yr")) n_/=1.0/(60*60*24*365);

            t2.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("F (Applied force)") && t2.length()>0 && t7.length()>0) {

            float n0;
            try {
                n0=Float.parseFloat(t2.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units3.equals("nN")) n0*=Math.pow(10,-9);
            if(units3.equals("μN")) n0*=Math.pow(10,-6);
            if(units3.equals("mN")) n0*=Math.pow(10,-3);
            if(units3.equals("cN")) n0*=Math.pow(10,-2);
            if(units3.equals("dN")) n0*=Math.pow(10,-1);
            if(units3.equals("N"))  ;
            if(units3.equals("kN")) n0*=Math.pow(10,3);
            if(units3.equals("MN")) n0*=Math.pow(10,6);
            if(units3.equals("GN")) n0*=Math.pow(10,9);
                
            if(units4.equals("ns")) n0*=Math.pow(10,9);
            if(units4.equals("ms")) n0*=Math.pow(10,3);
            if(units4.equals("s"))  ;
            if(units4.equals("min")) n0*=1.0/(60);
            if(units4.equals("hr")) n0*=1.0/(60*60);
            if(units4.equals("day")) n0*=1.0/(60*60*24);
            if(units4.equals("yr")) n0*=1.0/(60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t7.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }
                
            if(units8.equals("ns")) n2*=Math.pow(10,9);
            if(units8.equals("ms")) n2*=Math.pow(10,3);
            if(units8.equals("s"))  ;
            if(units8.equals("min")) n2*=1.0/(60);
            if(units8.equals("hr")) n2*=1.0/(60*60);
            if(units8.equals("day")) n2*=1.0/(60*60*24);
            if(units8.equals("yr")) n2*=1.0/(60*60*24*365);

            double n_=n0/n2;

            if(units6.equals("nN")) n_/=Math.pow(10,-9);
            if(units6.equals("μN")) n_/=Math.pow(10,-6);
            if(units6.equals("mN")) n_/=Math.pow(10,-3);
            if(units6.equals("cN")) n_/=Math.pow(10,-2);
            if(units6.equals("dN")) n_/=Math.pow(10,-1);
            if(units6.equals("N"))  ;
            if(units6.equals("kN")) n_/=Math.pow(10,3);
            if(units6.equals("MN")) n_/=Math.pow(10,6);
            if(units6.equals("GN")) n_/=Math.pow(10,9);

            t5.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("t (Time elapsed)") && t2.length()>0 && t5.length()>0) {

            float n0;
            try {
                n0=Float.parseFloat(t2.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units3.equals("nN")) n0*=Math.pow(10,-9);
            if(units3.equals("μN")) n0*=Math.pow(10,-6);
            if(units3.equals("mN")) n0*=Math.pow(10,-3);
            if(units3.equals("cN")) n0*=Math.pow(10,-2);
            if(units3.equals("dN")) n0*=Math.pow(10,-1);
            if(units3.equals("N"))  ;
            if(units3.equals("kN")) n0*=Math.pow(10,3);
            if(units3.equals("MN")) n0*=Math.pow(10,6);
            if(units3.equals("GN")) n0*=Math.pow(10,9);
                
            if(units4.equals("ns")) n0*=Math.pow(10,9);
            if(units4.equals("ms")) n0*=Math.pow(10,3);
            if(units4.equals("s"))  ;
            if(units4.equals("min")) n0*=1.0/(60);
            if(units4.equals("hr")) n0*=1.0/(60*60);
            if(units4.equals("day")) n0*=1.0/(60*60*24);
            if(units4.equals("yr")) n0*=1.0/(60*60*24*365);

            float n1;
            try {
                n1=Float.parseFloat(t5.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units6.equals("nN")) n1*=Math.pow(10,-9);
            if(units6.equals("μN")) n1*=Math.pow(10,-6);
            if(units6.equals("mN")) n1*=Math.pow(10,-3);
            if(units6.equals("cN")) n1*=Math.pow(10,-2);
            if(units6.equals("dN")) n1*=Math.pow(10,-1);
            if(units6.equals("N"))  ;
            if(units6.equals("kN")) n1*=Math.pow(10,3);
            if(units6.equals("MN")) n1*=Math.pow(10,6);
            if(units6.equals("GN")) n1*=Math.pow(10,9);

            double n_=n0/n1;
                
            if(units8.equals("ns")) n_/=Math.pow(10,9);
            if(units8.equals("ms")) n_/=Math.pow(10,3);
            if(units8.equals("s"))  ;
            if(units8.equals("min")) n_/=1.0/(60);
            if(units8.equals("hr")) n_/=1.0/(60*60);
            if(units8.equals("day")) n_/=1.0/(60*60*24);
            if(units8.equals("yr")) n_/=1.0/(60*60*24*365);

            t7.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}