package com.example.libraryapp.RestControllers;

import com.example.libraryapp.Model.Enumeration.Book_Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "https://library-order-book-application.herokuapp.com/")
public class CategoryRestController {

    @GetMapping
    public List<Book_Category> getAllCategories()
    {
        return List.of(Book_Category.values());
    }

}
