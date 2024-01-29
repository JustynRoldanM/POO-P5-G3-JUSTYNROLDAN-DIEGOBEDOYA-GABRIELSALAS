
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarContenedorVuelo(vueloIda,contenedorVuelo1);
        cargarContenedorVuelo(vueloVenida,contenedorVuelo2);
        labelFechaR.setText(fechaR);
        labelFechaS.setText(fechaS);
        totalReserva=vueloIda.getPrecioVuelo()+vueloVenida.getPrecioVuelo();
        labelTotalReserva.setText(String.valueOf(totalReserva));
        origenDestino.setText(vueloIda.getOrigen()+" - "+vueloVenida.getOrigen());
        destinoOrigen.setText(vueloVenida.getOrigen()+" - "+vueloVenida.getDestino());
    }    
    
    public void cargarContenedorVuelo(Vuelo v,VBox contenedor){
        VBox vb = new VBox();
        vb.setStyle("-fx-background-color: white" +"; -fx-border-color: gold");
        HBox duracion = new HBox();
        duracion.setAlignment(Pos.CENTER);
        Label lblDuracion = new Label("Duracion: " + v.getDuracionHoras() + " horas");
        lblDuracion.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 20px; -fx-font-weight: bold;");
        duracion.getChildren().add(lblDuracion);
        HBox hora = new HBox();
        hora.setAlignment(Pos.CENTER);
        Label lblHoraSalida = new Label(v.getHoraSalida());
        Label lblHoraLlegada = new Label(v.getHoraLlegada());
        lblHoraSalida.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
        lblHoraLlegada.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
        ImageView img=null;
         try (FileInputStream f = new FileInputStream("src/main/resources/images/aereo.png")) {
            Image i = new Image(f, 100, 100, false, false);
            img = new ImageView(i);
            img.setPreserveRatio(true);
        } catch (IOException e) {
        }
        hora.getChildren().addAll(lblHoraSalida, img, lblHoraLlegada);
        HBox precio = new HBox();
        precio.setAlignment(Pos.CENTER);
        Label lblPrecio = new Label(String.valueOf(v.getPrecioVuelo()));
        lblPrecio.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 20px; -fx-font-weight: bold;");
        Bloom b = new Bloom();
        lblPrecio.setEffect(b);
        precio.getChildren().add(lblPrecio);
        vb.setPadding(new Insets(12, 12, 12, 12));
        vb.setSpacing(30);
        vb.getChildren().addAll(duracion, hora, precio);
        Button btnDetalles = new Button("Detalles de la Reserva");
        btnDetalles.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        btnDetalles.setOnAction(event -> {
            try {
                mostrarDetallesReserva(v);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        VBox cButton = new VBox();
        cButton.setAlignment(Pos.CENTER);
        cButton.setPadding(new Insets(10, 10, 10, 10));
        cButton.getChildren().add(btnDetalles);
        vb.getChildren().add(cButton);
        contenedor.getChildren().add(vb);
    }

    public static Vuelo getVueloIda() {
        return vueloIda;
    }
    
    public void mostrarDetallesReserva(Vuelo v) throws IOException{
        App.abrirNuevaVentana("popDetalleReserva", 200, 200);
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


   
}
