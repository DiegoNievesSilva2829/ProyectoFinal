/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

public class Ventas {
    private int NoProducto;
    private int numeroFactura;
    private String nombre;
    private LocalDate fechaActual;
    private int cantidad;
    private double precioUnidad;
    private Producto producto;
    
    
    public int getNoProducto() {
        return NoProducto;
    }

    public void setNoProducto(int NoProducto) {
        this.NoProducto = NoProducto;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return numeroFactura + "," + nombre + "," + fechaActual + "," + cantidad + "," + precioUnidad + "," + producto.getIDProducto();
    }
}