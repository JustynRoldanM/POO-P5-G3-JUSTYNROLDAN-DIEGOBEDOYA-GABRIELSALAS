/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Justin Roldan
 */
public class CodigoInvalidoException extends RuntimeException{
    public CodigoInvalidoException(String mensaje){
        super(mensaje);
    }
}
