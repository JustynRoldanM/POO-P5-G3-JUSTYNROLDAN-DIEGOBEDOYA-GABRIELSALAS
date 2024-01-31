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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author home
 */
public class CancelarProcesoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnSi;
    
    @FXML
    private Button btnNo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnNo.setOnAction(e ->{
           Stage s = (Stage) btnNo.getScene().getWindow();
           s.close();
        });
        
        btnSi.setOnAction(e ->{
            Stage s = (Stage) btnNo.getScene().getWindow();
            s.close();
            try{
                App.abrirNuevaVentana("bienvenido", 1037, 758);
            }catch(IOException ex){
                ex.printStackTrace();
            }
        });
        
    }    
    
}
