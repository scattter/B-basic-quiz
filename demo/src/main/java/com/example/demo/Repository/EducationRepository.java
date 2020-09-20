package com.example.demo.repository;

import com.example.demo.entity.EducationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface EducationRepository extends CrudRepository<EducationEntity, Long> {
    List<EducationEntity> findAll();

    @Query(value = "select * from education where education.user_id = ?1", nativeQuery = true)
    List<EducationEntity> findAllByUserId(Long id);
}
