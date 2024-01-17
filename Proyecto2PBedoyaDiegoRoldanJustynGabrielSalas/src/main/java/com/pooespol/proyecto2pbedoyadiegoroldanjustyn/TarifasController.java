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
import javafx.scene.layout.VBox;
import modelo.Tarifa;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class TarifasController implements Initializable {
    private static Vuelo v;
    
    public static ArrayList<Tarifa> tarifas;
    @FXML
    private VBox contenedorVB;
    
    @FXML
    private Label titulo;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public static Vuelo getV() {
        return v;
    }

    public static void setV(Vuelo v) {
        TarifasController.v = v;
    }
    
    public void cargarTarifas(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/tarifas.txt"))){
            br.readLine();
            tarifas = new ArrayList<>();
            String linea;
            while((linea=br.readLine())!=null){
                
            }
        }catch(IOException e){
        }
    }
}
