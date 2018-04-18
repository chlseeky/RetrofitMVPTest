package com.study.lyds.retrofitmvptest.http;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 * 订阅者，网络错误的回调
 */
public abstract class ApiCallback<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String msg;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 500 || code == 502 || code == 503 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
        } else {
            msg = e.getMessage();
            onFailure(msg);
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);
    }

    @Override
    public void onCompleted() {
        onFinish();
    }

}
