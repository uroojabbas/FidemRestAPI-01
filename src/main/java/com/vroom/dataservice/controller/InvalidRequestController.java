package com.vroom.dataservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvalidRequestController {

    @GetMapping("/")
    @ResponseBody
    public Object redirectInvalidRequest() {
        return "redirect:/index.html";
    }
}
