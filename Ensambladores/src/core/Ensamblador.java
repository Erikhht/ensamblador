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
    
    private Parser parser;
    
    /** Crea una nueva instancia de Ensamblador */
    public Ensamblador(String codigo) {
        this.parser = new Parser(codigo);
    }
    
    public Ensamblador(Parser parser){
        this.parser = parser;
    }
    
    /** 
     * Extrae el segmento especificado del codigo fuente y cre aun String que contiene
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
    
    public String getSegment(int segment) throws SegmentNotFoundException{
        return StringUtils.vectorString(this.getVectorSegment(segment));
    }
    
    /**
     * Devueve el segmento de datos especificado de acuerdo a la sintaxis definida
     * Para ello se deben usar las variables estaticas de la clase
     * CODE_SEGMENT, DATA_SEGMENT, STACK_SEGMENT.
     */
    public Vector<String> getVectorSegment(int segment) throws SegmentNotFoundException{
        Parser parser = this.parser.quitarComentarios(Parser.TOKEN_COMENTARIO);
        if(segment == Ensamblador.CODE_SEGMENT)
            return parser.getSegment("code", "ends");
        else if(segment == Ensamblador.DATA_SEGMENT)
            return parser.getSegment("data", "ends");
        else if(segment == Ensamblador.STACK_SEGMENT)
            return parser.getSegment("stack", "ends");
        throw new SegmentNotFoundException("Tipo de segmento no v‡lido");
    }
    
    public Parser getParser(){
        return this.parser;
    }
    
    
}
