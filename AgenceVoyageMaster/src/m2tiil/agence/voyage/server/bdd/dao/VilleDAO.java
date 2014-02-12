package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Ville;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VilleDAO 
{
	
	public ArrayList<Ville> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Ville");
		
		ArrayList<Ville> Villes = new ArrayList<Ville>();
		
		List<Ville> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Ville v = new Ville();
			v.setNom(res.get(i).getNom());

			
			Villes.add(v);
		}

		tx.commit();
		s.close();
		return Villes;
	}
	
	public Ville findById(int id)
	{
		ArrayList<Ville> Villes = selectAll();
		Iterator<Ville> i = Villes.iterator();
		Ville v = new Ville();
		for(;i.hasNext() ; v = i.next())
		{
			if (v.getId() == id)
			{
				return v;
			}
		}
		return new Ville();
	}
	
	public boolean delete(Ville v)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Ville where id="+v.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Ville v)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Ville(nom) values ("+v.getNom()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Ville origine, Ville modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Ville set nom=\'"+modif.getNom()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}