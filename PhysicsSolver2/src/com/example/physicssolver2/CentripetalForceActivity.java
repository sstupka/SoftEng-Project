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

public class CentripetalForceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.centripetalforceactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t4=(EditText)findViewById(R.id.editText4);
        t4.addTextChangedListener(updateAnswer);
        EditText t6=(EditText)findViewById(R.id.editText6);
        t6.addTextChangedListener(updateAnswer);
        EditText t10=(EditText)findViewById(R.id.editText10);
        t10.addTextChangedListener(updateAnswer);
        EditText t12=(EditText)findViewById(R.id.editText12);
        t12.addTextChangedListener(updateAnswer);
        Spinner units3=(Spinner)findViewById(R.id.spinner3);
        units3.setOnItemSelectedListener(updateUnits);
        Spinner units5=(Spinner)findViewById(R.id.spinner5);
        units5.setOnItemSelectedListener(updateUnits);
        Spinner units7=(Spinner)findViewById(R.id.spinner7);
        units7.setOnItemSelectedListener(updateUnits);
        Spinner units9=(Spinner)findViewById(R.id.spinner9);
        units9.setOnItemSelectedListener(updateUnits);
        Spinner units11=(Spinner)findViewById(R.id.spinner11);
        units11.setOnItemSelectedListener(updateUnits);
        Spinner units13=(Spinner)findViewById(R.id.spinner13);
        units13.setOnItemSelectedListener(updateUnits);
        Spinner units15=(Spinner)findViewById(R.id.spinner15);
        units15.setOnItemSelectedListener(updateUnits);
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
        EditText t6=(EditText)findViewById(R.id.editText6);
        EditText t10=(EditText)findViewById(R.id.editText10);
        EditText t12=(EditText)findViewById(R.id.editText12);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units5=((Spinner)findViewById(R.id.spinner5)).getSelectedItem().toString();
        String units7=((Spinner)findViewById(R.id.spinner7)).getSelectedItem().toString();
        String units9=((Spinner)findViewById(R.id.spinner9)).getSelectedItem().toString();
        String units11=((Spinner)findViewById(R.id.spinner11)).getSelectedItem().toString();
        String units13=((Spinner)findViewById(R.id.spinner13)).getSelectedItem().toString();
        String units15=((Spinner)findViewById(R.id.spinner15)).getSelectedItem().toString();
        if(solveFor.equals("F (Centripetal force)") && t4.length()>0 && t6.length()>0 && t10.length()>0 && t12.length()>0) {

            float n1;
            try {
                n1=Float.parseFloat(t4.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units5.equals("ng")) n1*=Math.pow(10,-12);
            if(units5.equals("μg")) n1*=Math.pow(10,-9);
            if(units5.equals("mg")) n1*=Math.pow(10,-6);
            if(units5.equals("g"))  n1*=Math.pow(10,-3);
            if(units5.equals("kg")) ;
            if(units5.equals("Mg")) n1*=Math.pow(10,3);
            if(units5.equals("Gg")) n1*=Math.pow(10,6);

            float n2;
            try {
                n2=Float.parseFloat(t6.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units7.equals("nm")) n2*=Math.pow(10,-9);
            if(units7.equals("μm")) n2*=Math.pow(10,-6);
            if(units7.equals("mm")) n2*=Math.pow(10,-3);
            if(units7.equals("cm")) n2*=Math.pow(10,-2);
            if(units7.equals("dm")) n2*=Math.pow(10,-1);
            if(units7.equals("m"))  ;
            if(units7.equals("km")) n2*=Math.pow(10,3);
            if(units7.equals("Mm")) n2*=Math.pow(10,6);
            if(units7.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units9.equals("ns")) n2/=Math.pow(10,-9);
            if(units9.equals("ms")) n2/=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n2/=(60);
            if(units9.equals("hr")) n2/=(60*60);
            if(units9.equals("day")) n2/=(60*60*24);
            if(units9.equals("yr")) n2/=(60*60*24*365);

            float n3;
            try {
                n3=Float.parseFloat(t10.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units11.equals("nm")) n3*=Math.pow(10,-9);
            if(units11.equals("μm")) n3*=Math.pow(10,-6);
            if(units11.equals("mm")) n3*=Math.pow(10,-3);
            if(units11.equals("cm")) n3*=Math.pow(10,-2);
            if(units11.equals("dm")) n3*=Math.pow(10,-1);
            if(units11.equals("m"))  ;
            if(units11.equals("km")) n3*=Math.pow(10,3);
            if(units11.equals("Mm")) n3*=Math.pow(10,6);
            if(units11.equals("Gm")) n3*=Math.pow(10,9);

            float n4;
            try {
                n4=Float.parseFloat(t12.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units13.equals("nm")) n4*=Math.pow(10,-9);
            if(units13.equals("μm")) n4*=Math.pow(10,-6);
            if(units13.equals("mm")) n4*=Math.pow(10,-3);
            if(units13.equals("cm")) n4*=Math.pow(10,-2);
            if(units13.equals("dm")) n4*=Math.pow(10,-1);
            if(units13.equals("m"))  ;
            if(units13.equals("km")) n4*=Math.pow(10,3);
            if(units13.equals("Mm")) n4*=Math.pow(10,6);
            if(units13.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units15.equals("ns^2")) n4/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units15.equals("ms^2")) n4/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units15.equals("s^2"))  ;
            if(units15.equals("min^2")) n4/=(60*60);
            if(units15.equals("hr^2")) n4/=(60*60*60*60);
            if(units15.equals("day^2")) n4/=(60*60*24*60*60*24);
            if(units15.equals("yr^2")) n4/=(60*60*24*365*60*60*24*365);

            double n_=n1*n4;

            if(units3.equals("nN")) n_/=Math.pow(10,-9);
            if(units3.equals("μN")) n_/=Math.pow(10,-6);
            if(units3.equals("mN")) n_/=Math.pow(10,-3);
            if(units3.equals("cN")) n_/=Math.pow(10,-2);
            if(units3.equals("dN")) n_/=Math.pow(10,-1);
            if(units3.equals("N"))  ;
            if(units3.equals("kN")) n_/=Math.pow(10,3);
            if(units3.equals("MN")) n_/=Math.pow(10,6);
            if(units3.equals("GN")) n_/=Math.pow(10,9);

            t2.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("m (Mass)") && t2.length()>0 && t6.length()>0 && t10.length()>0 && t12.length()>0) {

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

            float n2;
            try {
                n2=Float.parseFloat(t6.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units7.equals("nm")) n2*=Math.pow(10,-9);
            if(units7.equals("μm")) n2*=Math.pow(10,-6);
            if(units7.equals("mm")) n2*=Math.pow(10,-3);
            if(units7.equals("cm")) n2*=Math.pow(10,-2);
            if(units7.equals("dm")) n2*=Math.pow(10,-1);
            if(units7.equals("m"))  ;
            if(units7.equals("km")) n2*=Math.pow(10,3);
            if(units7.equals("Mm")) n2*=Math.pow(10,6);
            if(units7.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units9.equals("ns")) n2/=Math.pow(10,-9);
            if(units9.equals("ms")) n2/=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n2/=(60);
            if(units9.equals("hr")) n2/=(60*60);
            if(units9.equals("day")) n2/=(60*60*24);
            if(units9.equals("yr")) n2/=(60*60*24*365);

            float n3;
            try {
                n3=Float.parseFloat(t10.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units11.equals("nm")) n3*=Math.pow(10,-9);
            if(units11.equals("μm")) n3*=Math.pow(10,-6);
            if(units11.equals("mm")) n3*=Math.pow(10,-3);
            if(units11.equals("cm")) n3*=Math.pow(10,-2);
            if(units11.equals("dm")) n3*=Math.pow(10,-1);
            if(units11.equals("m"))  ;
            if(units11.equals("km")) n3*=Math.pow(10,3);
            if(units11.equals("Mm")) n3*=Math.pow(10,6);
            if(units11.equals("Gm")) n3*=Math.pow(10,9);

            float n4;
            try {
                n4=Float.parseFloat(t12.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units13.equals("nm")) n4*=Math.pow(10,-9);
            if(units13.equals("μm")) n4*=Math.pow(10,-6);
            if(units13.equals("mm")) n4*=Math.pow(10,-3);
            if(units13.equals("cm")) n4*=Math.pow(10,-2);
            if(units13.equals("dm")) n4*=Math.pow(10,-1);
            if(units13.equals("m"))  ;
            if(units13.equals("km")) n4*=Math.pow(10,3);
            if(units13.equals("Mm")) n4*=Math.pow(10,6);
            if(units13.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units15.equals("ns^2")) n4/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units15.equals("ms^2")) n4/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units15.equals("s^2"))  ;
            if(units15.equals("min^2")) n4/=(60*60);
            if(units15.equals("hr^2")) n4/=(60*60*60*60);
            if(units15.equals("day^2")) n4/=(60*60*24*60*60*24);
            if(units15.equals("yr^2")) n4/=(60*60*24*365*60*60*24*365);

            double n_=n0*n3/(n2*n2);

            if(units5.equals("ng")) n_/=Math.pow(10,-12);
            if(units5.equals("μg")) n_/=Math.pow(10,-9);
            if(units5.equals("mg")) n_/=Math.pow(10,-6);
            if(units5.equals("g"))  n_/=Math.pow(10,-3);
            if(units5.equals("kg")) ;
            if(units5.equals("Mg")) n_/=Math.pow(10,3);
            if(units5.equals("Gg")) n_/=Math.pow(10,6);

            t4.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("v (Velocity)") && t2.length()>0 && t4.length()>0 && t10.length()>0 && t12.length()>0) {

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

            float n1;
            try {
                n1=Float.parseFloat(t4.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units5.equals("ng")) n1*=Math.pow(10,-12);
            if(units5.equals("μg")) n1*=Math.pow(10,-9);
            if(units5.equals("mg")) n1*=Math.pow(10,-6);
            if(units5.equals("g"))  n1*=Math.pow(10,-3);
            if(units5.equals("kg")) ;
            if(units5.equals("Mg")) n1*=Math.pow(10,3);
            if(units5.equals("Gg")) n1*=Math.pow(10,6);

            float n3;
            try {
                n3=Float.parseFloat(t10.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units11.equals("nm")) n3*=Math.pow(10,-9);
            if(units11.equals("μm")) n3*=Math.pow(10,-6);
            if(units11.equals("mm")) n3*=Math.pow(10,-3);
            if(units11.equals("cm")) n3*=Math.pow(10,-2);
            if(units11.equals("dm")) n3*=Math.pow(10,-1);
            if(units11.equals("m"))  ;
            if(units11.equals("km")) n3*=Math.pow(10,3);
            if(units11.equals("Mm")) n3*=Math.pow(10,6);
            if(units11.equals("Gm")) n3*=Math.pow(10,9);

            float n4;
            try {
                n4=Float.parseFloat(t12.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units13.equals("nm")) n4*=Math.pow(10,-9);
            if(units13.equals("μm")) n4*=Math.pow(10,-6);
            if(units13.equals("mm")) n4*=Math.pow(10,-3);
            if(units13.equals("cm")) n4*=Math.pow(10,-2);
            if(units13.equals("dm")) n4*=Math.pow(10,-1);
            if(units13.equals("m"))  ;
            if(units13.equals("km")) n4*=Math.pow(10,3);
            if(units13.equals("Mm")) n4*=Math.pow(10,6);
            if(units13.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units15.equals("ns^2")) n4/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units15.equals("ms^2")) n4/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units15.equals("s^2"))  ;
            if(units15.equals("min^2")) n4/=(60*60);
            if(units15.equals("hr^2")) n4/=(60*60*60*60);
            if(units15.equals("day^2")) n4/=(60*60*24*60*60*24);
            if(units15.equals("yr^2")) n4/=(60*60*24*365*60*60*24*365);

            double n_=Math.sqrt(n0*n3/n1);

            if(units7.equals("nm")) n_/=Math.pow(10,-9);
            if(units7.equals("μm")) n_/=Math.pow(10,-6);
            if(units7.equals("mm")) n_/=Math.pow(10,-3);
            if(units7.equals("cm")) n_/=Math.pow(10,-2);
            if(units7.equals("dm")) n_/=Math.pow(10,-1);
            if(units7.equals("m"))  ;
            if(units7.equals("km")) n_/=Math.pow(10,3);
            if(units7.equals("Mm")) n_/=Math.pow(10,6);
            if(units7.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units9.equals("ns")) n_*=Math.pow(10,-9);
            if(units9.equals("ms")) n_*=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n_*=(60);
            if(units9.equals("hr")) n_*=(60*60);
            if(units9.equals("day")) n_*=(60*60*24);
            if(units9.equals("yr")) n_*=(60*60*24*365);

            t6.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("r (Radius)") && t2.length()>0 && t4.length()>0 && t6.length()>0 && t12.length()>0) {

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

            float n1;
            try {
                n1=Float.parseFloat(t4.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units5.equals("ng")) n1*=Math.pow(10,-12);
            if(units5.equals("μg")) n1*=Math.pow(10,-9);
            if(units5.equals("mg")) n1*=Math.pow(10,-6);
            if(units5.equals("g"))  n1*=Math.pow(10,-3);
            if(units5.equals("kg")) ;
            if(units5.equals("Mg")) n1*=Math.pow(10,3);
            if(units5.equals("Gg")) n1*=Math.pow(10,6);

            float n2;
            try {
                n2=Float.parseFloat(t6.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units7.equals("nm")) n2*=Math.pow(10,-9);
            if(units7.equals("μm")) n2*=Math.pow(10,-6);
            if(units7.equals("mm")) n2*=Math.pow(10,-3);
            if(units7.equals("cm")) n2*=Math.pow(10,-2);
            if(units7.equals("dm")) n2*=Math.pow(10,-1);
            if(units7.equals("m"))  ;
            if(units7.equals("km")) n2*=Math.pow(10,3);
            if(units7.equals("Mm")) n2*=Math.pow(10,6);
            if(units7.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units9.equals("ns")) n2/=Math.pow(10,-9);
            if(units9.equals("ms")) n2/=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n2/=(60);
            if(units9.equals("hr")) n2/=(60*60);
            if(units9.equals("day")) n2/=(60*60*24);
            if(units9.equals("yr")) n2/=(60*60*24*365);

            float n4;
            try {
                n4=Float.parseFloat(t12.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units13.equals("nm")) n4*=Math.pow(10,-9);
            if(units13.equals("μm")) n4*=Math.pow(10,-6);
            if(units13.equals("mm")) n4*=Math.pow(10,-3);
            if(units13.equals("cm")) n4*=Math.pow(10,-2);
            if(units13.equals("dm")) n4*=Math.pow(10,-1);
            if(units13.equals("m"))  ;
            if(units13.equals("km")) n4*=Math.pow(10,3);
            if(units13.equals("Mm")) n4*=Math.pow(10,6);
            if(units13.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units15.equals("ns^2")) n4/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units15.equals("ms^2")) n4/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units15.equals("s^2"))  ;
            if(units15.equals("min^2")) n4/=(60*60);
            if(units15.equals("hr^2")) n4/=(60*60*60*60);
            if(units15.equals("day^2")) n4/=(60*60*24*60*60*24);
            if(units15.equals("yr^2")) n4/=(60*60*24*365*60*60*24*365);

            double n_=n1*n2*n2/n0;

            if(units11.equals("nm")) n_/=Math.pow(10,-9);
            if(units11.equals("μm")) n_/=Math.pow(10,-6);
            if(units11.equals("mm")) n_/=Math.pow(10,-3);
            if(units11.equals("cm")) n_/=Math.pow(10,-2);
            if(units11.equals("dm")) n_/=Math.pow(10,-1);
            if(units11.equals("m"))  ;
            if(units11.equals("km")) n_/=Math.pow(10,3);
            if(units11.equals("Mm")) n_/=Math.pow(10,6);
            if(units11.equals("Gm")) n_/=Math.pow(10,9);

            t10.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("a(Centripetal acceleration)") && t2.length()>0 && t4.length()>0 && t6.length()>0 && t10.length()>0) {

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

            float n1;
            try {
                n1=Float.parseFloat(t4.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units5.equals("ng")) n1*=Math.pow(10,-12);
            if(units5.equals("μg")) n1*=Math.pow(10,-9);
            if(units5.equals("mg")) n1*=Math.pow(10,-6);
            if(units5.equals("g"))  n1*=Math.pow(10,-3);
            if(units5.equals("kg")) ;
            if(units5.equals("Mg")) n1*=Math.pow(10,3);
            if(units5.equals("Gg")) n1*=Math.pow(10,6);

            float n2;
            try {
                n2=Float.parseFloat(t6.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units7.equals("nm")) n2*=Math.pow(10,-9);
            if(units7.equals("μm")) n2*=Math.pow(10,-6);
            if(units7.equals("mm")) n2*=Math.pow(10,-3);
            if(units7.equals("cm")) n2*=Math.pow(10,-2);
            if(units7.equals("dm")) n2*=Math.pow(10,-1);
            if(units7.equals("m"))  ;
            if(units7.equals("km")) n2*=Math.pow(10,3);
            if(units7.equals("Mm")) n2*=Math.pow(10,6);
            if(units7.equals("Gm")) n2*=Math.pow(10,9);
                
            if(units9.equals("ns")) n2/=Math.pow(10,-9);
            if(units9.equals("ms")) n2/=Math.pow(10,-3);
            if(units9.equals("s"))  ;
            if(units9.equals("min")) n2/=(60);
            if(units9.equals("hr")) n2/=(60*60);
            if(units9.equals("day")) n2/=(60*60*24);
            if(units9.equals("yr")) n2/=(60*60*24*365);

            float n3;
            try {
                n3=Float.parseFloat(t10.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units11.equals("nm")) n3*=Math.pow(10,-9);
            if(units11.equals("μm")) n3*=Math.pow(10,-6);
            if(units11.equals("mm")) n3*=Math.pow(10,-3);
            if(units11.equals("cm")) n3*=Math.pow(10,-2);
            if(units11.equals("dm")) n3*=Math.pow(10,-1);
            if(units11.equals("m"))  ;
            if(units11.equals("km")) n3*=Math.pow(10,3);
            if(units11.equals("Mm")) n3*=Math.pow(10,6);
            if(units11.equals("Gm")) n3*=Math.pow(10,9);

            double n_=n0/n1;

            if(units13.equals("nm")) n_/=Math.pow(10,-9);
            if(units13.equals("μm")) n_/=Math.pow(10,-6);
            if(units13.equals("mm")) n_/=Math.pow(10,-3);
            if(units13.equals("cm")) n_/=Math.pow(10,-2);
            if(units13.equals("dm")) n_/=Math.pow(10,-1);
            if(units13.equals("m"))  ;
            if(units13.equals("km")) n_/=Math.pow(10,3);
            if(units13.equals("Mm")) n_/=Math.pow(10,6);
            if(units13.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units15.equals("ns^2")) n_*=Math.pow(10,-9)*Math.pow(10,-9);
            if(units15.equals("ms^2")) n_*=Math.pow(10,-3)*Math.pow(10,-3);
            if(units15.equals("s^2"))  ;
            if(units15.equals("min^2")) n_*=(60*60);
            if(units15.equals("hr^2")) n_*=(60*60*60*60);
            if(units15.equals("day^2")) n_*=(60*60*24*60*60*24);
            if(units15.equals("yr^2")) n_*=(60*60*24*365*60*60*24*365);

            t12.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}