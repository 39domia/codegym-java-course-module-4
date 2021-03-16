package com.service;

import com.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService implements IBaseService<Customer> {
    List<Customer> customerList = new ArrayList<>();
    {
        customerList.add(new Customer(1, "A", "B", "C"));
        customerList.add(new Customer(2, "A2", "B-2", "C-2"));
        customerList.add(new Customer(3, "A3", "B-3", "C-3"));
        customerList.add(new Customer(4, "A4", "B-4", "C-4"));
        customerList.add(new Customer(5, "A5", "B5-", "C-5"));
        customerList.add(new Customer(6, "A6", "6B-", "C-6"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findOne(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer updating = findOne(customer.getId());
        if (updating != null) {
            updating.setName(customer.getName());
            updating.setEmail(customer.getEmail());
            updating.setAddress(customer.getAddress());
        }
        else {
            throw new RuntimeException("Khong tim thay khach hang");
        }
    }

    @Override
    public void delete(int id) {
        customerList.remove(findOne(id));
    }
}
