/*
 * CampoReg.java
 *
 * Created on 13 de julio de 2007, 12:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package codificaciones;

/**
 *
 * @author Franxo
 */
public class CampoReg {
    
    /** Creates a new instance of CampoReg */
 
   private static String reg[] = {"ax","000","1","al","000","0",  
                                 "cx","001","1","cl","001","0",  
                                 "dx","010","1","dl","010","0",
                                 "bx","011","1","bl","011","0",
                                 "sp","100","1","ah","100","0",
                                 "bp","101","1","ch","101","0",
                                 "si","110","1","dh","110","0",
                                 "di","111","1","bh","111","0"
                                 };
  
  private static String regs2[] = {"es","00",            
                                   "cs","01",
                                   "ss","10",
                                   "ds","11"
                                  };
  
  private static String regs3[] = {"es","000",           
                                   "cs","001",
                                   "ss","010",
                                   "ds","011"
                                   };
     public CampoReg() {
    }
  public static String[] getReg(){return reg;}
  public static String[] getRegs2(){return regs2;}
  public static String[] getRegs3(){return regs3;}
  
}
