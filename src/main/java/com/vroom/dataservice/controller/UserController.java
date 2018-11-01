package com.vroom.dataservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;
import com.vroom.orm.Users;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable int id){
        logger.debug("getUser : [" + id + "]");
        return userRepository.findById(id);

    }

    @GetMapping("/users/{name}")
    public List<Users> getUser(@PathVariable String name){
        logger.debug("getUser : [" + name + "]");
        return userRepository.findByName(name);

    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        logger.debug("getUsers");
        return userRepository.findAll();

    }

    @PostMapping(value = "/user/login",consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Users loginUser(@RequestBody Users user){
        logger.debug("loginUser : Name[" + user.toString() + "]");
        return userRepository.findByUsername(user.getUsername());

    }
}
