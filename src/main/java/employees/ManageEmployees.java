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
		ManageEmployees ME = new ManageEmployees();

		//ME.listEmployees();

		//ME.updateEmployee(499842, new Date());
		
		//Integer empID = ME.addEmployee(500000, "Pedro", "Navaja", "M", new Date(), new Date());
		//Employee employee = ME.getEmployee(empID);
		//System.out.println("EmpNo: " + employee.getEmpNo() + " Name: " + employee.getFirstName() + " " + employee.getLastName());
		//ME.deleteEmployee(empID);

		//ME.listDepartments();

		//ME.listDeptEmp();
		
		ME.Query();
		
		try {
			InputStream file = ManageEmployees.class.getResourceAsStream("/homer_ascii"); 
			BufferedReader in = new BufferedReader(new InputStreamReader(file));
			String line;
			while((line = in.readLine()) != null)
			{
				System.out.println(line);
			}
			in.close();
		} catch  (Exception e) {
			System.out.println(e.toString());
		} finally {
			
		}
	}

	public void Query() {
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

	public void listDepartments() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Department");
			List<?> departments = query.list();
			for (Iterator<?> iterator = departments.iterator(); iterator.hasNext();) {
				Department department = (Department) iterator.next();
				System.out.println("DeptNo: " + department.getDeptNo() + " DeptName: " + department.getDeptName());
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

	public void listDeptEmp() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM DeptEmp");
			List<?> deptemps = query.list();
			for (Iterator<?> iterator = deptemps.iterator(); iterator.hasNext();) {
				DeptEmp deptemp = (DeptEmp) iterator.next();
				System.out.println("DeptEmp => EmpNo: " + deptemp.getEmployee().getEmpNo() + " DeptName: " + deptemp.getDepartment().getDeptName());
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


	/* Method to CREATE an employee in the database */
	public Integer addEmployee(int empNo, String fname, String lname, String gender, Date birthDate, Date hireDate) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEmpNo(empNo);
			employee.setFirstName(fname);
			employee.setLastName(lname);
			employee.setGender(gender);
			employee.setBirthDate(birthDate);
			employee.setHireDate(hireDate);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Employee");
			List<?> employees = query.list();
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("EmpNo: " + employee.getEmpNo() + " Name: " + employee.getFirstName() + " " + employee.getLastName());
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

	public Employee getEmployee(Integer empNo) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, empNo);
			tx.commit();
			return employee;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer empNo, Date date) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, empNo);
			employee.setGender("F");
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			session.delete(employee);
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