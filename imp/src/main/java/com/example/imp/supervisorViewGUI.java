package com.example.imp;

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

    // Is called
    private void showNextRequest() {
        vacationRequestsTextarea.clear();
        vacationRejectionTextfield.clear();

        if (requestIterator != null && requestIterator.hasNext()) {
            currentEmployee = requestIterator.next();
            vacationRequestsTextarea.setText(
                    "Request from: " + currentEmployee.getEmail() + "\n" +
                            "For: " + currentEmployee.getVacationRequest()
            );
        } else {
            currentEmployee = null;
            vacationRequestsTextarea.setText("No more vacation requests.");
            newAlertLabel.setText("All requests handled.");
        }
    }

    @FXML
    protected void onApproveVacation(ActionEvent actionEvent) {
        if (currentEmployee != null) {
            String request = currentEmployee.getVacationRequest();
            currentEmployee.setApprovedVacations(request);
            currentEmployee.cancelVacationRequest();

            newAlertLabel.setText("Approved vacation for: " + currentEmployee.getEmail());
            showNextRequest();
        } else {
            newAlertLabel.setText("No request to approve.");
        }
    }

    @FXML
    protected void onRejectVacation(ActionEvent actionEvent) {
        if (currentEmployee != null) {
            String reason = vacationRejectionTextfield.getText();
            if (reason == null || reason.isEmpty()) {
                newAlertLabel.setText("Please enter a reason for rejection.");
                return;
            }

            String request = currentEmployee.getVacationRequest();
            currentEmployee.setRejectedVacation(request);
            currentEmployee.setMessage(reason);
            currentEmployee.cancelVacationRequest();

            newAlertLabel.setText("Rejected vacation for: " + currentEmployee.getEmail());
            showNextRequest();
        } else {
            newAlertLabel.setText("No request to reject.");
        }
    }

    @FXML
    protected void switchToMain() throws IOException {
        HelloApplication.setRoot("main-page");
    }

    @FXML
    protected void onLogoutButton(ActionEvent actionEvent) throws IOException {
        switchToMain();
    }
}