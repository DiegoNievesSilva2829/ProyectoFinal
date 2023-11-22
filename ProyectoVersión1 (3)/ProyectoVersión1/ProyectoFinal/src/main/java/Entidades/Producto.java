/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author harol
 */
public class Producto {
    private int NoProducto;
    private int IDProducto;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private Proveedor proveedor;
    
     public int getNoProducto() {
        return NoProducto;
    }
    
     public void setNoProducto(int NoProducto) {
        this.NoProducto = NoProducto;
    }
    
    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return  nombreProducto ;
    }
    
    public String toStingtosave() {
        return IDProducto + "," + nombreProducto + "," + cantidad + "," + precio + "," + proveedor.getNoProveedor();
    }
}
