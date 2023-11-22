/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Movimiento;
import Entidades.PiezaAutomotriz;
import Entidades.Ventas;
import java.util.ArrayList;

/**
 *
 * @author camar
 */
public interface IListasMovimientos {
    
    public void adicionarMovimiento(Movimiento p);
    public ArrayList<Movimiento> obtenerMovimiento();
    public Movimiento buscarMovimiento(int noMovimiento);

    public void agregarPiezaAutomotriz(PiezaAutomotriz p);
    
}
