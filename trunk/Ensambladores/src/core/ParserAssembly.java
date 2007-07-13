/*
 * ParserAssembly.java
 *
 * Creado el 12 de julio de 2007, 0:46
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
public class ParserAssembly implements Parser {
    
    /**
     * Variable que almacena cada linea de codigo en un vector de strings
     */
    private final Vector<String> codigo;
    
    /**
     * Crea una nueva instancia de ParserAssembly
     */
    public ParserAssembly(String codigo) {
        this(ParserAssembly.quitarSaltosLinea(codigo));
    }
    
    public ParserAssembly(Vector<String> codigo){
        this.codigo = codigo;
    }
    
       /** 
     * Extrae el segmento especificado del codigo fuente y cre aun String que contiene
     * el codigo en formato con saltos de linea
     */
    public String getSegment(int segment) throws SegmentNotFoundException{
        return StringUtils.vectorString(this.getVectorSegment(segment));
    }
    
    /**
     * Devueve el segmento de datos especificado de acuerdo a la sintaxis definida
     * Para ello se deben usar las variables estaticas de la clase
     * CODE_SEGMENT, DATA_SEGMENT, STACK_SEGMENT.
     */
    public Vector<String> getVectorSegment(int segment) throws SegmentNotFoundException{
        ParserAssembly parser = this.quitarComentarios(ParserAssembly.TOKEN_COMENTARIO);
        if(segment == Ensamblador.CODE_SEGMENT)
            return parser.getSegment("code", "ends");
        else if(segment == Ensamblador.DATA_SEGMENT)
            return parser.getSegment("data", "ends");
        else if(segment == Ensamblador.STACK_SEGMENT)
            return parser.getSegment("stack", "ends");
        throw new SegmentNotFoundException("Tipo de segmento no v‡lido");
    }
    
    /**
     * A partir de cualquier codigo fuente, los divide en lineas
     */
    public static Vector<String> quitarSaltosLinea(String codigo){
        Vector<String> lineas = new Vector<String>();
        String[] lineasArray = codigo.split("\n");
        for(String linea : lineasArray)
            lineas.add(linea);
        return lineas;
    }
    
    public Vector<String> getSegment(String inicioSegmento, String finSegmento){
        int posInicioSegmento = 0;
        int posFinSegmento = 0;
        for(int x = 0; x < this.codigo.size(); x++){
            if(this.codigo.get(x).contains(inicioSegmento)){
                posInicioSegmento = x + 1;
                break;
            }
        }
        for(int x = posInicioSegmento + 1; x < this.codigo.size(); x++){
            if(this.codigo.get(x).contains(finSegmento)){
                posFinSegmento = x - 1;
                break;
            }
        }
        Vector<String> lineasSegmento = this.extraerSegmento(posInicioSegmento, posFinSegmento);
        return lineasSegmento;
    }
    
    public Vector<String> extraerSegmento(int inicioSegmento, int finSegmento){
        Vector<String> segmento = new Vector<String>();
        for(int x = inicioSegmento; x <= finSegmento; x++)
            segmento.add(this.codigo.get(x));
        return segmento;
    }
    
    public ParserAssembly quitarComentarios(String token){
        Vector<String> codigo = new Vector<String>();
        String[] temp;
        for(int x = 0; x < this.codigo.size(); x++){
            temp = this.codigo.get(x).split(token);
            codigo.add(temp[0]);
        }   
        return new ParserAssembly(codigo);
    }
    
    /**
     * Crea un nuevo vector sin comentarios identificados por el token dado
     */
    public Vector<String> quitarComentarios(String token, Vector<String> segmento){
        Vector<String> codigo = new Vector<String>();
        String[] temp;
        for(int x = 0; x < segmento.size(); x++){
            temp = segmento.get(x).split(token);
            codigo.add(temp[0]);
        }   
        return codigo;
    }
    
    public Vector<String> getCodigo(){
        return this.codigo;
    }
    
    /**
     * Retorna el numero de lineas basadas en cada salto de linea
     * del archivo fuente
     */
    public int getNumeroLineas(){
        return this.codigo.size();
    }
}
