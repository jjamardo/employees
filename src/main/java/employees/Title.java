package employees;

import java.util.Date;

public class Title {
	private TitleId titleId;
	private Employee employee;
	private Date toDate;

	public TitleId getTitleId() {
		return titleId;
	}

	public void setTitleId(TitleId titleId) {
		this.titleId = titleId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
