
package modelo;

/**
 *
 * @author Justyn Roldan
 */
public class Cliente {
    private long cedula;
    private String nombre;
    private String apellido;
    private String user;
    private String password;

    public Cliente(long cedula, String nombre, String apellido, String user, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.password = password;
    }
    
    @Override
    public String toString(){
        return nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
