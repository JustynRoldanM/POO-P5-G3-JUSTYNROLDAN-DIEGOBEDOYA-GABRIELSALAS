
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Justyn Roldan
 */
public class Tarifa {
    private String nombreTarifa;
    private String descripcion;
    private ArrayList<String> caracteristicas= new ArrayList<>();
    private double incremento;

    public Tarifa(String nombreTarifa, String descripcion, double incremento,ArrayList<String> caracteristicas) {
        this.nombreTarifa = nombreTarifa;
        this.descripcion = descripcion;
        this.incremento = incremento;
        this.caracteristicas=caracteristicas;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public void setNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getIncremento() {
        return incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }
    
}
