package ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.med;

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
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Cart;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.Medicine;

import java.net.URL;
import java.util.ResourceBundle;

public class CartMenuController implements Initializable {

    int pageNumber;
    double totalAmount;

    @FXML
    VBox successBox;

    @FXML
    Button medicineMenuButton, nextPageButton, prevPageButton, purchaseButton;

    @FXML
    Label n1, n2, n3, n4, c1, c2, c3, c4, p1, p2, p3, p4, a1, a2, a3, a4, totalText, changeBox;

    @FXML
    Text insufficientText;

    @FXML
    TextField paymentBox;

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
        Label[] priceFieldArray = new Label[] {p1, p2, p3, p4};
        Label[] amountFieldArray = new Label[] {a1, a2, a3, a4};

        for(int i = 0; i < 4; i++){
            nameFieldArray[i].setText("");
            categoryFieldArray[i].setText("");
            amountFieldArray[i].setText("");
            priceFieldArray[i].setText("");
        }

        for (int i = 0; i < 4; i++){
            try{
                Medicine selected = MedicineApplication.cart.getMedicine(i+pageOffset);
                if (selected != null) {
                    nameFieldArray[i].setText(selected.getName());
                    categoryFieldArray[i].setText(selected.getCategory());
                    amountFieldArray[i].setText(String.valueOf(MedicineApplication.cart.getAmount(i)));
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
        int medicineCount = MedicineApplication.cart.getMedicineCount();
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

    @FXML
    public void calculateTotal(){
        Cart cart = MedicineApplication.cart;
        for(int i = 0; i < cart.medicineCount; i++){
            totalAmount += cart.getAmount(i) * cart.getMedicine(i).getPrice();
        }
        totalText.setText("Total: " + totalAmount);
    }

    @FXML
    public void purchase(){
        Double purchaseAmount = Double.valueOf(paymentBox.getText());
        if (purchaseAmount < totalAmount){
            insufficientText.setVisible(true);
        }
        else {
            insufficientText.setVisible(false);
            successBox.setVisible(true);
            changeBox.setText("Your Change is: " + (purchaseAmount - totalAmount));
            purchaseButton.setDisable(true);
            paymentBox.setDisable(true);
            for (int i = 0; i < MedicineApplication.cart.getMedicineCount(); i++){
                MedicineApplication.mDatabase.reduceStock(MedicineApplication.cart.getMedicine(i).getName(), MedicineApplication.cart.getAmount(i));
                MedicineApplication.cart.clearCart();
            }
        }
    }


    public void initialize(URL url, ResourceBundle rb){
        pageNumber = 0;
        setDisplay();
        checkNextPage();
        checkPrevPage();
        calculateTotal();
        if (MedicineApplication.cart.getMedicineCount() > 0){
            purchaseButton.setDisable(false);
            paymentBox.setDisable(false);
        }
        else {
            purchaseButton.setDisable(true);
            paymentBox.setDisable(true);
        }
        successBox.setVisible(false);
        insufficientText.setVisible(false);
    }
}
