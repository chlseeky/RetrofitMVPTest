package com.study.lyds.retrofitmvptest.persenter;

import com.study.lyds.retrofitmvptest.http.AppClient;
import com.study.lyds.retrofitmvptest.http.TradeApiStores;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/6/15.
 */

public class BasePresenter<T> {
    protected T mvpView;
    protected TradeApiStores tradeApiStores;
    private CompositeSubscription mCompositeSubscription;

    public void attachView(T view) {
        this.mvpView = view;
        tradeApiStores = AppClient.getTradeRetrofit().create(TradeApiStores.class);
    }

    public void detachView() {
        this.mvpView = null;
        unSubscribe();
    }

    public void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

}