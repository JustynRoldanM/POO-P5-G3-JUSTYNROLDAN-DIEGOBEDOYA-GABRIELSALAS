
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Justyn Roldan
 */
public class Destino {
    private String ciudad;
    private String pais;

    public Destino(String ciudad, String pais) {
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
     public static ArrayList<Destino> cargarDestinos(){
        ArrayList<Destino> destinos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/destinos.txt"))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] info = linea.split(",");
                Destino d = new Destino(info[0],info[1]);
                destinos.add(d);
            }
        }catch(IOException e){
        }
        return destinos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return ciudad;
    }
    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
