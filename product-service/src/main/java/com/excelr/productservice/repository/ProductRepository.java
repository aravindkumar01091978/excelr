package com.excelr.productservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excelr.productservice.entity.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByCategory(String category);
}
