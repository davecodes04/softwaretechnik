package user;

import util.UserIDGenerator;

public class HR extends Employee{

    public HR() {
        this.id = UserIDGenerator.getNextId("HR");
    }

    public void createUser(){

    }

    public void manageUser(User user){

    }

    public void deactivateUser(User user){

    }

    public void enterSickness(User user){

    }

    public void enterApprovedVacation(){

    }

    public void enterApprovedFlexLeave(){

    }
}
