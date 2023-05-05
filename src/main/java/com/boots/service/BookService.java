package com.boots.service;

import com.boots.entity.TablesReaderBook.Book;
import com.boots.entity.TablesUserRole.User;
import com.boots.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> allBooks() {return bookRepository.findAll();}
    public boolean saveBook(Book book) {
        Book bookFromDB = bookRepository.findByName(book.getName());
        if (bookFromDB != null) {
            return false;
        }
        bookRepository.save(book);
        return true;
    }
    public Book findById(Long bookId) {
        Optional<Book> bookFromDb = bookRepository.findById(bookId);
        return bookFromDb.orElse(new Book());
    }

    public boolean deleteBook(Long bookId) {
        if (bookRepository.findById(bookId).isPresent()) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}
