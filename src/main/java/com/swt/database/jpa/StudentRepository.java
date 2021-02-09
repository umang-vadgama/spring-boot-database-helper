package com.swt.database.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentEnroll,String> {


    public List<StudentEnroll> findAll();
}
