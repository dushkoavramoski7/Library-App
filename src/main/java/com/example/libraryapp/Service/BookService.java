package com.example.libraryapp.Service;


import com.example.libraryapp.Model.Entites.Author;
import com.example.libraryapp.Model.Entites.Book;
import com.example.libraryapp.Model.Enumeration.Book_Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long bookId);

    Optional<Book> save(String name, Book_Category book_category, Integer availableCopies, Long AuthorId);

    Optional<Book> update(Long bookId,String name, Book_Category book_category, Integer availableCopies, Long authorId);

    void deleteById(Long bookId);

    void markAsTaken(Long bookId);











}
