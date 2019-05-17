package com.vroom.dataservice.inventory;

import com.vroom.dataservice.GoodsReceivedNote.GoodsReceivedNoteRepository;
import com.vroom.dataservice.GoodsReceivedNote.GoodsReceivedNoteService;
import com.vroom.dataservice.Product.ProductInventory;
import com.vroom.dataservice.Product.ProductRepository;
import com.vroom.dataservice.common.InventoryType;
import com.vroom.dataservice.common.ReferenceType;
import com.vroom.dataservice.common.Region;
import com.vroom.dataservice.po.POStatusType;
import com.vroom.dataservice.po.POStatusTypeRepository;
import com.vroom.dataservice.po.PurchaseOrderRepository;
import com.vroom.dbmodel.orm.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    InventoryRepository inventoryRepository;


    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    POStatusTypeRepository poStatusTypeRepository;

    @Autowired
    GoodsReceivedNoteRepository goodsReceivedNoteRepository;

    @Autowired
    GoodsReceivedNoteService goodsReceivedNoteService;

    public List<Podetail> save(int userId, List<Podetail> products){

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

            Grnmaster grnmaster = goodsReceivedNoteService.generateGRN(userId, pomaster, userId);

            products.forEach(podetail -> {

                Inventory inventory = addInventory(podetail.getProduct(),
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

                Grndetail grndetail = new Grndetail(grnmaster, podetail.getProduct(),
                podetail.getProduct().getQuantity(), (podetail.getProduct().getQuantity() *
                        podetail.getProduct().getProductcost()));
                grnmaster.getGrndetail().add(grndetail);
            } );

            goodsReceivedNoteRepository.save(grnmaster);
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

    public Inventory addInventory(Product product,
                                      Users user,
                                      TransactionType transactionType,
                                      int quantity){

        Inventory inventory = new Inventory();

        inventory.setReferenceType(ReferenceType.PURCHASE_ORDER);
        inventory.setInventoryType(InventoryType.FORSALE);
        inventory.setTransactionType(transactionType);
        inventory.setProduct(product);
        inventory.setQuantity(quantity);
        inventory.setRegion(Region.Head_Office);
        inventory.setInsertedByUserId(user.getId());
        inventory.setInsertedTime(new Date());

        return inventory;
    }

    public Inventory addInventory(Product product,
                                  Users user,
                                  TransactionType transactionType,
                                  ReferenceType referenceType,
                                  InventoryType inventoryType,
                                  Region region,
                                  int quantity){

        Inventory inventory = new Inventory();

        inventory.setReferenceType(referenceType);
        inventory.setInventoryType(inventoryType);
        inventory.setTransactionType(transactionType);
        inventory.setProduct(product);
        inventory.setQuantity(quantity);
        inventory.setRegion(region);
        inventory.setInsertedByUserId(user.getId());
        inventory.setInsertedTime(new Date());

        return inventory;
    }
    public Inventory addInventoryOnApprove(Product product,
                                      Users user,
                                      TransactionType transactionType,
                                      int quantity){

        Inventory inventory = this.addInventory(product,
                user,
                transactionType,
                quantity);

        return inventory;
    }

    public List<ProductInventory> getInventoryProducts(){
        return this.inventoryRepository.findAllInventoryProducts();
    }
}
