package Annotations;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Annotation[] annotations = clazz.getAnnotations();
    }
}
