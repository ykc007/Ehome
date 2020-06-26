package com.ehome.electpin.mvp.contract;

import com.fly.tour.api.entity.CollectionEntity;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.common.mvp.view.BaseRefreshView;

public interface CollectionContract {
    interface Presenter {
    }

    interface View<DataBean> extends BaseRefreshView<DataBean> {

    }

    interface Model {
        CollectionEntity getCollections();
    }
}
