import java.util.Scanner;

public class Item{
    private String name;
    private double price;
    private int amount;

    public Item(){
        name = "Item";
        price = 0.0;
        amount = 0;
    }

    public Item(String name, double price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void displayItemDetails(){
        System.out.println("Item: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Amount: " + getAmount());
    }

}
