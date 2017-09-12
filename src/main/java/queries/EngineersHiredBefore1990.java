package queries;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import employees.Employee;

public class EngineersHiredBefore1990 implements Queryable {
	public void query(Session session) {
		/** Prints all employees that are from Research department and are Engineers */
		/* Using projections instead of create Employee objects */
		Criteria c = session.createCriteria(Employee.class, "employee");
		c.createAlias("employee.deptEmps", "deptEmps");
		c.createAlias("deptEmps.department", "department");
		Criterion co = Restrictions.conjunction() 
                .add(Restrictions.eq("titleId.title","Engineer"));
		c.createCriteria("titles").add(co);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.property("employee.firstName"));
		proList.add(Projections.property("employee.lastName"));
		proList.add(Projections.property("employee.hireDate"));
		proList.add(Projections.property("department.deptName"));
		c.add(Restrictions.le("employee.hireDate", QueryUtils.DateParse("1990-01-01")));
		c.setProjection(proList);
		c.setMaxResults(25000);
		List<?> results = c.list();
		for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
			Object[] result = (Object[]) iterator.next();
			String firstName = (String) result[0];
			String lastName = (String) result[1];
			Date hireDate = (Date) result[2];
			String deptName = (String) result[3];
			System.out.println("Name: " + firstName + " " + lastName + ", Department: " + deptName + ", Hire: " + hireDate);
		}
		System.out.println("Results size: " + results.size());
	}
}
