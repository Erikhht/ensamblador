/*
 * Instruccion.java
 *
 * Creado el 13 de julio de 2007, 15:45
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package core.simbolos;

import java.util.Vector;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Instruccion {
    
    private String nombre;
    private Vector<String> parametros;
    private String Operando1;
    private String Operando2;
    
    /** Crea una nueva instancia de Instruccion */
    public Instruccion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vector<String> getParametros() {
        return parametros;
    }
    
    public String getOperando1(){
        return Operando1;
    }
    
    public String getOperando2(){
        return Operando2;
    }

    public void setParametros(Vector<String> parametros) {
        this.parametros = parametros;
    }
    
}
