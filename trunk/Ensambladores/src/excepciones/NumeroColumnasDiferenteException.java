/*
 * NumeroColumnasDiferenteException.java
 *
 * Created on 1 de julio de 2007, 12:27
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package excepciones;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class NumeroColumnasDiferenteException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>NumeroColumnasDiferenteException</code> without detail message.
     */
    public NumeroColumnasDiferenteException() {
    }
    
    
    /**
     * Constructs an instance of <code>NumeroColumnasDiferenteException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NumeroColumnasDiferenteException(String msg) {
        super(msg);
    }
}
