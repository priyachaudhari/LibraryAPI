package com.libraryAPI.entity;

import javax.persistence.*;

@Entity
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "BOOK_ID", length = 8, unique = true, nullable = false)
    private Integer bookId;

    @Column(name = "ISBN_NO", nullable = false, unique = true)
    private String isbn_no;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "PUBLISHER", nullable = false)
    private String publisher;

    @Column(name = "NUM_OF_COPIES")
    private int no_of_copies;

    public Book(String isbn_no, String author, String title, String publisher, int no_of_copies)
    {
        this.isbn_no = isbn_no;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.no_of_copies = no_of_copies;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn_no;
    }

    public void setIsbn(String isbn_no) {
        this.isbn_no = isbn_no;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNo_of_copies() {
        return no_of_copies;
    }

    public void setNo_of_copies(int no_of_copies) {
        this.no_of_copies = no_of_copies;
    }
}
