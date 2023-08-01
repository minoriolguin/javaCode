import java.io.*;
import java.util.ArrayList;

class NameListFixer {
    private String firstName;
    private String lastName;

    public NameListFixer() {
        firstName = "first name";
        lastName = "last name";
    }

    public NameListFixer(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    ArrayList<NameListFixer> nameList = new ArrayList<>();

    void addToNameList(NameListFixer names) {
        nameList.add(names);
    }

    void readNamesFromFile() {
        try {
            FileInputStream inputStream = new FileInputStream("messy_name_list.txt");
            int data = 0;
            String file = "";
            while (data != -1) {
                data = inputStream.read();
                if (data != -1)
                    file += (char) data;
            }
            String[] nameListReader = file.split( "\\s+");
            for (int i = 0; i < nameListReader.length; i+=2) {
                String firstName = nameListReader[i];
                String lastName = nameListReader[i+1];
                addToNameList(new NameListFixer(firstName, lastName));
            }
            System.out.println("\nNames successfully read from messy_name_list.txt.\n");
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nDownload error: File not found\n");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("\nDownload error: io exception\n");
            e.printStackTrace();
        }
    }

    void writeNamesToNewFile() {
        String fullName = "";
        System.out.println("File preview for clean_name_list.txt:\n");
        for (NameListFixer names : nameList) {
            fullName += names.getFirstName() + " " + names.getLastName() + "\n";
        }
        System.out.println(fullName);
        try {
            FileOutputStream outputStream = new FileOutputStream("clean_name_list.txt");
            outputStream.write(fullName.getBytes());
            System.out.println("Names successfully wrote to clean_name_list.txt.\n");
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nFile not found exception: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("\nIO error: ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        NameListFixer nameFixer = new NameListFixer();
        
        nameFixer.readNamesFromFile();
        nameFixer.writeNamesToNewFile();

    }
}