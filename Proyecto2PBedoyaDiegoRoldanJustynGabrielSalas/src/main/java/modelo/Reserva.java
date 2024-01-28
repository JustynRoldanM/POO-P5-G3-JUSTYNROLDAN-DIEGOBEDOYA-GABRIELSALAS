
package modelo;

/**
 *
 * @author Justyn Roldan
 */
public class Reserva implements Pagable{
    private int codigoReserva;
    private Cliente cliente;
    private Vuelo vueloIda;
    private Vuelo vueloRgereso;
    private int numeroPasajeros;
    private Tarifa tarifaIda;
    private Tarifa tarifaRegreso;

    public Reserva(int codigoReserva, Cliente cliente, Vuelo vueloIda, Vuelo vueloRgereso, int numeroPasajeros, Tarifa tarifaIda, Tarifa tarifaRegreso) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.vueloIda = vueloIda;
        this.vueloRgereso = vueloRgereso;
        this.numeroPasajeros = numeroPasajeros;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
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

    public Vuelo getVueloIda() {
        return vueloIda;
    }

    public void setVueloIda(Vuelo vueloIda) {
        this.vueloIda = vueloIda;
    }

    public Vuelo getVueloRgereso() {
        return vueloRgereso;
    }

    public void setVueloRgereso(Vuelo vueloRgereso) {
        this.vueloRgereso = vueloRgereso;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Tarifa getTarifaIda() {
        return tarifaIda;
    }

    public void setTarifaIda(Tarifa tarifaIda) {
        this.tarifaIda = tarifaIda;
    }

    public Tarifa getTarifaRegreso() {
        return tarifaRegreso;
    }

    public void setTarifaRegreso(Tarifa tarifaRegreso) {
        this.tarifaRegreso = tarifaRegreso;
    }

}