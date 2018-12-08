package com.hatim.oauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hatim.oauth.model.User;
import com.hatim.oauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return service.findAll();
    }
}
