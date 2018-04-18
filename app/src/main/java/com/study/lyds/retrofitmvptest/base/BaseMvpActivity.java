package com.study.lyds.retrofitmvptest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.study.lyds.retrofitmvptest.persenter.BasePresenter;

/**
 * Created by ly on 2017/6/19.
 * presenter的初始化，与View的绑定和解绑；公共接口方法提取
 */
public abstract class BaseMvpActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected abstract T initPresenter();

    public void showLoading() {

    }

    public void showLoading(boolean cancellable){

    }

    public void showLoading(String text){

    }

    public void hideLoading() {

    }

    public void requestFail(String msg) {

    }

}
