package jeu.exception;
import java.lang.Exception;
/**
 * @author waradia
 *
 */
public class NoSuchResourceException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoSuchResourceException(String msg) {
		super(msg);
	}

}
