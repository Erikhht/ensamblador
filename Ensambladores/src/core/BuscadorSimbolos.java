/*
 * BuscadorSimbolos.java
 *
 * Created on 14 de julio de 2007, 02:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core;

import core.simbolos.Constante;
import core.simbolos.Instruccion;
import core.simbolos.Variable;
import excepciones.SimboloNotFoundException;
import java.util.Vector;

/**
 *
 * @author Franxo
 */
public class BuscadorSimbolos {
    
    private Vector<Variable> variables;
    private Vector<Constante> constantes;
    private Vector<Instruccion> instrucciones;
    
    /**
     * Creates a new instance of BuscadorSimbolos
     */
    public BuscadorSimbolos(Vector<Variable> var, Vector<Constante> constantes, Vector<Instruccion> instrucciones) {
        this.variables = var;
        this.constantes = constantes;
        this.instrucciones = instrucciones;
    }
    
    public Variable buscarVariable(String nombre) throws SimboloNotFoundException{
        for(Variable v : this.variables){
            System.out.println("Variable "+v.getNombre());
            if(v.getNombre().equalsIgnoreCase(nombre))
                return v;
        }
        throw new SimboloNotFoundException("Variable no existente " + nombre);
    }
    
    public Constante buscarConstante(String nombre) throws SimboloNotFoundException{
        for(Constante c : this.constantes)
            if(c.getNombre().equalsIgnoreCase(nombre))
                return c;
        
        throw new SimboloNotFoundException("La constante no existe " + nombre);
    }
    
    public Instruccion buscarInstruccion(String nombre) throws SimboloNotFoundException{
        for(Instruccion in : this.instrucciones)
            if(in.getNombre().equalsIgnoreCase(nombre))
                return in;
        
        throw new SimboloNotFoundException("La instruccion no existe " + nombre);
    }
}
