package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "facturas")
public class Facturas {

    @Id
    private String consecutivoFactura = UUID.randomUUID().toString().substring(0,8);

    private LocalDate fecha;

    private String nombreCliente;

    private String nombreVendedor;

    private List productosComprados;

    private double costoTotal;

    private String descripcion;

    public String getConsecutivoFactura() {
        return consecutivoFactura;
    }

    public void setConsecutivoFactura(String consecutivoFactura) {
        this.consecutivoFactura = consecutivoFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public List getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(List productosComprados) {
        this.productosComprados = productosComprados;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //el precio individual estaria en productos comprados y
    //total a pagar lo calculamos en el front
}
