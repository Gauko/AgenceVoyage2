package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Type 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="libelle")
	private String libelle;

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

}
