package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.MoyenDeTransport;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MoyenDeTransportDAO 
{
	
	public ArrayList<MoyenDeTransport> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from MoyenDeTransport");
		
		ArrayList<MoyenDeTransport> MoyenDeTransports = new ArrayList<MoyenDeTransport>();
		
		List<MoyenDeTransport> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			MoyenDeTransport m = new MoyenDeTransport();
			m.setNom(res.get(i).getNom());

			
			MoyenDeTransports.add(m);
		}

		tx.commit();
		s.close();
		return MoyenDeTransports;
	}
	
	public MoyenDeTransport findById(int id)
	{
		ArrayList<MoyenDeTransport> MoyenDeTransports = selectAll();
		Iterator<MoyenDeTransport> i = MoyenDeTransports.iterator();
		MoyenDeTransport m = new MoyenDeTransport();
		for(;i.hasNext() ; m = i.next())
		{
			if (m.getId() == id)
			{
				return m;
			}
		}
		return new MoyenDeTransport();
	}
	
	public boolean delete(MoyenDeTransport m)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from MoyenDeTransport where id="+m.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(MoyenDeTransport m)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into MoyenDeTransport(nom) values ("+m.getNom()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(MoyenDeTransport origine, MoyenDeTransport modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update MoyenDeTransport set nom=\'"+modif.getNom()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}