package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IBaseService<Customer>{
    private List<Customer> customerList;

    {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "A", "a@a.a", "Hue"));
        customerList.add(new Customer(2, "A", "a@a.a", "Hue"));
        customerList.add(new Customer(3, "A", "a@a.a", "Hue"));
        customerList.add(new Customer(4, "A", "a@a.a", "Hue"));
        customerList.add(new Customer(5, "A", "a@a.a", "Hue"));
        customerList.add(new Customer(6, "A", "a@a.a", "Hue"));
    }

    @Override
    public List<Customer> selectAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer updating = findById(customer.getId());
        if (updating == null)
            throw new RuntimeException("khong tim thay khach hang");

        updating.setEmail(customer.getEmail());
        updating.setAddress(customer.getAddress());
        updating.setName(customer.getName());
    }

    @Override
    public void delete(int id) {
        Customer customer = findById(id);
        customerList.remove(customer);
    }


}
