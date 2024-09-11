package ph.edu.dlsu.lbycpei.finalprojectjavafx.objects;

import java.util.ArrayList;

public class Cart {
    public int medicineCount = 0;
    public ArrayList<Medicine> medicineInCart;
    public ArrayList<Integer> amount;

    public Cart(){
        medicineInCart = new ArrayList<>();
        amount = new ArrayList<>();
    }

    public void add(Medicine m, int a){
        medicineInCart.add(m);
        amount.add(a);
        medicineCount++;
    }

    public int getMedicineCount(){
        return medicineCount;
    }

    public Medicine getMedicine(int index){
        return medicineInCart.get(index);
    }

    public int getAmount(int index){
        return amount.get(index);
    }

    public void clearCart(){
        medicineInCart.clear();
        amount.clear();
        medicineCount = 0;
    }
}
