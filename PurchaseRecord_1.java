import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class PurchaseRecord{
    private String name;
    private double price;
    private int quantity;
    private double total;

    public PurchaseRecord(){
        name = "Item name";
        price = 0.0;
        quantity = 0;
    }

    public PurchaseRecord(String name, double price, int quantity){
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }
        else{
            System.out.println("price cannot be set to 0 or less, quanitity has automatically been set to $5.0.");
            this.price = 5.0;
        }
    }

    public void setQuantity(int quantity) {
        if(quantity > 0){
            this.quantity = quantity;
        }
        else{
            System.out.println("quantity cannot be set to 0 or less, quanitity has automatically been set to 1.");
            this.quantity = 1;
        }
    }

    public void setTotal(double price, int quanitity) {
        total = price * (double)quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public void displayPurchase(){
        System.out.println("\nItem: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Purchase total: " + getTotal());
    }

    ArrayList<PurchaseRecord> purchaseRecords = new ArrayList<>();

    void addPurchase(PurchaseRecord purchaseRecord){
        purchaseRecords.add(purchaseRecord);
    }

    void displayPurchaseRecords(){
        for (PurchaseRecord purchaseRecord : purchaseRecords){
            purchaseRecord.displayPurchase();
        }
    }

    void upload(){
        String newPurchaseRecord = "";
        for (PurchaseRecord purchaseRecord : purchaseRecords){
            newPurchaseRecord += purchaseRecord.getName() + "\n";
            newPurchaseRecord += purchaseRecord.getPrice() + "\n";
            newPurchaseRecord += purchaseRecord.getQuantity() + "\n";
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("purchase_record.txt", true);
            outputStream.write(newPurchaseRecord.getBytes());
            outputStream.close();
        } catch (Exception exception) {
            System.out.println("Upload error: ");
            exception.getStackTrace();
        }
    }

    void download(){
        try {
            FileInputStream inputStream = new FileInputStream("purchase_record.txt");
            int inputReader = inputStream.read();
            String purchaseRecords = "";
            while (inputReader != -1) {
                purchaseRecords += (char)inputReader;
                inputReader = inputStream.read();
            }
            String[] purchaseRecord = purchaseRecords.split("\n");
            int i = 0;
            System.out.println("Purchase records downloaded: " + purchaseRecord.length/4 + "\n");
            while (i <  purchaseRecord.length) {
                String name = purchaseRecord[i];
                String inputPrice = purchaseRecord[i+1];
                String inputQuantity = purchaseRecord[i+2];
                String inputTotal = purchaseRecord[i+3];
                double price = Double.parseDouble(inputPrice);
                int quantity = Integer.parseInt(inputQuantity);
                double total = Double.parseDouble(inputTotal);
                addPurchase(new PurchaseRecord(name, price, quantity));
                System.out.println("Record " + (i/4+1) + "\nItem: " + name + "\nPrice: " + price + "\nQuantity: " + quantity + "\nPurchase Total: " + total + "\n");
                i+=4;
            }
            inputStream.close();
        } catch (Exception exception) {
            System.out.println("Download error");
            exception.getStackTrace();
        }
    }

    public static void displayUserMenu(){
        System.out.println("Press '1' to add a new purchase record.");
        System.out.println("Press '2' to display purchase records entered.");
        System.out.println("Press '3' to download purchase records from a file.");
        System.out.println("Press '4' to exit the program.");
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        PurchaseRecord purchase = new PurchaseRecord();
        int userOption = 0;
        do{
            displayUserMenu();
            userOption = Integer.parseInt(sc.nextLine());
            if (userOption == 1) {
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter amount: ");
                int quanitity = sc.nextInt();
                sc.nextLine();
                double purchaseTotal = price * (double)quanitity;
                System.out.println("Purchase Total: " + purchaseTotal + "\n");
                purchase.addPurchase(new PurchaseRecord(name, price, quanitity));
                purchase.upload();
                } 
            else if (userOption == 2) {
                purchase.displayPurchaseRecords();
                } 
            else if ( userOption == 3 ) {
                    purchase.download();
                }
        }
        while(userOption > 0 && userOption < 4);

        sc.close();
    }

}
/* 
Question 1. Write a program that will record the purchases made at a store. For each purchase, read
from the keyboard an item’s name, its cost price and the numbers bought. Compute the cost of the
purchase. And write all this data to a text file. Also, display this information and the current total cost on
the screen. After all items have been entered, write the total cost to both the screen and the file. Since
we want to remember all purchases made, you should append new data to the end of the file.
Submission: Run this program 2 – 3 times. Store the record of the purchases in the text file. Submit a
java file and a text file to the D2L.

Question 2:
Suppose you are given a text file that contains the names of people. Every name in the file consists of
first name and last name. Unfortunately, the programmer who created the file of names had a strange
sense of humor and did not guarantee that each name was on a single line of the file. Read the file of
names and write them to a new text file, one name per line. For example, if the input file contains
Bon Jones Fred
Charles Ed
Marston
Jeff
Williams
The output file should be
Bon Jones
Fred Charles
Ed Marston
Jeff Williams
Submission: Submit a java file and input text file to the D2L.
Rubric:
Submission of input text file (1 marks)
Submission of java file (1 marks)
Correct output file produced (6)
For each of the question, you should handle exception. For example, if files not does exist, your program
should generate an exception. (4 marks)*/
