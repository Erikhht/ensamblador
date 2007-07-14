/*
 * StringUtils.java
 *
 * Creado el 12 de julio de 2007, 10:18
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package util;

import java.util.Vector;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class StringUtils {
    
   /**
    * Toma un vecto de Strings y concatena cada una de sus elementos en un unico String
    * en el se ingluyen un salto de linea excepto en la ultima linea
    */
   public static String vectorToString(Vector<String> lineas){
       Object[] lineasCodigo = lineas.toArray();
       String codigo = "";
       for(int x = 0; x < lineasCodigo.length; x++){
           if( x == lineasCodigo.length - 1)
               codigo +=(String)lineasCodigo[x];
           else codigo +=(String)lineasCodigo[x] + "\n";
       }
       
       return codigo;
   }
   
   /**
    * Convierte un Vector de Strings en un arreglo de strings
    */
   public static Vector<String> arrayToVector(String[] arreglo){
       Vector<String> vector = new Vector<String>();
       for(String a : arreglo)
           vector.add(a);
       return vector;
   }
   
   /**
    * Toma los elementos de un Vector y los almacena en un string, separados por una coma cada uno
    */
   public static String vectorToLinearString(Vector<String> lineas){
       String linea = "";
       for(int x = 0; x < lineas.size(); x++){
           if(x == lineas.size() - 1)
               linea += lineas.get(x);
           else 
               linea += lineas.get(x) + ", ";
       }
       return linea;
   }
    
}
