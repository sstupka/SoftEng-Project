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
        listDataHeader.add("Straight Line Motion");
        listDataHeader.add("Motion in Two and Three Dimensions");
        listDataHeader.add("Force");
        listDataHeader.add("Kinetic Energy");
        listDataHeader.add("Work and Power");
        listDataHeader.add("Potential Energy and Energy Conservation");
        listDataHeader.add("Momemtum");
        listDataHeader.add("Collisions");
        listDataHeader.add("Circular Motion");
        listDataHeader.add("Gravitation");


        //CHILDREN
        List<String> slm = new ArrayList<String>();
        slm.add("Vectors");
        slm.add("Constant Acceleration");

        List<String> mittd = new ArrayList<String>();
        mittd.add("Ideal Projectile Motion");
        mittd.add("Maximum Height and Range");
        mittd.add("Realistic Projectile Motion");

        List<String> force = new ArrayList<String>();
        force.add("Weight and Mass");
        force.add("Newton's Laws");
        force.add("Ropes and Pulleys");

        listDataChild.put(listDataHeader.get(0), slm);
        listDataChild.put(listDataHeader.get(1), mittd);
        listDataChild.put(listDataHeader.get(2), force);
    }
}