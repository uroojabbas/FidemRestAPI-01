package com.vroom.dataservice.Product;

import com.vroom.dataservice.common.Region;
import com.vroom.dbmodel.orm.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE (p.isdeleted = false) ")
    List<Product> findAll();

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
}