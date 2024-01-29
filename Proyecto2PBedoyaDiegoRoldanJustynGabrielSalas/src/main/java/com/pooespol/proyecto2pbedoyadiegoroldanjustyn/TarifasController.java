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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Tarifa;
import modelo.TipoTarifa;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class TarifasController implements Initializable {
    private static Vuelo vueloIda;
    
    public static ArrayList<Tarifa> tarifas;
    @FXML
    private VBox contenedorVB;
    
    @FXML
    private Label titulo;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarContenidoDinamico();
        titulo.setText("Tarifas");
    }    

    public static Vuelo getVueloIda() {
        return vueloIda;
    }

    public static void setVueloIda(Vuelo vueloIda) {
        TarifasController.vueloIda = vueloIda;
    }

    public static ArrayList<String> cargarColores(){
        ArrayList<String> coloresVintage = new ArrayList<>();
        coloresVintage.add("#f5f5dc"); // Beige Claro
        coloresVintage.add("#d2b48c"); // Marrón Tostado
        coloresVintage.add("#b8b76d"); // Verde Salvia
        coloresVintage.add("#778899"); // Gris Azulado
        coloresVintage.add("#d4ca9a"); // Amarillo Mostaza
        coloresVintage.add("#556b2f"); // Verde Oliva
        coloresVintage.add("#6699cc"); // Azul Polvoriento
        coloresVintage.add("#d8bfd8"); // Rosa Antiguo
        coloresVintage.add("#cc9966"); // Terracota
        coloresVintage.add("#708090"); // Gris Pizarra
        coloresVintage.add("#adbd8f"); // Verde Musgo
        coloresVintage.add("#fadfad"); // Melocotón Pálido
        coloresVintage.add("#4682b4"); // Azul Acero Desvaído
        coloresVintage.add("#8b4513"); // Marrón Envejecido
        coloresVintage.add("#eadeda"); // Amarillo Desgastado
        return coloresVintage;
    }
    
    public void cargarContenidoDinamico() {
        ArrayList<String> colores = cargarColores();
        cargarTarifas();
        contenedorVB.setPadding(new Insets(30,30,30,30));
        int j=0;
        for (Tarifa t : tarifas) {
            VBox vb = new VBox();
            vb.setStyle("-fx-border-color: "+colores.get(j+3)+";"+
                      "-fx-border-width: 6px;");
     
            vb.setAlignment(Pos.TOP_LEFT);
            vb.setSpacing(15);
            HBox hbNombre = new HBox();
            VBox vbCaracteristicas = new VBox();
            HBox hbPrecio = new HBox();
            ArrayList<String> imgCarac = new ArrayList<>();
            
            imgCarac.add("src/main/resources/images/maleta.png");
            imgCarac.add("src/main/resources/images/millas.png");
            imgCarac.add("src/main/resources/images/equipaje.png");
            imgCarac.add("src/main/resources/images/asiento.png");
            imgCarac.add("src/main/resources/images/time.png");

            hbNombre.setAlignment(Pos.CENTER);
            vbCaracteristicas.setAlignment(Pos.CENTER_LEFT);
            hbPrecio.setAlignment(Pos.CENTER);
            hbNombre.setPadding(new Insets(20,20,20,20));
            
            Label lb1 = new Label(t.getTipo() + ": " + t.getNombreTarifa());
            lb1.setStyle("-fx-text-fill: "+colores.get(j+3)+"; -fx-font-family: 'Georgia'; -fx-font-size: 18px; -fx-font-weight: bold;");
            hbNombre.getChildren().add(lb1);
            vb.getChildren().addAll(hbNombre);

            for (int i = 0; i < t.getCaracteristicas().size(); i++) {
                HBox hb = new HBox();
                hb.setSpacing(30);       
                hb.setAlignment(Pos.CENTER_LEFT);
                try(FileInputStream f = new FileInputStream(imgCarac.get(i))){
                    Image im = new Image(f,50,50,false,false);
                    ImageView img = new ImageView(im);
                    img.setPreserveRatio(true);
                    hb.getChildren().add(img);
                }catch(IOException e){
                }
                Label l = new Label(t.getCaracteristicas().get(i));
                l.setStyle("-fx-font-size: 15px;");
                hb.getChildren().add(l);
                vbCaracteristicas.setPadding(new Insets(20,20,20,20));
                vbCaracteristicas.getChildren().add(hb);
            }
            vb.getChildren().add(vbCaracteristicas);

            Label lbl3 = new Label(String.valueOf(vueloIda.getPrecioVuelo() + vueloIda.getPrecioVuelo() * t.getIncremento()));
            lbl3.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
            hbPrecio.setStyle("-fx-background-color: "+colores.get(j+3)+";");
            hbPrecio.getChildren().add(lbl3);
            hbPrecio.setPadding(new Insets(15,15,15,15));
            vb.getChildren().add(hbPrecio);
            
            contenedorVB.setSpacing(15);
            contenedorVB.getChildren().add(vb);
            contenedorVB.setOnMouseClicked(e->{
                Stage s = (Stage)contenedorVB.getScene().getWindow();
                s.close();
                vueloIda.setPrecioVuelo(vueloIda.getPrecioVuelo()*(1+t.getIncremento()));
                ResumenReservaController.setVueloIda(vueloIda);
                try {
                    App.abrirNuevaVentana("vuelosRegreso",640 ,700);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            j+=1;
        }
    }
    
   public static void cargarTarifas(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/tarifas.txt"))){
            tarifas = new ArrayList<>();
            br.readLine();
            String linea = br.readLine();
            while(linea!=null){
                String[] datos = linea.split(",");
                String [] caracteristicas = datos[2].split("-");
                ArrayList<String> caract = new ArrayList<>();
                for(int i = 0;i<caracteristicas.length;i++){
                    caract.add(caracteristicas[i]);
                }
                tarifas.add(new Tarifa(datos[0],TipoTarifa.valueOf(datos[1]),Double.parseDouble(datos[3]),caract));
                linea = br.readLine(); 
            }
        }catch(IOException e1){
        }
    }
   
    public static ArrayList<Tarifa> obtenerTarifas(){
        ArrayList<Tarifa> tarifas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/tarifas.txt"))){
            tarifas = new ArrayList<>();
            br.readLine();
            String linea = br.readLine();
            while(linea!=null){
                String[] datos = linea.split(",");
                String [] caracteristicas = datos[2].split("-");
                ArrayList<String> caract = new ArrayList<>();
                for(int i = 0;i<caracteristicas.length;i++){
                    caract.add(caracteristicas[i]);
                }
                tarifas.add(new Tarifa(datos[0],TipoTarifa.valueOf(datos[1]),Double.parseDouble(datos[3]),caract));
                linea = br.readLine(); 
            }
        }catch(IOException e1){
        }
        return tarifas;
    }
    
    public static Tarifa buscarTarifa(TipoTarifa codTarifa){
        ArrayList<Tarifa> tarifas=obtenerTarifas();
        for(Tarifa t:tarifas){
            if(t.getTipo().equals(codTarifa)){
                return t;
            }
        }
        return null;
    }
}
