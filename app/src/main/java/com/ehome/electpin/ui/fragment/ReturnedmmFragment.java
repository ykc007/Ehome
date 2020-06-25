package com.ehome.electpin.ui.fragment;

import android.view.View;

import com.ehome.electpin.R;
import com.ehome.electpin.mvp.contract.IReturnedmmContract;
import com.fly.tour.common.mvp.BaseMvpFragment;
import com.fly.tour.common.mvp.presenter.BasePresenter;

/**
 * @author ykc
 * @describe
 * @date 2020/6/24  18:06
 * - generate by MvpAutoCodePlus plugin.
 */

public class ReturnedmmFragment extends BaseMvpFragment implements IReturnedmmContract.View
{



    @Override
    public int onBindLayout()
    {
        return R.layout.returnmmframent_layout;
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

