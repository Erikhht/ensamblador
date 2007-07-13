/*
 * GestorArchivos.java
 *
 * Created on 29 de junio de 2007, 9:25
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class GestorArchivos extends JFileChooser{
    
    File archivo;
    String archivoString;
    JFrame frame;
    
    /** Creates a new instance of GestorArchivos */
    public GestorArchivos(JFrame frame) {
        this.archivoString = "";
        this.inicializarFileChooser();
        this.frame = frame;
    }
    
    public void showOpenDialog(){
        int r = this.showOpenDialog(frame);
        if(r != JFileChooser.APPROVE_OPTION) return;
        this.archivo = this.getSelectedFile();
    }
    
    private void inicializarFileChooser(){
        this.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                String nombre = f.getName().toLowerCase();
                return nombre.endsWith(".asm") || nombre.endsWith(".ASM") || f.isDirectory();
            }
            public String getDescription() {
                return "Archivos de imagenes";
            }
        });
    }
    
    public void leerArchivo() throws FileNotFoundException, IOException{
        String linea = "";
        if(this.archivoString != "") this.archivoString = "";
       
        BufferedReader in = new BufferedReader(new FileReader(this.archivo));
        do{
            linea = in.readLine();
            if(linea == null) break;
            this.archivoString += linea + "\n";

        }while(true);
    }
    
    /**
     * Devuelve el archivo leido, debe de invocarse antes a showDialog
     * @return El arhivo leido
     */
    public File getArchivo(){
        return this.archivo;
    }
   
    /**
     * Devuele el texto contenido en el archivo leido
     * @return Texto contenido en el archivo leido
     */
    public String getArhivoString(){
        return this.archivoString;
    }
    
    
}
