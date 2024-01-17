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
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class ReservaVueloController implements Initializable {
    
    private static ArrayList<Vuelo> vuelos = new ArrayList<>();
    private static String fechaVueloRegreso;
    private static String fechaVueloSalida;
    private static int cantidadPasajeros;
    private static String origen;
    private static String destino;
    
    @FXML
    private Label titulo;
    
    @FXML
    private ComboBox cbFiltro;
    
    @FXML
    private Label ordenar;
    
    @FXML
    private VBox contenedorVB;
    
    
    private static String valorCB="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        llenarListaVuelos();
        try {
            contenidoDinamicoVuelos(vuelos);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        cbFiltro.setStyle(
                "-fx-font-size: 14px; " +
                "-fx-background-color: #f4f4f4; " +
                "-fx-border-color: #a0a0a0; " +
                "-fx-border-width: 2px; " +
                "-fx-border-radius: 5px; " +
                "-fx-padding: 5px 10px; " +
                "-fx-effect: innershadow(gaussian, #e0e0e0, 10, 0, 0, 0);"
        );
        filtroComboBox();
    }    
    
    public void llenarListaVuelos(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/vuelos.txt"))){
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[] info = linea.split(";");
                vuelos.add(new Vuelo(info[1],info[2],Double.valueOf(info[3]),info[4],info[5],info[0],info[6],Double.valueOf(info[7])));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void contenidoDinamicoVuelos(ArrayList<Vuelo> vuelos) throws FileNotFoundException{
        titulo.setText("Selecciona tu vuelo "+origen+" - "+destino);
        ordenar.setText("Ordenar por: ");
        for(Vuelo v:vuelos){
            if(v.getOrigen().equals(origen) && v.getDestino().equals(destino)){
                VBox vb = new VBox();
                vb.setStyle("-fx-border-color: black;");
                HBox duracion = new HBox();
                HBox hora = new HBox();
                HBox precio = new HBox();
                HBox espacioTop = new HBox();
                HBox espacioBottom = new HBox();
                espacioBottom.setPadding(new Insets(20,20,20,20));
                espacioTop.setPadding(new Insets(20,20,20,20));
                duracion.setAlignment(Pos.CENTER);
                hora.setAlignment(Pos.CENTER);
                precio.setAlignment(Pos.CENTER);
                duracion.setSpacing(55);
                hora.setSpacing(5);
                precio.setSpacing(55);
                Label lblDuracion = new Label("Duracion: "+v.getDuracionHoras()+" horas");
                Label lblHoraSalida = new Label(v.getHoraSalida());
                Label lblHoraLlegada = new Label(v.getHoraLlegada());
                Label lblPrecio = new Label(String.valueOf(v.getPrecioVuelo()));
                vb.setPadding(new Insets(42,42,42,42));
                FileInputStream f = new FileInputStream("src/main/resources/images/menos.png");
                Image i = new Image(f,400,45,false,false);
                ImageView img= new ImageView(i);
                img.setPreserveRatio(true);
                duracion.getChildren().add(lblDuracion);
                hora.getChildren().addAll(lblHoraSalida,img,lblHoraLlegada);
                precio.getChildren().add(lblPrecio);
                contenedorVB.getChildren().addAll(espacioTop,duracion,hora,precio,espacioBottom);
            }
        }
    }
    
    public void cargarVentanaTarifas() throws IOException{
        Stage s = (Stage)contenedorVB.getScene().getWindow();
        s.close();
        App.abrirNuevaVentana("tarifas", 700, 700);
    }
    
    public void filtroComboBox(){
        cbFiltro.getItems().addAll("precio","duración");
        cbFiltro.setOnAction(e ->{
            ReservaVueloController.setValorCB((String) cbFiltro.getValue());
            if(cbFiltro.getValue().equals("precio")){        
                contenedorVB.getChildren().clear();
                try {
                    Collections.sort(vuelos);
                    contenidoDinamicoVuelos(vuelos);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }else{
                contenedorVB.getChildren().clear();
                Collections.sort(vuelos);
                try {
                    contenidoDinamicoVuelos(vuelos);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    


    public static String getFechaVueloRegreso() {
        return fechaVueloRegreso;
    }

    public static void setFechaVueloRegreso(String fechaVueloRegreso) {
        ReservaVueloController.fechaVueloRegreso = fechaVueloRegreso;
    }

    public static String getFechaVueloSalida() {
        return fechaVueloSalida;
    }

    public static void setFechaVueloSalida(String fechaVueloSalida) {
        ReservaVueloController.fechaVueloSalida = fechaVueloSalida;
    }

    public static int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public static void setCantidadPasajeros(int cantidadPasajeros) {
        ReservaVueloController.cantidadPasajeros = cantidadPasajeros;
    }

    public static String getOrigen() {
        return origen;
    }

    public static void setOrigen(String origen) {
        ReservaVueloController.origen = origen;
    }

    public static String getDestino() {
        return destino;
    }

    public static void setDestino(String destino) {
        ReservaVueloController.destino = destino;
    }

    public static String getValorCB() {
        return valorCB;
    }

    public static void setValorCB(String valorCB) {
        ReservaVueloController.valorCB = valorCB;
    }
    
    
}
