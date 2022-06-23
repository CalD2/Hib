package hib.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hib.HibernateUtils;
import hib.entities.Produit;

public class ProduitManager
{
	public Session getSession()
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();

		return factory.getCurrentSession();
	}

	public void create(Produit produit)
	{
		Session session = getSession();
		session.getTransaction().begin();

		session.save(produit);

		session.getTransaction().commit();
		session.close();
	}

	public List<Produit> getAll()
	{
		Session session = getSession();
		session.getTransaction().begin();

		String sql = "Select p from " + Produit.class.getName() + " p " + " order by p.nom ";
		Query<Produit> query = session.createQuery(sql);

		List<Produit> result = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return result;
	}
}
