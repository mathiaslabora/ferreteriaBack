package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "volantes")
public class Volantes {
    @Id
    private String idProveedor = UUID.randomUUID().toString().substring(0,4);

    private String nombre;

    private List prodAIngresar;

    private LocalDate fecha;

    private String RUT;

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

    public List getProdAIngresar() {
        return prodAIngresar;
    }

    public void setProdAIngresar(List prodAIngresar) {
        this.prodAIngresar = prodAIngresar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }
}
