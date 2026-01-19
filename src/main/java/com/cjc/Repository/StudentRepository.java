package com.cjc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByUsernameAndPassword(String username, String password);

}
