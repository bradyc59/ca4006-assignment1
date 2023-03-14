import java.util.*;

public class Main {
    private static final int CUSTOMER_TICKS = 10;
    public static int TICKS_PER_DAY = 1000;
    public static int tickCount = 0;
    public static Box box = new Box();
    // private final static List<Assistant> assistants = new ArrayList<>();

    // public Main() {
    // // int tickCount = 0;
    // // TICKS_PER_DAY = 1000;
    // }

    // @Override
    // public void run() {
    // long threadId = Thread.currentThread().getId();
    // while (TICKS_PER_DAY > 0) {
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // // tickCount++;
    // System.out.println("TPD: " + TICKS_PER_DAY);
    // Assistant assistant = new Assistant();
    // Tick tick = new Tick(box);
    // Thread ticks = new Thread(tick);

    // Thread assistantThread = new Thread(assistant);
    // ticks.start();
    // TICKS_PER_DAY--;
    // // assistantThread.start();

    // }
    // }
    // public synchronized boolean isAssistantAvailable() {
    // for (Assistant assistant : assistants) {
    // if (!assistant.isBusy()) {
    // return true;
    // }
    // }
    // return false;
    // }

    public static void StartShelves() {
        List<String> CategoriesUsed = new ArrayList<String>();

        while (CategoriesUsed.size() < 6) {
            // Books book = new Books();
            Books book = Books.GenerateBook();

            // boolean CategoryAlreadyAdded = false;
            // System.out.println(book.toString());
            if (!CategoriesUsed.contains(book.toString())) {

                String book_category = book.toString();

                if (book_category.equals("Horror")) {
                    CategoriesUsed.add("Horror");

                    Shelve.HorrorShelf.add(book);

                    System.out.println(Shelve.HorrorShelf);
                }

                if (book_category.equals("Sport")) {
                    CategoriesUsed.add("Sport");

                    Shelve.SportShelf.add(book);

                    System.out.println(Shelve.SportShelf);
                }

                if (book_category.equals("Fiction")) {
                    CategoriesUsed.add("Fiction");

                    Shelve.FictionShelf.add(book);

                    System.out.println(Shelve.FictionShelf);
                }

                if (book_category.equals("Fantasy")) {
                    CategoriesUsed.add("Fantasy");

                    Shelve.FantasyShelf.add(book);

                    System.out.println(Shelve.FantasyShelf);
                }

                if (book_category.equals("Romance")) {
                    CategoriesUsed.add("Romance");

                    Shelve.RomanceShelf.add(book);

                    System.out.println(Shelve.RomanceShelf);
                }

                if (book_category.equals("Crime")) {
                    CategoriesUsed.add("Crime");

                    Shelve.CrimeShelf.add(book);

                    System.out.println(Shelve.CrimeShelf);
                }
            }

            // if (CategoryAlreadyAdded == true) {
            // x = 0;
            // book = new Books();
            // if (book.toString() == CategoriesUsed.get(x)) {
            // CategoryAlreadyAdded = true;
            // }
            // }

            // if (book.Category == "Horror" && CategoryAlreadyAdded == false) {
            // CategoriesUsed.add("Horror");
            // Shelve.HorrorShelf.add(book);
            // }

            // if (book.Category == "Sport" && CategoryAlreadyAdded == false) {
            // CategoriesUsed.add("Sport");
            // Shelve.SportShelf.add(book);
            // }

            // if (book.Category == "Fiction" && CategoryAlreadyAdded == false) {
            // CategoriesUsed.add("Fiction");
            // Shelve.FictionShelf.add(book);
            // }

            // if (book.Category == "Fantasy" && CategoryAlreadyAdded == false) {
            // CategoriesUsed.add("Fantasy");
            // Shelve.FantasyShelf.add(book);
            // }

            // if (book.Category == "Romance" && CategoryAlreadyAdded == false) {
            // CategoriesUsed.add("Romance");
            // Shelve.RomanceShelf.add(book);
            // }

            // if (book.Category == "Crime" && CategoryAlreadyAdded == false) {
            // CategoriesUsed.add("Crime");
            // Shelve.CrimeShelf.add(book);
            // }

            // i++;
        }

        System.out.println("Each Shelf contains 1 book");

        // System.out.println(Shelve.FictionShelf);
        // System.out.println(Shelve.HorrorShelf);
        // System.out.println(Shelve.FantasyShelf);
        // System.out.println(Shelve.SportShelf);
        // System.out.println(Shelve.CrimeShelf);
        // System.out.println(Shelve.RomanceShelf);
    }

    public static void main(String[] args) {
        StartShelves();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            // assistants.add(new Assistant());
            threads.add(new Thread(new Assistant()));
        }
        threads.add(new Thread(new Customer()));
        threads.add(new Thread(new Tick(box)));

        for (Thread thread : threads) {
            // System.out.println(thread);
            thread.start();
        }
    }
}
