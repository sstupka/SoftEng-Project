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

public class ConstantVelocityMotionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.constantvelocitymotionactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t4=(EditText)findViewById(R.id.editText4);
        t4.addTextChangedListener(updateAnswer);
        EditText t8=(EditText)findViewById(R.id.editText8);
        t8.addTextChangedListener(updateAnswer);
        Spinner units3=(Spinner)findViewById(R.id.spinner3);
        units3.setOnItemSelectedListener(updateUnits);
        Spinner units5=(Spinner)findViewById(R.id.spinner5);
        units5.setOnItemSelectedListener(updateUnits);
        Spinner units7=(Spinner)findViewById(R.id.spinner7);
        units7.setOnItemSelectedListener(updateUnits);
        Spinner units9=(Spinner)findViewById(R.id.spinner9);
        units9.setOnItemSelectedListener(updateUnits);
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
        EditText t4=(EditText)findViewById(R.id.editText4);
        EditText t8=(EditText)findViewById(R.id.editText8);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units5=((Spinner)findViewById(R.id.spinner5)).getSelectedItem().toString();
        String units7=((Spinner)findViewById(R.id.spinner7)).getSelectedItem().toString();
        String units9=((Spinner)findViewById(R.id.spinner9)).getSelectedItem().toString();
        if(solveFor.equals("d (Total distance)") && t4.length()>0 && t8.length()>0) {

            float n1;
            try {
                n1=Float.parseFloat(t4.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units5.equals("nm")) n1*=Math.pow(10,-9);
            if(units5.equals("μm")) n1*=Math.pow(10,-6);
            if(units5.equals("mm")) n1*=Math.pow(10,-3);
            if(units5.equals("cm")) n1*=Math.pow(10,-2);
            if(units5.equals("dm")) n1*=Math.pow(10,-1);
            if(units5.equals("m"))  ;
            if(units5.equals("km")) n1*=Math.pow(10,3);
            if(units5.equals("Mm")) n1*=Math.pow(10,6);
            if(units5.equals("Gm")) n1*=Math.pow(10,9);
                
            if(units7.equals("ns")) n1/=Math.pow(10,-9);
            if(units7.equals("ms")) n1/=Math.pow(10,-3);
            if(units7.equals("s"))  ;
            if(units7.equals("min")) n1/=(60);
            if(units7.equals("hr")) n1/=(60*60);
            if(units7.equals("day")) n1/=(60*60*24);
            if(units7.equals("yr")) n1/=(60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t8.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }
                
            if(units9.equals("ns")) n2*=Math.pow(10,-9);
            if(units9.equals("ms")) n2*=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n2*=(60);
            if(units9.equals("hr")) n2*=(60*60);
            if(units9.equals("day")) n2*=(60*60*24);
            if(units9.equals("yr")) n2*=(60*60*24*365);

            double n_=n1*n2;

            if(units3.equals("nm")) n_/=Math.pow(10,-9);
            if(units3.equals("μm")) n_/=Math.pow(10,-6);
            if(units3.equals("mm")) n_/=Math.pow(10,-3);
            if(units3.equals("cm")) n_/=Math.pow(10,-2);
            if(units3.equals("dm")) n_/=Math.pow(10,-1);
            if(units3.equals("m"))  ;
            if(units3.equals("km")) n_/=Math.pow(10,3);
            if(units3.equals("Mm")) n_/=Math.pow(10,6);
            if(units3.equals("Gm")) n_/=Math.pow(10,9);

            t2.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("v (Velocity)") && t2.length()>0 && t8.length()>0) {

            float n0;
            try {
                n0=Float.parseFloat(t2.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units3.equals("nm")) n0*=Math.pow(10,-9);
            if(units3.equals("μm")) n0*=Math.pow(10,-6);
            if(units3.equals("mm")) n0*=Math.pow(10,-3);
            if(units3.equals("cm")) n0*=Math.pow(10,-2);
            if(units3.equals("dm")) n0*=Math.pow(10,-1);
            if(units3.equals("m"))  ;
            if(units3.equals("km")) n0*=Math.pow(10,3);
            if(units3.equals("Mm")) n0*=Math.pow(10,6);
            if(units3.equals("Gm")) n0*=Math.pow(10,9);

            float n2;
            try {
                n2=Float.parseFloat(t8.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }
                
            if(units9.equals("ns")) n2*=Math.pow(10,-9);
            if(units9.equals("ms")) n2*=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n2*=(60);
            if(units9.equals("hr")) n2*=(60*60);
            if(units9.equals("day")) n2*=(60*60*24);
            if(units9.equals("yr")) n2*=(60*60*24*365);

            double n_=n0/n2;

            if(units5.equals("nm")) n_/=Math.pow(10,-9);
            if(units5.equals("μm")) n_/=Math.pow(10,-6);
            if(units5.equals("mm")) n_/=Math.pow(10,-3);
            if(units5.equals("cm")) n_/=Math.pow(10,-2);
            if(units5.equals("dm")) n_/=Math.pow(10,-1);
            if(units5.equals("m"))  ;
            if(units5.equals("km")) n_/=Math.pow(10,3);
            if(units5.equals("Mm")) n_/=Math.pow(10,6);
            if(units5.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units7.equals("ns")) n_*=Math.pow(10,-9);
            if(units7.equals("ms")) n_*=Math.pow(10,-3);
            if(units7.equals("s"))  ;
            if(units7.equals("min")) n_*=(60);
            if(units7.equals("hr")) n_*=(60*60);
            if(units7.equals("day")) n_*=(60*60*24);
            if(units7.equals("yr")) n_*=(60*60*24*365);

            t4.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("t (Elapsed time)") && t2.length()>0 && t4.length()>0) {

            float n0;
            try {
                n0=Float.parseFloat(t2.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units3.equals("nm")) n0*=Math.pow(10,-9);
            if(units3.equals("μm")) n0*=Math.pow(10,-6);
            if(units3.equals("mm")) n0*=Math.pow(10,-3);
            if(units3.equals("cm")) n0*=Math.pow(10,-2);
            if(units3.equals("dm")) n0*=Math.pow(10,-1);
            if(units3.equals("m"))  ;
            if(units3.equals("km")) n0*=Math.pow(10,3);
            if(units3.equals("Mm")) n0*=Math.pow(10,6);
            if(units3.equals("Gm")) n0*=Math.pow(10,9);

            float n1;
            try {
                n1=Float.parseFloat(t4.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units5.equals("nm")) n1*=Math.pow(10,-9);
            if(units5.equals("μm")) n1*=Math.pow(10,-6);
            if(units5.equals("mm")) n1*=Math.pow(10,-3);
            if(units5.equals("cm")) n1*=Math.pow(10,-2);
            if(units5.equals("dm")) n1*=Math.pow(10,-1);
            if(units5.equals("m"))  ;
            if(units5.equals("km")) n1*=Math.pow(10,3);
            if(units5.equals("Mm")) n1*=Math.pow(10,6);
            if(units5.equals("Gm")) n1*=Math.pow(10,9);
                
            if(units7.equals("ns")) n1/=Math.pow(10,-9);
            if(units7.equals("ms")) n1/=Math.pow(10,-3);
            if(units7.equals("s"))  ;
            if(units7.equals("min")) n1/=(60);
            if(units7.equals("hr")) n1/=(60*60);
            if(units7.equals("day")) n1/=(60*60*24);
            if(units7.equals("yr")) n1/=(60*60*24*365);

            double n_=n0/n1;
                
            if(units9.equals("ns")) n_/=Math.pow(10,-9);
            if(units9.equals("ms")) n_/=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n_/=(60);
            if(units9.equals("hr")) n_/=(60*60);
            if(units9.equals("day")) n_/=(60*60*24);
            if(units9.equals("yr")) n_/=(60*60*24*365);

            t8.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}