package com.example.libraryapp.Service.Impl;

import com.example.libraryapp.Model.Entites.Country;
import com.example.libraryapp.Repository.CountryRepository;
import com.example.libraryapp.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return Optional.of(this.countryRepository.save(new Country(name, continent)));
    }

    @Override
    public Optional<Country> findById(Long CountryId) {
        return Optional.of(this.countryRepository.findById(CountryId).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }
}
