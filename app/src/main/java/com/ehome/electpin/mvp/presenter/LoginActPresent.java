package com.ehome.electpin.mvp.presenter;

import android.content.Context;

import com.ehome.electpin.mvp.contract.LoginContract;
import com.fly.tour.common.mvp.model.BaseModel;

public class LoginActPresent extends LoginContract.Presenter
{
    public LoginActPresent(Context context)
    {

        super(context);

    }

    @Override
    public BaseModel initModel()
    {
        return null;
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
