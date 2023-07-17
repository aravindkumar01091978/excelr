package com.excelr.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ecommerce.entity.OrderData;

@Repository
public interface OrderRepository extends 
CrudRepository<OrderData, Integer>{

}
