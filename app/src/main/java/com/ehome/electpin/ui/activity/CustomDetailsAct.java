package com.ehome.electpin.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ehome.electpin.R;

import com.ehome.electpin.ui.adapter.TabPageIndicatorAdapter;
import com.ehome.electpin.ui.fragment.CommunicateFragment;
import com.ehome.electpin.ui.fragment.ContractFragment;
import com.ehome.electpin.ui.fragment.FlowFragment;
import com.ehome.electpin.ui.fragment.LogFragment;
import com.ehome.electpin.ui.fragment.OrderFragment;
import com.ehome.electpin.ui.fragment.ReturnedmmFragment;
import com.fly.tour.common.mvp.BaseMvpActivity;
import com.fly.tour.common.mvp.presenter.BasePresenter;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomDetailsAct extends BaseMvpActivity implements View.OnClickListener
{
    @BindView(R.id.viewpage)
    ViewPager viewPager;

    @BindView(R.id.tab)
    TabPageIndicator tabPageIndicator;
    @BindView(R.id.more_details)
    View more_details;


    String[] TITLE = new String[]{"日志", "通话", "流转", "订单", "合同", "回款"};

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    LogFragment logFragment = new LogFragment();
    CommunicateFragment communicateFragment = new CommunicateFragment();
    FlowFragment flowFragment = new FlowFragment();
    OrderFragment orderFragment = new OrderFragment();
    ContractFragment contractFragment = new ContractFragment();
    ReturnedmmFragment returnedmmFragment = new ReturnedmmFragment();


    @Override
    public int onBindLayout()
    {
        return R.layout.customdetails_layout;
    }

    @Override
    public void initView()
    {
        mToolbar.setVisibility(View.GONE);
        fragmentArrayList.add(logFragment);
        fragmentArrayList.add(communicateFragment);
        fragmentArrayList.add(flowFragment);
        fragmentArrayList.add(orderFragment);
        fragmentArrayList.add(contractFragment);
        fragmentArrayList.add(returnedmmFragment);

        FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getSupportFragmentManager(), fragmentArrayList);
        ButterKnife.bind(this);
        viewPager.setAdapter(adapter);
        more_details.setOnClickListener(this);

        tabPageIndicator.setViewPager(viewPager);
        tabPageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int i, float v, int i1)
            {

            }

            @Override
            public void onPageSelected(int i)
            {
                //   Toast.makeText(getApplicationContext(), TITLE[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i)
            {

            }
        });
    }

    @Override
    public void initData()
    {

    }

    @Override
    public BasePresenter initPresenter()
    {
        return null;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.more_details:
                details_pop();

        }

    }

    public void details_pop()
    {
        View view=this.getLayoutInflater().inflate(R.layout.moredeatails_pop,null);
        PopupWindow popupWindow= new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(more_details,-20,50);

    }
}
