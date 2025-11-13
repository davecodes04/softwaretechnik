package timos_teil;

import dataClass.Date;

public class VacationEntry extends Entry{
	// Attributes
		Date startDate;
		Date endDate;
		int rejected = 0;
		String rejectionReason = "";
		
		// Constructor
		public VacationEntry(Date startDate, Date endDate) {
			super();
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		// Methods
		public Date getStartDate() {
			return startDate;
		}
		
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		
		public Date getEndDate() {
			return endDate;
		}
		
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
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
}
