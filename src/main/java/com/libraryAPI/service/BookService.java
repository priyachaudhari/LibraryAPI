package com.libraryAPI.service;

import com.libraryAPI.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    List<Book> getBooks();

    Boolean addBook(Book book);

    Book getBook(Integer bookId);

    void updateBook(Book book);

    Boolean deleteBook(Book book);
}
