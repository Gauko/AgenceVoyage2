package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Offre 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="prix")
	private double prix;
	
	@Column(name="placesTotales")
	private int placesTotales;
	
	@Column(name="placesDisponibles")
	private int placesDisponibles;
	
	@OneToMany
	@JoinColumn(name="idTrajet")
	private Trajet trajet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getPlacesTotales() {
		return placesTotales;
	}

	public void setPlacesTotales(int placesTotales) {
		this.placesTotales = placesTotales;
	}

	public int getPlacesDisponibles() {
		return placesDisponibles;
	}

	public void setPlacesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
		
}
