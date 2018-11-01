package com.vroom.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class CustomErrorController {

    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);


    @RequestMapping (value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> defaultPath() {
        logger.debug("Unmapped request handling!");
        return new ResponseEntity<String>("Unmapped request", HttpStatus.OK);
    }
}
