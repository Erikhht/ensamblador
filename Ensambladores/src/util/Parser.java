package util;

import java.util.Vector;

public class Parser {
    String[] aux = new String[100];   
    String[] aux1 = new String[100]; 
    Vector<String[]> todo = new Vector<String[]>();
    Vector<String> datas = new Vector<String>();
    Vector<String> stacks = new Vector<String>();
    Vector<String> codes = new Vector<String>();
    String[] stack;
    String[] data;
    String[] code;
    int tope=0;
    int indice=0;
    int ini_stack=0;
    int ini_data=0;
    int ini_code=0;
    int fin_stack=0;
    int fin_data=0;
    int fin_code=0;
    int ban1=0;
    int ban2=0;
    public Parser(String m) {     
        aux=m.split("/n");
        
//***************** Ciclo para buscar inicio y fin de segmentos *******************
        for(int i=0;i<aux.length;i++){                                        
            if(aux[i].contains("stack segment")){ 
                ini_stack=i;
            }
            if(aux[i].contains("data segment")){ 
                ini_data=i;
            }
            if(aux[i].contains("code segment")){ 
                ini_code=i;
            }
            if(aux[i].contains("ends")){    
                if(ban1==0){
                    fin_stack=i;                    
                }   
                if(ban1==1){
                    fin_data=i;                    
                }
                fin_code=i;
                ban1++;
            }
//***************** Validacion para omitir comentarios ************************
            if(aux[i].contains(";")){   
                indice=aux[i].indexOf(";");                
                aux[i]=aux[i].substring(0,indice);
            }            
        }
        
//******** Ciclo para guardar los segmentos a sus respectivos vectores *************
        for(int i=ini_code+1;i<fin_code;i++){
            codes.add(aux[i]);
        }
            
        for(int i=ini_stack+1;i<fin_stack;i++){
            stacks.add(aux[i]);
        }        
        
        for(int i=ini_data+1;i<fin_data;i++){            
            datas.add(aux[i]);                      
        }    
//********************** Ciclo de separacion de instrucciones *******************
        for(int i=0;i<stacks.size();i++){
            stack=stacks.elementAt(i).split(" ");
            todo.add(stack);
        }               
        /*for(int i=0;i<datas.size();i++){
            data=datas.elementAt(i).split(" ");
            todo.add(data);
        }  */   
        for(int i=0;i<codes.size();i++){
            code=codes.elementAt(i).split(" ");
            todo.add(code);
        } 
        
//*************** IMPRIMIR *********************************  
         System.out.println("******************************");
        for(int i=0; i<aux.length;i++){
            System.out.println(aux[i]);
        }                          
        System.out.println("******************************");
         for(int i=0; i<stacks.size();i++){
            System.out.println(stacks.elementAt(i));
        }   
        System.out.println("******************************");               
        for(int i=0; i<datas.size();i++){
            System.out.println(datas.elementAt(i));
        }  
         System.out.println("******************************");         
        for(int i=0; i<codes.size();i++){
            System.out.println(codes.elementAt(i));
        }     
          System.out.println("******************************");         
        for(int i=0; i<todo.size();i++){
              aux1=todo.elementAt(i);
              for(int j=0;j<aux1.length;j++){
                    System.out.println(aux1[j]);
              }
        }    
    }     
    
    public Vector getStack(){
        return stacks;
    }
    public Vector getData(){
        return datas;
    }
    public Vector getcode(){
        return codes;
    }
    
    public static void main(String[] args) {           
        String cadena="stack segment/n db 64 dup ('?')/n ends/n/n" +
                "data segment/n m1 db 'hola$'/n m2 dw 'regresa$'/n" +
                " m3 db 'hola mundo$'/n ends/n/n code segment/n mov ah,09H/n" +
                " int 21H;comentario/n add var1,05H/nends";
        Parser p = new Parser(cadena);        
    }
}