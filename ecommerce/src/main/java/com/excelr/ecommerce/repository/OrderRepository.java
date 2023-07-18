package com.excelr.ecommerce.repository;
import java.sql.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.excelr.ecommerce.entity.OrderData;
@Repository
public interface OrderRepository extends 
CrudRepository<OrderData, Integer>{
	List<OrderData> findByOrderDateBetween(Date start, 
			Date end);
}
