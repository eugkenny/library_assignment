package library;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryApp {

    private static final Scanner input = new Scanner(System.in);

    static void main(String[] args) {

        LibraryManager library = new LibraryManager();

        /* Small development dataset. */
        SampleData.loadSmall(library);

        /*
         * Once the basic application is working,
         * replace the call above with:
         *
         * SampleData.loadFromFiles(
         *         library,
         *         "data/books.txt",
         *         "data/members.txt");
         */

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Choice: ");

            System.out.println();

            switch (choice) {

                case 1:
                    library.displayCatalogue();
                    break;

                case 2:
                    library.displaySortedCatalogue();
                    break;

                case 3:
                    registerMember(library);
                    break;

                case 4:
                    borrowBook(library);
                    break;

                case 5:
                    returnBook(library);
                    break;

                case 6:
                    reserveBook(library);
                    break;

                case 7:
                    displayReservations(library);
                    break;

                case 8:
                    library.displayActiveLoans();
                    break;

                case 9:
                    processDueNotices(library);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid menu option.");
            }

            System.out.println();
        }

        System.out.println("Goodbye.");
    }

    private static void displayMenu() {

        System.out.println("Library Loans and Reservation Manager");

        System.out.println();

        System.out.println("1. Display catalogue");
        System.out.println("2. Display sorted catalogue");
        System.out.println("3. Register member");
        System.out.println("4. Borrow book");
        System.out.println("5. Return book");
        System.out.println("6. Reserve book");
        System.out.println("7. Display reservations for book");
        System.out.println("8. Display active loans");
        System.out.println("9. Process due notices");
        System.out.println("0. Exit");

        System.out.println();
    }

    private static void registerMember(LibraryManager library) {

        String memberId = readString("Member ID: ");

        String name = readString("Name: ");

        Member member = new Member(memberId, name);

        if (library.registerMember(member)) {
            System.out.println("Member registered.");
        } else {
            System.out.println("Unable to register member.");
        }
    }

    private static void borrowBook(LibraryManager library) {
        String memberId = readString("Member ID: ");
        String isbn = readString("ISBN: ");
        LocalDate date = readDate("Borrow date");
        if (library.borrowBook(memberId, isbn, date)) {
            System.out.println("Book borrowed.");
        } else {
            System.out.println("Unable to borrow book.");
        }
    }

    private static void returnBook(LibraryManager library) {
        String memberId = readString("Member ID: ");
        String isbn = readString("ISBN: ");
        LocalDate date = readDate("Return date");

        if (library.returnBook(memberId, isbn, date)) {

            System.out.println("Book returned.");

        } else {
            System.out.println("Unable to return book.");
        }
    }

    private static void reserveBook(LibraryManager library) {

        String memberId = readString("Member ID: ");

        String isbn = readString("ISBN: ");

        LocalDate date = readDate("Reservation date");

        if (library.reserveBook(memberId, isbn, date)) {

            System.out.println("Reservation added.");

        } else {
            System.out.println("Unable to reserve book.");
        }
    }

    private static void displayReservations(LibraryManager library) {

        String isbn = readString("ISBN: ");

        library.displayReservations(isbn);
    }

    private static void processDueNotices(LibraryManager library) {

        LocalDate date = readDate("Current date");

        library.processDueNotices(date);
    }

    private static String readString(String prompt) {

        System.out.print(prompt);

        return input.nextLine().trim();
    }

    private static int readInt(String prompt) {

        while (true) {

            try {
                return Integer.parseInt(readString(prompt));

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static LocalDate readDate(String prompt) {

        while (true) {

            String value = readString(prompt + " (YYYY-MM-DD): ");

            try {
                return LocalDate.parse(value);

            } catch (Exception e) {
                System.out.println("Please enter a valid date.");
            }
        }
    }
}