/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author harol
 */
public class MovimientoConcreto extends Movimiento {
    // Aquí puedes implementar los métodos abstractos de Movimiento

    public MovimientoConcreto(String nombreComprador, int par, String id, double descuento, int par1, ArrayList<PiezaAutomotriz> pieza) {
    }

    public MovimientoConcreto(String nombrePersona, String numeroFactura, String fechaFactura, double precio, int cantidad, ArrayList<PiezaAutomotriz> piezas) {
       
    }


    @Override
    public String toString() {
        return "MovimientoConcreto{" +
        "nombrePersona='" + getNombrePersona () + '\'' +
        ", numeroFactura='" + getNumeroFactura () + '\'' +
        ", fechaFactura='" + getFechaFactura () + '\'' +
        ", precio=" + getPrecio () +
        ", cantidad=" + getCantidad () +
        ", piezas=" + getPiezas () +
        '}';
    }

    @Override
    public double calcularPrecioFinal (boolean pagoInmediato) {
        double precio = getPrecio ();
        int cantidad = getCantidad ();
        double subtotal = precio * cantidad;
        
        System.out.printf ("El subtotal es: %.2f\n", subtotal);

        // Devolvemos el subtotal como el precio final, ya que las compras no tienen descuento
        return subtotal;
}
}