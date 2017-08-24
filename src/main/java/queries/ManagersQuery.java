package queries;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import employees.DeptManager;

public class ManagersQuery implements Queryable {
	public void query(Session session) {
		/** Prints all active managers */
		Criteria c = session.createCriteria(DeptManager.class);
		c.add(Restrictions.eq("toDate", QueryUtils.toThePresent()));
		List<?> results = c.list();
		for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
			DeptManager manager = (DeptManager) iterator.next();
			String name = manager.getEmployee().getFirstName() + " " + manager.getEmployee().getLastName();
			String department = manager.getDepartment().getDeptName();
			System.out.println("Department: " + department + ", Manager: " + name + ", From: " + manager.getFromDate());
		}
	}
}
