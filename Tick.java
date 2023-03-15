import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tick implements Runnable {
    private Box bookstore;
    private Random random = new Random();
    private static String deliveryTime = Delivery.NextDeliveryTime();
    public static boolean deliveryRecieved = false;

    public Tick(Box bookstore) {
        this.bookstore = bookstore;
    }

    @Override
    public void run() {

        while (true) {
                try {
                    Thread.sleep(1 * Main.TICK_TIME_SIZE);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Main.tickCount);
                long threadId = Thread.currentThread().getId();

                String isDelivery = Delivery.NextDeliveryTime();
                if (isDelivery == "True") {
                    Thread bookstoreThread = new Thread(bookstore);
                    System.out.println("<" + Main.tickCount + "> <" + threadId + ">" + "Recieved a delivery!");
                    bookstoreThread.run();
                    deliveryTime = Delivery.NextDeliveryTime();
                    deliveryTime += Main.tickCount;
                    System.out.println("<" + Main.tickCount + "> <" + threadId + ">" + " Box: " + Box.box);
                    deliveryRecieved = true;
                }
                Main.tickCount++; 
        }
    }

    public static void main(String[] args) {
        // Tick tickThread = new Tick(bookstore);
        // Thread ticks = new Thread(tickThread);
        // ticks.run();
    }
}