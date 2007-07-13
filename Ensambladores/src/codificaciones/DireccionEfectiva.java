/*
 * DireccionEfectiva.java
 *
 * Created on 13 de julio de 2007, 12:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package codificaciones;

/**
 *
 * @author Franxo
 */
public class DireccionEfectiva {
    private static String direccion_efectiva[] = {"[bx+si]","00","000",   
                                               "[bx+di]","00","001",
                                               "[bp+si]","00","010",
                                               "[bp+di]","00","011",
                                               "[si]","00","100",
                                               "[di]","00","101",
                                               "DIRECTA","00","110",
                                               "[bx]","00","111",
                                               "[si+d8]","01","100",
                                               "[di+d8]","01","101",
                                               "[bp+d8]","01","110",
                                               "[bx+d8]","01","111"
                                               };       
    /** Creates a new instance of DireccionEfectiva */
    public DireccionEfectiva() {
    }
    public static String[] getDireccionEfectiva(){return direccion_efectiva;}
}
