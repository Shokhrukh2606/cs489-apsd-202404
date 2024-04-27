package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.BookDetailDto;
import org.example.rentacar.dto.BookDto;
import org.example.rentacar.dto.CheckinRequestDto;
import org.example.rentacar.dto.CheckinResponseDto;
import org.example.rentacar.mapper.BookMapper;
import org.example.rentacar.model.Book;
import org.example.rentacar.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/bookings")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService, BookMapper bookMapper){
        this.bookService=bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDetailDto>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/mine")
    public ResponseEntity<List<BookDetailDto>> findAllMine(Principal principal){
        return ResponseEntity.ok(bookService.findAllMine(principal.getName()));
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDetailDto> findById(@PathVariable Long bookId){
        return ResponseEntity.ok(bookService.findById(bookId));
    }
    @PostMapping
    public ResponseEntity<BookDetailDto> registerBooking(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.registerBooking(bookDto), HttpStatus.CREATED);
    }
    @PostMapping("/{bookId}")
    public ResponseEntity<CheckinResponseDto> checkinCar(@PathVariable Long bookId, @Valid @RequestBody CheckinRequestDto checkinRequestDto){
        return ResponseEntity.ok(bookService.checkInCarItem(bookId,checkinRequestDto));
    }
}
