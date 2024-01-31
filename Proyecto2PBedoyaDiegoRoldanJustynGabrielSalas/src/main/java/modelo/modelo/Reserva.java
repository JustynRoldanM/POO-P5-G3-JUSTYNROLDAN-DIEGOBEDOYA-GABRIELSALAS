
package modelo;
import com.pooespol.proyecto2pbedoyadiegoroldanjustyn.PagoController;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Justyn Roldan
 */
public class Reserva implements Pagable,Serializable{
    private String codigoReserva;
    private Cliente cliente;
    private Vuelo vueloIda;
    private Vuelo vueloRgereso;
    private int numeroPasajeros;
    private Tarifa tarifaIda;
    private Tarifa tarifaRegreso;
    private String fechaSalida;
    private String fechaRegreso;
    private double total;

    public Reserva(String codigoReserva, Cliente cliente, Vuelo vueloIda, Vuelo vueloRgereso, int numeroPasajeros, Tarifa tarifaIda, Tarifa tarifaRegreso,String fechaSalida,String fechaRegreso,double total) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.vueloIda = vueloIda;
        this.vueloRgereso = vueloRgereso;
        this.numeroPasajeros = numeroPasajeros;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
        this.fechaRegreso=fechaRegreso;
        this.fechaSalida=fechaSalida;
        this.total=total;
    }
    
    public static void escribirReserva(Reserva r){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/Files/reservas.txt",true));){
            bw.write(r.getCodigoReserva()+","+r.getCliente().getCedula()+","+r.getVueloIda().getOrigen()+","+
                    r.getVueloIda().getDestino()+","+r.getFechaSalida()+","+r.getFechaRegreso()+","+r.getNumeroPasajeros()+","+
                    r.getVueloIda().getNumVuelo()+","+r.getVueloRgereso().getNumVuelo()+","+r.getTarifaIda().getTipo()+","+r.getTarifaRegreso().getTipo()+","+r.getTotal()+"\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void serializarObjetoReserva(){
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("src/main/resources/ReservasSerializadas/"+this.getCodigoReserva()+".bin"))) {
            salida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Pago generarTransaccion(){
        Random random = new Random();
        int codigoPago=100000 + random.nextInt(900000);
        FormaPago f=null;
        if(PagoController.validarFormaPago==true){
            f = FormaPago.TARJETACREDITO;
        }else{
            f = FormaPago.EFECTIVO;
        }
        Pago pago = new Pago(codigoPago,f,this,PagoController.precioConDescuento,PagoController.descuentoValor);
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("src/main/resources/Files/pagos.txt",true))){
            bw.write(pago.getIdPago()+","+pago.getReserva().getCodigoReserva()+","+pago.getReserva().getTotal()+","+pago.getDescuento()+","+pago.getFormaPago()+","+pago.getTotalPagar()+"\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pago;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }
    

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
    
    @Override
    public String toString(){
        return codigoReserva+" - "+cliente.getNombre()+" "+cliente.getApellido();
    }

}