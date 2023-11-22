/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Entidades.Administrador;
import Logica.Login;
import Logica.Utility;
import com.mycompany.proyectofinal.App;
import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author harol
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        this.txtUsername.setText(null);
        this.txtPassword.setText(null);
        this.txtUsername.requestFocus();
    }

    @FXML
    private void clickLogin(ActionEvent event) {
        
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();

        try {
            Login.validarLogin(username, password);
            App.newStage("principal", true, 1200, 800);

        } catch (IllegalStateException ie) {

            Utility.notificarMensaje("Validación de Ingreso", ie.getMessage(), Alert.AlertType.ERROR);

        } catch (Exception ie) {
            Utility.notificarMensaje("Validación de Login", ie.getMessage(), Alert.AlertType.ERROR);
        }

    }
    
    @FXML
    private void onKeyReleased(KeyEvent  event) {
        if (event.getCode() ==  KeyCode.ENTER) {
            clickLogin(null);
        }
    }
    
}
