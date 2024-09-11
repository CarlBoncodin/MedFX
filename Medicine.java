package ph.edu.dlsu.lbycpei.finalprojectjavafx.objects;

public class Medicine {
    String name;
    String category;
    double price;
    int stock;

    public Medicine(String n, String c, double p, int s){
        name = n;
        category = c;
        price = p;
        stock = s;
    }

    public String getName(){
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reduceStock(int amount) {
        stock -= amount;}
}

