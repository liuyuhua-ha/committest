package com.bigface.studyproject.service;

import android.app.Application;
import android.app.Service;
import android.content.Intent;

import com.bigface.studyproject.LogUtil;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.i(" App onCreate ");
    }
}
