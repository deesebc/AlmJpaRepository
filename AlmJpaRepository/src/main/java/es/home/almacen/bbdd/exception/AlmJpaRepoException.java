/**
 * 
 */
package es.home.almacen.bbdd.exception;

/**
 * @author daniel
 *
 */
public class AlmJpaRepoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AlmJpaRepoException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AlmJpaRepoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AlmJpaRepoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AlmJpaRepoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
