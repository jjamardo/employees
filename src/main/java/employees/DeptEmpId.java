package employees;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class DeptEmpId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "emp_no")
	private int empNo;

	@Column(name = "dept_no")
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