package com.ehome.electpin.ui.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.adapter.CustomerAdapter;
import com.fly.tour.common.mvp.BaseFragment;
import com.refresh.lib.BaseRefreshLayout;
import com.refresh.lib.DaisyRefreshLayout;

public class CustomerFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = CustomerFragment.class.getSimpleName();


    RecyclerView recview;
    DaisyRefreshLayout customer_refresh_layout;
    LinearLayout ll_sort;
    LinearLayout ll_screen;
    LinearLayout ll_show_pop;


    public static CustomerFragment newInstance() {
        return new CustomerFragment();
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_customer;
    }

    @Override
    public void initView(View view) {
        headerSetting(getActivity(), "客户", false, false, "", "");
        recview = view.findViewById(R.id.recview);
        customer_refresh_layout = view.findViewById(R.id.customer_refresh_layout);
        ll_sort = view.findViewById(R.id.ll_sort);
        ll_screen = view.findViewById(R.id.ll_screen);
        ll_show_pop = view.findViewById(R.id.ll_show_pop);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recview.setLayoutManager(layoutManager);

        CustomerAdapter customerAdapter = new CustomerAdapter(getActivity());
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

    @Override
    public String getToolbarTitle() {
        return null;
    }

    /**
     * 设置头部
     *
     * @param title
     * @param isGoneLeftIv
     * @param isGoneRightIv
     */
    public void headerSetting(final Context context, String title, boolean isGoneLeftIv, boolean isGoneRightIv, String tvLeft, String tvRight) {
        LinearLayout ll_right = mView.findViewById(R.id.ll_right);
        LinearLayout ll_left = mView.findViewById(R.id.ll_left);
        ImageView iv_left = mView.findViewById(R.id.iv_left);
        ImageView iv_right = mView.findViewById(R.id.iv_right);
        TextView tv_left = mView.findViewById(R.id.tv_left);
        TextView tv_right = mView.findViewById(R.id.tv_right);
        TextView tv_center = mView.findViewById(R.id.tv_center);

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
                //AddCollectionActivity.startAddFollowReminderActivity(context);
            }
        });
        ll_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finish();
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
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pop_customer_sort_layout, null);

        PopupWindow mPopupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(ll_show_pop);
    }

    public void initScreenPopupWindow() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pop_customer_screen_layout, null);

        PopupWindow mPopupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(ll_show_pop);
    }
}
