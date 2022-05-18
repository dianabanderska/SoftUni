package blackBoxInteger;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method currentMethod = getCurrentMethod(methods, command);
                 /*   methods.stream()
                    .filter(method -> method.getName().equals(command))
                    .findFirst()
                    .orElse(null); */

            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);
            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }

    private static Method getCurrentMethod(List<Method> methods, String command) {
        for (Method method : methods) {
            if (method.getName().equals(command)) {
                return method;
            }
        }
        return null;
    }
}
