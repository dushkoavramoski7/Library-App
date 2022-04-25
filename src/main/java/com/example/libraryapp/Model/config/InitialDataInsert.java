package com.example.libraryapp.Model.config;

import com.example.libraryapp.Model.Enumeration.Book_Category;
import com.example.libraryapp.Service.AuthorService;
import com.example.libraryapp.Service.BookService;
import com.example.libraryapp.Service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitialDataInsert {

    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;

    public InitialDataInsert(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void initData()
    {

        this.countryService.save("Country0", "Continent0");
        this.countryService.save("Country1", "Continent1");
        this.countryService.save("Country2", "Continent2");



        this.authorService.save("Author0",  "AuthorSurname0", this.countryService.findAll().get(0).getId() ); // book0
        this.authorService.save("Author1",  "AuthorSurname1", this.countryService.findAll().get(1).getId() ); // book0
        this.authorService.save("Author2",  "AuthorSurname2", this.countryService.findAll().get(1).getId() ); // book1
        this.authorService.save("Author3",  "AuthorSurname3", this.countryService.findAll().get(2).getId() ); // book1 & book2
        this.authorService.save("Author4",  "AuthorSurname4", this.countryService.findAll().get(2).getId() ); // book3 & book2


        this.bookService.save("Book0", Book_Category.BIOGRAPHY, 3, this.authorService.findAll().get(0).getId());// author0 & author1
        this.bookService.save("Book1", Book_Category.CLASSICS, 7, this.authorService.findAll().get(1).getId()); // author2 & author3
        this.bookService.save("Book2", Book_Category.DRAMA, 1, this.authorService.findAll().get(2).getId());// author4 & author3
        this.bookService.save("Book3", Book_Category.FANTASY, 6, this.authorService.findAll().get(2).getId());// author4

//        this.bookService.update(this.bookService.findAll().get(0).getId(),"Book0", Book_Category.BIOGRAPHY, 3 ,List.of(this.authorService.findAll().get(0),this.authorService.findAll().get(1) ));
//        this.bookService.update(this.bookService.findAll().get(1).getId(),"Book1", Book_Category.CLASSICS, 7 ,List.of(this.authorService.findAll().get(2),this.authorService.findAll().get(3) ));
//        this.bookService.update(this.bookService.findAll().get(2).getId(),"Book2", Book_Category.DRAMA, 1 ,List.of(this.authorService.findAll().get(4), this.authorService.findAll().get(3)));
//        this.bookService.update(this.bookService.findAll().get(3).getId(),"Book3", Book_Category.FANTASY, 6 ,List.of(this.authorService.findAll().get(4)));

    }
}
