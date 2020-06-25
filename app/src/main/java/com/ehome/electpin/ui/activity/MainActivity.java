package com.ehome.electpin.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;

import com.ehome.electpin.R;
import com.ehome.electpin.entity.MainChannel;
import com.ehome.electpin.ui.fragment.CustomerFragment;
import com.ehome.electpin.ui.fragment.DalFragment;
import com.ehome.electpin.ui.fragment.MainFragment;
import com.ehome.electpin.ui.fragment.MeFragment;
import com.ehome.electpin.ui.fragment.TableFragment;
import com.fly.tour.common.mvp.BaseActivity;

public class MainActivity extends BaseActivity {


    private Fragment mMainFragment;
    private Fragment mCustomerFragment;
    private Fragment mTableFragment;
    private Fragment mMeFragment;

    private Fragment mCurrFragment;


    @Override
    public int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        mToolbar.setVisibility(View.GONE);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setItemIconTintList(null);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int i = menuItem.getItemId();
                if (i == R.id.navigation_trip) {
                    switchContent(mCurrFragment, mMainFragment, MainChannel.NEWS.name);
                    mCurrFragment = mMainFragment;

                    return true;
                } else if (i == R.id.navigation_customer) {
                    switchContent(mCurrFragment, mCustomerFragment, MainChannel.CUSTOMER.name);
                    mCurrFragment = mCustomerFragment;

                    return true;
                } else if (i == R.id.navigation_table) {
                    switchContent(mCurrFragment, mTableFragment, MainChannel.TABLE.name);
                    mCurrFragment = mTableFragment;

                    return true;
                } else if (i == R.id.navigation_me) {
                    switchContent(mCurrFragment, mMeFragment, MainChannel.ME.name);
                    mCurrFragment = mMeFragment;

                    return true;
                }
                return false;
            }
        });
        mMainFragment = new DalFragment();
        mCustomerFragment = CustomerFragment.newInstance();
        mTableFragment = TableFragment.newInstance();
        mMeFragment = MeFragment.newInstance();

        mCurrFragment = mMainFragment;
        if (mMainFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mMainFragment, MainChannel.NEWS.name).commit();
        }
    }

    @Override
    public void initData() {

    }

    public void switchContent(Fragment from, Fragment to, String tag) {
        if (from == null || to == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(R.id.frame_content, to, tag).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }
    }
}
