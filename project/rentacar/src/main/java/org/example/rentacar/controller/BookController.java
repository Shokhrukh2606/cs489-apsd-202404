package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.BookDetailDto;
import org.example.rentacar.dto.BookDto;
import org.example.rentacar.mapper.BookMapper;
import org.example.rentacar.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    public BookController(BookService bookService, BookMapper bookMapper){
        this.bookService=bookService;this.bookMapper=bookMapper;
    }
    @GetMapping
    public ResponseEntity<List<BookDetailDto>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
    @PostMapping
    public ResponseEntity<BookDetailDto> registerBooking(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.registerBooking(bookDto), HttpStatus.CREATED);
    }
}
