package m2tiil.agence.voyage.client.widgets.ResearchOffer;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ResearchOffer extends Composite {

	public interface UiResearchOffer extends UiBinder<Widget, ResearchOffer> {

	}
	
	private static UiResearchOffer uiResearchOffer = GWT.create(UiResearchOffer.class);

	@UiField Label login;
	@UiField Label password;
	@UiField Button connect;
	@UiField TextBox loginName;
	@UiField TextBox paswd;
	
	public ResearchOffer() {
		initWidget(uiResearchOffer.createAndBindUi(this));
	}
}
