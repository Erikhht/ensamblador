/*
 * Constante.java
 *
 * Created on 12 de julio de 2007, 10:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core.simbolos;

import java.util.Vector;

/**
 *
 * @author Franxo
 */
public class Constante {
  private String nombre;
  private String tipo;
  private String valor;
    /**
     * Creates a new instance of Constante
     */
    public Constante(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public String getNombre(){
        return nombre;
    }
  
    public String getValor(){
        return valor;
    }
}
