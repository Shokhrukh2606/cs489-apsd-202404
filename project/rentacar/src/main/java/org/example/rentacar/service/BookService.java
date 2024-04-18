package org.example.rentacar.service;

import org.example.rentacar.dto.BookDetailDto;
import org.example.rentacar.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDetailDto> findAll();
    BookDetailDto registerBooking(BookDto bookDto);
}
