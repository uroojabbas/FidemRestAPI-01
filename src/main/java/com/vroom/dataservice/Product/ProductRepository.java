package com.vroom.dataservice.Product;

import com.vroom.dataservice.common.Region;
import com.vroom.dbmodel.orm.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product,Long> {


    @Query("SELECT p.id as id,p.name as name, p.isbn as isbn, p.subject as subject," +
            " 0 as quantity, p.publisher as publisher, p.author as author," +
            " p.language.language as languagename " +
            " FROM Product p WHERE p.isdeleted = false")
    List<AbstractProduct> findAllProducts();

    @Query("SELECT p FROM Product p WHERE p.name = :name AND (p.isdeleted = false) ")
    List<Product> findByName(@Param("name") String  name);

    @Query("SELECT p FROM Product p WHERE p.id = :id AND (p.isdeleted = false) ")
    Product findById(@Param("id") int  id);

    @Query("SELECT p FROM Product p WHERE p.isbn = :isbn AND (p.isdeleted = false) ")
    Product findByISBN(@Param("isbn") int  isbn);

    @Query("SELECT p FROM Product p WHERE p.vendor.id = :vendorId AND (p.isdeleted = false) ")
    List<Product> findByVendorId(@Param("vendorId") int  vendorId);

    @Query("SELECT i.product FROM Inventory i WHERE i.region = :region " +
            "AND (i.product.isdeleted = false) ")
    Set<Product> findByRegion(@Param("region") Region region);

    @Query(value = "Select p.id as id,p.name as name, p.isbn as isbn, p.subject as subject,r.regionName as region " +
            ",it.name inventoryType, SUM(i.quantity) quantity, SUM(0) as transferQuantity From Inventory i " +
            "INNER JOIN Product p ON (i.productId = p.Id)  " +
            "INNER JOIN Region r ON (r.Id = i.regionId) " +
            "INNER JOIN Inventorytype it ON (it.Id = i.inventoryTypeId) " +
            "WHERE i.regionId = :region AND i.transactiontypeid > 0 " +
            "GROUP BY p.id,p.name,p.isbn,p.subject,r.regionName, it.name " +
            "HAVING SUM(i.quantity) > 0 " +
            "ORDER BY r.regionName, it.name, p.name", nativeQuery = true)
    public Set<ProductInventory> findProductByRegion(@Param("region") Region region);
}
