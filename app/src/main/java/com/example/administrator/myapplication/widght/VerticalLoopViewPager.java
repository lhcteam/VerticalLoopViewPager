package com.example.administrator.myapplication.widght;

import android.content.Context;
import android.support.v4.view.LoopViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/12/15.
 */

    public class VerticalLoopViewPager extends LoopViewPager {

        public VerticalLoopViewPager(Context context) {
            super(context);
        }

        public VerticalLoopViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        private MotionEvent swapTouchEvent(MotionEvent event) {
            float width = getWidth();
            float height = getHeight();
            event.setLocation((event.getY() / height) * width, (event.getX() / width) * height);
            return event;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
            return super.onInterceptTouchEvent(swapTouchEvent(MotionEvent.obtain(event)));
        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            return super.onTouchEvent(swapTouchEvent(MotionEvent.obtain(ev)));
        }
    }


