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
import java.util.Vector;

/**
 *
 * @author Franxo
 */
public class BuscadorVariable {
    private Vector<Variable> variable = new Vector<Variable>();
    /** Creates a new instance of BuscadorVariable */
    public BuscadorVariable(Variable var) {
        variable.add(var);
    }
    public String getVarFind(String var){
        String varenc = null;
        Variable comparacion = null;
        String other;
        TipoVariable tipo;
        for(int i=0;i<variable.size();i++){
            other=variable.elementAt(i).getNombre();
            if(other==var){
                tipo=comparacion.getTipo();
                varenc=tipo.getTipo();
            }
        }                
        return varenc;
    }       
}
