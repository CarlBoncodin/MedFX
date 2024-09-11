package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Medicine;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.MedicineDatabase;

public class MainMenuController {
    @FXML
    Button medMenu, appointMenu, exitButton;

    @FXML
    public void medMenuLoad() throws Exception{
        FXMLLoader medLoader = new FXMLLoader(getClass().getResource("MedMenu.fxml"));
        Stage mainStage = (Stage) medMenu.getScene().getWindow();
        mainStage.setScene(new Scene(medLoader.load()));
    }

    public void appointMenuLoad() throws Exception{
        FXMLLoader appointLoader = new FXMLLoader(getClass().getResource("AppointMenu.fxml"));
        Stage mainStage = (Stage) appointMenu.getScene().getWindow();
        mainStage.setScene(new Scene(appointLoader.load()));
    }

    public void saveExit(){
        MedicineApplication.exportDatabases();
        Platform.exit();
    }
}
