package com.example.MappingPratice.controller;

import com.example.MappingPratice.model.Book;
import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("Books")
    public List<Book> Books(){
        return bookService.Books();
    }
    @PostMapping("Book")
    public String createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

//    @GetMapping("Books")
//    @PostMapping("Book")
//    @PutMapping("updateBook/{BookId}")
//    @DeleteMapping("removeBook/{BookId}")
    @PutMapping("updateBook/{BookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook = bookService.updateBook(id,book);
        if(updatedBook != null){
            return ResponseEntity.ok(updatedBook);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("removeBook/{BookId}")
    public String removeBookById(@PathVariable Long id){
        return bookService.removeBookById(id);
    }
}
