/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import modelo.Promocion;

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
        agregarPromociones();
    }    
    
        public void agregarPromociones(){
            ArrayList<Promocion> promociones = cargarPromociones();
            for(int i=0;i<promociones.size();i++){
                Promocion promo = promociones.get(i);
                try (FileInputStream f = new FileInputStream("src/main/resources/images/posicion.png")) {
                     Image img = new Image(f, 30, 30, false, false);
                     ImageView im = new ImageView(img);
                     im.setPreserveRatio(true);
                     im.setSmooth(true);
                     im.setCache(true);
                     im.setLayoutX(promo.getCoordX());
                     im.setLayoutY(promo.getCoordY());
                     p.getChildren().add(im);
                     im.setOnMouseClicked(e ->{
                         try {
                             VentanaEmergenteMapaController.setPromo(promo);
                             cargarVentanaEmergente(promo);
                         } catch (IOException ex) {
                             ex.printStackTrace();
                         }
                     });
                } catch (FileNotFoundException f) {
                       f.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } 
            }
        }
        
        public void cargarVentanaEmergente(Promocion promo) throws IOException{
            Stage s = new Stage();
            Scene scene = new Scene(App.loadFXML("ventanaEmergenteMapa"),300,200);
            s.setScene(scene);
            s.show();
        }
        
        public ArrayList<Promocion> cargarPromociones(){
            ArrayList<Promocion> promociones = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/promociones.txt"))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] info = linea.split(",");
                        Promocion promo = new Promocion(Double.valueOf(info[0]), Double.valueOf(info[1]), info[2], info[3], Double.valueOf(info[4]));
                        promociones.add(promo);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return promociones;
        }
        
        public void ejecutarThread(ImageView i){
            Random random = new Random();
            int n = random.nextInt(10) + 1;
            Thread tr = new Thread(() ->{
                try {
                    Thread.sleep(n*1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
            tr.start();
        }
    
}
