/*
 * NombreInstruccion.java
 *
 * Created on 14 de julio de 2007, 0:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core.simbolos;

/**
 *
 * @author Hugo
 */
public enum NombreInstruccion {
    MOV("mov"),
    ADD("add"),
    LEA("lea"),
    JMP("jmp"),
    INT("int"),
    AND("and");
    
    private String nombre;
    NombreInstruccion(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
