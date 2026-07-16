package com.sprint.mission.entity;

public class User extends BaseEntity{

    private String userName;

    public User(String userName) {
        super();
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void updateUserName(String userName){
        this.userName = userName;
        this.updateUpdatedAt(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
