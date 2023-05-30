package com.pro.dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pro.dev.api.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
