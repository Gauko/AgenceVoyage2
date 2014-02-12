package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Reservation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationDAO 
{
	
	public ArrayList<Reservation> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Reservation");
		
		ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
		
		List<Reservation> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Reservation r = new Reservation();
			r.setUtilisateur(res.get(i).getUtilisateur());
			r.setOffre(res.get(i).getOffre());

			
			Reservations.add(r);
		}

		tx.commit();
		s.close();
		return Reservations;
	}
	
	public Reservation findById(int id)
	{
		ArrayList<Reservation> Reservations = selectAll();
		Iterator<Reservation> i = Reservations.iterator();
		Reservation r = new Reservation();
		for(;i.hasNext() ; r = i.next())
		{
			if (r.getId() == id)
			{
				return r;
			}
		}
		return new Reservation();
	}
	
	public boolean delete(Reservation r)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Reservation where id="+r.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Reservation r)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Reservation(idUtilisateur, idOffre) values ("+r.getUtilisateur()+","+r.getOffre()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Reservation origine, Reservation modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Reservation set idUtilisateur=\'"+modif.getUtilisateur()+"\', idOffre="+modif.getOffre()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}

