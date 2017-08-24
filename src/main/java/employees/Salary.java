package employees;

import java.util.Date;

public class Salary {
	private SalaryId salaryId;
	private Employee employee;
	private int salary;
	private Date toDate;

	public SalaryId getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(SalaryId salarieId) {
		this.salaryId = salarieId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
