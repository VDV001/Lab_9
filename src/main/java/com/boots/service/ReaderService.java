package com.boots.service;

import com.boots.entity.TablesReaderBook.Reader;
import com.boots.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    public List<Reader> allReaders() {
        return readerRepository.findAll();
    }
    public boolean saveReader(Reader reader) {
        Reader readerFromDB = readerRepository.findByName(reader.getName());
        if (readerFromDB != null) {
            return false;
        }
        readerRepository.save(reader);
        return true;
    }
    public Reader findById(Long bookId) {
        Optional<Reader> bookFromDb = readerRepository.findById(bookId);
        return bookFromDb.orElse(new Reader());
    }

    public boolean deleteReader(Long bookId) {
        if (readerRepository.findById(bookId).isPresent()) {
            readerRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}
