package com.boots.repository;

import com.boots.entity.TablesReaderBook.Book;
import com.boots.entity.TablesReaderBook.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findByName(String readername);
}
