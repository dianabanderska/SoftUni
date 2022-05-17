import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(42);
        numbers.add(69);
        numbers.add(73);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ser-out.txt"));

        outputStream.writeObject(numbers);
        
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ser-out.txt"));

        List<Integer> newNumList = (List<Integer>) inputStream.readObject();
    }
}
