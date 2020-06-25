package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseMvpActivity;
import com.fly.tour.common.mvp.presenter.BasePresenter;

/**
 * 添加合同
 */
public class AddContractActivity extends BaseMvpActivity {
    public static void startAddContractActivity(Context context) {
        Intent intent = new Intent(context, AddContractActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_add_contract;
    }

    @Override
    public void initView() {

        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "添加合同", false, true);
    }

    @Override
    public void initData() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    /**
     * 设置头部
     *
     * @param title
     * @param isGoneLeftIv
     * @param isGoneRightIv
     */
    public void headerSetting(final Context context, String title, boolean isGoneLeftIv, boolean isGoneRightIv) {
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
            tv_right.setText("保存");
        }


        ll_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        ll_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
