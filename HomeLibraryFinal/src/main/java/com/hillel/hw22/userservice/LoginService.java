package com.hillel.hw22.userservice;

import com.hillel.hw22.dbUtils.DBWork;
import com.hillel.hw22.person.User;

public class LoginService {
    DBWork dbWork = new DBWork();

    public User login(String username, String password) {
        User user = dbWork.findUser(username, password);

        if (user != null) {
            return user;
        } else {
            return new User("New User", "");
        }

    }
}