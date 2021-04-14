package com.libraryAPI.controller;

import com.libraryAPI.entity.Book;
import com.libraryAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Gives list of all books in the Library
     * @return List<Book>
     */
    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    /**
     * Adds new book to library
     * @param book
     * @return String
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        if(bookService.addBook(book)) {
            return "Book added successfully!";
        }
        return "Error. Try again";
    }

    /**
     * Gets the book details by bookID
     * @param bookId
     * @return Book
     */
    @RequestMapping(value = "/getBook/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook(@PathVariable int bookId) {
        return bookService.getBook(bookId);
    }

    /**
     * If found, update details of book or adds new entry
     * @param book
     * @return String
     */
    @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
    @ResponseBody
    public String updateBook(@RequestBody Book book) {
        return "Book updated Successfully!";
    }

    /**
     * Deletes the book if found
     * @param book
     * @return String
     */
    @RequestMapping(value = "/deleteBook", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBook(@RequestBody Book book) {
        if(bookService.deleteBook(book)) {
            return "Book deleted Sucessfully!";
        }
        return "Book not found";
    }
}