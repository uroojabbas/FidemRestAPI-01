package com.vroom.dataservice.GoodsReceivedNote;

import com.vroom.dbmodel.orm.Grnmaster;
import com.vroom.dbmodel.orm.Pomaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class GoodsReceivedNoteService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsReceivedNoteService.class);

    @Autowired
    GoodsReceivedNoteRepository goodsReceivedNoteRepository;

    public Grnmaster generateGRN(int userid, Pomaster pomaster, Integer modifiedbyuserid){
        return new Grnmaster(userid,
                pomaster,
                modifiedbyuserid,
                new Date(),
                new Date(),
                Boolean.FALSE
        );
    }

    public Grnmaster getById(int grnId){
        return goodsReceivedNoteRepository.findById(grnId);
    }

    public Collection<GoodsReceivedNoteList> getGRNList(){
        return goodsReceivedNoteRepository.findAllGRNs();
    }
}
