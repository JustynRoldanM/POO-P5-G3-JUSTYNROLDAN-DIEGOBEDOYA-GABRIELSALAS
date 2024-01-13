
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
 * @author Justyn Roldan
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
        cargarCombo();
        aplicarEstilos();
        btnBuscar.setOnAction(e ->{
            
        });
    } 
    
    public void aplicarEstilos(){
        cbxOrigen.setStyle("-fx-font-size: 18px;");
        cbxDestino.setStyle("-fx-font-size: 18px;");
        fechaSalida.setStyle("-fx-font-size: 18px;");
        fechaRegreso.setStyle("-fx-font-size: 18px;");
        cantidadPasajeros.setStyle("-fx-font-size: 18px;");
    }
    
    public void cargarCombo(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/destinos.txt"))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] info = linea.split(",");
                Destino d = new Destino(info[0],info[1]);
                cbxDestino.getItems().add(d);
            }
        }catch(IOException e){
        }
    }
    
    public void cambiarAReservaVuelo() throws IOException{
        Stage s = new Stage();
        Scene scene= new Scene(App.loadFXML("reservaVuelo"),400,400);
        s.setScene(scene);
        s.setResizable(false);
    }
    
}
