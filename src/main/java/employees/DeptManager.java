package employees;

public class DeptManager {
	private DeptManagerId deptManagerId;
	private Employee employee;
	private Department department;

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
}
