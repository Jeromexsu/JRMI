package warehouse2;


import java.io.Serializable;

public class Product implements Serializable {
    private String description;
    private double price;
    private WareHouse location;

    Product(String description,double price){
        this.description=description;
        this.price=price;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public WareHouse getLocation(){
        return location;
    }
    public void setLocation(WareHouse location){
        this.location=location;
    }
}
