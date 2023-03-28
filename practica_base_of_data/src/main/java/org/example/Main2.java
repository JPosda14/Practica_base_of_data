package org.example;

import org.example.model.Producto;
import org.example.service.ProductServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main2 {
    public static void main(String[] args) {
        try (Connection conn = ConnectionBD.getInstance()){
            ProductServiceImpl productService=new ProductServiceImpl();
            productService.getlist();
            productService.getbyId(1L);
            productService.delete(2L);
            productService.getlist();
            productService.save(new Producto("Pso",5000.0, LocalDate.of(2023,03,27)));
            productService.getlist();
            productService.update(1L,new Producto("embative",500.0, LocalDate.of(2023,03,27)));
            productService.getlist();
        }catch (SQLException e) {
            e.printStackTrace();//"hola"

        }
    }
}
