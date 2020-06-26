package com.ehome.electpin.mvp.presenter;

import android.content.Context;

import com.ehome.electpin.mvp.contract.CollectionContract;
import com.ehome.electpin.mvp.contract.ContractContract;
import com.ehome.electpin.mvp.contract.SalesOrderContract;
import com.ehome.electpin.mvp.model.CollectionModel;
import com.ehome.electpin.mvp.model.ContractModel;
import com.facebook.stetho.common.LogUtil;
import com.fly.tour.api.entity.CollectionEntity;
import com.fly.tour.api.entity.ContractEntity;
import com.fly.tour.common.mvp.presenter.BaseRefreshPresenter;
import com.fly.tour.common.util.NetUtil;
import com.fly.tour.common.util.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CollectionPresenter extends BaseRefreshPresenter<CollectionModel, CollectionContract.View<CollectionEntity.DataBean>, CollectionEntity.DataBean> implements CollectionContract.Presenter {

    int page = 1;

    public CollectionPresenter(Context context) {
        super(context);
    }

    @Override
    public CollectionModel initModel() {
        return new CollectionModel(mContext);
    }

    @Override
    public void refreshData() {

        if (!NetUtil.checkNetToast()) {
            mView.showNetWorkErrView();
            return;
        }
        page = 1;
        mModel.getCollection(page).subscribe(new Observer<CollectionEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CollectionEntity collectionEntity) {
                ToastUtil.showToast(collectionEntity.getMsg());
                if (collectionEntity.getData() != null && collectionEntity.getData().size() > 0) {
                    mView.refreshData(collectionEntity.getData());
                } else {
                    //mView.showNoDataView();
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.stopRefresh();
                //mView.showNetWorkErrView();
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
        mModel.getCollection(page).subscribe(new Observer<CollectionEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CollectionEntity collectionEntity) {
                LogUtil.e("1111" + collectionEntity.getMsg());
                ToastUtil.showToast(collectionEntity.getMsg());
                if (collectionEntity.getData() != null && collectionEntity.getData().size() > 0) {
                    mView.loadMoreData(collectionEntity.getData());
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
