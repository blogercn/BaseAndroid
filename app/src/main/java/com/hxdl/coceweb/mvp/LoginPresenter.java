package com.hxdl.coceweb.mvp;

import android.text.TextUtils;

public class LoginPresenter {

    private final LoginModelInterface loginBusiness;

    private final LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface viewInterface){
        this.loginBusiness = new LoginBusinessImp();
        this.loginViewInterface = viewInterface;
    }

    public void login(){
        String userName = loginViewInterface.getUserName();
        String password  = loginViewInterface.getPassword();
        if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(password)){
            loginViewInterface.showLoginFail("请完善登录信息");
            return;
        }
        loginViewInterface.showProgress();
        loginBusiness.login(userName, password, new CallBack() {
            @Override
            public void onSuccess(LoginInfo info) {
                loginViewInterface.dismissProgress();
                loginViewInterface.goToActivity();
            }

            @Override
            public void onFail(final Throwable error) {
                loginViewInterface.dismissProgress();
                loginViewInterface.showLoginFail(error.getMessage());
            }
        });
    }

    public interface CallBack{

        void onSuccess(LoginInfo info);

        void onFail(Throwable error);
    }
}
