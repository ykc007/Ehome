package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.ehome.electpin.mvp.contract.SalesOrderContract;
import com.ehome.electpin.mvp.model.SalesOrderModel;
import com.ehome.electpin.mvp.presenter.SalesOrderPresenter;
import com.ehome.electpin.ui.adapter.SalesOrderAdapter;
import com.facebook.stetho.common.LogUtil;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.common.mvp.BaseRefreshActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 销售订单
 */
public class SalesOrderActivity extends BaseRefreshActivity<SalesOrderModel,
        SalesOrderContract.View<SalesOrderEntity.SalesOrderBean>, SalesOrderPresenter,
        SalesOrderEntity.SalesOrderBean> implements View.OnClickListener,
        SalesOrderContract.View<SalesOrderEntity.SalesOrderBean> {

    public Context mContext;
    RecyclerView recview;
    SalesOrderAdapter salesOrderAdapter;
    private List<SalesOrderEntity.SalesOrderBean> mSalesOrderBeans;

    public static void startSalesOrderActivity(Context context) {
        Intent intent = new Intent(context, SalesOrderActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_sales_order;
    }

    @Override
    public void initView() {
        mContext = this;
        mToolbar.setVisibility(View.GONE);


        headerSetting(this, "销售订单", false, false);

        recview = findViewById(R.id.recview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recview.setLayoutManager(layoutManager);

    }

    @Override
    public void initData() {

        mSalesOrderBeans = new ArrayList<>();
        salesOrderAdapter = new SalesOrderAdapter(this, mSalesOrderBeans);
        recview.setAdapter(salesOrderAdapter);

        autoLoadData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    public void refreshData(List data) {

        mSalesOrderBeans.clear();
        mSalesOrderBeans.addAll(data);
        salesOrderAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreData(List data) {
        mSalesOrderBeans.addAll(data);
        salesOrderAdapter.notifyDataSetChanged();
    }

    @Override
    protected int onBindRreshLayout() {
        return R.id.sales_order_refresh;
    }

    @Override
    public void enableRefresh(boolean b) {

    }

    @Override
    public void enableLoadMore(boolean b) {

    }

    @Override
    public void onRefreshEvent() {
        mPresenter.refreshData();
    }

    @Override
    public void onLoadMoreEvent() {
        mPresenter.loadMoreData();
    }

    @Override
    public void onAutoLoadEvent() {
        mPresenter.refreshData();
    }

    @Override
    public SalesOrderPresenter initPresenter() {
        return new SalesOrderPresenter(this);
    }


    /**
     * 设置头部
     *
     * @param title
     * @param isGoneLeftIv
     * @param isGoneRightIv
     */
    public void headerSetting(final Context context, String title, boolean isGoneLeftIv, boolean isGoneRightIv) {
        LinearLayout ll_right = findViewById(R.id.ll_right);
        LinearLayout ll_left = findViewById(R.id.ll_left);
        ImageView iv_left = findViewById(R.id.iv_left);
        ImageView iv_right = findViewById(R.id.iv_right);
        TextView tv_left = findViewById(R.id.tv_left);
        TextView tv_right = findViewById(R.id.tv_right);
        TextView tv_center = findViewById(R.id.tv_center);

        tv_center.setText(title);

        iv_left.setVisibility(View.VISIBLE);
        tv_left.setVisibility(View.GONE);
        if (isGoneLeftIv) {
            iv_left.setVisibility(View.GONE);
            tv_left.setVisibility(View.VISIBLE);
            tv_left.setText("");
        }

        iv_right.setVisibility(View.VISIBLE);
        tv_right.setVisibility(View.GONE);
        if (isGoneRightIv) {
            iv_right.setVisibility(View.GONE);
            tv_right.setVisibility(View.VISIBLE);
            tv_right.setText("保存");
        }


        ll_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddOrderActivity.startAddOrderActivity(context);
            }
        });
        ll_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
