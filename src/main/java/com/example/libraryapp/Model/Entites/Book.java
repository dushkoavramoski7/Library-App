package com.example.libraryapp.Model.Entites;

import com.example.libraryapp.Model.Enumeration.Book_Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Book must have a name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Book_Category book_category;

    private Integer availableCopies;

    @ManyToOne()
    private Author author;

    public Book(String name, Book_Category book_category, Integer availableCopies, Author author) {
        this.name = name;
        this.book_category = book_category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
