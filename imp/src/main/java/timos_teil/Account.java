package timos_teil;
import entryClass.*;

public class Account {
	//Attributes
	private Entry[] entries;
	
	//Constructor
	public Account() {};
	
	//Methods
	public void addEntry(Entry entry) {
		if(entries != null) {
			int len = entries.length;
			Entry[] temp = new Entry[len + 1];
			for(int i = 0; i < len; i++) {
				temp[i] = entries [i];
			}
			temp[len] = entry;
			entries = temp;
		} else {
			Entry[] temp = {entry};
			entries = temp;
		}
	}
	
	public Entry getEntry(int index) {
		return entries[index];
	}
	
	public void removeEntry(int index) {
		entries[index] = null;
	}
	
	public Entry[] getEntries() {
		return this.entries;
	}
	
	public int getIndexById(int id) {
		int i = 0;
		for(Entry entry : entries) {
			if(entry.getId() == id) {
				return i;
			} 
			i++;
		}
		return -1;
	}
	
	public int getSize() {
		if(entries == null) {return 0;}
		else {return entries.length;}
	}
	
	public void clean() {
		int num = 0;
		int i = 0;
		for(Entry entry : this.entries) {
			if(entry != null) {
				num++;
			}
		}
		Entry[] temp = new Entry[num];
		for(Entry entry : this.entries) {
			if(entry != null) {
				temp[i++] = entry;
			}
		}
		this.entries = temp;
	}
}
