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
   
   public static Vector<String> arrayToVector(String[] arreglo){
       Vector<String> vector = new Vector<String>();
       for(String a : arreglo)
           vector.add(a);
       return vector;
   }
    
}
