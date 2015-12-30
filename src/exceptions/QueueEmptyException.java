package exceptions;

/**
 * Created by Jógvan 30/12-2015 17:37.
 */
public class QueueEmptyException extends ArrayIndexOutOfBoundsException{

    public QueueEmptyException(String s) {
        super(s);
    }
}
