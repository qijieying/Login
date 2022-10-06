package com.iweb.bookstore.service;

public class LoginManagement {
    public static boolean login(String userName,String pass) {
        if(userName.equals("123456")&&pass.equals("123456"))
            return true;
        if(userName.equals("戚洁莹")&&pass.equals("123"))
            return true;
        return false;
    }
}