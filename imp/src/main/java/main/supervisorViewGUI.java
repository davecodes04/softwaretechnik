package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Employee;
import user.UserAdministration;
import util.Date;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class supervisorViewGUI extends mainGUI {

    Date date = new Date();

    @FXML
    private Button logoutButton;
    @FXML
    private Label newAlertLabel;
    @FXML
    private TextArea vacationRequestsTextarea;
    @FXML
    private Button buttonApproveVacation;
    @FXML
    private Button buttonRejectVacation;
    @FXML
    private TextField vacationRejectionTextfield;

    // Each employee that has a pending request is saved in this list
    private List<Employee> pendingRequests = new ArrayList<>();
    // Iterates from one employee to the next
    private Iterator<Employee> requestIterator;
    private Employee currentEmployee;

    // Gets called as soon as the supervisor view is loaded into FXMLLoader
    @FXML
    public void initialize() {
        loadPendingRequests();
        showNextRequest();
    }

    // Loads the current employee who has an open request
    private void loadPendingRequests() {
        pendingRequests.clear();
        List<Employee> allEmployees = UserAdministration.getAllEmployees();

        for (Employee emp : allEmployees) {
            // Checks if the current employee has a request at all
            if (emp.getVacationRequest() != null && !emp.getVacationRequest().isEmpty()) {
                pendingRequests.add(emp);
            }
        }

        // Checks if there are employees with requests, then the text is set accordingly
        if (pendingRequests.isEmpty()) {
            newAlertLabel.setText("No new vacation requests.");
        } else {
            newAlertLabel.setText("There are new vacation requests!");
        }

        // Returns an iterator over the elements in this list
        requestIterator = pendingRequests.iterator();
    }

    // Is called to show the next employee and his request
    private void showNextRequest() {
        vacationRequestsTextarea.clear();
        vacationRejectionTextfield.clear();

        // Checks if there are still more employees "in line"
        if (requestIterator != null && requestIterator.hasNext()) {
            currentEmployee = requestIterator.next();
            vacationRequestsTextarea.setText(
                    "Request from: " + currentEmployee.getEmail() + "\n" +
                            "For: " + currentEmployee.getVacationRequest()
            );
        } else {
            currentEmployee = null;
            vacationRequestsTextarea.clear();
            newAlertLabel.setText("All requests handled.");
        }
    }

    // Is called when the 'approve' button gets clicked
    @FXML
    protected void onApproveVacation(ActionEvent actionEvent) {
        if (currentEmployee != null) {
            // The vacation request is copied into the local variable
            String request = currentEmployee.getVacationRequest();
            // The vacation request gets added into approved vacations
            currentEmployee.setApprovedVacations(request);
            // The vacation request gets deleted
            currentEmployee.cancelVacationRequest();
            // The approved vacation gets added into the list of all vacations
            currentEmployee.addVacation(request);
            // We use a method in Date to calculate the amount of days between two dates
            int days = date.calculateDaysBetween(request);
            // The total amount of their vacation days gets calculated
            currentEmployee.setVacationDaysLeft(currentEmployee.getVacationDaysLeft() - days);

            newAlertLabel.setText("Approved vacation for: " + currentEmployee.getEmail());
            showNextRequest();
        } else {
            newAlertLabel.setText("No request to approve.");
        }
    }

    // Is called when the 'reject' button gets clicked
    @FXML
    protected void onRejectVacation(ActionEvent actionEvent) {
        if (currentEmployee != null) {
            String reason = vacationRejectionTextfield.getText();
            // If the supervisor doesn't write in a reason for the rejection, then nothing happens
            if (reason == null || reason.isEmpty()) {
                newAlertLabel.setText("Please enter a reason for rejection.");
                return;
            }
            // Get the vacation request from the current employee
            String request = currentEmployee.getVacationRequest();
            // The vacation request is set as rejected
            currentEmployee.setRejectedVacation(request);
            // The rejection reason is passed over to the employee
            currentEmployee.setMessage(reason);
            // The vacation request is canceled
            currentEmployee.cancelVacationRequest();

            // Rejection is displayed for the current employee, and then it displays the next request in line
            newAlertLabel.setText("Rejected vacation for: " + currentEmployee.getEmail());
            showNextRequest();
        } else {
            newAlertLabel.setText("No request to reject.");
        }
    }

    // Switch back to the main GUI view (login page)
    @FXML
    protected void switchToMain() throws IOException {
        HelloApplication.setRoot("main-page");
    }

    // Is called when logout gets clicked
    @FXML
    protected void onLogoutButton(ActionEvent actionEvent) throws IOException {
        switchToMain();
    }
}