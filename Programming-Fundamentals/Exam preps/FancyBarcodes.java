import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int barcodesCount = Integer.parseInt(scanner.nextLine());

        String regex = "@[#]+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < barcodesCount; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String product = matcher.group("product");
                String productGroup = determineProductGroup(product);
                System.out.println("Product group: " + productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static String determineProductGroup(String product) {
        String group = "00";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < product.toCharArray().length; i++) {
            char symbol = product.charAt(i);
            if (Character.isDigit(symbol)) {
                String digit = String.valueOf(symbol);
                sb.append(digit);
            }
        }
        if (sb.length() == 0) {
            sb.append(group);
        }
        return sb.toString();
    }
}