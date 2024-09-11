package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.appoint;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.MainMenuController;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Appointment;

import java.net.URL;
import java.util.ResourceBundle;

public class TakeMenuController implements Initializable {

    int pageNumber = 0;
    String dateSelect;
    String timeSelect;

    @FXML
    Text successBox;

    @FXML
    VBox detailBox;

    @FXML
    TextField firstNameBox, lastNameBox, contactBox;

    @FXML
    Label d1, d2, d3, d4, t1, t2, t3, t4;

    @FXML
    Button appointButton, takeButton, s1, s2, s3, s4, nextPageButton, prevPageButton;

    @FXML
    public void appointMenuLoad() throws Exception {
        FXMLLoader appointLoader = new FXMLLoader(MainMenuController.class.getResource("AppointMenu.fxml"));
        Stage medStage = (Stage) appointButton.getScene().getWindow();
        medStage.setScene(new Scene(appointLoader.load()));
    }

    public void setDisplay(){
        int pageOffset = pageNumber*4;
        Label[] dateFieldArray = new Label[]{d1, d2, d3, d4};
        Label[] timeFieldArray = new Label[]{t1, t2, t3, t4};
        Button[] buttonArray = new Button[]{s1,s2,s3,s4};

        for(int i = 0; i < 4; i++){
            dateFieldArray[i].setText("");
            timeFieldArray[i].setText("");
            buttonArray[i].setVisible(false);
            buttonArray[i].setDisable(false);
        }

        for (int i = 0; i < 4; i++){
            try{
                Appointment selected = MedicineApplication.aDatabase.getAppointment(i+pageOffset);
                if (selected != null) {
                    dateFieldArray[i].setText(selected.getDate());
                    timeFieldArray[i].setText(selected.getTime());
                    buttonArray[i].setVisible(true);
                    if (selected.isScheduled()){
                        buttonArray[i].setDisable(true);
                    }
                }
            } catch (IndexOutOfBoundsException e){}
        }
    }

    @FXML
    public void nextPage(){
        pageNumber += 1;
        setDisplay();
        checkPrevPage();
        checkNextPage();
    }

    @FXML
    public void prevPage(){
        pageNumber -= 1;
        setDisplay();
        checkNextPage();
        checkPrevPage();
    }

    @FXML
    public void checkNextPage(){
        int appointmentCount = MedicineApplication.aDatabase.getAppointmentCount();
        if (pageNumber >= appointmentCount/4){
            nextPageButton.setDisable(true);
        }
        else nextPageButton.setDisable(false);
    }

    @FXML
    public void checkPrevPage(){
        if ((pageNumber) < 1){
            prevPageButton.setDisable(true);
        }
        else prevPageButton.setDisable(false);
    }

    @FXML
    public void select1(){
        dateSelect = d1.getText();
        timeSelect = t1.getText();
        detailBox.setVisible(true);
        takeButton.setDisable(false);

    }

    @FXML
    public void select2(){
        dateSelect = d2.getText();
        timeSelect = t2.getText();
        detailBox.setVisible(true);
        takeButton.setDisable(false);

    }

    @FXML
    public void select3(){
        dateSelect = d3.getText();
        timeSelect = t3.getText();
        detailBox.setVisible(true);
        takeButton.setDisable(false);

    }

    @FXML
    public void select4(){
        dateSelect = d4.getText();
        timeSelect = t4.getText();
        detailBox.setVisible(true);
        takeButton.setDisable(false);
    }

    public void takeAppoint(){
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String contact = contactBox.getText();

        Appointment selected = MedicineApplication.aDatabase.searchAppointment(dateSelect,timeSelect);
        MedicineApplication.aDatabase.takeAppointment(selected, firstName,lastName,contact);
        takeButton.setDisable(true);
        successBox.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDisplay();
        detailBox.setVisible(false);
        successBox.setVisible(false);
        checkNextPage();
        checkPrevPage();
    }
}
