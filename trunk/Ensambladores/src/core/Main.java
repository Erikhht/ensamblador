/*
 * Main.java
 *
 * Creado el 11 de julio de 2007, 22:26
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package core;

import java.util.Vector;

public class Main {
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
    public Main(String m) {     
        aux=m.split("/n");            
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
            if(aux[i].contains(";")){   
                indice=aux[i].indexOf(";");                
                aux[i]=aux[i].substring(0,indice);
            }            
        }                            
        for(int i=ini_code+1;i<fin_code;i++){
            codes.add(aux[i]);
        }
            
        for(int i=ini_stack+1;i<fin_stack;i++){
            stacks.add(aux[i]);
        }        
        
        for(int i=ini_data+1;i<fin_data;i++){            
            datas.add(aux[i]);                      
        }    
        
        for(int i=0;i<stacks.size();i++){
            stack=stacks.elementAt(i).split(" ");
            todo.add(stack);
        }     
        for(int i=0;i<codes.size();i++){
            code=codes.elementAt(i).split(" ");
            todo.add(code);
        }     
        for(int i=0;i<datas.size();i++){
            data=datas.elementAt(i).split(" ");
            todo.add(data);
        }        
//*************** IMPRIMIR *********************************  
         System.out.println("******************************");
        for(int i=0; i<aux.length;i++){
            System.out.println(aux[i]);
        }                          
        System.out.println("******************************");
         for(int i=1; i<stacks.size();i++){
            System.out.println(stacks.elementAt(i));
        }   
        System.out.println("******************************");               
        for(int i=1; i<datas.size();i++){
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
    

    public static void main(String[] args) {           
        String cadena="stack segment/n db 64 dup ('?')/n ends/n/n data segment/n m1 db 'hola$'/n m2 dw 'regresa$'/n m3 db 'hola mundo$'/n ends/n/n code segment/n mov ah,09H/n int 21H;comentario/n add var1,05H/nends";
        Main p = new Main(cadena);
        
    }
}