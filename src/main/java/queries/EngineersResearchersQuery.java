package queries;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import employees.Employee;

public class EngineersResearchersQuery implements Queryable {
	public void query(Session session) {
		/** Prints all employees that are from Research department and are Engineers */
		/* Using projections instead of create Employee objects */
		Criteria c = session.createCriteria(Employee.class, "employee");
		c.createAlias("employee.deptEmps", "deptEmps");
		c.createAlias("deptEmps.department", "department");
		c.add(Restrictions.eq("department.deptName", "Research"));
		Criterion co = Restrictions.conjunction() 
                .add(Restrictions.eq("titleId.title","Engineer"));
		c.createCriteria("titles").add(co);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.property("employee.firstName"));
		proList.add(Projections.property("employee.lastName"));
		c.setProjection(proList);
		List<?> results = c.list();
		for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
			Object[] result = (Object[]) iterator.next();
			String firstName = (String) result[0];
			String lastName = (String) result[1];
			System.out.println("Name: " + firstName + " " + lastName);
		}
	}
}
