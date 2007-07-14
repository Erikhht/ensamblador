/*
 * VariableNotFoundException.java
 *
 * Created on 14 de julio de 2007, 3:57
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package excepciones;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class VariableNotFoundException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>VariableNotFoundException</code> without detail message.
     */
    public VariableNotFoundException() {
    }
    
    
    /**
     * Constructs an instance of <code>VariableNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public VariableNotFoundException(String msg) {
        super(msg);
    }
}
