package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region,Long> {
    @Query("SELECT r FROM Region r WHERE r.id <> 4 and (r.isdeleted = false OR r.isdeleted = 'false') ")
    List<Region> findAll();
    Region findByregionname(String regionName);
}
