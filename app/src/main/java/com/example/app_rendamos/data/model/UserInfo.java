package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("uid")
    @Expose
    int uid;

    @SerializedName("givenName")
    @Expose
    String givenName;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("role")
    @Expose
    String role;

    public UserInfo(int uid, String givenName, String email, String role){
        this.uid = uid;
        this.givenName = givenName;
        this.email = email;
        this.role = role;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid){
        this.uid = uid;
    }

    public String getGivenName(){
        return givenName;
    }

    public void setGivenName(String givenName){
        this.givenName = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
