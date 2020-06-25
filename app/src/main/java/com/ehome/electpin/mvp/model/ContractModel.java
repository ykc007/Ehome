package com.ehome.electpin.mvp.model;

import android.content.Context;

import com.fly.tour.api.CommonService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.entity.ContractEntity;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.common.mvp.model.BaseModel;

import io.reactivex.Observable;

public class ContractModel extends BaseModel {
    private CommonService commonService;

    public ContractModel(Context context) {
        super(context);
        commonService = RetrofitManager.getInstance().getCommonService();
    }

    public Observable<ContractEntity> getContract(int page) {
        return commonService.getContract("Content-Type:application/x-www-form-urlencoded", page, 50).
                compose(RxAdapter.exceptionTransformer())
                .compose(RxAdapter.schedulersTransformer());
    }
}
