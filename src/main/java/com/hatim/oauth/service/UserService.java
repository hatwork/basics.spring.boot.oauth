package com.hatim.oauth.service;

import java.util.List;

import com.hatim.oauth.model.User;

public interface UserService {
    List<User> findAll();
}
