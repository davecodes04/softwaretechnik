package util;

import main.employeeViewGUI;
import main.supervisorViewGUI;

import java.util.ArrayList;
import java.util.List;

public class Notification {

    private static final List<String> notifications = new ArrayList<>();
    static supervisorViewGUI supervisorviewGUI = new supervisorViewGUI();
    static employeeViewGUI employeeviewGUI = new employeeViewGUI();

    public static void sendNotification(String from, String to, String notification){
        switch(to){
            case "Supervisor":
                //supervisorviewGUI.getNotification(from, notification);
                break;
            case "Employee":
                //employeeViewGUI.getNotification(from, notification);
                break;
            case "HR":
                break;
            case "CEO":
                break;
            default: break;
        }
    }

    public static void addNotification(String notification, String type) {
        notifications.add(notification);
    }

    public static List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public static void clearNotifications() {
        notifications.clear();
    }
}