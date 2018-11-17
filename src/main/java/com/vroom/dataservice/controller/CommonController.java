package com.vroom.dataservice.controller;

import com.vroom.dataservice.com.vroom.dataservice.repository.*;
import com.vroom.dbmodel.orm.*;
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

    @Autowired
    VendorTypeRepository vendorTypeRepository;

    @Autowired
    ClientTypeRepository ClientTypeRepository;

    @Autowired
    InstituteTypeRepository instituteTypeRepository;

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

    @GetMapping("/vendortypelist")
    public List<Vendortype> getVendorTypeList(){
        logger.debug("getVendorTypeList");
        return vendorTypeRepository.findAll();
    }

    @GetMapping("/clienttypelist")
    public List<Clienttype> getClientTypeList(){
        logger.debug("getClientTypeList");
        return ClientTypeRepository.findAll();
    }

    @GetMapping("/institutetypelist")
    public List<Institutetype> getInstitutetypeList(){
        logger.debug("getInstitutetypeList");
        return instituteTypeRepository.findAll();
    }
}
