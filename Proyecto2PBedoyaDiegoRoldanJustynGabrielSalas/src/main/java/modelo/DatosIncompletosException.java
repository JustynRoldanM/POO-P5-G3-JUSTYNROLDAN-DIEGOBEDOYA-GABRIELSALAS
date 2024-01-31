/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.IOException;

/**
 *
 * @author Justin Roldan
 */
public class DatosIncompletosException extends IOException{
    public DatosIncompletosException(String message) {
        super(message);
    }
}
