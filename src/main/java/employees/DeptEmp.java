package employees;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dept_emp")
public class DeptEmp {
	@EmbeddedId
	private DeptEmpPK deptEmptPK; 

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public DeptEmpPK getDeptEmptPK() {
		return deptEmptPK;
	}

	public void setDeptEmptPK(DeptEmpPK deptEmptPK) {
		this.deptEmptPK = deptEmptPK;
	}
}
