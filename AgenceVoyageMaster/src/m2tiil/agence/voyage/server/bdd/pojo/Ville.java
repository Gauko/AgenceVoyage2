package m2tiil.agence.voyage.server.bdd.pojo;

import javax.persistence.*;

@Entity
public class Ville 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
