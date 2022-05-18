package demo;

public class Dog extends Animal implements Mammal {
    @Override
    public void eat() {
        System.out.println("I am eating like a dog");
    }
}
