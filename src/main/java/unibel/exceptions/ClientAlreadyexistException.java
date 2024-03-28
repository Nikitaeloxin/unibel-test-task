package unibel.exceptions;

public class ClientAlreadyexistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5447987517241409560L;
	
	public ClientAlreadyexistException(String clientName) {
		super("Client " + clientName + "already exists");
	}

}
