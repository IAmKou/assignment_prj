/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class companyAccount {
    private int cid;
    private String name;
    private String password;
    private String email;
    private int tel;
    private String address;
    private String avatar;
    private String description;
    private String url;
    private int cpid;
    
    public companyAccount(){
    }

    public companyAccount(int cid, String name, String password, String email, int tel, String address, String avatar, String description, String url, int cpid) {
        this.cid = cid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.avatar = avatar;
        this.description = description;
        this.url = url;
        this.cpid = cpid;
    }

    public String getAddress() {
        return address;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getCid() {
        return cid;
    }

    public int getCpid() {
        return cpid;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getTel() {
        return tel;
    }

    public String getUrl() {
        return url;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCpid(int cpid) {
        this.cpid = cpid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
