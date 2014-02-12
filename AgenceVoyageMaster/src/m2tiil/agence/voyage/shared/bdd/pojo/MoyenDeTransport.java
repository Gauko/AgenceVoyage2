package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class MoyenDeTransport
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="type")
	private Type type;

	@ManyToOne
	@JoinColumn(name="societe")
	private Societe societe;
	

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
}