package com.bigface.studyproject;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;

public class SuperActivtiy extends Activity {

    public String TAG = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(getClass().getName() + "---------------Activity Status---------------");
//        LogUtil.i("\nThreadName: " + Thread.currentThread().getName() + "\nThreadId: " + Thread.currentThread().getId());
//        LogUtil.i("\nPid: " + Process.myPid() + "\nUid: " + Process.myUid() + "\nTid: " + Process.myTid());
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.i(getClass().getName() + "--Activity Status--");
    }
}
