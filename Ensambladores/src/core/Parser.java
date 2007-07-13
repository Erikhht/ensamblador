/*
 * Parser.java
 *
 * Creado el 12 de julio de 2007, 0:46
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package core;

import archivo.GestorArchivos;
import java.util.Vector;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Parser {
    
    public static final String TOKEN_COMENTARIO = ";";
    
    /**
     * Variable que almacena cada linea de codigo en un vector de strings
     */
    private final Vector<String> codigo;
    
    /** Crea una nueva instancia de Parser */
    public Parser(String codigo) {
        this(Parser.quitarSaltosLinea(codigo));
    }
    
    public Parser(Vector<String> codigo){
        this.codigo = codigo;
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
    
    /**
     * Metodo auxiliar que no usa atributos de la clase
     */
//    public Vector<String> getSegment(String archivoLineas, String inicioSegmento, String finSegmento){
//        Vector<String> lineas = this.quitarSaltosLinea(archivoLineas);
//        int posInicioSegmento = 0;
//        int posFinSegmento = 0;
//        for(int x = 0; x < lineas.size(); x++){
//            if(lineas.get(x).contains(inicioSegmento)){
//                posInicioSegmento = x + 1;
//                break;
//            }
//        }
//        
//        for(int x = posInicioSegmento + 1; x < lineas.size(); x++){
//            if(lineas.get(x).contains(finSegmento)){
//                posFinSegmento = x - 1;
//                break;
//            }
//        }
//        
//        Vector<String> lineasSegmento = this.extraerSegmento(posInicioSegmento, posFinSegmento);
//        return lineasSegmento;
//        
//    }
    
    public Vector<String> extraerSegmento(int inicioSegmento, int finSegmento){
        Vector<String> segmento = new Vector<String>();
        for(int x = inicioSegmento; x <= finSegmento; x++)
            segmento.add(this.codigo.get(x));
        return segmento;
    }
    
    public Parser quitarComentarios(String token){
        Vector<String> codigo = new Vector<String>();
        String[] temp;
        for(int x = 0; x < this.codigo.size(); x++){
            temp = this.codigo.get(x).split(token);
            codigo.add(temp[0]);
        }   
        return new Parser(codigo);
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
