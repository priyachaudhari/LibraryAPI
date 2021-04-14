package com.libraryAPI.impl;

import com.libraryAPI.entity.Book;
import com.libraryAPI.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("BookServiceImpl")
public class BookServiceImpl implements BookService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get list of books available in library
     * @return List<Book>
     */
    @Transactional
    public List<Book> getBooks() {
        return entityManager.createQuery("from Book").getResultList();
    }

    /**
     * Returns true when book is added
     * @param book
     * @return Boolean
     */
    @Transactional
    public Boolean addBook(Book book) {
        entityManager.persist(book);
        return true;
    }

    /**
     * Returns the book requested using BookID
     * @param bookId
     * @return Book
     */
    @Transactional
    public Book getBook(Integer bookId) {
        return entityManager.find(Book.class, bookId);
    }

    /**
     * Updates the details of book if found or creates new entry
     * @param book
     */
    @Transactional
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    /**
     * Deletes the book if found else returns false
     * @param book
     * @return Boolean
     */
    @Transactional
    public Boolean deleteBook(Book book) {
        if (entityManager.contains(book)) {
            entityManager.remove(book);
            return true;
        }
        return false;
    }
}
