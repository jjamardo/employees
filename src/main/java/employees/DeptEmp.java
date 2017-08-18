package employees;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dept_emp")
public class DeptEmp {
	@EmbeddedId
	private DeptEmpId deptEmptId; 

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    @MapsId("emp_no")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_no")
    @MapsId("dept_no")
    private Department department;
	
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

	public DeptEmpId getDeptEmptId() {
		return deptEmptId;
	}

	public void setDeptEmptId(DeptEmpId deptEmptId) {
		this.deptEmptId = deptEmptId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
