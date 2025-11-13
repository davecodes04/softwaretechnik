package timos_teil;
import entryClass.*;

public class SickLeaveAccount extends Account{
	//Constructors
	public SickLeaveAccount() {};
	
	//Methods
	public void addEntry(SickLeaveEntry entry) {
		super.addEntry(entry);
	}
	
	public SickLeaveEntry getEntry(int index){
		return (SickLeaveEntry) super.getEntry(index);	
}
}