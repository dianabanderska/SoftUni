public class Recursion {
    public static void main(String[] args) {
        //print nums from 1 to 10

        printNum(1);
    }

    public static void printNum(int i) {
        if (i <= 10) {
            System.out.println(i);
            printNum(i + 1);
        }
    }
}
