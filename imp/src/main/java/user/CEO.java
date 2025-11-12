package user;

import com.example.imp.mainGUI;
import util.UserIDGenerator;

public class CEO extends Employee{

    private mainGUI myGUI;

    public CEO() {
        this.id = UserIDGenerator.getNextId("CEO");
    }

    public void enterVacation(){

    }
}
