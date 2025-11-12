package user;

import java.util.ArrayList;
import java.util.List;

public class UserAdministration {

    private static final List<User> users = new ArrayList<>();

    public static void addUser(User newUser) {
        if (findById(newUser.getId()) == null) {
            users.add(newUser);
        }
    }

    public static User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public static User findByEmail(String email) {
        for (User u : users) {
            if (u.getEmail() != null && u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public static List<User> getAllUsers() {
        return users;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (User u : users) {
            if (u.getClass() == Employee.class) {
                employees.add((Employee) u);
            }
        }
        return employees;
    }

    public static void clear() {
        users.clear();
    }
}
