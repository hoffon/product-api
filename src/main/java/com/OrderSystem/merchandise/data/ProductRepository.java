package com.OrderSystem.merchandise.data;

import com.OrderSystem.merchandise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends
        JpaRepository<Product,Integer> {
//    List<Product> findByCustomerId(int customerId);
}

