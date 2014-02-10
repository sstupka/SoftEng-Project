package com.example.GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.ViewGroup;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    // Following is the method to ensure that when the view ontaing this
    // horizontal list is touched, rather than swiping between adjacent tabs
    // (using left and right swipe), the list can be scrolled.
    @Override
    public boolean onTouchEvent(MotionEvent p_event) {
        if (p_event.getAction() == MotionEvent.ACTION_MOVE
                && getParent() != null) {
            //getParent().requestDisallowInterceptTouchEvent(true);
        }

        return super.onTouchEvent(p_event);
    }
}
