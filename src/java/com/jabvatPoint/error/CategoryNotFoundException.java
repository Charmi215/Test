/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jabvatPoint.error;

/**
 *
 * @author DELL
 */
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String Category) {
        super("Category id not found : " + Category);
    }

}