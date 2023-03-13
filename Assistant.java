import java.util.*;

public class Assistant implements Runnable {
    static List<Books> booksToTake = new ArrayList<Books>();
    static List<Books> booksInHands = new ArrayList<Books>();
    private final Object lock = new Object();
    private static Books book;

    static int carrySpace = 10;
    static boolean isBusy = false;

    public synchronized static List<Books> takeBooksFromBox() {
        List<Books> books = Box.getBooks();
        if (!books.isEmpty()) {
            while (booksToTake.size() < carrySpace) {
                for (Books book : books) {
                    booksToTake.add(book);
                }
            }
            books.removeAll(booksToTake);
            return booksToTake;
        } else {
            return null;
        }
    }

    public synchronized boolean isBusy() {
        return isBusy;
    }

    public int size() {
        int Size = booksToTake.size();

        // System.out.print(Size);

        return Size;
    }

    @Override
    public String toString() {
        return "" + booksToTake;
    }

    @Override
    public void run() {
        while (Main.TICKS_PER_DAY > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // System.out.println(Tick.deliveryRecieved);
            if (Tick.deliveryRecieved == true) {
                if (booksInHands.size() == 0) {
                    booksInHands = takeBooksFromBox();
                }
                System.out.println("Books in hand: " + booksInHands);
                if (booksInHands.size() != 0) {
                    synchronized (lock) {
                        Iterator<Books> iterator = booksInHands.iterator();
                        while (iterator.hasNext()) {
                            book = iterator.next();
                            if (book.toString().equals("Fiction")) {
                                Shelve.AddBooksToShelves(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("<" + Main.tickCount + ">" + "Fiction: " + Shelve.FictionShelf);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                                if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are
                                                           // stacked
                                    try {
                                        Thread.sleep(1000); // simulate 10 seconds to move to the next shelf
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        iterator = booksInHands.iterator();
                        while (iterator.hasNext()) {
                            // System.out.println("In SPort");
                            book = iterator.next();
                            if (book.toString().equals("Sport")) {
                                Shelve.AddBooksToShelves(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("<" + Main.tickCount + ">" + "Sport: " + Shelve.SportShelf);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are stacked
                                try {
                                    Thread.sleep(1000); // simulate 10 seconds to move to the next shelf
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        iterator = booksInHands.iterator();

                        while (iterator.hasNext()) {
                            book = iterator.next();
                            if (book.toString().equals("Fantasy")) {
                                Shelve.AddBooksToShelves(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("<" + Main.tickCount + ">" + "Fantasy: " + Shelve.FantasyShelf);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are
                                                       // stacked
                                try {
                                    Thread.sleep(1000); // simulate 10 seconds to move to the next shelf
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        iterator = booksInHands.iterator();

                        while (iterator.hasNext()) {
                            book = iterator.next();
                            if (book.toString().equals("Horror")) {
                                Shelve.AddBooksToShelves(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("<" + Main.tickCount + ">" + "Horror: " + Shelve.HorrorShelf);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are
                                                       // stacked
                                try {
                                    Thread.sleep(1000); // simulate 10 seconds to move to the next shelf
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        iterator = booksInHands.iterator();

                        while (iterator.hasNext()) {
                            book = iterator.next();
                            if (book.toString().equals("Crime")) {
                                Shelve.AddBooksToShelves(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("<" + Main.tickCount + ">" + "Crime: " + Shelve.CrimeShelf);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are
                                                       // stacked
                                try {
                                    Thread.sleep(1000); // simulate 10 seconds to move to the next shelf
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        iterator = booksInHands.iterator();

                        while (iterator.hasNext()) {
                            book = iterator.next();
                            if (book.toString().equals("Romance")) {
                                Shelve.AddBooksToShelves(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("<" + Main.tickCount + ">" + "Romance: " + Shelve.RomanceShelf);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are
                                                       // stacked
                                try {
                                    Thread.sleep(1000); // simulate 10 seconds to move to the next shelf
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            // System.out.println(booksInHands);
            // System.out.println("Check books");
            Tick.deliveryRecieved = false;
        }
    }

    public static void main(String[] args) {
        // Box books = new Box();
        // books.main(args);
        // System.out.println(books.toString());
        // takeBooksFromBox(books);
        // System.out.println(books.toString());

        // System.out.println(booksToTake.toString());
        // System.out.println(takeBooksFromBox(books));
    }

    public List<Books> getBooks() {
        return booksToTake;
    }
}
