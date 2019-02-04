package com.vroom.dataservice.Product;

import com.vroom.dataservice.common.InventoryType;
import com.vroom.dataservice.common.Region;

public interface ProductInventory {

    public int getId();


    public String getName();


    public String getIsbn();


    public String getSubject();


    public Region getRegion();


    public InventoryType getInventoryType();

    public int getQuantity();

    public int getTransferQuantity();
}
