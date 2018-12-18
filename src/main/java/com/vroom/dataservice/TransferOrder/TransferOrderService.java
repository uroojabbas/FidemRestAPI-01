package com.vroom.dataservice.TransferOrder;

import com.vroom.dataservice.Product.ProductRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;
import com.vroom.dataservice.common.InventoryTransferType;
import com.vroom.dataservice.common.InventoryType;
import com.vroom.dataservice.common.ReferenceType;
import com.vroom.dataservice.common.Region;
import com.vroom.dataservice.inventory.InventoryService;
import com.vroom.dataservice.inventory.TransactionType;
import com.vroom.dataservice.po.POStatusType;
import com.vroom.dataservice.po.POStatusTypeRepository;
import com.vroom.dbmodel.orm.Tomaster;
import com.vroom.dbmodel.orm.Users;
import com.vroom.dbmodel.orm.Tostatus;
import com.vroom.dbmodel.orm.Todetail;
import com.vroom.dbmodel.orm.Product;
import com.vroom.dbmodel.orm.Inventory;
import com.vroom.dbmodel.orm.Postatustype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class TransferOrderService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    POStatusTypeRepository poStatusTypeRepository;

    @Autowired
    TransferOrderRepository transferOrderRepository;

    @Autowired
    InventoryService inventoryService;

    private static final Logger logger = LoggerFactory.getLogger(TransferOrderService.class);

    public Collection<Tomaster> getAll(){
        return transferOrderRepository.findAll();
    }

    public Tomaster save(Tomaster tomaster){

        int userId = tomaster.getUsers().getId();
        Users user = userRepository.findById(userId);
        tomaster.setUsers(user);
        tomaster.setTodetail(this.getToDetail(tomaster));
        tomaster.setTostatus(this.getToStatus(tomaster));
        tomaster.setIsdeleted(Boolean.FALSE);
        tomaster.setInsertedtime(new Date());
        return  this.transferOrderRepository.save(tomaster);
    }

    private Set<Todetail> getToDetail(Tomaster tomaster){

        Set<Todetail> toDetails = new HashSet<>(0);

        tomaster.getTodetail().forEach(tod -> {
            Todetail todetail = new Todetail();
            int productId = tod.getProduct().getId();
            Product product = productRepository.findById(productId);
            todetail.setToMaster(tomaster);
            todetail.setProduct(product);
            todetail.setQuantity(tod.getQuantity());
            toDetails.add(todetail);
        });
        return toDetails;
    }

    private Set<Tostatus> getToStatus(Tomaster tomaster){
        Postatustype postatustype  = this.poStatusTypeRepository.findById(POStatusType.PO_PENDING_APPROVAL.getValue());

        Tostatus tostatus = new Tostatus(tomaster,
                postatustype, true, tomaster.getUsers().getId(), new Date());

        Set<Tostatus> tostatuses = new HashSet<>(0);
        tostatuses.add(tostatus);
        return tostatuses;
    }

    public Tomaster approveTO(Tomaster tomaster){
        Postatustype tostatustype = poStatusTypeRepository.findById(POStatusType.PO_APPROVED.getValue());

        tomaster = this.changeTOStatus(tomaster, tostatustype);
        return this.transferOrderRepository.save(tomaster);
    }

    public Tomaster dispatchTO(Tomaster tomaster){
        Postatustype tostatustype = poStatusTypeRepository.findById(POStatusType.TO_INVENTORY_DISPATCHED.getValue());

        tomaster = this.changeTOStatus(tomaster, tostatustype);

        tomaster = this.generateInventoryOnDispatch(tomaster);

        return this.transferOrderRepository.save(tomaster);
    }

    public Tomaster inventoryReceived(Tomaster tomaster){
        Postatustype tostatustype = poStatusTypeRepository.findById(POStatusType.TO_INVENTORY_RECEIVED.getValue());

        tomaster = this.changeTOStatus(tomaster, tostatustype);

        tomaster = this.generateInventoryOnReceivedTO(tomaster);

        return this.transferOrderRepository.save(tomaster);
    }

    public Tomaster rejectTO(Tomaster tomaster){

        Postatustype postatustype = poStatusTypeRepository.findById(POStatusType.REJECTED.getValue());

        tomaster = this.changeTOStatus(tomaster, postatustype);

        return this.transferOrderRepository.save(tomaster);
    }

    public Tomaster cancelTO(Tomaster tomaster){

        Postatustype postatustype = poStatusTypeRepository.findById(POStatusType.CANCELLED.getValue());

        tomaster = this.changeTOStatus(tomaster, postatustype);

        return this.transferOrderRepository.save(tomaster);

    }

    private  Tomaster changeTOStatus(Tomaster tomaster, Postatustype tostatustype){
        Tomaster to = transferOrderRepository.findById(tomaster.getId());

        if((to.getTostatus() != null) && !(to.getTostatus().isEmpty())){
            Tostatus tostatus = to.getTostatus().iterator().next();
            tostatus.setIsactive(Boolean.FALSE);
            to.getTostatus().add(tostatus);
            to.setModifiedbyuserid(tomaster.getUsers().getId());

            Tostatus newTostatus = new Tostatus(to,tostatustype, true, to.getUsers().getId(), new Date());
            to.getTostatus().add(newTostatus);

        }

        return to;
    }

    private Tomaster generateInventoryOnDispatch(Tomaster tomaster){

        tomaster.getTodetail().forEach(todetail -> {
            Inventory inventory = this.inventoryService.addInventory(todetail.getProduct(),
                   tomaster.getUsers() ,
                    TransactionType.INVENTORY_TRANSFER_IN,
                    ReferenceType.TRANSFER,
                    this.getInventoryType(tomaster.getTransfertype()),
                    Region.Transit,
                    todetail.getQuantity()
                    );
            todetail.getProduct().getInventory().add(inventory);

            inventory = this.inventoryService.addInventory(todetail.getProduct(),
                    tomaster.getUsers() ,
                    TransactionType.INVENTORY_TRANSFER_OUT,
                    ReferenceType.TRANSFER,
                    this.getInventoryType(tomaster.getTransfertype()),
                    tomaster.getFromregion(),
                    -1 * todetail.getQuantity()
            );

            todetail.getProduct().getInventory().add(inventory);
        });

        return tomaster;
    }


    private Tomaster generateInventoryOnReceivedTO(Tomaster tomaster){

        tomaster.getTodetail().forEach(todetail -> {
            Inventory inventory = this.inventoryService.addInventory(todetail.getProduct(),
                    tomaster.getUsers() ,
                    TransactionType.INVENTORY_TRANSFER_OUT,
                    ReferenceType.TRANSFER,
                    this.getInventoryType(tomaster.getTransfertype()),
                    Region.Transit,
                    -1 * todetail.getQuantity()
            );
            todetail.getProduct().getInventory().add(inventory);

            inventory = this.inventoryService.addInventory(todetail.getProduct(),
                    tomaster.getUsers() ,
                    TransactionType.INVENTORY_TRANSFER_IN,
                    ReferenceType.TRANSFER,
                    this.getInventoryType(tomaster.getTransfertype()),
                    tomaster.getToregion(),
                    todetail.getQuantity()
            );

            todetail.getProduct().getInventory().add(inventory);
        });

        return tomaster;
    }

    private InventoryType getInventoryType(InventoryTransferType inventoryTransferType){
        return inventoryTransferType == InventoryTransferType.Region_Inventory_Transfer ?
                InventoryType.FORSALE : InventoryType.SAMPLE;
    }
}
