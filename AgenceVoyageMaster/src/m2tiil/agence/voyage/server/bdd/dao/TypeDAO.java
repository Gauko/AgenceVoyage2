package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.server.bdd.pojo.Type;

import org.hibernate.*;




public class TypeDAO 
{
	
	public ArrayList<Type> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Type");
		
		ArrayList<Type> Types = new ArrayList<Type>();
		
		List<Type> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Type v = new Type();
			v.setLibelle(res.get(i).getLibelle());

			
			Types.add(v);
		}

		tx.commit();
		s.close();
		return Types;
	}
	
	public Type findById(int id)
	{
		ArrayList<Type> Types = selectAll();
		Iterator<Type> i = Types.iterator();
		Type v = new Type();
		for(;i.hasNext() ; v = i.next())
		{
			if (v.getId() == id)
			{
				return v;
			}
		}
		return new Type();
	}
	
	public boolean delete(Type t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Type where id="+t.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Type t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Type(libelle) values ("+t.getLibelle()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Type origine, Type modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Type set libelle=\'"+modif.getLibelle()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}