package com.ehome.electpin.app;

import com.fly.tour.api.RetrofitManager;
import com.fly.tour.common.BaseApplication;

public class EHomeApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitManager.init(this);
    }
}
