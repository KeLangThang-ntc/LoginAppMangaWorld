package com.example.testlogin;

import java.io.Serializable;

public class User implements Serializable {
    private  int userID;
    private  String userLoginId;
    private  String passWord;
    private  String userName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(int userID, String userLoginId, String passWord, String userName) {
        this.userID = userID;
        this.userLoginId = userLoginId;
        this.passWord = passWord;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userLoginId='" + userLoginId + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
