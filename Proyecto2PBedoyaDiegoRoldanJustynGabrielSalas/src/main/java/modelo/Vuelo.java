package modelo;

import com.pooespol.proyecto2pbedoyadiegoroldanjustyn.ReservaVueloController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Justyn Roldan
 */
public class Vuelo implements Comparable<Vuelo>,Serializable{
    private String origen;
    private String destino;
    private double duracionHoras;
    private String horaSalida;
    private String horaLlegada;
    private String numVuelo;
    private String codigoAvion;
    private double precioVuelo;

    public Vuelo(String origen, String destino, double duracionHoras, String horaSalida, String horaLlegada, String numVuelo, String codigoAvion, double precioVuelo) {
        this.origen = origen;
        this.destino = destino;
        this.duracionHoras = duracionHoras;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.numVuelo = numVuelo;
        this.codigoAvion = codigoAvion;
        this.precioVuelo = precioVuelo;
    }
    
    

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public double getPrecioVuelo() {
        return precioVuelo;
    }

    public void setPrecioVuelo(double precioVuelo) {
        this.precioVuelo = precioVuelo;
    }

    @Override
    public int compareTo(Vuelo o) {
        int comparacion=0;
        if(ReservaVueloController.getValorCB().equals("precio")){
            comparacion= Double.compare(this.precioVuelo,o.getPrecioVuelo());
        }else{
            comparacion = Double.compare(this.duracionHoras,o.getDuracionHoras());
        }
        return comparacion;
    }
}
