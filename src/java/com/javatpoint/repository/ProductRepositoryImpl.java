/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javatpoint.repository;
import com.javatpoint.model.Product;
import com.javatpoint.service.ProductService;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
/**
 *
 * @author DELL
 */
public class ProductRepositoryImpl implements ProductRepository  {
    
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public int addproduct(Product product) {
        Timestamp instant= Timestamp.from(Instant.now());
        Map<String,String> map=new HashMap<String,String>();
        KeyHolder key=new GeneratedKeyHolder();
        StringBuilder query=new StringBuilder();
        query.append("Insert into Product(name,description,tags,brand,category,created_at) ");
        query.append("values(:name,:description,:tags,:brand,:category,:created_at)");
        
        map.put(":name",product.getName());
        map.put(":description", product.getDescription());
        map.put(":tags",product.getTags().toString());
        map.put(":brand",product.getBrand());
        map.put(":category",product.getCategory());
        map.put(":created_at",instant.toString());
         SqlParameterSource map1=new MapSqlParameterSource().addValues(map);
        
        return jdbcTemplate.update(query.toString(), map1,key);
        
    }

    @Override
    public Product getProduct(int id) {
         Map<String,Integer> map=new HashMap<String,Integer>();
        StringBuilder query=new StringBuilder();
        query.append("Select * from Product where id=:id ");
          map.put(":id",id);
          
          Product product=new Product();
          product=jdbcTemplate.queryForObject(query.toString(), map,Product.class);
       
          return product;
        
    }

    @Override
    public List<Product> getCategory(String category) {
         Map<String,String> map=new HashMap<String,String>();
        StringBuilder query=new StringBuilder();
        query.append("Select * from Product where category=:category ");
          map.put(":category",category);
          List<Product> list=jdbcTemplate.queryForList(category, map, Product.class);
          return list;
    }
    
}
