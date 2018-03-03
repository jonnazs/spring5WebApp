package com.jonnazs.spring5WebApp.repositories;

import com.jonnazs.spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
