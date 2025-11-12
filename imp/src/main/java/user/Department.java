package user;

import java.util.ArrayList;

public class Department {

    private String name;
    private Supervisor supervisor;
    private Supervisor supervisorDeputy;
    private ArrayList<Employee> listOfEmployees;

    public Department(String name, Supervisor supervisor, Supervisor supervisorDeputy, Employee employee){
        this.name = name;
        this.supervisor = supervisor;
        this.supervisorDeputy = supervisorDeputy;
        listOfEmployees.add(employee);
    }

    public String getName() {
        return name;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public Supervisor getSupervisorDeputy() {
        return supervisorDeputy;
    }

    public ArrayList<Employee> getListOfEmployees(){
        return listOfEmployees;
    }
}
