package employees;

import java.util.List;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;

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

		listDeptManagers();
		
		//listEmployees();
		
		//crazyJoin();
	}

	private static void crazyJoin() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(Employee.class, "employee");
			c.createAlias("employee.deptEmps", "deptEmps");
			c.createAlias("deptEmps.department", "department");
			c.add(Restrictions.eq("department.deptName", "Sales"));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("employee.firstName"));
			proList.add(Projections.property("employee.lastName"));
			proList.add(Projections.property("department.deptName"));
			c.setProjection(proList);
			List<?> results = c.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
				Object[] result = (Object[]) iterator.next();
				String firstName = (String) result[0];
				String lastName = (String) result[1];
				String deptName = (String) result[2];
				System.out.println("Name: " + firstName + " " + lastName + " DeptName: " + deptName);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(Employee.class);
			c.setMaxResults(100);
			List<?> results = c.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
				Employee employee = (Employee)iterator.next();
				System.out.println("Salaries Size: " + employee.getSalaries().size() + " Titles Size: " + employee.getTitles().size());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static void listDeptManagers() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(DeptManager.class);
			c.setMaxResults(100);
			List<?> results = c.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
				DeptManager manager = (DeptManager)iterator.next();
				System.out.println("Name: " + manager.getEmployee().getFirstName() + " Department: " + manager.getDepartment().getDeptName());
			}
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