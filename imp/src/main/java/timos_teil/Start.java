package timos_teil;
import entryClass.*;
import dataClass.*;
import accountClass.*;

public class Start {
	static void testEntry() {
		Entry entry1 = new Entry();
		Entry entry2 = new Entry();
		Entry entry3 = new Entry();
		System.out.println("Id entry1: " + entry1.getId());
		System.out.println("Id entry2: " + entry2.getId());
		System.out.println("Id entry3: " + entry3.getId());
		System.out.println("entryCount: " + Entry.getEntryCount());
	}
	
	static void testTimesheetEntry() {
		Date date = new Date(1, 1, 1);
		Time startTime = new Time(8, 20);
		Time endTime = new Time(16, 10);
		Time breakTime = new Time(1, 0);
		TimesheetEntry entry = new TimesheetEntry(date, startTime, endTime, breakTime, "Project");
		Time timeWorked = entry.getTimeWorked();
		System.out.println("time worked: " + timeWorked.getHour() + ":" + timeWorked.getMinute());
	}
	static void printSickLeaveEntries(SickLeaveAccount account) {
		int len = account.getSize();
		for(int i = 0; i < len; i++) {
			SickLeaveEntry entry = account.getEntry(i);
			Date startDate = entry.getStartDate();
			Date endDate = entry.getEndDate();
			System.out.println("-------------------");
			System.out.println("Id: " + entry.getId());
			System.out.println(	"Start date: " + startDate.getDay()
								+ "." + startDate.getMonth()
								+ "." + startDate.getYear());
			System.out.println(	"Start date: " + endDate.getDay()
								+ "." + endDate.getMonth()
								+ "." + endDate.getYear());
		}
	}
	
	static void testAccount() {
		SickLeaveEntry entry1 = new SickLeaveEntry(new Date(24, 2, 2025), new Date(24, 2, 2025));
		SickLeaveEntry entry2 = new SickLeaveEntry(new Date(24, 3, 2025), new Date(24, 3, 2025));
		SickLeaveEntry entry3 = new SickLeaveEntry(new Date(24, 4, 2025), new Date(24, 4, 2025));
		SickLeaveAccount account = new SickLeaveAccount();
		account.addEntry(entry1);
		account.addEntry(entry2);
		account.addEntry(entry3);
		printSickLeaveEntries(account);
		account.removeEntry(1);
		account.clean();
		printSickLeaveEntries(account);
		}
	
	static void printTimesheet(Timesheet timesheet) {
		int len = timesheet.getSize();
		for(int i = 0; i < len; i++) {
			TimesheetEntry entry = timesheet.getEntry(i);
			System.out.println("-------------------");
			System.out.println(	"Date: " + entry.getDate().getDay()
								+ "." + entry.getDate().getMonth()
								+ "." + entry.getDate().getYear());
			System.out.println(	"Start time: " + entry.getStartTime().getHour()
								+ ":" + entry.getStartTime().getMinute());
			System.out.println(	"End time: " + entry.getEndTime().getHour()
					+ ":" + entry.getEndTime().getMinute());
			System.out.println(	"Break time: " + entry.getBreakTime().getHour()
					+ ":" + entry.getBreakTime().getMinute());
			System.out.println(	"Time Worked: " + entry.getTimeWorked().getHour()
					+ ":" + entry.getTimeWorked().getMinute());
			System.out.println("Project: " + entry.getProject());
				}
	}
	
	static void testTimesheet() {
		TimesheetEntry entry = new TimesheetEntry(new Date(20, 9, 2025), new Time(8,0), new Time(18, 0), new Time(2, 0), "Projekt");
		Timesheet timesheet = new Timesheet(9, 2025);
		timesheet.addEntry(entry);
		timesheet.addEntry(new Date(21, 9, 2025), new Time(9,0), new Time(19, 0), new Time(2, 0), "Projekt");
		timesheet.addEntry(22, 9, 2025, 10, 0, 20, 0, 2, 0, "Projekt");
		printTimesheet(timesheet);			
	}
	
	static void printFlextime(FlexLeaveAccount account) {
		System.out.println("-------------------");
		System.out.println(	"Total flextime: " + account.getFlextime().getHour()
							+ ":" + account.getFlextime().getMinute());
		for(Entry temp : account.getEntries()) {
			FlexLeaveEntry entry = (FlexLeaveEntry) temp;
			System.out.println("-------------------");
			System.out.println(	"Date: " + entry.getDate().getDay()
								+ "." + entry.getDate().getMonth()
								+ ":" + entry.getDate().getYear());
			System.out.println(	"Flextime: " + entry.getFlexTime().getHour()
								+ ":" + entry.getFlexTime().getMinute());
		}
	}
	
	static void testFlexTime() {
		FlexLeaveAccount account = new FlexLeaveAccount();
		FlexLeaveEntry entry1 = new FlexLeaveEntry(new Date(9, 9, 2025), new Time(10, 0));
		FlexLeaveEntry entry2 = new FlexLeaveEntry(new Date(9, 9, 2025), new Time(8, 30));
		account.addEntry(entry1);
		account.addEntry(entry2);
		printFlextime(account);
	}
	
	public static void main(String[] args) {
		testFlexTime();
	}
}
