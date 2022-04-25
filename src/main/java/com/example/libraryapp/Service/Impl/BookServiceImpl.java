package com.example.libraryapp.Service.Impl;

import com.example.libraryapp.Model.Entites.Author;
import com.example.libraryapp.Model.Entites.Book;
import com.example.libraryapp.Model.Enumeration.Book_Category;
import com.example.libraryapp.Repository.AuthorRepository;
import com.example.libraryapp.Repository.BookRepository;
import com.example.libraryapp.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return Optional.of(this.bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public Optional<Book> save(String name, Book_Category book_category, Integer availableCopies, Long AuthorId) {
        Author author = this.authorRepository.findById(AuthorId).orElseThrow(NoSuchElementException::new);

        Book book = new Book(name, book_category, availableCopies, author);
//
//        if(authors!=null) {
//            for (Author author : authors) {
//
//                this.authorRepository.findById(author.getId())
//                        .get().getBooks().add(book);
//
//                this.authorRepository.save(author);
//            }
//        }
//        this.bookRepository.save(book);

        return Optional.of(this.bookRepository.save(book));

    }

    @Override
    public Optional<Book> update(Long bookId, String name, Book_Category book_category, Integer availableCopies, Long authorId) {

        Book oldBook = this.bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new); //stara

        oldBook.setName(name);
        oldBook.setBook_category(book_category);
        oldBook.setAvailableCopies(availableCopies);
        oldBook.setAuthor(this.authorRepository.findById(authorId).get());

        Book newBook = this.bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new); //nova

//        List<Author> authorList = newBook.getAuthors();
//
//        for (Author author : authorList) {
//
//            this.authorRepository.findById(author.getId())
//                    .get().getBooks().remove(oldBook);
//
//            this.authorRepository.save(author);
//
//        }
//
//        for (Author author : authorList) {
//
//            this.authorRepository.findById(author.getId())
//                    .get().getBooks().add(newBook);
//
//            this.authorRepository.save(author);
//        }

      return Optional.of(this.bookRepository.save(newBook));
    }

    @Override
    public void deleteById(Long bookId) {

        Book oldBook = this.bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new);
//
//        List<Author> authors = oldBook.getAuthors();
//
//        for(Author author: authors)
//        {
//            this.authorRepository.findById(author.getId())
//                    .get().getBooks().remove(oldBook);
//
//            this.authorRepository.save(author);
//        }

        this.bookRepository.delete(oldBook);

    }

    @Override
    public void markAsTaken(Long bookId) {

        Book book = this.bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new);

        book.setAvailableCopies(book.getAvailableCopies()-1);

        this.bookRepository.save(book);
    }
}
