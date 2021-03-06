/*
 * Array.java
 *
 * Created on 9 de abril de 2007, 05:14 PM
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package util;

import java.util.Vector;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Array {
    
    /**
     * Tranforma un vector de Strings a un arreglo de Strings
     */
    public static String[] toArray(Vector vector){
        Object[] o = vector.toArray();
        String[] s = new String[vector.size()];
        
        for(int x = 0; x < s.length ; x++)
            s[x] = (String)o[x];
        
        return s;
    }
    
    /**
     * Transforma un arreglo de Objects, los cuales son unicamente strings, en un vector de Strings
     * En caso de que el arreglo de objects tuviera un objeto distinto a un String, entonces se tomara la representacion
     * en String de dicho valor.
     */
    public static Vector<String> toVector(Object[] strings){
        Vector<String> vector = new Vector<String>();
        for(int x = 0; x < strings.length; x++)
            vector.add((String)strings[x]);
        return vector;
    }
    
    /**
     * Convierte un arreglo de Strings en un Vector<String>
     */
    public static Vector<String> toVector(String[] strings){
        Vector<String> vector = new Vector<String>();
        for(String x : strings) vector.add(x);
        return vector;
    }
}
