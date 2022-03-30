package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "facturas")
public class Facturas {

    @Id
    private String ConsecutivoFactura = UUID.randomUUID().toString();

    private LocalDate fecha;

    private String nombreCliente;

    private String nombreVendedor;

    private String productosComprados;

    public String getConsecutivoFactura() {
        return ConsecutivoFactura;
    }

    public void setConsecutivoFactura(String consecutivoFactura) {
        ConsecutivoFactura = consecutivoFactura;
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

    public String getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(String productosComprados) {
        this.productosComprados = productosComprados;
    }



    //el precio individual estaria en productos comprados y
    //total a pagar lo calculamos en el front
}
