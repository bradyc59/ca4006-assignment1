import java.util.*;

public class Main {
    public static int TICKS_PER_DAY = 1000;
    public static int TICK_TIME_SIZE = 100;

    public static int tickCount = 0;
    public static Box box = new Box();
    private static List<Books> booksInHands = new ArrayList<Books>();
    private static int booksCounter = 0;

    private final static List<Assistant> assistants = new ArrayList<>();


    public static int MilliSecondsNeeded(int TICK_TIME_SIZE, int HowManyTicks) 
    {
        int MillisToTick = 1000 / TICK_TIME_SIZE;

        HowManyTicks = MillisToTick * HowManyTicks;

        return HowManyTicks;
    }

    public static void StartShelves() {
        List<String> CategoriesUsed = new ArrayList<String>();

        while (CategoriesUsed.size() < 6) {
            Books book = Books.GenerateBook();

            if (!CategoriesUsed.contains(book.toString())) {

                String book_category = book.toString();

                if (book_category.equals("Horror")) {
                    CategoriesUsed.add("Horror");

                    Shelve.HorrorShelf.add(book);
                }

                if (book_category.equals("Sport")) {
                    CategoriesUsed.add("Sport");

                    Shelve.SportShelf.add(book);
                }

                if (book_category.equals("Fiction")) {
                    CategoriesUsed.add("Fiction");

                    Shelve.FictionShelf.add(book);
                }

                if (book_category.equals("Fantasy")) {
                    CategoriesUsed.add("Fantasy");

                    Shelve.FantasyShelf.add(book);
                }

                if (book_category.equals("Romance")) {
                    CategoriesUsed.add("Romance");

                    Shelve.RomanceShelf.add(book);
                }

                if (book_category.equals("Crime")) {
                    CategoriesUsed.add("Crime");

                    Shelve.CrimeShelf.add(book);
                }
            }
        }

        System.out.println("Each Shelf contains 1 book");

    }

    public static void main(String[] args) {
        StartShelves();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            assistants.add(new Assistant("Assistant-" + i, booksInHands, booksCounter));
            threads.add(new Thread(new Assistant("Assistant-" + i, booksInHands, booksCounter)));
        }
        threads.add(new Thread(new Customer()));
        threads.add(new Thread(new Tick(box)));

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
