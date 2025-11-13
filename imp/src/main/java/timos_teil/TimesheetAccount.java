package timos_teil;
import entryClass.*;

public class TimesheetAccount extends Account{
	//Constructor
	TimesheetAccount(){}
	
	//Methods
	public void addEntry(Timesheet entry) {
		super.addEntry(entry);
	}
	public Timesheet getEntry(int index){
		return (Timesheet) this.getEntries()[index];
	}
}
