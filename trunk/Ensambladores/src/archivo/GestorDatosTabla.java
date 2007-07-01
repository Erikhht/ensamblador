/*
 * DialogoApertura.java
 *
 * Created on 29 de junio de 2007, 9:26
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package archivo;

import excepciones.NumeroColumnasDiferenteException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class GestorDatosTabla extends DefaultTableModel{
    
    private JTable tabla;
    //private DefaultTableModel model;
    private Vector<String> nombresColumnas;
    
    public GestorDatosTabla(JTable tabla){
        super();
        this.tabla = tabla;
        //this.model = new DefaultTableModel();
        this.tabla.setModel(this);
        this.nombresColumnas = new Vector<String>();
    }
    
    
    /** Creates a new instance of GestorDatosTabla */
    public GestorDatosTabla(JTable tabla, Vector<String> encabezado) {
        super();
        this.tabla = tabla;
        //this.model = new DefaultTableModel();
        this.tabla.setModel(this);
        this.nombresColumnas = encabezado;
        //establece el nombre de las columnas
        this.setColumnIdentifiers(encabezado);
    }
    
    /**
     * Crea un objeto GestorDatosTabla dados el encabezado y los datos de la tabla
     * El numero de elementos del Vector encabezado debe coincidir con la longitud
     * del vector de datos.
     */
    public GestorDatosTabla(JTable table, Vector<String> encabezado, Vector<Vector> datos){
        super();
        this.tabla = tabla;
        //this.model = new DefaultTableModel();
        this.tabla.setModel(this);        
        this.nombresColumnas = encabezado;
        //establece el nombre de las columnas y los datos de la tabla
        this.setDataVector(datos, encabezado);
    }
    
    /**
     * Establece el nombre de los encabezados de las columnas en la tabla
     */
    public void setEncabezados(String... encabezado){
        if(!this.nombresColumnas.isEmpty()) this.nombresColumnas.clear();
        for(String s : encabezado) this.nombresColumnas.add(s);
        super.setColumnIdentifiers(this.nombresColumnas);
    }
    
    /**
     * Establece el nombre de los encabezados de las columnas en la tabla
     */
    public void setEncabezados(Vector<String> titulos){
         super.setColumnIdentifiers(titulos);
         this.nombresColumnas = titulos;
    }
    
    /**
     * Establece los datos de la tabla
     */
    public void setDatos(Vector<Vector> datos){
        super.setDataVector(datos, this.nombresColumnas);
    }
    
    public void addRenglon(Vector<String> renglon) throws NumeroColumnasDiferenteException{
        if(renglon.size() != super.getColumnCount()) 
            throw new NumeroColumnasDiferenteException("Los datos excedene el numero de columnas.");
        super.addRow(renglon);
    }
    
    public void addrenglon(String[] strings) throws NumeroColumnasDiferenteException{
        this.realAddRenglon(strings);
    }
    
    public void addRenglon(String... strings) throws NumeroColumnasDiferenteException{
        this.realAddRenglon(strings);
    }

    private void realAddRenglon(String[] strings) throws NumeroColumnasDiferenteException{
        if(strings.length != super.getColumnCount()) 
            throw new NumeroColumnasDiferenteException("Los datos exceden el numero de columnas.");
        
        Vector<String> renglon = new Vector<String>();
        for(String x : strings) renglon.add(x);
        super.addRow(renglon);
    }
}
