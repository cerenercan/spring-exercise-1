package com.example.demo.repositories;

import com.example.demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - Ceren Ercan at 30.09.2021
 */
@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
