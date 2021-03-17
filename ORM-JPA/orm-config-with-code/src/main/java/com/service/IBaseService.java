package com.service;

import java.util.List;

public interface IBaseService<T> {
    public List<T> findAll();

    public T findOne(int id);

    public void save(T t);

    public List<T> save(List<T> Ts);

    public void update(T t);

    public boolean exists(int id);

    public List<T> findAll(List<Integer> ids);

    public int count();

    public void delete(int id) ;

    public void delete(T t) ;

    public void delete(List<T> t) ;

    public void deleteAll();
}
