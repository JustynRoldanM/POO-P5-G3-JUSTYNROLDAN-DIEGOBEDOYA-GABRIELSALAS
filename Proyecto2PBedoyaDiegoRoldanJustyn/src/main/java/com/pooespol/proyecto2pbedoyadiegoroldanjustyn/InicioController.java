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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Cliente;


public class InicioController implements Initializable{ 
    
    private Boolean botonPresionado=false;
    @FXML
    private Pane paneLeft;
    
    @FXML
    private TextField txtPassVisible;
    
    @FXML
    private TextField txtPassNoVisible;
   
    @FXML
    private ImageView imgUser;
    
    @FXML
    private Pane panelRight;
    
    @FXML
    private TextField txtUser;
    @FXML
    private ImageView imgPass;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private CheckBox checkBox;
    
    @FXML
    private ImageView imgAvion;
    
    @FXML
    private ImageView imgLogin;
    
    @FXML
    private Label lblMensajeLogin;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarImagenes();
        btnLogin.setOnAction(e -> {
            if(txtPassNoVisible!=null){
                Boolean valor =validarUserContra(txtUser.getText(), String.valueOf(txtPassNoVisible.getCharacters()));
            }
            Boolean valor =validarUserContra(txtUser.getText(), txtPassVisible.getText());
        });
    }
    
    public void cambiarABienvenido() throws IOException{
        App.setRoot("bienvenido");
    }
    
    
    public void agregarImagenes(){
        try {
            FileInputStream f = new FileInputStream("src/main/resources/images/perfil.png");
            Image img = new Image(f);
            imgUser.setImage(img);
            FileInputStream f1 = new FileInputStream("src/main/resources/images/candado.png");
            Image img1 = new Image(f1);
            imgPass.setImage(img1);
            FileInputStream f3 = new FileInputStream("src/main/resources/images/avionmundo.png");
            Image img3 = new Image(f3);
            imgAvion.setImage(img3);
            FileInputStream f4 = new FileInputStream("src/main/resources/images/login.png");
            Image img4 = new Image(f4);
            imgLogin.setImage(img4);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
  
    
    public ArrayList<Cliente> cargarClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/clientes.txt"))){
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[] info = linea.split(";");
                clientes.add(new Cliente(Long.valueOf(info[0]),info[1],info[2],info[3],info[4]));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return clientes;
    }
    
    public static void abrirReservasCreadas() throws IOException{
        Stage ventana2 = new Stage();
        Scene scene = new Scene(App.loadFXML("reservasCreadas"),370,480);
        ventana2.setScene(scene);
        ventana2.setResizable(false);
        ventana2.setOnCloseRequest(e ->{
            e.consume();
        });
        ventana2.show();
    }
    
    public Cliente encontrarCliente(String user,String pass){
        ArrayList<Cliente> clientes = cargarClientes();
        for(Cliente c:clientes){
            if(c.getUser().equals(user) && c.getPassword().equals(pass)){
                return c;
            }
        }
        return null;
    }
    
    public Boolean validarUserContra(String user, String pass){
        Cliente c = encontrarCliente(user,pass);
        if(c!=null){ 
            try {
                BienvenidoController.setCliente(c);
                cambiarABienvenido(); 
                if (!botonPresionado) {
                     abrirReservasCreadas();       
                     botonPresionado = true;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
     return true;
        }
        else{
            lblMensajeLogin.setText("Usuario o contraseña incorrectas");
        }
        return false;
    }
    
    @FXML
    public void mostrarPassW(ActionEvent e){
      if(!checkBox.isSelected()){
          txtPassVisible.setVisible(false);
          txtPassNoVisible.setVisible(true);
          txtPassNoVisible.setText(txtPassVisible.getText());
      }else{
          txtPassVisible.setVisible(true);
          txtPassNoVisible.setVisible(false);
          txtPassVisible.setText(txtPassNoVisible.getText());
      }
    }

}


