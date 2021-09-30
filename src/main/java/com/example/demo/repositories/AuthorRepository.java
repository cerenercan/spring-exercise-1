package com.example.demo.repositories;

import com.example.demo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - Ceren Ercan at 30.09.2021
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
