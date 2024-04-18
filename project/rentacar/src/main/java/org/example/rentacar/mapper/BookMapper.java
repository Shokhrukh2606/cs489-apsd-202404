package org.example.rentacar.mapper;

import org.example.rentacar.dto.BookDetailDto;
import org.example.rentacar.dto.BookDto;
import org.example.rentacar.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    BookDetailDto toDetailDto(Book book);
}
