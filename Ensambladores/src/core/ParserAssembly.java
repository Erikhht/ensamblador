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

import core.simbolos.variables.Variable;
import excepciones.InstruccionException;
import excepciones.SegmentNotFoundException;
import interfaces.Parser;
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
        //Elimina los comentarios del codigo para el resto de las operaciones con este codigo fuente
        codigo = this.quitarComentarios(ParserAssembly.TOKEN_COMENTARIO, codigo);
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
    
    /**
     * Separa una linea en palabras, omitiendo todos los espacios en blanco entre ellas
     */
    public Vector<String> quitarEspacios(String linea){
        String[] palabras =  linea.split(" ");
        Vector<String> palabrasSinEspacios = new Vector<String>();
        for(String s : palabras)
            if(!s.equals(""))
                palabrasSinEspacios.add(s);
        
        return palabrasSinEspacios;
    }
    
    public Vector<String> separarTresOperandos(String linea) throws InstruccionException{
        Vector<String> partesTemp = this.quitarEspacios(linea);
        if(partesTemp.size() < 2)
            throw new InstruccionException("Instruccion no valida");
        Vector<String> partes = new Vector<String>();
        //parte inicial
        partes.add(partesTemp.get(0));
        
        String[] temp;
        if(partesTemp.get(1).contains(",")){
            temp = partesTemp.get(1).split(",");
            partes.add(temp[0]);
            if(temp.length == 1)
                partes.add(partesTemp.get(2));
            else
                partes.add(temp[1]);
        }else if(partesTemp.get(2).contains(",")){
           if(partesTemp.get(2).equals(",")){
               partes.add(partesTemp.get(1));
               partes.add(partesTemp.get(3));
           }else if(partesTemp.get(2).contains(",")){
               temp = partesTemp.get(2).split(",");
               partes.add(temp[0]);
           }
        }
        
        return partes;
    }
    
    /**
     * Este metodo extrae el nombre de las variables y su tipo, del segmento de codigo
     */
    public Vector<Variable> getVariables() throws SegmentNotFoundException{
        Vector<Variable> variables = new Vector<Variable>();
        //Se obtiene el segmento de datos
        Vector<String> segmentoDatos = this.getVectorSegment(Ensamblador.DATA_SEGMENT);
        
        Vector<String> varTemp = new Vector<String>();
        for(String linea : segmentoDatos){
            varTemp = this.quitarEspacios(linea);
 //           variables = new Variable(varTemp[]);
        }
        return null;
    }
    
    public static void main(String[] arg){
        String cadena = ",";
        String cadena1 = "   una cadena  con varios   espacios    ;";
        
//        ParserAssembly parser = new ParserAssembly("");
//        Vector<String> palabras = parser.quitarEspacios(cadena);
//        
//        for(String s : palabras)
//            System.out.print("\""+s+"\",");
//        
//        System.out.println("");
//        String[] s = palabras.get(0).split(",");
//        for(String y : s)
//            System.out.print("\""+y+"\",");
        
        
        ParserAssembly parser = new ParserAssembly("");
        Vector<String> palabras = parser.quitarEspacios(cadena);
        Vector<String> vars = new Vector<String>();
        try {
            vars = parser.separarTresOperandos("mov ax  ,bx");
        } catch (InstruccionException ex) {
            ex.printStackTrace();
        }
        for(String s : vars)
            System.out.print(s+"///");
    }
}
