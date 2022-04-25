package com.example.libraryapp.Repository;

import com.example.libraryapp.Model.Entites.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
