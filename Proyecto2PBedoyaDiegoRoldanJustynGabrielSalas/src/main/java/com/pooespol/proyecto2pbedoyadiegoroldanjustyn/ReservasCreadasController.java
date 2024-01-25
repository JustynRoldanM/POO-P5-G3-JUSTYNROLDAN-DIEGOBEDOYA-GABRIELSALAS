
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Tarifa;
import modelo.TipoTarifa;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class ReservasCreadasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    
    @FXML
    private VBox actualizadorReservas;
    
    @FXML
    private ImageView imgReservasCreadas;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarImagenes();
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Platform.runLater(() -> actualizarReservas());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true); 
        t.start();
    }    
     public void agregarImagenes(){
        try {
            FileInputStream f = new FileInputStream("src/main/resources/images/tierra.jpg");
            Image img = new Image(f);
            imgReservasCreadas.setImage(img);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarReservas() {
        actualizadorReservas.getChildren().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/reservas.txt"))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] info = linea.split(",");
                Cliente c = InicioController.buscarCliente(Long.valueOf(info[1]));
                Vuelo vIda = ReservaVueloController.buscarVueloa(info[7]);
                Vuelo vRegreso = ReservaVueloController.buscarVueloa(info[8]);
                Tarifa tIda = TarifasController.buscarTarifa(TipoTarifa.valueOf(info[9]));
                Tarifa tRegreso = TarifasController.buscarTarifa(TipoTarifa.valueOf(info[10]));
                Reserva r = new Reserva(Integer.valueOf(info[0]), c, vIda, vRegreso, Integer.valueOf(info[6]), tIda, tRegreso);
                Label label = new Label(r.getCodigoReserva() + " - " + r.getCliente().getNombre());
                HBox hBox = new HBox(label);
                hBox.setAlignment(Pos.CENTER);
                hBox.setPadding(new Insets(10, 10, 10, 10));
                hBox.setSpacing(10);
                actualizadorReservas.getChildren().add(hBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
