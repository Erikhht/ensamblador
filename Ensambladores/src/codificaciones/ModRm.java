/*
 * ModRm.java
 *
 * Created on 13 de julio de 2007, 12:28 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package codificaciones;

/**
 *
 * @author Franxo
 */
public class ModRm {
    private static String mod_rm[] = {"al","11","000","ax","11","000",    
                                    "cl","11","001","cx","11","001",
                                    "dl","11","010","dx","11","010",
                                    "bl","11","011","bx","11","011",
                                    "ah","11","100","sp","11","100",
                                    "ch","11","101","bp","11","101",
                                    "dh","11","110","si","11","110",
                                    "bh","11","111","di","11","111",
                                    "[bx+si]","00","000",   
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
    /** Creates a new instance of ModRm */
    public ModRm() {
    }
    public static String[] getModRm(){return mod_rm;}
    
    
}
