package com.ehome.electpin.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.ehome.electpin.mvp.contract.LoginContract;
import com.ehome.electpin.mvp.model.LoginActModule;
import com.fly.tour.api.entity.LoginEntity;
import com.fly.tour.common.mvp.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginActPresent extends BasePresenter<LoginActModule,LoginContract.View> implements  LoginContract.Presenter
{
    public LoginActPresent(Context context)
    {

        super(context);

    }

    @Override
    public LoginActModule initModel()
    {
        return new LoginActModule(mContext);
    }


    @Override
    public void login(String phone, String password)
    {
        mModel.login(phone,password).subscribe(new Observer<LoginEntity>()
        {
            @Override
            public void onSubscribe(Disposable d)
            {

            }

            @Override
            public void onNext(LoginEntity loginEntity)
            {
                Log.i("onNext",loginEntity.code+"");
            }

            @Override
            public void onError(Throwable e)
            {

            }

            @Override
            public void onComplete()
            {

            }
        });
    }


}
