/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Ventas;
import java.io.*;
import java.net.URL;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;

public class NuevaVentaController implements Initializable {
    @FXML
    private StackPane panelOpciones;
    @FXML
    private TextField txtNombre;
    @FXML
    private DatePicker dtFechaActual;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtPrecioUnidad;
    @FXML
    private Button btnCancelarVenta;
    @FXML
    private Button btnRegistrarVenta;
    @FXML
    private ComboBox<Producto> cbProducto;
    @FXML
    private TextField txtNumeroFactura;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarProductos();
        cbProducto.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            if (newValue != null) {
//                txtNombre.setText(newValue.getNombreProducto());
                txtPrecioUnidad.setText(String.valueOf(newValue.getPrecio()));
            }
        });
    }

    @FXML
    private void onClickCancelar(ActionEvent event) {
        this.txtNombre.setText(null);
        this.dtFechaActual.setValue(null);
        this.txtCantidad.setText(null);
        this.txtPrecioUnidad.setText(null);
        this.cbProducto.getSelectionModel().clearSelection();
        this.txtNumeroFactura.setText(null);

        this.txtNombre.requestFocus();
    }

    @FXML
    private void onClickRegistrar(ActionEvent event) {
        try {
        // Verificar que todos los campos de texto estén llenos
        if (txtNumeroFactura.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty() ||
            txtCantidad.getText().trim().isEmpty() || txtPrecioUnidad.getText().trim().isEmpty() ||
            cbProducto.getSelectionModel().getSelectedItem() == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Campos vacíos", "Por favor, llene todos los campos para registrar la venta.");
            return;
        }

        Ventas v = new Ventas();
        try {
            v.setNumeroFactura(Integer.parseInt(txtNumeroFactura.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número factura", "Por favor, ingrese un número válido.");
            return;
        }
        v.setNombre(txtNombre.getText().trim());
        v.setFechaActual(dtFechaActual.getValue());
        try {
            v.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número de cantidad", "Por favor, ingrese un número válido.");
            return;
        }
        try {
            v.setPrecioUnidad(Double.parseDouble(txtPrecioUnidad.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número de precio c/u", "Por favor, ingrese un número válido.");
            return;
        }
        v.setProducto(cbProducto.getSelectionModel().getSelectedItem());

        // Guardar los datos en el archivo "ventas.txt"
        try (FileWriter writer = new FileWriter("ventas.txt", true)) {
            writer.write(v.toString() + "\n");
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Venta registrada", "La venta ha sido registrada con éxito.");
            limpiarCampos();
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al guardar los datos", e.getMessage());
        }
        
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error desconocido", e.getMessage());
        }
    }

    private void cargarProductos() {
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

        ObservableList<Producto> listaObservable = FXCollections.observableArrayList(listaProd);
        cbProducto.setItems(listaObservable);
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
    private void mostrarAlerta(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void limpiarCampos() {
        txtNumeroFactura.clear();
        txtNombre.clear();
        dtFechaActual.setValue(null);
        txtCantidad.clear();
        txtPrecioUnidad.clear();
        cbProducto.getSelectionModel().clearSelection();
        txtNombre.requestFocus();
    }
    
}

