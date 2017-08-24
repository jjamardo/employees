package employees;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
	private int empNo;
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDate;
	private Date hireDate;
    private Set<DeptEmp> deptEmps = new HashSet<DeptEmp>();
    private Set<Salary> salaries = new HashSet<Salary>();
    private Set<Title> titles = new HashSet<Title>();
    private Set<DeptManager> deptManagers = new HashSet<DeptManager>();

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Set<DeptEmp> getDeptEmps() {
		return deptEmps;
	}

	public void setDeptEmps(Set<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public Set<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}

	public Set<Title> getTitles() {
		return titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

	public Set<DeptManager> getDeptManagers() {
		return deptManagers;
	}

	public void setDeptManagers(Set<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

}