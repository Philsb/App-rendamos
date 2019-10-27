package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentResponse {
    @SerializedName("dob")
    @Expose
    String dob;
    @SerializedName("joinDate")
    @Expose
    String joinDate;
    @SerializedName("earlyBirthAmount")
    @Expose
    int earlyBirthAmount;
    @SerializedName("sponsorId")
    @Expose
    int sponsorId;
    @SerializedName("classRoomId")
    @Expose
    int classRoomId;
    @SerializedName("classRoom")
    @Expose
    ClassRoom classRoom;
    @SerializedName("form")
    @Expose
    Form form;
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("dni")
    @Expose
    int dni;
    @SerializedName("firstName")
    @Expose
    String firstName;
    @SerializedName("lastName")
    @Expose
    String lastName;
    @SerializedName("gender")
    @Expose
    String gender;
    @SerializedName("locationId")
    @Expose
    int locationId;
    @SerializedName("status")
    @Expose
    String status;

    public StudentResponse(String dob, String joinDate, int earlyBirthAmount, int sponsorId, int classRoomId, ClassRoom classRoom, Form form, int id, int dni, String firstName, String lastName, String gender, int locationId, String status){
        this.dob = dob;
        this.joinDate = joinDate;
        this.earlyBirthAmount = earlyBirthAmount;
        this.classRoomId = classRoomId;
        this.classRoom = classRoom;
        this.form = form;
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.locationId = locationId;
        this.status = status;
    }

    public String getDob() {
        return dob;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public int getEarlyBirthAmount() {
        return earlyBirthAmount;
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public Form getForm() {
        return form;
    }

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getStatus() {
        return status;
    }
}
