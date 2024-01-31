
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Justyn Roldan
 */
public class Tarifa implements Serializable{
    private String nombreTarifa;
    private ArrayList<String> caracteristicas= new ArrayList<>();
    private double incremento;
    private TipoTarifa tipo;

    public Tarifa(String nombreTarifa, TipoTarifa tipo, double incremento,ArrayList<String> caracteristicas) {
        this.nombreTarifa = nombreTarifa;
        this.tipo=tipo;
        this.incremento = incremento;
        this.caracteristicas=caracteristicas;
        this.tipo=tipo;
    }

    public TipoTarifa getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarifa tipo) {
        this.tipo = tipo;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public void setNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
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
