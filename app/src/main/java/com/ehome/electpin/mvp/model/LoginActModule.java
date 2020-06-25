package com.ehome.electpin.mvp.model;

import android.content.Context;

import com.ehome.electpin.entity.Loginentry;
import com.ehome.electpin.mvp.contract.LoginContract;
import com.ehome.electpin.utils.SignUtil;
import com.fly.tour.api.CommonService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.entity.LoginEntity;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.common.mvp.model.BaseModel;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observable;

public class LoginActModule extends BaseModel implements LoginContract.Model
{
    CommonService commonService;
    public LoginActModule(Context context)
    {
        super(context);

    }

    @Override
    public Observable<LoginEntity> login(String phone, String password)
    {

        commonService = RetrofitManager.getInstance().getCommonService();
        Map<String, Object> map = new TreeMap<>();

        map.put("phone",phone);


        map.put("password",password);
        return  commonService.login(SignUtil.getSign(map))
            .compose(RxAdapter.exceptionTransformer())
            .compose(RxAdapter.schedulersTransformer());
    }



}
