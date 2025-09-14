package com.builderportfolio.dao;

import com.builderportfolio.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    void addUserTest() {
        User user = new User("testuser", "test@example.com", "pass123", "CLIENT");
        assertDoesNotThrow(() -> userDAO.addUser(user));
    }

    @Test
    void getUserByUsernameTest() {
        User user = new User("getuser", "get@example.com", "pass123", "BUILDER");
        userDAO.addUser(user);

        User retrieved = userDAO.getUserByUsername("getuser");
        assertNotNull(retrieved);
        assertEquals("getuser", retrieved.getUsername());
        assertEquals("BUILDER", retrieved.getRole());
    }
}
