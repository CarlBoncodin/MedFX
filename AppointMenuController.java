package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.appoint;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;

public class AppointMenuController {

    @FXML
    Button menuButton, addButton, viewButton, takeButton;



    @FXML
    public void mainMenuLoad() throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(MedicineApplication.class.getResource("MainMenu.fxml"));
        Stage medStage = (Stage) menuButton.getScene().getWindow();
        medStage.setScene(new Scene(mainLoader.load()));
    }

    @FXML
    public void addMenuLoad() throws Exception{
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("AddMenu.fxml"));
        Stage medStage = (Stage) addButton.getScene().getWindow();
        medStage.setScene(new Scene(addLoader.load()));
    }

    @FXML
    public void viewMenuLoad() throws Exception{
        FXMLLoader viewLoader = new FXMLLoader(getClass().getResource("ViewMenu.fxml"));
        Stage medStage = (Stage) viewButton.getScene().getWindow();
        medStage.setScene(new Scene(viewLoader.load()));
    }

    @FXML
    public void takeMenuLoad() throws Exception{
        FXMLLoader takeLoader = new FXMLLoader(getClass().getResource("TakeMenu.fxml"));
        Stage medStage = (Stage) takeButton.getScene().getWindow();
        medStage.setScene(new Scene(takeLoader.load()));
    }


}
