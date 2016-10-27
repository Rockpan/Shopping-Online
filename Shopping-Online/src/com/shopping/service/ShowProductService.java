/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.service;

import com.shopping.dao.ShowProductDao;
import com.shopping.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ShowProductService {

    public List<Product> selectProdut(String category) {
        List<Product> product = null;
        if (category != null) {
            product = new ShowProductDao().selectProdut(category);
        }
        return product;
    }

}
