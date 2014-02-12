package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.server.bdd.pojo.Offre;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OffreDAO 
{
	
	public ArrayList<Offre> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Offre");
		
		ArrayList<Offre> offres = new ArrayList<Offre>();
		
		List<Offre> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Offre o = new Offre();
			o.setId(res.get(i).getId());
			o.setLibelle(res.get(i).getLibelle());
			o.setPlacesDisponibles(res.get(i).getPlacesDisponibles());
			o.setPlacesTotales(res.get(i).getPlacesTotales());
			o.setPrix(res.get(i).getPrix());
			o.setTrajet(res.get(i).getTrajet());
			
			offres.add(o);
		}

		tx.commit();
		s.close();
		return offres;
	}
	
	public Offre findById(int id)
	{
		ArrayList<Offre> offres = selectAll();
		Iterator<Offre> i = offres.iterator();
		Offre o = new Offre();
		for(;i.hasNext() ; o = i.next())
		{
			if (o.getId() == id)
			{
				return o;
			}
		}
		return new Offre();
	}
	
	public boolean delete(Offre o)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Offre where id="+o.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Offre o)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Offre(libelle, placesDisponibles, placesTotales, prix, idTrajet) values (\'"+o.getLibelle()+"\',"+o.getPlacesDisponibles()+","+o.getPlacesTotales()+","+o.getPrix()+","+o.getTrajet()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Offre origine, Offre modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Offre set libelle=\'"+modif.getLibelle()+"\', placesDisponibles="+modif.getPlacesDisponibles()+", placesTotales="+modif.getPlacesTotales()+",prix="+modif.getPrix()+", idTrajet="+modif.getTrajet()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}
