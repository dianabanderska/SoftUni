package demo;

public class Cat extends Animal implements Mammal {
    @Override
    public void eat() {
        System.out.println("I am eating like a cat");
    }
}
