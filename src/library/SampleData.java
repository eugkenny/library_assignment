package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public final class SampleData {

    private SampleData() {
    }

    /* Small dataset for initial development. */
    public static void load(LibraryManager library) {
        library.addBook(new Book("9781000000016", "Algorithms at Work", "Nora Bennett"));
        library.addBook(new Book("9781000000023", "Beneath the Glass City", "Samuel Ward"));
        library.addBook(new Book("9781000000030", "Data in Motion", "Leah Morgan"));
        library.addBook(new Book("9781000000047", "The Art of Debugging", "Daniel Reed"));
        library.addBook(new Book("9781000000054", "Hidden Patterns", "Maya Collins"));
        library.addBook(new Book("9781000000061", "Building Reliable Software", "Aaron Hughes"));

        library.registerMember(new Member("M1001", "Alice Murphy"));
        library.registerMember(new Member("M1002", "Brian Kelly"));
        library.registerMember(new Member("M1003", "Carla Byrne"));
        library.registerMember(new Member("M1004", "David Walsh"));
        library.registerMember(new Member("M1005", "Emma Ryan"));
        library.registerMember(new Member("M1006", "Farah Ali"));
    }

    /*
     * Larger dataset loaded from external files.
     */
    public static void load(LibraryManager library, String booksFile, String membersFile) {
        loadBooks(library, booksFile);
        loadMembers(library, membersFile);
    }

    private static void loadBooks(LibraryManager library, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] fields = line.split("\\|", -1);

                if (fields.length != 3) {
                    System.out.println("Invalid book record: " + line);
                    continue;
                }

                String isbn = fields[0].trim();
                String title = fields[1].trim();
                String author = fields[2].trim();

                Book book = new Book(isbn, title, author);

                library.addBook(book);
            }

        } catch (IOException e) {
            System.out.println("Unable to load books from " + filename);
        }
    }

    private static void loadMembers(LibraryManager library, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] fields = line.split("\\|", -1);

                if (fields.length != 2) {
                    System.out.println("Invalid member record: " + line);
                    continue;
                }

                String memberId = fields[0].trim();
                String name = fields[1].trim();

                library.registerMember(new Member(memberId, name));
            }
        } catch (IOException e) {
            System.out.println("Unable to load members from " + filename);
        }
    }

    /*
     * Optional scenario for testing once borrowing,
     * returning and reservations have been implemented.
     *
     * Call this only after loading the larger dataset.
     */
    public static void loadTests(LibraryManager library) {

        /* Two loans with the same due date. */
        library.borrowBook("M1001", "9781000000016", LocalDate.of(2026, 11, 1));
        library.borrowBook("M1002", "9781000000023", LocalDate.of(2026, 11, 1));

        /* An earlier due date. */
        library.borrowBook("M1003", "9781000000030", LocalDate.of(2026, 10, 25));

        /* Three reservations for the same book. */
        library.reserveBook("M1004", "9781000000016", LocalDate.of(2026, 11, 2));
        library.reserveBook("M1005", "9781000000016", LocalDate.of(2026, 11, 3));
        library.reserveBook("M1006", "9781000000016", LocalDate.of(2026, 11, 4));

        /* A returned loan whose entry may still
         * remain in the due-date Priority Queue. */
        library.borrowBook("M1007", "9781000000047", LocalDate.of(2026, 10, 20));
        library.returnBook("M1007", "9781000000047", LocalDate.of(2026, 10, 30));

        /* Another book with a reservation waiting. */
        library.borrowBook("M1008", "9781000000054", LocalDate.of(2026, 11, 5));
        library.reserveBook("M1009", "9781000000054", LocalDate.of(2026, 11, 6));
    }
}