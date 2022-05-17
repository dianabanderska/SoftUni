package UpperBound;

import java.util.ArrayList;

public class AnimalList<T extends Animal> extends ArrayList<T> {

    public void printNames() {
        for (T next : this) {
            System.out.println(next.getName());
        }
    }
}
