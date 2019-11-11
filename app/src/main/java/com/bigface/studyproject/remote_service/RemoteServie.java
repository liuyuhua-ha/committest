package com.bigface.studyproject.remote_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.bigface.studyproject.LogUtil;
import com.bigface.studyproject.service.SuperService;

public class RemoteServie extends SuperService {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);

    }



    IMusicAidlInterface.Stub stub = new IMusicAidlInterface.Stub() {
        @Override
        public int addSum(int a, int b) {
            LogUtil.i("calculate " + android.os.Process.myPid());
            LogUtil.i("calculate " + android.os.Process.myTid());
            LogUtil.i("calculate " + Thread.currentThread().getId());
            return a + b;
        }
    };

}
