import java.util.*;
import java.security.SecureRandom;

public class Delivery {
    static Object Books = new Books();
    static int size = 10;
    public static List<Books> DeliveryList = new ArrayList<Books>();

    public static List<Books> GenerateDelivery() {
        int i = 0;

        while (i < size) {
            Books book = new Books();

            book.setCategory();

            DeliveryList.add(book);

            i++;
        }

        // Used for Testing .... System.out.print(DeliveryList);

        return DeliveryList;
    }

    public int size() {
        int Size = DeliveryList.size();

        // System.out.print(Size);

        return Size;
    }

    public static String NextDeliveryTime() {
        List<String> ProbabilityOfDelivery = new ArrayList<String>();
        var i = 0;
        while (i < 100) {
            if (i != 99) {
                ProbabilityOfDelivery.add("False");
            } else {
                ProbabilityOfDelivery.add("True");
            }
            i++;
        }

        int UpperRange = ProbabilityOfDelivery.size();

        Random rand = new Random();
        int Index = rand.nextInt(UpperRange);

        String IsDelivery = ProbabilityOfDelivery.get(Index);

        return IsDelivery;
    }

    @Override
    public String toString() {
        return "" + DeliveryList;
    }

    public static void main(String[] args) {
        String isDelivery = NextDeliveryTime();
        if (isDelivery == "True") {
            GenerateDelivery();
        }

    }

}
