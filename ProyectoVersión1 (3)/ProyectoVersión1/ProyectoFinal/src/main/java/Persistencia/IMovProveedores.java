/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author elstr
 */
    
package Persistencia;

import Entidades.Movimiento;
import Entidades.Proveedor;
import java.util.ArrayList;

public interface IMovProveedores {
    void agregarProveedor(Proveedor p);
    ArrayList<Proveedor> buscarProveedor(int nit);
    void eliminarProveedor(Proveedor p);

    public ArrayList<Movimiento> obtenerMovimiento();
}
