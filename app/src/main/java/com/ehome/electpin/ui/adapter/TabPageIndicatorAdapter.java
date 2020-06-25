package com.ehome.electpin.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public  class TabPageIndicatorAdapter  extends FragmentPagerAdapter
{
    ArrayList<Fragment> fragments;

    String[] TITLE = new String[] { "日志", "通话", "流转", "订单","合同","回款"};
    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return TITLE[position];
    }

    public TabPageIndicatorAdapter(FragmentManager fm, ArrayList<Fragment> fragments)
    {
        super(fm);
        this.fragments= fragments;
    }

    @Override
    public Fragment getItem(int i)
    {
        return fragments.get(i);
    }

    @Override
    public int getCount()
    {
        return TITLE.length;
    }
}
