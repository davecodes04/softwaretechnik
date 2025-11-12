package com.example.imp;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import user.*;

import java.io.IOException;

public class mainGUI {
    protected Employee employee = new Employee();
    protected Supervisor supervisor = new Supervisor();
    protected HR hr = new HR();
    protected CEO ceo = new CEO();
    @FXML
    protected TextField textEmail;
    @FXML
    protected TextField textPassword;
    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem menuItemEmp;
    @FXML
    private MenuItem menuItemSup;

    // Method that switches over to the employee view and calls its first methods to initialize
    @FXML
    private void switchToEmployee() throws IOException {
        employeeViewGUI controller = HelloApplication.setRoot("employee-view");
        controller.showLoggedInUser();
        controller.initialize();
    }

    // Method that switches over to the supervisor view and calls its first methods to initialize
    @FXML
    private void switchToSupervisor() throws IOException {
        supervisorViewGUI controller = HelloApplication.setRoot("supervisor-view");
        controller.initialize();
    }

    // Method that is called when the login button is clicked
    @FXML
    protected void onLoginButton() throws IOException {
        String email = textEmail.getText();
        String password = textPassword.getText();
        String role = menu.getText();

        // Trying to find an existing user by this E-Mail
        User existingUser = UserAdministration.findByEmail(email);

        // different logic is run dependent upon which role is picked
        if (role.equals("Employee")) {
            Employee employeeToLogin;

            // Case 1: User exists and is an employee
            if (existingUser != null && existingUser instanceof Employee) {
                employeeToLogin = (Employee) existingUser;
                // Case 2: User doesn't exist already, so we create them and set their attributes
            } else if (existingUser == null) {
                employeeToLogin = new Employee();
                employeeToLogin.setUsername(email);
                employeeToLogin.setEmail(email);
                employeeToLogin.setPassword(password);
                UserAdministration.addUser(employeeToLogin);

                // Case 3: E-Mail exists, but it's reserved by another user with a different role
            } else {
                System.err.println("This E-Mail is not registered for an Employee");
                return;
            }
            employeeToLogin.login();
            switchToEmployee();

        } else if (role.equals("Supervisor")) {
            Supervisor supervisorToLogin;

            // Case 1: User exists and is a supervisor
            if (existingUser != null && existingUser instanceof Supervisor) {
                supervisorToLogin = (Supervisor) existingUser;

                // Case 2: User doesn't exist already, so we create them and set their attributes
            } else if (existingUser == null) {
                supervisorToLogin = new Supervisor();
                supervisorToLogin.setUsername(email);
                supervisorToLogin.setEmail(email);
                supervisorToLogin.setPassword(password);
                UserAdministration.addUser(supervisorToLogin);

                // Case 3: E-Mail exists, but it's reserved by another user with a different role
            } else {
                System.err.println("This E-Mail is not registered for a Supervisor.");
                return;
            }
            supervisorToLogin.login();
            switchToSupervisor();

        } else if (role.equals("HR")) {
        } else if (role.equals("CEO")) {
        }
    }

    // Is called when a role is chosen in the drop-down menu. In this case 'Employee'
    @FXML
    protected void onEmployeeItemClick(){
        employee.setUserRole(menuItemEmp.getText());
        menu.setText("Employee");
    }
    // Is called when a role is chosen in the drop-down menu. In this case 'Supervisor'
    @FXML
    protected void onSupervisorItemClick(){
        employee.setUserRole(menuItemSup.getText());
        menu.setText("Supervisor");
    }
}