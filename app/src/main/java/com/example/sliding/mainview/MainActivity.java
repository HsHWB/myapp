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

        initView();
    }

    private void initView(){
        slidingView = (SlidingView) this.findViewById(R.id.main_slidingview);

        slidingCoverButton = (Button) this.findViewById(R.id.sliding_cover_button);

        slidingCoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingView.menuClose();
            }
        });
        slidingCoverButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    public static void setSlidingCoverButtonSize(int menuWidth){
        /**
         * button
         */
        RelativeLayout.LayoutParams buttonViewll = new RelativeLayout.LayoutParams(
                (int) screenWidth - menuWidth,
                (int)(screenHeight+1)
        );
        buttonViewll.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        slidingCoverButton.setLayoutParams(buttonViewll);
    }

    public static void setSlidingCoverButtonOn() {
        slidingCoverButton.setVisibility(View.VISIBLE);
    }

    public static void setSlidingCoverButtonClose() {
        slidingCoverButton.setVisibility(View.GONE);
    }
}
