package library;

import java.time.LocalDate;

import utils.ArrayList;
import utils.List;
import utils.BinaryHeap;
import utils.PriorityQueue;

public class LibraryManager {

    private static final int LOAN_PERIOD_DAYS = 14;

    private final List<Book> books;
    private final List<Member> members;
    private final List<Loan> loans;

    private final PriorityQueue<Loan> dueNotices;

    private int nextLoanId;

    public LibraryManager() {

        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();

        dueNotices = new BinaryHeap<>();

        nextLoanId = 100;
    }

    /* Catalogue */

    public boolean addBook(Book book) {
        /*
         * TODO
         *
         * Do not allow two books with the same ISBN.
         */
        return false;
    }

    public Book findBook(String isbn) {
        /*
         * TODO
         *
         * Perform a linear search through books.
         */
        return null;
    }

    public void displayCatalogue() {
        /*
         * TODO
         *
         * Display the books in their current List order.
         */
    }

    public void displaySortedCatalogue() {
        /*
         * TODO
         *
         * 1. Create a Book[] of the required size.
         * 2. Copy the books from the List into the array.
         * 3. Sort the array using one of the supplied
         *    sorting algorithms.
         * 4. Display the sorted array.
         *
         * Do not alter the order of the main books List.
         */
    }

    /* Members */

    public boolean registerMember(Member member) {
        /*
         * TODO
         *
         * Reject duplicate member IDs.
         */
        return false;
    }

    public Member findMember(String memberId) {
        /*
         * TODO
         *
         * Perform a linear search through members.
         */
        return null;
    }

    /* Borrowing */

    public boolean borrowBook(String memberId, String isbn, LocalDate borrowedDate) {
        /*
         * TODO
         *
         * 1. Find the member.
         * 2. Find the book.
         * 3. Check that the book is available.
         * 4. If reservations exist, check that the
         *    member is at the front of the Queue.
         * 5. Remove that reservation if appropriate.
         * 6. Calculate the due date.
         * 7. Create a Loan.
         * 8. Add the Loan to loans.
         * 9. Add the Loan to dueNotices.
         * 10. Mark the book as on loan.
         */
        return false;
    }

    /* Returns */

    public boolean returnBook(String memberId, String isbn, LocalDate returnDate) {
        /*
         * TODO
         *
         * 1. Find the active Loan corresponding to
         *    the member and book.
         * 2. Mark the Loan as returned.
         * 3. Mark the book as available.
         * 4. If reservations are waiting, display
         *    the member at the front of the Queue.
         *
         * Do not remove the Loan from dueNotices.
         * A returned Loan can be ignored when it is
         * eventually removed from the Priority Queue.
         */
        return false;
    }

    private Loan findActiveLoan(String memberId, String isbn) {
        /*
         * TODO
         *
         * Search loans for a matching Loan that has
         * not yet been returned.
         */
        return null;
    }

    /* Reservations */
    public boolean reserveBook(String memberId, String isbn, LocalDate requestDate) {
        /*
         * TODO
         *
         * 1. Find the member.
         * 2. Find the book.
         * 3. Check that the book is currently on loan.
         * 4. Check that this member does not already
         *    have the book on loan.
         * 5. Check that the member is not already
         *    in the reservation Queue.
         * 6. Add a Reservation to the Queue.
         */
        return false;
    }

    public void displayReservations(String isbn) {
        /*
         * TODO
         *
         * Find the book and iterate through its
         * reservation Queue.
         *
         * Do not remove reservations simply to
         * display them.
         */
    }

    /* Loans */
    public void displayActiveLoans() {
        /*
         * TODO
         *
         * Display each Loan whose returned flag
         * is false.
         */
    }

    /* Due-date processing */
    public void processDueNotices(LocalDate date) {
        /*
         * TODO
         *
         * While the Priority Queue is not empty:
         *
         * 1. Examine the Loan with the earliest
         *    due date.
         *
         * 2. Stop if its due date is after 'date'.
         *
         * 3. Otherwise remove it from the Priority
         *    Queue.
         *
         * 4. If the Loan has already been returned,
         *    ignore it.
         *
         * 5. Otherwise display a due/overdue notice.
         */
    }

    /* Utility */
    private String createLoanId() {
        String id = "L" + nextLoanId;
        nextLoanId++;
        return id;
    }
}