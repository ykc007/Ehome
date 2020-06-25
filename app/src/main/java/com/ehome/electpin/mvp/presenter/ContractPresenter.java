package com.ehome.electpin.mvp.presenter;

import android.content.Context;

import com.ehome.electpin.mvp.contract.ContractContract;
import com.ehome.electpin.mvp.contract.SalesOrderContract;
import com.ehome.electpin.mvp.model.ContractModel;
import com.ehome.electpin.mvp.model.SalesOrderModel;
import com.facebook.stetho.common.LogUtil;
import com.fly.tour.api.entity.ContractEntity;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.common.mvp.presenter.BaseRefreshPresenter;
import com.fly.tour.common.util.NetUtil;
import com.fly.tour.common.util.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ContractPresenter extends BaseRefreshPresenter<ContractModel, ContractContract.View<ContractEntity.ContractBean>, ContractEntity.ContractBean> implements SalesOrderContract.Presenter {

    int page = 1;

    public ContractPresenter(Context context) {
        super(context);
    }

    @Override
    public ContractModel initModel() {
        return new ContractModel(mContext);
    }

    @Override
    public void refreshData() {

        if (!NetUtil.checkNetToast()) {
            mView.showNetWorkErrView();
            return;
        }
        page = 1;
        mModel.getContract(page).subscribe(new Observer<ContractEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ContractEntity contractEntity) {
                ToastUtil.showToast(contractEntity.getMsg());
                if (contractEntity.getData() != null && contractEntity.getData().size() > 0) {
                    mView.refreshData(contractEntity.getData());
                } else {
                    //mView.showNoDataView();
                }
            }

            @Override
            public void onError(Throwable e) {
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
        mModel.getContract(page).subscribe(new Observer<ContractEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ContractEntity contractEntity) {
                LogUtil.e("1111" + contractEntity.getMsg());
                ToastUtil.showToast(contractEntity.getMsg());
                if (contractEntity.getData() != null && contractEntity.getData().size() > 0) {
                    mView.loadMoreData(contractEntity.getData());
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                mView.stopLoadMore();
            }
        });
    }
}
