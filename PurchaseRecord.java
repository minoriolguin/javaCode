import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class PurchaseRecord {
    private String name;
    private double price;
    private int quantity;
    private double itemTotal;
    private double purchaseTotal;

    public PurchaseRecord() {
        name = "Item name";
        price = 0.0;
        quantity = 0;
        itemTotal = price * (double)quantity;
        purchaseTotal = 0.0;
    }

    public PurchaseRecord(String name, double price, int quantity, double itemTotal, double purchaseTotal) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setItemTotal(price, quantity);
        setPurchaseTotal(purchaseTotal, itemTotal);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
        else {
            System.out.println("price cannot be set to 0 or less, quanitity has automatically been set to $5.0.");
            this.price = 5.0;
        }
    }

    public void setQuantity(int quantity) {
        if(quantity > 0) {
            this.quantity = quantity;
        }
        else {
            System.out.println("quantity cannot be set to 0 or less, quanitity has automatically been set to 1.");
            this.quantity = 1;
        }
    }

    public void setItemTotal(double price, int quanitity) {
        itemTotal = price * (double)quantity;
    }

    public void setPurchaseTotal(double purchaseTotal, double itemTotal) {
        this.purchaseTotal = purchaseTotal + itemTotal;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public double getPurchaseTotal() {
        return purchaseTotal;
    }

    ArrayList<PurchaseRecord> purchaseRecords = new ArrayList<>();

    void addPurchase(PurchaseRecord record) {
        purchaseRecords.add(record);
    }

    void displayPurchaseRecords() {
        if (purchaseRecords.size() > 0) {
            for (PurchaseRecord record : purchaseRecords) {
                System.out.println("\nItem: " + record.getName());
                System.out.println("Price: " + record.getPrice());
                System.out.println("Quantity: " + record.getQuantity());
                System.out.println("Sub Total: " + record.getItemTotal());
            }
            System.out.println("\nPurchase Total: " + sumItemTotals() + "\n");
        }
        else {
            System.out.println("\nNo purchase records to display, download or enter in new records.");
        }
    }

    public static void displayUserMenu() {
        System.out.println("\nPress '1' to add a new purchase record.");
        System.out.println("Press '2' to display purchase records entered.");
        System.out.println("Press '3' to download purchase records from a file.");
        System.out.println("Press '4' to save purchase records to a file.");
        System.out.println("Press '5' to exit the program.");
    }

    public double sumItemTotals() {
        double sumItemTotals = 0.0;
        for (PurchaseRecord record : purchaseRecords) {
            sumItemTotals += record.itemTotal;
        }
        return sumItemTotals; 
    }

    void save() {
        String newRecord = "";

        for (PurchaseRecord record : purchaseRecords) {
            newRecord += record.getName() + "\n";
            newRecord += record.getPrice() + "\n";
            newRecord += record.getQuantity() + "\n";
            newRecord += record.getItemTotal() + "\n";
            newRecord += record.getPurchaseTotal() + "\n";
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("purchase_record.txt", true);
            outputStream.write(newRecord.getBytes());
            System.out.println("\nSaving to purchase_record.txt.\n");
            outputStream.close();
        } catch (Exception e) {
            System.out.println("\nSave error: ");
            e.printStackTrace();
        }   
    }

    void load() {
        try {
            FileInputStream inputStream = new FileInputStream("purchase_record.txt");
            int inputReader = inputStream.read();
            String record = "";
            while (inputReader != -1) {
                record += (char)inputReader;
                inputReader = inputStream.read();
            }
            String[] purchaseRecordRead = record.split("\n");
            int recordSize = 5;
            int i = 0;
            while (i <  purchaseRecordRead.length) {
                String name = purchaseRecordRead[i];
                String inputPrice = purchaseRecordRead[i+1];
                String inputQuantity = purchaseRecordRead[i+2];
                String inputItemTotal = purchaseRecordRead[i+3];
                String inputPurchaseTotal = purchaseRecordRead[i+4];
                double price = Double.parseDouble(inputPrice);
                int quantity = Integer.parseInt(inputQuantity);
                double itemTotal = Double.parseDouble(inputItemTotal);
                double purchaseTotal = Double.parseDouble(inputPurchaseTotal);
                addPurchase(new PurchaseRecord(name, price, quantity, itemTotal, purchaseTotal));
                System.out.println("\nRecord " + (i/recordSize+1) + "\nItem: " + name + "\nPrice: " + price + 
                    "\nQuantity: " + quantity + "\nSub Total: " + itemTotal + "\nPurchase Total: " + purchaseTotal + "\n");
                i+=recordSize;
            }
            System.out.println("Purchase records downloaded: " + purchaseRecordRead.length/recordSize + "\n");
            inputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("\nDownload error: File not found\n");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("\nDownload error: io exception\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PurchaseRecord record = new PurchaseRecord();
        int userOption = 0;

        do{
            displayUserMenu();
            userOption = Integer.parseInt(sc.nextLine());
            if (userOption == 1) {
                System.out.print("\nEnter item name: ");
                record.name = sc.nextLine();
                System.out.print("Enter price: ");
                record.price = sc.nextDouble();
                System.out.print("Enter amount: ");
                record.quantity = sc.nextInt();
                sc.nextLine();
                record.itemTotal = record.price * (double)record.quantity;
                System.out.println("Sub Total: " + record.itemTotal + "\n");
                record.addPurchase(new PurchaseRecord(record.name, record.price, record.quantity, record.itemTotal, record.purchaseTotal));
                record.purchaseTotal = record.sumItemTotals();
                System.out.println("Purchase Total: " + record.purchaseTotal + "\n");
                } 
            else if (userOption == 2) {
                record.displayPurchaseRecords();
                } 
            else if ( userOption == 3 ) {
                record.load();
                }
            else if ( userOption == 4) {
                record.save();
            }
        }
        while(userOption > 0 && userOption < 5);

        sc.close();
    }
}
