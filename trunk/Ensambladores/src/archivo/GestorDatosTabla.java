/*
 * DialogoApertura.java
 *
 * Created on 29 de junio de 2007, 9:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package archivo;

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
    /** Creates a new instance of GestorDatosTabla */
    public GestorDatosTabla(JTable tabla, Vector encabezado) {
        this.tabla = tabla;
        this.model = new DefaultTableModel();
        this.tabla.setModel(model);
        //establece el nombre de las columnas
        this.model.setColumnIdentifiers(encabezado);
    }
    
    /**
     * Retorna el numero de columnas de la tabla
     */
    public int getNumueroColumnas(){
        return this.model.getColumnCount();
    }
    
    public void setEncabezados(){
        
    }
}
