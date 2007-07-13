/*
 * Parser.java
 *
 * Created on 12 de julio de 2007, 20:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package interfaces;

import core.*;
import excepciones.SegmentNotFoundException;
import java.util.Vector;

/**
 *
 * @author Hugo
 */
public interface Parser {
    
    String TOKEN_COMENTARIO = ";";

    Vector<String> extraerSegmento(int inicioSegmento, int finSegmento);

    Vector<String> getCodigo();

    /**
     * Retorna el numero de lineas basadas en cada salto de linea
     * del archivo fuente
     */
    int getNumeroLineas();

    Vector<String> getSegment(String inicioSegmento, String finSegmento);

    /**
     * 
     * Extrae el segmento especificado del codigo fuente y cre aun String que contiene
     * el codigo en formato con saltos de linea
     */
    String getSegment(int segment) throws SegmentNotFoundException;

    /**
     * Devueve el segmento de datos especificado de acuerdo a la sintaxis definida
     * Para ello se deben usar las variables estaticas de la clase
     * CODE_SEGMENT, DATA_SEGMENT, STACK_SEGMENT.
     */
    Vector<String> getVectorSegment(int segment) throws SegmentNotFoundException;

    /**
     * Retira los comentatios del codigo y crea una nueva instancia con el codig sin comentarios
     */
    ParserAssembly quitarComentarios(String token);

    /**
     * Crea un nuevo vector sin comentarios identificados por el token dado
     */
    Vector<String> quitarComentarios(String token, Vector<String> segmento);
    
    
    
}
