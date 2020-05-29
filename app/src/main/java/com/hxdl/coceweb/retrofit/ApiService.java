package com.hxdl.coceweb.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;

//ApiService.java
public interface ApiService {
    @GET("/TP_S/BookList")
    Observable<GithubUserInfo> queryJakeWhartonInfo();
}
