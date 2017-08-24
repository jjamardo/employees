package employees;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import queries.*;

public class ManageEmployees {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration().configure();
			factory = conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Queryable query = new ManagersQuery();
		transactionalQuery(query);

		Queryable query2 = new EngineersResearchersQuery();
		transactionalQuery(query2);

		Queryable query3 = new MaxSalaryPerEmployeeQuery();
		transactionalQuery(query3);
	}

	private static void transactionalQuery(Queryable query) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			query.query(session);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}