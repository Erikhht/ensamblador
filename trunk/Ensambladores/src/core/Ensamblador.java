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

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Ensamblador {
    
    public static int CODE_SEGMENT = 0;
    public static int DATA_SEGMENT = 1;
    public static int STACK_SEGMENT = 2;    
    private ParserAssembly parser;    
    
    /** Crea una nueva instancia de Ensamblador */
    public Ensamblador(String codigo) {
        this.parser = new ParserAssembly(codigo);
    }
    
    public Ensamblador(ParserAssembly parser){
        this.parser = parser;
    }
    
    public Ensamblador(){
        
    }
    
    public ParserAssembly getParser(){
        return this.parser;
    }
    
    public String getCode(Instruccion inst){
        String name;
        String ope1;
        String ope2;
        String code;
        name=inst.getNombre();  
        ope1=inst.getOperando1();
        ope2=inst.getOperando2();
            if(ope1.equals("ax")||ope1.equals("bx")||ope1.equals("cx")||ope1.equals("dx")||ope1.equals("al")||ope1.equals("bl")||ope1.equals("cl")||ope1.equals("dl")||ope1.equals("ah")||ope1.equals("bh")||ope1.equals("ch")||ope1.equals("dh")){
                ope1="reg";                
            }
            if(ope2.equals("ax")||ope2.equals("bx")||ope2.equals("cx")||ope2.equals("dx")||ope2.equals("al")||ope2.equals("bl")||ope2.equals("cl")||ope2.equals("dl")||ope2.equals("ah")||ope2.equals("bh")||ope2.equals("ch")||ope2.equals("dh")){
                ope2="reg";                
            }
            if(ope1.equals("ds")||ope1.equals("ss")||ope1.equals("es")||ope1.equals("cs")){
                ope1="regs";
            }
            if(ope2.equals("ds")||ope2.equals("ss")||ope2.equals("es")||ope2.equals("cs")){
                ope2="regs";
            }
            if(ope2.equals("0")||ope2.equals("1")||ope2.equals("2")||ope2.equals("3")||ope2.equals("4")||ope2.equals("5")||ope2.equals("6")||ope2.equals("7")||ope2.equals("8")||ope2.equals("9")||ope2.equals("a")||ope2.equals("b")||ope2.equals("c")||ope2.equals("d")||ope2.equals("f")){
                ope2="inm";
            }
           if(ope1.length()>2){
                ope1="mem";
           }
           if(ope2.length()>2){
                ope2="mem";
           }
            
        if(name.equals("mov")){            
           if(ope2.equals("reg")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="1000100w"+"mod"+"reg"+"r/m"+"desp";
           }
           if((ope2.equals("reg")||ope2.equals("mem"))&&ope1.equals("reg")){
                code="1000101w"+"mod"+"reg"+"r/m"+"desp";
           } 
           if(ope2.equals("inm")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="1100011w"+"mod"+"000"+"r/m"+"desp"+"Inm";
           } 
           if(ope2.equals("inm")&&ope1.equals("reg")){
                code="1011w"+"reg"+"Inm";
           }
           if(ope2.equals("reg")&&ope1.equals("regs")){
                code="10001110"+"mod"+"regs3"+"r/m";
           } 
           if(ope2.equals("regs")&&ope1.equals("reg")){
                code="10001100"+"mod"+"regs3"+"r/m";
           } 
        }
        if(name.equals("add")){
            if(ope2.equals("reg")&&ope1.equals("reg")){
                code="000000dw"+"mod"+"reg"+"r/m";
            }
            if(ope2.equals("reg")&&ope1.equals("mem")){
                code="0000000w"+"mod reg r/m"+"desp";
            }
            if(ope2.equals("mem")&&ope1.equals("reg")){
                code="0000001w"+"mod reg r/m"+"desp";                
            }
            if(ope2.equals("inm")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="100000sw"+"mod"+"000"+"r/m"+"desp"+"Inm";
            }                            
        }
        if(name.equals("and")){
            if(ope2.equals("reg")&&ope1.equals("reg")){
                code="001000dw"+"mod"+"reg"+"r/m";
            }
            if(ope2.equals("reg")&&ope1.equals("mem")){
                code="0010000w"+"mod"+"reg"+"r/m"+"desp";
            }
            if(ope2.equals("mem")&&ope1.equals("reg")){
                code="0010001w"+"mod"+"reg"+"r/m"+"desp";
            }
            if(ope2.equals("inm")&&(ope1.equals("reg")||ope1.equals("mem"))){
                code="1000000w"+"mod"+"100"+"r/m"+"desp"+"Inm";
            }
        }
        if(name.equals("lea")){
            code="10001101"+"mod"+"reg"+"r/m";
        }
        if(name.equals("jmp")){
            code="11101001"+"desp";
        }            
        if(name.equals("int")){
            code="11001101"+"Inm";
        }    
        return code;
    }
    
}
