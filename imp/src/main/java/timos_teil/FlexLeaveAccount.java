package timos_teil;
import entryClass.*;
import dataClass.*;

public class FlexLeaveAccount extends Account{
	//Attribute
	Time flextime;

	//Constructor
	public FlexLeaveAccount() {
		super();
		this.flextime = new Time(0,0);
	}
	
	//Methods
	public Time getFlextime() {
		return flextime;
	}

	public void setFlextime(Time flextime) {
		this.flextime = flextime;
	}
	
	public void addEntry(FlexLeaveEntry entry) {
		super.addEntry(entry);
		this.flextime.add(entry.getFlexTime());
	}
	
	public void addEntry(int day, int month, int year, int hour, int minute) {
		this.addEntry(new FlexLeaveEntry(day, month, year, hour, minute));
	}
	
	public FlexLeaveEntry getEntry(int index){
		return (FlexLeaveEntry) super.getEntry(index);
	}
}
