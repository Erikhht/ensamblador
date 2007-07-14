/*
 * BuscadorVariable.java
 *
 * Created on 14 de julio de 2007, 02:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core;

import core.simbolos.TipoVariable;
import core.simbolos.Variable;
import excepciones.VariableNotFoundException;
import java.util.Vector;

/**
 *
 * @author Franxo
 */
public class BuscadorVariable {
    
    private Vector<Variable> variables;
    
    /** Creates a new instance of BuscadorVariable */
    public BuscadorVariable(Vector<Variable> var) {
        this.variables = var;
    }
    
    public Variable buscarVariable(String nombre) throws VariableNotFoundException{
        for(Variable v : this.variables)
            if(v.getNombre().equalsIgnoreCase(nombre))
                return v;
        throw new VariableNotFoundException("Variable no existente");
    }
}
