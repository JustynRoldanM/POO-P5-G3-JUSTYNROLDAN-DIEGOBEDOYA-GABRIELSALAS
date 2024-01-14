
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class ReservasCreadasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ImageView imgReservasCreadas;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarImagenes();
    }    
     public void agregarImagenes(){
        try {
            FileInputStream f = new FileInputStream("src/main/resources/images/tierra.jpg");
            Image img = new Image(f);
            imgReservasCreadas.setImage(img);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
