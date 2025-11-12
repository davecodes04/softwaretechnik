package com.example.imp;

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
    String message;
    @FXML
    private Text emailText;
    @FXML
    private Text passwordText;
    @FXML
    private Button sendVacationRequestButton;
    @FXML
    private Button sendVacationCancelButton;
    @FXML
    private Button logoutButton;
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

    @FXML
    public void initialize(){
        loadApprovedVacations();
    }

    private void loadApprovedVacations() {
        if(employee.getLastApprovedVacation() != null && !employee.getLastApprovedVacation().isEmpty()) {
            vacationRequestPending.setText("Status: Your vacation request for: " + employee.getLastApprovedVacation() + "\n" + " was approved!");

            int days = date.calculateDaysBetween(employee.getLastApprovedVacation());
            int vacationDays = employee.getVacationDaysLeft();
            employee.setVacationDaysLeft(vacationDays - days);

            avaliableVacationDaysText.setText(String.valueOf(employee.getVacationDaysLeft()));
            vacationOptionMenuItem.setText("empty");

            employee.addVacation(employee.getLastApprovedVacation());
            employee.setApprovedVacations(null);
        }
        if(employee.getRejectedVacation() != null && !employee.getRejectedVacation().isEmpty()){
            vacationRequestPending.setText("Status: " + employee.getMessage() + "\n" +"for " + employee.getRejectedVacation());
        }
    }

    public void showLoggedInUser(){
        emailText.setText(employee.getEmail());
        passwordText.setText(employee.getPassword());
    }

    @FXML
    protected void switchToMain() throws IOException {
        HelloApplication.setRoot("main-page");
    }

    @FXML
    protected void onSendVacationRequest(ActionEvent actionEvent) {
        dateString = vacationFromField.getText();
        dateString += " - " + vacationUntilField.getText();

        vacationRequestPending.setText("Status: Request pending for: " + dateString);
        vacationOptionMenuItem.setText(dateString);

        employee.addRequestVacation(dateString);
    }

    @FXML
    protected void onSendVacationCancel(ActionEvent actionEvent) {
        if(!(vacationOptionMenuItem.getText().equals("empty"))) {
            employee.cancelVacationRequest();
            vacationOptionMenuItem.setText("empty");
            vacationRequestPending.setText("Status: ");
            dropdownVacations.setText("Requested Vacations");
        }
    }

    @FXML
    protected void onLogoutButton(ActionEvent actionEvent) throws IOException {
        switchToMain();
    }

    @FXML
    protected void onVacationOptionMenuItem(ActionEvent actionEvent) {
        dropdownVacations.setText(vacationOptionMenuItem.getText());
    }
}
