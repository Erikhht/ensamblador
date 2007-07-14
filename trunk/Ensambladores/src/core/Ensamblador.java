/*
 * Ensamblador.java
 *
 * Creado el 12 de julio de 2007, 11:47
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package core;

import codificaciones.CampoReg;
import codificaciones.ModRm;
import core.simbolos.Etiqueta;
import core.simbolos.Instruccion;
import core.simbolos.Variable;
import excepciones.InstruccionException;
import excepciones.SegmentNotFoundException;
import excepciones.SimboloNotFoundException;
import java.util.Vector;


/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Ensamblador {
    
    public static int CODE_SEGMENT = 0;
    public static int DATA_SEGMENT = 1;
    public static int STACK_SEGMENT = 2;    
    private BuscadorSimbolos buscador;
    private ParserAssembly parser;    
    
    /** Crea una nueva instancia de Ensamblador */
    public Ensamblador(String codigo) throws SegmentNotFoundException, InstruccionException {
        this.parser = new ParserAssembly(codigo);
        this.buscador = new BuscadorSimbolos(this.parser.getVariables(), this.parser.getConstantes(), this.parser.getInstrucciones());
    }  
    
    public Ensamblador(ParserAssembly parser) throws SegmentNotFoundException, InstruccionException{
        this.parser = parser;
        this.buscador = new BuscadorSimbolos(this.parser.getVariables(), this.parser.getConstantes(), this.parser.getInstrucciones());
    }            
    
    public ParserAssembly getParser(){
        return this.parser;
    }
    
    public Vector<String> Generar() throws SegmentNotFoundException, InstruccionException, SimboloNotFoundException{
        Vector<String> code =new Vector<String>();
        Vector<Instruccion> instrucciones = this.parser.getInstrucciones();
        for(int i=0;i<instrucciones.size();i++){            
            code.add(this.code(instrucciones.get(i)));
        }
        return code;
    }
    
    public String code(Instruccion inst) throws SimboloNotFoundException{
        ModRm mod = new ModRm();  
        String[] mod1=mod.getModRm();
        CampoReg reg = new CampoReg();
        String[] reg1 = reg.getReg();
        String[] reg3 = reg.getRegs3();
        String codificacion = new String();
        codificacion = this.getCode(inst);        
        String op1=inst.getOperando1();
        String op2=inst.getOperando2();
        Etiqueta etq = null;
        

        //********************REMPLAZO DE W *************************************
        if(codificacion.contains("w")){                                                        
           if(op1.equals("ax")||op1.equals("bx")||op1.equals("cx")||op1.equals("dx")){                               
               codificacion = codificacion.replace("w","1");
           }else{                             
               codificacion = codificacion.replace("w","0");           
           }
        }        
        //********************* REMPLAZO DE MOD ***********************************
        if(codificacion.contains("mod")){            
            for(int i=0;i<mod1.length;i++){                
                if(mod1[i].equals(op2)==true){                                    
                    codificacion=codificacion.replace("mod",mod1[i+1]);
                    codificacion=codificacion.replace("r/m",mod1[i+2]);                   
                }
            }
            if(codificacion.contains("mod")){                
                    codificacion=codificacion.replace("mod","00");
                    codificacion=codificacion.replace("r/m","110");                
            }
        }        
        //******************* REMPLAZO DE REGS3 ******************************** 
        if(codificacion.contains("regs3")){
            if(codificacion.contains("10001100")){
               for(int i=0;i<reg3.length;i++){
                if(reg3[i].equals(op2)){
                    codificacion=codificacion.replace("regs3",reg3[i+1]);
                }
            } 
            }else{
            for(int i=0;i<reg3.length;i++){
                if(reg3[i].equals(op1)){
                    codificacion=codificacion.replace("regs3",reg3[i+1]);
                }
            }
            }
        }
        
        //********************** REMPLAZO DE REG ********************************
        if(codificacion.contains("reg")){
            for(int i=0;i<reg1.length;i++){
                if(reg1[i].equals(op1)){
                    codificacion=codificacion.replace("reg",reg1[i+1]);
                }
            }
            if(codificacion.contains("reg")){
                for(int i=0;i<reg1.length;i++){
                    if(reg1[i].equals(op2)){
                        codificacion=codificacion.replace("reg",reg1[i+1]);
                    }
                }
            }
        }        
        //**************** REMPLAZO DE INM **********************************
        if(codificacion.contains("Inm")){            
            String otro = op2;
            otro=otro.replace("h","");
            codificacion=codificacion.replace("Inm",Integer.toBinaryString(Integer.parseInt(otro)));
        }                
        //************** DESPLAZAMIENTO DE DESP PASA ESTO MAS ARRIBA**********************
        if(codificacion.contains("desp")){
            if(op2=="ax"||op2=="bx"||op2=="cx"||op2=="dx"){
               codificacion=codificacion.replace("desp","");            
            }else{
                if(op2=="al"||op2=="bl"||op2=="cl"||op2=="dl"||op2=="ah"||op2=="bh"||op2=="ch"||op2=="dh"){
                    codificacion=codificacion.replace("desp","");            
                }else{
                    if(codificacion.contains("0000000100001110")){                        
                        codificacion=codificacion.replace("desp","");
                    }else{
                        if(codificacion.contains("110001110000011")){
                            codificacion=codificacion.replace("desp","");
                        }else{
                            if(codificacion.contains("110001110000011")){
                                codificacion=codificacion.replace("desp","");
                            }
                            Variable var=buscador.buscarVariable(op2);
                            codificacion=codificacion.replace("desp",var.getBinDireccion());            
                        }
                    }
                }
            }
        }
        
        //**************** REMPLAZO DE d **********************************
        if(codificacion.contains("000000dw")){            
            codificacion=codificacion.replace("d","0");
        }
        if(codificacion.contains("001000d")){            
            codificacion=codificacion.replace("d","0");
        }
        //**************** REMPLAZO DE S**********************************
        if(codificacion.contains("100000s")){              
            codificacion=codificacion.replace("s","0");
        }                   
        System.out.println("binario: "+codificacion);
        int hexa; 
        hexa= Integer.parseInt(codificacion,2);
        codificacion = Integer.toHexString(hexa);       
        return codificacion;
    }    
    
    public String getCode(Instruccion inst){
        int ban1=0;
        int ban2=0;
        String name;
        String ope1;
        String ope2;
        String code=new String();
        name=inst.getNombre();  
        System.out.println(name);
        ope1=inst.getOperando1();
        ope2=inst.getOperando2();        
        if(ope2==null){
            ope2="";
        }
//********************************* DETECTAMOS QUE ES CADA OPERANDO (REG,REGS,INM,MEM)*****************************************************        
            if(ope1.equals("ax")||ope1.equals("bx")||ope1.equals("cx")||ope1.equals("dx")||ope1.equals("al")||ope1.equals("bl")||ope1.equals("cl")||ope1.equals("dl")||ope1.equals("ah")||ope1.equals("bh")||ope1.equals("ch")||ope1.equals("dh")){
                ope1="reg";                
                ban1=1;
            }
            if(ope2.equals("ax")||ope2.equals("bx")||ope2.equals("cx")||ope2.equals("dx")||ope2.equals("al")||ope2.equals("bl")||ope2.equals("cl")||ope2.equals("dl")||ope2.equals("ah")||ope2.equals("bh")||ope2.equals("ch")||ope2.equals("dh")){
                ope2="reg";                
                ban2=1;
            }
            if(ope1.equals("ds")||ope1.equals("ss")||ope1.equals("es")||ope1.equals("cs")){
                ope1="regs";
                ban1=1;
            }
            if(ope2.equals("ds")||ope2.equals("ss")||ope2.equals("es")||ope2.equals("cs")){
                ope2="regs";
                ban2=1;
            }
            if(ope2.contains("h")){
                ope2="inm";
                ban2=1;
            }
        
           if(ope2==""){
                ope2="";
                ban2=1;
           }
           if(ban1==0){
                ope1="mem";
           }
           if(ban2==0){
                ope2="mem";
           }   
           System.out.println(ope1);
           System.out.println(ope2);
//**************************** CODIFICACION DE MOV *********************************************            
        if(name.equals("mov")){
        
           //*************** mov reg a reg/mem *********************************** 
           if(ope2.equals("reg")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="1000100w"+"mod"+"reg"+"r/m"+"desp";
           }
           
           //**************** mov reg/mem a reg *********************************           
           if((ope2.equals("reg")||ope2.equals("mem"))&&ope1.equals("reg")){
                code="1000101w"+"mod"+"reg"+"r/m"+"desp";
           }
           
           //**************mov inmediaro a reg/mem *******************************
           if(ope2.equals("inm")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="1100011w"+"mod"+"000"+"r/m"+"desp"+"Inm";
           } 
                      
           //******************** mov reg a regs *******************************
           if(ope2.equals("reg")&&ope1.equals("regs")){
                code="10001110"+"mod"+"regs3"+"r/m";
           } 
           
           //****************** mov regs a reg ********************************
           if(ope2.equals("regs")&&ope1.equals("reg")){
                code="10001100"+"mod"+"regs3"+"r/m";
           }         
        }
        
//**************************** CODIFICACION DE ADD ***********************************************        
        if(name.equals("add")){
               ;
            //************ add reg con reg ***********************************+
            if(ope2.equals("reg")&&ope1.equals("reg")){
                code="000000dw"+"mod"+"reg"+"r/m";
            }
            
            //************** add reg con mem *******************************
            if(ope1.equals("reg")&&ope2.equals("mem")){                
                code="0000000w"+"mod"+"reg"+"r/m"+"desp";
            }
            
            //************ add reg con meme *******************************
            if(ope1.equals("mem")&&ope2.equals("reg")){
                code="0000001w"+"mod"+"reg"+"r/m"+"desp";                
            }
            
            //************* add inm con reg/men ***************************
            if(ope2.equals("inm")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="100000sw"+"mod"+"000"+"r/m"+"desp"+"Inm";
            }                            
        }
        
//********************************** CODIFICACION DE AND ******************************************        
        if(name.equals("and")){
            
            //************ and reg con reg ****************************
            if(ope2.equals("reg")&&ope1.equals("reg")){
                code="001000dw"+"mod"+"reg"+"r/m";
            }
            
            //************ and reg con mem **************************
            if(ope2.equals("reg")&&ope1.equals("mem")){
                code="0010000w"+"mod"+"reg"+"r/m"+"desp";
            }
            
            //************ and mem con reg ***********************
            if(ope2.equals("mem")&&ope1.equals("reg")){
                code="0010001w"+"mod"+"reg"+"r/m"+"desp";
            }
            //************ and inm con reg/mem
            if(ope2.equals("inm")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="1000000w"+"mod"+"100"+"r/m"+"desp"+"Inm";
            }
        }
        
//*********************** CODIFICACION DE LEA ***************************************************        
        if(name.equals("lea")){
            code="10001101"+"mod"+"reg"+"r/m";
        }
        
//*********************** CODIFICACION DE JMP ***************************************************        
        if(name.equals("jmp")){
            code="11101001"+"desp";            
        }            
        
//*********************** CODIFICACION DE INT ***************************************************        
        if(name.equals("int")){               
           String otro = inst.getOperando1();
           otro=otro.replace("h","");
            code="11001101"+Integer.toBinaryString(Integer.parseInt(otro));            
        }            
        System.out.println("codificacion:"+code);   
        return code;
    }       
    
    
    
    public static void main(String[] arg) throws SimboloNotFoundException, SegmentNotFoundException, InstruccionException{         
        Ensamblador e = new Ensamblador(new ParserAssembly(""));
        Instruccion ins=new Instruccion("mov","ax","25h");
        String codidito = new String();
        codidito = e.code(ins);
        System.out.print(codidito);
    }
}
