package timos_teil;

public class Entry {
	//Attributes
	private int id;
	private static int entryCount;
	
	//Constructor
	public Entry () {
		id = entryCount++;
	};
	
	//Methods
	public static int getEntryCount() {
		return entryCount;
	}
	
	public int getId() {
		return id;
	}
}
