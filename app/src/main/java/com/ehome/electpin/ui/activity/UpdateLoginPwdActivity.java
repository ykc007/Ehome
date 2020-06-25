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
import com.fly.tour.common.util.ToastUtil;

/**
 * 修改登录密码
 */

public class UpdateLoginPwdActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_confirm;

    public static void startUpdateLoginPwdActivity(Context context) {
        Intent intent = new Intent(context, UpdateLoginPwdActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int onBindLayout() {
        return R.layout.activity_update_login_pwd;
    }

    @Override
    public void initView() {

        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "修改登录密码", false, true, "", "");

        btn_confirm = findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(this);
    }

    @Override
    public void initData() {

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
            case R.id.btn_confirm:
                ToastUtil.showToast("敬请期待...");
                break;
        }
    }
}
