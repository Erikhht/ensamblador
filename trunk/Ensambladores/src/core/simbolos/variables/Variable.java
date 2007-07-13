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
    

    private String nombre;
    private String tipo;
    /**Vector con los valores de inicializacion de la variable*/
    private Vector<String> valores = new Vector<String>();
    private String direccion;

    /** Crea una nueva instancia de Variable */
    public Variable(String nombre, String tipo, Vector valor,String direccion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valores = valor;
        this.direccion = direccion;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public Vector<String> getValue(){
        return valores;
    }
    public String getDireccion(){
        return direccion;
    }         
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
}
