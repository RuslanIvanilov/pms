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
    Boolean admin;
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

    public boolean getBlocked(){ return this.blocked; }

    public boolean isExists(){
        User user = find();
        return user.firstName != null || user.surName != null  ;
    }

    private User find(){
        UserUtils userUtils = new UserUtils();
        userUtils.loadFromJson();
        List<User> userList = userUtils.getUserList();

        for(User user : userList){
            if(user.getUserName().equalsIgnoreCase(this.userName) && user.getPassHash().longValue() == this.passHash.longValue() && !user.blocked){
                fillThis(user);
                break;
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return "userId: "+this.userId+"\n"
                +"userName: "+this.userName+"\n"
                +"firstName: "+this. firstName+"\n"
                +"surName: "+this.surName+"\n"
                +"patronymic: "+this.patronymic+"\n"
                +"position: "+this.position+"\n"
                +"blocked: "+this.blocked+"\n"
                +"passHash: "+this.passHash+"\n"
                +"admin: "+this.admin
                ;
    }

    public String getFullName(){
        return this.surName + " " + this.firstName + " " + this.patronymic;
    }

    private void fillThis(User user){
        this.userId = user.userId;
        this.firstName = user.firstName;
        this.surName = user.surName;
        this.patronymic = user.patronymic;
        this.position = user.position;
        this.blocked = user.blocked;
        this.admin = user.admin;
    }

    public String getPosition(){ return this.position; }
    public Boolean getAdmin(){ return this.admin; }

    public void clear(){
        fillThis(new User());
    }

}
