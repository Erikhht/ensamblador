/*
 * InstruccionException.java
 *
 * Created on 12 de julio de 2007, 22:58
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package excepciones;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class InstruccionException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>InstruccionException</code> without detail message.
     */
    public InstruccionException() {
    }
    
    
    /**
     * Constructs an instance of <code>InstruccionException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InstruccionException(String msg) {
        super(msg);
    }
}
