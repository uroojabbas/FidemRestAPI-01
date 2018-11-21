package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country,Long> {

    @Query("SELECT c FROM Country c WHERE (c.isdeleted = false OR c.isdeleted = 'false') ")
    List<Country> findAll();

    Country findById(int id);

    @Query("SELECT c FROM Country c WHERE c.country = :countryname and (c.isdeleted = false OR c.isdeleted = 'false') ")
    Country findByCountry(@Param("countryname") String countryname);
}