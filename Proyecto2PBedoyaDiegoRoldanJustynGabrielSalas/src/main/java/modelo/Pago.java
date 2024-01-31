package modelo;

/**
 *
 * @author Justyn Roldan
 */
public class Pago {
    private int idPago;
    private FormaPago formaPago;
    private Reserva reserva;
    private double totalPagar;
    private double descuento;

    public Pago(int idPago, FormaPago formaPago, Reserva reserva, double totalPagar, double descuento) {
        this.idPago = idPago;
        this.formaPago = formaPago;
        this.reserva = reserva;
        this.totalPagar = totalPagar;
        this.descuento = descuento;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}