package com.study.lyds.retrofitmvptest.view;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public interface BaseView {
    void showLoading();
    void hideLoading();
    void showLoading(boolean cancellable);
    void showLoading(String text);
    void requestFail(String msg);

}
