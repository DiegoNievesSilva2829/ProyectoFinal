/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Ventas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentasController implements Initializable {
    @FXML
    private StackPane panelOpciones;
    @FXML
    private TableView<Ventas> tableVentas;
    @FXML
    private TableColumn<Ventas, Integer> colNoFactura;
    @FXML
    private TableColumn<Ventas, String> colNombre;
    @FXML
    private TableColumn<Ventas, LocalDate> colFecha;
    @FXML
    private TableColumn<Ventas, Producto> colProductoVendido;
    @FXML
    private TableColumn<Ventas, Integer> colCantidad;
    @FXML
    private TableColumn<Ventas, Double> colValorTotal;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colNoFactura.setCellValueFactory(new PropertyValueFactory<>("numeroFactura"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaActual"));
        this.colProductoVendido.setCellValueFactory(new PropertyValueFactory<>("producto"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        this.colValorTotal.setCellValueFactory(new PropertyValueFactory<>("precioUnidad"));

        cargarVentas();
    }

    private void cargarVentas() {
        ArrayList<Ventas> listaVentas = new ArrayList<>();
        String line;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("ventas.txt"));
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                Ventas venta = new Ventas();
                venta.setNumeroFactura(Integer.parseInt(fields[0]));
                venta.setNombre(fields[1]);
                if (fields[2] != null && !fields[2].isEmpty()) {
                    venta.setFechaActual(LocalDate.parse(fields[2]));
                } else {
                    // Manejar el caso cuando la fecha es null
                }
                venta.setCantidad(Integer.parseInt(fields[3]));
                venta.setPrecioUnidad(Double.parseDouble(fields[4]));
                // Aquí necesitas buscar el producto por su IDProducto
                Producto producto = buscarProductoPorIDProducto(Integer.parseInt(fields[5]));
                venta.setProducto(producto);
                listaVentas.add(venta);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObservableList<Ventas> listaObservable = FXCollections.observableArrayList(listaVentas);
        tableVentas.setItems(listaObservable);
    }

    private Producto buscarProductoPorIDProducto(int IDProducto) {
        ArrayList<Producto> listaProd = new ArrayList<>();
        String line;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("productos.txt"));
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                Producto producto = new Producto();
                producto.setNoProducto(Integer.parseInt(fields[0]));
                producto.setIDProducto(Integer.parseInt(fields[1]));
                producto.setNombreProducto(fields[2]);
                producto.setCantidad(Integer.parseInt(fields[3]));
                producto.setPrecio(Double.parseDouble(fields[4]));
                // Aquí necesitas buscar el proveedor por su NoProveedor
                Proveedor proveedor = buscarProveedorPorNoProveedor(Integer.parseInt(fields[5]));
                producto.setProveedor(proveedor);
                listaProd.add(producto);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Producto producto : listaProd) {
            if (producto.getIDProducto() == IDProducto) {
                return producto;
            }
        }
        return null;
    }

    private Proveedor buscarProveedorPorNoProveedor(int noProveedor) {
        ArrayList<Proveedor> listaProv = new ArrayList<>();
        String line;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("proveedores.txt"));
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                Proveedor proveedor = new Proveedor();
                proveedor.setNoProveedor(Integer.parseInt(fields[0]));
                proveedor.setNit(Integer.parseInt(fields[1]));
                proveedor.setEmpresa(fields[2]);
                proveedor.setTelefono(fields[3]);
                listaProv.add(proveedor);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Proveedor proveedor : listaProv) {
            if (proveedor.getNoProveedor() == noProveedor) {
                return proveedor;
            }
        }
        return null;
    }
}


