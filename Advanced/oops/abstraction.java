

abstract class Animal{
    abstract public void run();
}

class Horse extends Animal{
    public void run(){
        System.out.println("Horse is Running");
    }
}

class Dog extends Animal{
    public void run(){
        System.out.println("Dog is Running");
    }
}

public class abstraction {

    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.run();

        Dog dog = new Dog();
        dog.run();

        /*Animal animal = new Animal();
        animal.run();*/   //Cannot be Inititated
    }
    
}
