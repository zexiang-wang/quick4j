package com.eliteams.quick4j.core.entity;

/**
 * @author wyx
 * @date 2020/12/10
 * @Time 2:07
 */
public class User {

    private String userName;

    private String passWord;

    public User(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
