inputFile=open("test1.database",'r')

unitDict={
    "m":"meterUnits",
    "m^2":"meterUnitsSquared",
    "m^2":"meterUnitsCubed",
    "s":"timeUnits",
    "s^2":"timeUnitsSquared",
    "s^2":"timeUnitsCubed"
    }

for activity in inputFile.read().split("\n\n\n\n"): #3 blank lines is 4 /n's
    fields=activity.split("\n\n")
    outputJavaFile=open("src/com/example/physicssolver2/"+fields[2]+".java",'w')
    outputXmlFile=open("res/layout/"+fields[2]+".xml",'w')

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
        newString='''	<string-array name="'''+fields[2]+"SolveFor"+'''">
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
                android:entries="@array/PendulumSolveFor" />

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
                
            unit=units[-1]
            i+=1
            outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />''')

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
                
            unit=units[-1]
            i+=1
            outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />''')
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
                
            unit=units[-1]
            i+=1
            outputXmlFile.write('''

        <Spinner
                android:id="@+id/spinner'''+str(i)+'''"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:entries="@array/'''+unitDict[unit]+'''" />''')
        outputXmlFile.write('''

    </LinearLayout>''')
    
    outputXmlFile.write('''

</LinearLayout>''')
    outputJavaFile.close()
    outputXmlFile.close()

inputFile.close()
        
