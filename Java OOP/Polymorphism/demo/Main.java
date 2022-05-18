package demo;

public class Main {
    public static void main(String[] args) {

        Mammal dog = new Dog();
        feed(dog);

        Mammal cat = new Cat();
        feed(cat);
    }

    public static void feed(Mammal p) { //Referenciqta, koqto se podava na feed metoda e samo i edinstveno takava, koqto znae kak da se nahrani.I togava metodut raboti kakto za Dog, taka i za Cat
        p.eat();
    }
}

