package com.vroom.dataservice.controller;

import com.vroom.dataservice.services.UserService;
import com.vroom.dbmodel.orm.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public Object getUser(@PathVariable int id){
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
    public Object loginUser(@RequestBody Users user){
        logger.debug("loginUser : Name[" + user.toString() + "]");
        return userRepository.findByUsername(user.getUsername());

    }

    @PostMapping(value = "/user/add",consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Users insertUser(@RequestBody Users user){
        logger.debug("inserUser : Name[" + user.toString() + "]");
        return userService.save(user);
    }

    @PostMapping(value = "/user/delete",consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Users deleteUser(@RequestBody int id){
        logger.debug("inserUser : Name[" + id + "]");

        Users user = userRepository.findById(id);

        if(user != null && user.getId() > 0){
            user.setIsdeleted(true);
        }

        return userRepository.save(user);
    }

}
