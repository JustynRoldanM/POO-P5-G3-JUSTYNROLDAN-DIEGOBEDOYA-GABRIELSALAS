
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
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Vuelo;

/**
 * FXML Controller class
 *
 * @author Justin Roldan
 */
public class VuelosRegresoController implements Initializable {
    
    private static String origenVRegreso;
    private static String destinoVRegreso;

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
        contenedorVB.setPadding(new Insets(20,20,20,20));
        ArrayList<Vuelo> vuelos = cargarVuelos();
        try {
            contenidoDinamicoVuelos(vuelos);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        cbFiltro.setStyle(
                "-fx-font-size: 15px; " +
                "-fx-border-radius: 5px; " +
                "-fx-padding: 5px 5px; " 
        );
        filtroComboBox();
    }    
    
     private static ArrayList<Vuelo> cargarVuelos(){
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/vuelosVenida.txt"))){
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[] info = linea.split(";");
                vuelos.add(new Vuelo(info[1],info[2],Double.valueOf(info[3]),info[4],info[5],info[0],info[6],Double.valueOf(info[7])));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return vuelos;
    }
    
    public static Vuelo buscarVueloa(String codVuelo){
        ArrayList<Vuelo> vuelos=cargarVuelos();
        for(Vuelo v: vuelos){
            if(v.getNumVuelo().equals(codVuelo)){
                return v;
            }
        }
        return null;
    }
    
    public static ArrayList<String> colores() {
        ArrayList<String> colores = new ArrayList<>();
        colores.add("#00CED1");  // Turquesa medio
        colores.add("#9932CC");  // Púrpura oscuro
        colores.add("#00FF7F");  // Verde primavera
        colores.add("#DAA520");  // Oro antiguo
        colores.add("#FF69B4");  // Rosa intenso
        colores.add("#6A5ACD");  // Azul pizarra
        colores.add("#8B008B");  // Magenta oscuro
        colores.add("#00FA9A");  // Verde césped
        colores.add("#CD853F");  // Bronceado
        colores.add("#FF6F61");  // Coral
        colores.add("#FFD700");  // Oro
        colores.add("#8A2BE2");  // Azul violeta
        colores.add("#32CD32");  // Verde lima
        colores.add("#FF8C00");  // Naranja oscuro
        colores.add("#8B4513");  // Marrón oscuro
        colores.add("#9370DB");  // Púrpura medio
        colores.add("#20B2AA");  // Verde azulado
        colores.add("#FF6347");  // Tomate
        colores.add("#4B0082");  // Índigo oscuro
        colores.add("#FF4500");  // Rojo anaranjado
       

        return colores;
    }
    
    public void contenidoDinamicoVuelos(ArrayList<Vuelo> vuelos) throws FileNotFoundException{
        ArrayList<String> colores= colores();
        titulo.setText("Selecciona tu vuelo "+origenVRegreso+" - "+destinoVRegreso);
        ordenar.setText("Ordenar por: ");
        int j=0;
        for(Vuelo vueloRegreso:vuelos){
            if(vueloRegreso.getOrigen().equals(origenVRegreso) && vueloRegreso.getDestino().equals(destinoVRegreso)){
                VBox vb = new VBox();
                vb.setStyle("-fx-background-color: "+colores.get(j) +
                            "; -fx-border-color: "+colores.get(j)+
                            "; -fx-border-width: 2px;" +
                            "-fx-border-radius: 10px;");
                HBox bottom = new HBox();
                HBox top = new HBox();
                bottom.setPadding(new Insets(10,10,10,10));
                top.setPadding(new Insets(5,5,5,5));
                HBox duracion = new HBox();
                HBox hora = new HBox();
                HBox precio = new HBox();
                duracion.setAlignment(Pos.CENTER);
                hora.setAlignment(Pos.CENTER);
                precio.setAlignment(Pos.CENTER);
                Label lblDuracion = new Label("Duracion: "+vueloRegreso.getDuracionHoras()+" horas");
                Label lblHoraSalida = new Label(vueloRegreso.getHoraSalida());
                Label lblHoraLlegada = new Label(vueloRegreso.getHoraLlegada());
                Label lblPrecio = new Label(String.valueOf(vueloRegreso.getPrecioVuelo()));
                lblHoraSalida.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
                lblDuracion.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 20px; -fx-font-weight: bold;");
                lblHoraLlegada.setStyle("-fx-text-fill: black; -fx-font-family: 'Helvetica'; -fx-font-size: 18px; -fx-font-weight: bold;");
                lblPrecio.setStyle("-fx-text-fill: white; -fx-font-family: 'Helvetica'; -fx-font-size: 20px; -fx-font-weight: bold;");
                Bloom b = new Bloom();
                lblPrecio.setEffect(b);
                vb.setPadding(new Insets(12,12,12,12));
                vb.setSpacing(30);
                FileInputStream f = new FileInputStream("src/main/resources/images/menos.png");
                Image i = new Image(f,150,150,false,false);
                ImageView img= new ImageView(i);
                img.setPreserveRatio(true);
                duracion.getChildren().add(lblDuracion);  
                hora.getChildren().addAll(lblHoraSalida,img,lblHoraLlegada);
                precio.getChildren().add(lblPrecio);
                vb.setOnMouseClicked(e ->{          
                    TarifaVueloRegresoController.setVueloRegreso(vueloRegreso);
                    try {
                        cargarVentanaTarifas();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                vb.getChildren().addAll(duracion,hora,precio);
                contenedorVB.getChildren().addAll(top,vb,bottom);
                j+=1;
            }
        }
    }
    
    
    
    public void cargarVentanaTarifas() throws IOException{
        Stage s = (Stage)contenedorVB.getScene().getWindow();
        s.close();
        App.abrirNuevaVentana("tarifaVueloRegreso", 550, 700);
    }
    
    public void filtroComboBox(){
        ArrayList<Vuelo> vuelos = cargarVuelos();
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

    public static String getOrigenVRegreso() {
        return origenVRegreso;
    }

    public static void setOrigenVRegreso(String origenVRegreso) {
        VuelosRegresoController.origenVRegreso = origenVRegreso;
    }

    public static String getDestinoVRegreso() {
        return destinoVRegreso;
    }

    public static void setDestinoVRegreso(String destinoVRegreso) {
        VuelosRegresoController.destinoVRegreso = destinoVRegreso;
    }
    


    public static String getValorCB() {
        return valorCB;
    }

    public static void setValorCB(String valorCB) {
        VuelosRegresoController.valorCB = valorCB;
    }
    
}
