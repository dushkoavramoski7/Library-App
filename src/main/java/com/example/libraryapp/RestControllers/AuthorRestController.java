package com.example.libraryapp.RestControllers;

import com.example.libraryapp.Model.Entites.Author;
import com.example.libraryapp.Service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "https://library-order-book-application.herokuapp.com/")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return  this.authorService.findAll();
    }

}
