/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarcia.apirest.dao;

import com.agarcia.apirest.entity.Product;
import com.agarcia.apirest.entity.ProductCreate;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pacisauctor
 */
public interface ProductDAO {

    public List<Product> findAll();

    public Product findById(int id);

    @Transactional
    @Modifying
    public Product save(ProductCreate product);

    @Transactional
    @Modifying
    public Product save(ProductCreate productData, Product product);
    
    @Transactional
    @Modifying
    public void deleteById(int id);

}
