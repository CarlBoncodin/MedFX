package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.med;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.MainMenuController;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Medicine;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.MedicineDatabase;

import java.net.URL;
import java.util.ResourceBundle;

public class BrowseMenuController implements Initializable {

    int pageNumber;

    @FXML
    Button medicineMenuButton, nextPageButton, prevPageButton;

    @FXML
    Label n1, n2, n3, n4, c1, c2, c3, c4, s1, s2, s3, s4, p1, p2, p3, p4;

    @FXML
    public void medMenuLoad() throws Exception{
            FXMLLoader mainLoader = new FXMLLoader(MainMenuController.class.getResource("MedMenu.fxml"));
            Stage medStage = (Stage) medicineMenuButton.getScene().getWindow();
            medStage.setScene(new Scene(mainLoader.load()));
    }

    @FXML
    public void setDisplay(){
        int pageOffset = pageNumber*4;
        Label[] nameFieldArray = new Label[]{n1, n2, n3, n4};
        Label[] categoryFieldArray = new Label[]{c1, c2, c3, c4};
        Label[] stockFieldArray = new Label[] {s1, s2, s3, s4};
        Label[] priceFieldArray = new Label[] {p1, p2, p3, p4};

        for(int i = 0; i < 4; i++){
            nameFieldArray[i].setText("");
            categoryFieldArray[i].setText("");
            stockFieldArray[i].setText("");
            priceFieldArray[i].setText("");
        }

        for (int i = 0; i < 4; i++){
            try{
                Medicine selected = MedicineApplication.mDatabase.getMedicine(i + pageOffset);
                if (selected != null) {
                    nameFieldArray[i].setText(selected.getName());
                    categoryFieldArray[i].setText(selected.getCategory());
                    stockFieldArray[i].setText(String.valueOf(selected.getStock()));
                    priceFieldArray[i].setText(String.valueOf(selected.getPrice()));
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
        int medicineCount = MedicineApplication.mDatabase.getMedicineCount();
        if (pageNumber >= medicineCount/4){
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

    public void initialize(URL url, ResourceBundle rb){
        pageNumber = 0;
        setDisplay();
        checkNextPage();
        checkPrevPage();
    }
}
