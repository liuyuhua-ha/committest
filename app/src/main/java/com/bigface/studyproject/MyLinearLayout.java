package com.bigface.studyproject;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.e("ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("ACTION_UP ");
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.e("ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("ACTION_UP ");
                break;
        }
        return super.onTouchEvent(event);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.e("ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("ACTION_UP ");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
