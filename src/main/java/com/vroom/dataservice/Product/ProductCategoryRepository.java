package com.vroom.dataservice.Product;

import com.vroom.dbmodel.orm.Productcategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<Productcategory,Long> {

    @Query("SELECT pc FROM Productcategory pc WHERE (pc.isdeleted = false OR pc.isdeleted = 'false') ")
    List<Productcategory> findAll();

    Productcategory findById(int id);


    @Query("SELECT pc FROM Productcategory pc WHERE pc.name=:name AND (pc.isdeleted = false OR pc.isdeleted = 'false') ")
    Productcategory findByName(@Param("name") String name);
}

