package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.appoint;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.MainMenuController;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Appointment;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewMenuController implements Initializable {

    int pageNumber;

    @FXML
    Label d1,d2,d3,d4,t1,t2,t3,t4,s1,s2,s3,s4,f1,f2,f3,f4,l1,l2,l3,l4,c1,c2,c3,c4;

    @FXML
    Button appointButton, prevPageButton, nextPageButton;

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
        Label[] scheduledFieldArray = new Label[]{s1, s2, s3, s4};
        Label[] fNameFieldArray = new Label[]{f1, f2, f3, f4};
        Label[] lNameFieldArray = new Label[]{l1, l2, l3, l4};
        Label[] contactFieldArray = new Label[]{c1, c2, c3, c4};

        for(int i = 0; i < 4; i++){
            dateFieldArray[i].setText("");
            timeFieldArray[i].setText("");
            scheduledFieldArray[i].setText("");
            fNameFieldArray[i].setText("");
            lNameFieldArray[i].setText("");
            contactFieldArray[i].setText("");
        }

        for (int i = 0; i < 4; i++){
            try{
                Appointment selected = MedicineApplication.aDatabase.getAppointment(i+pageOffset);
                if (selected != null) {
                    dateFieldArray[i].setText(selected.getDate());
                    timeFieldArray[i].setText(selected.getTime());
                    if (selected.isScheduled()){
                        scheduledFieldArray[i].setText("Yes");
                        fNameFieldArray[i].setText(selected.getFirstName());
                        lNameFieldArray[i].setText(selected.getLastName());
                        contactFieldArray[i].setText(selected.getNumber());
                    }
                    else {
                        scheduledFieldArray[i].setText("No");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pageNumber = 0;
        setDisplay();
        checkNextPage();
        checkPrevPage();
    }
}
