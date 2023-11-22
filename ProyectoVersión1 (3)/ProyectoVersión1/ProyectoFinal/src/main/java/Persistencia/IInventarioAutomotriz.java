/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Compras;
import Entidades.PiezaAutomotriz;
import java.util.ArrayList;
/**
 *
 * @author camar
 */
public interface IInventarioAutomotriz {
    
    public void agregarPiezaAutomotriz(PiezaAutomotriz p);
    public ArrayList<PiezaAutomotriz> buscarPiezaAutomotriz(int id);
    public void eliminarPiezaAutomotriz(PiezaAutomotriz p);

    public void agregarPiezaAutomotriz(Compras p);

}
    

