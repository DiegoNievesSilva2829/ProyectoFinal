package Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.mycompany.proyectofinal.App;
import com.mycompany.proyectofinal.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
