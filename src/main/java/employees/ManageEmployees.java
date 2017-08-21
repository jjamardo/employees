package employees;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;

public class ManageEmployees {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			AnnotationConfiguration conf = new AnnotationConfiguration().configure();
			conf.addAnnotatedClass(Employee.class);
			conf.addAnnotatedClass(Department.class);
			conf.addAnnotatedClass(DeptEmp.class);
			factory = conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
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
}