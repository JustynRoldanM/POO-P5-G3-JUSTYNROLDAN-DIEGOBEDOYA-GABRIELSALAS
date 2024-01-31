package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import modelo.Destino;

/**
 * FXML Controller class
 *
 * @author home
 */
public class ReservasController implements Initializable {
    @FXML
    private ComboBox cbxOrigen;
    
    @FXML
    private ComboBox cbxDestino;
    
    @FXML
    private DatePicker fechaSalida;
    
    @FXML
    private DatePicker fechaRegreso;
    
    @FXML
    private Spinner cantidadPasajeros;
    
    @FXML
    private Button btnBuscar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 1);
        cantidadPasajeros.setValueFactory(valueFactory);
        cbxOrigen.getItems().addAll("Guayaquil","Quito","Cuenca");
        cargarComboDestinos();
        aplicarEstilos();
        btnBuscar.setOnAction(e ->{
            if(cbxOrigen.getValue()==null || cbxDestino.getValue()==null || fechaSalida.getValue()==null || fechaRegreso.getValue()==null || cantidadPasajeros.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Campos incompletos, porfavor llena toda la información");
                alert.showAndWait();
            }else{
                ReservaVueloController.setDestino(String.valueOf(cbxDestino.getValue()));
                ReservaVueloController.setOrigen(String.valueOf(cbxOrigen.getValue()));
                ResumenReservaController.setFechaS(String.valueOf(fechaSalida.getValue()));
                ResumenReservaController.setFechaR(String.valueOf(fechaRegreso.getValue()));
                VuelosRegresoController.setDestinoVRegreso(String.valueOf(cbxOrigen.getValue()));
                VuelosRegresoController.setOrigenVRegreso(String.valueOf(cbxDestino.getValue()));
                DatosPersonalesController.setNumeroPersonas((int) cantidadPasajeros.getValue());
                PagoController.setDestino((Destino) cbxDestino.getValue());
                PagoController.setFechaSalida(String.valueOf(fechaSalida.getValue()));
                PagoController.setFechaRegreso(String.valueOf(fechaRegreso.getValue()));
                PagoController.setNumPasajeros((int) cantidadPasajeros.getValue());
                PagoController.setOrigen((String) cbxOrigen.getValue());
                try {
                    cambiarAReservaVuelo();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
  
            }
        });
    } 
    
    private void cargarComboDestinos(){
        ArrayList<Destino> destinos = Destino.cargarDestinos();
        for(Destino destino:destinos){
            cbxDestino.getItems().add(destino);
        }
    }
    
    public void aplicarEstilos(){
        cbxOrigen.setStyle("-fx-font-size: 18px;");
        cbxDestino.setStyle("-fx-font-size: 18px;");
        fechaSalida.setStyle("-fx-font-size: 18px;");
        fechaRegreso.setStyle("-fx-font-size: 18px;");
        cantidadPasajeros.setStyle("-fx-font-size: 18px;");
    }
    
    public void cambiarAReservaVuelo() throws IOException{
        Stage ventanaActual = (Stage) cbxOrigen.getScene().getWindow();
        ventanaActual.close();
        App.abrirNuevaVentana("reservaVuelo", 650, 700);
    }
}
