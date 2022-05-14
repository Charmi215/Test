/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javatpoint.test;
import com.javatpoint.model.Product;
import static org.junit.Assert.*;  
import com.javatpoint.service.ProductService;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author DELL
 */
public class TestLogic {
    @Autowired
    ProductService productService;
    @Test  
    public void testFindMax(){  
        Product product=new Product();
        assertNull(productService.addproduct(product));  
     
    }  
}
