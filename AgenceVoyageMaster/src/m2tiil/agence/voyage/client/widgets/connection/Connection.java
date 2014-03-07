package m2tiil.agence.voyage.client.widgets.connection;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


public class Connection extends Composite {

	public interface UiUserConnection extends UiBinder<Widget, Connection> {

	}
	
	private static UiUserConnection uiUserConnection = GWT.create(UiUserConnection.class);
	
	@UiField Label login;
	@UiField Label password;
	@UiField Button connect;
	@UiField TextBox loginName;
	@UiField TextBox paswd;
	
	public Connection() {
		initWidget(uiUserConnection.createAndBindUi(this));
	}
	
	@UiHandler("connect")
	protected void loginTextNotNull(ClickEvent event){
		if(login.getText().length() == 0){
			Window.alert("toto");
			
			
			
		}
	}
}