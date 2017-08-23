package employees;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private String deptNo;
	private String deptName;
    private Set<DeptEmp> deptEmps = new HashSet<DeptEmp>();
    private Set<DeptManager> deptManagers = new HashSet<DeptManager>();

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<DeptEmp> getDeptEmps() {
		return deptEmps;
	}

	public void setDeptEmps(Set<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public Set<DeptManager> getDeptManagers() {
		return deptManagers;
	}

	public void setDeptManagers(Set<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}
}