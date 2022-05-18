package Counter;

public class Counter {
    private int count;
    static int staticCount;

    public Counter() {
        count++;
        staticCount++;
    }

    public void printCounters() {
        System.out.printf("Count: %d%n", count);
        System.out.printf("Static count: %d%n", staticCount);
    }
}
