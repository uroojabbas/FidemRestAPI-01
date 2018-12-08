package com.vroom.dataservice.inventory;

import com.vroom.dataservice.com.vroom.dataservice.repository.ProductRepository;
import com.vroom.dataservice.common.InventoryType;
import com.vroom.dataservice.common.ReferenceType;
import com.vroom.dataservice.common.Region;
import com.vroom.dataservice.po.POStatusType;
import com.vroom.dataservice.po.POStatusTypeRepository;
import com.vroom.dataservice.po.PurchaseOrderRepository;
import com.vroom.dbmodel.orm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;


    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    POStatusTypeRepository poStatusTypeRepository;

    public List<Podetail> save(List<Podetail> products){

        if(products != null && !(products.isEmpty())) {
            Pomaster pomaster = purchaseOrderRepository.findByPODetailId(products.get(0).getId());

            boolean isPartialPO = this.isPartialReceived(products);

            //if partial PO received then change status to
            // Partial Inventory Received otherwise
            // Complete Inventory Received

            POStatusType poStatusType = (isPartialPO) ? POStatusType.PARTIAL_INVENTORY_RECEIVED
                    : POStatusType.COMPLETE_INVENTORY_RECEIVED;

            //Getting PO Status
            Postatustype postatustype  = this.poStatusTypeRepository.findById(poStatusType.getValue());

            //deactivating old statues
            pomaster.getPostatus().forEach(postatus -> postatus.setIsactive(Boolean.FALSE));


            Postatus postatus = new Postatus(pomaster,
                    postatustype, true, pomaster.getUsers().getId(), new Date());

            //adding new status
            pomaster.getPostatus().add(postatus);


            products.forEach(podetail -> {

                Inventory inventory = addInventory(podetail,
                        pomaster.getUsers(),
                        TransactionType.INVENTORY_ADDITION,
                        podetail.getProduct().getQuantity());

                Optional<Podetail> optional = pomaster.getPodetail().stream().
                        filter(pd -> pd.getProduct().getId() == podetail.getProduct().getId())
                        .findFirst();

                if(optional.isPresent()) {//Check whether optional has element you are looking for
                    Podetail p = optional.get();//get it from optional
                    p.getProduct().getInventory().add(inventory);
                }

            });

            purchaseOrderRepository.save(pomaster);
        }
        return products;
    }

    private boolean isPartialReceived(List<Podetail> products){

        boolean isPartialPO = false;

        int actualQuantity = products.stream().
                        mapToInt(Podetail::getQuantity).sum();

        int receivedQuantity = products.stream().
                mapToInt(podetail -> (podetail.getProduct().getQuantity()
                        + podetail.getProduct().getTotalLtdQuantity())).sum();

        return (receivedQuantity < actualQuantity);
    }

    public Inventory addInventory(Podetail podetail,
                                      Users user,
                                      TransactionType transactionType,
                                      int quantity){

        Inventory inventory = new Inventory();

        inventory.setReferenceType(ReferenceType.PURCHASE_ORDER);
        inventory.setInventoryType(InventoryType.FORSALE);
        inventory.setTransactionType(transactionType);
        inventory.setProduct(podetail.getProduct());
        inventory.setQuantity(quantity);
        inventory.setRegion(Region.Head_Office);
        inventory.setInsertedByUserId(user.getId());
        inventory.setInsertedTime(new Date());

        return inventory;
    }

    public void addInventoryOnApprove(Podetail podetail,
                                      Users user,
                                      TransactionType transactionType,
                                      int quantity){

        Inventory inventory = this.addInventory(podetail,
                user,
                transactionType,
                quantity);

        podetail.getProduct().getInventory().add(inventory);
    }
}
