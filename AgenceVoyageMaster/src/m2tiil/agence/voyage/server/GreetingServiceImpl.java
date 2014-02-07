package m2tiil.agence.voyage.server;

import java.util.Date;
import java.util.Hashtable;

import m2tiil.agence.voyage.client.GreetingService;
import m2tiil.agence.voyage.shared.ConnectionException;
import m2tiil.agence.voyage.shared.FieldVerifier;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// variables
	public Integer timeout = 20000;
	public Integer nbTentative = 20000;
	
	public Hashtable<String,Date> listTokens = new Hashtable<String,Date>();
	
	// helpers
	private void verifToken(String token) throws ConnectionException{
		Date now = new Date();
		Date tokenTimeOut = listTokens.get(token);
		if(tokenTimeOut == null){
			throw new ConnectionException("Pas de connection");
		}else if(tokenTimeOut.before(now)){
			throw new ConnectionException("Temps écoulé");
		}
		
		
	}
	
	
	//// interface
	public String login(String userName, String password) throws ConnectionException{
		String token = "defaultToken";
		int i = 0;
		
		// check user et password
		
		do{
			token = "" + Random.nextInt();
		}while(i<nbTentative && !listTokens.containsKey(token));
		
		if(i == nbTentative){
			throw new ConnectionException("Erreur, il n'y a plus de connection disponible");
		}
		listTokens.put(token, new Date(timeout));
		
		return token;
	}
	
	
	public void registerNewUser(String user, String password, String email){
		
	}
	
	public Object getTypeTransport(String token) throws ConnectionException{
		verifToken(token);
		
		
		return null;
	}
	
	
	public Object getCritere(String token) throws ConnectionException{
		verifToken(token);
		
		
		return null;
	}
	
	public Object getOffreDuJour(String token) throws ConnectionException{
		verifToken(token);
		
		
		return null;
	}
	
	public Object rechercheOffre(String token) throws ConnectionException{
		verifToken(token);
		
		
		return null;
	}
	
	public Object doReservation(String token, String user, Object panier, Object carteBanquaire) throws ConnectionException{
		verifToken(token);
		
		
		return null;
	}
	
	
	
	
}
