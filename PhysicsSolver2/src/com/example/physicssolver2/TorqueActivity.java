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

public class TorqueActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.torqueactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t5=(EditText)findViewById(R.id.editText5);
        t5.addTextChangedListener(updateAnswer);
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
        EditText t9=(EditText)findViewById(R.id.editText9);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units4=((Spinner)findViewById(R.id.spinner4)).getSelectedItem().toString();
        String units6=((Spinner)findViewById(R.id.spinner6)).getSelectedItem().toString();
        String units8=((Spinner)findViewById(R.id.spinner8)).getSelectedItem().toString();
        String units10=((Spinner)findViewById(R.id.spinner10)).getSelectedItem().toString();
        if(solveFor.equals("T (Torque)") && t5.length()>0 && t7.length()>0 && t9.length()>0) {

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

            if(units8.equals("nm")) n2*=Math.pow(10,-9);
            if(units8.equals("μm")) n2*=Math.pow(10,-6);
            if(units8.equals("mm")) n2*=Math.pow(10,-3);
            if(units8.equals("cm")) n2*=Math.pow(10,-2);
            if(units8.equals("dm")) n2*=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n2*=Math.pow(10,3);
            if(units8.equals("Mm")) n2*=Math.pow(10,6);
            if(units8.equals("Gm")) n2*=Math.pow(10,9);

            float n3;
            try {
                n3=Float.parseFloat(t9.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units10.equals("rad")) ;
            if(units10.equals("deg")) n3*=Math.PI/180.0;

            double n_=n1*n2*Math.sin(n3);

            if(units3.equals("nN")) n_/=Math.pow(10,-9);
            if(units3.equals("μN")) n_/=Math.pow(10,-6);
            if(units3.equals("mN")) n_/=Math.pow(10,-3);
            if(units3.equals("cN")) n_/=Math.pow(10,-2);
            if(units3.equals("dN")) n_/=Math.pow(10,-1);
            if(units3.equals("N"))  ;
            if(units3.equals("kN")) n_/=Math.pow(10,3);
            if(units3.equals("MN")) n_/=Math.pow(10,6);
            if(units3.equals("GN")) n_/=Math.pow(10,9);

            if(units4.equals("nm")) n_/=Math.pow(10,-9);
            if(units4.equals("μm")) n_/=Math.pow(10,-6);
            if(units4.equals("mm")) n_/=Math.pow(10,-3);
            if(units4.equals("cm")) n_/=Math.pow(10,-2);
            if(units4.equals("dm")) n_/=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n_/=Math.pow(10,3);
            if(units4.equals("Mm")) n_/=Math.pow(10,6);
            if(units4.equals("Gm")) n_/=Math.pow(10,9);

            t2.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("F (Force)") && t2.length()>0 && t7.length()>0 && t9.length()>0) {

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

            if(units4.equals("nm")) n0*=Math.pow(10,-9);
            if(units4.equals("μm")) n0*=Math.pow(10,-6);
            if(units4.equals("mm")) n0*=Math.pow(10,-3);
            if(units4.equals("cm")) n0*=Math.pow(10,-2);
            if(units4.equals("dm")) n0*=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n0*=Math.pow(10,3);
            if(units4.equals("Mm")) n0*=Math.pow(10,6);
            if(units4.equals("Gm")) n0*=Math.pow(10,9);

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

            float n3;
            try {
                n3=Float.parseFloat(t9.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units10.equals("rad")) ;
            if(units10.equals("deg")) n3*=Math.PI/180.0;

            double n_=n0/(n2*Math.sin(n3));

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
        if(solveFor.equals("r (Lever arm length)") && t2.length()>0 && t5.length()>0 && t9.length()>0) {

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

            if(units4.equals("nm")) n0*=Math.pow(10,-9);
            if(units4.equals("μm")) n0*=Math.pow(10,-6);
            if(units4.equals("mm")) n0*=Math.pow(10,-3);
            if(units4.equals("cm")) n0*=Math.pow(10,-2);
            if(units4.equals("dm")) n0*=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n0*=Math.pow(10,3);
            if(units4.equals("Mm")) n0*=Math.pow(10,6);
            if(units4.equals("Gm")) n0*=Math.pow(10,9);

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

            float n3;
            try {
                n3=Float.parseFloat(t9.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units10.equals("rad")) ;
            if(units10.equals("deg")) n3*=Math.PI/180.0;

            double n_=n0/(n1*Math.sin(n3));

            if(units8.equals("nm")) n_/=Math.pow(10,-9);
            if(units8.equals("μm")) n_/=Math.pow(10,-6);
            if(units8.equals("mm")) n_/=Math.pow(10,-3);
            if(units8.equals("cm")) n_/=Math.pow(10,-2);
            if(units8.equals("dm")) n_/=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n_/=Math.pow(10,3);
            if(units8.equals("Mm")) n_/=Math.pow(10,6);
            if(units8.equals("Gm")) n_/=Math.pow(10,9);

            t7.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("θ (Angle)") && t2.length()>0 && t5.length()>0 && t7.length()>0) {

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

            if(units4.equals("nm")) n0*=Math.pow(10,-9);
            if(units4.equals("μm")) n0*=Math.pow(10,-6);
            if(units4.equals("mm")) n0*=Math.pow(10,-3);
            if(units4.equals("cm")) n0*=Math.pow(10,-2);
            if(units4.equals("dm")) n0*=Math.pow(10,-1);
            if(units4.equals("m"))  ;
            if(units4.equals("km")) n0*=Math.pow(10,3);
            if(units4.equals("Mm")) n0*=Math.pow(10,6);
            if(units4.equals("Gm")) n0*=Math.pow(10,9);

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

            if(units8.equals("nm")) n2*=Math.pow(10,-9);
            if(units8.equals("μm")) n2*=Math.pow(10,-6);
            if(units8.equals("mm")) n2*=Math.pow(10,-3);
            if(units8.equals("cm")) n2*=Math.pow(10,-2);
            if(units8.equals("dm")) n2*=Math.pow(10,-1);
            if(units8.equals("m"))  ;
            if(units8.equals("km")) n2*=Math.pow(10,3);
            if(units8.equals("Mm")) n2*=Math.pow(10,6);
            if(units8.equals("Gm")) n2*=Math.pow(10,9);

            double n_=Math.asin(n0/(n1*n2));

            if(units10.equals("rad")) ;
            if(units10.equals("deg")) n_/=Math.PI/180.0;

            t9.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}