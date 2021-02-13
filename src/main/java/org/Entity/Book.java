package org.Entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getAllBooks", query = "SELECT w from Book w"),
        @NamedQuery(name = "getBookByName", query = "SELECT b from Book b where b.bookName = :bookName")
})

@Entity
@Table(name = "books", schema = "library_hibernate")
public class Book {
    private static final String PRODUCTS_SEQUENCE = "products_id_sequence";
    private static final String PRODUCTS_GENERATOR = "products_generator";

    @Id
    @SequenceGenerator(name = "PRODUCTS_GENERATOR", sequenceName = PRODUCTS_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PRODUCTS_GENERATOR)
    private int bookId;

    @Column
    private String bookName;

    @Column
    private String bookAuthor;

    public Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.bookAuthor = authorName;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
