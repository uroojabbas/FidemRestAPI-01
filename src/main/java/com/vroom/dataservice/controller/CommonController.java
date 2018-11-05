package com.vroom.dataservice.controller;

import com.vroom.dataservice.com.vroom.dataservice.repository.CityRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.RegionRepository;
import com.vroom.dbmodel.orm.City;
import com.vroom.dbmodel.orm.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    CityRepository cityRepository;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/citylist")
    public List<City> getCityList(){
        logger.debug("getCityList");
        return cityRepository.findAll();
    }

    @GetMapping("/reigonlist")
    public List<Region> getReigonList(){

        logger.debug("getReigonList");
        return regionRepository.findAll();
    }
}
