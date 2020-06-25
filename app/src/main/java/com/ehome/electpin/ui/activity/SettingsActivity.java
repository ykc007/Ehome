package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseActivity;
import com.fly.tour.common.mvp.BaseMvpActivity;
import com.fly.tour.common.util.SdkVersionUtil;
import com.fly.tour.common.util.ToastUtil;

/**
 * 设置
 */
public class SettingsActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll_personal_data;
    private LinearLayout ll_update_login_pwd;
    private LinearLayout ll_about_us;
    private LinearLayout ll_user_agreement;
    private LinearLayout ll_current_version;
    private Button btn_login_out;
    private TextView tv_current_version;

    public static void startSettingsActivity(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int onBindLayout() {
        return R.layout.activity_settings;
    }

    @Override
    public void initView() {

        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "设置", false, false, "", "");

        ll_personal_data = findViewById(R.id.ll_personal_data);
        ll_update_login_pwd = findViewById(R.id.ll_update_login_pwd);
        ll_about_us = findViewById(R.id.ll_about_us);
        ll_user_agreement = findViewById(R.id.ll_user_agreement);
        ll_current_version = findViewById(R.id.ll_current_version);
        btn_login_out = findViewById(R.id.btn_login_out);
        tv_current_version = findViewById(R.id.tv_current_version);

        ll_personal_data.setOnClickListener(this);
        ll_update_login_pwd.setOnClickListener(this);
        ll_about_us.setOnClickListener(this);
        ll_user_agreement.setOnClickListener(this);
        ll_current_version.setOnClickListener(this);
        btn_login_out.setOnClickListener(this);
    }

    @Override
    public void initData() {

        tv_current_version.setText("" + SdkVersionUtil.getAppVersion(this));
    }

    /**
     * 设置头部
     *
     * @param title
     * @param isGoneLeftIv
     * @param isGoneRightIv
     */
    public void headerSetting(final Context context, String title, boolean isGoneLeftIv, boolean isGoneRightIv, String tvLeft, String tvRight) {
        LinearLayout ll_right = findViewById(R.id.ll_right);
        LinearLayout ll_left = findViewById(R.id.ll_left);
        ImageView iv_left = findViewById(R.id.iv_left);
        ImageView iv_right = findViewById(R.id.iv_right);
        TextView tv_left = findViewById(R.id.tv_left);
        TextView tv_right = findViewById(R.id.tv_right);
        TextView tv_center = findViewById(R.id.tv_center);

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
                AddCollectionActivity.startAddCollectionActivity(context);
            }
        });
        ll_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_personal_data:
                PersonalDataActivity.startPersonalDataActivity(this);
                break;
            case R.id.ll_update_login_pwd:
                UpdateLoginPwdActivity.startUpdateLoginPwdActivity(this);
                break;
            case R.id.ll_about_us:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_user_agreement:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.ll_current_version:
                ToastUtil.showToast("敬请期待...");
                break;
            case R.id.btn_login_out:
                ToastUtil.showToast("敬请期待...");
                break;
        }
    }
}
