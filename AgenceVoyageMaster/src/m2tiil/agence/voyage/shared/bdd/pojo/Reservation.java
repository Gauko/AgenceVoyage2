package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Reservation 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@ManyToMany
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany
	@JoinColumn(name="idOffre")
	private Offre offre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	
}
