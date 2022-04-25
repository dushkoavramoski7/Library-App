package com.example.libraryapp.Model.Entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Author must have a name")
    private String name;

    @NotEmpty(message = "Author must have a surname")
    private String surname;

    @ManyToOne
    private Country country;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JsonIgnoreProperties(value="authors")
//    private List<Book> books = new ArrayList<>();

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

}
