package com.example.MappingPratice.service;

import com.example.MappingPratice.model.Book;
import com.example.MappingPratice.repositroy.IBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    IBookRepo iBookRepo;

    public List<Book> Books() {
        return iBookRepo.findAll();
    }

    public String createBook(Book book) {
        iBookRepo.save(book);
        return "new book is created in DB";
    }

    public String removeBookById(Long id) {
        iBookRepo.deleteById(id);
        return "Book by id removed from Db";
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = iBookRepo.findById(id).orElse(null);
        if(existingBook != null){
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());

            return iBookRepo.save(existingBook);
        }

        return null;
    }
}
