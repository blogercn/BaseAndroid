package com.hxdl.coceweb.retrofit;

import com.google.gson.annotations.SerializedName;

//JsonObjBase.java，解析对象类型
public class JsonObjBase<T> extends JsonBase {
    @SerializedName("data")
    T data;
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}