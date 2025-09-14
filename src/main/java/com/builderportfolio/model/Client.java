package com.builderportfolio.model;

public class Client extends User {
    public Client(int userId, String username, String email,String password) {
        super(userId, username, email, password ,"CLIENT");
    }
}
