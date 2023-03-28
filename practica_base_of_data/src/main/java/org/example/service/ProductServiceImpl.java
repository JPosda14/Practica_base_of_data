package org.example.service;

import org.example.Repositorio.impl.Repositoryimpl;
import org.example.model.Producto;

import java.util.ArrayList;

public class ProductServiceImpl  implements ProductService {
    Repositoryimpl repository=new Repositoryimpl();


    @Override
    public void getlist() {
        System.out.println("------------LIST PRODUCTS------------");
        ArrayList<Producto> products=(ArrayList<Producto>) repository.list();
        System.out.println(products);
    }

    @Override
    public void getbyId(Long id) {
        System.out.println("------------GET PRODUCT BY ID------------");
        System.out.println(repository.byId(id));
    }

    @Override
    public void save(Object o) {
        System.out.println("------------SAVE PRODUCT------------");
        repository.save(o);
    }

    @Override
    public void delete(Long id) {
        System.out.println("------------DELETE PRODUCT------------");
        repository.delete(id);
    }

    @Override
    public void update(Long id,Object o) {
        System.out.println("------------UPDATE PRODUCT------------");
        repository.update(id,o);
    }
}
