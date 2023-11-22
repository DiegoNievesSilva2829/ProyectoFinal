/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Entidades.Producto;
import Entidades.Proveedor;
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
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoController implements Initializable {
    @FXML
    private StackPane panelOpciones;
    @FXML
    private TextField txtIDProducto;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TableView<Producto> tableProducto;
    @FXML
    private TableColumn<Producto, Integer> colNoProducto;
    @FXML
    private TableColumn<Producto, Integer> colID;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, Proveedor> colProveedor;
    @FXML
    private TableColumn<Producto, Integer> colCantidad;
    @FXML
    private TableColumn<Producto, Double> colPrecio;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNoProducto;
    @FXML
    private ComboBox<Proveedor> cmbProveedor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colNoProducto.setCellValueFactory(new PropertyValueFactory<>("NoProducto"));
        this.colID.setCellValueFactory(new PropertyValueFactory<>("IDProducto"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        this.colProveedor.setCellValueFactory(new PropertyValueFactory<>("Proveedor"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));

        cargarProveedores();
        cargarProductos();
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
        tableProducto.setItems(listaObservable);
    }

    private Proveedor buscarProveedorPorNoProveedor(int noProveedor) {
        for (Proveedor proveedor : cmbProveedor.getItems()) {
            if (proveedor.getNoProveedor() == noProveedor) {
                return proveedor;
            }
        }
        return null;
    }

    @FXML
    private void clickGuardar(ActionEvent event) {
        try {
        // Verificar que todos los campos de texto estén llenos
        if (txtNoProducto.getText().trim().isEmpty() || txtIDProducto.getText().trim().isEmpty() ||
            txtNombreProducto.getText().trim().isEmpty() || txtCantidad.getText().trim().isEmpty() ||
            txtPrecio.getText().trim().isEmpty() || cmbProveedor.getSelectionModel().getSelectedItem() == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Campos vacíos", "Por favor, llene todos los campos para registrar el producto.");
            return;
        }

        Producto p = new Producto();
        try {
            p.setNoProducto(Integer.parseInt(txtNoProducto.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número de producto", "Por favor, ingrese un número válido.");
            return;
        }
        try {
            p.setIDProducto(Integer.parseInt(txtIDProducto.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número ID de producto", "Por favor, ingrese un número válido.");
            return;
        }
        p.setNombreProducto(txtNombreProducto.getText().trim());
        try {
            p.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número de cantidad", "Por favor, ingrese un número válido.");
            return;
        }
        try {
            p.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato del campo precio", "Por favor, ingrese un número válido.");
            return;
        }
        Proveedor proveedor = cmbProveedor.getSelectionModel().getSelectedItem();
        if (proveedor == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Proveedor no seleccionado", "Por favor, seleccione un proveedor.");
            return;
        }
        p.setProveedor(proveedor);

        // Guardar los datos en el archivo "productos.txt"
        try (FileWriter writer = new FileWriter("productos.txt", true)) {
            writer.write(p.getNoProducto()+ "," +p.getIDProducto() + "," + p.getNombreProducto() + "," + p.getCantidad() + "," + p.getPrecio() + "," + p.getProveedor().getNoProveedor() + "\n");
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Producto registrado", "El producto ha sido registrado con éxito.");
            limpiarCampos();
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al guardar los datos", e.getMessage());
        }

        cargarProductos();
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error desconocido", e.getMessage());
        }
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        limpiarCampos();
    }

    private void cargarProveedores() {
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

        ObservableList<Proveedor> listaObservable = FXCollections.observableArrayList(listaProv);
        cmbProveedor.setItems(listaObservable);
    }

    private void actualizarTabla(ArrayList<Producto> listaProd) {
        ObservableList<Producto> listaObservable = FXCollections.observableArrayList(listaProd);
        tableProducto.setItems(listaObservable);
    }
    
    private void mostrarAlerta(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void limpiarCampos() {
        txtNoProducto.clear();
        txtIDProducto.clear();
        txtNombreProducto.clear();
        txtCantidad.clear();
        txtPrecio.clear();
        cmbProveedor.getSelectionModel().clearSelection();
        txtNoProducto.requestFocus();
    }
}

