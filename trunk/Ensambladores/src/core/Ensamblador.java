/*
 * Ensamblador.java
 *
 * Creado el 12 de julio de 2007, 11:47
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package core;

import excepciones.SegmentNotFoundException;
import java.util.Vector;
import util.StringUtils;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Ensamblador {
    
    public static int CODE_SEGMENT = 0;
    public static int DATA_SEGMENT = 1;
    public static int STACK_SEGMENT = 2;
    
    private ParserAssembly parser;
    
    /** Crea una nueva instancia de Ensamblador */
    public Ensamblador(String codigo) {
        this.parser = new ParserAssembly(codigo);
    }
    
    public Ensamblador(ParserAssembly parser){
        this.parser = parser;
    }
    
    public Ensamblador(){
        
    }
    
    public ParserAssembly getParser(){
        return this.parser;
    }
    
    
}
