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

public class MomentumActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.momentumactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t7=(EditText)findViewById(R.id.editText7);
        t7.addTextChangedListener(updateAnswer);
        EditText t9=(EditText)findViewById(R.id.editText9);
        t9.addTextChangedListener(updateAnswer);
        Spinner units3=(Spinner)findViewById(R.id.spinner3);
        units3.setOnItemSelectedListener(updateUnits);
        Spinner units4=(Spinner)findViewById(R.id.spinner4);
        units4.setOnItemSelectedListener(updateUnits);
        Spinner units6=(Spinner)findViewById(R.id.spinner6);
        units6.setOnItemSelectedListener(updateUnits);
        Spinner units8=(Spinner)findViewById(R.id.spinner8);
        units8.setOnItemSelectedListener(updateUnits);
        Spinner units10=(Spinner)findViewById(R.id.spinner10);
        units10.setOnItemSelectedListener(updateUnits);
        Spinner units12=(Spinner)findViewById(R.id.spinner12);
        units12.setOnItemSelectedListener(updateUnits);
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
        EditText t7=(EditText)findViewById(R.id.editText7);
        EditText t9=(EditText)findViewById(R.id.editText9);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units4=((Spinner)findViewById(R.id.spinner4)).getSelectedItem().toString();
        String units6=((Spinner)findViewById(R.id.spinner6)).getSelectedItem().toString();
        String units8=((Spinner)findViewById(R.id.spinner8)).getSelectedItem().toString();
        String units10=((Spinner)findViewById(R.id.spinner10)).getSelectedItem().toString();
        String units12=((Spinner)findViewById(R.id.spinner12)).getSelectedItem().toString();
        if(solveFor.equals("p (Momentum)") && t7.length()>0 && t9.length()>0) {

            float n1;
            try {
                n1=Float.parseFloat(t7.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units8.equals("ng")) n1*=Math.pow(10,-12);
            if(units8.equals("μg")) n1*=Math.pow(10,-9);
            if(units8.equals("mg")) n1*=Math.pow(10,-6);
            if(units8.equals("g"))  n1*=Math.pow(10,-3);
            if(units8.equals("kg")) ;
            if(units8.equals("Mg")) n1*=Math.pow(10,3);
            if(units8.equals("Gg")) n1*=Math.pow(10,6);

            float n2;
            try {
                n2=Float.parseFloat(t9.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units10.equals("nm")) n2*=Math.pow(10,-9);
            if(units10.equals("μm")) n2*=Math.pow(10,-6);
            if(units10.equals("mm")) n2*=Math.pow(10,-3);
            if(units10.equals("cm")) n2*=Math.pow(10,-2);
            if(units10.equals("dm")) n2*=Math.pow(10,-1);
            if(units10.equals("m"))  ;
            if(units10.equals("km")) n2*=Math.pow(10,3);
            if(units10.equals("Mm")) n2*=Math.pow(10,6);
            if(units10.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units12.equals("ns")) n2/=Math.pow(10,-9);
            if(units12.equals("ms")) n2/=Math.pow(10,-3);
            if(units12.equals("s"))  ;
            if(units12.equals("min")) n2/=(60);
            if(units12.equals("hr")) n2/=(60*60);
            if(units12.equals("day")) n2/=(60*60*24);
            if(units12.equals("yr")) n2/=(60*60*24*365);

            double n_=n1*n2;

            if(units3.equals("ng")) n_/=Math.pow(10,-12);
            if(units3.equals("μg")) n_/=Math.pow(10,-9);
            if(units3.equals("mg")) n_/=Math.pow(10,-6);
            if(units3.equals("g"))  n_/=Math.pow(10,-3);
            if(units3.equals("kg")) ;
            if(units3.equals("Mg")) n_/=Math.pow(10,3);
            if(units3.equals("Gg")) n_/=Math.pow(10,6);

            if(units4.equals("nm")) n_/=Math.pow(10,-9);
            if(units4.equals("μm")) n_/=Math.pow(10,-6);
            if(units4.equals("mm")) n_/=Math.pow(10,-3);
            if(units4.equals("cm")) n_/=Math.pow(10,-2);
            if(units4.equals("dm")) n_/=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n_/=Math.pow(10,3);
            if(units4.equals("Mm")) n_/=Math.pow(10,6);
            if(units4.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units6.equals("ns")) n_*=Math.pow(10,-9);
            if(units6.equals("ms")) n_*=Math.pow(10,-3);
            if(units6.equals("s"))  ;
            if(units6.equals("min")) n_*=(60);
            if(units6.equals("hr")) n_*=(60*60);
            if(units6.equals("day")) n_*=(60*60*24);
            if(units6.equals("yr")) n_*=(60*60*24*365);

            t2.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("m (Mass)") && t2.length()>0 && t9.length()>0) {

            float n0;
            try {
                n0=Float.parseFloat(t2.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units3.equals("ng")) n0*=Math.pow(10,-12);
            if(units3.equals("μg")) n0*=Math.pow(10,-9);
            if(units3.equals("mg")) n0*=Math.pow(10,-6);
            if(units3.equals("g"))  n0*=Math.pow(10,-3);
            if(units3.equals("kg")) ;
            if(units3.equals("Mg")) n0*=Math.pow(10,3);
            if(units3.equals("Gg")) n0*=Math.pow(10,6);

            if(units4.equals("nm")) n0*=Math.pow(10,-9);
            if(units4.equals("μm")) n0*=Math.pow(10,-6);
            if(units4.equals("mm")) n0*=Math.pow(10,-3);
            if(units4.equals("cm")) n0*=Math.pow(10,-2);
            if(units4.equals("dm")) n0*=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n0*=Math.pow(10,3);
            if(units4.equals("Mm")) n0*=Math.pow(10,6);
            if(units4.equals("Gm")) n0*=Math.pow(10,9);
                
            if(units6.equals("ns")) n0/=Math.pow(10,-9);
            if(units6.equals("ms")) n0/=Math.pow(10,-3);
            if(units6.equals("s"))  ;
            if(units6.equals("min")) n0/=(60);
            if(units6.equals("hr")) n0/=(60*60);
            if(units6.equals("day")) n0/=(60*60*24);
            if(units6.equals("yr")) n0/=(60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t9.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units10.equals("nm")) n2*=Math.pow(10,-9);
            if(units10.equals("μm")) n2*=Math.pow(10,-6);
            if(units10.equals("mm")) n2*=Math.pow(10,-3);
            if(units10.equals("cm")) n2*=Math.pow(10,-2);
            if(units10.equals("dm")) n2*=Math.pow(10,-1);
            if(units10.equals("m"))  ;
            if(units10.equals("km")) n2*=Math.pow(10,3);
            if(units10.equals("Mm")) n2*=Math.pow(10,6);
            if(units10.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units12.equals("ns")) n2/=Math.pow(10,-9);
            if(units12.equals("ms")) n2/=Math.pow(10,-3);
            if(units12.equals("s"))  ;
            if(units12.equals("min")) n2/=(60);
            if(units12.equals("hr")) n2/=(60*60);
            if(units12.equals("day")) n2/=(60*60*24);
            if(units12.equals("yr")) n2/=(60*60*24*365);

            double n_=n0/n2;

            if(units8.equals("ng")) n_/=Math.pow(10,-12);
            if(units8.equals("μg")) n_/=Math.pow(10,-9);
            if(units8.equals("mg")) n_/=Math.pow(10,-6);
            if(units8.equals("g"))  n_/=Math.pow(10,-3);
            if(units8.equals("kg")) ;
            if(units8.equals("Mg")) n_/=Math.pow(10,3);
            if(units8.equals("Gg")) n_/=Math.pow(10,6);

            t7.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("v (Velocity)") && t2.length()>0 && t7.length()>0) {

            float n0;
            try {
                n0=Float.parseFloat(t2.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units3.equals("ng")) n0*=Math.pow(10,-12);
            if(units3.equals("μg")) n0*=Math.pow(10,-9);
            if(units3.equals("mg")) n0*=Math.pow(10,-6);
            if(units3.equals("g"))  n0*=Math.pow(10,-3);
            if(units3.equals("kg")) ;
            if(units3.equals("Mg")) n0*=Math.pow(10,3);
            if(units3.equals("Gg")) n0*=Math.pow(10,6);

            if(units4.equals("nm")) n0*=Math.pow(10,-9);
            if(units4.equals("μm")) n0*=Math.pow(10,-6);
            if(units4.equals("mm")) n0*=Math.pow(10,-3);
            if(units4.equals("cm")) n0*=Math.pow(10,-2);
            if(units4.equals("dm")) n0*=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n0*=Math.pow(10,3);
            if(units4.equals("Mm")) n0*=Math.pow(10,6);
            if(units4.equals("Gm")) n0*=Math.pow(10,9);
                
            if(units6.equals("ns")) n0/=Math.pow(10,-9);
            if(units6.equals("ms")) n0/=Math.pow(10,-3);
            if(units6.equals("s"))  ;
            if(units6.equals("min")) n0/=(60);
            if(units6.equals("hr")) n0/=(60*60);
            if(units6.equals("day")) n0/=(60*60*24);
            if(units6.equals("yr")) n0/=(60*60*24*365);

            float n1;
            try {
                n1=Float.parseFloat(t7.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units8.equals("ng")) n1*=Math.pow(10,-12);
            if(units8.equals("μg")) n1*=Math.pow(10,-9);
            if(units8.equals("mg")) n1*=Math.pow(10,-6);
            if(units8.equals("g"))  n1*=Math.pow(10,-3);
            if(units8.equals("kg")) ;
            if(units8.equals("Mg")) n1*=Math.pow(10,3);
            if(units8.equals("Gg")) n1*=Math.pow(10,6);

            double n_=n0/n1;

            if(units10.equals("nm")) n_/=Math.pow(10,-9);
            if(units10.equals("μm")) n_/=Math.pow(10,-6);
            if(units10.equals("mm")) n_/=Math.pow(10,-3);
            if(units10.equals("cm")) n_/=Math.pow(10,-2);
            if(units10.equals("dm")) n_/=Math.pow(10,-1);
            if(units10.equals("m"))  ;
            if(units10.equals("km")) n_/=Math.pow(10,3);
            if(units10.equals("Mm")) n_/=Math.pow(10,6);
            if(units10.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units12.equals("ns")) n_*=Math.pow(10,-9);
            if(units12.equals("ms")) n_*=Math.pow(10,-3);
            if(units12.equals("s"))  ;
            if(units12.equals("min")) n_*=(60);
            if(units12.equals("hr")) n_*=(60*60);
            if(units12.equals("day")) n_*=(60*60*24);
            if(units12.equals("yr")) n_*=(60*60*24*365);

            t9.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}