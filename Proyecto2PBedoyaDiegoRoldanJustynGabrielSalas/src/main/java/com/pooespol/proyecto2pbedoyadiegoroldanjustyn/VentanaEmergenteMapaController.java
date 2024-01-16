/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Promocion;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class VentanaEmergenteMapaController implements Initializable {

    /**
     * 
     * Initializes the controller class.
     */
    
    private static Promocion promo;
    
    @FXML
    private VBox root;
    
    @FXML
    private HBox hb1;
    
    @FXML
    private HBox hb2;
    
    @FXML
    private HBox hb3;
    
    @FXML
    private HBox hb4;
    
    @FXML
    private Label lbl1;
    
    @FXML
    private Label lbl2;
    
    @FXML
    private Label lbl3;
    
    @FXML
    private Label lbl4;
    
    @FXML
    private Button btnSalir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl1.setText(promo.getPais());
        lbl2.setText(promo.getCodigoPromocion());
        lbl3.setText("Descuento: "+promo.getDescuento()+"%");
        lbl4.setText("Cerrado en n segunodos ...");
        root.setStyle("-fx-background-color: #0e0e22; " +
              "-fx-background-image: url('src/main/resources/images/viaL'); " +
              "-fx-background-size: cover;");
        hb1.setPadding(new Insets(10));
        hb2.setPadding(new Insets(10));
        hb3.setPadding(new Insets(10));
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(35);
    }    

    public static Promocion getPromo() {
        return promo;
    }

    public static void setPromo(Promocion promo) {
        VentanaEmergenteMapaController.promo = promo;
    }
    
    
    
}
