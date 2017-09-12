package queries;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import employees.Salary;

public class ResearchersWhoEarnLessThanQuery implements Queryable {
	public void query(Session session) {
		/** Prints max salary per employee for an specific limit */
		Criteria c = session.createCriteria(Salary.class, "s");
		c.createAlias("s.employee", "e");
		c.createAlias("e.deptEmps", "de");
		c.createAlias("de.department", "dp");
		Criterion co = Restrictions.conjunction()                    
                .add(Restrictions.isNotNull("salaryId.empNo"));
		c.add(co);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.max("salary"));
		proList.add(Projections.groupProperty("salaryId.empNo"));
		proList.add(Projections.property("e.firstName"));
		proList.add(Projections.property("e.lastName"));
		c.add(Restrictions.le("salary", 70000));
		c.add(Restrictions.eq("dp.deptName", "Research"));
		c.setProjection(proList);
		//c.setMaxResults(4000);
		List<?> results = c.list();
		for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
			Object[] result = (Object[]) iterator.next();
			int salary = (Integer) result[0];
			String firstName = (String) result[2];
			String lastName = (String) result[3];
			System.out.println("Employee: " + firstName + " " + lastName + " Salary: " + salary);
		}
		System.out.println("Result size: " + results.size());
	}
}
