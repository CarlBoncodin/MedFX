package ph.edu.dlsu.lbycpei.finalprojectjavafx.objects;
import java.util.ArrayList;

public class MedicineDatabase {

    public int medicineCount = 0;
    public ArrayList<Medicine> medicineArray;

    public MedicineDatabase() {
        medicineArray = new ArrayList<>();
    }

    public void addMedicine(String n, String c, double p, int s) {
        medicineArray.add(new Medicine(n, c, p, s));
        medicineCount++;
    }

    public int getMedicineCount() {
        return medicineCount;
    }

    public void setMedicineCount(int medicineCount) {
        this.medicineCount = medicineCount;
    }

    public Medicine getMedicine(int index) {
        return medicineArray.get(index);
    }

    public Medicine search(String sName) {
        for (int counter = 0; counter < medicineCount; counter++) {
            if (sName.equals(medicineArray.get(counter).getName())) {
                return medicineArray.get(counter);
            }
        }
        return null;
    }

    public void reduceStock(String name, int amount){
        search(name).reduceStock(amount);
    }
}
