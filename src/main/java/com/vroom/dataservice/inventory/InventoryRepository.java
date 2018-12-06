package com.vroom.dataservice.inventory;

import com.vroom.dataservice.common.Region;
import com.vroom.dbmodel.orm.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface InventoryRepository extends CrudRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE (p.isdeleted = false) ")
    List<Product> findAll();

    @Query("SELECT p FROM Product p WHERE p.id = :id AND (p.isdeleted = false)")
    Product findById(@Param("id") int  id);

    @Query("SELECT i.product FROM Inventory i WHERE i.inventoryTypeId = :inventoryTypeId")
    List<Product> findByInventoryType(@Param("inventoryTypeId") int  inventoryTypeId);

    @Query("SELECT i.product FROM Inventory i WHERE i.activityTypeId = :activityTypeId")
    List<Product> findByActivityType(@Param("activityTypeId") int  activityTypeId);

    @Query("SELECT i.product FROM Inventory i WHERE i.transactionType = :transactionTypeId")
    List<Product> findByTransactionType(@Param("transactionTypeId") int  transactionTypeId);

    @Query("SELECT i.product FROM Inventory i WHERE i.regionId = :region")
    List<Product> findByRegion(@Param("region") Region region);

    @Query("SELECT i.product FROM Inventory i WHERE i.transactionType = :transactionTypes")
    List<Product> findByTransactionTypes(@Param("transactionTypes") Set<TransactionType>  transactionTypes);

}
