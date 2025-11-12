package user;

import util.UserIDGenerator;

public class Supervisor extends Employee{

    private Department department;

    public Supervisor() {
        this.id = UserIDGenerator.getNextId("Supervisor");
    }

    public void approveVacationRequest(){

    }

    public void rejectVacationRequest(){

    }

    public void approveTimesheet(){

    }

    public void rejectTimesheet(){

    }

    public void viewTeamOverview(){

    }

    public void approveFlexLeaveRequest(){

    }

    public void rejectFlexLeaveRequest(){

    }

    public void notifySickness(){

    }

    public void notifyOvertime(){

    }
}
