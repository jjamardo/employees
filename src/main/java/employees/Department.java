package employees;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String deptNo;
	private String deptName;
    private List<DeptEmp> deptEmps = new ArrayList<DeptEmp>();

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

	public List<DeptEmp> getDeptEmps() {
		return deptEmps;
	}

	public void setDeptEmps(List<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}
}
