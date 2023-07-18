package com.excelr.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ecommerce.entity.UserData;

@Repository
public interface UserRepository extends CrudRepository<UserData, Integer>{

}
