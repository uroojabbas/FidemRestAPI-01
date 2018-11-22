package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    @Query("SELECT d FROM Department d WHERE (d.isdeleted = false) ")
    List<Department> findAll();

    @Query("SELECT d FROM Department d WHERE d.name = :name AND (d.isdeleted = false) ")
    Department findByName(@Param("name") String  name);
}
