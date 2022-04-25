package com.example.libraryapp.Service;

import com.example.libraryapp.Model.Entites.Author;
import com.example.libraryapp.Model.Entites.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> save(String name, String surname, Long country);

    List<Author> findAll();

}