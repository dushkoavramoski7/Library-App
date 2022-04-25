package com.example.libraryapp.Service.Impl;

import com.example.libraryapp.Model.Entites.Author;
import com.example.libraryapp.Model.Entites.Book;
import com.example.libraryapp.Model.Entites.Country;
import com.example.libraryapp.Repository.AuthorRepository;
import com.example.libraryapp.Repository.CountryRepository;
import com.example.libraryapp.Service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(NoSuchElementException::new);
        return Optional.of(this.authorRepository.save(new Author(name, surname, country)));
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
