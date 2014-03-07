package m2tiil.agence.voyage.client.widgets.offers;

import java.util.ArrayList;

import m2tiil.agence.voyage.server.bdd.dao.OffreDAO;
import m2tiil.agence.voyage.shared.bdd.pojo.Offre;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;


public class Offers extends Composite {

	private static final Binder binder = GWT.create(Binder.class);
	// DATA
	protected final ListDataProvider<Offre> offres = new ListDataProvider<Offre>();
	
	// TABLE
	@UiField(provided=true) 
	CellTable<Offre> table = new CellTable<Offre>();
	
	final SimplePager pager = new SimplePager();

	interface Binder extends UiBinder<Widget, Offers> {
	}

	public Offers() {
		initWidget(binder.createAndBindUi(this));
		offres.setList(OffreDAO.selectAll());
		createOfferTable();
	}

	public void createOfferTable(){
		
		// Create column.
	    TextColumn<Offre> offreLibelle = new TextColumn<Offre>() {
	      @Override
	      public String getValue(Offre offre) {
	        return offre.getLibelle();
	      }
	    };
	    
	    final MultiSelectionModel<Offre> selectionModel = new MultiSelectionModel<Offre>();
	    this.table.setSelectionModel(selectionModel,DefaultSelectionEventManager.<Offre> createCheckboxManager()  );

	    Column<Offre, Boolean> checkColumn = new Column<Offre, Boolean>(
	    		new CheckboxCell(true, false)) {

					@Override
					public Boolean getValue(Offre object) {
						return selectionModel.isSelected(object);
					}
		};
		
	    // Create column.
	    TextColumn<Offre> offrePrix = new TextColumn<Offre>() {
	      @Override
	      public String getValue(Offre offre) {
			return String.valueOf(offre.getPrix());
	      }
	    };
	    
	    // Add the columns.
		this.table.addColumn(offreLibelle,"Libelle");
	    this.table.addColumn(offrePrix, "Prix");
	    this.table.addColumn(checkColumn);
	    
		offres.addDataDisplay(table);
		
		final SimplePager pager = new SimplePager();
		pager.setDisplay(table);
		System.err.println("toto");
		
		
	}
		
}
