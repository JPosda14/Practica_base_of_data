package org.example.service;

public interface ProductService <T>{
    void getlist();
    void getbyId(Long id);
    void save(T t);
    void delete(Long id);
    void update(Long id,Object o);
}
