package com.ehome.electpin.mvp.contract;

import android.content.Context;

import com.fly.tour.common.mvp.model.BaseModel;
import com.fly.tour.common.mvp.presenter.BasePresenter;
import com.fly.tour.common.mvp.view.BaseView;

/**
 * @author ykc
 * @describe
 * @date 2020/6/24  18:01
 * - generate by MvpAutoCodePlus plugin.
 */

public interface ICommunicateContract
{
    interface View extends BaseView
    {
    }

    abstract class Presenter extends BasePresenter
    {
        public Presenter(Context context)
        {
            super(context);
        }
    }

    abstract class Model extends BaseModel
    {
        public Model(Context context)
        {
            super(context);
        }
    }
}
