package Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.mycompany.proyectofinal.App;


public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}