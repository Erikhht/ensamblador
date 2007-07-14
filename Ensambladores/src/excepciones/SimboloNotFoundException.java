/*
 * SimboloNotFoundException.java
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
public class SimboloNotFoundException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>SimboloNotFoundException</code> without detail message.
     */
    public SimboloNotFoundException() {
    }
    
    
    /**
     * Constructs an instance of <code>SimboloNotFoundException</code> with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public SimboloNotFoundException(String msg) {
        super(msg);
    }
}
