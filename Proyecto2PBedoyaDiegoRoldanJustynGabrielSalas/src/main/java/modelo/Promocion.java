package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Justyn Roldan
 */
public class Promocion {
    private double coordX;
    private double coordY;
    private String codigoPromocion;
    private String pais;
    private int descuento;

    public Promocion(double coordX, double coordY, String codigoPromocion, String pais, int descuento) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.codigoPromocion = codigoPromocion;
        this.pais = pais;
        this.descuento = descuento;
    }
    
    public static ArrayList<Promocion> cargarPromos(){
            ArrayList<Promocion> promociones = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Files/promociones.txt"))){
                String linea;
                while ((linea = br.readLine())!= null){
                    String[] info = linea.split(",");
                    Promocion promo = new Promocion(Double.valueOf(info[0]),Double.valueOf(info[1]),String.valueOf(info[2]),String.valueOf(info[3]),Integer.valueOf(info[4]));
                    promociones.add(promo);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return promociones;
     }
     
     public static Promocion buscarPromocion(String codigo, ArrayList<Promocion> promociones) throws CodigoInvalidoException {
        for (Promocion promo : promociones) {
            if (promo.getCodigoPromocion().equals(codigo)) {
                return promo;
            }
        }
        return null;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
    

    public String getCodigoPromocion() {
        return codigoPromocion;
    }

    public void setCodigoPromocion(String codigoPromocion) {
        this.codigoPromocion = codigoPromocion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
