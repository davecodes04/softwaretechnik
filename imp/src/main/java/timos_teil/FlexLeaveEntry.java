package timos_teil;
import dataClass.*;

public class FlexLeaveEntry extends Entry{
	//Attribute
	Date date;
	Time flexTime;
	
	//Constructor
	public FlexLeaveEntry(Date date, Time timeOff) {
		super();
		this.date = date;
		this.flexTime = timeOff;
	}
	
	public FlexLeaveEntry(int day, int month, int year, int hour, int minute) {
		super();
		this.date = new Date(day, month, year);
		this.flexTime = new Time (hour, minute);
	}

	//Methods
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getFlexTime() {
		return this.flexTime;
	}

	public void setFlexTime(Time timeOff) {
		this.flexTime = timeOff;
	}
}
