package org.example.rentacar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.example.rentacar.dto.*;
import org.example.rentacar.mapper.BookMapper;
import org.example.rentacar.model.*;
import org.example.rentacar.repository.*;
import org.example.rentacar.service.BookService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CarRepository carRepository;
    private final CarItemRepository carItemRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;
    public BookServiceImpl(BookRepository bookRepository,BookMapper bookMapper,CarRepository carRepository, UserRepository userRepository,ObjectMapper objectMapper,CarItemRepository carItemRepository,CustomerRepository customerRepository){
        this.bookRepository=bookRepository;
        this.bookMapper=bookMapper;
        this.carRepository=carRepository;
        this.userRepository=userRepository;
        this.objectMapper=objectMapper;
        this.carItemRepository=carItemRepository;
        this.customerRepository=customerRepository;
    }
    @Override
    public List<BookDetailDto> findAll() {
        return bookRepository.findAllByIsDeletedFalse().stream().map(bookMapper::toDetailDto).toList();
    }

    @Override
    public BookDetailDto findById(Long bookId) {
        return bookMapper.toDetailDto(bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException(String.format("Book with id %d not found!", bookId))));
    }

    @Override
    public BookDetailDto registerBooking(BookDto bookDto) {
        Car car=carRepository.findById(bookDto.getCarId()).orElseThrow(()->new EntityNotFoundException(String.format("Car with id %d not found", bookDto.getCarId())));
        Customer customer=(Customer) userRepository.findById(bookDto.getCustomerId()).orElseThrow(()->new EntityNotFoundException("User does not exist!"));
        long noOfDaysBetween = ChronoUnit.DAYS.between(bookDto.getPickUpDate(), bookDto.getDropOffDate());
        Book newBooking=new Book(
                null,
                bookDto.getPickUpDate(),
                bookDto.getDropOffDate(),
                null,
                car,
                customer,
                false,
                new Invoice(null, noOfDaysBetween*car.getPriceForDay(), false)
        );
        return bookMapper.toDetailDto(bookRepository.save(newBooking));
    }

    @Override
    public InvoiceDto findInvoiceByBookId(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.format("Book with id %d not found!", id)));
        return bookMapper.toInvoiceDto(book.getInvoice());
    }

    @Override
    public InvoiceDto updateInvoiceByBookId(Long id, InvoiceDto invoiceDto) {
        Book book=bookRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.format("Book with id %d not found!", id)));
        book.getInvoice().setPaid(invoiceDto.isPaid());
        book.getInvoice().setTotal(invoiceDto.getTotal());
        bookRepository.save(book);
        return bookMapper.toInvoiceDto(book.getInvoice());
    }

    @Override
    public CheckinResponseDto checkInCarItem(Long bookId, CheckinRequestDto checkinRequestDto) {
        Book book=bookRepository.findById(checkinRequestDto.getCarItemId()).orElseThrow(()->new EntityNotFoundException(String.format("Car with id %d not found", bookId)));
        CarItem carItem=carItemRepository.findById(checkinRequestDto.getCarItemId()).orElseThrow(()->new EntityNotFoundException(String.format("Car Item with id %d not found", checkinRequestDto.getCarItemId())));
        book.setCarItem(carItem);
        return bookMapper.toCheckinDto(book);
    }

    @Override
    public List<BookDetailDto> findAllMine(String name) {
        Customer customer=customerRepository.findByEmailAddress(name);
        return bookRepository.findAllByCustomerId(customer.getId()).stream().map(bookMapper::toDetailDto).toList();
    }
}
