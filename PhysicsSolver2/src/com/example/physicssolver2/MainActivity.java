/*package com.example.physicssolver2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void pendulumClick(View view) {
        Intent anIntent=new Intent(view.getContext(),PendulumActivity.class);
        startActivity(anIntent);
        //finish();
    }

}
*/

package com.example.physicssolver2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        //listview group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + "Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + "Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition)
                +  " : "
                + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();

                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Vectors")
                {
                    Intent anIntent=new Intent(v.getContext(),PendulumActivity.class);
                    startActivity(anIntent);
                }

                return false;
            }

        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //HEADERS
        listDataHeader.add("Motion in One Dimension");
        listDataHeader.add("Motion in Two Dimensions");
        listDataHeader.add("Forces and Newton's Laws");
        listDataHeader.add("Momentum and Impulse");
        listDataHeader.add("Collisions");
        listDataHeader.add("Work and Energy");
        listDataHeader.add("Circular Motion and Rotation");

        //CHILDREN
        List<String> motionInOneDimension = new ArrayList<String>();
        motionInOneDimension.add("Constant Velocity Motion");
        motionInOneDimension.add("Accelerated Straight-Line Motion");
        motionInOneDimension.add("Two Objects Moving Apart on Same Line");

        List<String> motionInTwoDimenions = new ArrayList<String>();
        motionInTwoDimenions.add("Free Fall");
        motionInTwoDimenions.add("Ideal Projectile Motion");

        List<String> newtonsLaws = new ArrayList<String>();
        newtonsLaws.add("Newton's Laws");
        newtonsLaws.add("Weight and Normal Force");
        newtonsLaws.add("Pendulums");
        newtonsLaws.add("Friction on a Flat Plane");
        newtonsLaws.add("Friction on an Inclined Plane");

        List<String> momentumAndImpulse= new ArrayList<String>();
        momentumAndImpulse.add("Momentum");
        momentumAndImpulse.add("Impulse");
        momentumAndImpulse.add("Impulse-Momentum Theorem");
        momentumAndImpulse.add("Conservation of Momentum");

        List<String> Collisions = new ArrayList<String>();
        Collisions.add("Elastic Collisions of Two Objects");
        Collisions.add("Inelastic Collisions of Two Objects");
        Collisions.add("Completely Inelastic Collisions");

        List<String> workAndEnergy = new ArrayList<String>();
        workAndEnergy.add("Conservation of Energy");
        workAndEnergy.add("Kinetic Energy");
        workAndEnergy.add("Gravitational Potential Energy");
        workAndEnergy.add("Work");
        workAndEnergy.add("Power");

        List<String> circularMotion = new ArrayList<String>();
        circularMotion.add("Arc Length and Radians");
        circularMotion.add("Uniform Circular Motion");
        circularMotion.add("Centripetal Force");
        circularMotion.add("Moment of Inertia");
        circularMotion.add("Torque");

        listDataChild.put(listDataHeader.get(0), motionInOneDimension);
        listDataChild.put(listDataHeader.get(1), motionInTwoDimenions);
        listDataChild.put(listDataHeader.get(2), newtonsLaws);
		listDataChild.put(listDataHeader.get(3), momentumAndImpulse);
		listDataChild.put(listDataHeader.get(4), Collisions);
		listDataChild.put(listDataHeader.get(5), workAndEnergy);
		listDataChild.put(listDataHeader.get(6), circularMotion);

    }
}
