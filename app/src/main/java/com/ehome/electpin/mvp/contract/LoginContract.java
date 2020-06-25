package com.ehome.electpin.mvp.contract;

import android.content.Context;

import com.fly.tour.common.mvp.model.BaseModel;
import com.fly.tour.common.mvp.presenter.BasePresenter;
import com.fly.tour.common.mvp.view.BaseView;

public interface LoginContract
{

    abstract class Model extends BaseModel
    {
        public Model(Context context)
        {
            super(context);
        }


        public void login(String phone,String password)
        {

        }

        public void register()
        {
        }

        public void deal()
        {
        }


    }

    interface View extends BaseView
    {

        void login();

        void register();

        void deal();

    }

    abstract class Presenter extends BasePresenter
    {

        public Presenter(Context context)
        {
            super(context);
        }

        /**
         * 登录
         */
        public void login(String phone ,String password)
        {
        }

        public void register()
        {
        }

        public void deal()
        {
        }
    }
}