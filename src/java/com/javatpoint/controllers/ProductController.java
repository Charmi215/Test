/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javatpoint.controllers;

import com.javatpoint.model.Product;
import com.javatpoint.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jabvatPoint.error.CategoryNotFoundException;
/**
 *
 * @author DELL
 */
@RestController
public class ProductController {
    
   @Autowired
   ProductService ProductService;
    
   @RequestMapping(value = "v1/products", method = RequestMethod.POST, headers = "Accept=application/json")
    public Product addCountry(@RequestBody Product product) {
        return ProductService.addproduct(product);
        
    }
    
    @RequestMapping(value = "v1/product/{category}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getCategoryId(@PathVariable String category) {
        return ProductService.getCategory(category) throws new CategoryNotFoundException(category));
    }
    
}
