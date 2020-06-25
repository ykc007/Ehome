package com.ehome.electpin.ui.activity;

import android.view.View;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseMvpActivity;
import com.fly.tour.common.mvp.presenter.BasePresenter;

public  class ProfileAct extends BaseMvpActivity
{


    @Override
    public int onBindLayout()
    {
        return R.layout.profile_layout;
    }

    @Override
    public void initView()
    {
        mToolbar.setVisibility(View.GONE);
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
}
