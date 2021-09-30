package com.example.demo.repositories;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - Ceren Ercan at 30.09.2021
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
