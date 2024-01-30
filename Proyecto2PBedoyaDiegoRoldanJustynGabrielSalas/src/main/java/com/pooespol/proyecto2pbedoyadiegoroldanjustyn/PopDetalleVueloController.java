/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Tarifa;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justin Roldan
 */
public class PopDetalleVueloController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label labelCodigoAvion;
    
    @FXML
    private Label labelTipoTarifa;
    
    @FXML
    private Label labelCodigoVuelo;
    
    @FXML
    private Button btnCerrar;
    
    private static Vuelo v;
    private static Tarifa t;
    
    @FXML
    private ImageView imgAvion;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try(FileInputStream f = new FileInputStream("src/main/resources/images/avionPop.png")){
            Image i = new Image(f);
            imgAvion.setImage(i);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        labelCodigoVuelo.setText(v.getNumVuelo());
        labelCodigoAvion.setText(v.getCodigoAvion());
        labelTipoTarifa.setText(String.valueOf(t.getTipo()));
        btnCerrar.setOnAction(e->{
            Stage s=(Stage) imgAvion.getScene().getWindow();
            s.close();
        });
    }   

    public static Vuelo getV() {
        return v;
    }

    public static void setV(Vuelo v) {
        PopDetalleVueloController.v = v;
    }

    public static Tarifa getT() {
        return t;
    }

    public static void setT(Tarifa f) {
        PopDetalleVueloController.t = f;
    }
    
    
    
}
