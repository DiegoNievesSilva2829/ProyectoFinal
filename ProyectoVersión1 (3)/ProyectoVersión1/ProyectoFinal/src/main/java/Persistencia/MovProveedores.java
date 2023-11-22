/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author elstr
 */

import Entidades.Movimiento;
import Entidades.Proveedor;
import Persistencia.IMovProveedores;
import Persistencia.IMovProveedores;
import java.util.ArrayList;
import java.util.List;

public class MovProveedores implements IMovProveedores {
    private List<Proveedor> ListaProveedores;
    
    public MovProveedores (){
        this.ListaProveedores = new ArrayList<>();
    }

    @Override
    public void agregarProveedor(Proveedor p) {
        this.ListaProveedores.add(p);
    }

    @Override
    public ArrayList<Proveedor> buscarProveedor(int nit) {
        ArrayList<Proveedor> lista = new ArrayList<>(this.ListaProveedores);
        return lista;
    }
    
    @Override
    public void eliminarProveedor(Proveedor p) {
        this.ListaProveedores.remove(p);
    }
    
    public MovProveedores(List<Proveedor> ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }

    public List<Proveedor> getListaProveedores() {
        return ListaProveedores;
    }

    public void setListaProveedores(List<Proveedor> ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }

    @Override
    public ArrayList<Movimiento> obtenerMovimiento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

