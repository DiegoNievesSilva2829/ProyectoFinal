/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Compras;
import Entidades.PiezaAutomotriz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harol
 */
public class InventarioAutomotriz implements IInventarioAutomotriz {
    private List<PiezaAutomotriz> ListaPiezaAutomotriz;
    
    public InventarioAutomotriz (){
        this.ListaPiezaAutomotriz = new ArrayList () ;
    }

    @Override
    public void agregarPiezaAutomotriz(PiezaAutomotriz p) {
        this.ListaPiezaAutomotriz.add(p);
    }

    @Override
    public ArrayList<PiezaAutomotriz> buscarPiezaAutomotriz(int id) {
        ArrayList<PiezaAutomotriz> lista = new ArrayList(this.ListaPiezaAutomotriz);
        return lista;
    }
    
    @Override
    public void eliminarPiezaAutomotriz(PiezaAutomotriz p) {
        this.ListaPiezaAutomotriz.remove(p);
    }
    
    public InventarioAutomotriz(List<PiezaAutomotriz> ListaPiezaAutomotriz) {
        this.ListaPiezaAutomotriz = ListaPiezaAutomotriz;
    }

    public List<PiezaAutomotriz> getListaPiezaAutomotriz() {
        return ListaPiezaAutomotriz;
    }

    public void setListaPiezaAutomotriz(List<PiezaAutomotriz> ListaPiezaAutomotriz) {
        this.ListaPiezaAutomotriz = ListaPiezaAutomotriz;
    }

    @Override
    public void agregarPiezaAutomotriz(Compras p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


  
    
    
    
}