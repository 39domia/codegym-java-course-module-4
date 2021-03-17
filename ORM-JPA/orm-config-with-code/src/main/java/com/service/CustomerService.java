package com.service;

import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements IBaseService<Customer> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> findAll() {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer order by id");
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }

    @Override
    public Customer findOne(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Customer> save(List<Customer> Ts) {
        return null;
    }

    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Integer> ids) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Customer customer = session.load(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
            System.out.println("detete success!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> t) {

    }

    @Override
    public void deleteAll() {

    }
}
