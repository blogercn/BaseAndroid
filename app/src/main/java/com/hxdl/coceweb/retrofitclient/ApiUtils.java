package com.hxdl.coceweb.retrofitclient;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUtils {

    public static final String BASE_URL1 = "http://dev.hxlx.com/";
    public static final String BASE_URL2 = "http://dev.hxlx.com/robot/";

    public static ApiService getApiService() {
        return RetrofitClient.getSingleClient(BASE_URL1).create(ApiService.class);
    }
    public static ApiService getApiService2() {
        return RetrofitClient.getSingleClient(BASE_URL2).create(ApiService.class);
    }
    public static void main(String[] args) {
        getApiService2().getTeacherInviteQrcode("1111").enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println(call.request().toString());
                Result t = response.body();
                System.out.println(t.toString());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                System.out.println(t.toString());
            }
        });

        getApiService2().openLiveSupport("1111", "2222").enqueue(new Callback<Result>() {


            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println(call.request().toString());
                Result t = response.body();
                System.out.println(t.toString());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                System.out.println(t.toString());
            }
        });

        getApiService2().openLiveSupport2("1111", "2222")
                //.compose(this.<Result>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        System.out.println(result.toString());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}