
package modelo;

/**
 *
 * @author Justyn Roldan
 */
public class Promocion {
    private int codigoPromocion;
    private double descuento;
    private String pais;

    public Promocion(int codigoPromocion, double descuento, String pais) {
        this.codigoPromocion = codigoPromocion;
        this.descuento = descuento;
        this.pais = pais;
    }

    public int getCodigoPromocion() {
        return codigoPromocion;
    }

    public void setCodigoPromocion(int codigoPromocion) {
        this.codigoPromocion = codigoPromocion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
