package com.ehome.electpin.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.electpin.R;
import com.ehome.electpin.app.EHomeApplication;
import com.ehome.electpin.mvp.contract.LoginContract;
import com.ehome.electpin.mvp.model.LoginActModule;
import com.ehome.electpin.mvp.presenter.LoginActPresent;
import com.fly.tour.common.mvp.BaseMvpActivity;
import com.fly.tour.common.mvp.presenter.BasePresenter;
import com.fly.tour.common.util.NetUtil;
import com.fly.tour.common.util.ToastUtil;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Login_Act extends BaseMvpActivity<LoginActModule, LoginContract.View, LoginActPresent> implements LoginContract.View
{
    EditText phone;
    EditText password;

    Button rebt;
    Button login_bt;
    TextView t2;
    String phoneStr;
    String passwordStr;
    Tencent mtTencent;

    TextView forget;

    @BindView(R.id.qqlogin)
    ImageView qqlogin;
    @BindView(R.id.weixinlogin)
    ImageView   weixinlogin;



    UserInfo qq_info;
    private class BaseUiListener implements IUiListener
    {
        @Override
        public void onComplete(Object response) {
            Toast.makeText(Login_Act.this, "授权成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login_Act.this,PersonalCertificationActivity.class));
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mtTencent.setOpenId(openID);
                mtTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mtTencent.getQQToken();
                 qq_info = new UserInfo(Login_Act.this.getApplicationContext(), qqToken);
                qq_info.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(Login_Act.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(Login_Act.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }
    @OnClick(R.id.weixinlogin)
    public void setWeixinlogin(View view){
        if (!EHomeApplication.iwxapi.isWXAppInstalled()) {
            ToastUtil.showToast("您还未安装微信客户端");
            return;
        }
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "diandi_wx_login";
        EHomeApplication.iwxapi.sendReq(req);

}

    @Override
    public int onBindLayout()
    {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mtTencent=Tencent.createInstance("11",this.getApplicationContext());


    }

    @Override
    public void initView()
    {
        mToolbar.setVisibility(View.GONE);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        rebt = this.findViewById(R.id.RegButton);
        login_bt = this.findViewById(R.id.login_bt);
        t2 = this.findViewById(R.id.profile);
        phone = this.findViewById(R.id.phone);
        password = this.findViewById(R.id.password);
        forget = findViewById(R.id.forget_tv);

        String str = "登录即代表已阅读并同意本软件的《用户注册协议》";

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(str);

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
        stringBuilder.setSpan(clickableSpan, 15, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ff27a2ff"));

        stringBuilder.setSpan(colorSpan, 15, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        t2.setText(stringBuilder);

        qqlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                BaseUiListener baseUiListener = new BaseUiListener();
                mtTencent.login(Login_Act.this,"all",baseUiListener);
            }
        });



        login_bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!NetUtil.checkNetToast())
                {
                    return;
                }

                phone.setError(null);
                password.setError(null);

                phoneStr = phone.getText().toString();
                passwordStr = password.getText().toString();


                if (TextUtils.isEmpty(phoneStr))
                {

                    phone.setError("手机号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(passwordStr))
                {

                    password.setError("密码不能为空");


                }

                mPresenter.login(phoneStr, passwordStr);
                Intent i = new Intent();
                i.setAction("com.ehome.electpin.ui.PersonalCertificationActivity");

                startActivity(i);
                finish();

            }
        });


        rebt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent();
                i.setAction("com.ehome.electpin.ui.RegisterAct");

                startActivity(i);
            }
        });

        forget.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent();
                i.setAction("com.ehome.electpin.ui.ForgetAct");

                startActivity(i);
            }
        });

        /* rebt.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View v)
            {
                try
                {
                    // 首先拿到TelephonyManager
                    TelephonyManager telMag = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    Class<TelephonyManager> c = TelephonyManager.class;

                    // 再去反射TelephonyManager里面的私有方法 getITelephony 得到 ITelephony对象
                    Method mthEndCall = c.getDeclaredMethod("getITelephony", (Class[]) null);
                    //允许访问私有方法
                    mthEndCall.setAccessible(true);
                    final Object obj = mthEndCall.invoke(telMag, (Object[]) null);

                    // 再通过ITelephony对象去反射里面的call方法，并传入包名和需要拨打的电话号码
                    Method mt = obj.getClass().getMethod("call", new Class[]{String.class, String.class});
                    //允许访问私有方法
                    mt.setAccessible(true);
                    mt.invoke(obj, new Object[]{getPackageName() + "", "10086"});

                    Toast.makeText(Login_Act.this, "拨打电话！", Toast.LENGTH_SHORT).show();

                   sleep(800);

                    Intent intent= new Intent();
                    intent.setAction("com.ehome.electpin.main");
                    startActivity(intent);

                    new Handler().postDelayed(new Runnable()
                    {
                        public void run()
                        {
                            try
                            {
                                // 延迟5秒后自动挂断电话
                                // 再通过ITelephony对象去反射里面的endCall方法，挂断电话
                                Method mt = obj.getClass().getMethod("endCall");
                                //允许访问私有方法
                                mt.setAccessible(true);
                                mt.invoke(obj);
                                Toast.makeText(Login_Act.this, "挂断电话！", Toast.LENGTH_SHORT).show();
                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }, 10* 1000);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        });*/

    }

    @Override
    public void initData()
    {

    }


    @Override
    public void login()
    {

    }

    @Override
    public void register()
    {

    }

    @Override
    public void deal()
    {

    }


    @Override
    public LoginActPresent initPresenter()
    {
        return new LoginActPresent(this);
    }
}