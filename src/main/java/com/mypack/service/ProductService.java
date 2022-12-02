package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Product;
import com.mypack.util.SoutError;

import java.util.List;

public class ProductService {
    BaseDAOImpl<Product> useDao = new BaseDAOImpl<>(Product.class);

    public List<Product> getAllProductsCustomer(String reference) {
        CustomerService customerService = new CustomerService();
        int customer_id = customerService.getCustomerId(reference);
        try {
            return useDao.getAllWhere("customer_id", customer_id);
        }catch (Exception e)
        {
            SoutError.print("orange", "errorGetAllProductsCustomer : " + e.getMessage());
            return null;
        }
    }

    public List<Product> getProductByReference(String reference) {
        try {
            return useDao.getAllWhere("reference", reference);
        } catch (Exception e) {
            SoutError.print("orange","errrorGetProductByTrackingId : " + e.getMessage());
            return null;
        }
    }
}