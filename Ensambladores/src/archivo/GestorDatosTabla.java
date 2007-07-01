/*
 * DialogoApertura.java
 *
 * Created on 29 de junio de 2007, 9:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package archivo;

import excepciones.NumeroColumnasDiferenteException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class GestorDatosTabla {
    
    private JTable tabla;
    private DefaultTableModel model;
    private Vector<String> nombresColumnas;
    
    public GestorDatosTabla(JTable tabla){
        this.tabla = tabla;
        this.model = new DefaultTableModel();
        this.tabla.setModel(model);
        this.nombresColumnas = new Vector<String>();
    }
    
    
    /** Creates a new instance of GestorDatosTabla */
    public GestorDatosTabla(JTable tabla, Vector<String> encabezado) {
        this.tabla = tabla;
        this.model = new DefaultTableModel();
        this.tabla.setModel(model);
        this.nombresColumnas = encabezado;
        //establece el nombre de las columnas
        this.model.setColumnIdentifiers(encabezado);
    }
    
    /**
     * Crea un objeto GestorDatosTabla dados el encabezado y los datos de la tabla
     * El numero de elementos del Vector encabezado debe coincidir con la longitud
     * del vector de datos.
     */
    public GestorDatosTabla(JTable table, Vector<String> encabezado, Vector<Vector> datos){
        this.tabla = tabla;
        this.model = new DefaultTableModel();
        this.tabla.setModel(model);        
        this.nombresColumnas = encabezado;
        //establece el nombre de las columnas y los datos de la tabla
        this.model.setDataVector(datos, encabezado);
    }
    
    /**
     * Retorna el numero de columnas de la tabla.
     */
    public int getNumeroColumnas(){
        return this.model.getColumnCount();
    }
    
    /**
     * Establece el nombre de los encabezados de las columnas en la tabla
     */
    public void setEncabezados(String... encabezado) throws NumeroColumnasDiferenteException{
        if(encabezado.length != this.nombresColumnas.size() && this.nombresColumnas.size() != 0)
            throw new NumeroColumnasDiferenteException("El numero de columnas no coincide con el actual");
        
        if(!this.nombresColumnas.isEmpty()) this.nombresColumnas.clear();
        for(String s : encabezado) this.nombresColumnas.add(s);
        this.model.setColumnIdentifiers(this.nombresColumnas);
    }
    
    /**
     * Establece el nombre de los encabezados de las columnas en la tabla
     */
    public void setEncabezados(Vector<String> titulos){
         this.model.setColumnIdentifiers(titulos);
         this.nombresColumnas = titulos;
    }
    
    /**
     * Establece los datos de la tabla
     */
    public void setDatos(Vector<Vector> datos){
        this.model.setDataVector(datos, this.nombresColumnas);
    }
    
    public void addRenglon(Vector<String> renglon){
        this.model.addRow(renglon);
    }
   
}
