package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.Employee;
import user.UserSession;
import util.Date;
import java.io.IOException;

public class employeeViewGUI extends mainGUI{
    Employee employee = (Employee) UserSession.getCurrentUser();
    Date date = new Date();
    String dateString;
    @FXML
    private Text emailText;
    @FXML
    private Button sendVacationRequestButton;
    @FXML
    private Button sendVacationCancelButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TextArea allVacationsTextarea;
    @FXML
    private TextField vacationFromField;
    @FXML
    private TextField vacationUntilField;
    @FXML
    private Text avaliableVacationDaysText;
    @FXML
    private Label vacationRequestPending;
    @FXML
    private MenuButton dropdownVacations;
    @FXML
    private MenuItem vacationOptionMenuItem;

    // First method that runs
    @FXML
    public void initialize(){
        loadApprovedVacations();
    }

    // Gets called by initialize
    private void loadApprovedVacations() {
        // Checks ff an approved vacation exists
        if(employee.getLastApprovedVacation() != null && !employee.getLastApprovedVacation().isEmpty()) {
            // Message for the employee that their request has been approved
            vacationRequestPending.setText("Status: Your vacation request for: " + employee.getLastApprovedVacation() + "\n" + " was approved!");

            // We use a method in Date to calculate the amount of days between two dates
            int days = date.calculateDaysBetween(employee.getLastApprovedVacation());
            int vacationDays = employee.getVacationDaysLeft();
            // The total amount of their vacation days gets calculated
            employee.setVacationDaysLeft(vacationDays - days);

            // Their new amount of vacation days left gets displayed
            avaliableVacationDaysText.setText(String.valueOf(employee.getVacationDaysLeft()));
            vacationOptionMenuItem.setText("empty");

            // The approved vacation is now processed and gets added to their vacation list
            employee.addVacation(employee.getLastApprovedVacation());
            // Loops through all approved vacations and appends them to the Textarea
            for(int i = 1; i < employee.getAllVacations().size()+1; i++){
                allVacationsTextarea.appendText(i + ": " + employee.getAllVacations().get(i-1) + "\n");
            }
            employee.setApprovedVacations(null);
        }
        // Checks if there is a rejected vacation request
        if(employee.getRejectedVacation() != null && !employee.getRejectedVacation().isEmpty()){
            // The rejection reason is displayed
            vacationRequestPending.setText("Status: " + employee.getMessage() + "\n" +"for " + employee.getRejectedVacation());
        }
    }

    // Displays the current users email and password in the bottom left
    public void showLoggedInUser(){
        emailText.setText(employee.getEmail());
    }

    // Switches back to the main GUI
    @FXML
    protected void switchToMain() throws IOException {
        HelloApplication.setRoot("main-page");
    }

    // Is called when the 'send' button gets clicked
    @FXML
    protected void onSendVacationRequest(ActionEvent actionEvent) {
        // Checks if there is an unprocessed request already
        if(employee.getVacationRequest() == null){
            // We add the text from both text fields into one variable with a '-' in between
            dateString = vacationFromField.getText();
            dateString += " - " + vacationUntilField.getText();

            // Status is updated for current request
            vacationRequestPending.setText("Status: Request pending for: " + dateString);
            vacationOptionMenuItem.setText(dateString);

            // Request vacation gets added
            employee.addRequestVacation(dateString);
        }else{
            System.err.println("Can't make a new request before the last one has been processed!");
        }
    }

    // Is called when the 'cancel' button gets clicked
    @FXML
    protected void onSendVacationCancel(ActionEvent actionEvent) {
        // Checks if there is currently a vacation request pending
        if(!(vacationOptionMenuItem.getText().equals("empty"))) {
            // Vacation request gets canceled
            employee.cancelVacationRequest();
            // Everything gets reset
            vacationOptionMenuItem.setText("empty");
            vacationRequestPending.setText("Status: ");
            dropdownVacations.setText("Requested Vacations");
        }
    }

    // Is called when 'logout' gets clicked
    @FXML
    protected void onLogoutButton(ActionEvent actionEvent) throws IOException {
        switchToMain();
    }

    // Gets called when a menu item gets clicked
    @FXML
    protected void onVacationOptionMenuItem(ActionEvent actionEvent) {
        dropdownVacations.setText(vacationOptionMenuItem.getText());
    }
}
