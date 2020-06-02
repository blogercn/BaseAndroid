package com.hxdl.coceweb.retrofitclient;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers("urlname:test1")
    @GET("/robot/live/manager/getTeacherInviteQrcode.xhtml")
    Call<Result> getTeacherInviteQrcode(@Query("venueId") String venueId);


    @Headers("urlname:test2")
    @GET("partner/live/openLiveSupport.xhtml")
    Call<Result> openLiveSupport(@Query("venueId") String venueId, @Query("memberIds") String memberIds);

    @Headers("urlname:test2")
    @GET("partner/live/openLiveSupport.xhtml")
    Observable<Result> openLiveSupport2(@Query("venueId") String venueId, @Query("memberIds") String memberIds);
}