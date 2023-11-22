/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

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

public class ProveedorController implements Initializable {
    
    private ArrayList<Proveedor> listaProv;
    
    @FXML
    private StackPane panelOpciones;
    @FXML
    private TextField txtNit;
    @FXML
    private TextField txtEmpresa;
    @FXML
    private TextField txtNumeroTelefono;
    @FXML
    private TableView<Proveedor> tableProveedor;
    @FXML
    private TableColumn<Proveedor, Integer> colNoProveedor;
    @FXML
    private TableColumn<Proveedor, Integer> colNit;
    @FXML
    private TableColumn<Proveedor, String> colEmpresa;
    @FXML
    private TableColumn<Proveedor, String> coltelefono;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtNumeroProveedor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colNoProveedor.setCellValueFactory(new PropertyValueFactory<>("NoProveedor"));
        this.colNit.setCellValueFactory(new PropertyValueFactory<>("Nit"));
        this.colEmpresa.setCellValueFactory(new PropertyValueFactory<>("Empresa"));
        this.coltelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        // Leer los datos del archivo "proveedores.txt"
         listaProv = new ArrayList<>();
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

        // Actualizar la tabla
        actualizarTabla2(listaProv);
    }

    @FXML
    private void onClickGuardar(ActionEvent event) {
        try {
        // Verificar que todos los campos de texto estén llenos
        if (txtNumeroProveedor.getText().trim().isEmpty() || txtNit.getText().trim().isEmpty() ||
            txtEmpresa.getText().trim().isEmpty() || txtNumeroTelefono.getText().trim().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Campos vacíos", "Por favor, llene todos los campos para registrar el proveedor.");
            return;
        }

        Proveedor p = new Proveedor();
        try {
            p.setNoProveedor(Integer.parseInt(txtNumeroProveedor.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número de proveedor", "Por favor, ingrese un número válido.");
            return;
        }
        try {
            p.setNit(Integer.parseInt(txtNit.getText().trim()));
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error de formato de número de NIT", "Por favor, ingrese un número válido.");
            return;
        }
        p.setEmpresa(txtEmpresa.getText().trim());
        p.setTelefono(txtNumeroTelefono.getText().trim());

        // Guardar los datos en el archivo "proveedores.txt"
        try (FileWriter writer = new FileWriter("proveedores.txt", true)) {
            writer.write(p.getNoProveedor() + "," + p.getNit() + "," + p.getEmpresa() + "," + p.getTelefono() + "\n");
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Proveedor registrado", "El proveedor ha sido registrado con éxito.");
            limpiarCampos();
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al guardar los datos", e.getMessage());
        }

        // Actualizar la tabla
        listaProv.add(p);
        actualizarTabla2(listaProv);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error desconocido", e.getMessage());
        }
    }

    @FXML
    private void onClickBorrar(ActionEvent event) {
        limpiarCampos();
    }

    private void actualizarTabla2(ArrayList<Proveedor> listaProv) {
        ObservableList<Proveedor> listaObservable = FXCollections.observableArrayList(listaProv);
        tableProveedor.setItems(listaObservable);
    }
    
    private void mostrarAlerta(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void limpiarCampos() {
        txtNumeroProveedor.clear();
        txtNit.clear();
        txtEmpresa.clear();
        txtNumeroTelefono.clear();
        txtNumeroProveedor.requestFocus();
    }
}

