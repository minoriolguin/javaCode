class Food{
    private String type;
    private double weight;
    final double LB_TO_KILO_RATE = 0.453592;

    public Food(){
        type = "No type set";
        weight = 0.0;
    }

    public Food(String initialType, double initialWeight){
        type = initialType;
        if (initialWeight < 0){
            System.out.println("Invalid weight");
        }
        else {
            weight = initialWeight;
        }
    }

    public Food(String initialType){
        type = initialType;
        weight = 0.0;
    }
    
    public Food(double initialWeight){
        type = "No type set";
        if (initialWeight < 0){
            System.out.println("Invalid weight");
        }
        else {
            weight = initialWeight;
        }
    }

    //copy constructor
    public Food(Food foodCopy){
        setType(foodCopy.type);
        setWeight(foodCopy.weight);
    }

    public void setType(String newType){
        type = newType;
    }
     
    public void setWeight(double newWeight){
        weight = newWeight;
    }

    public String getType(){
        return type;
    }

    public double getWeight(){
        return weight;
    }

    public String foodDescription(){
        return "Food type: " + getType() + "\nWeight: " + getWeight() + "lbs \nWeight in kgs: " + (LB_TO_KILO_RATE * getWeight()) + "kgs\n";
    }
}
 

class Fruit extends Food{
    private String color;
    private int gramsOfSugar; 

    public Fruit(){
        color = "No color set";
        gramsOfSugar = 0;
    }

    public Fruit(String initialColor, int initialGramsOfSugar){
        color = initialColor;
        gramsOfSugar = initialGramsOfSugar;
    }

    public Fruit(String initialType, double initialWeight, String initialColor, int initialGramsOfSugar){
        super(initialType, initialWeight);
        color = initialColor;
        gramsOfSugar = initialGramsOfSugar;
    }

    public Fruit(String initialColor){
        color = initialColor;
        gramsOfSugar = 0;
    }

    public Fruit(int initialGramsOfSugar){
        color = "No color set";
        gramsOfSugar = initialGramsOfSugar;
    }

    public Fruit(Fruit fruitCopy){
        setType(fruitCopy.getType());
        setWeight(fruitCopy.getWeight());
        setColor(fruitCopy.color);
        setGramsOfSugar(fruitCopy.gramsOfSugar);
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public void setGramsOfSugar(int newGramsOfSugar){
        gramsOfSugar = newGramsOfSugar;
    }

    public String getColor(){
        return color;
    }

    public int getGramsOfSugar(){
        return gramsOfSugar;
    }

    @Override
    public String foodDescription(){
        return super.foodDescription() + getType() + " is a fruit and contains " + getGramsOfSugar() + " grams of sugar. \n";
    }
}


class Vegtable extends Food{
    private String classification;
    private int gramsOfFibre;

    public Vegtable(){
        classification = "No classification set";
        gramsOfFibre = 0;
    }

    public Vegtable(String initialClassification, int initialGramsOfFibre){
        classification = initialClassification;
        gramsOfFibre = initialGramsOfFibre;
    }

    public Vegtable(String initialClassification){
        classification = initialClassification;
        gramsOfFibre = 0;
    }

    public Vegtable(int initialGramsOfFibre){
        classification = "No classification set";
        gramsOfFibre = initialGramsOfFibre;
    }

    public Vegtable(String initialType, double initialWeight, String initialClassification, int initialGramsOfFibre){
        super(initialType, initialWeight);
        classification = initialClassification;
        gramsOfFibre = initialGramsOfFibre;
    }

    public Vegtable(Vegtable vegtableCopy){
        setType(vegtableCopy.getType());
        setWeight(vegtableCopy.getWeight());
        setClassification(vegtableCopy.classification);
        setGramsOfFibre(vegtableCopy.gramsOfFibre);
    }

    public void setClassification(String newClassification){
        classification = newClassification;
    }

    public void setGramsOfFibre(int newGramsOfFibre){
        gramsOfFibre = newGramsOfFibre;
    }

    public String getClassification(){
        return classification;
    }

    public int getGramsOfFibre() {
        return gramsOfFibre;
    }

    @Override
    public String foodDescription(){
        return super.foodDescription() + getType() + " is a vegtable and contains " + getGramsOfFibre() + " grams of fibre. \n";
    }
}


public class FoodInheritance{
    public static void main (String[] args){

        Fruit strawberry1 = new Fruit("Strawberry", 0.4, "red", 1);
        Fruit strawberry2 = new Fruit(strawberry1);

        Vegtable carrot1 = new Vegtable("Carrot", 0.8, "root", 2);
        Vegtable carrot2 = new Vegtable(carrot1);

        carrot2.setWeight(0.6);
        strawberry2.setWeight(0.9);
        carrot2.setGramsOfFibre(1);
        strawberry2.setGramsOfSugar(3);

        Food[] foods = new Food[9];

        foods[0] = new Food("Fries", 1.7);
        foods[1] = new Fruit("Banana", 0.44, "yellow", 2);
        foods[2] = new Vegtable("Kale", 0.23, "leafy green", 3);
        foods[3] = new Fruit("Kiwi", 2.0, "green", 5);
        foods[4] = new Vegtable("Broccoli", 2.1, "cruciferous", 4);
        foods[5] = strawberry1;
        foods[6] = strawberry2;
        foods[7] = carrot1;
        foods[8] = carrot2;

        for (Food food: foods){
            System.out.println(food.foodDescription());
        }
    }
}