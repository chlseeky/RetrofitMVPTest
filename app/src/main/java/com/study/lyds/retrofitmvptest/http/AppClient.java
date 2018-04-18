package com.study.lyds.retrofitmvptest.http;

import com.google.gson.Gson;
import com.study.lyds.retrofitmvptest.base.LyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：luoyin on 2017/06/19 13:26
 * 邮箱：2540757573@qq.com
 */
public class AppClient {
    public static Retrofit mTradeRetrofit;
    private static OkHttpClient okHttpClient;

    public static Retrofit getTradeRetrofit() {
        if (mTradeRetrofit == null) {
            mTradeRetrofit = new Retrofit.Builder()
                    .baseUrl(TradeApiStores.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return mTradeRetrofit;
    }

    public static OkHttpClient getOkHttpClient(){
        if (okHttpClient == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (true) {
//                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            //设置超时
            builder.connectTimeout(10, TimeUnit.SECONDS);//10
            builder.readTimeout(20, TimeUnit.SECONDS);//20
            builder.writeTimeout(20, TimeUnit.SECONDS);//20
            //错误重连
            builder.retryOnConnectionFailure(true);
            okHttpClient = builder.build();

            File httpCacheDirectory = new File(LyApplication.getInstance().getExternalCacheDir(), "responses");
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(httpCacheDirectory, cacheSize);
            builder.cache(cache);
//            builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();

            Request request = chain.request();
            if (!LyApplication.isNetworkAvailable(LyApplication.getInstance())) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();

            }
            Response originalResponse = chain.proceed(request);
            if (LyApplication.isNetworkAvailable(LyApplication.getInstance())) {
                int maxAge = 0; // read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-xcached, max-stale=" + maxStale)
                        .build();
            }
        }
    };
}
