import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

public class Customer implements Runnable {
    private final String[] genres = { "fiction", "horror", "romance", "fantasy", "sport", "crime" };
    // private final Box bookstore;
    private final Random random;
    private int customerCount;
    private String customer;
    static List<Integer> CustomerWaitTimes = new ArrayList<>();

    public Customer() {
        // this.bookstore = bookstore;
        this.random = new Random();
    }

    public static int WaitTime(String ArrivalTime, String DepartureTime) {
        Integer Arrival = Integer.parseInt(ArrivalTime);

        Integer Departure = Integer.parseInt(DepartureTime);

        int WaitTime = Departure - Arrival;

        return WaitTime;
    }

    public static List<Integer> WaitTimeList(int Time) {
        CustomerWaitTimes.add(Time);

        return CustomerWaitTimes;
    }

    public static int WaitTimeAverage(List<Integer> WaitTimes) {
        int i = 0;
        int sum_of_wait_time = 0;

        while (i < WaitTimes.size()) {
            sum_of_wait_time += WaitTimes.get(i);

            i++;
        }

        if (WaitTimes.size() != 0) {

            int AverageWaitTime = sum_of_wait_time / WaitTimes.size();

            return AverageWaitTime;
        }

        else {
            return 0;
        }
    }

    public static void takeBook(String genre) {
        if (genre == "fiction") {
            Shelve.FictionShelf.remove(0);
        }
        if (genre == "horror") {
            Shelve.HorrorShelf.remove(0);

        }
        if (genre == "romance") {
            Shelve.RomanceShelf.remove(0);

        }
        if (genre == "fantasy") {
            Shelve.FantasyShelf.remove(0);

        }
        if (genre == "crime") {
            Shelve.CrimeShelf.remove(0);

        }
        if (genre == "sport") {
            Shelve.SportShelf.remove(0);

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100 * Main.TICK_TIME_SIZE);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            long threadId = Thread.currentThread().threadId();
            customerCount++;
            customer = "Customer-" + customerCount;
            String customer_and_start_time = customer + ":" + Main.tickCount;
            String genre = genres[random.nextInt(genres.length)];
            switch (genre) {
                case "fiction":
                    if (!Shelve.FictionShelf.isEmpty() && Shelve.FictionWaitingLine.isEmpty()) {
                        takeBook(genre);
                        String customer_and_end_time = customer_and_start_time + ":" + Main.tickCount;
                        String[] parts = customer_and_end_time.split(":");
                        String ArrivalTime = parts[1];
                        String DepartureTime = parts[2];
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer +
                                " bought a book from " + genre + " section." + "The Customer spent " + WaitTime
                                + " shopping");

                    } else if (!Shelve.FictionShelf.isEmpty() && !Shelve.FictionWaitingLine.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        String customer_in_queue = Shelve.FictionWaitingLine.remove();
                        String[] parts = customer_in_queue.split(":");
                        String customer_to_serve = parts[0];
                        String ArrivalTime = parts[1];
                        takeBook(genre);
                        String DepartureTime = Integer.toString(Main.tickCount);
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer_to_serve
                                + " bought a book from "
                                + genre + " section." + " The Customer spent " + WaitTime + " shopping.");
                    } else if (Shelve.FictionShelf.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        System.out
                                .println("<" + Main.tickCount + ">" + "<" + threadId + ">" + "Fiction Customers Waiting"
                                        + Shelve.FictionWaitingLine);
                    }

                    break;

                case "fantasy":
                    if (!Shelve.FantasyShelf.isEmpty() && Shelve.FantasyWaitingLine.isEmpty()) {
                        takeBook(genre);
                        String customer_and_end_time = customer_and_start_time + ":" + Main.tickCount;
                        String[] parts = customer_and_end_time.split(":");
                        String ArrivalTime = parts[1];
                        String DepartureTime = parts[2];
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer +
                                " bought a book from " + genre + " section." + " The Customer spent " + WaitTime
                                + " shopping.");

                    } else if (!Shelve.FantasyShelf.isEmpty() && !Shelve.FantasyWaitingLine.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FantasyWaitingLine, customer_and_start_time);
                        String customer_in_queue = Shelve.FictionWaitingLine.remove();
                        String[] parts = customer_in_queue.split(":");
                        String customer_to_serve = parts[0];
                        String ArrivalTime = parts[1];
                        takeBook(genre);
                        String DepartureTime = Integer.toString(Main.tickCount);
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer_to_serve
                                + " bought a book from "
                                + genre + " section." + " The Customer spent " + WaitTime + " shopping");
                    } else if (Shelve.FantasyShelf.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        System.out
                                .println("<" + Main.tickCount + ">" + "<" + threadId + ">" + "Fiction Customers Waiting"
                                        + Shelve.FictionWaitingLine);
                    }

                    break;

                case "crime":
                    if (!Shelve.CrimeShelf.isEmpty() && Shelve.CrimeWaitingLine.isEmpty()) {
                        takeBook(genre);
                        String customer_and_end_time = customer_and_start_time + ":" + Main.tickCount;
                        String[] parts = customer_and_end_time.split(":");
                        String ArrivalTime = parts[1];
                        String DepartureTime = parts[2];
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer +
                                " bought a book from " + genre + " section." + "The Customer spent " + WaitTime
                                + " shopping");
                    } else if (!Shelve.CrimeShelf.isEmpty() && !Shelve.CrimeWaitingLine.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.CrimeWaitingLine, customer_and_start_time);
                        String customer_in_queue = Shelve.FictionWaitingLine.remove();
                        String[] parts = customer_in_queue.split(":");
                        String customer_to_serve = parts[0];
                        String ArrivalTime = parts[1];
                        takeBook(genre);
                        String DepartureTime = Integer.toString(Main.tickCount);
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer_to_serve
                                + " bought a book from "
                                + genre + " section." + " The Customer spent " + WaitTime + " shopping.");
                    } else if (genre == "crime" && Shelve.CrimeShelf.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        System.out
                                .println("<" + Main.tickCount + ">" + "<" + threadId + ">" + "Fiction Customers Waiting"
                                        + Shelve.FictionWaitingLine);
                    }

                    break;

                case "romance":
                    if (!Shelve.RomanceShelf.isEmpty() && Shelve.RomanceWaitingLine.isEmpty()) {
                        takeBook(genre);
                        String customer_and_end_time = customer_and_start_time + ":" + Main.tickCount;
                        String[] parts = customer_and_end_time.split(":");
                        String ArrivalTime = parts[1];
                        String DepartureTime = parts[2];
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer +
                                " bought a book from " + genre + " section." + "The Customer spent " + WaitTime
                                + " shopping");
                    } else if (!Shelve.RomanceShelf.isEmpty() && !Shelve.RomanceWaitingLine.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.RomanceWaitingLine, customer_and_start_time);
                        String customer_in_queue = Shelve.FictionWaitingLine.remove();
                        String[] parts = customer_in_queue.split(":");
                        String customer_to_serve = parts[0];
                        String ArrivalTime = parts[1];
                        takeBook(genre);
                        String DepartureTime = Integer.toString(Main.tickCount);
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer_to_serve
                                + " bought a book from "
                                + genre + " section." + " The Customer spent " + WaitTime + " shopping.");
                    } else if (genre == "romance" && Shelve.RomanceShelf.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        System.out
                                .println("<" + Main.tickCount + ">" + "<" + threadId + ">" + "Fiction Customers Waiting"
                                        + Shelve.FictionWaitingLine);
                    }

                    break;

                case "horror":
                    if (!Shelve.HorrorShelf.isEmpty() && Shelve.HorrorWaitingLine.isEmpty()) {
                        takeBook(genre);
                        String customer_and_end_time = customer_and_start_time + ":" + Main.tickCount;
                        String[] parts = customer_and_end_time.split(":");
                        String ArrivalTime = parts[1];
                        String DepartureTime = parts[2];
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer +
                                " bought a book from " + genre + " section." + "The Customer spent " + WaitTime
                                + " shopping");
                    } else if (!Shelve.HorrorShelf.isEmpty() && !Shelve.HorrorWaitingLine.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.HorrorWaitingLine, customer_and_start_time);
                        String customer_in_queue = Shelve.FictionWaitingLine.remove();
                        String[] parts = customer_in_queue.split(":");
                        String customer_to_serve = parts[0];
                        String ArrivalTime = parts[1];
                        takeBook(genre);
                        String DepartureTime = Integer.toString(Main.tickCount);
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer_to_serve
                                + " bought a book from "
                                + genre + " section." + " The Customer spent " + WaitTime + " shopping.");
                    } else if (Shelve.HorrorShelf.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        System.out
                                .println("<" + Main.tickCount + ">" + "<" + threadId + ">" + "Fiction Customers Waiting"
                                        + Shelve.FictionWaitingLine);
                    }

                    break;

                case "sport":
                    if (!Shelve.SportShelf.isEmpty() && Shelve.SportWaitingLine.isEmpty()) {
                        takeBook(genre);
                        String customer_and_end_time = customer_and_start_time + ":" + Main.tickCount;
                        String[] parts = customer_and_end_time.split(":");
                        String ArrivalTime = parts[1];
                        String DepartureTime = parts[2];
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer +
                                " bought a book from " + genre + " section." + "The Customer spent " + WaitTime
                                + " shopping");
                    } else if (!Shelve.SportShelf.isEmpty() && Shelve.SportWaitingLine.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.SportWaitingLine, customer_and_start_time);
                        String customer_in_queue = Shelve.FictionWaitingLine.remove();
                        String[] parts = customer_in_queue.split(":");
                        String customer_to_serve = parts[0];
                        String ArrivalTime = parts[1];
                        takeBook(genre);
                        String DepartureTime = Integer.toString(Main.tickCount);
                        int WaitTime = WaitTime(ArrivalTime, DepartureTime);
                        WaitTimeList(WaitTime);
                        System.out.println("<" + Main.tickCount + ">" + "<" + threadId + ">" + customer_to_serve
                                + " bought a book from "
                                + genre + " section." + " The Customer spent " + WaitTime + " shopping.");
                    } else if (Shelve.SportShelf.isEmpty()) {
                        Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer_and_start_time);
                        System.out
                                .println("<" + Main.tickCount + ">" + "<" + threadId + ">" + "Fiction Customers Waiting"
                                        + Shelve.FictionWaitingLine);
                    }

                    break;
            }
        }
    }
}
