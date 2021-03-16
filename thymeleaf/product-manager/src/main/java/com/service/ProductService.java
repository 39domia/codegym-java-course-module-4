package com.service;

import com.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IBaseService<Product> {
    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(0, "Banh my", 10000));
        productList.add(new Product(1, "khoai tay", 11000));
        productList.add(new Product(2, "my tom", 12000));
        productList.add(new Product(3, "may tinh", 13000));
        productList.add(new Product(4, "Banh my2", 14000));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findOne(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        Product product1 = findOne(product.getId());
        if (product1 != null) {
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
        }
        else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void delete(int id) {
        Product product1 = findOne(id);
        productList.remove(product1);
    }
}
