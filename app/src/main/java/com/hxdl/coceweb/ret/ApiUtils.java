package com.hxdl.coceweb.ret;

import android.util.Log;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUtils {

    public static final String BASE_URL2 = "https://api.stackexchange.com/";

    public static final String BASE_URL = "http://dev.hxlx.com/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
    public static SOService getSOService2() {
        return RetrofitClient.getClient(BASE_URL2).create(SOService.class);
    }
    public static void main(String[] args) {
        SOService ss = getSOService();


        getSOService2().getAnswers().enqueue(new Callback<List<SOAnswersResponse>>() {
            @Override
            public void onResponse(Call<List<SOAnswersResponse>> call, Response<List<SOAnswersResponse>> response) {
                List<SOAnswersResponse> l= response.body();
                for (SOAnswersResponse s : l){
                    System.out.println(s.toString());
                }
            }

            @Override
            public void onFailure(Call<List<SOAnswersResponse>> call, Throwable t) {
                System.out.println(t.toString());
            }

        });



        ss.getTeacherInviteQrcode("1111").enqueue(new Callback<TeacherInviteQrcodeResult>() {


            @Override
            public void onResponse(Call<TeacherInviteQrcodeResult> call, Response<TeacherInviteQrcodeResult> response) {
                TeacherInviteQrcodeResult t = response.body();
                System.out.println(t.toString());
            }

            @Override
            public void onFailure(Call<TeacherInviteQrcodeResult> call, Throwable t) {
                System.out.println(t.toString());
            }
        });

        ss.openLiveSupport("1111", "2222").enqueue(new Callback<TeacherInviteQrcodeResult>() {


            @Override
            public void onResponse(Call<TeacherInviteQrcodeResult> call, Response<TeacherInviteQrcodeResult> response) {
                TeacherInviteQrcodeResult t = response.body();
                System.out.println(t.toString());
            }

            @Override
            public void onFailure(Call<TeacherInviteQrcodeResult> call, Throwable t) {
                System.out.println(t.toString());
            }
        });

    }
}