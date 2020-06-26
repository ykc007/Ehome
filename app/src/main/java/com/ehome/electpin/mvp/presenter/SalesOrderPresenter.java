package com.ehome.electpin.mvp.presenter;

import android.content.Context;

import com.ehome.electpin.mvp.contract.SalesOrderContract;
import com.ehome.electpin.mvp.model.SalesOrderModel;
import com.ehome.electpin.utils.SignUtil;
import com.facebook.stetho.common.LogUtil;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.common.mvp.presenter.BaseRefreshPresenter;
import com.fly.tour.common.util.NetUtil;
import com.fly.tour.common.util.ToastUtil;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SalesOrderPresenter extends BaseRefreshPresenter<SalesOrderModel, SalesOrderContract.View<SalesOrderEntity.SalesOrderBean>, SalesOrderEntity.SalesOrderBean> implements SalesOrderContract.Presenter {

    int page = 1;

    public SalesOrderPresenter(Context context) {
        super(context);
    }

    @Override
    public SalesOrderModel initModel() {
        return new SalesOrderModel(mContext);
    }

    @Override
    public void refreshData() {

        if (!NetUtil.checkNetToast()) {
            mView.showNetWorkErrView();
            return;
        }
        page = 1;

        final Map<String, Object> map = new TreeMap<>();
        map.put("password", "123456");
        map.put("phone", "13576910486");


        LogUtil.e("111111===" + SignUtil.getSign(map));

        mModel.getSalesOrders(page, SignUtil.getSign(map)).subscribe(new Observer<SalesOrderEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SalesOrderEntity salesOrderEntity) {
                ToastUtil.showToast(salesOrderEntity.getMsg());
                if (salesOrderEntity.getData() != null && salesOrderEntity.getData().size() > 0) {
                    mView.refreshData(salesOrderEntity.getData());
                } else {
                    //mView.showNoDataView();
                }
            }

            @Override
            public void onError(Throwable e) {
                //mView.showNetWorkErrView();
                mView.stopRefresh();
            }

            @Override
            public void onComplete() {
                mView.stopRefresh();
            }
        });
    }

    @Override
    public void loadMoreData() {
        page += page;

        Map<String, Object> map = new TreeMap<>();
        map.put("phone", "13576910486");
        map.put("password", "123456");

        LogUtil.e("111111===" + SignUtil.getSign(map));
        mModel.getSalesOrders(page, SignUtil.getSign(map)).subscribe(new Observer<SalesOrderEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SalesOrderEntity salesOrderEntity) {
                LogUtil.e("1111" + salesOrderEntity.getMsg());
                ToastUtil.showToast(salesOrderEntity.getMsg());
                if (salesOrderEntity.getData() != null && salesOrderEntity.getData().size() > 0) {
                    mView.loadMoreData(salesOrderEntity.getData());
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.stopLoadMore();
            }

            @Override
            public void onComplete() {
                mView.stopLoadMore();
            }
        });
    }
}
