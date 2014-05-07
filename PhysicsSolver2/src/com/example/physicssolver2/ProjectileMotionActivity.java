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

public class ProjectileMotionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.projectilemotionactivity);

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.addTextChangedListener(updateAnswer);
        EditText t4=(EditText)findViewById(R.id.editText4);
        t4.addTextChangedListener(updateAnswer);
        EditText t8=(EditText)findViewById(R.id.editText8);
        t8.addTextChangedListener(updateAnswer);
        EditText t10=(EditText)findViewById(R.id.editText10);
        t10.addTextChangedListener(updateAnswer);
        EditText t14=(EditText)findViewById(R.id.editText14);
        t14.addTextChangedListener(updateAnswer);
        EditText t18=(EditText)findViewById(R.id.editText18);
        t18.addTextChangedListener(updateAnswer);
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
        Spinner units17=(Spinner)findViewById(R.id.spinner17);
        units17.setOnItemSelectedListener(updateUnits);
        Spinner units19=(Spinner)findViewById(R.id.spinner19);
        units19.setOnItemSelectedListener(updateUnits);
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
        EditText t10=(EditText)findViewById(R.id.editText10);
        EditText t14=(EditText)findViewById(R.id.editText14);
        EditText t18=(EditText)findViewById(R.id.editText18);
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        String units3=((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
        String units5=((Spinner)findViewById(R.id.spinner5)).getSelectedItem().toString();
        String units7=((Spinner)findViewById(R.id.spinner7)).getSelectedItem().toString();
        String units9=((Spinner)findViewById(R.id.spinner9)).getSelectedItem().toString();
        String units11=((Spinner)findViewById(R.id.spinner11)).getSelectedItem().toString();
        String units13=((Spinner)findViewById(R.id.spinner13)).getSelectedItem().toString();
        String units15=((Spinner)findViewById(R.id.spinner15)).getSelectedItem().toString();
        String units17=((Spinner)findViewById(R.id.spinner17)).getSelectedItem().toString();
        String units19=((Spinner)findViewById(R.id.spinner19)).getSelectedItem().toString();
        if(solveFor.equals("R (Range)") && t4.length()>0 && t8.length()>0 && t10.length()>0 && t14.length()>0 && t18.length()>0) {

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
                
            if(units7.equals("ns^2")) n1/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units7.equals("ms^2")) n1/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units7.equals("s^2"))  ;
            if(units7.equals("min^2")) n1/=(60*60);
            if(units7.equals("hr^2")) n1/=(60*60*60*60);
            if(units7.equals("day^2")) n1/=(60*60*24*60*60*24);
            if(units7.equals("yr^2")) n1/=(60*60*24*365*60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t8.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units9.equals("nm")) n2*=Math.pow(10,-9);
            if(units9.equals("μm")) n2*=Math.pow(10,-6);
            if(units9.equals("mm")) n2*=Math.pow(10,-3);
            if(units9.equals("cm")) n2*=Math.pow(10,-2);
            if(units9.equals("dm")) n2*=Math.pow(10,-1);
            if(units9.equals("m"))  ;
            if(units9.equals("km")) n2*=Math.pow(10,3);
            if(units9.equals("Mm")) n2*=Math.pow(10,6);
            if(units9.equals("Gm")) n2*=Math.pow(10,9);

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
                
            if(units13.equals("ns")) n3/=Math.pow(10,-9);
            if(units13.equals("ms")) n3/=Math.pow(10,-3);
            if(units13.equals("s"))  ;
            if(units13.equals("min")) n3/=(60);
            if(units13.equals("hr")) n3/=(60*60);
            if(units13.equals("day")) n3/=(60*60*24);
            if(units13.equals("yr")) n3/=(60*60*24*365);

            float n4;
            try {
                n4=Float.parseFloat(t14.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units15.equals("nm")) n4*=Math.pow(10,-9);
            if(units15.equals("μm")) n4*=Math.pow(10,-6);
            if(units15.equals("mm")) n4*=Math.pow(10,-3);
            if(units15.equals("cm")) n4*=Math.pow(10,-2);
            if(units15.equals("dm")) n4*=Math.pow(10,-1);
            if(units15.equals("m"))  ;
            if(units15.equals("km")) n4*=Math.pow(10,3);
            if(units15.equals("Mm")) n4*=Math.pow(10,6);
            if(units15.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units17.equals("ns")) n4/=Math.pow(10,-9);
            if(units17.equals("ms")) n4/=Math.pow(10,-3);
            if(units17.equals("s"))  ;
            if(units17.equals("min")) n4/=(60);
            if(units17.equals("hr")) n4/=(60*60);
            if(units17.equals("day")) n4/=(60*60*24);
            if(units17.equals("yr")) n4/=(60*60*24*365);

            float n5;
            try {
                n5=Float.parseFloat(t18.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units19.equals("rad")) ;
            if(units19.equals("deg")) n5*=Math.PI/180.0;

            double n_=n4*n4*Math.sin(2*n5)/n1;

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
        if(solveFor.equals("g (Acceleration due to gravity)") && t2.length()>0 && t8.length()>0 && t10.length()>0 && t14.length()>0 && t18.length()>0) {

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

            if(units9.equals("nm")) n2*=Math.pow(10,-9);
            if(units9.equals("μm")) n2*=Math.pow(10,-6);
            if(units9.equals("mm")) n2*=Math.pow(10,-3);
            if(units9.equals("cm")) n2*=Math.pow(10,-2);
            if(units9.equals("dm")) n2*=Math.pow(10,-1);
            if(units9.equals("m"))  ;
            if(units9.equals("km")) n2*=Math.pow(10,3);
            if(units9.equals("Mm")) n2*=Math.pow(10,6);
            if(units9.equals("Gm")) n2*=Math.pow(10,9);

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
                
            if(units13.equals("ns")) n3/=Math.pow(10,-9);
            if(units13.equals("ms")) n3/=Math.pow(10,-3);
            if(units13.equals("s"))  ;
            if(units13.equals("min")) n3/=(60);
            if(units13.equals("hr")) n3/=(60*60);
            if(units13.equals("day")) n3/=(60*60*24);
            if(units13.equals("yr")) n3/=(60*60*24*365);

            float n4;
            try {
                n4=Float.parseFloat(t14.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units15.equals("nm")) n4*=Math.pow(10,-9);
            if(units15.equals("μm")) n4*=Math.pow(10,-6);
            if(units15.equals("mm")) n4*=Math.pow(10,-3);
            if(units15.equals("cm")) n4*=Math.pow(10,-2);
            if(units15.equals("dm")) n4*=Math.pow(10,-1);
            if(units15.equals("m"))  ;
            if(units15.equals("km")) n4*=Math.pow(10,3);
            if(units15.equals("Mm")) n4*=Math.pow(10,6);
            if(units15.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units17.equals("ns")) n4/=Math.pow(10,-9);
            if(units17.equals("ms")) n4/=Math.pow(10,-3);
            if(units17.equals("s"))  ;
            if(units17.equals("min")) n4/=(60);
            if(units17.equals("hr")) n4/=(60*60);
            if(units17.equals("day")) n4/=(60*60*24);
            if(units17.equals("yr")) n4/=(60*60*24*365);

            float n5;
            try {
                n5=Float.parseFloat(t18.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units19.equals("rad")) ;
            if(units19.equals("deg")) n5*=Math.PI/180.0;

            double n_=n4*n4*Math.sin(2*n5)/n0;

            if(units5.equals("nm")) n_/=Math.pow(10,-9);
            if(units5.equals("μm")) n_/=Math.pow(10,-6);
            if(units5.equals("mm")) n_/=Math.pow(10,-3);
            if(units5.equals("cm")) n_/=Math.pow(10,-2);
            if(units5.equals("dm")) n_/=Math.pow(10,-1);
            if(units5.equals("m"))  ;
            if(units5.equals("km")) n_/=Math.pow(10,3);
            if(units5.equals("Mm")) n_/=Math.pow(10,6);
            if(units5.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units7.equals("ns^2")) n_*=Math.pow(10,-9)*Math.pow(10,-9);
            if(units7.equals("ms^2")) n_*=Math.pow(10,-3)*Math.pow(10,-3);
            if(units7.equals("s^2"))  ;
            if(units7.equals("min^2")) n_*=(60*60);
            if(units7.equals("hr^2")) n_*=(60*60*60*60);
            if(units7.equals("day^2")) n_*=(60*60*24*60*60*24);
            if(units7.equals("yr^2")) n_*=(60*60*24*365*60*60*24*365);

            t4.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("h (Max height)") && t2.length()>0 && t4.length()>0 && t10.length()>0 && t14.length()>0 && t18.length()>0) {

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
                
            if(units7.equals("ns^2")) n1/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units7.equals("ms^2")) n1/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units7.equals("s^2"))  ;
            if(units7.equals("min^2")) n1/=(60*60);
            if(units7.equals("hr^2")) n1/=(60*60*60*60);
            if(units7.equals("day^2")) n1/=(60*60*24*60*60*24);
            if(units7.equals("yr^2")) n1/=(60*60*24*365*60*60*24*365);

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
                
            if(units13.equals("ns")) n3/=Math.pow(10,-9);
            if(units13.equals("ms")) n3/=Math.pow(10,-3);
            if(units13.equals("s"))  ;
            if(units13.equals("min")) n3/=(60);
            if(units13.equals("hr")) n3/=(60*60);
            if(units13.equals("day")) n3/=(60*60*24);
            if(units13.equals("yr")) n3/=(60*60*24*365);

            float n4;
            try {
                n4=Float.parseFloat(t14.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units15.equals("nm")) n4*=Math.pow(10,-9);
            if(units15.equals("μm")) n4*=Math.pow(10,-6);
            if(units15.equals("mm")) n4*=Math.pow(10,-3);
            if(units15.equals("cm")) n4*=Math.pow(10,-2);
            if(units15.equals("dm")) n4*=Math.pow(10,-1);
            if(units15.equals("m"))  ;
            if(units15.equals("km")) n4*=Math.pow(10,3);
            if(units15.equals("Mm")) n4*=Math.pow(10,6);
            if(units15.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units17.equals("ns")) n4/=Math.pow(10,-9);
            if(units17.equals("ms")) n4/=Math.pow(10,-3);
            if(units17.equals("s"))  ;
            if(units17.equals("min")) n4/=(60);
            if(units17.equals("hr")) n4/=(60*60);
            if(units17.equals("day")) n4/=(60*60*24);
            if(units17.equals("yr")) n4/=(60*60*24*365);

            float n5;
            try {
                n5=Float.parseFloat(t18.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units19.equals("rad")) ;
            if(units19.equals("deg")) n5*=Math.PI/180.0;

            double n_=n3*n3*Math.sin(n5)*Math.sin(n5)/(2*n1);

            if(units9.equals("nm")) n_/=Math.pow(10,-9);
            if(units9.equals("μm")) n_/=Math.pow(10,-6);
            if(units9.equals("mm")) n_/=Math.pow(10,-3);
            if(units9.equals("cm")) n_/=Math.pow(10,-2);
            if(units9.equals("dm")) n_/=Math.pow(10,-1);
            if(units9.equals("m"))  ;
            if(units9.equals("km")) n_/=Math.pow(10,3);
            if(units9.equals("Mm")) n_/=Math.pow(10,6);
            if(units9.equals("Gm")) n_/=Math.pow(10,9);

            t8.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("v0 (Initial velocity)") && t2.length()>0 && t4.length()>0 && t8.length()>0 && t14.length()>0 && t18.length()>0) {

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
                
            if(units7.equals("ns^2")) n1/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units7.equals("ms^2")) n1/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units7.equals("s^2"))  ;
            if(units7.equals("min^2")) n1/=(60*60);
            if(units7.equals("hr^2")) n1/=(60*60*60*60);
            if(units7.equals("day^2")) n1/=(60*60*24*60*60*24);
            if(units7.equals("yr^2")) n1/=(60*60*24*365*60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t8.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units9.equals("nm")) n2*=Math.pow(10,-9);
            if(units9.equals("μm")) n2*=Math.pow(10,-6);
            if(units9.equals("mm")) n2*=Math.pow(10,-3);
            if(units9.equals("cm")) n2*=Math.pow(10,-2);
            if(units9.equals("dm")) n2*=Math.pow(10,-1);
            if(units9.equals("m"))  ;
            if(units9.equals("km")) n2*=Math.pow(10,3);
            if(units9.equals("Mm")) n2*=Math.pow(10,6);
            if(units9.equals("Gm")) n2*=Math.pow(10,9);

            float n4;
            try {
                n4=Float.parseFloat(t14.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units15.equals("nm")) n4*=Math.pow(10,-9);
            if(units15.equals("μm")) n4*=Math.pow(10,-6);
            if(units15.equals("mm")) n4*=Math.pow(10,-3);
            if(units15.equals("cm")) n4*=Math.pow(10,-2);
            if(units15.equals("dm")) n4*=Math.pow(10,-1);
            if(units15.equals("m"))  ;
            if(units15.equals("km")) n4*=Math.pow(10,3);
            if(units15.equals("Mm")) n4*=Math.pow(10,6);
            if(units15.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units17.equals("ns")) n4/=Math.pow(10,-9);
            if(units17.equals("ms")) n4/=Math.pow(10,-3);
            if(units17.equals("s"))  ;
            if(units17.equals("min")) n4/=(60);
            if(units17.equals("hr")) n4/=(60*60);
            if(units17.equals("day")) n4/=(60*60*24);
            if(units17.equals("yr")) n4/=(60*60*24*365);

            float n5;
            try {
                n5=Float.parseFloat(t18.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units19.equals("rad")) ;
            if(units19.equals("deg")) n5*=Math.PI/180.0;

            double n_=Math.sqrt(n2*2*n1/(Math.sin(n5)*Math.sin(n5)));

            if(units11.equals("nm")) n_/=Math.pow(10,-9);
            if(units11.equals("μm")) n_/=Math.pow(10,-6);
            if(units11.equals("mm")) n_/=Math.pow(10,-3);
            if(units11.equals("cm")) n_/=Math.pow(10,-2);
            if(units11.equals("dm")) n_/=Math.pow(10,-1);
            if(units11.equals("m"))  ;
            if(units11.equals("km")) n_/=Math.pow(10,3);
            if(units11.equals("Mm")) n_/=Math.pow(10,6);
            if(units11.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units13.equals("ns")) n_*=Math.pow(10,-9);
            if(units13.equals("ms")) n_*=Math.pow(10,-3);
            if(units13.equals("s"))  ;
            if(units13.equals("min")) n_*=(60);
            if(units13.equals("hr")) n_*=(60*60);
            if(units13.equals("day")) n_*=(60*60*24);
            if(units13.equals("yr")) n_*=(60*60*24*365);

            t10.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("v (Current velocity)") && t2.length()>0 && t4.length()>0 && t8.length()>0 && t10.length()>0 && t18.length()>0) {

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
                
            if(units7.equals("ns^2")) n1/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units7.equals("ms^2")) n1/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units7.equals("s^2"))  ;
            if(units7.equals("min^2")) n1/=(60*60);
            if(units7.equals("hr^2")) n1/=(60*60*60*60);
            if(units7.equals("day^2")) n1/=(60*60*24*60*60*24);
            if(units7.equals("yr^2")) n1/=(60*60*24*365*60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t8.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units9.equals("nm")) n2*=Math.pow(10,-9);
            if(units9.equals("μm")) n2*=Math.pow(10,-6);
            if(units9.equals("mm")) n2*=Math.pow(10,-3);
            if(units9.equals("cm")) n2*=Math.pow(10,-2);
            if(units9.equals("dm")) n2*=Math.pow(10,-1);
            if(units9.equals("m"))  ;
            if(units9.equals("km")) n2*=Math.pow(10,3);
            if(units9.equals("Mm")) n2*=Math.pow(10,6);
            if(units9.equals("Gm")) n2*=Math.pow(10,9);

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
                
            if(units13.equals("ns")) n3/=Math.pow(10,-9);
            if(units13.equals("ms")) n3/=Math.pow(10,-3);
            if(units13.equals("s"))  ;
            if(units13.equals("min")) n3/=(60);
            if(units13.equals("hr")) n3/=(60*60);
            if(units13.equals("day")) n3/=(60*60*24);
            if(units13.equals("yr")) n3/=(60*60*24*365);

            float n5;
            try {
                n5=Float.parseFloat(t18.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units19.equals("rad")) ;
            if(units19.equals("deg")) n5*=Math.PI/180.0;

            double n_=Math.sqrt(n0*n1/Math.sin(2*n5));

            if(units15.equals("nm")) n_/=Math.pow(10,-9);
            if(units15.equals("μm")) n_/=Math.pow(10,-6);
            if(units15.equals("mm")) n_/=Math.pow(10,-3);
            if(units15.equals("cm")) n_/=Math.pow(10,-2);
            if(units15.equals("dm")) n_/=Math.pow(10,-1);
            if(units15.equals("m"))  ;
            if(units15.equals("km")) n_/=Math.pow(10,3);
            if(units15.equals("Mm")) n_/=Math.pow(10,6);
            if(units15.equals("Gm")) n_/=Math.pow(10,9);
                
            if(units17.equals("ns")) n_*=Math.pow(10,-9);
            if(units17.equals("ms")) n_*=Math.pow(10,-3);
            if(units17.equals("s"))  ;
            if(units17.equals("min")) n_*=(60);
            if(units17.equals("hr")) n_*=(60*60);
            if(units17.equals("day")) n_*=(60*60*24);
            if(units17.equals("yr")) n_*=(60*60*24*365);

            t14.setText(String.format("%.2e",n_));
        }
        if(solveFor.equals("θ (Angle)") && t2.length()>0 && t4.length()>0 && t8.length()>0 && t10.length()>0 && t14.length()>0) {

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
                
            if(units7.equals("ns^2")) n1/=Math.pow(10,-9)*Math.pow(10,-9);
            if(units7.equals("ms^2")) n1/=Math.pow(10,-3)*Math.pow(10,-3);
            if(units7.equals("s^2"))  ;
            if(units7.equals("min^2")) n1/=(60*60);
            if(units7.equals("hr^2")) n1/=(60*60*60*60);
            if(units7.equals("day^2")) n1/=(60*60*24*60*60*24);
            if(units7.equals("yr^2")) n1/=(60*60*24*365*60*60*24*365);

            float n2;
            try {
                n2=Float.parseFloat(t8.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units9.equals("nm")) n2*=Math.pow(10,-9);
            if(units9.equals("μm")) n2*=Math.pow(10,-6);
            if(units9.equals("mm")) n2*=Math.pow(10,-3);
            if(units9.equals("cm")) n2*=Math.pow(10,-2);
            if(units9.equals("dm")) n2*=Math.pow(10,-1);
            if(units9.equals("m"))  ;
            if(units9.equals("km")) n2*=Math.pow(10,3);
            if(units9.equals("Mm")) n2*=Math.pow(10,6);
            if(units9.equals("Gm")) n2*=Math.pow(10,9);

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
                
            if(units13.equals("ns")) n3/=Math.pow(10,-9);
            if(units13.equals("ms")) n3/=Math.pow(10,-3);
            if(units13.equals("s"))  ;
            if(units13.equals("min")) n3/=(60);
            if(units13.equals("hr")) n3/=(60*60);
            if(units13.equals("day")) n3/=(60*60*24);
            if(units13.equals("yr")) n3/=(60*60*24*365);

            float n4;
            try {
                n4=Float.parseFloat(t14.getText().toString());
            }
            catch (NumberFormatException e) {
                return;
            }

            if(units15.equals("nm")) n4*=Math.pow(10,-9);
            if(units15.equals("μm")) n4*=Math.pow(10,-6);
            if(units15.equals("mm")) n4*=Math.pow(10,-3);
            if(units15.equals("cm")) n4*=Math.pow(10,-2);
            if(units15.equals("dm")) n4*=Math.pow(10,-1);
            if(units15.equals("m"))  ;
            if(units15.equals("km")) n4*=Math.pow(10,3);
            if(units15.equals("Mm")) n4*=Math.pow(10,6);
            if(units15.equals("Gm")) n4*=Math.pow(10,9);
                
            if(units17.equals("ns")) n4/=Math.pow(10,-9);
            if(units17.equals("ms")) n4/=Math.pow(10,-3);
            if(units17.equals("s"))  ;
            if(units17.equals("min")) n4/=(60);
            if(units17.equals("hr")) n4/=(60*60);
            if(units17.equals("day")) n4/=(60*60*24);
            if(units17.equals("yr")) n4/=(60*60*24*365);

            double n_=Math.asin(n0*n1*n4*n4)/2;

            if(units19.equals("rad")) ;
            if(units19.equals("deg")) n_/=Math.PI/180.0;

            t18.setText(String.format("%.2e",n_));
        }
    }
    Resources res;
}