package user;

import java.util.ArrayList;
import java.util.List;

public class UserAdministration {

    private static final List<User> users = new ArrayList<>();

    // Adds a new user to the list
    public static void addUser(User newUser) {
        // If the id of new user is null (doesn't exist) then we add them to the list
        if (findById(newUser.getId()) == null) {
            users.add(newUser);
        }
    }

    // Finds a user by id
    public static User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    // Finds a user by email
    public static User findByEmail(String email) {
        for (User u : users) {
            if (u.getEmail() != null && u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    // Returns all users that currently exist
    public static List<User> getAllUsers() {
        return users;
    }

    // Returns all employees that currently exist
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (User u : users) {
            if (u.getClass() == Employee.class) {
                employees.add((Employee) u);
            }
        }
        return employees;
    }

    // Deletes all users
    public static void clear() {
        users.clear();
    }
}
