package com.ehome.electpin.mvp.model;

import android.content.Context;

import com.ehome.electpin.mvp.contract.LoginContract;

public class LoginActModule extends LoginContract.Model
{
    public LoginActModule(Context context)
    {
        super(context);
    }

    @Override
    public void login(String phone, String password)
    {
        super.login(phone, password);


    }

    @Override
    public void register()
    {
        super.register();
    }

    @Override
    public void deal()
    {
        super.deal();
    }
}
