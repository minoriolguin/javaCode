class Animal{
    private String name;
    private int age;

    //default constructor
    public Animal(){
        name = "No name set";
        age = 0;
    }

    //main constructor
    public Animal(String initialName, int initialAge){
        name = initialName;
        if (initialAge < 0){
            System.out.println("Invalid Age");
        }
        else {
            age = initialAge;
        }
    }

    public Animal(String initialName){
        name = initialName;
        age = 0;
    }
    
    public Animal(int initialAge){
        name = "No name set";
        if (initialAge < 0){
            System.out.println("Invalid Age");
        }
        else {
            age = initialAge;
        }
    }

    //copy constructor
    public Animal(Animal animalCopy){
        setName(animalCopy.name);
        setAge(animalCopy.age);
    }

    public void setName(String newName){
        name = newName;
    }
     
    public void setAge(int newAge){
        age = newAge;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String animalDescription(){
        return getName() + " is " + getAge() + " years old.";
    }
}
 
class Dog extends Animal{
    private String breed;
    private String furLength; 

    public Dog(){
        breed = "No breed set.";
        furLength = "No fur length set.";
    }

    public Dog(String initialBreed, String initialFurLength){
        breed = initialBreed;
        furLength = initialFurLength;
    }

    public Dog(String initiallName, int initialAge, String initialBreed, String initialFurLength){
        super(initiallName, initialAge);
        breed = initialBreed;
        furLength = initialFurLength;
    }

    public Dog(String initialBreed){
        breed = initialBreed;

    }

    public Dog(Dog copyDog){
        setName(copyDog.getName());
        setAge(copyDog.getAge());
        setBreed(copyDog.breed);
        setFurLength(copyDog.furLength);
    }

    public void setBreed(String initialBreed){
        breed = initialBreed;
    }

    public void setFurLength(String initialFurLength){
        furLength = initialFurLength;
    }

    public String getBreed(){
        return breed;
    }

    public String getFurLength(){
        return furLength;
    }

    @Override
    public String animalDescription(){
        return getName() + " is a " + getBreed() + " and is " + getAge() + " years old. " + getName() + " has " + getFurLength() + " length fur.";
    }
}


class Fish extends Animal{
    private String swimmingSpeed;
    private int noOfFins;

    public Fish(){
        swimmingSpeed = "No swimming speed set.";
        noOfFins = 0;
    }

    public Fish(String initialSwimmingSpeed, int initialNoOfFins){
        swimmingSpeed = initialSwimmingSpeed;
        noOfFins = initialNoOfFins;
    }

    public Fish(String initialSwimmingSpeed){
        swimmingSpeed = initialSwimmingSpeed;
        noOfFins = 0;
    }

    public Fish(int initialNoOfFins){
        swimmingSpeed = "No swimming speed set.";
        noOfFins = initialNoOfFins;
    }

    public Fish(String initialName, int initialAge, String initialSwimmingSpeed, int initialNoOfFins){
        super(initialName, initialAge);
        swimmingSpeed = initialSwimmingSpeed;
        noOfFins = initialNoOfFins;
    }

    public Fish(Fish copyFish){
        setName(copyFish.getName());
        setAge(copyFish.getAge());
        setSwimmingSpeed(copyFish.swimmingSpeed);
        setNoOfFins(copyFish.noOfFins);
    }

    public void setSwimmingSpeed(String newSwimmingSpeed){
        swimmingSpeed = newSwimmingSpeed;
    }

    public void setNoOfFins(int newNoOfFins){
        noOfFins = newNoOfFins;
    }

    public String getSwimmingSpeed(){
        return swimmingSpeed;
    }

    public int getNoOfFins() {
        return noOfFins;
    }

    @Override
    public String animalDescription(){
        return getName() + " is a fish and is " + getAge() + " years old. " + getName() + " is a " + getSwimmingSpeed() + " swimmer.";
    }
}


public class AnimalInheritance{
    public static void main (String[] args){

        Dog dog1 = new Dog("Spot", 5, "bichon frise", "medium");
        Dog dog2 = new Dog(dog1);

        Fish fish1 = new Fish("Sabrina", 5, "mid fast", 3);
        Fish fish2 = new Fish(fish1);

        dog2.setName("Dodge");

        fish2.setName("Freddy");

        Animal[] animals = new Animal[9];

        animals[0] = new Animal("Kevin", 7);
        animals[1] = new Dog("Nessi", 4, "dalmation", "short");
        animals[2] = new Fish("Fishy the fish", 1, "super fast", 1);
        animals[3] = new Dog("Doggy the dog", 8, "cat", "long");
        animals[4] = new Fish("Nemo", 2, "slow", 5);
        animals[5] = dog1;
        animals[6] = dog2;
        animals[7] = fish1;
        animals[8] = fish2;

        for (Animal animal: animals){
            System.out.println(animal.animalDescription());
            
        }
    }
}