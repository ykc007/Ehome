package com.ehome.electpin.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.activity.AgentLoginActivity;
import com.ehome.electpin.ui.activity.BusinessCertificationActivity;
import com.ehome.electpin.ui.activity.CollectionActivity;
import com.ehome.electpin.ui.activity.ContractActivity;
import com.ehome.electpin.ui.activity.CustomerSeasActivity;
import com.ehome.electpin.ui.activity.FollowReminderActivity;
import com.ehome.electpin.ui.activity.PersonalCertificationActivity;
import com.ehome.electpin.ui.activity.SalesOrderActivity;
import com.ehome.electpin.ui.activity.SettingsActivity;
import com.ehome.electpin.ui.activity.StaffManageActivity;
import com.fly.tour.common.mvp.BaseFragment;
import com.fly.tour.common.mvp.BaseMvpFragment;
import com.fly.tour.common.util.ToastUtil;

public class MeFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = MeFragment.class.getSimpleName();

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    LinearLayout ll_sales_order;
    LinearLayout ll_collection;
    LinearLayout ll_contract;
    LinearLayout ll_customer_seas;
    LinearLayout ll_settings;
    LinearLayout ll_staff_manage;
    LinearLayout ll_agent_login;

    LinearLayout ll_notice;
    LinearLayout ll_check_work;
    LinearLayout ll_out_work;
    LinearLayout ll_call_statistics;
    LinearLayout ll_call_ranking;
    LinearLayout ll_order_statistics;
    LinearLayout ll_collection_statistics;
    LinearLayout ll_follow_reminder;
    LinearLayout ll_mine_task;
    LinearLayout ll_payment_function;

    @Override
    public int onBindLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(View view) {
        ll_sales_order = view.findViewById(R.id.ll_sales_order);
        ll_collection = view.findViewById(R.id.ll_collection);
        ll_contract = view.findViewById(R.id.ll_contract);
        ll_customer_seas = view.findViewById(R.id.ll_customer_seas);
        ll_settings = view.findViewById(R.id.ll_settings);
        ll_staff_manage = view.findViewById(R.id.ll_staff_manage);
        ll_agent_login = view.findViewById(R.id.ll_agent_login);

        ll_notice = view.findViewById(R.id.ll_notice);
        ll_check_work = view.findViewById(R.id.ll_check_work);
        ll_out_work = view.findViewById(R.id.ll_out_work);
        ll_call_statistics = view.findViewById(R.id.ll_call_statistics);
        ll_call_ranking = view.findViewById(R.id.ll_call_ranking);
        ll_order_statistics = view.findViewById(R.id.ll_order_statistics);
        ll_collection_statistics = view.findViewById(R.id.ll_collection_statistics);
        ll_follow_reminder = view.findViewById(R.id.ll_follow_reminder);
        ll_mine_task = view.findViewById(R.id.ll_mine_task);
        ll_payment_function = view.findViewById(R.id.ll_payment_function);

        ll_sales_order.setOnClickListener(this);
        ll_collection.setOnClickListener(this);
        ll_contract.setOnClickListener(this);
        ll_customer_seas.setOnClickListener(this);
        ll_settings.setOnClickListener(this);
        ll_staff_manage.setOnClickListener(this);
        ll_agent_login.setOnClickListener(this);
        ll_notice.setOnClickListener(this);
        ll_check_work.setOnClickListener(this);
        ll_out_work.setOnClickListener(this);
        ll_call_statistics.setOnClickListener(this);
        ll_call_ranking.setOnClickListener(this);
        ll_order_statistics.setOnClickListener(this);
        ll_collection_statistics.setOnClickListener(this);
        ll_follow_reminder.setOnClickListener(this);
        ll_mine_task.setOnClickListener(this);
        ll_payment_function.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_sales_order:
                SalesOrderActivity.startSalesOrderActivity(getActivity());
                break;
            case R.id.ll_collection:
                CollectionActivity.startCollectionActivity(getActivity());
                break;
            case R.id.ll_contract:
                ContractActivity.startContractActivity(getActivity());
                break;
            case R.id.ll_customer_seas:
                CustomerSeasActivity.startCustomerSeasActivity(getActivity());
                break;
            case R.id.ll_settings:
                SettingsActivity.startSettingsActivity(getActivity());
                break;
            case R.id.ll_staff_manage:
                StaffManageActivity.startStaffManageActivity(getContext());
                break;
            case R.id.ll_agent_login:
                AgentLoginActivity.startAgentLoginActivity(getActivity());
                break;
            case R.id.ll_notice:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_check_work:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_out_work:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_call_statistics:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_call_ranking:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_order_statistics:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_collection_statistics:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_follow_reminder:
                FollowReminderActivity.startCollectionActivity(getActivity());
                break;
            case R.id.ll_mine_task:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_payment_function:
                ToastUtil.showToast("敬请期待...");
                break;

        }
    }
}
