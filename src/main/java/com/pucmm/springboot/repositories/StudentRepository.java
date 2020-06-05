package com.pucmm.springboot.repositories;

import com.pucmm.springboot.entity.Student;
import org.springframework.data.repository.CrudRepository;
//
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
