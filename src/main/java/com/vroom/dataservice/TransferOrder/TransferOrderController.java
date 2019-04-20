package com.vroom.dataservice.TransferOrder;

import com.vroom.dbmodel.orm.Tomaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TransferOrderController {
    private static final Logger logger = LoggerFactory.getLogger(TransferOrderController.class);

    @Autowired
    TransferOrderService transferOrderService;

    @PostMapping(value = "/transferOrder/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<Boolean> savePO(@RequestBody Tomaster tomaster){
        logger.debug("save TO : Name[" + tomaster.toString() + "]");
        transferOrderService.save(tomaster);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping("/transferOrders")
    @ResponseBody
    public Collection<Tomaster> getPOList(){
        logger.debug("getPOById : ");
        return transferOrderService.getAll();

    }

    @PostMapping(value = "/transferOrder/approve",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Tomaster approvePO(@RequestBody Tomaster tomaster){
        logger.debug("approveTO[" + tomaster.toString() + "]");
        return transferOrderService.approveTO(tomaster);
    }

    @PostMapping(value = "/transferOrder/reject",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Tomaster rejectPO(@RequestBody Tomaster tomaster){
        logger.debug("rejectTO[" + tomaster.toString() + "]");
        return transferOrderService.rejectTO(tomaster);
    }


    @PostMapping(value = "/transferOrder/cancel",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Tomaster cancelPO(@RequestBody Tomaster tomaster){
        logger.debug("cancelTO[" + tomaster.toString() + "]");
        return transferOrderService.cancelTO(tomaster);
    }

    @PostMapping(value = "/transferOrder/dispatch",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Tomaster dispatchPO(@RequestBody Tomaster tomaster){
        logger.debug("dispatchTO[" + tomaster.toString() + "]");
        return transferOrderService.dispatchTO(tomaster);
    }

    @PostMapping(value = "/transferOrder/inventoryReceived",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Tomaster inventoryReceived(@RequestBody Tomaster tomaster){
        logger.debug("inventoryReceived[" + tomaster.toString() + "]");
        return transferOrderService.inventoryReceived(tomaster);
    }

}
