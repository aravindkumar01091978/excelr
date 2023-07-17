package com.excelr.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByCategory(String category);
}
