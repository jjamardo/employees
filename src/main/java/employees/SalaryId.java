package employees;

import java.io.Serializable;
import java.util.Date;

public class SalaryId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empNo;
	private Date fromDate;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
