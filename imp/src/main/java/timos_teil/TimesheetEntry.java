package timos_teil;

public class TimesheetEntry{
	//Attributes
	Date date;
	Time startTime;
	Time endTime;
	Time breakTime;
	Time timeWorked;
	String project;
	
	//Constructors
	public TimesheetEntry(Date date, Time startTime, Time endTime, Time breakTime, String project) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.breakTime = breakTime;
		this.project = project;
		timeWorked = new Time(0,0);
		calcTimeWorked();
	}
	public TimesheetEntry(int d, int m, int y, int hS, int mS, int hE, int mE, int hB, int mB, String p) {
		this.date = new Date(d, m, y);
		this.startTime = new Time(hS, mS);
		this.endTime = new Time(hE, mE);
		this.breakTime = new Time(hB, mB);
		this.project = p;
		timeWorked = new Time(0,0);
		calcTimeWorked();
	}
	
	//Methods
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
		calcTimeWorked();
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
		calcTimeWorked();
	}
	public Time getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(Time breakTime) {
		this.breakTime = breakTime;
		calcTimeWorked();
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Time getTimeWorked() {
		return this.timeWorked;
	}
	public void calcTimeWorked() {
		timeWorked.setHour(endTime.getHour() - startTime.getHour() - breakTime.getHour());
		int minutes = endTime.getMinute() - startTime.getMinute() - breakTime.getMinute();
		while(minutes < 0) {
			minutes += 60;
			timeWorked.setHour(timeWorked.getHour() - 1);
		}
		timeWorked.setMinute(minutes);
	}
}
