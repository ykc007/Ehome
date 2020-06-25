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
import com.ehome.electpin.mvp.contract.ContractContract;
import com.ehome.electpin.mvp.model.ContractModel;
import com.ehome.electpin.mvp.presenter.ContractPresenter;
import com.ehome.electpin.ui.adapter.ContractAdapter;
import com.fly.tour.api.entity.ContractEntity;
import com.fly.tour.common.mvp.BaseRefreshActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 合同
 */
public class ContractActivity extends BaseRefreshActivity<ContractModel, ContractContract.View<ContractEntity.ContractBean>, ContractPresenter, ContractEntity.ContractBean> implements View.OnClickListener, ContractContract.View<ContractEntity.ContractBean> {

    RecyclerView recview;
    ContractAdapter contractAdapter;
    private List<ContractEntity.ContractBean> mContractBeans;

    public static void startContractActivity(Context context) {
        Intent intent = new Intent(context, ContractActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_contract;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "合同", false, false);
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
        mContractBeans = new ArrayList<>();

        contractAdapter = new ContractAdapter(this, mContractBeans);
        recview.setAdapter(contractAdapter);

        autoLoadData();
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
        }
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
            tv_right.setText("编辑");
        }


        ll_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddContractActivity.startAddContractActivity(context);
            }
        });
        ll_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int onBindRreshLayout() {
        return R.id.contract_refresh;
    }

    @Override
    public ContractPresenter initPresenter() {
        return new ContractPresenter(this);
    }

    @Override
    public void refreshData(List<ContractEntity.ContractBean> data) {
        mContractBeans.clear();
        mContractBeans.addAll(data);
        contractAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreData(List<ContractEntity.ContractBean> data) {
        mContractBeans.addAll(data);
        contractAdapter.notifyDataSetChanged();
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
}
