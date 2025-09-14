package com.builderportfolio.service;

import com.builderportfolio.dao.UserDAO;
import com.builderportfolio.exceptions.InvalidUserException;
import com.builderportfolio.model.User;

public class AuthenticationServiceImpl implements AuthenticationService {
    private UserDAO userDAO = new UserDAO();

    @Override
    public User login(String username, String password) throws InvalidUserException {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new InvalidUserException("Invalid username or password");
        }
    }

    @Override
    public void register(User user) { userDAO.addUser(user); }
}
