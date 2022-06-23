package hib.query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hib.HibernateUtils;
import hib.entities.Employee;

public class QueryObjectDemo
{

	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try
		{

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			Employee empl = new Employee();
			empl.setEmpName("test");
			empl.setEmpNo("12");
			empl.setJob("test");
			empl.setSalary(120f);

			session.save(empl);

			// Create an HQL statement, query the object.
			// Equivalent to the SQL statement:
			// Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
			String sql = "Select e from " + Employee.class.getName() + " e " + " order by e.empName, e.empNo ";

			// Create Query object.
			Query<Employee> query = session.createQuery(sql);

			// Execute query.
			List<Employee> employees = query.getResultList();

			for (Employee emp : employees)
			{
				System.out.println("Emp: " + emp.getEmpNo() + " : " + emp.getEmpName());
			}

			// Commit data.
			session.getTransaction().commit();
			String a = "ok";
		} catch (Exception e)
		{
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
	}

}