/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javatpoint.service;
import com.javatpoint.model.Product;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ProductService {
    
     public Product addproduct(Product product);
     
    public List<Product> getCategory(String category);
 
}
