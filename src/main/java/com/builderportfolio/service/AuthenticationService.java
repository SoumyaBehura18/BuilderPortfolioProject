package com.builderportfolio.service;

import com.builderportfolio.model.User;
import com.builderportfolio.exceptions.InvalidUserException;

public interface AuthenticationService {
    User login(String username, String password) throws InvalidUserException;
    void register(User user);
}
