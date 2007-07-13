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

import java.util.Vector;
import util.StringUtils;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Ensamblador {
    
    private Parser parser;
    
    /** Crea una nueva instancia de Ensamblador */
    public Ensamblador(String codigo) {
        this.parser = new Parser(codigo);
    }
    
    public Ensamblador(Parser parser){
        this.parser = parser;
    }
    
    /** 
     * Extrae el segmento de codigo del codigo fuente y cre aun String que contiene
     * el codigo en formato con saltos de linea
     */
    public String getCodeSegment(){
        Parser parser = this.parser.quitarComentarios(Parser.TOKEN_COMENTARIO);
        Vector<String> segmentoCodigo = parser.getSegment("code", "ends");
        return StringUtils.vectorString(segmentoCodigo);
    }
    
    public String getDataSegment(){
        Parser parser = this.parser.quitarComentarios(Parser.TOKEN_COMENTARIO);
        Vector<String> segmentoCodigo = parser.getSegment("data", "ends");
        return StringUtils.vectorString(segmentoCodigo);
    }
    
    public String getStackSegment(){
        Parser parser = this.parser.quitarComentarios(Parser.TOKEN_COMENTARIO);
        Vector<String> segmentoCodigo = parser.getSegment("stack", "ends");
        return StringUtils.vectorString(segmentoCodigo);
    }
    
    public Parser getParser(){
        return this.parser;
    }
    
    
}
