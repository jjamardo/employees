package employees;

import java.util.Date;

public class DeptManager {
	private DeptManagerId deptManagerId;
	private Employee employee;
	private Department department;
	private Date fromDate;
	private Date toDate;

	public DeptManagerId getDeptManagerId() {
		return deptManagerId;
	}

	public void setDeptManagerId(DeptManagerId deptManagerId) {
		this.deptManagerId = deptManagerId;
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
}
