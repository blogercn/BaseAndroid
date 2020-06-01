package com.hxdl.coceweb.retrofitclient;

import java.util.List;

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
        getApiService().getTeacherInviteQrcode("1111").enqueue(new Callback<Result>() {
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

    }
}