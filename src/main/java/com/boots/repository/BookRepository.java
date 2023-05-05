package com.boots.repository;

import com.boots.entity.TablesReaderBook.Book;
import com.boots.entity.TablesUserRole.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String bookname);
}
