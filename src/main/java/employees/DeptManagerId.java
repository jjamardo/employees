package employees;

import java.io.Serializable;

public class DeptManagerId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int EmpNo;
	private String DeptNo;

	public int getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(int empNo) {
		EmpNo = empNo;
	}

	public String getDeptNo() {
		return DeptNo;
	}

	public void setDeptNo(String deptNo) {
		DeptNo = deptNo;
	}
}
