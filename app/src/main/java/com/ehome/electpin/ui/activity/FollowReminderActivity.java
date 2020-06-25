package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.adapter.FollowReminderAdapter;
import com.fly.tour.common.mvp.BaseActivity;
import com.refresh.lib.BaseRefreshLayout;
import com.refresh.lib.DaisyRefreshLayout;

/**
 * 回访提醒
 */

public class FollowReminderActivity extends BaseActivity implements View.OnClickListener {

    RecyclerView recview;
    DaisyRefreshLayout sales_order_refresh;

    public static void startCollectionActivity(Context context) {
        Intent intent = new Intent(context, FollowReminderActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int onBindLayout() {
        return R.layout.activity_follow_reminder;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "回访提醒", false, false);
        recview = findViewById(R.id.recview);
        sales_order_refresh = findViewById(R.id.sales_order_refresh);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recview.setLayoutManager(layoutManager);

        FollowReminderAdapter followReminderAdapter = new FollowReminderAdapter(this);
        recview.setAdapter(followReminderAdapter);


        sales_order_refresh.setOnRefreshListener(new BaseRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sales_order_refresh.setRefreshing(false);
                    }
                }, 1000 * 3);
            }
        });

        sales_order_refresh.setOnLoadMoreListener(new BaseRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sales_order_refresh.setLoadMore(false);
                    }
                }, 1000 * 3);
            }
        });

        sales_order_refresh.setOnAutoLoadListener(new DaisyRefreshLayout.OnAutoLoadListener() {
            @Override
            public void onAutoLoad() {
                Toast.makeText(getBaseContext(), "开始加载数据了", Toast.LENGTH_SHORT).show();
            }
        });
        sales_order_refresh.autoRefresh();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sales_order_refresh.setRefreshing(false);
            }
        }, 1000 * 3);
    }

    @Override
    public void initData() {

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
                AddFollowReminderActivity.startAddFollowReminderActivity(context);
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
