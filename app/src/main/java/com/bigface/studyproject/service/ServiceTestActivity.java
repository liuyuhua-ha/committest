package com.bigface.studyproject.service;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.bigface.studyproject.LogUtil;
import com.bigface.studyproject.R;
import com.bigface.studyproject.SuperActivtiy;

import android.view.View;
import android.widget.Toast;

public class ServiceTestActivity extends SuperActivtiy implements ServiceConnection {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
//        LogUtil.e("ThreadName: " + Thread.currentThread().getName() + "\nThreadId: " + Thread.currentThread().getId());
//        LogUtil.e("\nPid: " + Process.myPid() + "\nUid: " + Process.myUid() + "\nTid: " + Process.myTid());
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                Intent intent = new Intent(this, StartService.class);
                startService(intent);
                break;
            case R.id.tv2:
                Intent intent2 = new Intent(this, StartService.class);
                bindService(intent2, this, BIND_AUTO_CREATE);
                break;
            case R.id.tv3:
                Intent intent3 = new Intent(this, StartService.class);
                stopService(intent3);
                break;

            case R.id.tv4:
                Intent intent4 = new Intent(this, StartService.class);
                unbindService(this);
                break;

            case R.id.tv5:
                int result = -1;
                if (startService != null)
                    result = startService.getiBind().calculate(5, 6);
                Toast.makeText(this, "result:" + result, Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
    }

    private StartService startService = null;

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        LogUtil.i("IBinder:" + service.getClass().getName());
        startService = ((StartService.iBindImpl) service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

        startService = null;
    }
}
