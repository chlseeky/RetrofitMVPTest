package com.study.lyds.retrofitmvptest.persenter;

import com.google.gson.Gson;
import com.study.lyds.retrofitmvptest.http.ApiCallback;
import com.study.lyds.retrofitmvptest.model.ArticleReq;
import com.study.lyds.retrofitmvptest.model.ArticleRsp;
import com.study.lyds.retrofitmvptest.view.MainView;

import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/8/28.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public void getArticleList(ArticleReq articleReq){
        RequestBody body= RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(articleReq));
        addSubscription(tradeApiStores.getArticleList(body), new ApiCallback<ArticleRsp>() {

            @Override
            public void onSuccess(ArticleRsp model) {
                if(model.getError() == null){
                    mvpView.getArticleSuccess(model);
                }else{
                    mvpView.requestFail(model.getError().getMessage());
                }
            }

            @Override
            public void onFailure(String msg) {
                mvpView.requestFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.onFinish();
            }
        });
    }
}
