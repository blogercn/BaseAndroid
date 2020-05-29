package com.hxdl.coceweb.ret;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {

    @GET("/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers();

    @GET("/2.2//answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);

    @GET("/robot/live/manager/getTeacherInviteQrcode.xhtml")
    Call<TeacherInviteQrcodeResult> getTeacherInviteQrcode(@Query("venueId") String venueId);

    @GET("/robot/partner/live/openLiveSupport.xhtml")
    Call<TeacherInviteQrcodeResult> openLiveSupport(@Query("venueId") String venueId, @Query("memberIds") String memberIds);
}