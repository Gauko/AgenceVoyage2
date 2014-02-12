package m2tiil.agence.voyage.server.bdd.pojo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Trajet 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	@OneToMany
	@JoinColumn(name="idDepart")
	private Ville villeDepart;
	
	@OneToMany
	@JoinColumn(name="idArrivee")
	private Ville villeArrivee;
	
	@OneToMany
	@JoinColumn(name="idMoyenTransport")
	private MoyenDeTransport moyen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Ville getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}

	public Ville getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(Ville villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public MoyenDeTransport getMoyen() {
		return moyen;
	}

	public void setMoyen(MoyenDeTransport moyen) {
		this.moyen = moyen;
	}
	
}
