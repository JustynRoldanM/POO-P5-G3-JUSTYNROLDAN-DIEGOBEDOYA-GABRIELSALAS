/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.CodigoInvalidoException;
import modelo.DatosIncompletosException;
import modelo.Destino;
import modelo.Promocion;
import modelo.Reserva;
import modelo.Tarifa;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justin Roldan
 */
public class PagoController implements Initializable {
    private static double mTotalReserva;
    private static Cliente cliente;
    private static Vuelo VueloSalida;
    private static Vuelo VueloRegreso;
    private static Tarifa tarifaSalida;
    private static Tarifa tarifaRegreso;
    private static String origen;
    private static String fechaSalida;
    private static String fechaRegreso;
    private static Destino destino;
    private static int numPasajeros;
    public static boolean validarFormaPago;
    public static double descuentoValor;
    @FXML
    private RadioButton RBTarjetaCredito;
    
    @FXML
    private RadioButton RBEfectivo;
    
    @FXML
    private TextField TFCodigoPromocional;
    
    @FXML
    private VBox contenedor;
    
    public static double precioConDescuento;
    
    @FXML
    private Label totalReserva;
    
    @FXML
    private Button btnPagar;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private Label mensajeError;
    
    @FXML
    private Label mensajeError1;
    
    @FXML
    private TextField numeroTarjeta;
    
    @FXML
    private DatePicker fechaExpiracion;
    
    @FXML
    private TextField cvv;
    
    @FXML
    private Label lblTotalPagar;
    
    @FXML
    private Label lblDescuento;
    
    @FXML
    private Label totalPagar;
    
    @FXML
    private Label descuento; 
    
    private ToggleGroup toggleGroup = new ToggleGroup();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RBTarjetaCredito.setToggleGroup(toggleGroup);
        RBEfectivo.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            contenedor.getChildren().clear(); 
            if (newValue == RBTarjetaCredito) {
                TFCodigoPromocional.clear();
                mensajeError1.setText("");
                mensajeError.setText("");
                mensajeError1.setText("");
                mostrarFormularioTarjetaCredito();
                lblDescuento.setText("Descuento: ");
                lblTotalPagar.setText("Total a pagar: ");
                descuento.setText("0%");
                actualizarTotalPagar(0); 
            } else if (newValue == RBEfectivo) {
                TFCodigoPromocional.clear();
                mensajeError1.setText("");
                mensajeError.setText("");
                mensajeError1.setText("");
                mostrarFormularioEfectivo();
                lblDescuento.setText("Descuento: ");
                lblTotalPagar.setText("Total a pagar: ");
                descuento.setText("0%");
                actualizarTotalPagar(0); 
            }
        });

        totalReserva.setText("$" + mTotalReserva);
        TFCodigoPromocional.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ArrayList<Promocion> promociones = Promocion.cargarPromos();
                Promocion promo = Promocion.buscarPromocion(newValue, promociones);

                if (promo != null && promo.getPais().equals(destino.getPais())) {
                    descuento.setText(promo.getDescuento() + "%");
                    double descuentoPorcentaje = promo.getDescuento() / 100.0;
                    double totalConDescuento = mTotalReserva * (1 - descuentoPorcentaje);
                    precioConDescuento =totalConDescuento;
                    totalPagar.setText("$" + String.format("%.2f", totalConDescuento));
                    mensajeError1.setText("");
                    mensajeError.setText("");
                } else {
                    descuento.setText("0%");
                    totalPagar.setText("$" + String.format("%.2f", mTotalReserva));
                    if(promo==null || !promo.getPais().equals(destino.getPais())){
                        mensajeError1.setText("Codigo promocional no valido");
                    }else{
                        mensajeError1.setText("");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }    
    private void actualizarTotalPagar(double descuentoPorcentaje) {
        double descuento = mTotalReserva * descuentoPorcentaje;
        double totalConDescuento = mTotalReserva - descuento;
        totalPagar.setText("$" + String.format("%.2f", totalConDescuento));
    }

    private void mostrarFormularioTarjetaCredito() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        Label labelNumeroTarjeta = new Label("Número de Tarjeta:");
        labelNumeroTarjeta.setPrefWidth(160);
        labelNumeroTarjeta.setPrefHeight(66);
        labelNumeroTarjeta.setFont(Font.font("System", FontWeight.BOLD, 16));
        numeroTarjeta = new TextField();
        numeroTarjeta.setPrefWidth(223);
        numeroTarjeta.setPrefHeight(31);

        gridPane.add(labelNumeroTarjeta, 0, 0);
        gridPane.add(numeroTarjeta, 1, 0);
        
        fechaExpiracion = new DatePicker();
        Label labelFechaExpiracion = new Label("Fecha de Expiración:");
        labelFechaExpiracion.setPrefWidth(160);
        labelFechaExpiracion.setPrefHeight(66);
        labelFechaExpiracion.setFont(Font.font("System", FontWeight.BOLD, 16));
        fechaExpiracion.setPrefWidth(223);
        fechaExpiracion.setPrefHeight(31);

        gridPane.add(labelFechaExpiracion, 0, 1);
        gridPane.add(fechaExpiracion, 1, 1);

        Label labelCVV = new Label("CVV:");
        labelCVV.setPrefWidth(160);
        labelCVV.setPrefHeight(66);
        labelCVV.setFont(Font.font("System", FontWeight.BOLD, 16));
        cvv = new TextField();
        cvv.setPrefWidth(223);
        cvv.setPrefHeight(31);

        gridPane.add(labelCVV, 0, 2);
        gridPane.add(cvv, 1, 2);

        contenedor.getChildren().add(gridPane);
        contenedor.setPadding(new Insets(10));
        contenedor.setAlignment(Pos.CENTER);
    }

    private void mostrarFormularioEfectivo() {
        Label mensaje = new Label("Estimado cliente, tiene 24 horas para acercarse a realizar el pago. De lo contrario, "+
               "\nla reserva se anulará");
        mensaje.setFont(Font.font("System", FontWeight.BOLD, 16)); 
        contenedor.getChildren().add(mensaje);
    }

    public static double getmTotalReserva() {
        return mTotalReserva;
    }

    public static void setmTotalReserva(double mTotalReserva) {
        PagoController.mTotalReserva = mTotalReserva;
    }
    
    
    @FXML
    void pagar(ActionEvent e) throws IOException {
        try {
            ArrayList<Promocion> promociones = Promocion.cargarPromos();
            Promocion promo = Promocion.buscarPromocion(TFCodigoPromocional.getText(), promociones);
            double descuento = 0.0;

            if (promo != null) {
                descuento = promo.getDescuento();
            }

            if (toggleGroup.getSelectedToggle() == RBTarjetaCredito) {
                validarFormaPago = true;
                if (isTarjetaDataIncomplete()) {
                    throw new DatosIncompletosException("Datos de la tarjeta incompletos o código inválido");
                }
                if (!TFCodigoPromocional.getText().isEmpty() && (promo == null || !promo.getPais().equals(destino.getPais()))) {
                    throw new CodigoInvalidoException("Código promocional no válido o no pertenece a su destino");
                }
            } else if (toggleGroup.getSelectedToggle() == RBEfectivo) {
                validarFormaPago = false;
                if (!TFCodigoPromocional.getText().isEmpty() && (promo == null || !promo.getPais().equals(destino.getPais()))) {
                    throw new CodigoInvalidoException("Código promocional no válido o no pertenece a su destino");
                }
            } else {
                mensajeError1.setText("Seleccione un método de pago");
                return;
            }

            int longitudCodigo = 6;
            StringBuilder codigo = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < longitudCodigo; i++) {
                char letra = (char) (random.nextInt(26) + 'A');
                codigo.append(letra);
            }
            String codigoReserva = codigo.toString();
            double precioTotal = (VueloSalida.getPrecioVuelo() + VueloRegreso.getPrecioVuelo());
            
            Reserva reserva = new Reserva(codigoReserva, cliente, VueloSalida, VueloRegreso, numPasajeros,
                    tarifaSalida, tarifaRegreso, fechaSalida, fechaRegreso, precioTotal);
            ConfirmacionCompraController.setReserva(reserva);
            reserva.serializarObjetoReserva();
            reserva.generarTransaccion();
            Reserva.escribirReserva(reserva);
            Stage s = (Stage) mensajeError.getScene().getWindow();
            s.close();
            App.abrirNuevaVentana("confirmacionCompra", 675, 610);

        } catch (DatosIncompletosException | CodigoInvalidoException ex) {
            mensajeError1.setText(ex.getMessage());
            mensajeError.setText("");
        }
    }

    private boolean isTarjetaDataIncomplete() {
        return fechaExpiracion.getValue() == null || cvv.getText().isEmpty() || numeroTarjeta.getText().isEmpty();
    }

    
    @FXML
    void cancelar(ActionEvent e) throws IOException{
        Stage s = (Stage) contenedor.getScene().getWindow();
        CancelarReservaController.setStagePago(s);
        App.abrirNuevaVentana("CancelarProceso", 520, 365);
        
    }
    
     public static Destino getDestino() {
        return destino;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        PagoController.cliente = cliente;
    }
     
     

    public static void setDestino(Destino destino) {
        PagoController.destino = destino;
    }

    public static Vuelo getVueloSalida() {
        return VueloSalida;
    }

    public static void setVueloSalida(Vuelo VueloSalida) {
        PagoController.VueloSalida = VueloSalida;
    }

    public static int getNumPasajeros() {
        return numPasajeros;
    }

    public static void setNumPasajeros(int numPasajeros) {
        PagoController.numPasajeros = numPasajeros;
    }
    

    public static Vuelo getVueloRegreso() {
        return VueloRegreso;
    }

    public static void setVueloRegreso(Vuelo VueloRegreso) {
        PagoController.VueloRegreso = VueloRegreso;
    }

    public static Tarifa getTarifaSalida() {
        return tarifaSalida;
    }

    public static void setTarifaSalida(Tarifa tarifaSalida) {
        PagoController.tarifaSalida = tarifaSalida;
    }

    public static Tarifa getTarifaRegreso() {
        return tarifaRegreso;
    }

    public static void setTarifaRegreso(Tarifa tarifaRegreso) {
        PagoController.tarifaRegreso = tarifaRegreso;
    }

    public static String getOrigen() {
        return origen;
    }

    public static void setOrigen(String origen) {
        PagoController.origen = origen;
    }

    public static String getFechaSalida() {
        return fechaSalida;
    }

    public static void setFechaSalida(String fechaSalida) {
        PagoController.fechaSalida = fechaSalida;
    }

    public static String getFechaRegreso() {
        return fechaRegreso;
    }

    public static void setFechaRegreso(String fechaRegreso) {
        PagoController.fechaRegreso = fechaRegreso;
    }   
}
