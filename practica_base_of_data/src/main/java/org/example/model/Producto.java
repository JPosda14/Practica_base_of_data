package org.example.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private LocalDate fecha_registro;

    public Producto(String nombre, Double precio, LocalDate fecha_registro) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha_registro = fecha_registro;
    }
}
