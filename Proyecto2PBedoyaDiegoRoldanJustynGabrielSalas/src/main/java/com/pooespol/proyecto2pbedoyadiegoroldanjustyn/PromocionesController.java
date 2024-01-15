/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class PromocionesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ImageView mapaProyecto;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Pane p;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FileInputStream f = new FileInputStream("src/main/resources/images/mapaProyecto.png");
            Image img = new Image(f);
            mapaProyecto.setImage(img);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }    
    
    public void agregarPromociones(){
        
    }
     public void agregarImagenes(){
       
    }
  
    
}
