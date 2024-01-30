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
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Justin Roldan
 */


public class DatosPersonalesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private VBox contenedorFormularios;
    
    private static int numeroPersonas;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearFormularios();
    }


    public static int getNumeroPersonas() {
        return numeroPersonas;
    }
    
    private void crearFormularios() {
        for (int i = 0; i < numeroPersonas; i++) {
            VBox vDatosPersonales = new VBox();
            vDatosPersonales.setPadding(new Insets(20));
            vDatosPersonales.setAlignment(Pos.CENTER);
            vDatosPersonales.setStyle("-fx-border-color: black; -fx-border-width: 1;");

            HBox tituloDP = new HBox();
            HBox formulario = new HBox();
            formulario.setAlignment(Pos.CENTER);
            tituloDP.setPadding(new Insets(20));
            tituloDP.setAlignment(Pos.CENTER);

            Label titulo = new Label("Persona: " + (i + 1));
            titulo.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 14;");
            tituloDP.getChildren().add(titulo);

            VBox vNA = new VBox();
            VBox vPC = new VBox();

            HBox cNombre = crearCampo("Nombre:");
            HBox cApellido = crearCampo("Apellido:");
            HBox cPasaporte = crearCampo("Pasaporte:");
            HBox cCorreo = crearCampo("Correo:");

            vNA.getChildren().addAll(cNombre, cApellido);
            vPC.getChildren().addAll(cPasaporte, cCorreo);

            formulario.getChildren().addAll(vNA, vPC);
            vDatosPersonales.getChildren().addAll(tituloDP, formulario);
            contenedorFormularios.getChildren().addAll(vDatosPersonales);
        }
    }

    private HBox crearCampo(String labelText) {
        HBox campoBox = new HBox();
        campoBox.setAlignment(Pos.CENTER);
        campoBox.setPadding(new Insets(10));
        campoBox.setSpacing(20);

        Label label = new Label(labelText);
        TextField textField = new TextField();
        campoBox.getChildren().addAll(label, textField);

        return campoBox;
    }
          
    public static void setNumeroPersonas(int numeroPersonas) {
        DatosPersonalesController.numeroPersonas = numeroPersonas;
    }

   
    
}
