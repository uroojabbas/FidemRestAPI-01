package com.vroom.dataservice.po;

import com.vroom.dataservice.com.vroom.dataservice.repository.*;
import com.vroom.dataservice.vendor.VendorRepository;
import com.vroom.dbmodel.orm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    POStatusTypeRepository poStatusTypeRepository;

    @Autowired
    POStatusRepository poStatusRepository;

    public Pomaster getById(int id){
        return purchaseOrderRepository.findById(id);
    }

    public Collection<Pomaster> getAll(){
        return purchaseOrderRepository.findAll();
    }

    public Collection<Pomaster> getVendorPOList(int vendorId){

        List<Integer> poStatusTypeList = new ArrayList<>(0);
        poStatusTypeList.add(POStatusType.PO_APPROVED.getValue());
        poStatusTypeList.add(POStatusType.PARTIAL_INVENTORY_RECEIVED.getValue());

        return poStatusRepository.findByVendorId(vendorId,poStatusTypeList);
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
            int poStatusTypeId = ps.getPostatusType().getId();
            Postatustype postatustype  = this.poStatusTypeRepository.findById(poStatusTypeId);

            Postatus postatus = new Postatus(pomaster,
                    postatustype, true, userId, new Date());

            pomaster.getPostatus().clear();
            pomaster.getPostatus().add(postatus);
        }

        for(Podetail podetail: pomaster.getPodetail()){
            Product product = productRepository.findById(podetail.getProduct().getId());
            podetail.setProduct(product);
            podetail.setPomaster(pomaster);
        }

        return purchaseOrderRepository.save(pomaster);
    }

    public Pomaster approvePO(Pomaster pomaster){
        Pomaster po = purchaseOrderRepository.findById(pomaster.getId());
        Postatustype postatustype = poStatusTypeRepository.findById(POStatusType.PO_APPROVED.getValue());

         return this.changePOStatus(pomaster, postatustype);
    }

    public Pomaster rejectPO(Pomaster pomaster){

        Pomaster po = purchaseOrderRepository.findById(pomaster.getId());
        Postatustype postatustype = poStatusTypeRepository.findById(POStatusType.REJECTED.getValue());

        return this.changePOStatus(pomaster, postatustype);
    }

    public Pomaster cancelPO(Pomaster pomaster){

        Pomaster po = purchaseOrderRepository.findById(pomaster.getId());
        Postatustype postatustype = poStatusTypeRepository.findById(POStatusType.CANCELLED.getValue());

        return this.changePOStatus(pomaster, postatustype);
    }

    private  Pomaster changePOStatus(Pomaster pomaster, Postatustype postatustype){
        Pomaster po = purchaseOrderRepository.findById(pomaster.getId());

        if((po.getPostatus() != null) && !(po.getPostatus().isEmpty())){
            Postatus postatus = po.getPostatus().iterator().next();
            postatus.setIsactive(Boolean.FALSE);
            po.getPostatus().add(postatus);
            po.setModifiedbyuserid(pomaster.getUsers().getId());

            Postatus newPostatus = new Postatus(po,postatustype, true, pomaster.getUsers().getId(), new Date());
            po.getPostatus().add(newPostatus);

            po = purchaseOrderRepository.save(po);
        }

        return po;
    }
}
