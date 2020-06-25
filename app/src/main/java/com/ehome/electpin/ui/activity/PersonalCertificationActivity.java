package com.ehome.electpin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 个人认
 */
public class PersonalCertificationActivity extends BaseActivity {

    @BindView(R.id.btn_confirm)
    Button btn_confirm;

    public static void startPersonalCertificationActivity(Context context) {
        Intent intent = new Intent(context, PersonalCertificationActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_personal_certification;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);

        ButterKnife.bind(this);

        btn_confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent("ui.activity.MainActivity");
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void initData() {

    }
}
