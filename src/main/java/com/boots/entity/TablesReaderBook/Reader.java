package com.boots.entity.TablesReaderBook;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    public boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Book> books = new HashSet<>();

    public void add(Book departboss){
        books.add(departboss);}



    public Reader(String reader_name) {
        this.name = reader_name;
    }

    public Reader() {
    }

    public Reader(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
