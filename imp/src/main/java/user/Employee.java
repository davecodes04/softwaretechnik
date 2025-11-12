package user;

import com.example.imp.mainGUI;
import util.UserIDGenerator;

import java.util.ArrayList;

public class Employee extends User{

    protected Department department;
    protected String pendingVacation;
    protected String approvedVacation;
    protected String rejectedVacation;
    protected ArrayList<String> allVacations = new ArrayList<>();
    protected int vacationDaysLeft = 30;
    protected String message;
    protected mainGUI myGUI;

    public Employee() {
        this.id = UserIDGenerator.getNextId("EMPLOYEE");
    }

    public void submitTimesheet(){
    }

    public void viewTimesheet(){
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void addRequestVacation(String vacation){
        pendingVacation = vacation;
    }

    public String getVacationRequest(){
        return pendingVacation;
    }

    public void cancelVacationRequest(){ pendingVacation = null;}

    public void setApprovedVacations(String date){
        approvedVacation = date;
    }

    public String getLastApprovedVacation(){
        return approvedVacation;
    }

    public ArrayList<String> getAllVacations() {
        return allVacations;
    }

    public void addVacation(String vacation) {
        allVacations.add(vacation);
    }

    public String getRejectedVacation() {
        return rejectedVacation;
    }

    public void setRejectedVacation(String rejectedVacation) {
        this.rejectedVacation = rejectedVacation;
    }


    public void bookFlexLeave(){
    }

    public void viewFlexAccount(){
    }

    public void cancelFlexLeave(){
    }

    public void showStatistics(){
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public Department getDepartment(){
        return department;
    }

    public int getVacationDaysLeft() {
        return vacationDaysLeft;
    }

    public void setVacationDaysLeft(int vacationDaysLeft) {
        this.vacationDaysLeft = vacationDaysLeft;
    }

}
