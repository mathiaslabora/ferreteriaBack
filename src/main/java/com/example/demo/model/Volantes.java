package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "volantes")
public class Volantes {
    @Id
    private String idProveedor = UUID.randomUUID().toString();

    private String nombre;

    private String prodAIngresar;

    private LocalDate fecha;

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProdAIngresar() {
        return prodAIngresar;
    }

    public void setProdAIngresar(String prodAIngresar) {
        this.prodAIngresar = prodAIngresar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
