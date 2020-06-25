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
import com.ehome.electpin.ui.adapter.CollectionAdapter;
import com.ehome.electpin.ui.adapter.StaffManageAdapter;
import com.fly.tour.common.mvp.BaseActivity;
import com.refresh.lib.BaseRefreshLayout;
import com.refresh.lib.DaisyRefreshLayout;

public class StaffManageActivity extends BaseActivity {

    RecyclerView recview;
    DaisyRefreshLayout daisy_refresh_layout;

    public static void startStaffManageActivity(Context context) {
        Intent intent = new Intent(context, StaffManageActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_staff_manage;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "员工管理", false, false);

        recview = findViewById(R.id.recyclerview);
        daisy_refresh_layout = findViewById(R.id.daisy_refresh_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recview.setLayoutManager(layoutManager);

        daisy_refresh_layout.setOnRefreshListener(new BaseRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        daisy_refresh_layout.setRefreshing(false);
                    }
                }, 1000 * 3);
            }
        });

        daisy_refresh_layout.setOnLoadMoreListener(new BaseRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        daisy_refresh_layout.setLoadMore(false);
                    }
                }, 1000 * 3);
            }
        });

        daisy_refresh_layout.setOnAutoLoadListener(new DaisyRefreshLayout.OnAutoLoadListener() {
            @Override
            public void onAutoLoad() {
                Toast.makeText(getBaseContext(), "开始加载数据了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData() {
        StaffManageAdapter staffManageAdapter = new StaffManageAdapter(this);
        recview.setAdapter(staffManageAdapter);
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
                AddStaffActivity.startAddStaffActivity(getBaseContext());
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
