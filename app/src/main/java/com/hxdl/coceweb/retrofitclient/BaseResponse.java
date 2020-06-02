package com.hxdl.coceweb.retrofitclient;

class BaseResponse<T> {
    private String errcode;
    private T data;
    private boolean success;
    private String msg;
}
