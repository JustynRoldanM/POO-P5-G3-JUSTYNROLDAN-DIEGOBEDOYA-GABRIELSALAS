/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Reserva;

/**
 * FXML Controller class
 *
 * @author home
 */
public class ConfirmacionCompraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label lblReserva;
    
    @FXML
    private Label lblConteo;
    
    @FXML
    private ImageView visorImg;
    
    @FXML
    private Button btnAceptar;
    
    private static Reserva reserva;
    private static boolean validar = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lblReserva.setText(Integer.toString(reserva.getCodigoReserva()));
        
        try{
            FileInputStream f = new FileInputStream("src/main/resources/images/mundo.png");
            Image img = new Image(f);
            visorImg.setImage(img);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        Thread t = new Thread(() -> {
            for (int i = 5; i > 0; i--){
                int segundos = i;
                try {
                    Platform.runLater(()-> lblConteo.setText("Ventana cerrada en " + segundos + " segundos..."));
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
            Platform.runLater(() -> {
                try{
                    Stage s = (Stage) lblConteo.getScene().getWindow();
                    s.close();
                    
                    if (validar == false) {
                        try {
                            App.abrirNuevaVentana("bienvenido", 1037, 758);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        });
        t.setDaemon(true);
        t.start();
        
        btnAceptar.setOnAction(e -> {
            Stage s = (Stage) lblConteo.getScene().getWindow();
            s.close();
            
            try{
                App.abrirNuevaVentana("bienvenido", 1037, 758);
            }catch(IOException ex){
                ex.printStackTrace();
            }
            validar = true;
        });
        
    }
        
    public static Reserva getReserva() {
        return reserva;
    }

    public static void setReserva(Reserva reserva) {
        ConfirmacionCompraController.reserva = reserva;
    }
        
}
