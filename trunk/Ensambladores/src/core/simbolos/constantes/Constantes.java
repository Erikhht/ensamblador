/*
 * Constantes.java
 *
 * Created on 12 de julio de 2007, 10:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core.simbolos.constantes;

import java.util.Vector;

/**
 *
 * @author Franxo
 */
public class Constantes {
  private String nombre;
  private String tipo;
  private Vector valor = new Vector();  
    /** Creates a new instance of Constantes */
    public Constantes(String Nombre, String Tipo, Vector Valor) {
        nombre=Nombre;
        tipo=Tipo;
        valor=Valor;
    }
    
     public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public Vector getValue(){
        return valor;
    }
}
