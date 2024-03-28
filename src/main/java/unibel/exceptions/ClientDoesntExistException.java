package unibel.exceptions;

public class ClientDoesntExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4578543748236859647L;
	
	public ClientDoesntExistException() {
		super("Client doesnt exists");
	}

}
