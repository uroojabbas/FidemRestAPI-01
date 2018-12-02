package com.vroom.dataservice.po;

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

    @GetMapping("/po/vendor/{vendorId}")
    @ResponseBody
    public Collection<Pomaster> getVendorPOList(@PathVariable int vendorId){
        logger.debug("getPOById : ");
        return purchaseOrderService.getVendorPOList(vendorId);

    }


    @PostMapping(value = "/purchaseorder/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Pomaster savePO(@RequestBody Pomaster pomaster){
        logger.debug("save PO : Name[" + pomaster.toString() + "]");
        return purchaseOrderService.save(pomaster);
    }

    @PostMapping(value = "/purchaseorder/approve",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Pomaster approvePO(@RequestBody Pomaster pomaster){
        logger.debug("approvePO[" + pomaster.toString() + "]");
        return purchaseOrderService.approvePO(pomaster);
    }

    @PostMapping(value = "/purchaseorder/reject",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Pomaster rejectPO(@RequestBody Pomaster pomaster){
        logger.debug("rejectPO[" + pomaster.toString() + "]");
        return purchaseOrderService.rejectPO(pomaster);
    }


    @PostMapping(value = "/purchaseorder/cancel",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Pomaster cancelPO(@RequestBody Pomaster pomaster){
        logger.debug("cancelPO[" + pomaster.toString() + "]");
        return purchaseOrderService.cancelPO(pomaster);
    }
}
