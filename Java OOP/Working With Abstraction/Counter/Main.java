package Counter;

public class Main {
    public static void main(String[] args) {

        Counter c1 = new Counter();
        c1.printCounters();

        Counter c2 = new Counter();
        c2.printCounters();

        Counter c3 = new Counter();
        c3.printCounters();

        int counter = Counter.staticCount;
        System.out.println(counter);

    }
}
