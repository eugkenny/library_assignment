package library;

import java.time.LocalDate;

public class Reservation {

    private Member member;
    private Book book;
    private LocalDate requestDate;

    public Reservation(
            Member member,
            Book book,
            LocalDate requestDate) {

        this.member = member;
        this.book = book;
        this.requestDate = requestDate;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    @Override
    public String toString() {
        return member
                + " - reserved "
                + book.getTitle()
                + " on "
                + requestDate;
    }
}