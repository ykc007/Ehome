package com.ehome.electpin.app;

import com.fly.tour.api.RetrofitManager;
import com.fly.tour.common.BaseApplication;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class EHomeApplication extends BaseApplication {

    public static IWXAPI iwxapi;
    public  static  final  String App_ID="wxeeeee3333";
    public  static  final  String SERCRE_KEY="EEEE";


    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitManager.init(this);
        iwxapi = WXAPIFactory.createWXAPI(this,App_ID,true);

        iwxapi.registerApp(App_ID);
    }



}
