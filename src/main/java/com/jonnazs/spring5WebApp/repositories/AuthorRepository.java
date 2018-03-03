package com.jonnazs.spring5WebApp.repositories;

import com.jonnazs.spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
