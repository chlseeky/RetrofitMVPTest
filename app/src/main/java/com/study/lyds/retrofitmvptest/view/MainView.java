package com.study.lyds.retrofitmvptest.view;

import com.study.lyds.retrofitmvptest.model.ArticleRsp;

/**
 * Created by Administrator on 2017/8/28.
 */

public interface MainView extends BaseView {
    void getArticleSuccess(ArticleRsp articleRsp);
    void onFinish();
}
