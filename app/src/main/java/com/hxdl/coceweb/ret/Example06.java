package com.hxdl.coceweb.ret;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * [Retrofit Converter 反序化]源码
 */
public class Example06 {
    public interface BlogService {
        @GET("/robot/live/manager/getTeacherInviteQrcode.xhtml")
        Call<ResponseBody> getQrcode(@Query("venueId") String venueId);
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                //配置你的Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev.hxlx.com/")
                //可以接收自定义的Gson，当然也可以不传
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        BlogService service = retrofit.create(BlogService.class);
        Call<ResponseBody> call = service.getQrcode("111");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.toString());
                System.out.println(response.message());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }


        });
    }
}
