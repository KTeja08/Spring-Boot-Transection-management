package com.pagingsorting.repository;

import com.pagingsorting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> 
{
	
}