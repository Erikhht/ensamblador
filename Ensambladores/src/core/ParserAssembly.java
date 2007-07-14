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

import core.simbolos.Constante;
import core.simbolos.TipoVariable;
import core.simbolos.Variable;
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
    
    public static final String EQU = "equ";
    
    /**
     * Variable que almacena cada linea de codigo en un vector de strings
     */
    private final Vector<String> codigo;
    private final Vector<String> comentarios;
    
    /**
     * Crea una nueva instancia de ParserAssembly
     */
    public ParserAssembly(String codigo) {
        this(ParserAssembly.quitarSaltosLinea(codigo.toLowerCase()));
    }
    
    public ParserAssembly(Vector<String> codigo){
        this.comentarios = this.getComentariosToken(ParserAssembly.TOKEN_COMENTARIO, codigo);
        //Elimina los comentarios del codigo para el resto de las operaciones con este codigo fuente
        codigo = this.quitarComentarios(ParserAssembly.TOKEN_COMENTARIO, codigo);
        this.codigo = codigo;
    }
    
       /** 
     * Extrae el segmento especificado del codigo fuente y cre aun String que contiene
     * el codigo en formato con saltos de linea
     */
    public String getSegment(int segment) throws SegmentNotFoundException{
        return StringUtils.vectorToString(this.getVectorSegment(segment));
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
            if(linea.trim().length() != 0) lineas.add(linea);
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
    
    public Vector<String> getComentarios(){
        return this.comentarios;
    }
    
    public Vector<String> getComentariosToken(String token, Vector<String> codigo){
        Vector<String> comentarios = new Vector<String>();
        String[] temp;
        for(int x = 0; x < codigo.size(); x++){
            temp = codigo.get(x).split(token);
            if(temp.length >= 2)
                comentarios.add(temp[1]);
        }   
        return comentarios;
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
               partes.add(partesTemp.get(1));
               partes.add(temp[1]);
           }
        }
        return partes;
    }
       
    /**
     * Obtiene el nombre y valor de las variables, las cuales deben estar en el siguiente formato
     * var tipo valor
     */
    public Variable getVariable(String linea, int direccion) throws InstruccionException{
        Vector<String> partesTemp = this.quitarEspacios(linea);
        
        //se comprueba que al menos sean 3 operandos
        if(partesTemp.size() < 3)
            throw new InstruccionException("Instruccion no valida");
        Vector<String> partes = new Vector<String>();
        
        //parte inicial
        partes.add(partesTemp.get(0));
        
        //tipo de la variable
        partes.add(partesTemp.get(1));
        
        //Agregamos la ultima parte
        partes.add(partesTemp.get(2));
        //Se crea una sola parte en caso de que haya varios espacios
        for(int x = 3; x < partesTemp.size(); x++)
            partes.set(2, partes.get(2) + partesTemp.get(x));
        
        String[] valores = partes.get(2).split(",");
        TipoVariable tipo = TipoVariable.BYTE;
        if(partes.get(1).equals(TipoVariable.BYTE.getTipo()))
            tipo = TipoVariable.BYTE;
        else if(partes.get(1).equals(TipoVariable.WORD.getTipo()))
            tipo = TipoVariable.WORD;
        Variable variable = new Variable(partes.get(0), tipo, StringUtils.arrayToVector(valores), direccion);

        return variable;
    }
    
    /**
     * Este metodo extrae el nombre de las variables y su tipo, del segmento de codigo
     */
    public Vector<Variable> getVariables() throws SegmentNotFoundException{
        Vector<Variable> variables = new Vector<Variable>();
        
        //Se obtiene el segmento de datos
        Vector<String> segmentoDatos = this.getVectorSegment(Ensamblador.DATA_SEGMENT);
        
        for(String linea : segmentoDatos){
            if(linea.contains(EQU)) continue;
            try {
                //la direccion del contador del programa es puesta a cero 
                variables.add(this.getVariable(linea, 0));
            } catch (InstruccionException ex) {
                ex.printStackTrace();
            }
        }
        return variables;
    }
    
    public Constante getConstante(String linea){
        Vector<String> partes = this.quitarEspacios(linea);
        return new Constante(partes.get(0), partes.get(2));
            
    }
    
    /**
     * 
     */
    public Vector<Variable> establecerContadorDataSegment() throws SegmentNotFoundException{
        Vector<Variable> variables = this.getVariables();
        int counter = 0;
        for(Variable var : variables){
            int n = this.contarValores(var.getTipo(), var.getValores());
            counter += n;
            var.setDireccion(counter);
        }
        
        return variables;
    }
    
    private int contarValores(TipoVariable tipo, Vector<String> valores){
        int contador = 0;
            
        //Caso en que el valor pueda ser un numero decimao o hexadecimal o sean varios 
        if(valores.size() == 1){
            //Si se trata de inializacion con dup, se hace la suma correspondiente para dup
            if(valores.get(0).contains("dup")){
                String[] cadena = valores.get(0).split("dup");
                contador = Integer.parseInt(cadena[0]);

            //en caso de que sea un numero decimal o hexadecimal
            }else{
                String cadena = valores.get(0);
                char[] cadenaChar = cadena.toCharArray();
                if(cadenaChar[cadenaChar.length - 1] == 'h'){
                    cadena = "";
                    for(int x = 0; x < cadenaChar.length - 1; x++ )
                        cadena += cadenaChar[x];
                    contador = Integer.parseInt(cadena, 16);
                }else{
                    contador = Integer.parseInt(cadena);
                }
            } 
        }else{
            contador = valores.size();
        }
        if(tipo == TipoVariable.WORD)
            contador *= 2;
        return contador;
    }
    
    public Vector<Constante> getConstantes(){
        Vector<Constante> constantes = new Vector<Constante>();
        for(String linea : this.codigo)
            if(linea.contains(EQU))
                constantes.add(this.getConstante(linea));
        
        return constantes;
    }
    
//    public Vector<Instruccion> getInstrucciones(){
//        
//    }
    
/**    public static void main(String[] arg){
        ParserAssembly parser = new ParserAssembly("");
        Vector<String> valores = new Vector<String>();
        try {
            
            Variable variable = parser.getVariable("var db a,   b, c,w,  qw   ", 34);
            Vector<String> s = variable.getValores();
            for(String d : s)
                System.out.print(d+"///");
            System.out.println("\n"+variable.getNombre());
            System.out.println("\n"+variable.getTipo());
                    
        } catch (InstruccionException ex) {
            ex.printStackTrace();
        }
        
    }**/
    
/**    public static void main(String[] arg){
        String cadena = ",bx";
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
            vars = parser.separarTresOperandos("mov ax,bx");
        } catch (InstruccionException ex) {
            ex.printStackTrace();
        }
        for(String s : vars)
            System.out.print(s+"///");
    }
 */
    
    public static void main(String[] arg){
        String cadena = "1234he";
        char[] cadenaChar = cadena.toCharArray();
        if(cadenaChar[cadenaChar.length - 1] == 'h'){
            cadena = "";
            for(int x = 0; x < cadenaChar.length - 1; x++ )
                cadena += cadenaChar[x];
        }   
        System.out.println(cadena);
    }
}
