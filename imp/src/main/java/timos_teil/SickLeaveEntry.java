package timos_teil;
import dataClass.Date;

public class SickLeaveEntry extends Entry{
	// Attributes
	Date startDate;
	Date endDate;
	
	// Constructor
	public SickLeaveEntry(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	// Methods
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
}
