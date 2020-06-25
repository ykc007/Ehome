package com.ehome.electpin.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.fly.tour.common.mvp.BaseMvpActivity;
import com.fly.tour.common.mvp.presenter.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public  class RegisterAct extends BaseMvpActivity
{

    TextView profile;
    @BindView(R.id.register_re)
    Button registerBt;

    @Override
    public int onBindLayout()
    {
        return R.layout.register_layout;
    }

    @Override
    public void initView()
    {
        mToolbar.setVisibility(View.GONE);
        ButterKnife.bind(this);
        profile =findViewById(R.id.profile_re);

        registerBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent("com.ehome.electpin.ui.CustomDetailsAct");
                startActivity(intent);
            }
        });
        String str = "登录即代表已阅读并同意本软件的《用户注册协议》";

        SpannableStringBuilder stringBuilder =new SpannableStringBuilder(str);

        ClickableSpan clickableSpan = new ClickableSpan()
        {
            @Override
            public void onClick(@NonNull View view)
            {
                Intent i = new Intent();
                i.setAction("com.ehome.electpin.ui.ProfileAct");

                startActivity(i);
            }
        };
        stringBuilder.setSpan(clickableSpan,15,str.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan colorSpan =new ForegroundColorSpan(Color.parseColor("#ff27a2ff"));

        stringBuilder.setSpan(colorSpan,15,str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        profile.setMovementMethod(LinkMovementMethod.getInstance());
        profile.setText(stringBuilder);
    }

    @Override
    public void initData()
    {

    }

    @Override
    public BasePresenter initPresenter()
    {
        return null;
    }
}
