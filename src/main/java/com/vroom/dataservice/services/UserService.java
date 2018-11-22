package com.vroom.dataservice.services;

import com.vroom.dataservice.com.vroom.dataservice.repository.DepartmentRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.DesignationRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;
import com.vroom.dbmodel.orm.Department;
import com.vroom.dbmodel.orm.Designation;
import com.vroom.dbmodel.orm.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DesignationRepository designationRepository;

    public Users save(Users user){
        logger.debug("save : " + user.toString());

        String departmentName = user.getDepartmentname();
        String designationName = user.getDesignationname();

        Department department = departmentRepository.findByName(departmentName);
        Designation designation = designationRepository.findByName(designationName);

        user.setDepartment(department);
        user.setDesignation(designation);
        user.setIsdeleted(Boolean.FALSE);
       return this.userRepository.save(user);
    }
}
