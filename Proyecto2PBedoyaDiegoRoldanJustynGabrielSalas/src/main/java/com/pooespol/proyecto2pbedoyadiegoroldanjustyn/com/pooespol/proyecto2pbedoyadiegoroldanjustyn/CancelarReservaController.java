/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Justin Roldan
 */
public class CancelarReservaController implements Initializable {

    @FXML
    private Button btnSi;
    
    @FXML
    private Button btnNo;
    
    @FXML
    private static Stage stagePago;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSi.setOnAction(e->{    
            stagePago.close();
            try {
                App.abrirNuevaVentana("bienvenido",1037 , 758);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Stage s =(Stage) btnNo.getScene().getWindow();
            s.close();
        });
        btnNo.setOnAction(e->{
            Stage s =(Stage) btnNo.getScene().getWindow();
            s.close();
        });
    }    

    public static Stage getStagePago() {
        return stagePago;
    }

    public static void setStagePago(Stage stagePago) {
        CancelarReservaController.stagePago = stagePago;
    }

    
    
    
}
