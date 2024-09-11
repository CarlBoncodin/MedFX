package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.appoint;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.MainMenuController;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMenuController implements Initializable {

    @FXML
    Text successBox;

    @FXML
    Button appointButton, addButton;

    @FXML
    TextField dateBox, timeBox;

    @FXML
    public void appointMenuLoad() throws Exception {
        FXMLLoader appointLoader = new FXMLLoader(MainMenuController.class.getResource("AppointMenu.fxml"));
        Stage medStage = (Stage) appointButton.getScene().getWindow();
        medStage.setScene(new Scene(appointLoader.load()));
    }

    public void addAppoint(){
        String date = dateBox.getText();
        String time = timeBox.getText();

        if (date.equalsIgnoreCase("") | time.equalsIgnoreCase("")){
            successBox.setVisible(false);
            return;
        }
        else {
            MedicineApplication.aDatabase.addAppointmentSchedule(date, time);
            successBox.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        successBox.setVisible(false);
    }
}
