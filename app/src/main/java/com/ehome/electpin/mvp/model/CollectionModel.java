package com.ehome.electpin.mvp.model;

import android.content.Context;

import com.fly.tour.api.CommonService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.entity.CollectionEntity;
import com.fly.tour.api.entity.ContractEntity;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.common.mvp.model.BaseModel;

import io.reactivex.Observable;

public class CollectionModel extends BaseModel {
    private CommonService commonService;

    public CollectionModel(Context context) {
        super(context);
        commonService = RetrofitManager.getInstance().getCommonService();
    }

    public Observable<CollectionEntity> getCollection(int page) {
        return commonService.getCollection("Content-Type:application/x-www-form-urlencoded", page, 50).
                compose(RxAdapter.exceptionTransformer())
                .compose(RxAdapter.schedulersTransformer());
    }
}
