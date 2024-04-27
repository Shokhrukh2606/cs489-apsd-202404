package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.InvoiceDto;
import org.example.rentacar.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
    private final BookService bookService;
    public InvoiceController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<InvoiceDto> findByBookId(@PathVariable Long bookId){
         return ResponseEntity.ok(bookService.findInvoiceByBookId(bookId));
    };
    @PutMapping("/{bookId}")
    public ResponseEntity<InvoiceDto> findByBookId(@PathVariable Long bookId, @Valid @RequestBody InvoiceDto invoiceDto){
        return ResponseEntity.ok(bookService.updateInvoiceByBookId(bookId, invoiceDto));
    };
}
