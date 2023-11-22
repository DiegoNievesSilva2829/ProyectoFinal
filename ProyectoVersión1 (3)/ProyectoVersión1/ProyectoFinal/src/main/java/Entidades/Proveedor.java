/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author elstr
 */
public class Proveedor {
    private int NoProveedor;
    private int nit;
    private String empresa;
    private String telefono;
    
    
    
     public int getNoProveedor() {
        return NoProveedor;
    }

    public void setNoProveedor(int NoProveedor) {
        this.NoProveedor = NoProveedor;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
 
    public String toString() {
        return this.getEmpresa(); 
    }
}
