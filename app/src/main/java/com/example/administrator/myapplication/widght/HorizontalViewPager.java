package com.example.administrator.myapplication.widght;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by Administrator on 2017/12/15.
 */

public class HorizontalViewPager extends ViewPager {
    private float mDownX;
    private float mDownY;
    private float mTouchSlop;

    public HorizontalViewPager(Context context) {
        super(context);
        init(context);
    }

    public HorizontalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercept = super.onInterceptTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = x;
                mDownY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - mDownX);
                float dy = Math.abs(y - mDownY);
                if (!intercept && dx > mTouchSlop && dx * 0.5f > dy) {
                    intercept = true;
                }
                break;
            default:
                break;
        }
        return intercept;
    }
}


