package com.vroom.dataservice.services;

import com.vroom.dataservice.com.vroom.dataservice.repository.PurchaseOrderRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.VendorRepository;
import com.vroom.dbmodel.orm.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VendorRepository vendorRepository;

    public Pomaster getById(int id){
        return purchaseOrderRepository.findById(id);
    }

    public Collection<Pomaster> getAll(){
        return purchaseOrderRepository.findAll();
    }

    public Pomaster save(Pomaster pomaster){
        //return purchaseOrderRepository.save(pomaster);
        int userId = pomaster.getUsers().getId();
        Users user = userRepository.findById(userId);
        int vendorId = pomaster.getVendor().getId();
        Vendor vendor = vendorRepository.findById(vendorId);

        pomaster.setVendor(vendor);
        pomaster.setInsertedtime(new Date());
        pomaster.setIsdeleted(Boolean.FALSE);
        pomaster.setUsers(user);
        for(Postatus ps:pomaster.getPostatus()){
            int poStatusId = ps.getPostatusid();
            Postatus postatus = new Postatus(pomaster,
                    poStatusId, true, userId, new Date());
            pomaster.getPostatus().clear();
            pomaster.getPostatus().add(postatus);
        }

        for(Podetail podetail: pomaster.getPodetail()){
            podetail.setPomaster(pomaster);
        }

        return purchaseOrderRepository.save(pomaster);
    }
}
