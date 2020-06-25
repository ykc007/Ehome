package com.ehome.electpin.mvp.contract;

import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.common.mvp.view.BaseRefreshView;

public interface ContractContract {
    interface Presenter {
    }

    interface View<ContractBean> extends BaseRefreshView<ContractBean> {

    }

    interface Model {
        SalesOrderEntity getSalesOrders();
    }
}
