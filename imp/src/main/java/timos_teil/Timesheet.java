package timos_teil;
import dataClass.*;

public class Timesheet extends Entry{
	//Attributes
	Date date;
	TimesheetEntry[] entries;
	int rejected = 0;
	String rejectionReason = "";
	
	//Constructor
	public Timesheet(int month, int year) {
		super();
		date = new Date(0, 0, 0);
		this.date.setMonth(month);
		this.date.setYear(year);
	}
	
	//Methods
	public void setMonth(int month) {
		this.date.setMonth(month);
	}
	
	public void setYear(int year) {
		this.date.setYear(year);
	}
	
	public int getMonth() {
		return this.date.getMonth();
	}
	
	public int getYear() {
		return this.date.getYear();
	}
	
	public void addEntry(TimesheetEntry entry) {
		if(entries != null) {
			int len = entries.length;
			TimesheetEntry[] temp = new TimesheetEntry[len + 1];
			for(int i = 0; i < len; i++) {
				temp[i] = entries [i];
			}
			temp[len] = entry;
			entries = temp;
		} else {
			TimesheetEntry[] temp = {entry};
			entries = temp;
		}	
	}
	
	public void addEntry(Date date, Time startTime, Time endTime, Time breakTime, String project) {
		this.addEntry(new TimesheetEntry(date, startTime, endTime, breakTime, project));
	}
	
	public void addEntry(int d, int m, int y, int hS, int mS, int hE, int mE, int hB, int mB, String p) {
		this.addEntry(new TimesheetEntry(d, m, y, hS, mS, hE, mE, hB, mB, p));
	}
	
	public TimesheetEntry getEntry(int index) {
		return entries[index];
	}
	
	public void removeEntry(int index) {
		entries[index] = null;
	}
	
	public int getSize() {
		if(entries == null) {return 0;}
		else {return entries.length;}
	}
	
	public int getIndexByDate(Date date) {
		int i = 0;
		for(TimesheetEntry entry : entries) {
			if(entry.getDate() == date) {
				return i;
			} 
			i++;
		}
		return -1;
	}
	
	public void clean() {
		int num = 0;
		int i = 0;
		for(TimesheetEntry entry : this.entries) {
			if(entry != null) {
				num++;
			}
		}
		TimesheetEntry[] temp = new TimesheetEntry[num];
		for(TimesheetEntry entry : this.entries) {
			if(entry != null) {
				temp[i++] = entry;
			}
		}
		this.entries = temp;
	}

	public void reject(String reason) {
		this.rejected = 1;
		this.rejectionReason = reason;
	}
	
	public void revertRejection() {
		this.rejected = 0;
		this.rejectionReason = "";
	}
	
	public int isRejected() {
		return this.rejected;
	}
	
	public String getReason() {
		return this.rejectionReason;
	}
	
	public TimesheetEntry[] getEntries() {
		return this.entries;
	}
}
