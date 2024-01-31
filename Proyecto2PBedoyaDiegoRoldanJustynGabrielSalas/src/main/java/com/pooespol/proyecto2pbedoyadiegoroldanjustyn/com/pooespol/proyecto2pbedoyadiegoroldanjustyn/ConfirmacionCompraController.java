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
import javafx.stage.Stage;
import modelo.Reserva;

/**
 * FXML Controller class
 *
 * @author Justin Roldan
 */
public class ConfirmacionCompraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ImageView image;
    
    @FXML
    private Label labelCodigoR;
    
    @FXML
    private Label labelSegundos;
    
    @FXML
    private Button btnAceptar;
    
    @FXML
    private static Reserva reserva;
    
    boolean validar=false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try(FileInputStream fileInput = new FileInputStream("src/main/resources/images/avionConfirmacion.png")){
            Image img = new Image(fileInput);
            image.setImage(img);
        }catch(FileNotFoundException f){
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        labelCodigoR.setText(reserva.getCodigoReserva());
        ejecutarThread();
    }    
    
    private void ejecutarThread(){
        Thread t = new Thread(()->{
            for(int i =0;i<5;i++){
                int e =i;
                Platform.runLater(()->{
                    labelSegundos.setText(String.valueOf(5-e));
                });    
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
            if(!validar){
                Platform.runLater(()->{
                    Stage s=(Stage) labelSegundos.getScene().getWindow();
                    s.close();
                    try {
                        App.abrirNuevaVentana("bienvenido", 1037, 758);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                
            }
        });
        t.start();
        
        btnAceptar.setOnAction(e->{
            validar=true;
            Stage s=(Stage) labelSegundos.getScene().getWindow();
            s.close();
            try {
                App.abrirNuevaVentana("bienvenido", 1037, 758);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    

    public static Reserva getReserva() {
        return reserva;
    }

    public static void setReserva(Reserva reserva) {
        ConfirmacionCompraController.reserva = reserva;
    }

    
    
}
