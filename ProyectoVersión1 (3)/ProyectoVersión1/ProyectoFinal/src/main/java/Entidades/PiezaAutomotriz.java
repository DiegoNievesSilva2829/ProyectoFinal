/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author harol
 */
public abstract  class PiezaAutomotriz {
    
    private int id;
    private String nombre;
    private int cantidad;
    private int precio;
    private String Proveedor;

    public PiezaAutomotriz () {
    }

    public PiezaAutomotriz(int id, String nombre,String Proveedor, int cantidad, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getProveedor() {
           return Proveedor;
       }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }
    
    public void setId(int id) {
        this.id = id;
    }
 
    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public abstract String toString();
    

}
