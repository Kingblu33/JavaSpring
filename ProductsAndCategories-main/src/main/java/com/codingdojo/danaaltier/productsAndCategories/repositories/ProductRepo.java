package com.codingdojo.danaaltier.productsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.danaaltier.productsAndCategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {

}