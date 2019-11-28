package ru.s7.staff;

import java.util.List;

public class User {
    Long userId;
    String userName;
    String firstName;
    String surName;
    String patronymic;
    String position;
    Boolean blocked;
    Long passHash;
    List<Permission> permissionList;

    /**
     * @deprecated
     * */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * @deprecated
     * */
    public void setPassHash(Long passHash){
        this.passHash = passHash;
    }

    public String getUserName(){
        return userName;
    }

    public Long getPassHash(){
        return passHash;
    }

}
