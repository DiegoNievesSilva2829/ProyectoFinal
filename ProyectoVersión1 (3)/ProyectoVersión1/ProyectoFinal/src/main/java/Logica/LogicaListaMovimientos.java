/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.IListasMovimientos;
import Entidades.Movimiento;
import java.util.List;
import Persistencia.*;

/**
 *
 * @author camar
 */
public class LogicaListaMovimientos {
    
    private IListasMovimientos data;
    
    public LogicaListaMovimientos (){
        this.data = new ListasMovimientos () {};
    }
    
    public void RegistrarListaMovimientos (Movimiento p){
        this.data.adicionarMovimiento(p); 
    }
    
    public List<Movimiento> ConsultarListaMovimiento(){
        return this.data.obtenerMovimiento();
    }
    
    public Movimiento BucarListaMovimiento (int noMovimiento){
            Movimiento p = this.data.buscarMovimiento(noMovimiento);
            return p;                 
    }

          
 }
