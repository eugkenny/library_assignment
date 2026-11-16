package library;

import java.time.LocalDate;

public class Loan implements Comparable<Loan> {

    private String loanId;

    private Member member;
    private Book book;

    private LocalDate borrowedDate;
    private LocalDate dueDate;

    private boolean returned;
    private LocalDate returnDate;

    public Loan(
            String loanId,
            Member member,
            Book book,
            LocalDate borrowedDate,
            LocalDate dueDate) {

        this.loanId = loanId;
        this.member = member;
        this.book = book;

        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;

        returned = false;
        returnDate = null;
    }

    public String getLoanId() {
        return loanId;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void returnBook(LocalDate returnDate) {
        returned = true;
        this.returnDate = returnDate;
    }

    @Override
    public int compareTo(Loan other) {

        /*
         * TODO
         *
         * Loans should be ordered so that the loan
         * with the earliest due date has the highest
         * priority.
         *
         * If two loans have the same due date, use
         * the loan ID to break the tie.
         *
         * Take account of whether the supplied
         * PriorityQueue is min-oriented or max-oriented.
         */

        throw new UnsupportedOperationException(
                "Loan.compareTo() not yet implemented");
    }

    @Override
    public String toString() {

        String status;

        if (returned) {
            status = "Returned " + returnDate;
        } else {
            status = "Due " + dueDate;
        }

        return loanId
                + " - "
                + member.getName()
                + " - "
                + book.getTitle()
                + " - "
                + status;
    }
}