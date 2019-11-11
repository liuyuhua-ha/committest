package com.bigface.studyproject.remote_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Toast;

import com.bigface.studyproject.LogUtil;
import com.bigface.studyproject.R;
import com.bigface.studyproject.SuperActivtiy;

public class RemoteTestActivity extends SuperActivtiy implements ServiceConnection {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_remote_service);

    }

    public boolean isBind = false;

    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.tv2:
                Intent intent = new Intent("haha.hehe.coco");

                //Android5.0后无法只通过隐式Intent绑定远程Service
                //需要通过setPackage()方法指定包名
                intent.setPackage("com.bigface.studyproject");
                startService(intent);
                isBind = bindService(intent, this, BIND_AUTO_CREATE);
                break;
            case R.id.tv3:
                Intent intent3 = new Intent(this, RemoteServie.class);
                stopService(intent3);
                break;

            case R.id.tv4:
                Intent intent4 = new Intent(this, RemoteServie.class);
                if (service == null)
                    return;
                unbindService(this);
                break;

            case R.id.tv5:
                if (service == null)
                    return;
                try {
                    int result = service.addSum(67, 90);
                    Toast.makeText(this, "result:" + result, Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


                break;
        }
    }

    private IMusicAidlInterface service = null;

    @Override
    public void onServiceConnected(ComponentName name, IBinder s) {
        LogUtil.i("onServiceConnected " + android.os.Process.myPid());
        this.service = IMusicAidlInterface.Stub.asInterface(s);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        LogUtil.i("onServiceDisconnected " + android.os.Process.myPid());
        service = null;
        isBind = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBind)
            unbindService(this);
    }
}
