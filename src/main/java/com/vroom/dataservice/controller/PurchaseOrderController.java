package com.vroom.dataservice.controller;

import com.vroom.dataservice.services.PurchaseOrderService;
import com.vroom.dbmodel.orm.Pomaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PurchaseOrderController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping("/purchaseorder/{id}")
    @ResponseBody
    public Pomaster getPOById(@PathVariable int id){
        logger.debug("getPOById : [" + id + "]");
        return purchaseOrderService.getById(id);

    }

    @GetMapping("/purchaseorders")
    @ResponseBody
    public Collection<Pomaster> getPOList(){
        logger.debug("getPOById : ");
        return purchaseOrderService.getAll();

    }


    @PostMapping(value = "/purchaseorder/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Pomaster saveProduct(@RequestBody Pomaster pomaster){
        logger.debug("save PO : Name[" + pomaster.toString() + "]");
        return purchaseOrderService.save(pomaster);
    }

}
