package com.springbootapp.service;

import com.springbootapp.entity.postgres.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
}
