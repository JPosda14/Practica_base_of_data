package org.example.Repositorio.impl;

import org.example.ConnectionBD;
import org.example.Repositorio.Repository;
import org.example.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repositoryimpl implements Repository {
    private Connection getConnection() throws SQLException {
        return ConnectionBD.getInstance();
    }

    private Producto createProduct(ResultSet resultSet) throws SQLException {
        Producto product = new Producto();
        product.setId(resultSet.getInt("id"));
        product.setNombre(resultSet.getString("nombre"));
        product.setPrecio(resultSet.getDouble("precio"));
        product.setFecha_registro(resultSet.getDate("fecha_registro").toLocalDate());
        return product;
    }
    @Override
    public List<Producto> list() {
        List<Producto> products = new ArrayList<>();
        try (Statement statement=getConnection().createStatement();
             ResultSet resultSet=statement.executeQuery("SELECT * FROM productos")
        ){
            while (resultSet.next()) {
                Producto product = createProduct(resultSet);
                products.add(product);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public Producto byId(Long id) {
        Producto product = null;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("SELECT * FROM productos WHERE id =?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                product = createProduct(resultSet);
            }
            resultSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Object o) {
        Producto product = (Producto) o;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("INSERT INTO productos(nombre,precio,fecha_registro) VALUES (?,?,?)")){
            preparedStatement.setString(1,product.getNombre());
            preparedStatement.setLong(2,product.getPrecio().longValue());
            preparedStatement.setDate(3,Date.valueOf(product.getFecha_registro()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        Producto product = null;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("DELETE FROM productos WHERE id =?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Long id,Object o) {
        Producto product = (Producto) o;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("UPDATE productos SET nombre=? ,precio=?,fecha_registro=? where id=?")){
            preparedStatement.setString(1,product.getNombre());
            preparedStatement.setLong(2,product.getPrecio().longValue());
            preparedStatement.setDate(3, Date.valueOf(product.getFecha_registro()));
            preparedStatement.setLong(4,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
