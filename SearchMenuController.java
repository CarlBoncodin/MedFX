package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.med;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.MedicineApplication;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.MainMenuController;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Medicine;

public class SearchMenuController {

    @FXML
    VBox purchaseBox;

    @FXML
    Label n,c,s,p,availableText;

    @FXML
    Button medicineMenuButton, searchButton, cartButton;

    @FXML
    TextField searchBox, amountBox;

    @FXML
    Text addedText;

    @FXML
    public void medMenuLoad() throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(MainMenuController.class.getResource("MedMenu.fxml"));
        Stage medStage = (Stage) medicineMenuButton.getScene().getWindow();
        medStage.setScene(new Scene(mainLoader.load()));
    }

    @FXML
    public void search(){
        String searchName = searchBox.getText();
        Medicine foundMedicine = MedicineApplication.mDatabase.search(searchName);

        if (foundMedicine == null){
            availableText.setVisible(true);
            n.setText("Name: ");
            c.setText("Category: ");
            s.setText("Stock: ");
            p.setText("Price: ");
            purchaseBox.setVisible(false);
        }
        else{
            availableText.setVisible(false);
            n.setText("Name: " + foundMedicine.getName());
            c.setText("Category: " + foundMedicine.getCategory());
            s.setText("Stock: " + foundMedicine.getStock());
            p.setText("Price: " + foundMedicine.getPrice());
            purchaseBox.setVisible(true);
            if (foundMedicine.getStock() > 0){
                cartButton.setDisable(false);
            }
            else cartButton.setDisable(true);
        }
    }

    @FXML
    public void addToCart(){
        String searchName = searchBox.getText();
        Medicine foundMedicine = MedicineApplication.mDatabase.search(searchName);
        int amount = 0;
        try{
            amount = Integer.parseInt(amountBox.getText());
        }
        catch (NumberFormatException e){
        }
        if ((amount != 0)&(amount < foundMedicine.getStock())) {
            MedicineApplication.cart.add(foundMedicine, amount);
            addedText.setVisible(true);
        }
        else addedText.setVisible(false);
    }
}
