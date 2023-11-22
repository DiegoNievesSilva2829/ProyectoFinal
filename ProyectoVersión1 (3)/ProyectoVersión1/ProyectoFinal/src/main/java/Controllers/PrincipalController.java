/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import com.mycompany.proyectofinal.App;
import Logica.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author harol
 */
public class PrincipalController implements Initializable {

    @FXML
    private Label btnNuevaVenta;
    @FXML
    private Label btnClientes;
    @FXML
    private Label Proveedor;
    @FXML
    private Label Producto;
    @FXML
    private Label Ventas;
    @FXML
    private Label lbUsuario;
    @FXML
    private StackPane panelOpciones;

  
    @FXML
    private void clickNuevaVenta(MouseEvent event) throws IOException {
        
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("nuevaventa"));
        this.panelOpciones.getChildren().add(pane);
        
    }

    @FXML
    private void clickProveedor(MouseEvent event) throws IOException {
        
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("proveedor"));
        this.panelOpciones.getChildren().add(pane);
    }

    @FXML
    private void clickProducto(MouseEvent event) throws IOException {
        
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("producto"));
        this.panelOpciones.getChildren().add(pane);
    }

    @FXML
    private void clickVentas(MouseEvent event) throws IOException {
        
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("ventas"));
        this.panelOpciones.getChildren().add(pane);
        
    }
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.lbUsuario.setText(Login.getUsuarioLogeado().getNombre() + " " + Login.getUsuarioLogeado().getApellido());
    }    
    
}
