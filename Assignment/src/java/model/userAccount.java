/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class userAccount {
    private int uid;
    private String username;
    private String password;
    private String email;
    private Date dob;
    private int phonenumber;
    private String avatar;
    private String gender;
    private int tid;

public userAccount(){
}

    public userAccount(int uid, String username, String password, String email, Date dob, int phonenumber, String avatar, String gender, int tid) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.avatar = avatar;
        this.gender = gender;
        this.tid = tid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public int getUid() {
        return uid;
    }

    public int getTid() {
        return tid;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDob() {
        return dob;
    }

    public String getAvatar() {
        return avatar;
    }

}