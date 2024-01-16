
package modelo;

/**
 *
 * @author Justyn Roldan
 */
public class Promocion {
    private double coordX;
    private double coordY;
    private String codigoPromocion;
    private String pais;
    private double descuento;

    public Promocion(double coordX, double coordY, String codigoPromocion, String pais, double descuento) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.codigoPromocion = codigoPromocion;
        this.pais = pais;
        this.descuento = descuento;
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
