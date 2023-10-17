package com.nttdata.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.crm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
