package com.vroom.dataservice.Product;

import com.vroom.dataservice.common.InventoryType;
import com.vroom.dataservice.common.Region;

public interface ProductInventory extends  AbstractProduct{

    public Region getRegion();


    public InventoryType getInventoryType();

    public int getQuantity();

    public int getTransferQuantity();
}
