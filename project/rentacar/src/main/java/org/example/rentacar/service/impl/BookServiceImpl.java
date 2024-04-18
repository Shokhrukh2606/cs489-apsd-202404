package org.example.rentacar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.example.rentacar.dto.BookDetailDto;
import org.example.rentacar.dto.BookDto;
import org.example.rentacar.mapper.BookMapper;
import org.example.rentacar.model.Book;
import org.example.rentacar.model.Car;
import org.example.rentacar.model.Customer;
import org.example.rentacar.repository.BookRepository;
import org.example.rentacar.repository.CarRepository;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CarRepository carRepository;

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    public BookServiceImpl(BookRepository bookRepository,BookMapper bookMapper,CarRepository carRepository, UserRepository userRepository,ObjectMapper objectMapper){
        this.bookRepository=bookRepository;
        this.bookMapper=bookMapper;
        this.carRepository=carRepository;
        this.userRepository=userRepository;
        this.objectMapper=objectMapper;
    }
    @Override
    public List<BookDetailDto> findAll() {
        return bookRepository.findAllByIsDeletedFalse().stream().map(bookMapper::toDetailDto).toList();
    }

    @Override
    public BookDetailDto registerBooking(BookDto bookDto) {
        System.out.println(bookDto.toString());
        Car car=carRepository.findById(bookDto.getCarId()).orElseThrow(()->new EntityNotFoundException(String.format("Car with id %d not found", bookDto.getCarId())));
        Customer customer=(Customer) userRepository.findById(bookDto.getCustomerId()).orElseThrow(()->new EntityNotFoundException("User does not exist!"));
        Book newBooking=new Book(
                null,
                bookDto.getPickUpDate(),
                bookDto.getDropOffDate(),
                null,
                car,
                customer,
                false,
                null
        );
        return bookMapper.toDetailDto(bookRepository.save(newBooking));
    }
}
