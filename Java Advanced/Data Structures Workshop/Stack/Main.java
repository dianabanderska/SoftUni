package Stack;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(12);
        stack.push(23);
        stack.push(45);
        stack.push(56);

        stack.forEach(System.out::println);
    }
}
