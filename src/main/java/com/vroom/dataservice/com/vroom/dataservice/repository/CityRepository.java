package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City,Long> {

    List<City> findAll();
}
