public class BoxesRecursion {
    public static void main(String[] args) {
        //3 boxes [][][]
        //print all the possible combinations of the lowercase letters that fit into those boxes

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
