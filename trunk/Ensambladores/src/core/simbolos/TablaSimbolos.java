/*
 * TablaSimbolos.java
 *
 * Creado el 12 de julio de 2007, 21:00
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
public class TablaSimbolos {
    
    private Vector<String> seudoInstrucciones;
    
    private String nombre;
    private String tipo;   
    private Vector<String> valores = new Vector<String>();
    private String direccion;
    /** Crea una nueva instancia de TablaSimbolos */
    public TablaSimbolos() {
    }
    //*************** INFORMACION DE VARIABLES *************************
    public String getNomVar(Variable var){        
        nombre= var.getNombre();
        return nombre;
    }
    public String getTipoVar(Variable var){
        tipo= var.getTipo();
        return tipo;
    }
    public Vector<String> getValueVar(Variable var){
        valores= var.getValue();
        return valores;
    }
    public String getDirVar(Variable var){
        direccion=var.getDireccion();
        return direccion;
    }
    
    //*************** INFORMACION DE CONSTANTES *************************
    public String getNomCte(Constantes cte){        
        nombre= cte.getNombre();
        return nombre;
    }
    public String getTipoCte(Constantes cte){
        tipo= cte.getTipo();
        return tipo;
    }
    public Vector<String> getValueCte(Constantes cte){
        valores= cte.getValue();
        return valores;
    }  
    
    
    //************** INFROMACION DE ETIQUETAS *****************************
    public String getNomEtq(Etiqueta etq){        
        nombre= etq.getNombre();
        return nombre;
    }
    public String getTipoEtq(Etiqueta etq){
        tipo= etq.getTipo();
        return tipo;
    }
    public String getDirEtq(Etiqueta etq){
        direccion=etq.getDireccion();
        return direccion;
    }
    
}
