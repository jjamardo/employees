package employees;

import java.io.Serializable;
import java.util.Date;

public class TitleId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String title;
	private Date fromDate;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
