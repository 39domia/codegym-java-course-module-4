package com.service;

import com.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    List<Customer> customerList = new ArrayList<>();
    {
        customerList.add(new Customer( 1, "A", "B", "C"));
        customerList.add(new Customer( 2, "A", "B", "C"));
        customerList.add(new Customer( 3, "A", "B", "C"));
        customerList.add(new Customer( 4, "A", "B", "C"));
        customerList.add(new Customer( 5, "A", "B", "C"));
    }

    public Customer findOne(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> findAll(){
        return customerList;
    }

    public void add(Customer customer) {
        customerList.add(customer);
    }

    public void update(Customer customer){
        Customer updating = findOne(customer.getId());
        if (updating == null)
            throw new RuntimeException("khong tim thay khach hang");
        updating.setEmail(customer.getEmail());
        updating.setAddress(customer.getAddress());
        updating.setName(customer.getName());
    }

    public void delete(int id) {
        Customer customer = findOne(id);
        customerList.remove(customer);
    }

}
