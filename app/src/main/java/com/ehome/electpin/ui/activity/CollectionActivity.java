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
import com.ehome.electpin.mvp.contract.CollectionContract;
import com.ehome.electpin.mvp.model.CollectionModel;
import com.ehome.electpin.mvp.presenter.CollectionPresenter;
import com.ehome.electpin.ui.adapter.CollectionAdapter;
import com.fly.tour.api.entity.CollectionEntity;
import com.fly.tour.common.mvp.BaseRefreshActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 回款
 */

public class CollectionActivity extends BaseRefreshActivity<CollectionModel,
        CollectionContract.View<CollectionEntity.DataBean>, CollectionPresenter,
        CollectionEntity.DataBean> implements View.OnClickListener,
        CollectionContract.View<CollectionEntity.DataBean> {

    RecyclerView recview;
    CollectionAdapter collectionAdapter;
    private List<CollectionEntity.DataBean> mCollections;

    public static void startCollectionActivity(Context context) {
        Intent intent = new Intent(context, CollectionActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int onBindLayout() {
        return R.layout.activity_collection;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "回款", false, false);
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
        mCollections = new ArrayList<>();

        collectionAdapter = new CollectionAdapter(this, mCollections);
        recview.setAdapter(collectionAdapter);

        autoLoadData();
    }

    @Override
    public void onClick(View view) {
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
            tv_right.setText("保存");
        }


        ll_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCollectionActivity.startAddCollectionActivity(context);
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
        return R.id.daisy_refresh_layout;
    }

    @Override
    public CollectionPresenter initPresenter() {
        return new CollectionPresenter(this);
    }

    @Override
    public void refreshData(List<CollectionEntity.DataBean> data) {
        mCollections.clear();
        mCollections.addAll(data);
        collectionAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreData(List<CollectionEntity.DataBean> data) {
        mCollections.addAll(data);
        collectionAdapter.notifyDataSetChanged();
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
