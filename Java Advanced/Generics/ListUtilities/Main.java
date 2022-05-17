package ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(12, 34, 45, 3, -1);

        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));
    }
}
