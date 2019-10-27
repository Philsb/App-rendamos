package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogInResponse {
    @SerializedName("LoginData")
    @Expose
    LoginData loginData;

    @SerializedName("UserInfo")
    @Expose
    UserInfo userInfo;

    public LogInResponse(LoginData loginData, UserInfo userinfo){
        this.loginData = loginData;
        this.userInfo = userinfo;
    }

    public LoginData getLoginData(){return loginData;}

    public void setLoginData(LoginData loginData){
        this.loginData = loginData;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }
}
