/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Entidades.PiezaAutomotriz;
import java.util.ArrayList;

/**
 *
 * @author harol
 */
public class Compras extends Movimiento {
    
    private String fechaEntrega;

    public Compras() {
    }

    public Compras(String fechaEntrega, String nombrePersona, String numeroFactura, String fechaFactura, double precio, int cantidad, ArrayList<PiezaAutomotriz> piezas) {
        
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "Compras{" +
        "nombrePersona='" + getNombrePersona () + '\'' +
        ", numeroFactura='" + getNumeroFactura () + '\'' +
        ", fechaFactura='" + getFechaFactura () + '\'' +
        ", precio=" + getPrecio () +
        ", cantidad=" + getCantidad () +
        ", piezas=" + getPiezas () +
        ", fechaEntrega='" + this.fechaEntrega + '\'' +
        '}';
}
    @Override
    public double calcularPrecioFinal (boolean pagoInmediato) {
        double precio = getPrecio ();
        int cantidad = getCantidad ();
        double subtotal = precio * cantidad;
        
        System.out.printf ("El subtotal es: %.2f\n", subtotal);

        // Devolvemos el subtotal como el precio final, ya que las compras no tienen descuento
        return subtotal;
}

    public void setNombre(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setProveedor(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setEmpresa(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNit(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void SetTelefono(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
