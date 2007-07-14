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

import core.ParserAssembly;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Instruccion {
    
    public static final int OP1 = 1;
    public static final int OP2 = 2;
    
    private String nombre;
    private String operando1;
    private String operando2;
    
    /** Crea una nueva instancia de Instruccion */
    public Instruccion(String nombre, String op1, String op2) {
        this.nombre = nombre;
        this.operando1 = op1;
        this.operando2 = op2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getOperando1(){
        return operando1;
    }
    
    public void setoperando2(String op){
        operando2=op;
    }
    public void setoperando1(String op){
        operando1=op;
    }
    
    public String getOperando2(){
        return operando2;
    }

    /**
     * Si el operando es un digito, lo devuelve en su forma hexadecimal
     * Dicho digito, debe estar en base 10
     */
    public String getOpHex(int op){
        String operando = "";
        if(op == OP1)   operando = this.operando1;
        else if(op == OP2)  operando = this.operando2;
        
        int numero = ParserAssembly.hexaToInt(operando);
        return Integer.toHexString(numero);

    }
    
    public String getOpBin(int op){
        String operando = "";
        if(op == OP1)   operando = this.operando1;
        else if(op == OP2)  operando = this.operando2;
        
        int numero = ParserAssembly.hexaToInt(operando);
        return Integer.toBinaryString(numero);
    }

}
