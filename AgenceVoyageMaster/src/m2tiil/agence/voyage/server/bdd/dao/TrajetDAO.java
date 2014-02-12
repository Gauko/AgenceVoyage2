package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.server.bdd.pojo.Trajet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TrajetDAO 
{
	
	public ArrayList<Trajet> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Trajet");
		
		ArrayList<Trajet> Trajets = new ArrayList<Trajet>();
		
		List<Trajet> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Trajet t = new Trajet();
			t.setDate(res.get(i).getDate());
			t.setVilleDepart(res.get(i).getVilleDepart());
			t.setVilleArrivee(res.get(i).getVilleArrivee());
			t.setMoyen(res.get(i).getMoyen());

			
			Trajets.add(t);
		}

		tx.commit();
		s.close();
		return Trajets;
	}
	
	public Trajet findById(int id)
	{
		ArrayList<Trajet> Trajets = selectAll();
		Iterator<Trajet> i = Trajets.iterator();
		Trajet t = new Trajet();
		for(;i.hasNext() ; t = i.next())
		{
			if (t.getId() == id)
			{
				return t;
			}
		}
		return new Trajet();
	}
	
	public boolean delete(Trajet t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Trajet where id="+t.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Trajet t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Trajet(date, idDepart, idArrivee, idMoyenTransport) values ("+t.getDate()+","+t.getVilleDepart()+","+t.getVilleArrivee()+","+t.getMoyen()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Trajet origine, Trajet modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Trajet set date=\'"+modif.getDate()+"\', idDepart="+modif.getVilleDepart()+"\', idArrivee="+modif.getVilleArrivee()+"\', idMoyenTransport="+modif.getMoyen()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}

