/*
 * Ejemplo.java
 *
 * Creado el 12 de julio de 2007, 0:25
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 *
 */

package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class Ejemplo extends JFrame implements ActionListener{
    
    private JButton boton1; 
    private JPanel unPanel;
    /**
     * Constructora del JFrame
     */
    public Ejemplo() {
        //Inicializacion de los componentes graficos
        boton1 = new JButton("Un boton");
        
        //Esta linea indica que el boton sera capaz de escuchar cuando lo presionen
        boton1.addActionListener(this);
        
        /**
         * Este es un mensaje que se usa para poder comparar posteriormente si precisamente
         * este boton fue presionado
         */
        boton1.setActionCommand("este boton fue presionado");
        
        unPanel = new JPanel();
        
        //Creamos un layout que controla el ordenamiento de los componentes en el panel
        unPanel.setLayout(new FlowLayout());
        //agregamos el boton al panel
        unPanel.add(boton1);
        
        //Agregamos el boton al JFrame, o marco principal
        this.add(unPanel);
        
    }
    
    /**
     * Este es el metodo que va a servir como oyente, cada vez que
     * se presione un boton u ocurra un evento, ese metodo se va a ejecutar
     */
    public void actionPerformed(ActionEvent e){
        //Obtenemos el mensaje captado por el objeto oyente
        String mensaje = e.getActionCommand();
        
        if(mensaje.equals("este boton fue presionado")){
            //Esta linea muestra un mensaje de que el boton fue presionado
            javax.swing.JOptionPane.showMessageDialog(null, "Un mensaje", "El boton fue presionado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public static void main(String[] arg){
        Ejemplo miPrograma = new Ejemplo();
        //Establecemos las dimensiones de la ventana
        miPrograma.setSize(new java.awt.Dimension(400, 300));
        //se muestra la pantalla finalmente
        miPrograma.setVisible(true);
    }
}
