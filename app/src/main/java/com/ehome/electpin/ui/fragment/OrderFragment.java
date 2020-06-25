package com.ehome.electpin.ui.fragment;

import android.view.View;

import com.ehome.electpin.R;
import com.ehome.electpin.mvp.contract.IOrderContract;
import com.fly.tour.common.mvp.BaseMvpFragment;
import com.fly.tour.common.mvp.presenter.BasePresenter;

/**
 * @author ykc
 * @describe
 * @date 2020/6/24  18:05
 * - generate by MvpAutoCodePlus plugin.
 */

public class OrderFragment extends BaseMvpFragment implements IOrderContract.View
{



    @Override
    public int onBindLayout()
    {
        return R.layout.orderframent_layout;
    }

    @Override
    public void initView(View view)
    {

    }

    @Override
    public void initData()
    {

    }

    @Override
    public String getToolbarTitle()
    {
        return null;
    }

    @Override
    public BasePresenter initPresenter()
    {
        return null;
    }
}

