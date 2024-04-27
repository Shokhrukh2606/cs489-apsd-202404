package org.example.rentacar.repository;

import org.example.rentacar.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByIsDeletedFalse();
    List<Book> findAllByCustomerId(Long customerId);
}
