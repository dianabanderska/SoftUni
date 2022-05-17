package UpperBound;

public class Main {
    public static void main(String[] args) {

        AnimalList<Animal> animals = new AnimalList<>();
        animals.add(new Cat("puding", 1));
        animals.add(new Animal("animal", 2));

        animals.printNames();
    }
}
