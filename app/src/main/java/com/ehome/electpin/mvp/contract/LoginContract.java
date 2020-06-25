package com.ehome.electpin.mvp.contract;

import android.content.Context;
import android.content.Intent;

import com.ehome.electpin.entity.Loginentry;
import com.ehome.electpin.mvp.model.LoginActModule;
import com.fly.tour.api.entity.LoginEntity;
import com.fly.tour.common.mvp.model.BaseModel;
import com.fly.tour.common.mvp.presenter.BasePresenter;
import com.fly.tour.common.mvp.view.BaseView;

import io.reactivex.Observable;

public interface LoginContract
{

     interface Model<T>
    {


         T login(String phone,String password);



    }

    interface View extends BaseView
    {

        void login();

        void register();

        void deal();

    }

    interface Presenter{


        /**
         * 登录
         */
         void login(String phone ,String password);



    }
}