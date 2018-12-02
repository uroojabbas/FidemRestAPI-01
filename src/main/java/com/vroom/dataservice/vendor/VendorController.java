package com.vroom.dataservice.vendor;

import com.vroom.dbmodel.orm.Vendor;
import com.vroom.dbmodel.orm.Vendortype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {

    private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    VendorTypeRepository vendorTypeRepository;

    @GetMapping("/vendor/{id}")
    @ResponseBody
    public Vendor getVendor(@PathVariable int id){
        logger.debug("getVendor : [" + id + "]");
        return vendorRepository.findById(id);

    }

    @GetMapping("/vendors/{name}")
    public Vendor getVendor(@PathVariable String name){
        logger.debug("getVendor : [" + name + "]");
        return vendorRepository.findByName(name);

    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors(){
        logger.debug("getAllVendors");
            List<Vendor> vList = vendorRepository.findAll();
        return vList;
    }

    @GetMapping("/vendortypes")
    public List<Vendortype> getAllVendorTypes(){
        logger.debug("getAllVendorTypes");
        return vendorTypeRepository.findAll();
    }

    @PostMapping(value = "/vendor/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Vendor saveVendor(@RequestBody Vendor vendor){
        logger.debug("saveVendor : Name[" + vendor.toString() + "]");
        Vendortype vendortype = vendorTypeRepository.findByName(vendor.getType());
        vendor.setVendortype(vendortype);
        vendor.setIsdeleted(Boolean.FALSE);
        return vendorRepository.save(vendor);
    }

    @PostMapping(value = "/vendor/delete",consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Vendor deleteVendor(@RequestBody int id){
        logger.debug("deleteVendor : Name[" + id + "]");

        Vendor vendor = vendorRepository.findById(id);

        if(vendor != null && vendor.getId() > 0){
            vendor.setIsdeleted(Boolean.TRUE);
        }

        return vendorRepository.save(vendor);
    }
}
