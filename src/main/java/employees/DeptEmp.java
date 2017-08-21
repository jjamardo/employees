package employees;

import java.util.Date;

public class DeptEmp {
	private DeptEmpId deptEmptId; 
	private Date fromDate;
	private Date toDate;
    private Employee employee;
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
