package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.med;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;

public class MedMenuController {
    @FXML
    Button menuButton, browseButton, searchButton, cartButton;

    @FXML
    public void mainMenuLoad() throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(MedicineApplication.class.getResource("MainMenu.fxml"));
        Stage medStage = (Stage) menuButton.getScene().getWindow();
        medStage.setScene(new Scene(mainLoader.load()));
    }

    public void browseMenuLoad() throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("BrowseMenu.fxml"));
        Stage medStage = (Stage) menuButton.getScene().getWindow();
        medStage.setScene(new Scene(mainLoader.load()));
    }

    public void searchMenuLoad() throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("SearchMenu.fxml"));
        Stage medStage = (Stage) menuButton.getScene().getWindow();
        medStage.setScene(new Scene(mainLoader.load()));
    }

    public void cartMenuLoad() throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("CartMenu.fxml"));
        Stage medStage = (Stage) menuButton.getScene().getWindow();
        medStage.setScene(new Scene(mainLoader.load()));
    }
}
