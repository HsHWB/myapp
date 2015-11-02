package com.example.sliding.mainview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
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
    private VelocityTracker vt = null;
    private Context mContext;
    private DisplayMetrics dm;
    private WindowManager wm;
    private ViewGroup menu;
    private View alphView;

    public SlidingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        dm = new DisplayMetrics();
        wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        this.screenWidth = dm.widthPixels;



    }

    /**
     * 定义view在父布局中的位置
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        this.scrollTo(menuWidth, 0);
        super.onLayout(changed, l, t, r, b);
    }

    /**
     * 定义view的长宽，大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        LinearLayout ll = (LinearLayout)getChildAt(0);
        alphView = (View)ll.getChildAt(0);
        LinearLayout contentLayout = (LinearLayout)ll.getChildAt(1);
        LinearLayout.LayoutParams contentll = new LinearLayout.LayoutParams(
                this.screenWidth,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        contentLayout.setLayoutParams(contentll);

        /**
         *  dp转成px
         */

        menuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                menuRightPadding, contentLayout.getResources().getDisplayMetrics());

        menuWidth = alphView.getWidth();
        halfMenuWidth = menuWidth/2;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action){

//            case MotionEvent.ACTION_DOWN:
//                if (vt == null){
//                    vt = VelocityTracker.obtain();
//                }else {
//                    vt.clear();
//                }
//                vt.addMovement(ev);
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                vt.addMovement(ev);
//                //代表的是监测每1000毫秒手指移动的距离（像素）即m/px，这是用来控制vt的单位，
//                // 若括号内为1，则代表1毫秒手指移动过的像素数即ms/px
//                vt.computeCurrentVelocity(100);
//                //这里x为正则代表手指向右滑动，为负则代表手指向左滑动，y的比较特殊，
//                // 为正则代表手指向下滑动，为负则代表手指向上滑动
//                Log.i("vt X",String.valueOf(vt.getXVelocity()));
//                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                /**
                 * getScrollX(): x - (左滑为负数，右滑为正数)
                 * 就是当前view的左上角相对于母视图的左上角的X轴偏移量。
                 */
                if (scrollX > halfMenuWidth){
                    alphView.setVisibility(View.VISIBLE);
                    this.smoothScrollTo(menuWidth, 0);
                }else{
                    alphView.setVisibility(View.INVISIBLE);
                    this.smoothScrollTo(0,0);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

    }
}
