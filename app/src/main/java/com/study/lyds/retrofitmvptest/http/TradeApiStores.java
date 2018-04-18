package com.study.lyds.retrofitmvptest.http;

import com.study.lyds.retrofitmvptest.model.ArticleRsp;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface TradeApiStores {
    String API_BASE_URL = "http://120.25.228.229:10086/";

    @POST("api/services/app/articleService/getArticleListByPageFilter")
    Observable<ArticleRsp> getArticleList(@Body RequestBody route);

}
