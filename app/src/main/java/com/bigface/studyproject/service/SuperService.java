package com.bigface.studyproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.bigface.studyproject.LogUtil;

public class SuperService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i(getClass().getName() + "--Service Status--onCreate");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.i(getClass().getName() + "--Service Status--onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.i(getClass().getName() + "--Service Status--onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.i(getClass().getName() + "--Service Status--onUnbind");
        super.onUnbind(intent);
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        LogUtil.i(getClass().getName() + "--Service Status--onRebind");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i(getClass().getName() + "--Service Status--onDestroy");
    }
}
