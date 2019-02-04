package com.vroom.dataservice.inventory;

import com.vroom.dbmodel.orm.Podetail;

import java.util.List;

public class InventoryRequest {
    private int userId;
    private List<Podetail> products;

    public int getUserId(){
        return this.userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
    public List<Podetail> getProducts(){
        return this.products;
    }

    public void setProducts(List<Podetail> products){
        this.products = products;
    }
}
