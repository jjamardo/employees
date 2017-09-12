package queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import employees.Employee;

public class ListEmployeesQuery implements Queryable {
	public void query(Session session) {
		Criteria c = session.createCriteria(Employee.class);
	    c.setMaxResults(100);
	    List<?> results = c.list();
	    for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
			Employee employee = (Employee)iterator.next();
			String name = employee.getFirstName() + " " + employee.getLastName();
			System.out.println("Employee: " + name);
		}
	}
}
