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

public class ImpulseMomentumTheoremActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.impulsemomentumtheoremactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t5=(EditText)findViewById(R.id.editText5);
        t5.addTextChangedListener(updateAnswer);
        EditText t7=(EditText)findViewById(R.id.editText7);
        t7.addTextChangedListener(updateAnswer);
        EditText t11=(EditText)findViewById(R.id.editText11);
        t11.addTextChangedListener(updateAnswer);
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
        Spinner units14=(Spinner)findViewById(R.id.spinner14);
        units14.setOnItemSelectedListener(updateUnits);
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
        EditText t11=(EditText)findViewById(R.id.editText11);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units4=((Spinner)findViewById(R.id.spinner4)).getSelectedItem().toString();
        String units6=((Spinner)findViewById(R.id.spinner6)).getSelectedItem().toString();
        String units8=((Spinner)findViewById(R.id.spinner8)).getSelectedItem().toString();
        String units10=((Spinner)findViewById(R.id.spinner10)).getSelectedItem().toString();
        String units12=((Spinner)findViewById(R.id.spinner12)).getSelectedItem().toString();
        String units14=((Spinner)findViewById(R.id.spinner14)).getSelectedItem().toString();
        if(solveFor.equals("J (Impulse)") && t5.length()>0 && t7.length()>0 && t11.length()>0) {

            float n1;
            try {
                n1=Float.parseFloat(t5.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units6.equals("ng")) n1*=Math.pow(10,-9);
            if(units6.equals("μg")) n1*=Math.pow(10,-6);
            if(units6.equals("mg")) n1*=Math.pow(10,-3);
            if(units6.equals("cg")) n1*=Math.pow(10,-2);
            if(units6.equals("dg")) n1*=Math.pow(10,-1);
            if(units6.equals("g"))  ;
            if(units6.equals("kg")) n1*=Math.pow(10,3);
            if(units6.equals("Mg")) n1*=Math.pow(10,6);
            if(units6.equals("Gg")) n1*=Math.pow(10,9);

            float n2;
            try {
                n2=Float.parseFloat(t7.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units8.equals("nm")) n2*=Math.pow(10,-9);
            if(units8.equals("μm")) n2*=Math.pow(10,-6);
            if(units8.equals("mm")) n2*=Math.pow(10,-3);
            if(units8.equals("cm")) n2*=Math.pow(10,-2);
            if(units8.equals("dm")) n2*=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n2*=Math.pow(10,3);
            if(units8.equals("Mm")) n2*=Math.pow(10,6);
            if(units8.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units10.equals("ns")) n2/=Math.pow(10,9);
            if(units10.equals("ms")) n2/=Math.pow(10,3);
            if(units10.equals("s"))  ;
            if(units10.equals("min")) n2/=1.0/(60);
            if(units10.equals("hr")) n2/=1.0/(60*60);
            if(units10.equals("day")) n2/=1.0/(60*60*24);
            if(units10.equals("yr")) n2/=1.0/(60*60*24*365);

            float n3;
            try {
                n3=Float.parseFloat(t11.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units12.equals("nm")) n3*=Math.pow(10,-9);
            if(units12.equals("μm")) n3*=Math.pow(10,-6);
            if(units12.equals("mm")) n3*=Math.pow(10,-3);
            if(units12.equals("cm")) n3*=Math.pow(10,-2);
            if(units12.equals("dm")) n3*=Math.pow(10,-1);
            if(units12.equals("m"))  ;
            if(units12.equals("km")) n3*=Math.pow(10,3);
            if(units12.equals("Mm")) n3*=Math.pow(10,6);
            if(units12.equals("Gm")) n3*=Math.pow(10,9);
                
            if(units14.equals("ns")) n3/=Math.pow(10,9);
            if(units14.equals("ms")) n3/=Math.pow(10,3);
            if(units14.equals("s"))  ;
            if(units14.equals("min")) n3/=1.0/(60);
            if(units14.equals("hr")) n3/=1.0/(60*60);
            if(units14.equals("day")) n3/=1.0/(60*60*24);
            if(units14.equals("yr")) n3/=1.0/(60*60*24*365);

            double n_=n1*(n3-n2);

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
        if(solveFor.equals("m (Mass)") && t2.length()>0 && t7.length()>0 && t11.length()>0) {

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

            if(units8.equals("nm")) n2*=Math.pow(10,-9);
            if(units8.equals("μm")) n2*=Math.pow(10,-6);
            if(units8.equals("mm")) n2*=Math.pow(10,-3);
            if(units8.equals("cm")) n2*=Math.pow(10,-2);
            if(units8.equals("dm")) n2*=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n2*=Math.pow(10,3);
            if(units8.equals("Mm")) n2*=Math.pow(10,6);
            if(units8.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units10.equals("ns")) n2/=Math.pow(10,9);
            if(units10.equals("ms")) n2/=Math.pow(10,3);
            if(units10.equals("s"))  ;
            if(units10.equals("min")) n2/=1.0/(60);
            if(units10.equals("hr")) n2/=1.0/(60*60);
            if(units10.equals("day")) n2/=1.0/(60*60*24);
            if(units10.equals("yr")) n2/=1.0/(60*60*24*365);

            float n3;
            try {
                n3=Float.parseFloat(t11.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units12.equals("nm")) n3*=Math.pow(10,-9);
            if(units12.equals("μm")) n3*=Math.pow(10,-6);
            if(units12.equals("mm")) n3*=Math.pow(10,-3);
            if(units12.equals("cm")) n3*=Math.pow(10,-2);
            if(units12.equals("dm")) n3*=Math.pow(10,-1);
            if(units12.equals("m"))  ;
            if(units12.equals("km")) n3*=Math.pow(10,3);
            if(units12.equals("Mm")) n3*=Math.pow(10,6);
            if(units12.equals("Gm")) n3*=Math.pow(10,9);
                
            if(units14.equals("ns")) n3/=Math.pow(10,9);
            if(units14.equals("ms")) n3/=Math.pow(10,3);
            if(units14.equals("s"))  ;
            if(units14.equals("min")) n3/=1.0/(60);
            if(units14.equals("hr")) n3/=1.0/(60*60);
            if(units14.equals("day")) n3/=1.0/(60*60*24);
            if(units14.equals("yr")) n3/=1.0/(60*60*24*365);

            double n_=n0/(n3-n2);

            if(units6.equals("ng")) n_/=Math.pow(10,-9);
            if(units6.equals("μg")) n_/=Math.pow(10,-6);
            if(units6.equals("mg")) n_/=Math.pow(10,-3);
            if(units6.equals("cg")) n_/=Math.pow(10,-2);
            if(units6.equals("dg")) n_/=Math.pow(10,-1);
            if(units6.equals("g"))  ;
            if(units6.equals("kg")) n_/=Math.pow(10,3);
            if(units6.equals("Mg")) n_/=Math.pow(10,6);
            if(units6.equals("Gg")) n_/=Math.pow(10,9);

            t5.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("v0 (Initial velocity)") && t2.length()>0 && t5.length()>0 && t11.length()>0) {

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

            if(units6.equals("ng")) n1*=Math.pow(10,-9);
            if(units6.equals("μg")) n1*=Math.pow(10,-6);
            if(units6.equals("mg")) n1*=Math.pow(10,-3);
            if(units6.equals("cg")) n1*=Math.pow(10,-2);
            if(units6.equals("dg")) n1*=Math.pow(10,-1);
            if(units6.equals("g"))  ;
            if(units6.equals("kg")) n1*=Math.pow(10,3);
            if(units6.equals("Mg")) n1*=Math.pow(10,6);
            if(units6.equals("Gg")) n1*=Math.pow(10,9);

            float n3;
            try {
                n3=Float.parseFloat(t11.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units12.equals("nm")) n3*=Math.pow(10,-9);
            if(units12.equals("μm")) n3*=Math.pow(10,-6);
            if(units12.equals("mm")) n3*=Math.pow(10,-3);
            if(units12.equals("cm")) n3*=Math.pow(10,-2);
            if(units12.equals("dm")) n3*=Math.pow(10,-1);
            if(units12.equals("m"))  ;
            if(units12.equals("km")) n3*=Math.pow(10,3);
            if(units12.equals("Mm")) n3*=Math.pow(10,6);
            if(units12.equals("Gm")) n3*=Math.pow(10,9);
                
            if(units14.equals("ns")) n3/=Math.pow(10,9);
            if(units14.equals("ms")) n3/=Math.pow(10,3);
            if(units14.equals("s"))  ;
            if(units14.equals("min")) n3/=1.0/(60);
            if(units14.equals("hr")) n3/=1.0/(60*60);
            if(units14.equals("day")) n3/=1.0/(60*60*24);
            if(units14.equals("yr")) n3/=1.0/(60*60*24*365);

            double n_=n3+n0/n1;

            if(units8.equals("nm")) n_/=Math.pow(10,-9);
            if(units8.equals("μm")) n_/=Math.pow(10,-6);
            if(units8.equals("mm")) n_/=Math.pow(10,-3);
            if(units8.equals("cm")) n_/=Math.pow(10,-2);
            if(units8.equals("dm")) n_/=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n_/=Math.pow(10,3);
            if(units8.equals("Mm")) n_/=Math.pow(10,6);
            if(units8.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units10.equals("ns")) n_*=Math.pow(10,9);
            if(units10.equals("ms")) n_*=Math.pow(10,3);
            if(units10.equals("s"))  ;
            if(units10.equals("min")) n_*=1.0/(60);
            if(units10.equals("hr")) n_*=1.0/(60*60);
            if(units10.equals("day")) n_*=1.0/(60*60*24);
            if(units10.equals("yr")) n_*=1.0/(60*60*24*365);

            t7.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("vf (Final velocity)") && t2.length()>0 && t5.length()>0 && t7.length()>0) {

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

            if(units6.equals("ng")) n1*=Math.pow(10,-9);
            if(units6.equals("μg")) n1*=Math.pow(10,-6);
            if(units6.equals("mg")) n1*=Math.pow(10,-3);
            if(units6.equals("cg")) n1*=Math.pow(10,-2);
            if(units6.equals("dg")) n1*=Math.pow(10,-1);
            if(units6.equals("g"))  ;
            if(units6.equals("kg")) n1*=Math.pow(10,3);
            if(units6.equals("Mg")) n1*=Math.pow(10,6);
            if(units6.equals("Gg")) n1*=Math.pow(10,9);

            float n2;
            try {
                n2=Float.parseFloat(t7.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units8.equals("nm")) n2*=Math.pow(10,-9);
            if(units8.equals("μm")) n2*=Math.pow(10,-6);
            if(units8.equals("mm")) n2*=Math.pow(10,-3);
            if(units8.equals("cm")) n2*=Math.pow(10,-2);
            if(units8.equals("dm")) n2*=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n2*=Math.pow(10,3);
            if(units8.equals("Mm")) n2*=Math.pow(10,6);
            if(units8.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units10.equals("ns")) n2/=Math.pow(10,9);
            if(units10.equals("ms")) n2/=Math.pow(10,3);
            if(units10.equals("s"))  ;
            if(units10.equals("min")) n2/=1.0/(60);
            if(units10.equals("hr")) n2/=1.0/(60*60);
            if(units10.equals("day")) n2/=1.0/(60*60*24);
            if(units10.equals("yr")) n2/=1.0/(60*60*24*365);

            double n_=n2+n0/n1;

            if(units12.equals("nm")) n_/=Math.pow(10,-9);
            if(units12.equals("μm")) n_/=Math.pow(10,-6);
            if(units12.equals("mm")) n_/=Math.pow(10,-3);
            if(units12.equals("cm")) n_/=Math.pow(10,-2);
            if(units12.equals("dm")) n_/=Math.pow(10,-1);
            if(units12.equals("m"))  ;
            if(units12.equals("km")) n_/=Math.pow(10,3);
            if(units12.equals("Mm")) n_/=Math.pow(10,6);
            if(units12.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units14.equals("ns")) n_*=Math.pow(10,9);
            if(units14.equals("ms")) n_*=Math.pow(10,3);
            if(units14.equals("s"))  ;
            if(units14.equals("min")) n_*=1.0/(60);
            if(units14.equals("hr")) n_*=1.0/(60*60);
            if(units14.equals("day")) n_*=1.0/(60*60*24);
            if(units14.equals("yr")) n_*=1.0/(60*60*24*365);

            t11.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}