/*
 * TipoVariable.java
 *
 * Created on 12 de julio de 2007, 21:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package core.simbolos;

/**
 *
 * @author Hugo
 */
public enum TipoVariable {
    BYTE("db"),
    WORD("dw");
    
    private final String tipo;
    TipoVariable(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
}
