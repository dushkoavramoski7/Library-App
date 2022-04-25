package com.example.libraryapp.RestControllers;


import com.example.libraryapp.Model.Entites.Author;
import com.example.libraryapp.Model.Entites.Book;
import com.example.libraryapp.Model.Enumeration.Book_Category;
import com.example.libraryapp.Service.AuthorService;
import com.example.libraryapp.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/", "/api/books"})
@CrossOrigin(origins = "https://library-book-fe.herokuapp.com/")
public class BookRestController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }



    @GetMapping
    public List<Book> getAllBooks()
    {
        return this.bookService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id)
    {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam String name,
                                     @RequestParam String availableCopies,
                                     @RequestParam String category,
                                     @RequestParam String author ){

        return this.bookService.save(name, Book_Category.valueOf(category), Integer.valueOf(availableCopies),  Long.valueOf(author) )
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,@RequestParam String name,
                                     @RequestParam String availableCopies,
                                     @RequestParam String category,
                                     @RequestParam String author )
    {
        return this.bookService.update(id,name,Book_Category.valueOf(category), Integer.valueOf(availableCopies),  Long.valueOf(author))
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {

        if(this.bookService.findById(id).isEmpty())
        {
            return ResponseEntity.badRequest().build();
        }
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/markAsTaken/{id}")
    public Integer markAsTaken(@PathVariable Long id)
    {
        this.bookService.markAsTaken(id);
        return this.bookService.findById(id).get().getAvailableCopies();
    }



}
