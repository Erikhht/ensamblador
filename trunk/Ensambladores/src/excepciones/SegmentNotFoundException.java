/*
 * SegmentNotFoundException.java
 *
 * Created on 12 de julio de 2007, 19:45
 *
 * Autor: Victor Hugo Perez Alvarado
 * Email: ywegoster@gmail.com
 */

package excepciones;

/**
 *
 * @author Victor Hugo Perez Alvarado
 */
public class SegmentNotFoundException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>SegmentNotFoundException</code> without detail message.
     */
    public SegmentNotFoundException() {
    }
    
    
    /**
     * Constructs an instance of <code>SegmentNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SegmentNotFoundException(String msg) {
        super(msg);
    }
}
