package com.example.sliding.mainview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    public static Button slidingCoverButton;
    public static float screenWidth;
    public static float screenHeight;
    private SlidingView slidingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenHeight = WindowsUtlls.getWindowHeight(getApplicationContext());
        screenWidth = WindowsUtlls.getWindowWidth(getApplicationContext());

//        initView();
    }


}
