package com.ehome.electpin.mvp.contract;

import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.common.mvp.view.BaseRefreshView;

public interface SalesOrderContract {
    interface Presenter {
    }

    interface View<SalesOrderBean> extends BaseRefreshView<SalesOrderBean> {

    }

    interface Model {
        SalesOrderEntity getSalesOrders();
    }
}
