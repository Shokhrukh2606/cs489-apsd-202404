package org.example.rentacar.service;

import org.example.rentacar.dto.*;
import org.example.rentacar.model.Book;

import java.util.List;

public interface BookService {
    List<BookDetailDto> findAll();
    BookDetailDto findById(Long bookId);
    BookDetailDto registerBooking(BookDto bookDto);
    InvoiceDto findInvoiceByBookId(Long id);
    InvoiceDto updateInvoiceByBookId(Long id, InvoiceDto invoiceDto);
    CheckinResponseDto checkInCarItem(Long bookId, CheckinRequestDto checkinRequestDto);

    List<BookDetailDto> findAllMine(String name);
}
