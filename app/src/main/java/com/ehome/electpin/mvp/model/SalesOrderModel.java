package com.ehome.electpin.mvp.model;

import android.content.Context;

import com.ehome.electpin.mvp.contract.SalesOrderContract;
import com.fly.tour.api.CommonService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.common.mvp.model.BaseModel;

import java.util.List;

import io.reactivex.Observable;

public class SalesOrderModel extends BaseModel {
    private CommonService commonService;

    public SalesOrderModel(Context context) {
        super(context);
        commonService = RetrofitManager.getInstance().getCommonService();
    }

    public Observable<SalesOrderEntity> getSalesOrders(int page,String sign) {
        return commonService.getSalesOrder("Content-Type:application/x-www-form-urlencoded", page, 50,sign).
                compose(RxAdapter.exceptionTransformer())
                .compose(RxAdapter.schedulersTransformer());
    }
}
