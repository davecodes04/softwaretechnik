package timos_teil;
import entryClass.*;

public class VacationAccount extends Account{
	//Constructor
	public VacationAccount() {};
		
	//Methods
	public void addEntry(VacationEntry entry) {
		super.addEntry(entry);
	}
		
	public VacationEntry getEntry(int index){
		return (VacationEntry) super.getEntry(index);	
	}
}
