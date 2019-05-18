package com.vroom.dataservice.GoodsReceivedNote;

import com.vroom.dbmodel.orm.Grnmaster;
import com.vroom.dbmodel.orm.Vendor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class GoodsReceivedNoteController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsReceivedNoteController.class);

    @Autowired
    GoodsReceivedNoteService goodsReceivedNoteService;

    @GetMapping("/grn/grn-list")
    public Collection<GoodsReceivedNoteList> getAllGRN(){
        logger.debug("getAllGRN");
        Collection<GoodsReceivedNoteList> grnList = goodsReceivedNoteService.getGRNList();
        return grnList;
    }

    @GetMapping("/grn/id/{grnId}")
    public Grnmaster getById(@PathVariable int grnId){
        logger.debug("getById");
        return goodsReceivedNoteService.findById(grnId);
    }

    @GetMapping("/grn/vendor/{vendorId}")
    public Collection<GoodsReceivedNoteList> getByVendorId(@PathVariable int vendorId){
        logger.debug("getById");
        return goodsReceivedNoteService.findByVendorId(vendorId);
    }

    @GetMapping("/grn/list/{grnList}")
    public Collection<GoodReceivedNoteProductList> getGRNById(@PathVariable Number ... grnList){
        logger.debug("getGRNById");
        return goodsReceivedNoteService.getGRNById(grnList);
    }
}
