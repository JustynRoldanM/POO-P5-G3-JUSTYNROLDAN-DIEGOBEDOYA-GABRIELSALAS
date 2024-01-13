
package modelo;

/**
 *
 * @author Justyn Roldan
 */
public class Reserva implements Pagable{
    private int codigoReserva;
    private Cliente cliente;
    private Vuelo vuelo;
    private int numeroPasajeros;
    private Tarifa tarifa;

    public Reserva(int codigoReserva, Cliente cliente, Vuelo vuelo, int numeroPasajeros, Tarifa tarifa) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.numeroPasajeros = numeroPasajeros;
        this.tarifa = tarifa;
    }
    
    @Override
    public Pago generarTransaccion(){
        Pago pago = null;
        return pago;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
    
}
