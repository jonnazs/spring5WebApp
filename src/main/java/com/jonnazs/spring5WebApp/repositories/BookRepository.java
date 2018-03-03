package com.jonnazs.spring5WebApp.repositories;

import com.jonnazs.spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
