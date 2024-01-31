package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class Cliente implements Serializable{
    private long cedula;
    private String nombre;
    private String apellido;
    private String user;
    private String password;

    public Cliente(long cedula, String nombre, String apellido, String user, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.password = password;
    }
    
       public static ArrayList<Cliente> cargarClientes(){
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
    
    public static Cliente buscarCliente(long cedula){
        ArrayList<Cliente> clientes=cargarClientes();
        for(Cliente c: clientes){
            if(c.getCedula()==cedula){
                return c;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}