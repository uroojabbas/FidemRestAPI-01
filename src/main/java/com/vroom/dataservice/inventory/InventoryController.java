package com.vroom.dataservice.inventory;
import com.vroom.dbmodel.orm.Podetail;
import com.vroom.dbmodel.orm.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    InventoryService inventoryService;

    @PostMapping(value = "/inventory/add",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public List<Podetail> addInventory(@RequestBody List<Podetail> products){
        logger.debug("addInventory[" + " " + "]");

        this.inventoryService.save(products);

        return products;
    }
}

