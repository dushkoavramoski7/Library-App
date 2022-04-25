package com.example.libraryapp.Service;


import com.example.libraryapp.Model.Entites.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> save(String name, String continent);

    Optional<Country> findById(Long CountryId);

    List<Country> findAll();

}
