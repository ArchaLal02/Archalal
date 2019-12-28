package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
