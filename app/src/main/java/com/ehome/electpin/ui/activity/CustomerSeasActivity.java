package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.adapter.CustomerAdapter;
import com.fly.tour.common.mvp.BaseActivity;
import com.refresh.lib.BaseRefreshLayout;
import com.refresh.lib.DaisyRefreshLayout;

/**
 * 客户公海
 */
public class CustomerSeasActivity extends BaseActivity implements View.OnClickListener {
    RecyclerView recview;
    LinearLayout ll_sort;
    LinearLayout ll_screen;
    DaisyRefreshLayout customer_refresh_layout;
    LinearLayout ll_show_pop;

    public static void startCustomerSeasActivity(Context context) {
        Intent intent = new Intent(context, CustomerSeasActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int onBindLayout() {
        return R.layout.activity_customer_seas;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "客户公海", false, false, "", "");
        recview = findViewById(R.id.recview);
        ll_sort = findViewById(R.id.ll_sort);
        ll_screen = findViewById(R.id.ll_screen);
        customer_refresh_layout = findViewById(R.id.customer_refresh_layout);
        ll_show_pop = findViewById(R.id.ll_show_pop);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recview.setLayoutManager(layoutManager);

        CustomerAdapter customerAdapter = new CustomerAdapter(this);
        recview.setAdapter(customerAdapter);

        customer_refresh_layout.setOnRefreshListener(new BaseRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        customer_refresh_layout.setRefreshing(false);
                    }
                }, 1000 * 3);
            }
        });

        customer_refresh_layout.setOnLoadMoreListener(new BaseRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        customer_refresh_layout.setLoadMore(false);
                    }
                }, 1000 * 3);
            }
        });
    }

    @Override
    public void initData() {
        ll_screen.setOnClickListener(this);
        ll_sort.setOnClickListener(this);
    }

    /**
     * 设置头部
     *
     * @param title
     * @param isGoneLeftIv
     * @param isGoneRightIv
     */
    public void headerSetting(final Context context, String title, boolean isGoneLeftIv, boolean isGoneRightIv, String tvLeft, String tvRight) {
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
            tv_right.setText(tvRight);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_sort:
                initSortPopupWindow();
                break;
            case R.id.ll_screen:
                initScreenPopupWindow();
                break;
        }
    }

    public void initSortPopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_customer_sort_layout, null);

        PopupWindow mPopupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(ll_show_pop);
    }

    public void initScreenPopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_customer_screen_layout, null);

        PopupWindow mPopupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(ll_show_pop);
    }
}
