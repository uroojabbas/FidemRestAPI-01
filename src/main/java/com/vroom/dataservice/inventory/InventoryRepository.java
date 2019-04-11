package com.vroom.dataservice.inventory;

import com.vroom.dataservice.Product.ProductInventory;
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

    @Query("SELECT i.product FROM Inventory i WHERE i.inventoryType = :inventoryTypeId")
    List<Product> findByInventoryType(@Param("inventoryTypeId") int  inventoryTypeId);

    @Query("SELECT i.product FROM Inventory i WHERE i.referenceType = :referenceId")
    List<Product> findByReference(@Param("referenceId") int  referenceId);

    @Query("SELECT i.product FROM Inventory i WHERE i.transactionType = :transactionTypeId")
    List<Product> findByTransactionType(@Param("transactionTypeId") int  transactionTypeId);

    @Query("SELECT i.product FROM Inventory i WHERE i.region = :region")
    List<Product> findByRegion(@Param("region") Region region);

    @Query("SELECT i.product FROM Inventory i WHERE i.transactionType = :transactionTypes")
    List<Product> findByTransactionTypes(@Param("transactionTypes") Set<TransactionType>  transactionTypes);

    @Query(value = "Select p.id as id,p.name as name, p.isbn as isbn, p.subject as subject,r.regionName as region " +
            ",it.name inventoryType, SUM(i.quantity) quantity, SUM(0) as transferQuantity From Inventory i " +
            "INNER JOIN Product p ON (i.productId = p.Id)  " +
            "INNER JOIN Region r ON (r.Id = i.regionId) " +
            "INNER JOIN Inventorytype it ON (it.Id = i.inventoryTypeId) " +
            "WHERE i.transactiontypeid > 0 " +
            "GROUP BY p.id,p.name,p.isbn,p.subject,r.regionName, it.name " +
            "HAVING SUM(i.quantity) > 0 " +
            "ORDER BY r.regionName, it.name, p.name", nativeQuery = true)
    List<ProductInventory> findAllInventoryProducts();
}
