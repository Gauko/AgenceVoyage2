package m2tiil.agence.voyage.server.bdd.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.server.bdd.pojo.Utilisateur;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtilisateurDAO 
{
	
	public ArrayList<Utilisateur> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("from Utilisateur");
		
		ArrayList<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
		
		List<Utilisateur> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Utilisateur u = new Utilisateur();
			u.setId(res.get(i).getId());
			u.setNom(res.get(i).getNom());
			u.setPrenom(res.get(i).getPrenom());
			u.setMail(res.get(i).getMail());
			
			Utilisateurs.add(u);
		}

		tx.commit();
		s.close();
		return Utilisateurs;
	}
	
	public Utilisateur findById(int id)
	{
		ArrayList<Utilisateur> Utilisateurs = selectAll();
		Iterator<Utilisateur> i = Utilisateurs.iterator();
		Utilisateur u = new Utilisateur();
		for(;i.hasNext() ; u = i.next())
		{
			if (u.getId() == id)
			{
				return u;
			}
		}
		return new Utilisateur();
	}
	
	public boolean delete(Utilisateur u)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Utilisateur where id="+u.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean save(Utilisateur u)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Utilisateur(nom, prenom, mail) values (\'"+u.getNom()+"\',\'"+u.getPrenom()+"\',\'"+u.getMail()+"\')");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public boolean update(Utilisateur origine, Utilisateur modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Utilisateur set nom=\'"+modif.getNom()+"\', prenom=\'"+modif.getPrenom()+"\', mail=\'"+modif.getMail()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}
