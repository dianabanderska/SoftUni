import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();

        int elementsToAdd = scanner.nextInt();
        int elementsToRemove = scanner.nextInt();
        int element = scanner.nextInt();

        boolean isFound = false;

        for (int i = 0; i < elementsToAdd; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }
        if (queue.contains(element)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }
    }
}
