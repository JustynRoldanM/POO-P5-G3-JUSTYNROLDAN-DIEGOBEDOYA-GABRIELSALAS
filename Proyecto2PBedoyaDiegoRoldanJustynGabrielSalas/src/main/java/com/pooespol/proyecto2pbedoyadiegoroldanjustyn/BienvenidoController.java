
package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author Justyn Roldan
 */
public class BienvenidoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static Cliente cliente;
    
    @FXML
    private Label lblNombre;
    
    @FXML
    private Label lblBienvenido;
    
    @FXML
    private Button btnPromociones;
    
    @FXML
    private Button btnReservar;
    
    @FXML
    private ImageView fondoMapa;
    
    @FXML
    private Pane paneLeft;
    
    @FXML
    private Pane paneRight;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarImagenes();
        setearLabels();
        
        btnPromociones.setOnAction(e ->{
            try {
                App.setRoot("promociones");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btnReservar.setOnAction(e ->{
            try {
                App.setRoot("reservas");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
    }    
    

    
    public void setearLabels(){
        lblNombre.setText(cliente.getNombre());
        if(cliente.getNombre().charAt(cliente.getNombre().length()-1)=='a'){
            lblBienvenido.setText("Bienvenida");
        }else{
            lblBienvenido.setText("Bienvenido");
        }
    }
    
   
 
    
     public void agregarImagenes(){
        try {
            FileInputStream f = new FileInputStream("src/main/resources/images/viajescollage.jpg");
            Image img = new Image(f);
            fondoMapa.setImage(img);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        BienvenidoController.cliente = cliente;
    }
    
    
}
