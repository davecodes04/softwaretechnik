package timos_teil;

public class Time {
	// Attributes
	private int hour;
	private int minute;
	
	// Constructor
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	// Methods
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void add(Time flexTime) {
		this.hour += flexTime.getHour();
		this.minute += flexTime.getMinute();
	}
}
