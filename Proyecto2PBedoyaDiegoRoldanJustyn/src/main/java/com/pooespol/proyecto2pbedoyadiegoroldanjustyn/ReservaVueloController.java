/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
    private AnchorPane root;
    
    @FXML
    private Pane paneCenter;
    
    @FXML
    private BorderPane bp;
    @FXML
    private Pane paneTop;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarListaVuelos();
        titulo.setText("Selecciona tu vuelo "+origen+" - "+destino);
    }    
    
    public void llenarListaVuelos(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/vuelos.txt"))){
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[] info = linea.split(";");
                vuelos.add(new Vuelo(info[3],info[1],info[2],Double.valueOf(info[4]),info[5],info[6],info[0],info[7],Double.valueOf(info[8])));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Vuelo> cargarVuelosXfechaVOrigen(){
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        for(Vuelo v: vuelos){
            if(v.getFechaVuelo().equals(fechaVueloSalida)){
                vuelos.add(v);
            }
        }
        return vuelos;
    }
    
    public ArrayList<Vuelo> cargarVuelosXfechaVDestino(){
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        for(Vuelo v: vuelos){
            if(v.getFechaVuelo().equals(fechaVueloRegreso)){
                vuelos.add(v);
            }
        }
        return vuelos;
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
    
   
}
