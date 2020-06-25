package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseActivity;

/**
 * 企业认证
 */
public class BusinessCertificationActivity extends BaseActivity {

    public static void startBusinessCertificationActivity(Context context) {
        Intent intent = new Intent(context, BusinessCertificationActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_business_certification;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
    }

    @Override
    public void initData() {

    }
}
