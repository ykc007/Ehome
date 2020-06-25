package com.ehome.electpin.ui.fragment;

import android.view.View;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseFragment;

public class TableFragment extends BaseFragment {
    public static final String TAG = TableFragment.class.getSimpleName();
    public static TableFragment newInstance() {
        return new TableFragment();
    }
    @Override
    public int onBindLayout() {
        return R.layout.fragment_table;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }
}
