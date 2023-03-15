import java.util.Random;

public class Customer implements Runnable {
    private final String[] genres = { "fiction", "horror", "romance", "fantasy", "sport", "crime" };
    // private final Box bookstore;
    private final Random random;
    private int customerCount;
    private String customer;

    public Customer() {
        // this.bookstore = bookstore;
        this.random = new Random();
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
                try{
                    Thread.sleep(10 * Main.TICK_TIME_SIZE);
                }
                catch(InterruptedException e){

                }
                customerCount++;
                customer = "Customer-" + customerCount;
                String genre = genres[random.nextInt(genres.length)];
                if (genre == "fiction" && !Shelve.FictionShelf.isEmpty()) {
                    takeBook(genre);
                    System.out.println("<" + Main.tickCount + ">" + "Customer bought a book from " + genre + " section.");
                } else if (genre == "fiction" && Shelve.FictionShelf.isEmpty()) {
                    System.out.println("<" + Main.tickCount + ">" + "Fiction Customers Waiting" + Shelve.FictionWaitingLine);
                    Shelve.CustomerWaitingLine(Shelve.FictionWaitingLine, customer);
                } else if (genre == "fantasy" && !Shelve.FantasyShelf.isEmpty()) {
                    takeBook(genre);
                    System.out.println("<" + Main.tickCount + ">" + "Customer bought a book from " + genre + " section.");
                } else if (genre == "fantasy" && Shelve.FantasyShelf.isEmpty()) {
                    System.out.println("<" + Main.tickCount + ">" + "Fanstasy Customers Waiting" + Shelve.FantasyWaitingLine);
                    Shelve.CustomerWaitingLine(Shelve.FantasyWaitingLine, customer);
                } else if (genre == "crime" && !Shelve.CrimeShelf.isEmpty()) {
                    takeBook(genre);
                    System.out.println("<" + Main.tickCount + ">" + "Customer bought a book from " + genre + " section.");
                } else if (genre == "crime" && Shelve.CrimeShelf.isEmpty()) {
                    System.out.println("<" + Main.tickCount + ">" + "Romance Customers Waiting" + Shelve.CrimeWaitingLine);
                    Shelve.CustomerWaitingLine(Shelve.CrimeWaitingLine, customer);
                } else if (genre == "romance" && !Shelve.RomanceShelf.isEmpty()) {
                    takeBook(genre);
                    System.out.println("<" + Main.tickCount + ">" + "Customer bought a book from " + genre + " section.");
                } else if (genre == "romance" && Shelve.RomanceShelf.isEmpty()) {
                    System.out.println("Crime Customers Waiting" + Shelve.RomanceWaitingLine);
                    Shelve.CustomerWaitingLine(Shelve.RomanceWaitingLine, customer);
                } else if (genre == "horror" && !Shelve.HorrorShelf.isEmpty()) {
                    takeBook(genre);
                    System.out.println("<" + Main.tickCount + ">" + "Customer bought a book from " + genre + " section.");
                } else if (genre == "horror" && Shelve.HorrorShelf.isEmpty()) {
                    System.out.println("<" + Main.tickCount + ">" + "Horror Customers Waiting" + Shelve.HorrorWaitingLine);
                    Shelve.CustomerWaitingLine(Shelve.HorrorWaitingLine, customer);
                } else if (genre == "sport" && !Shelve.SportShelf.isEmpty()) {
                    takeBook(genre);
                    System.out.println("<" + Main.tickCount + ">" + "Sport Customer bought a book from " + genre + " section.");
                } else if (genre == "sport" && Shelve.SportShelf.isEmpty()) {
                    System.out.println("<" + Main.tickCount + ">" + "Sport Customers Waiting" + Shelve.SportWaitingLine);
                    Shelve.CustomerWaitingLine(Shelve.SportWaitingLine, customer);
                }
            }
         
    }
}