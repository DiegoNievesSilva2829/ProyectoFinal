/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Entidades.Movimiento;
import Entidades.PiezaAutomotriz;
import Entidades.Ventas;
import Persistencia.IListasMovimientos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harol
 */
public class ListasMovimientos implements IListasMovimientos {
    
    private String archivo;

    public ListasMovimientos() {
        archivo = "movimiento.csv";
    }

    @Override
    public void adicionarMovimiento(Movimiento p) {
        guardarEnArchivo(p);
    }



    @Override
    public Movimiento buscarMovimiento(int noMovimiento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void guardarEnArchivo(Movimiento movimiento) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
            escritor.write(movimiento.toString());
            escritor.newLine();
            System.out.println("Lista de personas guardada exitosamente en " + archivo);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
    

    @Override
    public void agregarPiezaAutomotriz(PiezaAutomotriz p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Movimiento> obtenerMovimiento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
