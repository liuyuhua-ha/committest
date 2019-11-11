package com.bigface.studyproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.os.Process;

import com.bigface.studyproject.LogUtil;

public class StartService extends SuperService {

    private iBindImpl iBind = null;

    public iBindImpl getiBind() {
        return iBind;
    }

    public class iBindImpl extends Binder {
        public StartService getService() {
            return StartService.this;
        }

        public int calculate(int a, int b) {
            LogUtil.i("calculate " + android.os.Process.myPid());
            LogUtil.i("calculate " + android.os.Process.myTid());
            LogUtil.i("calculate " + Thread.currentThread().getId());
            return a + b;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.e("ThreadName: " + Thread.currentThread().getName() + "\nThreadId: " + Thread.currentThread().getId());
        LogUtil.e("\nPid: " + Process.myPid() + "\nUid: " + Process.myUid() + "\nTid: " + Process.myTid());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        iBind = new iBindImpl();
        return iBind;
    }
}
