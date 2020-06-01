package com.hxdl.coceweb.mvp;
public interface LoginModelInterface {
    void login(String userName,String password, LoginPresenter.CallBack callBack);
}
