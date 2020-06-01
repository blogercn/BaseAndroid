package com.hxdl.coceweb.mvp;

public interface LoginViewInterface {
    String getUserName();

    String getPassword();

    void showProgress();

    void dismissProgress();

    void showLoginFail(String error);

    void goToActivity();
}
