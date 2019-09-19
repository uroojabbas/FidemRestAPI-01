package com.vroom.dataservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvalidRequestController {

    private static final Logger logger = LoggerFactory.getLogger(InvalidRequestController.class);
    @RequestMapping (value = "/invalid", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> defaultPath() {
        logger.info("Unmapped request handling!");
        return new ResponseEntity<String>("Unmapped request", HttpStatus.OK);
    }
}
