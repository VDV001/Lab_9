package com.boots.entity.TablesReaderBook;

import javax.persistence.*;

@Entity
@Table(name = "t_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Book() {
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
