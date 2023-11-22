/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.IInventarioAutomotriz;
import Persistencia.InventarioAutomotriz;
import Entidades.PiezaAutomotriz;
import java.util.List;
import Persistencia.*;

public class LogicaInventarioAutomotriz {
    
    private IInventarioAutomotriz data;

    public LogicaInventarioAutomotriz() {
        this.data = new InventarioAutomotriz();
    }
    
    public void agregarPiezaAutomotriz(PiezaAutomotriz p){
       this.data.agregarPiezaAutomotriz(p);
    }
    
    public List<PiezaAutomotriz> buscarPiezaAutomotriz(int id){
        return this.data.buscarPiezaAutomotriz(id);
    }
    
    public void eliminarPiezaAutomotriz(PiezaAutomotriz p){
         this.data.eliminarPiezaAutomotriz(p);
    }
}
