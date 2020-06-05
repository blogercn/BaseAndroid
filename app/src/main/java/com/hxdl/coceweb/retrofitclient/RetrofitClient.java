package com.hxdl.coceweb.retrofitclient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getSingleClient(String baseUrl) {
        if (retrofit == null) {
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(30000, TimeUnit.MILLISECONDS)
                            .readTimeout(30000, TimeUnit.MILLISECONDS)
                            .writeTimeout(30000, TimeUnit.MILLISECONDS)
                            //.addInterceptor(mRewriteCacheControlInterceptor)//没网的情况下
                            //.addNetworkInterceptor(mRewriteCacheControlInterceptor)//有网的情况下
                            //.addInterceptor(new BaseUrlInterceptor())
                            .addInterceptor(new HttpLoggingInterceptor())
                            //.cache(new Cache())
                            .build();

                    //使用该OkHttpClient创建一个Retrofit对象
                    retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            //添加RxJava语言支持
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            //指定网络请求client
                            .client(okHttpClient)
                            .build();
                }
            }
        }
        return retrofit;
    }

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
                    .writeTimeout(30000, TimeUnit.MILLISECONDS)
                    .build();

            //使用该OkHttpClient创建一个Retrofit对象
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    //添加RxJava语言支持
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //指定网络请求client
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }

    public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }
}