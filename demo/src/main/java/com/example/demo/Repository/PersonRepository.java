package com.example.demo.repository;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    List<PersonEntity> findAll();
    List<PersonEntity> findAllById(Long id);
}
