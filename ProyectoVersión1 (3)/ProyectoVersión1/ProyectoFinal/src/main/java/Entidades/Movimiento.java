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
public abstract class Movimiento {
    
    private String nombrePersona;
    private String numeroFactura;
    private String fechaFactura;
    private double precio;
    private int cantidad;
    private double total;
    private ArrayList<PiezaAutomotriz> piezas;
    private int Nit;
    private String Empresa;
    private String Telefono;

    public Movimiento() {
    }

    public Movimiento(String Telefono,String Empresa,int Nit,String nombrePersona, String numeroFactura, String fechaFactura, double precio, int cantidad, ArrayList<PiezaAutomotriz> piezas) {
        this.nombrePersona = nombrePersona;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.precio = precio;
        this.cantidad = cantidad;
        this.piezas = piezas;
        this.Nit =Nit;
        this.Empresa =Empresa;
        this.Telefono =Telefono;
    }
      public String getTelefono() {
        return Telefono;
    }
      public int getNit() {
        return Nit;
    }
       public String getEmpresa() {
        return Empresa;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }
    public String SetTelefono() {
            return Telefono;
    }
     public int setNit() {
        return Nit;
    }
      public double getPrecio() {
        return precio;
    }
    
    public String setEmpresa() {
        return Empresa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<PiezaAutomotriz> getPiezas() {
        return piezas;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPiezas(ArrayList<PiezaAutomotriz> piezas) {
        this.piezas = piezas;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getTotal() {
        return this.total;
    }

    @Override
    public abstract String toString();
    
    public abstract double calcularPrecioFinal (boolean pagoInmediato);

    public int getConsecutivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

      
}
