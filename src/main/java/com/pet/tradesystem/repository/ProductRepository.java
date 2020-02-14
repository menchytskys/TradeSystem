package com.pet.tradesystem.repository;

import com.pet.tradesystem.domain.Product;

import java.util.List;

public interface ProductRepository extends AppRepository<Product, Integer>  {

    List<Product> findAllByPage(int pageId, int total);

    Product findGoodByName(String name);

    boolean isExist(String name);

    int productCount();

}
