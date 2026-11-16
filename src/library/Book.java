package library;

import utils.LinkedQueue;
import utils.Queue;

public class Book implements Comparable<Book> {

    private String isbn;
    private String title;
    private String author;

    private boolean onLoan;

    private Queue<Reservation> reservations;

    public Book(
            String isbn,
            String title,
            String author) {

        this.isbn = isbn;
        this.title = title;
        this.author = author;

        onLoan = false;

        reservations = new LinkedQueue<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public boolean isAvailable() {
        return !onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public Queue<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public int compareTo(Book other) {

        /*
         * TODO
         *
         * Books should be ordered by:
         *
         * 1. title
         * 2. author
         * 3. ISBN
         *
         * Use the additional fields to break ties.
         */

        throw new UnsupportedOperationException(
                "Book.compareTo() not yet implemented");
    }

    @Override
    public String toString() {

        String status;

        if (onLoan) {
            status = "On loan";
        } else {
            status = "Available";
        }

        return isbn
                + " - "
                + title
                + " - "
                + author
                + " - "
                + status;
    }
}