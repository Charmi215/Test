/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javatpoint.service;

import com.javatpoint.model.Product;
import com.javatpoint.repository.ProductRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    
    @Override
    public Product addproduct(Product product) {
        Product products=null;
        try {
            int id= productRepository.addproduct(product);
            products= productRepository.getProduct(id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public List<Product> getCategory(String category) {
        List<Product> products=null;
        try {
            products= productRepository.getCategory(category);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
}
