package hib.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hib.HibernateUtils;
import hib.entities.Client;

public class ClientManager
{

	public Session getSession()
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();

		return factory.getCurrentSession();
	}

	public void create(Client client)
	{
		Session session = getSession();
		session.getTransaction().begin();

		session.save(client);

		session.getTransaction().commit();
		session.close();
	}

	public List<Client> getAll()
	{
		Session session = getSession();
		session.getTransaction().begin();

		String sql = "Select c from " + Client.class.getName() + " c " + " order by c.nom ";
		Query<Client> query = session.createQuery(sql);

		List<Client> result = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return result;
	}
}
