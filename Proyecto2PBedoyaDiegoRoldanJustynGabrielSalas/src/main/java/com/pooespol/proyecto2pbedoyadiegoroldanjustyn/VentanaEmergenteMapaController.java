
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Promocion;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class VentanaEmergenteMapaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static Promocion promocion;
    private static Stage popupStage;
    
    @FXML
    private Label lbl1;
    
    @FXML
    private Label lbl2;
    
    @FXML
    private Label lbl3;
    
    @FXML
    private Label popupLabel;
    
    @FXML
    private Button btnCerrar;
    
    @FXML
    private ImageView img;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try(FileInputStream f =new FileInputStream("src/main/resources/images/viaL.jpg")){
            Image i = new Image(f);
            img.setImage(i);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        lbl1.setText(promocion.getPais());
        lbl2.setText(promocion.getCodigoPromocion());
        lbl3.setText("Descuento: "+promocion.getDescuento()+"%");
        cargarVentanaEmergente(popupStage);
    }    
    
    public void cargarVentanaEmergente(Stage popupStage){
        
            Thread popupThread = new Thread(() -> {
                try {
                    for (int i = 5; i > 0; i--) {
                        final int count = i;
                        Platform.runLater(() -> popupLabel.setText("Cerrando en " + count + " segundos"));
                        Thread.sleep(1000);
                    }
                    Platform.runLater(() -> popupStage.close());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            btnCerrar.setOnAction(event -> popupStage.close());
            popupThread.start();
    }

    public static Promocion getPromocion() {
        return promocion;
    }

    public static void setPromocion(Promocion promocion) {
        VentanaEmergenteMapaController.promocion = promocion;
    }

    public static Stage getPopupStage() {
        return popupStage;
    }

    public static void setPopupStage(Stage popupStage) {
        VentanaEmergenteMapaController.popupStage = popupStage;
    }
    
    
   
}
