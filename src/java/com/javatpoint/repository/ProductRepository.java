/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javatpoint.repository;

import com.javatpoint.model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author DELL
 */
public interface ProductRepository  {
    
    public int addproduct(Product product) throws SQLException,IOException;
    
    public Product getProduct(int id) throws SQLException,IOException;
    
      public List<Product> getCategory(String category) throws SQLException,IOException;
    
}
