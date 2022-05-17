public class RecursionPow {
    public static void main(String[] args) {

        int power = pow(2, 6);
        System.out.println(power);
    }

    private static int pow(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * pow(x, n - 1);
    }
}
