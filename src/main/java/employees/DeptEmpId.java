package employees;

import java.io.Serializable;

public class DeptEmpId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String deptNo;
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
}