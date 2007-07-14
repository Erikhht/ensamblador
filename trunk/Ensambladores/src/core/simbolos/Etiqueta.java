/*
 * Etiqueta.java
 *
 * Created on 13 de julio de 2007, 12:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core.simbolos;

/**
 *
 * @author Franxo
 */
public class Etiqueta {
    private String nombre;
    private String tipo;
    private String direccion;
    /**
     * Creates a new instance of Etiqueta
     */
    public Etiqueta() {
    }
      public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public String getDireccion(){
        return direccion;
    }         
}
