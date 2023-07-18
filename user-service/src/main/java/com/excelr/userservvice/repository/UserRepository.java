package com.excelr.userservvice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excelr.userservvice.entity.UserData;



@Repository
public interface UserRepository extends CrudRepository<UserData, Integer>{

}
