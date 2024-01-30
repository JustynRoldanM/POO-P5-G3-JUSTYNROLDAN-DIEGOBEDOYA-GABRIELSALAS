
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Tarifa;
import modelo.Vuelo;
 
public class ResumenReservaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label labelFechaS;
    
    @FXML
    private Label labelFechaR;
    
    @FXML
    private VBox contenedorVuelo1;
    
    @FXML
    private VBox contenedorVuelo2;
    
    @FXML
    private Button btnContinuar;
    
    @FXML
    private Label origenDestino;
    
    @FXML
    private Label destinoOrigen;
    
    @FXML
    private Label labelTotalReserva;
    
    private static Vuelo vueloIda;
    private static Vuelo vueloVenida;
    private static String fechaR;
    private static String fechaS;
    private static double totalReserva;
    private static Tarifa tarifaIda;
    private static Tarifa tarifaVenida;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Button btnVueloSalida = new Button("Detalles de la Reserva");
        btnVueloSalida.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        btnVueloSalida.setOnAction(event -> {
            PopDetalleVueloController.setT(tarifaIda);
            PopDetalleVueloController.setV(vueloIda);
            try {
                App.abrirNuevaVentana("popDetalleVuelo", 374, 276);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Button btnVueloRegreso = new Button("Detalles de la Reserva");
        btnVueloRegreso.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        btnVueloRegreso.setOnAction(event -> {
            PopDetalleVueloController.setT(tarifaVenida);
            PopDetalleVueloController.setV(vueloVenida);
            try {
                App.abrirNuevaVentana("popDetalleVuelo", 374, 276);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        cargarContenedorVuelo(vueloIda,contenedorVuelo1,btnVueloSalida);
        cargarContenedorVuelo(vueloVenida,contenedorVuelo2,btnVueloRegreso);
        labelFechaR.setText(fechaR);
        labelFechaS.setText(fechaS);
        totalReserva=vueloIda.getPrecioVuelo()+vueloVenida.getPrecioVuelo();
        labelTotalReserva.setText(String.valueOf(totalReserva));
        origenDestino.setText(vueloIda.getOrigen()+" - "+vueloVenida.getOrigen());
        destinoOrigen.setText(vueloVenida.getOrigen()+" - "+vueloVenida.getDestino());
        btnContinuar.setOnAction(e->{
            Stage s = (Stage) btnContinuar.getScene().getWindow();
            s.close();
            try {
                App.abrirNuevaVentana("datosPersonales", 750, 730);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }    
    
   public void cargarContenedorVuelo(Vuelo v, VBox contenedor, Button btn) {
        VBox vb = new VBox(10);  
        vb.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 10px;");

        HBox duracion = new HBox();
        duracion.setAlignment(Pos.CENTER);
        Label lblDuracion = new Label("Duración: " + v.getDuracionHoras() + " horas");
        lblDuracion.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
        duracion.getChildren().add(lblDuracion);
        HBox hora = new HBox(10);  
        hora.setAlignment(Pos.CENTER);
        Label lblHoraSalida = new Label(v.getHoraSalida());
        Label lblHoraLlegada = new Label(v.getHoraLlegada());
        lblHoraSalida.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
        lblHoraLlegada.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");

        ImageView img = null;
        try (FileInputStream f = new FileInputStream("src/main/resources/images/aereo.png")) {
            Image i = new Image(f, 100, 100, false, false);
            img = new ImageView(i);
            img.setPreserveRatio(true);
        } catch (IOException e) {
            e.printStackTrace();  
        }
        hora.getChildren().addAll(lblHoraSalida, img, lblHoraLlegada);
        HBox precio = new HBox();
        precio.setAlignment(Pos.CENTER);
        Label lblPrecio = new Label(String.valueOf(v.getPrecioVuelo()));
        lblPrecio.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
        Bloom b = new Bloom();
        lblPrecio.setEffect(b);
        precio.getChildren().add(lblPrecio);

        HBox HBtn = new HBox();
        HBtn.setAlignment(Pos.CENTER);
        HBtn.setPadding(new Insets(10));
        HBtn.getChildren().add(btn);

        vb.getChildren().addAll(duracion, hora, precio, HBtn);
        contenedor.getChildren().add(vb);
    }


    public static Vuelo getVueloIda() {
        return vueloIda;
    }
   

    public static void setVueloIda(Vuelo vueloIda) {
        ResumenReservaController.vueloIda = vueloIda;
    }

    public static Vuelo getVueloVenida() {
        return vueloVenida;
    }

    public static void setVueloVenida(Vuelo vueloVenida) {
        ResumenReservaController.vueloVenida = vueloVenida;
    }

    public static String getFechaR() {
        return fechaR;
    }

    public static void setFechaR(String fechaR) {
        ResumenReservaController.fechaR = fechaR;
    }

    public static String getFechaS() {
        return fechaS;
    }

    public static void setFechaS(String fechaS) {
        ResumenReservaController.fechaS = fechaS;
    }

    public static double getTotalReserva() {
        return totalReserva;
    }

    public static void setTotalReserva(double totalReserva) {
        ResumenReservaController.totalReserva = totalReserva;
    }

    public static Tarifa getTarifaIda() {
        return tarifaIda;
    }

    public static void setTarifaIda(Tarifa tarifaIda) {
        ResumenReservaController.tarifaIda = tarifaIda;
    }

    public static Tarifa getTarifaVenida() {
        return tarifaVenida;
    }

    public static void setTarifaVenida(Tarifa tarifaVenida) {
        ResumenReservaController.tarifaVenida = tarifaVenida;
    }


}
