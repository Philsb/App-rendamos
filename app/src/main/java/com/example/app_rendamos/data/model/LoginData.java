package com.example.app_rendamos.data.model;

import android.media.session.MediaSession;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("access_token")
    @Expose
    String access_token;

    @SerializedName("expires_in")
    @Expose
    int expires_in;

    @SerializedName("token_type")
    @Expose
    String token_type;

    @SerializedName("refresh_token")
    @Expose
    String refresh_token;

    @SerializedName("scope")
    @Expose
    String scope;

    public LoginData(String access_token, int expires_in, String token_type, String refresh_token, String scope){
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.refresh_token = refresh_token;
        this.scope = scope;
    }

    public String getAccess_token(){
        return access_token;
    }
    public void setAccess_token(String access_token){
        this.access_token = access_token;
    }

    public int getExpires_in(){
        return expires_in;
    }
    public void setExpires_in(int expires_in){
        this.expires_in = expires_in;
    }

    public String getToken_type(){
        return token_type;
    }
    public void setToken_type(String token_type){
        this.token_type = token_type;
    }

    public String getRefresh_token(){
        return refresh_token;
    }
    public void setRefresh_token(String refresh_token){
        this.refresh_token= refresh_token;
    }

    public String getScope(){
        return scope;
    }
    public void setScope(String scope){
        this.scope = scope;
    }


}
