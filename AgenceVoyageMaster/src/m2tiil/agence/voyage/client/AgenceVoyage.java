package m2tiil.agence.voyage.client;

import m2tiil.agence.voyage.client.widgets.connection.Connection;
import m2tiil.agence.voyage.client.widgets.offers.Offers;
import m2tiil.agence.voyage.client.widgets.research.Research;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AgenceVoyage implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel vpanel = new VerticalPanel();
		vpanel.add(new Connection());
		vpanel.add(new Research());
		vpanel.add(new Offers());
		RootPanel.get("page1").add(vpanel);
		
	}
}
