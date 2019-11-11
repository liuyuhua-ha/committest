package com.bigface.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigface.studyproject.remote_service.RemoteTestActivity;
import com.bigface.studyproject.service.ServiceTestActivity;



public class MainActivity extends SuperActivtiy implements View.OnClickListener, View.OnTouchListener {

    public volatile  int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(this);
        tv.setOnTouchListener(this);

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
    public void onClick(View view) {
        LogUtil.e("onClick");
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ServiceTestActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.e("ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("ACTION_UP ");
                break;
        }
        return false;
    }

    public void onRemoteClick(View view){
        startActivity(new Intent(this, RemoteTestActivity.class));
    }
}
