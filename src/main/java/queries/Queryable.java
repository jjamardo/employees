package queries;

import org.hibernate.Session;

public interface Queryable {
	public void query(Session session);
}
