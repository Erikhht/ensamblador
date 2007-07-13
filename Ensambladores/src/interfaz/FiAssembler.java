/*
 * FiAssembler.java
 *
 * Creado el 29 de junio de 2007, 9:12
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package interfaz;

import archivo.*;
import core.*;
import excepciones.NumeroColumnasDiferenteException;
import excepciones.SegmentNotFoundException;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import util.StringUtils;
import static core.Ensamblador.*;

/**
 *
 * @author  Victor Hugo Perez Alvarado
 */
public class FiAssembler extends javax.swing.JFrame {
    
    /** Creates new form FiAssembler */
    public FiAssembler() {
        initComponents();
        
        this.gestor = new GestorArchivos(this);
        
        this.gestorSimbolos = new GestorDatosTabla(this.jTSimbolos);
        this.gestorSimbolos.setEncabezados("Nombre", "Tipo", "Valor", "Descripcion");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Image img = null;
                try{
                    img = javax.imageio.ImageIO.read(getClass().getResource("/background.jpg"));
                }catch(Exception e){}

                if(img != null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
                else g.drawString("Image not found", 50,50);
            }};
            jIFCodigoAsm = new javax.swing.JInternalFrame();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTACodigoAsm = new javax.swing.JTextArea();
            jIFSegmentos = new javax.swing.JInternalFrame();
            jScrollPane2 = new javax.swing.JScrollPane();
            jTASegmentos = new javax.swing.JTextArea();
            jInternalFrame2 = new javax.swing.JInternalFrame();
            jToolBar1 = new javax.swing.JToolBar();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jButton4 = new javax.swing.JButton();
            jInternalFrame3 = new javax.swing.JInternalFrame();
            jScrollPane3 = new javax.swing.JScrollPane();
            jTSimbolos = new javax.swing.JTable();
            jInternalFrame4 = new javax.swing.JInternalFrame();
            jButton3 = new javax.swing.JButton();
            jMenuBar1 = new javax.swing.JMenuBar();
            jMenu1 = new javax.swing.JMenu();
            jMIAbrir = new javax.swing.JMenuItem();
            jMISalir = new javax.swing.JMenuItem();
            jMenu3 = new javax.swing.JMenu();
            jMenuItem1 = new javax.swing.JMenuItem();
            jMenu2 = new javax.swing.JMenu();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("FI Assembler");
            setName("FiAssembler");
            jDesktopPane1.setBackground(new java.awt.Color(102, 102, 102));
            jIFCodigoAsm.setIconifiable(true);
            jIFCodigoAsm.setMaximizable(true);
            jIFCodigoAsm.setResizable(true);
            jIFCodigoAsm.setVisible(true);
            jTACodigoAsm.setColumns(20);
            jTACodigoAsm.setRows(5);
            jScrollPane1.setViewportView(jTACodigoAsm);

            org.jdesktop.layout.GroupLayout jIFCodigoAsmLayout = new org.jdesktop.layout.GroupLayout(jIFCodigoAsm.getContentPane());
            jIFCodigoAsm.getContentPane().setLayout(jIFCodigoAsmLayout);
            jIFCodigoAsmLayout.setHorizontalGroup(
                jIFCodigoAsmLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jIFCodigoAsmLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jIFCodigoAsmLayout.setVerticalGroup(
                jIFCodigoAsmLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jIFCodigoAsmLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
            );
            jIFCodigoAsm.setBounds(10, 80, 470, 310);
            jDesktopPane1.add(jIFCodigoAsm, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jIFSegmentos.setIconifiable(true);
            jIFSegmentos.setMaximizable(true);
            jIFSegmentos.setResizable(true);
            jIFSegmentos.setVisible(true);
            jTASegmentos.setColumns(20);
            jTASegmentos.setRows(5);
            jScrollPane2.setViewportView(jTASegmentos);

            org.jdesktop.layout.GroupLayout jIFSegmentosLayout = new org.jdesktop.layout.GroupLayout(jIFSegmentos.getContentPane());
            jIFSegmentos.getContentPane().setLayout(jIFSegmentosLayout);
            jIFSegmentosLayout.setHorizontalGroup(
                jIFSegmentosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jIFSegmentosLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jIFSegmentosLayout.setVerticalGroup(
                jIFSegmentosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jIFSegmentosLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jIFSegmentos.setBounds(10, 400, 470, 190);
            jDesktopPane1.add(jIFSegmentos, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jInternalFrame2.setVisible(true);
            jToolBar1.setFloatable(false);
            jToolBar1.setRollover(true);
            jButton1.setText("Data Segment");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jToolBar1.add(jButton1);

            jButton2.setText("Code Segment");
            jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jToolBar1.add(jButton2);

            jButton4.setText("Stack Segment");
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });

            jToolBar1.add(jButton4);

            org.jdesktop.layout.GroupLayout jInternalFrame2Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame2.getContentPane());
            jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
            jInternalFrame2Layout.setHorizontalGroup(
                jInternalFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
            );
            jInternalFrame2Layout.setVerticalGroup(
                jInternalFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jInternalFrame2Layout.createSequentialGroup()
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jInternalFrame2.setBounds(10, 10, 470, 60);
            jDesktopPane1.add(jInternalFrame2, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jInternalFrame3.setIconifiable(true);
            jInternalFrame3.setMaximizable(true);
            jInternalFrame3.setResizable(true);
            jInternalFrame3.setVisible(true);
            jTSimbolos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jTSimbolos.setEnabled(false);
            jScrollPane3.setViewportView(jTSimbolos);

            org.jdesktop.layout.GroupLayout jInternalFrame3Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame3.getContentPane());
            jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
            jInternalFrame3Layout.setHorizontalGroup(
                jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jInternalFrame3Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jInternalFrame3Layout.setVerticalGroup(
                jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jInternalFrame3Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jInternalFrame3.setBounds(490, 10, 370, 290);
            jDesktopPane1.add(jInternalFrame3, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jInternalFrame4.setVisible(true);
            jButton3.setText("llenar");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            org.jdesktop.layout.GroupLayout jInternalFrame4Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame4.getContentPane());
            jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
            jInternalFrame4Layout.setHorizontalGroup(
                jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jInternalFrame4Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jButton3)
                    .addContainerGap(214, Short.MAX_VALUE))
            );
            jInternalFrame4Layout.setVerticalGroup(
                jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jInternalFrame4Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jButton3)
                    .addContainerGap(27, Short.MAX_VALUE))
            );
            jInternalFrame4.setBounds(490, 310, 310, 90);
            jDesktopPane1.add(jInternalFrame4, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jMenu1.setText("Archivo");
            jMIAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
            jMIAbrir.setText("Abrir archivo");
            jMIAbrir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMIAbrirActionPerformed(evt);
                }
            });

            jMenu1.add(jMIAbrir);

            jMISalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
            jMISalir.setText("Salir");
            jMISalir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMISalirActionPerformed(evt);
                }
            });

            jMenu1.add(jMISalir);

            jMenuBar1.add(jMenu1);

            jMenu3.setText("Edicion");
            jMenuItem1.setText("Item");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });

            jMenu3.add(jMenuItem1);

            jMenuBar1.add(jMenu3);

            jMenu2.setText("Ver");
            jMenuBar1.add(jMenu2);

            setJMenuBar(jMenuBar1);

            org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jDesktopPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jDesktopPane1)
            );
            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.segmentSelected(STACK_SEGMENT);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.segmentSelected(CODE_SEGMENT);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.segmentSelected(DATA_SEGMENT);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void segmentSelected(int segment){
        String segmentoLeido = "";
        String titulo = "";
        if(segment == STACK_SEGMENT)
           titulo = "Segmento de pila";
        else if(segment == DATA_SEGMENT)
            titulo = "Segmento de datos";
        else if(segment == CODE_SEGMENT)
            titulo = "Segmento de c�digo";
        
        this.jIFSegmentos.setTitle(titulo);
        
        try {
            this.jTASegmentos.setText(this.ensamblador.getSegment(segment));
            this.jIFSegmentos.setSelected(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        } catch (SegmentNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.llenarTablaSimbolos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(this.gestor.getArchivo() != null)
            this.mostrarCodigo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Despliega un cuadro de dialogo que permite elegir un archivo con extension .asm o .ASM
     * Luego lee la informaci�n del archivo, y la muestra en el dialogo principal.
     * @param evt 
     */
    private void jMIAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAbrirActionPerformed
        this.gestor.showOpenDialog();
        this.mostrarCodigo();
    }//GEN-LAST:event_jMIAbrirActionPerformed

    public void llenarTablaSimbolos(){
        this.gestorSimbolos.setEncabezados("Nueva columna", "Nueva imagen", "todo nuevo");

        for (int i = 0; i < 10; i++) {
            try {
                this.gestorSimbolos.addRenglon("Datos", "mas", "jeje");
            } catch (NumeroColumnasDiferenteException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Muestra el codigo del archivo leido en el JTextArea destinado para el codigo fuente.
     */
    private void mostrarCodigo(){
        try {
            this.gestor.leerArchivo();
            //Creacion del ensamblador a partir del codigo fuente cargado
            this.ensamblador = new Ensamblador(this.gestor.getArhivoString());
            this.jIFCodigoAsm.setTitle("C�digo Fuente - "+this.gestor.getArchivo().getName());
            this.jIFCodigoAsm.setSelected(true);
            this.jTACodigoAsm.setText(this.gestor.getArhivoString());
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            this.mostrarError("Tipo de archivo no valido", "Aviso");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void jMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMISalirActionPerformed
    
    private void mostrarError(String mensaje, String titulo){
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * @param args Argumentos de la linea de comandos
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FiAssembler gui = new FiAssembler();
                gui.setSize(new java.awt.Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
                gui.setVisible(true);
            }
        });
    }
   
    private Ensamblador ensamblador;
    private GestorDatosTabla gestorSimbolos;
    private GestorArchivos gestor;
    private static final int DEFAULT_WIDTH = 875;
    private static final int DEFAULT_HEIGHT = 620;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jIFCodigoAsm;
    private javax.swing.JInternalFrame jIFSegmentos;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JMenuItem jMIAbrir;
    private javax.swing.JMenuItem jMISalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTACodigoAsm;
    private javax.swing.JTextArea jTASegmentos;
    private javax.swing.JTable jTSimbolos;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
}
