inputFile=open("test1.database",'r')

unitDict={ #RBF needs mroe units
    "m":"meterUnits",
    "m^2":"meterUnitsSquared",
    "m^3":"meterUnitsCubed",
    "s":"timeUnits",
    "s^2":"timeUnitsSquared",
    "s^3":"timeUnitsCubed"
    }

def unitsMath(varNum,starOrDiv,units,unitsNum): #RBF Needs more units
    if(units=="m"):
        return '''

            if(units'''+str(unitsNum)+'''.equals("nm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-9);
            if(units'''+str(unitsNum)+'''.equals("μm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-6);
            if(units'''+str(unitsNum)+'''.equals("mm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-3);
            if(units'''+str(unitsNum)+'''.equals("cm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-2);
            if(units'''+str(unitsNum)+'''.equals("dm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-1);
            if(units'''+str(unitsNum)+'''.equals("m"))  ;
            if(units'''+str(unitsNum)+'''.equals("km")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,3);
            if(units'''+str(unitsNum)+'''.equals("Mm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,6);
            if(units'''+str(unitsNum)+'''.equals("Gm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,9);'''
    if(units=="m^2"):
        return '''

            if(units'''+str(unitsNum)+'''.equals("nm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-9)*Math.pow(10,-9);
            if(units'''+str(unitsNum)+'''.equals("μm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-6)*Math.pow(10,-6);
            if(units'''+str(unitsNum)+'''.equals("mm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-3)*Math.pow(10,-3);
            if(units'''+str(unitsNum)+'''.equals("cm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-2)*Math.pow(10,-2);
            if(units'''+str(unitsNum)+'''.equals("dm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-1)*Math.pow(10,-1);
            if(units'''+str(unitsNum)+'''.equals("m"))  ;
            if(units'''+str(unitsNum)+'''.equals("km")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,3)*Math.pow(10,3);
            if(units'''+str(unitsNum)+'''.equals("Mm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,6)*Math.pow(10,6);
            if(units'''+str(unitsNum)+'''.equals("Gm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,9)*Math.pow(10,9);'''
    if(units=="m^3"):
        return '''

            if(units'''+str(unitsNum)+'''.equals("nm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-9)*Math.pow(10,-9)*Math.pow(10,-9);
            if(units'''+str(unitsNum)+'''.equals("μm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-6)*Math.pow(10,-6)*Math.pow(10,-6);
            if(units'''+str(unitsNum)+'''.equals("mm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-3)*Math.pow(10,-3)*Math.pow(10,-3);
            if(units'''+str(unitsNum)+'''.equals("cm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-2)*Math.pow(10,-2)*Math.pow(10,-2);
            if(units'''+str(unitsNum)+'''.equals("dm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,-1)*Math.pow(10,-1)*Math.pow(10,-1);
            if(units'''+str(unitsNum)+'''.equals("m"))  ;
            if(units'''+str(unitsNum)+'''.equals("km")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,3)*Math.pow(10,3)*Math.pow(10,3);
            if(units'''+str(unitsNum)+'''.equals("Mm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,6)*Math.pow(10,6)*Math.pow(10,6);
            if(units'''+str(unitsNum)+'''.equals("Gm")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,9)*Math.pow(10,9)*Math.pow(10,9);'''
    if(units=="s"):
        return '''
                
            if(units'''+str(unitsNum)+'''.equals("ns")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,9);
            if(units'''+str(unitsNum)+'''.equals("ms")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,3);
            if(units'''+str(unitsNum)+'''.equals("s"))  ;
            if(units'''+str(unitsNum)+'''.equals("min")) n'''+str(varNum)+starOrDiv+'''=1.0/(60);
            if(units'''+str(unitsNum)+'''.equals("hr")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60);
            if(units'''+str(unitsNum)+'''.equals("day")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*24);
            if(units'''+str(unitsNum)+'''.equals("yr")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*24*365);'''
    if(units=="s^2"):
        return '''
                
            if(units'''+str(unitsNum)+'''.equals("ns")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,9)*Math.pow(10,9);
            if(units'''+str(unitsNum)+'''.equals("ms")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,3)*Math.pow(10,3);
            if(units'''+str(unitsNum)+'''.equals("s"))  ;
            if(units'''+str(unitsNum)+'''.equals("min")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60);
            if(units'''+str(unitsNum)+'''.equals("hr")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*60*60);
            if(units'''+str(unitsNum)+'''.equals("day")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*24*60*60*24);
            if(units'''+str(unitsNum)+'''.equals("yr")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*24*365*60*60*24*365);'''
    if(units=="s^3"):
        return '''
                
            if(units'''+str(unitsNum)+'''.equals("ns")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,9)*Math.pow(10,9)*Math.pow(10,9);
            if(units'''+str(unitsNum)+'''.equals("ms")) n'''+str(varNum)+starOrDiv+'''=Math.pow(10,3)*Math.pow(10,3)*Math.pow(10,3);
            if(units'''+str(unitsNum)+'''.equals("s"))  ;
            if(units'''+str(unitsNum)+'''.equals("min")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*60);
            if(units'''+str(unitsNum)+'''.equals("hr")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*60*60*60*60);
            if(units'''+str(unitsNum)+'''.equals("day")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*24*60*60*24*60*60*24);
            if(units'''+str(unitsNum)+'''.equals("yr")) n'''+str(varNum)+starOrDiv+'''=1.0/(60*60*24*365*60*60*24*365*60*60*24*365);'''
    return '' #Unrecognized units

for activity in inputFile.read().split("\n\n\n\n"): #3 blank lines is 4 /n's
    fields=activity.split("\n\n")
    
    javaSave=['''''']*3+[[[],[],[]]]+['''''']*0 #Save code to be written in various places throughout the java file here.
    #element 3 is lists of EditText t#, and associated spinner units#. In database order.

    #Begin writing XML Code
    outputXmlFile=open("res/layout/"+fields[2].lower()+".xml",'w')

    #Header
    outputXmlFile.write('''<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:tools="http://schemas.android.com/tools"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:paddingBottom="@dimen/activity_vertical_margin"
              android:paddingLeft="@dimen/activity_horizontal_margin"
              android:paddingRight="@dimen/activity_horizontal_margin"
              android:paddingTop="@dimen/activity_vertical_margin"
              tools:context=".'''+fields[2]+'''"
              android:orientation="vertical" >''')

    i=0
    for image in fields[0].split("\n"): #Populate image entries
        imageFields=image.split(";")
        i+=1
        outputXmlFile.write('''

    <ImageView
            android:id="@+id/imageView'''+str(i)+'''"
            android:layout_width="'''+imageFields[1]+'''dp"
            android:layout_height="'''+imageFields[2]+'''dp"
            android:layout_gravity="center_horizontal"
            android:contentDescription="@string/image"
            android:src="@drawable/'''+imageFields[0]+'''" />''')

    strings=open("res/values/strings.xml",'r') #Need to define a new string array for the solve for drop down menu.
    allStrings=strings.read()
    if (fields[2]+"SolveFor") not in allStrings:
        newString='''   <string-array name="'''+fields[2]+"SolveFor"+'''">
'''
        for entry in fields[1].split("\n"):
            newString+='''        <item>'''+entry.split(";")[1]+'''</item>
'''
        newString+='''    </string-array>'''
        allStrings=allStrings.split("\n")
        allStrings.insert(-2,newString)
        strings.close()
        strings=open("res/values/strings.xml",'w')
        strings.write("\n".join(allStrings))
    strings.close()

    outputXmlFile.write('''

<LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal" >

        <TextView
                android:id="@+id/textView1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:text="@string/solve_for_"
                android:textSize="15sp" />

        <Spinner
                android:id="@+id/spinner1"
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_weight="1"
                android:entries="@array/'''+fields[2]+'''SolveFor" />

    </LinearLayout>''')

    i=1
    for var in fields[1].split("\n"): #Generate variables section
        i+=1
        varFields=var.split(";")
        
        strings=open("res/values/strings.xml",'r') #Need to define a new string for each var's text field
        allStrings=strings.read()
        if (varFields[0]+"_") not in allStrings:
            allStrings=allStrings.split("\n")
            allStrings.insert(-2,'''<string name="'''+varFields[0]+'''_">'''+varFields[0]+'''=</string>''')
            strings.close()
            strings=open("res/values/strings.xml",'w')
            strings.write("\n".join(allStrings))
        strings.close()
        
        outputXmlFile.write('''

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal" >

        <TextView
                android:id="@+id/textView'''+str(i)+'''"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/'''+varFields[0]+'''_"
                android:textSize="20sp" />

        <EditText
                android:id="@+id/editText'''+str(i)+'''"
                android:layout_width="100dp"
                android:layout_height="wrap_content"
                android:ems="10"
                android:filterTouchesWhenObscured="true"
                android:inputType="number|numberDecimal" />''')

        javaSave[0]+='''
        EditText t'''+str(i)+'''=(EditText)findViewById(R.id.editText'''+str(i)+''');
        t'''+str(i)+'''.addTextChangedListener(updateAnswer);'''
        javaSave[2]+='''
        EditText t'''+str(i)+'''=(EditText)findViewById(R.id.editText'''+str(i)+''');'''
        javaSave[3][0].append(i) #edit text and textview numbers are the same
        javaSave[3][1].append([])
        javaSave[3][2].append([])

        fraction=varFields[2].split("/")
        if len(fraction)==2: #Has a denominator
            units=fraction[0].split("*")
            for unit in units[:-1]:
                i+=1
                outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />

        <TextView
                android:id="@+id/textView'''+str(i)+'''"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:text="@string/star"
                android:textAppearance="?android:attr/textAppearanceSmall"
                android:textSize="20sp" />''')
                javaSave[1]+='''
        Spinner units'''+str(i)+'''=(Spinner)findViewById(R.id.spinner'''+str(i)+''');
        units'''+str(i)+'''.setOnItemSelectedListener(updateUnits);'''
                javaSave[3][1][-1].append(i)
                javaSave[3][2][-1].append(unit)
                
            unit=units[-1]
            i+=1
            outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />''')
            javaSave[1]+='''
        Spinner units'''+str(i)+'''=(Spinner)findViewById(R.id.spinner'''+str(i)+''');
        units'''+str(i)+'''.setOnItemSelectedListener(updateUnits);'''
            javaSave[3][1][-1].append(i)
            javaSave[3][2][-1].append(unit)

            i+=1 #write the "/" symbol
            outputXmlFile.write('''

        <TextView
                android:id="@+id/textView'''+str(i)+'''"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:text="@string/slash"
                android:textAppearance="?android:attr/textAppearanceSmall"
                android:textSize="20sp" />''')
            
            units=fraction[1].split("*")
            for unit in units[:-1]:
                i+=1
                outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />

        <TextView
                android:id="@+id/textView'''+str(i)+'''"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:text="@string/star"
                android:textAppearance="?android:attr/textAppearanceSmall"
                android:textSize="20sp" />''')
                javaSave[1]+='''
        Spinner units'''+str(i)+'''=(Spinner)findViewById(R.id.spinner'''+str(i)+''');
        units'''+str(i)+'''.setOnItemSelectedListener(updateUnits);'''
                javaSave[3][1][-1].append(i)
                javaSave[3][2][-1].append(unit)
                
            unit=units[-1]
            i+=1
            outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />''')
            javaSave[1]+='''
        Spinner units'''+str(i)+'''=(Spinner)findViewById(R.id.spinner'''+str(i)+''');
        units'''+str(i)+'''.setOnItemSelectedListener(updateUnits);'''
            javaSave[3][1][-1].append(i)
            javaSave[3][2][-1].append(unit)

        else: #No denominator
            units=fraction[0].split("*")
            for unit in units[:-1]:
                i+=1
                outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />

        <TextView
                android:id="@+id/textView'''+str(i)+'''"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:text="@string/star"
                android:textAppearance="?android:attr/textAppearanceSmall"
                android:textSize="20sp" />''')
                javaSave[1]+='''
        Spinner units'''+str(i)+'''=(Spinner)findViewById(R.id.spinner'''+str(i)+''');
        units'''+str(i)+'''.setOnItemSelectedListener(updateUnits);'''
                javaSave[3][1][-1].append(i)
                javaSave[3][2][-1].append(unit)
                
            unit=units[-1]
            i+=1
            outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />''')
            javaSave[1]+='''
        Spinner units'''+str(i)+'''=(Spinner)findViewById(R.id.spinner'''+str(i)+''');
        units'''+str(i)+'''.setOnItemSelectedListener(updateUnits);'''
            javaSave[3][1][-1].append(i)
            javaSave[3][2][-1].append(unit)
        outputXmlFile.write('''

    </LinearLayout>''')
    
    outputXmlFile.write('''

</LinearLayout>''')
    outputXmlFile.close()

    #Begin Writing Java Code
    outputJavaFile=open("src/com/example/physicssolver2/"+fields[2]+".java",'w')

    outputJavaFile.write('''package com.example.physicssolver2;
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

public class '''+fields[2]+''' extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.'''+fields[2].lower()+''');

        Spinner solveFor=(Spinner)findViewById(R.id.spinner1);
        solveFor.setOnItemSelectedListener(updateSolveFor);
        ''')

    outputJavaFile.write(javaSave[0])
    outputJavaFile.write(javaSave[1]) #RBF need to remove text change watcher before updating target text field!

    outputJavaFile.write('''
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pendulum, menu);
        return true;
    }
    
    TextWatcher updateAnswer=new TextWatcher(){
        private EditText e;
        private String old="";

        public void updateAnswer(EditText et) { 
            e=et;
        }

        public void afterTextChanged(Editable s) {
            if(!e.getText().equals(old)) { //Prevents recursion here.
                updateAll();
            }
            old=e.getText().toString();

            /*e.removeTextChangedListener(this);
            updateAll();
            e.addTextChangedListener(this);*/
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
    
    private void updateAll() {''')

    outputJavaFile.write(javaSave[2])
    outputJavaFile.write('''
        String solveFor=((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();''')

    for units in javaSave[3][1]:
        for unit in units:
            outputJavaFile.write('''
        String units'''+str(unit)+'''=((Spinner)findViewById(R.id.spinner'''+str(unit)+''')).getSelectedItem().toString();''')

    i=-1
    for var in fields[1].split("\n"): #Solve for calculations for each variable
        i+=1
        varFields=var.split(";")

        outputJavaFile.write('''
        if(solveFor.equals("'''+varFields[1]+'''")''')
        k=-1
        for editTextNum in javaSave[3][0]:
            k+=1
            if k!=i:
                outputJavaFile.write(''' && t'''+str(editTextNum)+'''.length()>0''')
        outputJavaFile.write(''') {''')

        k=-1
        for editText in javaSave[3][0]: #Inputs
            k+=1
            if k!=i:
                outputJavaFile.write('''

            float n'''+str(k)+'''=Float.parseFloat(t'''+str(editText)+'''.getText().toString());''')
                L=-1
                outputJavaFile.close()
                outputJavaFile=open("src/com/example/physicssolver2/"+fields[2]+".java",'ab') #Now writing a byte stream since this portion of the code writes unicode characters
                for units in javaSave[3][1][k]:
                    L+=1
                    outputJavaFile.write(unitsMath(k,'*',javaSave[3][2][k][L],units).encode('utf8'))
                outputJavaFile.close()
                outputJavaFile=open("src/com/example/physicssolver2/"+fields[2]+".java",'a')

        #Answer!
        outputJavaFile.write('''

            double n_='''+varFields[3]+''';''')
        L=-1
        for units in javaSave[3][1][i]:
            L+=1
            outputJavaFile.close()
            outputJavaFile=open("src/com/example/physicssolver2/"+fields[2]+".java",'ab') #Now writing a byte stream since this portion of the code writes unicode characters
            outputJavaFile.write(unitsMath('_','/',javaSave[3][2][i][L],units).encode('utf8'))
            outputJavaFile.close()
            outputJavaFile=open("src/com/example/physicssolver2/"+fields[2]+".java",'a')

        outputJavaFile.write('''

            t'''+str(javaSave[3][0][i])+'''.setText(String.format("%.2e",n_));
        }''')
    outputJavaFile.write('''
    }
    
    AdapterView.OnItemSelectedListener updateSolveFor = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
            updateAll();
        }
        public void onNothingSelected(AdapterView<?> adapterView) {} 
    };
    Resources res;
}''')

    outputJavaFile.close()

inputFile.close()
        