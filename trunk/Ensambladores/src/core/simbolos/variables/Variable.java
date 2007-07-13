/*
 * Variable.java
 *
 * Creado el 12 de julio de 2007, 21:10
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package core.simbolos.variables;

import java.util.Vector;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Variable {
    
  private String name;
  private String type;
  private Vector value = new Vector();
  private String direc;
    /** Crea una nueva instancia de Variable */
    public Variable(String nombre, String tipo, Vector valor,String direccion) {
        name=nombre;
        type=tipo;
        value=valor;
        direc=direccion;
    }
    
    public String getNombre(){
        return name;
    }
    public String getTipo(){
        return type;
    }
    public Vector getValue(){
        return value;
    }
    public String getDireccion(){
        return direc;
    }         
    
}
