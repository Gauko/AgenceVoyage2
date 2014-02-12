package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.server.bdd.pojo.Societe;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SocieteDAO 
{
	
	public ArrayList<Societe> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Societe");
		
		ArrayList<Societe> Societes = new ArrayList<Societe>();
		
		List<Societe> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Societe so = new Societe();
			so.setNom(res.get(i).getNom());

			
			Societes.add(so);
		}

		tx.commit();
		s.close();
		return Societes;
	}
	
	public Societe findById(int id)
	{
		ArrayList<Societe> Societes = selectAll();
		Iterator<Societe> i = Societes.iterator();
		Societe so = new Societe();
		for(;i.hasNext() ; so = i.next())
		{
			if (so.getId() == id)
			{
				return so;
			}
		}
		return new Societe();
	}
	
	public boolean delete(Societe so)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Societe where id="+so.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Societe so)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Societe(nom) values ("+so.getNom()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Societe origine, Societe modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Societe set nom=\'"+modif.getNom()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}