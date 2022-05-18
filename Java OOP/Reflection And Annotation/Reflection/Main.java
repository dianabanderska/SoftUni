package Reflection;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Reflection> clazz = Reflection.class;


        System.out.println("class " + clazz.getSimpleName());
        System.out.println("class java.lang." + clazz.getSuperclass().getSimpleName());
        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println("interface java.io." + anInterface.getSimpleName());
        }

        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();

        Constructor<Reflection> constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class);

        constructor.setAccessible(true);

        Reflection reflection1 = constructor.newInstance("Name", "WebAddress", "example@example.com");

        System.out.println(reflection1.toString());

        Reflection reflection = ctor.newInstance();
        System.out.println(reflection.toString());

        Field field = clazz.getField("name");
        Class<?> type = field.getType();
        Class<String> stringClass = String.class;

        Field field2 = clazz.getDeclaredField("zip");

        Reflection reflection2 = new Reflection();
        field2.setAccessible(true);

        int zip = (int) field2.get(reflection2);
        System.out.println(zip);

        field2.set(reflection2, 13);

        System.out.println(reflection2.getZip());

        Method[] methods = clazz.getMethods();

        Method getName = clazz.getMethod("getName");

        Method setEmail = clazz.getMethod("setEmail", String.class);

        Class<?>[] parameterTypes = setEmail.getParameterTypes();
        Class<?> returnType = setEmail.getReturnType();

        Method setName = clazz.getDeclaredMethod("setName", String.class);

        setName.setAccessible(true);

        Reflection reflection3 = new Reflection();
        System.out.println(reflection3.getName());

        setName.invoke(reflection3, "NewName");

        System.out.println(reflection3.getName());

        Method print = clazz.getDeclaredMethod("print");

        print.invoke(null);

        int modifiers = clazz.getModifiers();

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method m : declaredMethods) {
            System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getName());

            int[] intArr = (int[]) Array.newInstance(int.class, 3);

            Array.set(intArr, 0, 123);
            Array.set(intArr, 1, 456);
        }
    }
}
