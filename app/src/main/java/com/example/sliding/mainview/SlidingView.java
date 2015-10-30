package com.example.sliding.mainview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by bingoo on 2015/10/30.
 */
public class SlidingView extends HorizontalScrollView {

    private int menuWidth;
    private int menuRightPadding = 100;
    private int halfMenuWidth;
    private int screenWidth;//屏幕宽度
    private Context mContext;
    private DisplayMetrics dm;
    private WindowManager wm;
    private ViewGroup menu;

    public SlidingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        dm = new DisplayMetrics();
        wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        this.screenWidth = dm.widthPixels;



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        this.scrollTo(menuWidth,0);
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        LinearLayout ll = (LinearLayout)getChildAt(0);
        View alphView = (View)ll.getChildAt(0);
        LinearLayout contentLayout = (LinearLayout)ll.getChildAt(1);

        /**
         *  dp转成px
         */

        menuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                menuRightPadding, contentLayout.getResources().getDisplayMetrics());

        menuWidth = screenWidth - menuRightPadding;
        halfMenuWidth = menuWidth/2;
        alphView.getLayoutParams().width = menuWidth;
        contentLayout.getLayoutParams().width = screenWidth;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
